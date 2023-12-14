package placementenginejobposting.entity;

import lombok.Data;
import lombok.ToString;

import javax.persistence.*;

@Entity(name="User_details")
@Data
@ToString
public class UserDetails {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;
    private String qualification;
    private int yearOfExperience;
    private String email;
    @OneToOne(cascade = CascadeType.ALL)
    private CV cv;
    @OneToOne
    private UserRegistration userRegistration;

}
