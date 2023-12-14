package placementenginejobposting.Controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.kafka.core.KafkaTemplate;
import org.springframework.web.bind.annotation.*;
import placementenginejobposting.entity.JobApplication;
import placementenginejobposting.service.JobApplicationService;

import java.util.List;

@RestController
@RequestMapping(value="/Job/apply")
public class JonApplicationController {
    @Autowired
    JobApplicationService jobApplicationService;

    @Autowired
    KafkaTemplate<String,String> kafkaTemplate;

    @PostMapping(value = "/JobApply")
    public ResponseEntity<String> jobapply(@RequestBody JobApplication jp) {
        jobApplicationService.saveJobApplication(jp);

        return ResponseEntity.ok().body("job applied successfully you will receive the mail shortly");

    }

    @GetMapping(value = "/jobApplications")
    public ResponseEntity<List<JobApplication>> jobapplication() {
        List<JobApplication> j = jobApplicationService.allAppliedJob();
        return ResponseEntity.ok().body(j);
    }
}
