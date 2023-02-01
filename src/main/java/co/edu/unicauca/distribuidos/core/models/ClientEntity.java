package co.edu.unicauca.distribuidos.core.models;

import jakarta.validation.constraints.Email;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

import javax.validation.constraints.Size;


@Getter @Setter @AllArgsConstructor
public class ClientEntity {
    @Size(min = 5, max = 20)
    private String name;
    @Size(min = 5, max = 20)
    private String lastname;

    @Email
    private String email;

    private String phone;
    @Size(min = 10, max = 20)
    private String username;
    @Size(min = 10, max = 20)
    private String password;

    public ClientEntity (){}

}
