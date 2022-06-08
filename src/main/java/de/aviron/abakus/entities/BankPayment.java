package de.aviron.abakus.entities;

import java.time.LocalDateTime;

import javax.persistence.*;

import com.fasterxml.jackson.annotation.JsonIgnore;

import lombok.Data;

@Entity
@Data
public class BankPayment {
    
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Integer id;

    // Sender Tresor
    @ManyToOne(cascade = CascadeType.ALL) @JsonIgnore
    @JoinColumn(name="sender_wallet_id")
    private BankWallet senderWallet;

    // Empfänger Tresor
    @ManyToOne(cascade = CascadeType.ALL) @JsonIgnore
    @JoinColumn(name="receiver_wallet_id")
    private BankWallet receiverWallet;

    // Überweisungs Menge
    private Integer amount;

    // Überweisungs Zeitpunkt
    private LocalDateTime dateTime;

}
