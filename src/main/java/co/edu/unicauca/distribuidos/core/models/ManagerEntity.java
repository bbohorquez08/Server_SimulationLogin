package co.edu.unicauca.distribuidos.core.models;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;

import javax.validation.constraints.Size;
import java.util.ArrayList;

@Getter @Setter @AllArgsConstructor
public class ManagerEntity {
    @Size(min = 5, max = 20)
    private String name;
    @Size(min = 5, max = 20)
    private String lastname;
    @Size(min = 10, max = 20)
    private String username;
    @Size(min = 10, max = 20)
    private String password;

    public ManagerEntity(){

    }


}
