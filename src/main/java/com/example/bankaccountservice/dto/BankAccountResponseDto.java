package com.example.bankaccountservice.dto;

import com.example.bankaccountservice.enums.AccountType;
import jakarta.persistence.EnumType;
import jakarta.persistence.Enumerated;
import jakarta.persistence.Id;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.Date;
@Data
@AllArgsConstructor
@NoArgsConstructor @Builder
public class BankAccountResponseDto {
    private String id;
    private Double balance;
    private Date createdAt;
    private String currency;

    private AccountType type;
}
