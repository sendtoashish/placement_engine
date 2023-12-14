package placementenginejobposting.entity;


import lombok.Data;

import javax.persistence.*;
import java.util.List;
import java.util.Timer;

@Entity(name="jobApplication_details")
@Data
public class JobApplication {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;

    private String  review_by;
    private String status;

    @OneToOne
    private JobPosting jobPosting;

    @OneToOne
    private UserRegistration user;
}
