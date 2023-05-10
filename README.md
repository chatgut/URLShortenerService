In order to start the application then you need a Redis Container.

docker pull redis

docker run -d --name=redis -p 6379:6379 redis