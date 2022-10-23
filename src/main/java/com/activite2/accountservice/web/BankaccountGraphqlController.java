package com.activite2.accountservice.web;

import com.activite2.accountservice.DTO.BankaccountRequestDTO;
import com.activite2.accountservice.DTO.BankaccountResponseDTO;
import com.activite2.accountservice.entities.Bankaccount;
import com.activite2.accountservice.entities.Customer;
import com.activite2.accountservice.repositories.BankAccountRepository;
import com.activite2.accountservice.repositories.CustomerRepository;
import com.activite2.accountservice.services.AccountService;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.graphql.data.method.annotation.Argument;
import org.springframework.graphql.data.method.annotation.MutationMapping;
import org.springframework.graphql.data.method.annotation.QueryMapping;
import org.springframework.stereotype.Controller;

import java.util.List;

@Controller
public class BankaccountGraphqlController {
    @Autowired
    private BankAccountRepository bankAccountRepository;
    @Autowired
    private AccountService accountService;
    @Autowired
    private CustomerRepository customerRepository;
    @QueryMapping
    public List<Bankaccount> accountslist(){
        return bankAccountRepository.findAll();
    }
    @QueryMapping
    public Bankaccount bankaccountbyId(@Argument  String id){
        return bankAccountRepository.findById(id)
                .orElseThrow(()->new RuntimeException(String.format("Account %s not found",id)));
    }
    @MutationMapping
    public BankaccountResponseDTO addAccount(@Argument BankaccountRequestDTO bankAccount){
        return accountService.addAccount(bankAccount);

    }
    @MutationMapping
    public BankaccountResponseDTO updateAccount(@Argument String id,@Argument BankaccountRequestDTO bankAccount){
        return accountService.updateAccount(id,bankAccount);

    }
    @MutationMapping
    public Boolean deleteAccount(@Argument String id){
       bankAccountRepository.deleteById(id);
       return true;

    }
    @QueryMapping
    public List <Customer>customers(){
        return customerRepository.findAll();
    }
    @QueryMapping
    public List <Bankaccount>bankaccounts(){
        return bankAccountRepository.findAll();
    }

}

/*record BankAccountDTO(Double balance, String type, String currency){

}
*/
