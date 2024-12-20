package spring.boot.example.SpringBootApp311.dao;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import spring.boot.example.SpringBootApp311.model.User;


@Repository
public interface UserRepository extends JpaRepository<User, Integer> {
}
