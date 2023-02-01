package co.edu.unicauca.distribuidos.core.models;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;

import java.util.ArrayList;

@Getter @Setter @AllArgsConstructor
public class ManagerEntity {
    private String name;
    private String lastname;
    private String username;
    private String password;

    public ManagerEntity(){

    }


}
