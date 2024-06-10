package com.demo.Model;

import jakarta.persistence.*;

import java.math.BigDecimal;

@Entity
@Table(name = "account")
public class Account {
    @Id
    @Column
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;

    @Column(name = "account number")
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private String accnumber;

    @Column(name = "balance")
    private BigDecimal balance;

    @Column(name = "contact")
    private String contact;

    public Account(int id, String accnumber, BigDecimal balance, String contact) {
        this.id = id;
        this.accnumber = accnumber;
        this.balance = balance;
        this.contact = contact;
    }

    public Account() {
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getAccnumber() {
        return accnumber;
    }

   public void setAccnumber(String accnumber){
        this.accnumber=accnumber;
   }

    public BigDecimal getBalance() {
        return balance;
    }

    public void setBalance(BigDecimal balance) {
        this.balance = balance;
    }

    public String getContact() {
        return contact;
    }

    public void setContact(String contact) {
        this.contact = contact;
    }
}
