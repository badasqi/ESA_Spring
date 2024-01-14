package com.example.esaSpring.service;

import com.example.esaSpring.entity.Provider;
import com.example.esaSpring.repository.ProviderRepository;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.EnableTransactionManagement;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
@Transactional
@EnableTransactionManagement
public class ProviderService {

    private ProviderRepository providerRepository;

    public ProviderService(ProviderRepository providerRepository) {
        this.providerRepository = providerRepository;
    }

    public List<Provider> getAllProviders() {return providerRepository.getAllProviders();}

    public void addProvider(Provider provider) {providerRepository.addProvider(provider);}

    public Provider getProviderById(Integer id) {
        return providerRepository.getProviderById(id);
    }

    public void updateProvider(Provider provider) {
        providerRepository.updateProvider(provider);
    }

    public void deleteProviderById(Integer id) {
        providerRepository.deleteProviderById(id);
    }

}
