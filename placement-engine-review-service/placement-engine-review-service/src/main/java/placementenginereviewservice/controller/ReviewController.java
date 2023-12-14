package placementenginereviewservice.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import placementenginereviewservice.service.ReviewService;

@RestController
@RequestMapping(value="/review")
public class ReviewController {
    @Autowired
    ReviewService reviewService;

    public ResponseEntity<String> postReview(@RequestParam int id){
          reviewService.review(id);
          return ResponseEntity.ok().body("review saved successfully");

    }
}
