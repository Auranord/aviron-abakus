package de.aviron.abakus.entities;

import java.time.LocalDateTime;

import javax.persistence.*;

import com.fasterxml.jackson.annotation.JsonIdentityInfo;
import com.fasterxml.jackson.annotation.ObjectIdGenerators;

import de.aviron.abakus.enums.BankTransactionError;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@Data
@NoArgsConstructor
@JsonIdentityInfo(generator = ObjectIdGenerators.PropertyGenerator.class,property = "id")
public class BankDeposit {
    
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Integer id;

    // 
    @ManyToOne(cascade = CascadeType.ALL)
    @JoinColumn(name="wallet_id")
    private BankWallet wallet;

    // 
    @ManyToOne(cascade = CascadeType.ALL)
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
