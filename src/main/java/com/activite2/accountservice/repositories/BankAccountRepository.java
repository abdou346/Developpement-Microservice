package com.activite2.accountservice.repositories;

import com.activite2.accountservice.entities.Bankaccount;
import com.activite2.accountservice.enums.AccountType;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.repository.query.Param;
import org.springframework.data.rest.core.annotation.RepositoryRestResource;
import org.springframework.data.rest.core.annotation.RestResource;
import org.springframework.stereotype.Repository;

import java.util.List;

@RepositoryRestResource
public interface BankAccountRepository extends JpaRepository<Bankaccount,String> {
    @RestResource(path="/byType")
    List<Bankaccount> findByType(@Param(("t")) AccountType type);
}
