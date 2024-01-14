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
