# Atelier 2 Développement du Premier Micro-service
## Enoncé :
1. Créer un projet Spring Boot avec les dépendances Web, Spring Data JPA, H2, Lombok
2. Créer l'entité JPA Compte
3. Créer l'interface CompteRepository basée sur Spring Data
4. Tester la couche DAO
5. Créer le Web service Restfull qui permet de gérer des comptes
6. Tester le web micro-service en utilisant un client REST comme Postman
7. Générer et tester le documentation Swagger de des API Rest du Web service
8. Exposer une API Restful en utilisant Spring Data Rest en exploitant des projections
9. Créer les DTOs et Mappers
10. Créer la couche Service (métier) et du micro service

##  Conception et architecture :
![archi](https://user-images.githubusercontent.com/101510983/200371852-06eaf710-4b2a-41c2-897c-f30cdbb91233.png)


![accountservice](https://user-images.githubusercontent.com/101510983/198897988-5066fe78-1764-4de5-b94f-e8206029f69c.png)

### Bankaccount :
```java
@Entity
@Data @NoArgsConstructor @AllArgsConstructor @Builder
public class Bankaccount {
    @Id
    private String id;
    private Date createdAt;
    private Double balance;
    private String currency;
    @Enumerated(EnumType.STRING )
    private AccountType type;@ManyToOne
    private Customer customer;

}
```
### Bankaccount Repository :
```java
@RepositoryRestResource
public interface BankAccountRepository extends JpaRepository<Bankaccount,String> {
    @RestResource(path="/byType")
    List<Bankaccount> findByType(@Param(("t")) AccountType type);
}
```
![image](https://user-images.githubusercontent.com/101510983/200375526-f4e7444b-02b8-4cb6-946c-5f8e309ab622.png)



### RestController:

```java
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
    
 ```
    ![image](https://user-images.githubusercontent.com/101510983/200377077-767dd0d3-e3fe-42cf-a5b3-76831def8027.png)

### RestController:

