package co.edu.unicauca.distribuidos.core.services.services;


import co.edu.unicauca.distribuidos.core.models.ClientEntity;
import co.edu.unicauca.distribuidos.core.repositories.ClientRepository;
import co.edu.unicauca.distribuidos.core.services.DTO.ClientDTO;

import org.modelmapper.ModelMapper;
import org.modelmapper.TypeToken;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;


import java.util.ArrayList;
import java.util.List;

@Service
public class ServiceClientImpl implements IServiceClient{

    //INYECCION DE DEPENDENCIAS
    @Autowired
    private ClientRepository clientRepository;

    @Autowired
    private ModelMapper modelMapper;


    @Override
    public ClientDTO createClient(ClientDTO client) {
        ClientEntity objEntity = this.modelMapper.map(client,ClientEntity.class);
        ClientEntity objClientEntity = this.clientRepository.save(objEntity);
        ClientDTO clientDTO = this.modelMapper.map(objClientEntity,ClientDTO.class);
        return clientDTO;
    }

    @Override
    public List<ClientDTO> findAll() {
        List<ClientEntity> lstEntity = this.clientRepository.findAll();
        List<ClientDTO> lstDTO = this.modelMapper.map(lstEntity,new TypeToken<List<ClientDTO>>(){}.getType());
        return lstDTO;
    }

    @Override
    public ClientDTO findById(String username) {
        ClientEntity objEntity = this.clientRepository.findByID(username);
        ClientDTO objDTO = this.modelMapper.map(objEntity,ClientDTO.class);
        return objDTO;
    }

    @Override
    public ClientDTO update(String username, ClientDTO client) {
        ClientEntity clientEntity = this.modelMapper.map(client,ClientEntity.class);
        ClientEntity clientEntityUpdate = this.clientRepository.update(username,clientEntity);
        ClientDTO clientDTO = this.modelMapper.map(clientEntityUpdate,ClientDTO.class);
        return clientDTO;
    }

    @Override
    public boolean delete(String username) {
        return this.clientRepository.delete(username);
    }

    @Override
    public boolean verifyLogin(String username, String password) {
        return this.clientRepository.verifyProfile(username,password);
    }
}
