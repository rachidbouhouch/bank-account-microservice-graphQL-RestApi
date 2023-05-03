package com.example.bankaccountservice.services;

import com.example.bankaccountservice.dto.BankAccountRequestDto;
import com.example.bankaccountservice.dto.BankAccountResponseDto;
import com.example.bankaccountservice.entities.BankAccount;
import com.example.bankaccountservice.mappers.AccountMapper;
import com.example.bankaccountservice.repositories.BankAccountRepository;
import jakarta.transaction.Transactional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Date;
import java.util.UUID;

@Service
@Transactional
public class AccountServiceImpl implements AccountService{

    @Autowired
    private BankAccountRepository bankAccountRepository;

    @Autowired
    private AccountMapper accountMapper;

    @Override
    public BankAccountResponseDto addAccount(BankAccountRequestDto bankAccountRequestDto) {
        BankAccount bankAccount = accountMapper.toBankAccount(bankAccountRequestDto);

        BankAccount saveBankAccount = bankAccountRepository.save(bankAccount);

        BankAccountResponseDto bankAccountResponseDto=accountMapper.fromBankAccount(saveBankAccount);

        return bankAccountResponseDto;
    }

    @Override
    public BankAccountResponseDto updateAccount(String id,BankAccountRequestDto bankAccountRequestDto) {
      BankAccount bankAccount = BankAccount.builder()
                .id(id)
                .type(bankAccountRequestDto.getType())
                .createdAt(new Date())
                .currency(bankAccountRequestDto.getCurrency())
                .balance(bankAccountRequestDto.getBalance())
                .build();

        BankAccount saveBankAccount = bankAccountRepository.save(bankAccount);

        BankAccountResponseDto bankAccountResponseDto=accountMapper.fromBankAccount(saveBankAccount);

        return bankAccountResponseDto;
    }

    @Override
    public boolean deleteBankAccount(String id) {
        bankAccountRepository.deleteById(id);
        return true;

    }
}
