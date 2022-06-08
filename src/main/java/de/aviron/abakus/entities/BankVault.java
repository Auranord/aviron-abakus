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

    // Konten in Tresor
    @OneToMany(cascade = CascadeType.ALL, mappedBy="vault") @JsonIgnore
    private Collection<BankAccount> accounts;

    // Ausgehende Überweisungen
    @OneToMany(cascade = CascadeType.ALL, mappedBy="senderVault") @JsonIgnore
    private Collection<BankTransaction> outgoingTransactions;

    // Eingehende Überweisungen
    @OneToMany(cascade = CascadeType.ALL, mappedBy="receiverVault") @JsonIgnore
    private Collection<BankTransaction> incomingTransactions;

}
