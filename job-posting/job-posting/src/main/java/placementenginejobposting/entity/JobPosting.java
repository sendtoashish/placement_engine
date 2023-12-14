package placementenginejobposting.entity;

import lombok.Data;

import javax.persistence.*;

@Entity(name="jobposting_details")
@Data
public class JobPosting {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;
    private String position;
    private int numberOfVacancy;
    private int noOfExperience;
    private long salary;
    private String recruiterEmail;
    private String noticePeriod;
    private boolean status;
    @Column(columnDefinition = "text")
    private String jobDescription;
    @OneToOne
    private Recruiter recruiter;

}
