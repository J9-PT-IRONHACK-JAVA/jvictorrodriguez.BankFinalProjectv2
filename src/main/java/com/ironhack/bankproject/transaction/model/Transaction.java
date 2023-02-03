package com.ironhack.bankproject.transaction.model;

import com.ironhack.bankproject.Money;
import jakarta.persistence.*;
import jakarta.validation.constraints.NotEmpty;
import lombok.Data;
import org.hibernate.annotations.CreationTimestamp;

import java.time.Instant;

@Data
@Entity
public abstract class Transaction {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private Long accountFrom;

    private Long accountTo;

    private Money amount;
    @CreationTimestamp
    private Instant dateTime;

    private String senderId;//Sender's DNI
}
