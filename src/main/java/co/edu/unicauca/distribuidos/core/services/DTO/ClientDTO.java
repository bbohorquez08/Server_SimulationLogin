package co.edu.unicauca.distribuidos.core.services.DTO;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;

@Getter @Setter @AllArgsConstructor
public class ClientDTO {
    private String name;
    private String lastname;
    private String email;
    private String phone;
    private String username;
    private String password;

    public ClientDTO(){}

}
