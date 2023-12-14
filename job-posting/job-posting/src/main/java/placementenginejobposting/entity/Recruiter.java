package placementenginejobposting.entity;


import lombok.*;
import org.springframework.transaction.annotation.Transactional;

import javax.persistence.*;


@Entity(name="recruiterregistration_details")
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Transactional
public class Recruiter {



    @Id
    @GeneratedValue
    private int id;
    private String name;
    private long contact_no;
    private String email;
    @OneToOne(cascade = CascadeType.ALL)
    private Company company;

}
