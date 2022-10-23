package com.activite2.accountservice.repositories;

import com.activite2.accountservice.entities.Bankaccount;
import com.activite2.accountservice.entities.Customer;
import com.activite2.accountservice.enums.AccountType;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.repository.query.Param;
import org.springframework.data.rest.core.annotation.RepositoryRestResource;
import org.springframework.data.rest.core.annotation.RestResource;

import java.util.List;

@RepositoryRestResource
public interface CustomerRepository extends JpaRepository<Customer,Long> {
    
}
