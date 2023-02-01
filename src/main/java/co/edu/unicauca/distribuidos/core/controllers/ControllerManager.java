package co.edu.unicauca.distribuidos.core.controllers;

import co.edu.unicauca.distribuidos.core.services.DTO.ManagerDTO;
import co.edu.unicauca.distribuidos.core.services.services.IServiceManager;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;


import javax.validation.Valid;
import java.util.List;

@RestController
@RequestMapping("managers")
public class ControllerManager {
    //INYECCION DE DEPENDENCIAS
    @Autowired
    private IServiceManager serviceManager;

    @GetMapping("/")
    @ResponseBody
    public List<ManagerDTO> findAll(){
        return this.serviceManager.findAll();
    }

    @GetMapping("/{username}")
    @ResponseBody
    public ManagerDTO findById(@PathVariable String username){
        return serviceManager.findById(username);
    }

    @PostMapping("/")
    @ResponseBody
    public ManagerDTO create(@Valid @RequestBody ManagerDTO client){
        if(client.getName().length() < 5 || client.getLastname().length() < 5
                || client.getName().length() > 20 || client.getLastname().length() > 20){
            return null;
        }
        if(client.getPassword().length()<10 || client.getUsername().length()<10
                || client.getPassword().length()>20 || client.getUsername().length()>20){
            return null;
        }
        return this.serviceManager.createClient(client);
    }

    @PutMapping("/{username}")
    @ResponseBody
    public ManagerDTO update(@RequestBody ManagerDTO client, @PathVariable String username){
        ManagerDTO objClient = null;
        ManagerDTO clientActually = this.serviceManager.findById(username);
        if(clientActually != null){
            objClient = this.serviceManager.update(username,client);
        }
        return objClient;
    }

    @DeleteMapping("/{username}")
    @ResponseBody
    public boolean delete (@PathVariable String username){
        boolean bandera = false;
        ManagerDTO actually = this.serviceManager.findById(username);
        if(actually != null){
            bandera = this.serviceManager.delete(username);
        }
        return bandera;
    }
}
