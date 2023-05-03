package com.example.bankaccountservice.services;

import com.example.bankaccountservice.dto.BankAccountRequestDto;
import com.example.bankaccountservice.dto.BankAccountResponseDto;

public interface AccountService {
    BankAccountResponseDto addAccount(BankAccountRequestDto bankAccountRequestDto);
    BankAccountResponseDto updateAccount(String id,BankAccountRequestDto bankAccountRequestDto);
    boolean deleteBankAccount(String id);
}
