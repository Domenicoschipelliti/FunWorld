package domenico.CapStoneProject.repositories;

import domenico.CapStoneProject.enteties.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;
import java.util.UUID;
@Repository
public interface UserDao extends JpaRepository<User,UUID > {
    Optional<User> findByEmail(String email);
    Optional<User> findByUsername(String username);

}
