package spring.boot.example.SpringBootApp311.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import spring.boot.example.SpringBootApp311.dao.UserRepository;
import spring.boot.example.SpringBootApp311.model.User;

import java.util.List;

@Service
public class UserServiceImpl implements UserService {
    private final UserRepository userRepository;

    @Autowired
    public UserServiceImpl(UserRepository userRepository) {
        this.userRepository = userRepository;
    }

    @Override
    @Transactional(readOnly = true)
    public List<User> findAll() {
        return userRepository.findAll();
    }

    @Override
    @Transactional
    public void save(User user) {
        userRepository.save(user);
    }

    @Override
    @Transactional
    public void deleteUser(int id) {
        if (!userRepository.existsById(id)) {
            throw new RuntimeException("User not found");
        }
        userRepository.deleteById(id);
    }

    @Override
    @Transactional(readOnly = true)
    public User getUser(int id) {
        return userRepository.findById(id).orElseThrow(()-> new RuntimeException("User not found"));
    }

    @Override
    @Transactional
    public void updateUser(User user, int id) {
        User updateUser = userRepository.findById(id).orElseThrow(()-> new RuntimeException("User not found"));
        updateUser.setAge(user.getAge());
        updateUser.setName(user.getName());
        updateUser.setEmail(user.getEmail());
        userRepository.save(updateUser);
    }
}

