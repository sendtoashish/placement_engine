package placementenginejobposting.service;


import com.google.gson.Gson;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.kafka.core.KafkaTemplate;
import org.springframework.stereotype.Service;
import placementenginejobposting.DAO.JobApplicationDAO;
import placementenginejobposting.DAO.JobPostingDAO;
import placementenginejobposting.DAO.UserRegistrationDAO;
import placementenginejobposting.Utility.Review_status;
import placementenginejobposting.entity.*;

import java.util.List;

@Service
public class JobApplicationService {
    @Autowired
    JobPostingDAO jobPostingDAO;
    @Autowired
    UserRegistrationDAO userRegistrationDAO;
    @Autowired
    JobApplicationDAO jobApplicationDAO;

    @Autowired
    KafkaTemplate<String,String> kafkaTemplate;



    public void saveJobApplication(JobApplication jp){
        int jobPosting=jp.getJobPosting().getId();
        JobPosting jobObj = jobPostingDAO.findJobbyId(jobPosting);
        int user=jp.getUser().getId();
        UserRegistration usr = userRegistrationDAO.findUserbyId(user);
        jp.setUser(usr);
        jp.setJobPosting(jobObj);
        jp.setStatus(Review_status.INITIATE.name());
        jobApplicationDAO.save(jp);
        MailInfo m1 =  new MailInfo();
        MailInfo m2 =  new MailInfo();
        m1.setSendTo(usr.getEmail());
        m1.setSubject("Job Application");
        m1.setMessage("JobApplied" + jobObj.getPosition() + "Please get in touch with recruiter" + jobObj.getRecruiter().getEmail());
        Gson gson = new Gson();
        kafkaTemplate.send("mailInfo",gson.toJson(m1));

        m2.setSendTo(jobObj.getRecruiter().getEmail());
        m2.setSubject("Job Applied by User");
        m2.setMessage(usr.getEmail() + "is the user"+ jobObj.getPosition() + "applied for the position");
        kafkaTemplate.send("mailInfo",gson.toJson(m2));

    }


    public List<JobApplication> allAppliedJob(){
        List<JobApplication> j=jobApplicationDAO.findAll();
        return j;
    }
}
