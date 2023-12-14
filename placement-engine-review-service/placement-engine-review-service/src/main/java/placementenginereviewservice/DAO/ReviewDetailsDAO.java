package placementenginereviewservice.DAO;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import placementenginereviewservice.entity.ReviewDetails;

@Repository
public interface ReviewDetailsDAO extends JpaRepository<ReviewDetails,Long> {

}
