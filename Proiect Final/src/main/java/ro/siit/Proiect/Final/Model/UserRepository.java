package ro.siit.Proiect.Final.Model;

import org.springframework.data.annotation.Id;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;

import java.util.List;

public interface UserRepository extends CrudRepository <User, Id> {

    @Query(value = "SELECT * FROM users  WHERE username = :users ", nativeQuery = true)
    public List<User> searchUser(@Param("users") String user);

    User findUserByUsername(String username);

}
