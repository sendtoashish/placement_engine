package placementenginereviewservice.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import placementenginereviewservice.DAO.JobPostingDAO;
import placementenginereviewservice.DAO.ReviewDetailsDAO;
import placementenginereviewservice.DAO.UserDAO;
import placementenginereviewservice.Utils.AuthenticationInterceptor;
import placementenginereviewservice.entity.JobPosting;
import placementenginereviewservice.entity.ReviewDetails;
import placementenginereviewservice.entity.User;

@Service
public class ReviewService {

    @Autowired
    JobPostingDAO jobPostingDAO;

    @Autowired
    UserDAO userDAO;

    @Autowired
    AuthenticationInterceptor authenticationInterceptor;
    @Autowired
    ReviewDetailsDAO reviewDetailsDAO;


    public void review(int id){
        try{
        JobPosting jobposting = jobPostingDAO.findById(id);
        if(jobposting != null) {
            String u = authenticationInterceptor.getUserByUsername();
            User user = userDAO.getUserByUsername(u);
            ReviewDetails review = ReviewDetails.builder()
                    .jobPosting(jobposting)
                    .user(user).build();
            reviewDetailsDAO.save(review);
        }

            }catch(Exception e){
            e.printStackTrace();




        }

    }

}


