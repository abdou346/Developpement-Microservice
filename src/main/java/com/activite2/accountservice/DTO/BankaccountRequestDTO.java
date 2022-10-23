package com.activite2.accountservice.DTO;

import com.activite2.accountservice.enums.AccountType;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import java.util.Date;
@Data @AllArgsConstructor @NoArgsConstructor @Builder
public class BankaccountRequestDTO {
    private Double balance;
    private String currency;
    private AccountType type;
}
