FROM openjdk:17.0.1 as  builder
WORKDIR /app/servio-producto 

COPY ./pom.xml /app
COPY ./.mvn ./.mvn
COPY ./mvnw .
COPY ./pom.xml .

RUN ./mvnw clean package -Dmaven.test.skip -Dmaven.main.skip -Dspring-boot.repackage.skip && rm -r ./target/

COPY ./src ./src

RUN ./mvnw clean package -DskipTests
#FROM openjdk:17.0.1
#WORKDIR / app
RUN mkdir ./logs
#COPY --from=builder /app/msvc-usuarios/target/msvc-usuarios-0.0.1-SNAPSHOT.jar .
#EXPOSE 8002
CMD ["java", "-jar", "./target/ValorMaximo-0.0.1-SNAPSHOT.jar"]