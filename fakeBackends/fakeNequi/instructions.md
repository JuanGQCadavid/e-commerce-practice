docker build --tag fakenequi .

docker run --publish 5001:5000 --detach --name nequi fakenequi