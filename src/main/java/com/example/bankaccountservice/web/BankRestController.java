package com.example.bankaccountservice.web;

import com.example.bankaccountservice.dto.BankAccountRequestDto;
import com.example.bankaccountservice.dto.BankAccountResponseDto;
import com.example.bankaccountservice.entities.BankAccount;
import com.example.bankaccountservice.repositories.BankAccountRepository;
import com.example.bankaccountservice.services.AccountService;
import org.springframework.web.bind.annotation.*;

import java.util.Date;
import java.util.List;
import java.util.Optional;

@RestController
public class BankRestController {
    private BankAccountRepository bankAccountRepository;

    private AccountService accountService;

    public BankRestController(BankAccountRepository bankAccountRepository,AccountService accountService){
        this.bankAccountRepository=bankAccountRepository;
        this.accountService = accountService;
    }

    @GetMapping("/bankAccounts")
    public List<BankAccount> getBankAccounts(){
        return bankAccountRepository.findAll();
    }

    @GetMapping("/bankAccounts/{id}")
    public BankAccount getBankAccount(@PathVariable String id){
        return bankAccountRepository.findById(id)
                .orElseThrow(()-> new RuntimeException(String.format("Account %s not found",id)));
    }
    @PostMapping("/bankAccounts")
    public BankAccountResponseDto saveBankAccount(@RequestBody BankAccountRequestDto bankAccountRequestDto){
        return accountService.addAccount(bankAccountRequestDto);
    }

    @PutMapping("/bankAccounts/{id}")
    public BankAccount updateBankAccount(@PathVariable String id,@RequestBody BankAccount bankAccount){
        BankAccount account=bankAccountRepository.findById(id).orElseThrow();
        if(bankAccount.getBalance()!=null)account.setBalance(bankAccount.getBalance());
        if(bankAccount.getType()!=null)account.setType(bankAccount.getType());
        if(bankAccount.getCurrency()!=null)account.setCurrency(bankAccount.getCurrency());
        if(bankAccount.getCreatedAt()!=null)account.setCreatedAt(new Date());
        return bankAccountRepository.save(account);
    }

    @DeleteMapping("/bankAccounts/{id}")
    public void deleteBankAccount(@PathVariable String id){
         bankAccountRepository.deleteById(id);
    }

}
