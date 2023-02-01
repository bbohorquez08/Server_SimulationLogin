package co.edu.unicauca.distribuidos.core.services.services;

import co.edu.unicauca.distribuidos.core.models.ManagerEntity;
import co.edu.unicauca.distribuidos.core.repositories.ManagerRepository;
import co.edu.unicauca.distribuidos.core.services.DTO.ManagerDTO;

import org.modelmapper.ModelMapper;
import org.modelmapper.TypeToken;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;


import java.util.List;

@Service
public class ServiceManagerImpl implements IServiceManager{

    //INYECCION DE DEPENDENCIAS
    @Autowired
    private ManagerRepository managerRepository;
    @Autowired
    private ModelMapper modelMapper;

    @Override
    public ManagerDTO createClient(ManagerDTO admin) {

        ManagerEntity objEntity = this.modelMapper.map(admin,ManagerEntity.class);
        ManagerEntity objManagerEntity = this.managerRepository.save(objEntity);
        ManagerDTO managerDTO = this.modelMapper.map(objManagerEntity,ManagerDTO.class);
        return managerDTO;
    }

    @Override
    public List<ManagerDTO> findAll() {
        List<ManagerEntity> lstEntity = this.managerRepository.findAll();
        List<ManagerDTO> lstDTO = this.modelMapper.map(lstEntity,new TypeToken<List<ManagerDTO>>(){}.getType());
        return lstDTO;
    }

    @Override
    public ManagerDTO findById(String username) {
        ManagerEntity objEntity = this.managerRepository.findByID(username);
        ManagerDTO objDTO = this.modelMapper.map(objEntity,ManagerDTO.class);
        return objDTO;
    }

    @Override
    public ManagerDTO update(String username, ManagerDTO client) {
        ManagerEntity managerEntity = this.modelMapper.map(client,ManagerEntity.class);
        ManagerEntity managerEntityUpdate = this.managerRepository.update(username,managerEntity);
        ManagerDTO managerDTO = this.modelMapper.map(managerEntityUpdate,ManagerDTO.class);
        return managerDTO;
    }

    @Override
    public boolean delete(String username) {
        return this.managerRepository.delete(username);
    }

    @Override
    public boolean verifyLogin(String username, String password) {
        return this.managerRepository.verifyProfile(username,password);
    }
}
