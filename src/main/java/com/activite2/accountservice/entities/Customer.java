package com.activite2.accountservice.entities;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.*;
import org.springframework.web.bind.annotation.GetMapping;

import javax.persistence.*;
import java.util.List;
@Entity
@NoArgsConstructor @AllArgsConstructor @Data@Builder
public class Customer {
    @Id @GeneratedValue (strategy = GenerationType.IDENTITY)
    private Long id ;
    private String name;
    @OneToMany(mappedBy = "customer")
    @JsonProperty(access = JsonProperty.Access.WRITE_ONLY)
    private List<Bankaccount> bankaccounts;
}
