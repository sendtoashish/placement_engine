package placementenginereviewservice.entity;

import lombok.Builder;
import lombok.Data;

import javax.persistence.*;
import java.util.List;

@Entity(name="review_details")
@Data
@Builder
public class ReviewDetails {


    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private JobPosting jobPosting;
    private User user;
    @OneToOne(cascade = CascadeType.ALL)
    private Comment comment;


}
