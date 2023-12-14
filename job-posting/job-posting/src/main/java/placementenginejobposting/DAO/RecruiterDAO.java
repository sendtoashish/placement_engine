package placementenginejobposting.DAO;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;
import placementenginejobposting.entity.Recruiter;
@Repository
public interface RecruiterDAO extends JpaRepository<Recruiter,Long> {


    @Query("SELECT r from recruiterregistration_details r where email = :email")
    public Recruiter findRecruiterByEmail(String email);
}
