package placementenginejobposting.DAO;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;
import placementenginejobposting.entity.JobApplication;

@Repository
public interface JobApplicationDAO extends JpaRepository<JobApplication,Long> {
}
