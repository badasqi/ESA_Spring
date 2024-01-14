package com.example.esaSpring.service;

import com.example.esaSpring.dao.ProviderDAO;
import com.example.esaSpring.entity.Provider;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.EnableTransactionManagement;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
@Transactional
@EnableTransactionManagement
public class ProviderService {

    private ProviderDAO providerDAO;

    public ProviderService(ProviderDAO providerDAO) {
        this.providerDAO = providerDAO;
    }

    public List<Provider> getAllProviders() {return providerDAO.getAllProviders();}

    public void addProvider(Provider provider) {providerDAO.addProvider(provider);}

    public Provider getProviderById(Integer id) {
        return providerDAO.getProviderById(id);
    }

    public void updateProvider(Provider provider) {
        providerDAO.updateProvider(provider);
    }

    public void deleteProviderById(Integer id) {
        providerDAO.deleteProviderById(id);
    }

}
