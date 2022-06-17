package de.aviron.abakus.entities;

import java.util.Collection;

import javax.persistence.*;

import com.fasterxml.jackson.annotation.JsonIdentityInfo;
import com.fasterxml.jackson.annotation.ObjectIdGenerators;

import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.EqualsAndHashCode;

@Entity
@Data
@NoArgsConstructor
@JsonIdentityInfo(generator = ObjectIdGenerators.PropertyGenerator.class,property = "id")
@EqualsAndHashCode(callSuper=true)
public class Bank extends _Possession {
    
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Integer id;

    // Name
    private String name;

    // Kurzbeschreibung
    private String description;

    // Trivia Artikel
    private String trivia;

    // Währungs Name
    private String currencyName;

    // Maximale Konten
    private Integer maxAccounts;

    // Maximale Tresore
    private Integer maxVaults;

    // Tresore
    @OneToMany(cascade = CascadeType.ALL, mappedBy="bank")
    private Collection<BankVault> vaults;

    // Tresore mit Bankwährung
    @OneToMany(cascade = CascadeType.ALL, mappedBy="currency")
    private Collection<BankVault> vaultsUsingCurrency;

    // Konten mit Bankwährung
    @OneToMany(cascade = CascadeType.ALL, mappedBy="currency")
    private Collection<BankAccount> accountsUsingCurrency;

}