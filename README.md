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

###Bankaccount :
'''@Entity
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

}'''
