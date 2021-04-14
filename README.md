# Simulador de Cuotas

_Simulador de compras que permita a un usuario BCP saber las cuotas mensuales que deberá aportar luego de realizar una compra con su tarjeta BCP_


## Comenzando 🚀

_Estas instrucciones permitirán realizar la prueba: para esto se deberá solicitar al usuario su tipo de tarjeta, monto de compra, cuotas a financiar, tasa de interés, fecha de compra y día de pago_

```
Formulario:

{
    "dni": "99991111",
    "tarjeta":"BLACK",
    "moneda":"S/",
    "monto": "1000", 
    "cuota": "6", 
    "tea":"90.9%",
    "diaPago":"20"
}
```

```
Respuesta exitosa:

{
    "cuota": "200.41",
    "moneda": "S/",
    "primeraCuota": "20/05/2021",
    "estado": "exitoso"
}
```

```
Respuesta fallida:

{
    "estado": "fallido",
    "mensaje": "DNI no disponible"
}
```

```
Datos de Tareta:
- Clasica
- Oro
- Black
```

```
Cuotas:
de 1 a 36
```

```
Dias de pago:
5 o 20
```

```
TEA:
99.90%
95.90%
90.90%
```


### Pre-requisitos 📋

_Crear en MySQL la Base de Datos: **simuladordb** utilizar la clave que desee y actualizarlo en el archivo: **application.properties**_
_Crear las siguientes tablas para poder probar el proyecto:_

```
CREATE TABLE `tarjeta` (
  `id` int NOT NULL,
  `nombre` varchar(255) NOT NULL,
  `tasa` double NOT NULL,
  `tem` double NOT NULL,
  PRIMARY KEY (`id`)
```

```
CREATE TABLE `clitarj` (
  `dniCliente` varchar(8) NOT NULL,
  `idTarjeta` bigint NOT NULL,
  PRIMARY KEY (`dniCliente`,`idTarjeta`)
```

```
CREATE TABLE `cliente` (
  `DniCliente` int NOT NULL,
  `NombreCliente` varchar(45) NOT NULL,
  `ApellidoPatCliente` varchar(45) NOT NULL,
  `ApellidoMatCliente` varchar(45) NOT NULL,
  `EmailCliente` varchar(45) DEFAULT NULL,
  PRIMARY KEY (`DniCliente`)
```


## Ejecutando las pruebas ⚙️

_Ingresar a POSTMAN y en el Workspaces ingresar los siguientes endpoints:_

```
http://localhost:9090/api/tarjetas/v2

respuesta: la lista de los nombres y tea de las tarjetas de la tabla: tarjeta
```

```
http://localhost:9090/api/cuotas/calcular

respuesta: debera mostrar respuesta exitosa o respuesta fallida detallada en el punto Comenzando 
```


## Construido con 🛠️

* [Intellij IDEA](https://www.jetbrains.com/es-es/idea/) - IDE para JVM eficaz y ergonomico
* [Maven](https://maven.apache.org/) - Manejador de dependencias
* [Postman](https://www.postman.com/) - Plataforma de colaboracion para el desarrollo de API

