package com.demo.service;
import com.demo.repository.AccountRepository;
import com.demo.Model.Account;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.RequestBody;

import java.math.BigDecimal;
import java.util.Random;

@Service
public class AccountService {
    @Autowired
    AccountRepository accountRepository;

    public Account openAccount(Account account){
        account.setAccnumber(generateAccnumber());
       return accountRepository.save(account);
    }

    public BigDecimal withdraw(int id,BigDecimal amount){
        Account account=accountRepository.findById(id)
                .orElseThrow(() -> new IllegalArgumentException("Account not found"));
        BigDecimal newBalance=account.getBalance().subtract(amount);
        account.setBalance(newBalance);
         accountRepository.save(account);
         return newBalance;
    }
    public  BigDecimal deposite(int id,BigDecimal amount){
        Account account=accountRepository.findById(id)
                .orElseThrow(() -> new IllegalArgumentException("Account not found"));
        BigDecimal newBalance=account.getBalance().add(amount);
        account.setBalance(newBalance);
        accountRepository.save(account);
        return newBalance;
    }
    public void transfer(int fromId,int ToId,BigDecimal amount){
        withdraw(fromId,amount);
        deposite(ToId,amount);
    }

   public BigDecimal getBalance(int id) {
       Account account = accountRepository.findById(id)
               .orElseThrow(() -> new IllegalArgumentException("Account not found"));
       return account.getBalance();
   }
    public String generateAccnumber(){
        Random random=new Random();
        StringBuilder sb=new StringBuilder();
        for(int i=0;i<10;i++){
            sb.append(random.nextInt(10));
        }
        return sb.toString();
    }
}

