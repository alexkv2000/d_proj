package kvo.spring.projects.d_proj.repository;

import kvo.spring.projects.d_proj.model.Department;
import kvo.spring.projects.d_proj.model.User;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface DepartmentRepository extends JpaRepository<Department, String> {

    List<Department> findByDepartment(String department);
}
