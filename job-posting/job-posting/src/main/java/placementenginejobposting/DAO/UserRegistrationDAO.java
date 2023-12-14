package placementenginejobposting.DAO;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;
import placementenginejobposting.entity.JobPosting;
import placementenginejobposting.entity.UserRegistration;

@Repository
public interface UserRegistrationDAO extends JpaRepository<UserRegistration,Long> {

    @Query("SELECT u from UserRegistration_details u WHERE id = :id")
    public UserRegistration findUserbyId(int id);
}
