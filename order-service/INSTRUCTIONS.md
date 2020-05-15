mvn clean package
docker build -t orders:1.0 .
docker run -d -p 8080:8080 --name order-services orders:1.0