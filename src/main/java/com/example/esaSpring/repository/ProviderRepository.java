package com.example.esaSpring.repository;
import com.example.esaSpring.entity.Provider;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.stereotype.Repository;

import javax.persistence.EntityNotFoundException;
import java.util.List;

@Repository
public class ProviderRepository {

    private final SessionFactory sessionFactory;

    public ProviderRepository(SessionFactory sessionFactory) {
        this.sessionFactory = sessionFactory;
    }

    public void addProvider(Provider provider) {
        Session session = sessionFactory.getCurrentSession();
        session.save(provider);
    }

    public List<Provider> getAllProviders() {
        Session session = sessionFactory.getCurrentSession();
        return session.createQuery("from Provider", Provider.class).list();
    }


    public Provider getProviderById(Integer id) {
        Session session = sessionFactory.getCurrentSession();
        return session.get(Provider.class, id);
    }

    public void updateProvider(Provider provider) {
        Session session = sessionFactory.getCurrentSession();
        session.save(provider);
    }

    public void deleteProviderById(Integer id) {
        Session session = sessionFactory.getCurrentSession();
        Provider provider = session.get(Provider.class, id);
        if (provider != null) {
            session.delete(provider);
        } else {
            throw new EntityNotFoundException("Provider with id " + id + " not found.");
        }
    }

}

