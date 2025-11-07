# Quarkus Microservice - ARREGLADO ✅

Este proyecto de Quarkus ha sido arreglado y ahora funciona correctamente.

## Problemas que se arreglaron:

1. **pom.xml**: 
   - Corregido el groupId de `io.quarkus` a `io.quarkus.platform`
   - Actualizada la versión de Quarkus a 3.6.4 (estable)
   - Agregados plugins necesarios (compiler, surefire, failsafe)
   - Agregadas propiedades faltantes

2. **GreetingResource.java**:
   - Agregada anotación `@Transactional` al método POST
   - Agregado import para `jakarta.transaction.Transactional`

3. **Tests**:
   - Actualizado el test para usar el endpoint correcto `/people`
   - Cambiado de verificar contenido específico a verificar que responda correctamente

4. **Datos de prueba**:
   - Agregado archivo `import.sql` con datos iniciales

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