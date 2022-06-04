package de.aviron.abakus.entities;

import java.util.Collection;

import javax.persistence.*;

import com.fasterxml.jackson.annotation.JsonIgnore;

import lombok.Data;
import lombok.EqualsAndHashCode;

@Entity
@Data
@EqualsAndHashCode(callSuper=true)
public class Bank extends _Possession {
    
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Integer id;

    // Name
    private String name;

    // Beschreibung
    private String description;

    // Währungs Name
    private String currencyName;

    // Maximale Konten
    private Integer maxAccounts;

    // Maximale Tresore
    private Integer maxVaults;

    // Tresore
    @OneToMany(cascade = CascadeType.ALL, mappedBy="bank") @JsonIgnore
    private Collection<BankVault> vaults;

    // Konten
    @OneToMany(cascade = CascadeType.ALL, mappedBy="bank") @JsonIgnore
    private Collection<BankAccount> accounts;

    // Tresore mit Bankwährung
    @OneToMany(cascade = CascadeType.ALL, mappedBy="currency") @JsonIgnore
    private Collection<BankVault> vaultsUsingCurrency;

    // Konten mit Bankwährung
    @OneToMany(cascade = CascadeType.ALL, mappedBy="currency") @JsonIgnore
    private Collection<BankAccount> accountsUsingCurrency;

}