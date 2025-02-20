# Franquicias
Api para CRUD de Franquicias

Esta api permite la creacion y modificacion de francias, sucursales y productos

Para correr el proyecto es necesario tener docker instalado 

Ubicado en la carpeta raiz del proyecto cambiar a la rama 
JPA-MySql con el siguiente comando
git checkout JPA-MySql

Luego ejecutar el siguiente comando
para construir el jar
.\gradlew build

En la misma carpeta correr el siguiente comando
para crear la imagen de docker

docker build -t springio/franchiseapi .

Luego correr el siguiente comando para correr la imagen
Reemplazar los espacion con --- por la informacion contenida en el correo
docker run -p 8080:8080 -e DB_URL="---" -e DB_USERNAME="---" -e DB_PASSWORD="---" springio/franchiseapi

Finalmente se añade un archivo json para ser importado en Postman o cualquier
gestor 