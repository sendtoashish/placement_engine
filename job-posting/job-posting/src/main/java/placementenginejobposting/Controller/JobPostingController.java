package placementenginejobposting.Controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.RequestEntity;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import placementenginejobposting.Utility.Secured;
import placementenginejobposting.entity.JobPosting;
import placementenginejobposting.service.JobPostingService;

import java.util.List;

@RestController
@RequestMapping(value="/JobPosting/byRecruiter")
public class JobPostingController {
    @Autowired
    private JobPostingService jobPostingService;
    @Secured
    @PostMapping(value="/postJob")
    public ResponseEntity<String> postJob(@RequestBody JobPosting jp){
        jobPostingService.saveJobDetails(jp);
       return ResponseEntity.ok().body("Job Posted Successfully");
    }

    @GetMapping(value="/findalljob")
    public ResponseEntity<List<JobPosting>> findJobPosting(){
        List<JobPosting> jobPosting=jobPostingService.findAllJobs();
        return ResponseEntity.ok().body(jobPosting);
    }

    @PostMapping(value="/archieveJob")
    public ResponseEntity<?> archieveJob(@RequestParam int id){
        jobPostingService.jobArchieve(id);
        return ResponseEntity.ok().body("Job Archieved Successfully");
    }
    @GetMapping(value="/getActivejob")
    public ResponseEntity<String> getActiveJob(@RequestParam int id){
        String job = jobPostingService.showActiveJob(id);
        return ResponseEntity.ok().body(job);
    }
    @GetMapping(value="/getallactivejob")
    public ResponseEntity<List<JobPosting>> getAllActiveJob(){
        List<JobPosting> job = jobPostingService.showAllActiveJobsOnly();
        return ResponseEntity.ok().body(job);
    }
    @GetMapping(value="/getJobByRecruiter")
    public ResponseEntity<List<JobPosting>> getJobByRecruiter(@RequestParam String email){
        List<JobPosting> job = jobPostingService.jobPostbyRecruiter(email);
        return ResponseEntity.ok().body(job);
    }


}
