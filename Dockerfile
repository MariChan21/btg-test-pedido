# Use uma imagem base do OpenJDK para Java 11
FROM openjdk:17-alpine

# Defina o diretório de trabalho
WORKDIR /app

# Copie o arquivo JAR da sua aplicação Spring Boot para o contêiner
COPY target/btg-test-pedido.jar app.jar

# Execute a aplicação Spring Boot quando o contêiner iniciar
CMD ["java", "-jar", "app.jar"]

