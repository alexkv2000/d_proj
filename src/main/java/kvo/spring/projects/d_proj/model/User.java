package kvo.spring.projects.d_proj.model;

import jakarta.persistence.*;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.NonNull;
import lombok.Value;

import java.time.LocalDate;
import java.time.Period;
import java.util.Date;

import static org.thymeleaf.util.StringUtils.substring;

@Data
@NoArgsConstructor
@Entity
@Table(name = "t_users")
public class User {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    @NonNull
    private String firstNameUser;
    @NonNull
    private String lastNameUser;
    @Column(name = "familiya")
    @OrderBy(value = "familiya")
    @NonNull
    private String familiyaUser;
    @Transient
    private String fio;
    @NonNull
    private LocalDate birthdayUser;
    @Transient
    private String oldUser;
    @ManyToOne
    @JoinColumn(name="name_categories_of_employes_id")
    @NonNull
    private Department department;


    public int getOldUser() {
        //LocalDate data = LocalDate.parse(this.BirthdayUser.toString());
        LocalDate bd = this.birthdayUser != null ? this.birthdayUser : LocalDate.now();
        return Period.between(bd, LocalDate.now()).getYears();
    }
    public String getFIO() {
//        return this.familiyaUser + " " + this.FirstNameUser.substring(0,1) + "." + this.LastNameUser.substring(0, 1) + ".//" + department + "/";
        return (this.familiyaUser != null ? this.familiyaUser.substring(0, Math.min(this.familiyaUser.length(), 50)) : "") +
                (this.firstNameUser != null ? this.firstNameUser.substring(0, 1): ' ') + "." +
                (this.lastNameUser != null ? this.lastNameUser.substring(0, 1): ' ') + ".";
    }
}
