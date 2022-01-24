package web.repo;

import org.springframework.data.jpa.repository.JpaRepository;
import web.user.User;

public interface UserRepository extends JpaRepository<User, Integer> {
}
