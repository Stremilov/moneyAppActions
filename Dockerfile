# Используем официальный базовый образ OpenJDK 17 с Alpine Linux
FROM eclipse-temurin:17-jdk-alpine

# Создаем директорию для приложения
WORKDIR /app

# Создаем директорию для временных файлов
VOLUME /tmp

# Определяем аргумент для JAR файла
#ARG JAR_FILE=build/libs/*.jar

ARG JAR_FILE

# Копируем JAR файл в образ
COPY ${JAR_FILE} app.jar

# Устанавливаем переменную окружения для уменьшения времени ожидания
ENV JAVA_OPTS="-Djava.security.egd=file:/dev/./urandom"

# Определяем точку входа для запуска Spring Boot приложения
ENTRYPOINT ["sh", "-c", "java $JAVA_OPTS -jar /app/app.jar"]
