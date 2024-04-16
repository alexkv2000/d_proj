package kvo.spring.projects.d_proj.model;

import jakarta.persistence.*;
import lombok.Data;

import java.time.LocalDate;
import java.time.Period;

@Data
@Entity
@Table(name = "t_users")
public class User {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String FirstNameUser;
    private String LastNameUser;
    @Column(name = "familiya")
    @OrderBy(value = "familiya")
    private String familiyaUser;
    @Transient
    private String FIO;
    private LocalDate BirthdayUser;
    @Transient
    private String OldUser;
    @ManyToOne
    private Department department;


    public int getOldUser() {
        //LocalDate data = LocalDate.parse(this.BirthdayUser.toString());
        return Period.between(this.BirthdayUser, LocalDate.now()).getYears();
    }
    public String getFIO() {
        return this.familiyaUser + " " + this.FirstNameUser.substring(0,1) + "." + this.LastNameUser.substring(0, 1) + ".//" + department + "/";
    }
}
