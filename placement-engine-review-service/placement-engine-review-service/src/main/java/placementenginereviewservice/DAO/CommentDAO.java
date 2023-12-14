package placementenginereviewservice.DAO;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import placementenginereviewservice.entity.Comment;

@Repository
public interface CommentDAO extends JpaRepository<Comment,Long> {
}
