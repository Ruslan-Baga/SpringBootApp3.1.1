package spring.boot.example.SpringBootApp311.dao;

import jakarta.persistence.EntityManager;
import jakarta.persistence.PersistenceContext;
import org.springframework.stereotype.Repository;
import spring.boot.example.SpringBootApp311.model.User;

import java.util.List;

@Repository
public class UserDAOimp implements UserDao {

    @PersistenceContext
    private EntityManager entityManager;


    @Override
    public List<User> getAllUser() {
        return entityManager.createQuery("FROM User", User.class).getResultList();
    }

    @Override
    public void saveUser(User user) {
        entityManager.persist(user);
    }

    @Override
    public void deleteUser(int id) {
        entityManager.remove(entityManager.find(User.class, id));
    }

    @Override
    public void updateUser(User userUpg, int id) {
        User user = entityManager.find(User.class, id);

        user.setName(userUpg.getName());
        user.setAge(userUpg.getAge());
        user.setEmail(userUpg.getEmail());
    }

    @Override
    public User getUserById(int id) {
        return entityManager.find(User.class, id);
    }
}
