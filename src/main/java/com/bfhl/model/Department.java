package com.bfhl.model;
import jakarta.persistence.*;
import lombok.Data;
@Entity
@Data
public class Department {
    @Id
    private int departmentId;
    private String departmentName;
}
