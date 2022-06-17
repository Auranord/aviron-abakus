package de.aviron.abakus.entities;

import java.time.LocalDateTime;

import javax.persistence.*;

import com.fasterxml.jackson.annotation.JsonIdentityInfo;
import com.fasterxml.jackson.annotation.ObjectIdGenerators;

import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@Data
@NoArgsConstructor
@JsonIdentityInfo(generator = ObjectIdGenerators.PropertyGenerator.class,property = "id")
public class BankPayment {
    
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    // Sender Tresor
    @ManyToOne(cascade = CascadeType.ALL)
    @JoinColumn(name="sender_wallet_id")
    private BankWallet senderWallet;

    // Empfänger Tresor
    @ManyToOne(cascade = CascadeType.ALL)
    @JoinColumn(name="receiver_wallet_id")
    private BankWallet receiverWallet;

    // Überweisungs Menge
    private Integer amount;

    // Überweisungs Zeitpunkt
    private LocalDateTime dateTime;

}
