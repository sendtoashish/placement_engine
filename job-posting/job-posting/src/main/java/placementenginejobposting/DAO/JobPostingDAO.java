package placementenginejobposting.DAO;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;
import placementenginejobposting.entity.JobPosting;

import java.util.List;

@Repository
public interface JobPostingDAO extends JpaRepository<JobPosting,Long> {


    @Query("SELECT j from jobposting_details j WHERE id = :id")
    public JobPosting findJobbyId(int id);

    @Query("SELECT j from jobposting_details j WHERE position = :position")
    public List<JobPosting> ByKeyword(String position);
}
