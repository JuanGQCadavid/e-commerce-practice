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

docker stop fake-card-server
docker rm fake-card-server

docker build -t fake-card-img .

docker run --name fake-card-server \
    -p 8080:8080\
    -d \
    fake-card-img