###############################################
# Etapa 1: Build nativo con GraalVM / Mandrel
###############################################
FROM quay.io/quarkus/ubi-quarkus-mandrel-builder-image:23.0-java17 AS build

# ⬇️ Escalamos permisos temporalmente a root para configurar /app
USER root
WORKDIR /app
COPY . .

# 🔧 Crea y da permisos al directorio target
RUN mkdir -p /app/target && chmod -R 777 /app

# ⬇️ Volvemos al usuario original (1001) para ejecutar Maven
USER 1001

# 🚀 Compila el binario nativo
RUN ./mvnw package -Pnative -DskipTests -Dquarkus.native.container-build=false -Dquarkus.native.native-image-xmx=4g


###############################################
# Etapa 2: Imagen final ultraligera
###############################################
FROM registry.access.redhat.com/ubi9/ubi-minimal:9.3
WORKDIR /work/

COPY --from=build /app/target/*-runner /work/application
RUN chmod 775 /work/application
EXPOSE 8080
USER 1001
ENTRYPOINT ["./application"]
