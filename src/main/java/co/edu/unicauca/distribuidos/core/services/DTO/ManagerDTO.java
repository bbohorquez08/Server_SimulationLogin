package co.edu.unicauca.distribuidos.core.services.DTO;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;

@Getter @Setter @AllArgsConstructor
public class ManagerDTO {
    private String name;
    private String lastname;
    private String username;
    private String password;

    public ManagerDTO(){

    }


}
