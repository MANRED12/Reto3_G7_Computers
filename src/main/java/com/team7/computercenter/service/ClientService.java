package com.team7.computercenter.service;

import com.team7.computercenter.entities.Client;
import com.team7.computercenter.repository.ClientRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class ClientService {
    @Autowired
    private ClientRepository clientRepository;

    public List<Client> getAll(){
        return clientRepository.getAll();
    }
    public Optional<Client> getById(int clientId) {
        return clientRepository.getById(clientId);
    }
    public Client save(Client c){
        if(c.getIdClient()==null){
            return clientRepository.save(c);
        }
        return c;
    }
    public boolean deleteClient (int id){
        Optional<Client> cOp= clientRepository.getById(id);
        if (cOp.isPresent()){
            clientRepository.delete(cOp.get());
            return true;
        }
        return false;
    }
    public Client update(Client c){
        if(c.getIdClient()!=null){
            Optional<Client> e= clientRepository.getById(c.getIdClient());
            if(e.isPresent()){
                Client k = e.get();

                if(c.getName()!=null){
                    k.setName(c.getName());
                }
                if(c.getAge()!=null){
                    k.setAge(c.getAge());
                }
                if(c.getPassword()!=null){
                    k.setPassword(c.getPassword());
                }
                if(c.getEmail()!=null){
                    k.setEmail(c.getEmail());
                }
                return clientRepository.save(k);
            }
        }
        return c;
    }
}


