package com.example.bankaccountservice.mappers;

import com.example.bankaccountservice.dto.BankAccountRequestDto;
import com.example.bankaccountservice.dto.BankAccountResponseDto;
import com.example.bankaccountservice.entities.BankAccount;
import com.fasterxml.jackson.databind.util.BeanUtil;
import org.springframework.beans.BeanUtils;
import org.springframework.stereotype.Component;

import java.util.Date;
import java.util.UUID;

@Component
public class AccountMapperImpl implements AccountMapper{
     @Override
    public BankAccountResponseDto fromBankAccount(BankAccount bankAccount){
        BankAccountResponseDto bankAccountResponseDto=new BankAccountResponseDto();
        BeanUtils.copyProperties(bankAccount,bankAccountResponseDto);
        return bankAccountResponseDto;
    }

    @Override
    public BankAccount toBankAccount(BankAccountRequestDto bankAccountRequestDto) {
        BankAccount bankAccount = BankAccount.builder()
                .id(UUID.randomUUID().toString())
                .type(bankAccountRequestDto.getType())
                .createdAt(new Date())
                .currency(bankAccountRequestDto.getCurrency())
                .balance(bankAccountRequestDto.getBalance())
                .build();
        return bankAccount;
    }


}
