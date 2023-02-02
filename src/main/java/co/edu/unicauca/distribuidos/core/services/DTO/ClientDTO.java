package co.edu.unicauca.distribuidos.core.services.DTO;


import co.edu.unicauca.distribuidos.core.models.Phone;
import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotEmpty;
import jakarta.validation.constraints.Size;
import jakarta.validation.constraints.NotNull;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;
import lombok.experimental.FieldNameConstants;



@Getter @Setter @AllArgsConstructor

public class ClientDTO {

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

    public ClientDTO(){}

}
