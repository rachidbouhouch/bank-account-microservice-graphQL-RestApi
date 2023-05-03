package com.example.bankaccountservice.mappers;

import com.example.bankaccountservice.dto.BankAccountRequestDto;
import com.example.bankaccountservice.dto.BankAccountResponseDto;
import com.example.bankaccountservice.entities.BankAccount;

public interface AccountMapper {

    BankAccountResponseDto fromBankAccount(BankAccount bankAccount);
    BankAccount toBankAccount(BankAccountRequestDto bankAccountRequestDto);
}
