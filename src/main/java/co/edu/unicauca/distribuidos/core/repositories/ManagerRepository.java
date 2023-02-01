package co.edu.unicauca.distribuidos.core.repositories;




import co.edu.unicauca.distribuidos.core.models.ManagerEntity;
import org.springframework.stereotype.Repository;

import java.util.ArrayList;
import java.util.List;
@Repository
public class ManagerRepository {
    private ArrayList<ManagerEntity> lstClient;

    public ManagerRepository(){
        this.lstClient = new ArrayList <ManagerEntity>();
        cargarAdmins();
    }

    public List<ManagerEntity> findAll(){
        System.out.println("Invocando a listar todos");
        return this.lstClient;
    }

    public ManagerEntity findByID(String username){
        System.out.println("Invocando a consultar cliente");
        ManagerEntity objClient=null;
        for (ManagerEntity client : lstClient) {
            if(client.getUsername().equals(username)){
                objClient=client;
                break;
            }
        }

        return objClient;
    }

    public ManagerEntity save(ManagerEntity client){
        System.out.println("Invocando a guardar cliente");
        ManagerEntity objClient = null;
        if(this.lstClient.add(client)){
            objClient=client;
        }

        return objClient;
    }

    public ManagerEntity update (String username, ManagerEntity client){
        System.out.println("Invocando a actualizar cliente");
        ManagerEntity objClient = null;

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
        for (ManagerEntity admin : lstClient) {
            if(admin.getUsername().equals(username) && admin.getPassword().equals(password)){
                bandera=true;
            }
        }
        return bandera;
    }

    private void cargarAdmins()
    {
        ManagerEntity objCliente1= new ManagerEntity("David", "Gustin", "dgustin", "123");
        this.lstClient.add(objCliente1);
        ManagerEntity objCliente2= new ManagerEntity("Nicolas", "Muñoz","nmunoz", "1234");
        this.lstClient.add(objCliente2);

    }
}
