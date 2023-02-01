package co.edu.unicauca.distribuidos.core.services.services;

import co.edu.unicauca.distribuidos.core.services.DTO.ClientDTO;


import java.util.ArrayList;
import java.util.List;

public interface IServiceClient {
    //METODO QUE ME PERMITE REGISTRAR CLIENTES
    public ClientDTO createClient(ClientDTO client);
    //METODO QUE ME PERMITE OBTENER TODOS LOS CLIENTES
    public List<ClientDTO> findAll();
    //METODO QUE ME PERMITE OBTENER UN CLIENTE EN ESPECIFICO
    public ClientDTO findById(String username);
    //METODO QUE ME PERMITE EDITAR EL CLIENTE
    public ClientDTO update(String username, ClientDTO client);
    //METODO QUE ME PERMITE ELIMINAR EL CLIENTE
    public boolean delete (String username);
    //METODO QUE ME PERMITE CONSULTAR LOGIN
    public boolean verifyLogin(String username, String password);


}
