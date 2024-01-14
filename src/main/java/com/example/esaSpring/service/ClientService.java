package com.example.esaSpring.service;
import com.example.esaSpring.dao.ClientDAO;
import com.example.esaSpring.dao.ProviderDAO;
import com.example.esaSpring.entity.Client;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.EnableTransactionManagement;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
@Transactional
@EnableTransactionManagement
public class ClientService {

    private ClientDAO clientDAO;

    public ClientService(ClientDAO clientDAO) {this.clientDAO = clientDAO;}

    public List<Client> getAllClients() {
        return clientDAO.getAllClients();
    }

    public void addClient(Client client) {
        clientDAO.addClient(client);
    }

    public Client getClientById(Integer id) {return clientDAO.getClientById(id);}

    public void updateClient(Client client) {clientDAO.updateClient(client);}

    public void deleteClientById(Integer id) {clientDAO.deleteClientById(id);}
}
