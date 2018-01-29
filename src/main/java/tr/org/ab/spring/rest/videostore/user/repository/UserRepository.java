package tr.org.ab.spring.rest.videostore.user.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import tr.org.ab.spring.rest.videostore.user.User;

@Repository
public interface UserRepository extends JpaRepository<User,String> {
    User findUserByUsername(String userName);
}
