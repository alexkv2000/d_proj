package kvo.spring.projects.d_proj.model;

import jakarta.persistence.*;
import lombok.Data;

@Data
@Entity
@Table(name = "lib_categories_of_employes")
public class Department {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    String department;
}
