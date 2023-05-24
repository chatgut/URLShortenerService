In order to start the application then you need a Redis Container.

docker pull redis:latest

docker run -d --name=redis -p 6379:6379 redis

To Post in insomnia.
http://localhost:8080/urlShortener
Body: Json
{
    "url":"{The long url here}"
}
Then you will get back the short url.
