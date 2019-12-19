# Restaurant
1. Build code
- `cd $ROOT/app`
- `mvn clean install`
2. Build image
- `cd $ROOT`
- `docker-compose build`

3. Start server
- `cd $ROOT`
- `docker-compose up`

Access http://localhost:8080/restaurant/swagger-ui.html#/ to test REST api
