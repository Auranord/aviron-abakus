package de.aviron.abakus.entities;

import java.util.Collection;

import javax.persistence.*;

import com.fasterxml.jackson.annotation.JsonIdentityInfo;
import com.fasterxml.jackson.annotation.ObjectIdGenerators;

import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@Data
@NoArgsConstructor
@JsonIdentityInfo(generator = ObjectIdGenerators.PropertyGenerator.class,property = "id")
public class BankVault {
    
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Integer id;

    // Bank
    @ManyToOne(cascade = CascadeType.ALL)
    @JoinColumn(name="bank_id")
    private Bank bank;

    // Währung
    @ManyToOne(cascade = CascadeType.ALL)
    @JoinColumn(name="currency_id")
    private Bank currency;

    // Kontostand
    private Integer balance;

    // Konten in Tresor
    @OneToMany(cascade = CascadeType.ALL, mappedBy="vault")
    private Collection<BankAccount> accounts;

    // Ausgehende Überweisungen
    @OneToMany(cascade = CascadeType.ALL, mappedBy="senderVault")
    private Collection<BankTransaction> outgoingTransactions;

    // Eingehende Überweisungen
    @OneToMany(cascade = CascadeType.ALL, mappedBy="receiverVault")
    private Collection<BankTransaction> incomingTransactions;

}
