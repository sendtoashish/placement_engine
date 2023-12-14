package placementengineauthenticationservice.entity;


import lombok.Data;
import lombok.ToString;
import org.springframework.transaction.annotation.Transactional;

import javax.persistence.*;


@Entity(name="UserRegistration_details")
@Transactional
@Data
@ToString
public class User {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;
    private String uuid;
    private String username;
    private String password;
    private String name;
    private String email;
    @Column(columnDefinition="tinyint(1) default 0")
    private boolean user_status;




}
