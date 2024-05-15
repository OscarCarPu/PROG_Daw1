# Ficheros

## Ficheros

```java
ObjectOutputStream output = new ObjectOutpuStream(Files.newOutputStream(Paths.get("archivo.txt")));
output.writeObject(Object);
output.writeInt();
output.close

ObjectInputStream input = new ObjectInputStream(Files.newInputStream(Paths.get("archivo.txt")));
Object o = (Object) input.readObject();
input.close();
```

# Bases de Datos

## JDBC

```java
JdbcRowSet rowSet;
try {
  //obtenemos el rowset de forma estatica
  rowSet = RowSetProvider.newFactory().createJdbcRowSet();
  rowSet.setUrl("jdbc:mysql://localhost:3306/Empresa");

  rowSet.setUsername("root");
  rowSet.setPassword("xxxxx");

  // Asignamos consulta y ejecutamos
  rowSet.setCommand("select * from employees");
  rowSet.execute();
}

while (rowSet.next()) {
  System.out.println("Id: "  + rowSet.getInt(1));
  System.out.println("Name: " + rowSet.getString(2));
  System.out.println("Posicion: " + rowSet.getString(3));
}
```
