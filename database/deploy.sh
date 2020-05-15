echo "Checking if docker is installed"
if ! [ -x "$(command -v docker)" ]; then
    echo "Install and start docker"
    yum update -y
    yum install -y docker
    service docker start
    usermod -a -G docker ec2-user
else
    echo 'Docker is installed'
fi


if ! [ -z "$(docker volume inspect mysql-db-data)" ]; then
    echo "Creating volumne"
    docker volume create mysql-db-data
else
    echo "Database volume already created"
fi

if  [ -z "$(docker inspect mysql-db)" ]; then
    echo "Removing old mysl-db"
    docker rm -f mysql-db
fi


docker run -d -p 3306:3306 --name mysql-db -e MYSQL_ROOT_PASSWORD=secret -v mysql-db-data:/var/lib/mysql mysql


