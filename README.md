In order to start the application then you need a Redis Container.

docker pull redis:latest

docker run -d --name=redis -p 6379:6379 redis

To Post in insomnia to the Redis server.
http://localhost:8080/urlShortener/{{the-long-name-on-url}}
Body: plain
The short url in the Body
