package de.aviron.abakus.entities;

import java.time.LocalDateTime;

import javax.persistence.*;

import com.fasterxml.jackson.annotation.JsonIgnore;

import de.aviron.abakus.enums.BankTransactionError;
import lombok.Data;

@Entity
@Data
public class BankDeposit {
    
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Integer id;

    // 
    @ManyToOne(cascade = CascadeType.ALL) @JsonIgnore
    @JoinColumn(name="wallet_id")
    private BankWallet wallet;

    // 
    @ManyToOne(cascade = CascadeType.ALL) @JsonIgnore
    @JoinColumn(name="account_id")
    private BankAccount account;

    // 
    private Integer amount;

    // Überweisungs Fehler
    @Enumerated
    private BankTransactionError error;

    // Überweisungs Zeitpunkt
    private LocalDateTime dateTime;

    // Gebühren
    private Integer fees;
}
