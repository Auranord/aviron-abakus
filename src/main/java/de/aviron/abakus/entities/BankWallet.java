package de.aviron.abakus.entities;

import java.util.Collection;

import javax.persistence.*;

import com.fasterxml.jackson.annotation.JsonIgnore;

import lombok.Data;

@Entity
@Data
public class BankWallet {
    
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Integer id;

    // Besitzer
    @ManyToOne(cascade = CascadeType.ALL) @JsonIgnore
    @JoinColumn(name="figure_id")
    private Figure figure;

    // Währung
    @ManyToOne(cascade = CascadeType.ALL) @JsonIgnore
    @JoinColumn(name="currency_id")
    private Bank currency;

    // Kontostand
    private Integer balance;

    // 
    private Integer max;

    // Einzahlung
    @OneToMany(cascade = CascadeType.ALL, mappedBy="wallet") @JsonIgnore
    private Collection<BankDeposit> deposits;

    // Ausgehende Barzahlung
    @OneToMany(cascade = CascadeType.ALL, mappedBy="senderWallet") @JsonIgnore
    private Collection<BankPayment> outgoingPayments;

    // Eingehende Barzahlung
    @OneToMany(cascade = CascadeType.ALL, mappedBy="receiverWallet") @JsonIgnore
    private Collection<BankPayment> incomingPayments;

}
