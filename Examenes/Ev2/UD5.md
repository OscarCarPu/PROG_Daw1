# UD5 - Arrays
## Trabajar con Fechas
### Clase Date
```java
import java.util.Date;

```
Constructores
```java
Date(); //fecha actual
Date(y,m,d); // (1900+y)/m/d   Los meses están en 0-index
Date(y,m,d,h,m,s); // (1900+y)/m/d H:m:s
System.out.println(new Date()); // Thu Mar 07 23:47:13 CET 2024
```
Metodos para obtener cada valor
```java
fecha.getYear() // 124
fecha.getMonth() // 2
fecha.getDate() // 7
fecha.getDay() // 4
fecha.getHours() // 23
fecha.getMinutes() // 47
fecha.getSeconds() // 13
```
Metodos para comparar fechas
```java
fecha.after(Date d)
fecha.befor(Date a)
```
### Paquete Time
Principales clases
```java
import java.time.*;
```
- **LocalDate**: Fecha sola
- **LocalTime**: Hora sola
- **LocalDateTime**: Fecha y hora
- **Instant**: Timestamp UNIX (nanosegundos)
- **ZonedDateTime**: LocalDateTime teniendo en cuenta zonas horarias
- **Period**: Diferencias entre fechas
- **Duration**: Period pero solo para horas

Construynedo fechas y horas

- now() &rarr; crea instancias a partir de la fecha y hora actual
- of() &rarr; construye una fecha a partir de parametros dependiendo de la clase
- with() &rarr; modifica la fecha actual con los parametros que se le pase

Existen getters de cada parte de la fecha

Existen metodos para hacer operaciones con las fechas:
- plusDays() / minusDays()
- plusWeeks() / minusWeeks()
- plusMonths() / minusMonths()
- plusYears() / minusYears()

## Arrays Unidimensionales

