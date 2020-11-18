## Configuración de persistence con Glassfish
1. Entrar a `http://localhost:4848`
2. Click en JDBC -> JDBC Connection Pools -> New Pool
3. Nombrar pool `TallerPool`, con resource type `javax.sql.ConnectionPoolDataSource`
4. En **General**, el **Datasource Classname** debe ser `com.mysql.cj.jdbc.MysqlDataSource`
5. Las propiedades adicionales son las siguientes

| serverTimezone  | useTimezone  | useSSL  | password  | databaseName  | serverName |        datasourceName       | user | portNumber |
|-----------------|--------------|---------|-----------|---------------|------------|-----------------------------|------|------------|
|      UTC        |      true    |  false  |   root    |     mydb      |  localhost | com.cj.jdbc.MysqlDataSource | root |   3306     |

6. Click en JDBC -> JDBC Resources -> New
7. Nombrar el recurso `jdbc/TallerDb` y seleccionar el pool `TallerPool`
