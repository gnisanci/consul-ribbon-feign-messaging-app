# <ins>Consul-Ribbon-Feign Message CRUD app</ins>  

. java 8 is required  
. ensure 8500, 8081, 8082 ports are not in use  

## Usage:  

1. run consul on terminal: consul agent -dev  
2. run internal app on terminal: ./gradlew bootRun  
3. run external app on terminal: ./gradlew bootRun  

consul web console: http://localhost:8500/ui/dc1/services  
external app url: http://localhost:8081/message/  
internal app url: http://localhost:8082/message/  

. app initially starts by loading 2 sample messages  
. uses in memory h2 database to store messages  

## Features:  

GET all messages  
http://localhost:8081/message/  

GET sample message 1  
http://localhost:8081/message/1  

POST new message  
http://localhost:8081/message/  
{
"message":"hello"
}

DELETE sample message 1  
http://localhost:8081/message/1  
