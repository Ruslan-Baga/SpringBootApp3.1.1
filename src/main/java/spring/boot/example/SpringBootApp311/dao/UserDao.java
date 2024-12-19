package spring.boot.example.SpringBootApp311.dao;

import org.springframework.stereotype.Repository;
import spring.boot.example.SpringBootApp311.model.User;

import java.util.List;

@Repository
public interface UserDao {
    List<User> getAllUser();

    void saveUser(User user);

    void deleteUser(int id);

    void updateUser(User User, int id);

    User getUserById(int id);
}
