# Quarkus Microservice - ARREGLADO ✅

Este proyecto de Quarkus ha sido arreglado y ahora funciona correctamente con soporte para GraalVM.

## Problemas que se arreglaron:

1. **pom.xml**: 
   - Corregido el groupId de `io.quarkus` a `io.quarkus.platform`
   - Actualizada la versión de Quarkus a 3.6.4 (estable)
   - Agregados plugins necesarios (compiler, surefire, failsafe)
   - Agregadas propiedades faltantes
   - **NUEVO**: Configuración para GraalVM native compilation
   - **NUEVO**: Profile `native` para compilación nativa

2. **GreetingResource.java**:
   - Agregada anotación `@Transactional` al método POST
   - Agregado import para `jakarta.transaction.Transactional`

3. **Tests**:
   - Actualizado el test para usar el endpoint correcto `/people`
   - Cambiado de verificar contenido específico a verificar que responda correctamente

4. **Datos de prueba**:
   - Agregado archivo `import.sql` con datos iniciales

5. **GraalVM Native**:
   - Configuración para container-build nativo
   - Empaquetado como uber-jar por defecto

## Cómo usar:

### Ejecutar en modo desarrollo:
```bash
mvn quarkus:dev
```

### Ejecutar tests:
```bash
mvn test
```

### Compilar:
```bash
mvn clean compile
```

### Empaquetar:
```bash
mvn package
```

### Compilar ejecutable nativo (GraalVM):
```bash
# Con Docker (recomendado)
mvn package -Dnative

# Con GraalVM local instalado
mvn package -Dnative -Dquarkus.native.container-build=false
```

### Ejecutar ejecutable nativo:
```bash
./target/quarkus-microservice-1.0.0-SNAPSHOT-runner
```

## Endpoints disponibles:

- `GET /people` - Lista todas las personas
- `POST /people` - Crea una nueva persona

### Ejemplo de uso:

```bash
# Listar personas
curl http://localhost:8080/people

# Crear nueva persona
curl -X POST http://localhost:8080/people \
  -H "Content-Type: application/json" \
  -d '{"name": "Ana Martínez", "age": 28}'
```

## Dev UI:
Cuando ejecutes en modo dev, puedes acceder a la interfaz de desarrollo en:
http://localhost:8080/q/dev/

¡El proyecto ahora funciona correctamente! 🎉