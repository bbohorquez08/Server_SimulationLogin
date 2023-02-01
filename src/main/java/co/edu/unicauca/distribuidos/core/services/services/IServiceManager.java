package co.edu.unicauca.distribuidos.core.services.services;




import co.edu.unicauca.distribuidos.core.services.DTO.ManagerDTO;


import java.util.ArrayList;
import java.util.List;

public interface IServiceManager {
    //METODO QUE ME PERMITE REGISTRAR ADMINISTRADORES
    public ManagerDTO createClient(ManagerDTO admin);


    //METODO QUE ME PERMITE OBTENER TODOS LOS CLIENTES
    public List<ManagerDTO> findAll();
    //METODO QUE ME PERMITE OBTENER UN CLIENTE EN ESPECIFICO
    public ManagerDTO findById(String username);
    //METODO QUE ME PERMITE EDITAR EL CLIENTE
    public ManagerDTO update(String username, ManagerDTO client);
    //METODO QUE ME PERMITE ELIMINAR EL CLIENTE
    public boolean delete (String username);
    //METODO QUE ME PERMITE CONSULTAR LOGIN
    public boolean verifyLogin(String username, String password);
}
