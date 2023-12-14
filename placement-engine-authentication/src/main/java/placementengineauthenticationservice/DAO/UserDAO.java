package placementengineauthenticationservice.DAO;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;
import placementengineauthenticationservice.entity.User;

@Repository
public interface UserDAO extends JpaRepository<User,Long> {

    @Query("SELECT u FROM UserRegistration_details u WHERE username = :username")
    public User findUserByUsername(String username);
}
