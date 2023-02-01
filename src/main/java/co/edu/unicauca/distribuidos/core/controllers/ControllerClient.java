package co.edu.unicauca.distribuidos.core.controllers;

import co.edu.unicauca.distribuidos.core.services.DTO.ClientDTO;
import co.edu.unicauca.distribuidos.core.services.services.IServiceClient;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;


import java.util.List;

@Controller
@RequestMapping("clients")
public class ControllerClient {
    //INYECCION DE DEPENDENCIAS
    @Autowired
    private IServiceClient serviceClient;

    @GetMapping("/")
    @ResponseBody
    public List<ClientDTO> findAll(){
        return this.serviceClient.findAll();
    }

    @GetMapping("/{username}")
    @ResponseBody
    public ClientDTO findById(@PathVariable String username){
        return serviceClient.findById(username);
    }

    @PostMapping("/")
    @ResponseBody
    public ClientDTO create(@RequestBody ClientDTO client){
        return this.serviceClient.createClient(client);
    }

    @PutMapping("/{username}")
    @ResponseBody
    public ClientDTO update(@RequestBody ClientDTO client, @PathVariable String username){
        ClientDTO objClient = null;
        ClientDTO clientActually = this.serviceClient.findById(username);
        if(clientActually != null){
            objClient = this.serviceClient.update(username,client);
        }
        return objClient;
    }

    @DeleteMapping("/{username}")
    @ResponseBody
    public boolean delete (@PathVariable String username){
        boolean bandera = false;
        ClientDTO actually = this.serviceClient.findById(username);
        if(actually != null){
            bandera = this.serviceClient.delete(username);
        }
        return bandera;
    }



}
