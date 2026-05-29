FROM eclipse-temurin:17

WORKDIR /app

COPY . .

RUN apt-get update && apt-get install -y maven

RUN mvn clean install -DskipTests -X

CMD java -jar target/*.jar
