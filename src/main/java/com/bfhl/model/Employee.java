package com.bfhl.model;
import jakarta.persistence.*;
import lombok.Data;
import java.time.LocalDate;
@Entity
@Data
public class Employee {
    @Id
    private int empId;
    private String firstName;
    private String lastName;
    private LocalDate dob;
    private String gender;
    @ManyToOne
    @JoinColumn(name = "department")
    private Department department;
}
