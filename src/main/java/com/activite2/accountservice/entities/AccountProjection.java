package com.activite2.accountservice.entities;

import com.activite2.accountservice.enums.AccountType;
import org.springframework.data.rest.core.config.Projection;

@Projection(types=Bankaccount.class,name = "p1")
public interface AccountProjection {
    public String getId();
    public AccountType getType();
    public Double getBalance();
}
