# ЛР2 SPRING
Сервер приложений Tomcat 9.0.84
БД - MySQL
Предметная область Provider, Client.
## Конфигурация приложения 
Конфигурационный файл для Spring Framework applicationContext.xml

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
DataSource:
```
<bean id="dataSource" class="org.springframework.jdbc.datasource.DriverManagerDataSource">
        <property name="driverClassName" value="com.mysql.cj.jdbc.Driver" />
        <property name="url" value="jdbc:mysql://localhost:3306/esalab3" />
        <property name="username" value="root" />
        <property name="password" value="root" />
    </bean>
```
SessionFactory:
```
<bean id="sessionFactory" class="org.springframework.orm.hibernate5.LocalSessionFactoryBean">
        <property name="dataSource" ref="dataSource" />
        <property name="annotatedClasses">
            <list>
                <value>com.example.esaSpring.entity.Provider</value>
                <value>com.example.esaSpring.entity.Client</value>
            </list>
        </property>
        <property name="hibernateProperties">
            <props>
                <prop key="hibernate.dialect">org.hibernate.dialect.MySQL8Dialect</prop>
                <prop key="hibernate.show_sql">true</prop>
                <prop key="hibernate.format_sql">false</prop>
                <prop key="hibernate.generate_statistics">true</prop>
            </props>
        </property>
    </bean>
```
TransactionManager:
```
<bean id="sessionFactory" class="org.springframework.orm.hibernate5.LocalSessionFactoryBean">
        <property name="dataSource" ref="dataSource" />
        <property name="annotatedClasses">
            <list>
                <value>com.example.esaSpring.entity.Provider</value>
                <value>com.example.esaSpring.entity.Client</value>
            </list>
        </property>
        <property name="hibernateProperties">
            <props>
                <prop key="hibernate.dialect">org.hibernate.dialect.MySQL8Dialect</prop>
                <prop key="hibernate.show_sql">true</prop>
                <prop key="hibernate.format_sql">false</prop>
                <prop key="hibernate.generate_statistics">true</prop>
            </props>
        </property>
    </bean>
```
