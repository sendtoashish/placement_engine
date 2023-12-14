package placementenginejobposting.Utility;


import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.*;
import org.springframework.stereotype.Component;
import org.springframework.web.client.RestTemplate;
import org.springframework.web.context.request.RequestContextHolder;
import org.springframework.web.context.request.ServletRequestAttributes;
import org.springframework.web.method.HandlerMethod;
import org.springframework.web.servlet.HandlerInterceptor;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.lang.reflect.Method;
import java.util.HashMap;
import java.util.Map;

@Component
public class AuthenticationInterceptor implements HandlerInterceptor {
	public static final String AUTHENTICATION_SCHEME_JWT = "jwt";

	@Autowired
	ObjectMapper objectMapper;

	

	
	@Override
	public boolean preHandle(HttpServletRequest request, HttpServletResponse response, Object handler)
			throws Exception {
		if (handler instanceof HandlerMethod) {
			final HandlerMethod handlerMethod = (HandlerMethod) handler;
			final Method method = handlerMethod.getMethod();

			if (method.isAnnotationPresent(Secured.class)) {
				try {
					String accessToken = getBearerTokenHeader();
					if (accessToken != null) {
						Map<String, Object> param = new HashMap<>();
						param.put("access_token", accessToken);
						RestTemplate restTemplate = new RestTemplate();
						HttpHeaders headers = new HttpHeaders();
						headers.setContentType(MediaType.APPLICATION_JSON);
						HttpEntity<Map<String, Object>> requestEntity = new HttpEntity<>(param, headers);
						ResponseEntity<String> result = null;
						try {
							result = restTemplate.postForEntity("http://localhost:8080/user/authentication/validateToken", requestEntity, String.class);
							if (result.getStatusCode() == HttpStatus.OK) {
								return true;
							} else {
								return abortWithUnauthorized(response);
							}
						} catch (Exception e) {
							return abortWithUnauthorized(response);
						}
					} else {
						return abortWithSessionFailure(response);
					}

				} catch (Exception e) {
					return abortWithSessionFailure(response);
				}






			}
		}
		
		return true;
	}

	/**
	 * Aborts the filter chain with a 401 status code response and the authenticate
	 * header is sent along with the response.
	 * 
	 * @throws IOException
	 * @throws JsonProcessingException
	 */
	private boolean abortWithUnauthorized(HttpServletResponse response) throws Exception {
		response.setStatus(HttpStatus.UNAUTHORIZED.value());
		response.getWriter().write(objectMapper.writeValueAsString("Unauthorized Access"));
		return false;
	}

	/**
	 * Aborts the filter chain with a 504 status code response and the authenticate
	 * header is sent along with the response.
	 */
	private boolean abortWithSessionFailure(HttpServletResponse response) throws Exception {
		response.setStatus(HttpStatus.GATEWAY_TIMEOUT.value());
		response.getWriter().write(objectMapper.writeValueAsString("Gateway Timeout"));
		return false;
	}
	private String getBearerTokenHeader() {
		return ((ServletRequestAttributes) RequestContextHolder.getRequestAttributes()).getRequest()
				.getHeader("Authorization");
	}
}
