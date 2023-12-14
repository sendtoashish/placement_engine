package placementenginereviewservice.DAO;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;
import placementenginereviewservice.entity.User;


@Repository
public interface UserDAO extends JpaRepository<User,Long> {

    @Query("SELECT u FROM UserRegistration_details U WHERE username = :username")
    public User getUserByUsername(String username);
}
