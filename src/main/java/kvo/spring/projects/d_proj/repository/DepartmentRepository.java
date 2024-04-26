package kvo.spring.projects.d_proj.repository;

import kvo.spring.projects.d_proj.model.Department;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;
import java.util.Optional;

public interface DepartmentRepository extends JpaRepository<Department, Long>
{

    List<Department> findByDepartment(String department);

}
