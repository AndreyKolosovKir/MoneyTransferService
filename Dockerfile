FROM khipu/openjdk17-alpine

EXPOSE 5500

COPY target/MoneyTransferService-0.0.1-SNAPSHOT.jar app.jar

CMD ["java", "-jar", "app.jar"]