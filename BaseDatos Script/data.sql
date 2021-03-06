--------------------------------------------------------
-- Archivo creado  - viernes-marzo-05-2021   
--------------------------------------------------------
REM INSERTING into PRUEBA2.ACTIVIDADES
SET DEFINE OFF;
Insert into PRUEBA2.ACTIVIDADES (ID,NOMBRE,FECHA,OBSERVACION,IDEVENTO) values (1,'Buscar Lugar',to_date('08/05/21','DD/MM/RR'),null,1);
Insert into PRUEBA2.ACTIVIDADES (ID,NOMBRE,FECHA,OBSERVACION,IDEVENTO) values (2,'Preparar equipo',to_date('10/05/21','DD/MM/RR'),null,1);
Insert into PRUEBA2.ACTIVIDADES (ID,NOMBRE,FECHA,OBSERVACION,IDEVENTO) values (3,'Armar escenario',to_date('11/05/21','DD/MM/RR'),null,1);
REM INSERTING into PRUEBA2.ACTIVIDADES_USUARIOS
SET DEFINE OFF;
Insert into PRUEBA2.ACTIVIDADES_USUARIOS (ID,IDUSUARIO,IDACTIVIDAD) values (1,1,1);
Insert into PRUEBA2.ACTIVIDADES_USUARIOS (ID,IDUSUARIO,IDACTIVIDAD) values (2,1,2);
Insert into PRUEBA2.ACTIVIDADES_USUARIOS (ID,IDUSUARIO,IDACTIVIDAD) values (3,4,1);
Insert into PRUEBA2.ACTIVIDADES_USUARIOS (ID,IDUSUARIO,IDACTIVIDAD) values (4,4,2);
REM INSERTING into PRUEBA2.CATEGORIAS
SET DEFINE OFF;
Insert into PRUEBA2.CATEGORIAS (ID,NOMBRE) values (1,'Fiesta');
Insert into PRUEBA2.CATEGORIAS (ID,NOMBRE) values (2,'Concierto');
REM INSERTING into PRUEBA2.EVENTOS
SET DEFINE OFF;
Insert into PRUEBA2.EVENTOS (ID,IDCATEGORIA,NOMBRE,OBSERVACIONES) values (1,1,'Evento de fiesta de san valentin',null);
Insert into PRUEBA2.EVENTOS (ID,IDCATEGORIA,NOMBRE,OBSERVACIONES) values (2,2,'Concierto La Capital',null);
REM INSERTING into PRUEBA2.ROLES
SET DEFINE OFF;
Insert into PRUEBA2.ROLES (ID,NOMBRE) values (1,'Manager');
Insert into PRUEBA2.ROLES (ID,NOMBRE) values (2,'Integrante');
REM INSERTING into PRUEBA2.USUARIOS
SET DEFINE OFF;
Insert into PRUEBA2.USUARIOS (ID,NOMBRE,CONTRASENIA,IDROL,FECHAVENCIMIENTO) values (1,'Jose','1234',1,to_date('08/03/21','DD/MM/RR'));
Insert into PRUEBA2.USUARIOS (ID,NOMBRE,CONTRASENIA,IDROL,FECHAVENCIMIENTO) values (4,'Juan','1234',1,to_date('05/03/21','DD/MM/RR'));
Insert into PRUEBA2.USUARIOS (ID,NOMBRE,CONTRASENIA,IDROL,FECHAVENCIMIENTO) values (7,'Elmer','12345',2,to_date('05/03/21','DD/MM/RR'));
