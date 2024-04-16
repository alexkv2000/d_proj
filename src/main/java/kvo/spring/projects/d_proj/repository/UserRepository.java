package kvo.spring.projects.d_proj.repository;

import kvo.spring.projects.d_proj.model.User;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface UserRepository extends JpaRepository<User, Long>{
    List<User> findByFamiliyaUser(String familiyaUser);

    void deleteById(Long id);

}
