package placementenginejobposting.service;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import placementenginejobposting.DAO.JobPostingDAO;
import placementenginejobposting.DAO.RecruiterDAO;
import placementenginejobposting.entity.JobPosting;
import placementenginejobposting.entity.Recruiter;

import java.util.ArrayList;
import java.util.List;

@Service
public class JobPostingService {

    @Autowired
    private RecruiterDAO recruiterDAO;
    @Autowired
    private JobPostingDAO jobPostingDAO;
    public void saveJobDetails(JobPosting jp){
        Recruiter recruiter = recruiterDAO.findRecruiterByEmail(jp.getRecruiterEmail());
        jp.setRecruiter(recruiter);
        jp.setStatus(true);
        jobPostingDAO.save(jp);
    }

    public List<JobPosting> findAllJobs(){
       return jobPostingDAO.findAll();
    }

    public void jobArchieve(int id){
        try {
            JobPosting jobposting = jobPostingDAO.findJobbyId(id);
            jobposting.setStatus(false);
            jobPostingDAO.save(jobposting);

        }catch(Exception e){
           e.printStackTrace();
        }
    }

    public String showActiveJob(int id){
        JobPosting jobposting = jobPostingDAO.findJobbyId(id);
        boolean status= jobposting.isStatus();
        if(status==true){
            return ("Job is not Archieved"+ jobposting);
        }else{
            return "Job is not available now";
        }
    }
    public List<JobPosting> showAllActiveJobsOnly(){
        List<JobPosting> job = jobPostingDAO.findAll();
        List<JobPosting> activejob = new ArrayList<>();
        for(JobPosting j : job){
            if(j.isStatus() == true){
                activejob.add(j);
            }
        }
        return activejob;
    }
    public List<JobPosting> jobPostbyRecruiter(String email){
       Recruiter recruiter= recruiterDAO.findRecruiterByEmail(email);
       int recruiterId = recruiter.getId();
       List<JobPosting> allJob = jobPostingDAO.findAll();
       List<JobPosting> rjob = new ArrayList<>();
      // allJob.stream().filter((JobPosting j)->j.getRecruiter().getId() ==)
        for(JobPosting j:allJob){
            if(j.getRecruiter().getId() == recruiterId){
                rjob.add(j);
        }
            }
           return rjob;

        }

        public List<JobPosting> jobByKeyword(String position){
            List<JobPosting> jobs = jobPostingDAO.ByKeyword(position);
            return jobs;
        }

    }

