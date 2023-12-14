package placementenginejobposting.Configuration;




import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.config.annotation.InterceptorRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;
import placementenginejobposting.Utility.AuthenticationInterceptor;

@Configuration
public class InterceptorConfig implements WebMvcConfigurer{

	@Autowired
	AuthenticationInterceptor authenticationFilter;

	@Override
	public void addInterceptors(InterceptorRegistry registry)
	{
		registry.addInterceptor(authenticationFilter);
	}
}
