# DevEnterprise OS · Parcial 1 de Arquitectura de Software

Parcial elaborado por **Santiago Ruiz** y **Juan Calderon**.

Prototipo funcional en Java generado a partir del diagrama de clases UML de *DevEnterprise OS*. Implementa las 66 interfaces, clases abstractas, clases y enumeraciones del diagrama, organizadas en cinco bloques que aplican 12 patrones de diseño y los principios SOLID.

Los métodos no tienen lógica de negocio compleja ni persistencia: ejecutan código básico e imprimen mensajes (`[Clase] ...`) para mostrar el flujo de ejecución. Las integraciones externas (Google Calendar, Outlook y los entornos de prueba Web, Mobile y Cloud) son **teóricas**: solo imprimen que se están conectando o cargando.

## Diagrama UML

[![Diagrama de clases de DevEnterprise OS](DevEnterprise%20OS-Evaluacion.drawio.svg)](DevEnterprise%20OS-Evaluacion.drawio.svg)

> Haz clic en el diagrama para abrirlo a tamaño completo. El archivo `.drawio.svg` también puede abrirse y editarse en [draw.io](https://app.diagrams.net).

## Estructura del proyecto

```
src/deventerprise/
├── Main.java            Demo: solo depende de DevEnterpriseFacade
├── proyectos/           Bloque 1 · Composite, Strategy, Observer
├── personal/            Bloque 2 · Decorator, State
├── calidad/             Bloque 3 · Chain of Responsibility, Abstract Factory
├── bitacora/            Bloque 4 · Command, Mediator
└── infraestructura/     Bloque 5 · Adapter, Singleton, Facade
```

| Bloque | Patrón | Clases principales | Problema que resuelve |
|---|---|---|---|
| 1 · Gestión de proyectos | Composite | `ComponenteProyecto`, `ComponenteCompuesto`, `Proyecto`, `Fase`, `Tarea`, `SubTarea` | El proyecto es un árbol y cada nivel calcula su costo y tiempo sumando el de sus hijos. |
| | Strategy | `EstrategiaEstimacion`, `PorHoras`, `PorPuntosFuncion` | Cambiar en ejecución la metodología de estimación. |
| | Observer | `ObservadorTarea`, `LiderProyecto`, `Cliente` | Cuando una tarea pasa a `COMPLETADO` se notifica al líder y al cliente. |
| 2 · Manejo de personal | Decorator | `ResponsabilidadDecorator`, `LiderTecnico`, `SoporteFinSemana`, `Mentor` | Responsabilidades temporales que suman salario y permisos y se pueden encadenar. |
| | State | `EstadoEmpleado`, `Disponible`, `AsignadoProyecto`, `EnLicencia` | El estado del empleado decide si puede recibir asignaciones y a qué estado pasa. |
| 3 · Calidad y pruebas | Chain of Responsibility | `FasePrueba`, `AnalisisEstatico`, `PruebasUnitarias`, `PruebasIntegracion`, `PruebasSeguridad` | Las fases se ejecutan en secuencia y el pipeline se detiene si una falla. |
| | Abstract Factory | `FabricaPruebas`, `FabricaWeb`, `FabricaMobile`, `FabricaCloud` y sus paquetes | Cada tecnología crea su propia familia de paquetes de prueba. |
| 4 · Bitácora y cambios | Command | `Comando`, `AgregarRequerimiento`, `ModificarRequerimiento`, `EliminarRequerimiento`, `GestorCambios` | Los cambios pedidos en un acta se ejecutan como comandos y se deshacen si el acta no se firma. |
| | Mediator | `MediadorProyecto`, `MediadorCentral`, `BitacoraReuniones`, `Cronograma`, `NotificadorDesarrolladores` | Coordina bitácora, cronograma y notificaciones sin acoplarlos entre sí. |
| 5 · Infraestructura | Adapter | `ServicioCalendario`, `GoogleCalendarAdapter`, `OutlookAdapter` | Unifica las APIs de Google Calendar y Outlook detrás de una sola interfaz. |
| | Singleton | `ConfiguracionSistema` | Una sola configuración global y una sola conexión al calendario. |
| | Facade | `DevEnterpriseFacade` | Punto de entrada sencillo que coordina todos los bloques. |

## Requisitos

- JDK 17 o superior (probado con OpenJDK 21).

## Compilar y ejecutar

Desde la raíz del proyecto:

```bash
javac -d out $(find src -name '*.java')
java -cp out deventerprise.Main
```

## Flujo de la demo

`Main` usa solamente la fachada `DevEnterpriseFacade` y recorre los cinco bloques en este orden:

1. **Inicialización:** se crea la configuración única del sistema (Singleton), se conecta Google Calendar a través de su adaptador y se registran los colegas del mediador.
2. **Composite y Strategy:** se arma el proyecto *Portal Bancario* (Proyecto → Fase → Tarea → SubTarea) y se estima primero por horas y luego por puntos de función, cambiando la estrategia en ejecución.
3. **Observer:** al completar la tarea *Backend* se notifica al líder del proyecto y al cliente.
4. **Decorator y State:** se contratan empleados y se les agregan responsabilidades que suman salario y permisos. Al asignar un empleado al proyecto pasa de `Disponible` a `AsignadoProyecto`, y un segundo intento se rechaza.
5. **Chain of Responsibility y Abstract Factory:** se ejecuta el pipeline de pruebas para Web, Mobile y Cloud. Cada paquete simula la carga de su entorno.
6. **Command y Mediator:** un acta no firmada revierte sus cambios de requerimientos. Un acta firmada los conserva, y el mediador ajusta el cronograma y avisa al equipo.
7. **Adapter:** se cambia el calendario a Outlook sin modificar la bitácora.
8. **Command:** se deshace el último cambio desde el historial de `GestorCambios`.
