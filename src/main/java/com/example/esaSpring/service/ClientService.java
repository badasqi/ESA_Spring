package com.example.esaSpring.service;
import com.example.esaSpring.entity.Client;
import com.example.esaSpring.repository.ClientRepository;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.EnableTransactionManagement;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
@Transactional
@EnableTransactionManagement
public class ClientService {

    private final ClientRepository clientRepository;

    public ClientService(ClientRepository clientRepository) {
        this.clientRepository = clientRepository;
    }

    public List<Client> getAllClients() {
        return clientRepository.getAllClients();
    }

    public void addClient(Client client) {
        clientRepository.addClient(client);
    }

    public Client getClientById(Integer id) {return clientRepository.getClientById(id);}

    public void updateClient(Client client) {clientRepository.updateClient(client);}

    public void deleteClientById(Integer id) {clientRepository.deleteClientById(id);}
}
