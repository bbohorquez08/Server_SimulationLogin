package co.edu.unicauca.distribuidos.core.models;

import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotEmpty;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Size;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;




@Getter @Setter @AllArgsConstructor
public class ClientEntity {
    @NotEmpty
    @NotNull
    @Size(min = 5,max = 50)
    private String name;

    @NotEmpty
    @NotNull
    @Size(min = 5,max = 50)
    private String lastname;

    @Email
    @NotNull
    private String email;

    @NotEmpty
    @NotNull
    @Size(min = 10)
    @Phone
    private String phone;

    @NotEmpty
    @NotNull
    @Size(min = 10,max = 20)
    private String username;

    @NotEmpty
    @NotNull
    @Size(min = 10,max = 20)
    private String password;

    public ClientEntity (){}

}
