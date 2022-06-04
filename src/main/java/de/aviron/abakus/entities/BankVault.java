package de.aviron.abakus.entities;

import java.util.Collection;

import javax.persistence.*;

import com.fasterxml.jackson.annotation.JsonIgnore;

import lombok.Data;

@Entity
@Data
public class BankVault {
    
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Integer id;

    // Tresor
    private Boolean isWallet;

    // Bank
    @ManyToOne(cascade = CascadeType.ALL) @JsonIgnore
    @JoinColumn(name="bank_id")
    private Bank bank;

    // Währung
    @ManyToOne(cascade = CascadeType.ALL) @JsonIgnore
    @JoinColumn(name="currency_id")
    private Bank currency;

    // Kontostand
    private Integer balance;

    // Ausgehende Überweisungen
    @OneToMany(cascade = CascadeType.ALL, mappedBy="senderVault") @JsonIgnore
    private Collection<BankTransaction> outgoingTransactions;

    // Eingehende Überweisungen
    @OneToMany(cascade = CascadeType.ALL, mappedBy="receiverVault") @JsonIgnore
    private Collection<BankTransaction> incomingTransactions;

}
