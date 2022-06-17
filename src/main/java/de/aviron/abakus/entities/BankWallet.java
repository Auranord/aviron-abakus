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
public class BankWallet {
    
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Integer id;

    // Besitzer
    @ManyToOne(cascade = CascadeType.ALL)
    @JoinColumn(name="figure_id")
    private Figure figure;

    // Währung
    @ManyToOne(cascade = CascadeType.ALL)
    @JoinColumn(name="currency_id")
    private Bank currency;

    // Kontostand
    private Integer balance;

    // 
    private Integer max;

    // Einzahlung
    @OneToMany(cascade = CascadeType.ALL, mappedBy="wallet")
    private Collection<BankDeposit> deposits;

    // Ausgehende Barzahlung
    @OneToMany(cascade = CascadeType.ALL, mappedBy="senderWallet")
    private Collection<BankPayment> outgoingPayments;

    // Eingehende Barzahlung
    @OneToMany(cascade = CascadeType.ALL, mappedBy="receiverWallet")
    private Collection<BankPayment> incomingPayments;

}
