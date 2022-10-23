package com.activite2.accountservice.services;

import com.activite2.accountservice.DTO.BankaccountRequestDTO;
import com.activite2.accountservice.DTO.BankaccountResponseDTO;
import com.activite2.accountservice.entities.Bankaccount;

public interface AccountService {
   BankaccountResponseDTO addAccount(BankaccountRequestDTO bankaccountDTO);

    BankaccountResponseDTO updateAccount(String id, BankaccountRequestDTO bankaccountDTO);
}
