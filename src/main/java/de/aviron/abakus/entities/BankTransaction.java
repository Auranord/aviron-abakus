package de.aviron.abakus.entities;

import java.time.LocalDateTime;

import javax.persistence.*;

import com.fasterxml.jackson.annotation.JsonIgnore;

import de.aviron.abakus.enums.BankTransactionError;
import lombok.Data;

@Entity
@Data
public class BankTransaction {
    
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Integer id;

    // Auftraggeber
    @ManyToOne(cascade = CascadeType.ALL) @JsonIgnore
    @JoinColumn(name="client_id")
    private Figure client;

    // Sender Tresor
    @ManyToOne(cascade = CascadeType.ALL) @JsonIgnore
    @JoinColumn(name="sender_vault_id")
    private BankVault senderVault;

    // Empfänger Tresor
    @ManyToOne(cascade = CascadeType.ALL) @JsonIgnore
    @JoinColumn(name="receiver_vault_id")
    private BankVault receiverVault;

    // Sender Konto
    @ManyToOne(cascade = CascadeType.ALL) @JsonIgnore
    @JoinColumn(name="sender_account_id")
    private BankAccount senderAccount;

    // Empfänger Konto
    @ManyToOne(cascade = CascadeType.ALL) @JsonIgnore
    @JoinColumn(name="receiver_account_id")
    private BankAccount receiverAccount;

    // Forderung
    private Boolean isClaim;

    // Überweisungs Menge
    private Integer amount;

    // Überweisungs Zeitpunkt
    private LocalDateTime dateTime;

    // Sender Gebühren
    private Integer senderFees;

    // Empfänger Gebühren
    private Integer receiverFees;

    // Überweisungs Fehler
    @Enumerated
    private BankTransactionError error;

    // Sender Anmerkung
    private String senderDescription;

    // Empfänger Anmerkung
    private String receiverDescription;

    // Verwendungszweck
    private String purpose;

    // Sender Gelöscht
    private Boolean senderIsDeleted;

    // Empfänger Gelöscht
    private Boolean receiverIsDeleted;

    // Sender Archiviert
    private Boolean senderIsArchived;

    // Empfänger Archiviert
    private Boolean receiverIsArchived;

    // Sender Gelesen
    private Boolean senderIsRead;

    // Empfänger Gelesen
    private Boolean receiverIsRead;

}
