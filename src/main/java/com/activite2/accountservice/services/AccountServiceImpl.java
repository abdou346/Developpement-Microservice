package com.activite2.accountservice.services;

import com.activite2.accountservice.DTO.BankaccountRequestDTO;
import com.activite2.accountservice.DTO.BankaccountResponseDTO;
import com.activite2.accountservice.entities.Bankaccount;
import com.activite2.accountservice.mappers.AccountMapper;
import com.activite2.accountservice.repositories.BankAccountRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.Date;
import java.util.UUID;

@Service
@Transactional
public class AccountServiceImpl implements AccountService {
    @Autowired
    private BankAccountRepository bankAccountRepository;
    @Autowired
    private AccountMapper accountMapper;
    @Override
    public BankaccountResponseDTO addAccount(BankaccountRequestDTO bankaccountDTO) {
        Bankaccount bankaccount = Bankaccount.builder()
                .id(UUID.randomUUID().toString())
                .createdAt(new Date())
                .balance(bankaccountDTO.getBalance())
                .type(bankaccountDTO.getType())
                .currency(bankaccountDTO.getCurrency())
                .build();
        Bankaccount saveBankAccount=bankAccountRepository.save(bankaccount)    ;
        BankaccountResponseDTO bankaccountResponseDTO=accountMapper.fromBankaccount(saveBankAccount);

        return bankaccountResponseDTO;
    }
    @Override
    public BankaccountResponseDTO updateAccount(String id,BankaccountRequestDTO bankaccountDTO) {
        Bankaccount bankaccount = Bankaccount.builder()
                .id(id)
                .createdAt(new Date())
                .balance(bankaccountDTO.getBalance())
                .type(bankaccountDTO.getType())
                .currency(bankaccountDTO.getCurrency())
                .build();
        Bankaccount saveBankAccount=bankAccountRepository.save(bankaccount)    ;
        BankaccountResponseDTO bankaccountResponseDTO=accountMapper.fromBankaccount(saveBankAccount);

        return bankaccountResponseDTO;
    }
}
