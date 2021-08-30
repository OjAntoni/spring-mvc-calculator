package org.example.entity;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.*;
import java.util.Date;

@Data
@NoArgsConstructor
@Entity
public class Operation {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;
    private double num1;
    private double num2;
    private String operationSign;
    private double result;
    @ManyToOne(cascade = CascadeType.PERSIST)
    private User user;
    private Date date;

    public Operation(long id, double num1, double num2, String operationSign, double result, User user) {
        this.id = id;
        this.num1 = num1;
        this.num2 = num2;
        this.operationSign = operationSign;
        this.result = result;
        this.user = user;
    }
}
