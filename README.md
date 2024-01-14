# ЛР2 SPRING
Сервер приложений Tomcat 9.0.84
БД - MySQL
Предметная область Provider, Client.
## Конфигурация приложения 
Конфигурационный файл для Spring Framework - [applicationContext.xml](https://github.com/badasqi/ESA_Spring/blob/main/src/main/webapp/WEB-INF/applicationContext.xml)

Component Scanning:
```

<context:component-scan base-package="com.example.esaSpring.controller" />
<context:component-scan base-package="com.example.esaSpring.service" />
<context:component-scan base-package="com.example.esaSpring.dao" />
```
ViewResolver:
```
<bean class="org.springframework.web.servlet.view.InternalResourceViewResolver">
    <property name="prefix" value="/WEB-INF/views/" />
    <property name="suffix" value=".jsp" />
</bean>

```
Также в файле [applicationContext.xml](https://github.com/badasqi/ESA_Spring/blob/main/src/main/webapp/WEB-INF/applicationContext.xml) - DataSource, SessionFactory, TransactionManager.


## Business layer
классы репозиториев реализованы для работы с БД
```java
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
```
Логика приложения реализована в Service классах

```java
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
```

## Spring MVC
Реализованы контроллеры [ClientController](https://github.com/badasqi/ESA_Spring/blob/main/src/main/java/com/example/esaSpring/controller/ClientController.java), [ProviderController](https://github.com/badasqi/ESA_Spring/blob/main/src/main/java/com/example/esaSpring/controller/ProviderController.java), также добавлены jsp страницы для добавления клиентов и провайдеров.
![image](https://github.com/badasqi/ESA_Spring/assets/78803025/43a1ea8e-689e-4d19-9f94-07092e2204e0)

