FROM tomcat:8.5

ENV http_proxy=http://10.10.10.10:8080/
ENV https_proxy=https://10.10.10.10:8080/

COPY ./target/restaurant-0.0.1-SNAPSHOT.war $CATALINA_HOME/webapps/restaurant.war 

EXPOSE 8080

CMD ["/usr/local/tomcat/bin/catalina.sh", "run"]