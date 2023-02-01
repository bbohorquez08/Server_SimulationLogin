package co.edu.unicauca.distribuidos.core.repositories;

import co.edu.unicauca.distribuidos.core.models.ClientEntity;
import org.springframework.stereotype.Repository;

import java.util.ArrayList;
import java.util.List;

@Repository
public class ClientRepository{
    private List<ClientEntity> lstClient;

    public ClientRepository(){
        this.lstClient = new ArrayList <ClientEntity>();
        cargarClientes();
    }

    public List<ClientEntity> findAll(){
        System.out.println("Invocando a listar todos");
        return this.lstClient;
    }

    public ClientEntity findByID(String username){
        System.out.println("Invocando a consultar cliente");
        ClientEntity objClient=null;
        for (ClientEntity client : lstClient) {
            if(client.getUsername().equals(username)){
                objClient=client;
                break;
            }
        }

        return objClient;
    }

    public ClientEntity save(ClientEntity client){
        System.out.println("Invocando a guardar cliente");
        ClientEntity objClient = null;
        if(this.lstClient.add(client)){
            objClient=client;
        }

        return objClient;
    }

    public ClientEntity update (String username, ClientEntity client){
        System.out.println("Invocando a actualizar cliente");
        ClientEntity objClient = null;

        for (int i = 0; i < this.lstClient.size(); i++) {
            if(this.lstClient.get(i).getUsername().equals(username)){
                this.lstClient.set(i,client);
                objClient=client;
                break;
            }
        }
        return objClient;
    }

    public boolean delete (String username){
        System.out.println("Invocando a eliminar cliente");
        boolean bandera = false;

        for (int i = 0; i < this.lstClient.size(); i++) {
            if(this.lstClient.get(i).getUsername().equals(username)){
                this.lstClient.remove(i);
                bandera=true;
                break;
            }
        }
        return bandera;
    }

    public boolean verifyProfile(String username, String password){
        System.out.println("Invocando a verificar iniciar sesion");
        boolean bandera = false;
        for (ClientEntity client : lstClient) {
            if(client.getUsername().equals(username) && client.getPassword().equals(password)){
                bandera=true;
            }
        }
        return bandera;
    }

    private void cargarClientes()
    {
        ClientEntity objCliente1= new ClientEntity("Juan", "Perez", "juan@unicauca.edu.co", "13123112", "jperez", "123");
        this.lstClient.add(objCliente1);
        ClientEntity objCliente2= new ClientEntity("Catalina", "Lopez", "catalina@unicauca.edu.co", "75634212", "clopez", "1234");
        this.lstClient.add(objCliente2);

    }
}
