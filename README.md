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
Также в файле [applicationContext.xml](https://github.com/badasqi/ESA_Spring/blob/main/src/main/webapp/WEB-INF/applicationContext.xml) - DataSource, SessionFactory, TransactionManager:


## Business layer
Логика приложения реализована в Service классах
<pre>
```java
@Service
@Transactional
@EnableTransactionManagement
public class ClientService {

    private final ClientDAO clientDAO;

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
```
<pre/>
