package com.activite2.accountservice.web;

import com.activite2.accountservice.DTO.BankaccountRequestDTO;
import com.activite2.accountservice.DTO.BankaccountResponseDTO;
import com.activite2.accountservice.entities.Bankaccount;
import com.activite2.accountservice.mappers.AccountMapper;
import com.activite2.accountservice.repositories.BankAccountRepository;
import com.activite2.accountservice.services.AccountService;
import org.springframework.web.bind.annotation.*;

import java.util.Date;
import java.util.List;

@RestController
@RequestMapping("/api")
public class AccountRestController {
    private BankAccountRepository bankAccountRepository;
    private AccountMapper accountMapper;
    private AccountService accountService;
    public AccountRestController(BankAccountRepository bankAccountRepository, AccountMapper accountMapper, AccountService accountService){
        this.bankAccountRepository=bankAccountRepository;
        this.accountMapper = accountMapper;
        this.accountService = accountService;
    }
    @GetMapping("/bankAccounts")
    public List <Bankaccount>bankaccounts(){
        return bankAccountRepository.findAll();
    }
    @GetMapping("/bankAccounts/{id}")
    public Bankaccount bankaccount(@PathVariable String id){
       return bankAccountRepository.findById(id)
               .orElseThrow(()->new RuntimeException(String.format("Account %s not found ",id)));
    }
    @PostMapping("/bankAccounts")
    public BankaccountResponseDTO save (@RequestBody BankaccountRequestDTO requestDTO){
        return  accountService.addAccount(requestDTO);
    }
    @PutMapping("/bankAccounts/{id}")
    public Bankaccount update (@PathVariable String id,@RequestBody Bankaccount bankaccount){
        Bankaccount account=bankAccountRepository.findById(id).orElseThrow();
        if (bankaccount.getBalance()!=null) account.setBalance(bankaccount.getBalance());
        if (bankaccount.getCreatedAt()!=null) account.setCreatedAt(new Date());
        if (bankaccount.getType()!=null) account.setType(bankaccount.getType());
        if (bankaccount.getCurrency()!=null) account.setCurrency(bankaccount.getCurrency());
        return bankAccountRepository.save(account);
    }
    @DeleteMapping ("/bankAccounts/{id}")
    public void delete(@PathVariable String id){
        bankAccountRepository.deleteById(id);
    }
}

