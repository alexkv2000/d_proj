package kvo.spring.projects.d_proj.service;

import kvo.spring.projects.d_proj.model.Department;
import kvo.spring.projects.d_proj.repository.DepartmentRepository;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@AllArgsConstructor
public class DepartmentService {
    private final DepartmentRepository departmentRepository;
    public List<Department> findAll() {
        return departmentRepository.findAll();
    }
    public List<Department> findByDepartment(String department) {
        return departmentRepository.findByDepartment(department);
    }
    public Department saveDepartment(Department department) {
        return departmentRepository.save(department);
    }
    public Department findById(Long id) {
        return departmentRepository.findById(id).orElse(null);
    }
    public void deleteById(Long id) {
        departmentRepository.deleteById(id);
    }

    public String getDepartmentByID(Long id) {
        return findById(id).getDepartment();
    }
}
