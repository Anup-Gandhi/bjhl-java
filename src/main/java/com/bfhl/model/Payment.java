package com.bfhl.model;
import jakarta.persistence.*;
import lombok.Data;
import java.time.LocalDateTime;
@Entity
@Data
public class Payment {
    @Id
    private int paymentId;
    @ManyToOne
    @JoinColumn(name = "emp_id")
    private Employee employee;
    private double amount;
    private LocalDateTime paymentTime;
}
