package com.example.esaSpring.controller;

import com.example.esaSpring.entity.Client;
import com.example.esaSpring.entity.Provider;
import com.example.esaSpring.service.ClientService;
import com.example.esaSpring.service.ProviderService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import java.util.List;

@Controller
public class ClientController {

    @Autowired
    private ClientService clientService;
    @Autowired
    private ProviderService providerService;

    @GetMapping("/clients")
    public String getAllClients(Model model) {
        List<Client> clients = clientService.getAllClients();
        model.addAttribute("clients", clients);
        return "clients"; // Имя представления для отображения списка клиентов
    }

    @GetMapping("/clients/new")
    public String showAddProviderForm(Model model) {
        model.addAttribute("client", new Client());
        List<Provider> providers = providerService.getAllProviders();
        model.addAttribute("providers", providers);
        return "addClient"; // Возвращает название JSP-файла без расширения
    }

    @PostMapping("/clients")
    public String addProvider(@ModelAttribute("client") Client client, @RequestParam("providerId") Integer providerId) {
        Provider provider = providerService.getProviderById(providerId);

        // Установка выбранного провайдера для клиента
        client.setProvider(provider);
        clientService.addClient(client);
        return "redirect:/clients";  // Перенаправление на список провайдеров после создания
    }

    @PutMapping("/clients/{id}")
    public String updateClient(@PathVariable("id") Integer id, @RequestParam("name") String name) {
        Client client = clientService.getClientById(id);

        if (client != null) {
            client.setName(name);
            clientService.updateClient(client);
        }

        return "redirect:/clients"; // Перенаправление на список клиентов после обновления
    }

    @DeleteMapping("/clients/{id}")
    public String deleteClient(@PathVariable("id") Integer id) {
        clientService.deleteClientById(id);
        return "redirect:/clients"; // Перенаправление на список клиентов после удаления
    }
    // Другие методы контроллера для добавления, обновления и удаления клиентов
}
