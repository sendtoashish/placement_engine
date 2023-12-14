package placementenginereviewservice.DAO;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;
import placementenginereviewservice.entity.JobPosting;

@Repository
public interface JobPostingDAO extends JpaRepository<JobPosting,Long> {

    @Query("SELECT j FROM jobposting_details j WHERE id = :id")
    public JobPosting findById(int id);
}
