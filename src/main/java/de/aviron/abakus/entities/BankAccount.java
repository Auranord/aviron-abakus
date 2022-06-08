package de.aviron.abakus.entities;

import java.util.Collection;

import javax.persistence.*;

import com.fasterxml.jackson.annotation.JsonIgnore;

import lombok.Data;
import lombok.EqualsAndHashCode;

@Entity
@Data
@EqualsAndHashCode(callSuper=true)
public class BankAccount extends _Possession {
    
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Integer id;

    // Währung
    @ManyToOne(cascade = CascadeType.ALL) @JsonIgnore
    @JoinColumn(name="currency_id")
    private Bank currency;

    // Währung
    @ManyToOne(cascade = CascadeType.ALL) @JsonIgnore
    @JoinColumn(name="vault_id")
    private BankVault vault;

    // Kontostand
    private Integer balance;

    // maximaler Überzug
    private Integer maxOverdraft;

    // maximale Überweisung
    private Integer maxTransaction;

    // maximaler Kontostand
    private Integer maxBalance;

    // Eingefroren
    private Boolean isFrozen;

    // Konto Gebühren
    private Integer absoluteIntervalFees;

    // Konto Gebühren Prozent
    private Double relativeIntervalFees;

    // Überweisungs Gebühren
    private Integer absoluteTransactionFees;

    // Überweisungs Gebühren Prozent
    private Double relativeTransactionFees;

    // Empfang Gebühren
    private Integer absoluteReceptionFees;

    // Empfang Gebühren Prozent
    private Double relativeReceptionFees;

    // Ausgehende Überweisungen
    @OneToMany(cascade = CascadeType.ALL, mappedBy="senderAccount") @JsonIgnore
    private Collection<BankTransaction> outgoingTransactions;

    // Eingehende Überweisungen
    @OneToMany(cascade = CascadeType.ALL, mappedBy="receiverAccount") @JsonIgnore
    private Collection<BankTransaction> incomingTransactions;

    // 
    @OneToMany(cascade = CascadeType.ALL, mappedBy="account") @JsonIgnore
    private Collection<BankDeposit> deposits;

}