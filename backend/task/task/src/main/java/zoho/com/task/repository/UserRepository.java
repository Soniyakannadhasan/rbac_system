package zoho.com.task.repository;

import java.util.Optional;
import org.springframework.data.jpa.repository.JpaRepository;
import zoho.com.task.model.User;

public interface UserRepository extends JpaRepository<User,Long>{

    Optional<User> findByUsername(String username);
}
