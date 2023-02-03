package com.ironhack.bankproject.transaction;

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
    @NotEmpty
    private Long accountFrom;
    @NotEmpty
    private Long accountTo;
    @Embedded
    private Money amount;
    @CreationTimestamp
    private Instant dateTime;
    @NotEmpty
    private String senderId;//Sender's DNI
}
