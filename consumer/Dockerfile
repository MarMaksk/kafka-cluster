FROM openjdk:17-jdk-alpine

WORKDIR /app

# Копирование JAR-файла в контейнер
COPY consumer/build/libs/consumer-0.0.1-SNAPSHOT.jar consumer.jar

# Команда для запуска JAR-файла
CMD ["java", "-jar", "consumer.jar"]
