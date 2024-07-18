docker run --name mysql-container -e MYSQL_ROOT_PASSWORD=binod -p 3306:3306-d mysql:latest

docker exec -it mysql-container mysql -u root -p

