package com.example.esaSpring.dao;

import com.example.esaSpring.entity.Client;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import javax.persistence.EntityNotFoundException;
import java.util.List;


@Repository
public class ClientDAO {
    private final SessionFactory sessionFactory;

    public ClientDAO(SessionFactory sessionFactory) {
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
        session.saveOrUpdate(client);
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
