package kvo.spring.projects.d_proj.service;

import kvo.spring.projects.d_proj.model.User;
import kvo.spring.projects.d_proj.repository.UserRepository;
import lombok.AllArgsConstructor;
import lombok.NoArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@AllArgsConstructor
public class UserService {
    private final UserRepository userRepository;
    public List<User> findAllUser() {
        return userRepository.findAll();
    }
    public void deleteById(Long id) {
        userRepository.deleteById(id);
    }
    public List<User> findByFamiliyaUser(String familiyaUser) {
        return userRepository.findByFamiliyaUser(familiyaUser);
    }
    public User saveUser(User user) {
        return userRepository.save(user);
    }
    public User findById(Long id) {
        return userRepository.findById(id).orElse(null);
    }
}