# Usar uma imagem leve do JDK 17
FROM eclipse-temurin:17-jre

# Definir o diretório de trabalho dentro do container
WORKDIR /ac2

# Copiar o arquivo .jar gerado para o diretório do container
COPY target/*.jar /ac2/ac2-0.0.1-SNAPSHOT.jar

EXPOSE 8585

# Comando para executar a aplicação com Java 17
CMD ["java", "-jar", "ac2.ac2-0.0.1-SNAPSHOT.jar"]
