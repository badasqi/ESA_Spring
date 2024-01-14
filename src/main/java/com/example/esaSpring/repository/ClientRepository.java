package com.example.esaSpring.repository;

import com.example.esaSpring.entity.Client;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.stereotype.Repository;

import javax.persistence.EntityNotFoundException;
import java.util.List;


@Repository
public class ClientRepository {
    private final SessionFactory sessionFactory;

    public ClientRepository(SessionFactory sessionFactory) {
        this.sessionFactory = sessionFactory;
    }

    public void addClient(Client client) {
        Session session = sessionFactory.getCurrentSession();
        session.save(client);
    }

    public List<Client> getAllClients() {
        Session session = sessionFactory.getCurrentSession();
        return session.createQuery("from Client", Client.class).list();
    }
    public Client getClientById(Integer id) {
        Session session = sessionFactory.getCurrentSession();
        return session.get(Client.class, id);
    }

    public void updateClient(Client client) {
        Session session = sessionFactory.getCurrentSession();
        Client client1 = session.get(Client.class, client.getId());
        if (client1 != null) {
            session.saveOrUpdate(client);
        } else {
            throw new EntityNotFoundException("Client with id " + client.getId() + " not found.");
        }
    }

    public void deleteClientById(Integer id) {
        Session session = sessionFactory.getCurrentSession();
        Client client = session.get(Client.class, id);
        if (client != null) {
            session.delete(client);
        } else {
            throw new EntityNotFoundException("Client with id " + id + " not found.");
        }
    }
}
