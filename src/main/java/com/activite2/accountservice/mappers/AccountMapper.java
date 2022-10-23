package com.activite2.accountservice.mappers;

import com.activite2.accountservice.DTO.BankaccountResponseDTO;
import com.activite2.accountservice.entities.Bankaccount;
import org.springframework.beans.BeanUtils;
import org.springframework.stereotype.Component;

@Component
public class AccountMapper {
    public BankaccountResponseDTO fromBankaccount(Bankaccount bankaccount){
        BankaccountResponseDTO bankaccountResponseDTO =new BankaccountResponseDTO();
        BeanUtils.copyProperties(bankaccount,bankaccountResponseDTO);
        return bankaccountResponseDTO;
    }
}
