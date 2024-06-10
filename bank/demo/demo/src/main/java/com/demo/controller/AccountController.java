package com.demo.controller;

import com.demo.Model.Account;
import com.demo.service.AccountService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.math.BigDecimal;

@RestController
public class AccountController{

    @Autowired
   AccountService accountService;


    @PostMapping("/open-account")
    public ResponseEntity<Account> openAccount(@RequestBody Account account) {
        Account account1 = accountService.openAccount(account);
        return ResponseEntity.ok(account1);
    }
    @PostMapping("/{id}/withdraw")
    public ResponseEntity<?> withdraw(@PathVariable int id, @RequestParam BigDecimal amount) {
        BigDecimal newBalance = accountService.withdraw(id, amount);
        return ResponseEntity.ok("Withdrawn successfully. New balance: " + newBalance);
    }

    @PostMapping("/{id}/deposite")
    public ResponseEntity<?> deposite(@PathVariable int id, @RequestParam BigDecimal amount) {
        BigDecimal newBalance = accountService.deposite(id, amount);
        return ResponseEntity.ok("Deposited successfully. New balance: "+newBalance);
    }

    @PostMapping("{fromId}/{ToId}/transfer")
    public ResponseEntity<?> transfer(@PathVariable int fromId,@PathVariable int ToId,@RequestParam BigDecimal amount){
        accountService.transfer(fromId,ToId,amount);
        return ResponseEntity.ok("Transfer Successfully");
    }
    @GetMapping("/{id}/balance")
    public ResponseEntity<BigDecimal> getBalance(@PathVariable int id) {
        BigDecimal balance = accountService.getBalance(id);
        return ResponseEntity.ok(balance);
    }
    }
