CREATE DATABASE proyectoIntegrador
character set Latin1
collate latin1_spanish_ci;
use proyectoIntegrador;

create table polideportivo (
nombre_polideportivo varchar (80),
telefono varchar (15),
poblacion varchar (30),
primary key (nombre_polideportivo)
)engine=innodb;

create table deportes (
codigo_deporte int AUTO_INCREMENT,
nombre_deporte varchar (15),
primary key (codigo_deporte)
)engine=innodb;

create table users (
usr varchar(30),
nombre varchar (30),
apellidos varchar (30),
telefono varchar (15),
email varchar (30),
poblacion varchar (30),
fecha_nacimiento varchar (30),
rol varchar (20),
pwd varchar(30),
estado varchar(11),
codigo_recuperacion int,
primary key (usr)
)engine=innodb;



create table Eventos (
codigo_evento int AUTO_INCREMENT,
fecha varchar (15),
hora varchar (15),
polideportivo varchar (80),
nivel varchar(15),
codigo_deporte int,
primary key (codigo_evento),
foreign key (codigo_deporte) references DEPORTES (codigo_deporte)
ON UPDATE CASCADE ON DELETE RESTRICT  
-- On update cascade ya que al actualizar el deporte se actualiza en eventos.
-- On delete restrict ya que no permitimos el borrado del deporte.
)engine=innodb;

create table Foro (
codigo_foro int AUTO_INCREMENT,
codigo_evento int,
primary key (codigo_foro),
foreign key (codigo_evento) references EVENTOS (codigo_evento)
ON UPDATE CASCADE ON DELETE CASCADE
-- On update cascade ya que al actualizar un campo se actualiza también en la otra tabla.
-- On delete cascade ya que al borrar un campo se borra también en la otra tabla.
)engine=innodb;

create table Mensaje (
codigo_mensaje int AUTO_INCREMENT,
mensaje text,
codigo_foro int,
usr varchar(30),
primary key (codigo_mensaje),
foreign key (codigo_foro) references FORO (codigo_foro)
ON UPDATE CASCADE ON DELETE CASCADE,
-- On update cascade ya que al actualziar un foro se actualizan sus mensajes.
-- On delete cascade ya que al borrar un foro se borran también sus mesnajes.
foreign key (usr) references users (usr)
ON UPDATE CASCADE ON DELETE SET NULL
-- On update cascade ya que al actualizar un usuario se actualiza también en mensajes.
-- On delete cascade set null ya que al borrar un usuario su codigo queda en null en mensaje.
)engine=innodb;

create table users_Eventos (
usr varchar(30),
codigo_evento int,
primary key (usr, codigo_evento),
foreign key (usr) references users (usr)
ON UPDATE CASCADE ON DELETE CASCADE,
-- On update cascade ya que al actualizar un campo del usuario se actualiza también en la reserva.
-- On delete cascade ya que al borrar un campo del usuario se borra también en la reserva.
foreign key (codigo_evento) references  EVENTOS (codigo_evento)
ON UPDATE CASCADE ON DELETE CASCADE
-- On update cascade ya que al actualizar un campo del evento se actualiza también en la reserva.
-- On delete cascade ya que al borrar un campo del evento se borra también en la reserva.
)engine=innodb;

create table Polideportivo_Deportes (
nombre_polideportivo varchar (80),
codigo_deporte int,
primary key (nombre_polideportivo, codigo_deporte),
foreign key (nombre_polideportivo) references POLIDEPORTIVO (nombre_polideportivo)
ON UPDATE RESTRICT ON DELETE RESTRICT,
-- On update restrict ya que no permitimos actualizar casuisticas del polideportivo.
-- On delete restrict ya que no permitimos borrar la practica del deporte.
foreign key (codigo_deporte) references  DEPORTES (codigo_deporte)
ON UPDATE CASCADE ON DELETE CASCADE
-- On update cascade ya que al actualizar un campo se actualiza también en la práctica.
-- On delete cascade ya que al borrar un campo se borra también en su práctica.
)engine=innodb;


-- INSERTAMOS DATOS DE USUARIOS:
INSERT INTO users VALUES ('DGP', 'Daniel','González Pérez','656345678','dangonper@hotmail.com','Villalba','20 jun 2000', 'usuario', 'dangonper', 'activo', null);
INSERT INTO users VALUES ('JPR','José','Pascual Rodríguez','658902345','joparod@gmail.com','Galapagar','10 jun 2003','usuario', 'joparod', 'inactivo', null);
INSERT INTO users VALUES ('IMG','Inés','Martínez Gutiérrez','656882675','inmargut@gmail.com','Las Rozas','08 jul 2005', 'usuario', 'inmargut', 'activo', null);
INSERT INTO users VALUES ('RRM','Rodrigo','Rodríguez Moreno','659382245','rodromo@gmail.com','Torrelodones','21 ene 2003', 'usuario', 'rodromo', 'activo', null);
INSERT INTO users VALUES ('MSE','María','Saldaña Espinosa','651923490','masalesp@yahoo.es','Villalba','10 sep 2000', 'usuario', 'masalesp', 'activo', null);
INSERT INTO users VALUES ('PFO','Pedro','Flores Ortiz','659912456','peflortiz@yahoo.es','Majadahonda','14 mar 2002', 'usuario', 'peflortiz', 'activo', null);
INSERT INTO users VALUES ('JPS','Susana','Benitez Prado','651123987','subepra@gamil.com','Galapagar','12 oct 2000', 'usuario', 'subepra', 'activo', null);
INSERT INTO users VALUES ('CAE','Clara','Alonso Espina','652345768','clalonespi@yahoo.es','Villalba','10 ago 1990', 'usuario', 'clalonespi', 'activo', null);
INSERT INTO users VALUES ('NSF','Nacho','Sánchez Fernández','650234566','nasafer@hotmail.com','Villalba','10 sep 1990', 'usuario', 'nasafer', 'activo', null);
INSERT INTO users VALUES ('SPS','Santiago','Pazos Segura','651234567','sanpase@gmail.com','Galapagar','14 feb 1994', 'usuario', 'sanpase', 'activo', null);
INSERT INTO users VALUES ('MCP','Martin','Cuentos Pérez','652543196','marcupe@yahoo.es','Las Rozas','10 jul 1992', 'usuario', 'marcupe', 'activo', null);
INSERT INTO users VALUES ('MCPI','Marta','Claras Pinto','647890234','marclapi@yahoo.es','Las Rozas','12 jul 1994', 'usuario', 'marclapi', 'activo', null);
INSERT INTO users VALUES ('PVGHA','Paula','Vía Gómez','634781233','pauvigo@hotmail.com','Torrelodones','08 jul 1987', 'usuario', 'pauvigo', 'activo', null);
INSERT INTO users VALUES ('RRLOP','Rocío','Romero López','672345908','rorolop@hotmail.ccom','Pozuelo','06 ago 1990', 'usuario', 'rorolop', 'activo', null);
INSERT INTO users VALUES ('PRRAM','Paula','Ruiz Ramírez','623098123','paururam@gmail.com','Pozuelo','28 sep 1992', 'usuario', 'paururam', 'activo', null);
INSERT INTO users VALUES ('MRPIE', 'Miguel','Ramírez Pérez','678120090','miraper@yahoo.es','Torrelodones','13 ene 1992', 'usuario', 'miraper', 'activo', null);
INSERT INTO users VALUES ('JCMUÑ', 'Jose','Cruz Muñoz','675998877','joscrumu@hotmail.com','Galapagar','14 feb 1993', 'usuario', 'joscrumu', 'activo', null);
INSERT INTO users VALUES ('MSALON', 'Mar','Silva Alonso','623445566','marsial@yahoo.es','Torrelodones','15 mar 1984', 'usuario', 'marsial', 'activo', null);
INSERT INTO users VALUES ('SSCRT', 'Sofía','Soto Contreras','609876161','sosocon@hotmail.com','Villalba','16 abr 1982', 'usuario', 'sosocon', 'activo', null);
INSERT INTO users VALUES ('LTHSER', 'Lidia','Torres Hernández','690324532','litoher@gmail.com','Galapagar','17 may 1982', 'usuario', 'litoher', 'activo', null);
INSERT INTO users VALUES ('CFCASR', 'Carmen','Flores Castillo','675123432','cafloca@yahoo.es','Las Rozas','19 abr 1983', 'usuario', 'cafloca', 'activo', null);
INSERT INTO users VALUES ('MVPIZA', 'Marco','Valenzuela Pizarro','619830234','marvapi@yahoo.es','Las Rozas','11 oct 1996', 'usuario', 'marvapi', 'activo', null);
INSERT INTO users VALUES ('FRDIZ', 'Francis','Rojas Díaz','657890000','frarodi@hotmail.com','Torrelodones','02 jul 1994', 'usuario', 'frarodi', 'activo', null);
INSERT INTO users VALUES ('ARMIS','Aaron','Ramírez Fuentes','657121213','aarramfu@hotmail.ccom','Pozuelo','02 dic 1987', 'usuario', 'aarramfu', 'activo', null);
INSERT INTO users VALUES ('SMBEN', 'Sergio','Morales Benitez','626982314','semobe@gmail.com','Pozuelo','03 sep 1995', 'usuario', 'semobe', 'activo', null);
INSERT INTO users VALUES ('IJVER', 'Israel','Jara Vergara','656098710','isjave@yahoo.es','Torrelodones','02 nov 1988', 'usuario', 'isjave', 'activo', null);
INSERT INTO users VALUES ('LMCUER', 'Lucía','Miranda Cuervo','610232123','lumicu@hotmail.com','Galapagar','11 nov 1997', 'usuario', 'lumicu', 'activo', null);
INSERT INTO users VALUES ('SCFIER', 'Silvia','Campos Figueroa','689098909','silcafi@yahoo.es','Torrelodones','20 nov 1992', 'usuario', 'silcafi', 'activo', null);
INSERT INTO users VALUES ('GRSAL', 'Ramón','Garrido Salazar','651234567','ragasa@gmail.com','Galapagar','23 jul 1998', 'usuario', 'ragasa', 'activo', null);
INSERT INTO users VALUES ('LAROME', 'Luis','Alarcón Romero','652543196','lualro@yahoo.es','Las Rozas','10 oct 1987', 'usuario', 'lualro', 'activo', null);
INSERT INTO users VALUES ('MVCAC', 'Marcos','Vázquez Cáceres','647890234','mavaca@yahoo.es','Las Rozas','03 ene 1982', 'usuario', 'mavaca', 'activo', null);
INSERT INTO users VALUES ('POSANDO', 'Paula','Orellana Sandoval','634781233','paorsa@hotmail.com','Torrelodones','29 ago 1992', 'usuario', 'paorsa', 'activo', null);
INSERT INTO users VALUES ('INAAGUI', 'Inés','Aguilera Aravena','672345908','inagar@hotmail.ccom','Pozuelo','20 feb 1988', 'usuario', 'inagar', 'activo', null);
INSERT INTO users VALUES ('AELIV','Aureo','Escobar Leiva','623098123','auesle@gmail.com','Pozuelo','11 ene 1995', 'usuario', 'auesle', 'activo', null);
INSERT INTO users VALUES ('FRPER', 'Fernando','Ruiz Pérez','678120090','ferrupe@yahoo.es','Torrelodones','13 mar 1998', 'usuario', 'ferrupe', 'activo', null);
INSERT INTO users VALUES ('PVMOL', 'Pilar','Vega Molina','675998877','pivemo@hotmail.com','Galapagar','10 jul 1992', 'usuario', 'pivemo', 'activo', null);
INSERT INTO users VALUES ('NGMIOE', 'Natalia','García Molinero','623445566','nagamo@yahoo.es','Torrelodones','12 feb 1995', 'usuario', 'nagamo', 'activo', null);
INSERT INTO users VALUES ('IVMOLI', 'Iván','Vera Molina','650234566','ivavemo@hotmail.com','Villalba','13 sep 1999', 'usuario', 'ivavemo', 'activo', null);
INSERT INTO users VALUES ('PSMOLI', 'Pablo','Sánchez Molina','623400066','pasmoo@yahoo.es','Torrelodones','12 ago 1992', 'usuario', 'pasmoo', 'activo', null);
INSERT INTO users VALUES ('IVAGASA', 'Iván','Agapito Sanchez','600234500','ivagasa@hotmail.com','Villalba','23 jun 1980', 'usuario', 'ivagasa', 'activo', null);
INSERT INTO users VALUES ('JCPEREZ', 'Juan','Carlos Pérez','656000000','nuestraapp@hotmail.com','Villalba','14 jun 1988', 'administrador', 'nuestraapp', 'activo', null);
INSERT INTO users VALUES ('PGLOPEZ', 'Pedro','González López','656000000','nuestraapp@hotmail.com','Villalba','24 sep 1990', 'administrador', 'nuestraapp', 'activo', null);
INSERT INTO users VALUES ('JGGRANGE', 'Javier','Guerra Grange','656000000','nuestraapp@hotmail.com','Villalba','18 ene 1999', 'administrador', 'nuestraapp', 'activo', null);
INSERT INTO users VALUES ('APRIVAS', 'Álvaro','Pérez Rivas','656000000','nuestraapp@hotmail.com','Villalba','23 ago 1998', 'administrador', 'nuestraapp', 'activo', null);
INSERT INTO users VALUES ('JMMORENO', 'Jaime','Martí Moreno','656000000','nuestraapp@hotmail.com','Villalba','28 feb 1999', 'administrador', 'nuestraapp', 'activo', null);

-- INSERTAMOS DATOS DE POLIDEPORTIVO:
INSERT INTO polideportivo VALUES ('Enrique Blas','918505311','Villalba');
INSERT INTO polideportivo VALUES ('Ciudad Deportiva Collado Villalba','918684727','Villalba');
INSERT INTO polideportivo VALUES ('Galapagar Sports','918587800','Galapagar');
INSERT INTO polideportivo VALUES ('Gal-full stadium','918524567','Galapagar');
INSERT INTO polideportivo VALUES ('Dehesa de Navalcarbón','917579811','Las Rozas');
INSERT INTO polideportivo VALUES ('El Abajón','917893423','Las Rozas');
INSERT INTO polideportivo VALUES ('Torre Más Deportes','918592487','Torrelodones');
INSERT INTO polideportivo VALUES ('Torre Club','918567821','Torrelodones');
INSERT INTO polideportivo VALUES ('Príncipe Felipe','916389065','Majadahonda');
INSERT INTO polideportivo VALUES ('La Granadilla','918345687','Majadahonda');
INSERT INTO polideportivo VALUES ('El Torreón','918234109','Pozuelo');
INSERT INTO polideportivo VALUES ('Valle de las Cañas','918324501','Pozuelo');

-- INSERTAMOS DATOS DE DEPORTES:
INSERT INTO deportes VALUES (null, 'Fútbol');
INSERT INTO deportes VALUES (null, 'Baloncesto');
INSERT INTO deportes VALUES (null, 'Tenis');
INSERT INTO deportes VALUES (null, 'Padel');

-- INSERTAMOS EVENTOS:
INSERT INTO Eventos VALUES (null, '28 oct 2022', '18:00', 'Enrique Blas', 'Avanzado', 1);
INSERT INTO Eventos VALUES (null, '20 ago 2022', '15:00', 'La Granadilla', 'Principiante', 1);
INSERT INTO Eventos VALUES (null, '24 sep 2022', '20:00', 'El Torreón', 'Medio', 1);
INSERT INTO Eventos VALUES (null, '18 jul 2022', '19:00', 'Enrique Blas', 'Avanzado', 1);
INSERT INTO Eventos VALUES (null, '28 jun 2022', '18:00', 'El Torreón', 'Principiante', 1);
INSERT INTO Eventos VALUES (null, '23 jul 2022', '15:00', 'La Granadilla', 'Principiante', 1);

INSERT INTO Eventos VALUES (null, '19 jul 2022', '18:00', 'El Torreón', 'Principiante', 2);
INSERT INTO Eventos VALUES (null, '18 ago 2022', '15:00', 'La Granadilla', 'Principiante', 2);
INSERT INTO Eventos VALUES (null, '08 jul 2022', '18:00', 'Enrique Blas', 'Avanzado', 2);
INSERT INTO Eventos VALUES (null, '13 jun 2022', '15:00', 'La Granadilla', 'Principiante', 2);
INSERT INTO Eventos VALUES (null, '12 jul 2022', '20:00', 'El Torreón', 'Medio', 2);
INSERT INTO Eventos VALUES (null, '11 jun 2022', '19:00', 'Enrique Blas', 'Avanzado', 2);

INSERT INTO Eventos VALUES (null, '11 ago 2022', '19:00', 'Enrique Blas', 'Avanzado', 3);
INSERT INTO Eventos VALUES (null, '02 jul 2022', '18:00', 'El Torreón', 'Principiante', 3);
INSERT INTO Eventos VALUES (null, '04 jul 2022', '18:00', 'Enrique Blas', 'Avanzado', 3);
INSERT INTO Eventos VALUES (null, '05 oct 2022', '15:00', 'La Granadilla', 'Principiante', 3);
INSERT INTO Eventos VALUES (null, '12 jul 2022', '20:00', 'El Torreón', 'Medio', 3);
INSERT INTO Eventos VALUES (null, '13 sep 2022', '15:00', 'La Granadilla', 'Principiante', 3);

INSERT INTO Eventos VALUES (null, '10 sep 2022', '19:00', 'Enrique Blas', 'Avanzado', 4);
INSERT INTO Eventos VALUES (null, '12 jul 2022', '18:00', 'El Torreón', 'Principiante', 4);
INSERT INTO Eventos VALUES (null, '10 ago 2022', '15:00', 'La Granadilla', 'Principiante', 4);
INSERT INTO Eventos VALUES (null, '02 ago 2022', '18:00', 'Enrique Blas', 'Avanzado', 4);
INSERT INTO Eventos VALUES (null, '24 jun 2022', '15:00', 'La Granadilla', 'Principiante', 4);
INSERT INTO Eventos VALUES (null, '28 jun 2022', '20:00', 'El Torreón', 'Medio', 4);


-- INSERTAMOS MENSAJES:
INSERT INTO Foro VALUES (1, 1);
INSERT INTO Mensaje VALUES (null, 'Hola, yo llevo el balón', 1, 'FRPER');
INSERT INTO Mensaje VALUES (null, 'Ok, genial', 1, 'ARMIS');
INSERT INTO Mensaje VALUES (null, 'Nos vemos allí a las 18:00', 1, 'JCMUÑ');

-- INSTRUCCIONES NECESARIAS POR CADA PANTALLA DE LA APP:

-- BIENVENIDO:
-- A continuación se muestran las SELECT necesarias para recoger y posteriormente comparar los datos:
-- 'SELECT usr FROM users WHERE usr=?', usr, "usr"
-- 'SELECT pwd FROM users WHERE usr=?', usr, "pwd"
-- 'SELECT rol FROM users WHERE usr=?', usr, "rol"

-- BINEVENIDO ADMIN:
update users set estado = 'inactivo' where usr = 'IMG'; -- Ejemplo 'JPR'. Dejariamos bloqueado a este usuario.
update users set estado = 'activo' where usr = 'IMG'; -- Ejemplo 'JPR'. Volveríamos a dejar activo a este usuario.

-- REGISTRARSE:
select usr from users where usr = 'RPSANT'; -- Comprueba si está el nickname 
INSERT INTO users VALUES ('RPSANT', 'Rodrigo','Pintos Santos','657890909','rpsant@hotmail.com','Torrelodones','28 oct 1996', 'usuario', 'rpsnt', 'activo', null); -- Inserta si no está
-- Si está, error

-- RECUPERAR CONTRASEÑA:
select email from users where email = 'frarodi@hotmail.com'; -- Comprueba si está email (está)
select email from users where email = 'frarodindo@hotmail.com';  -- Comprueba si está email (no está)
update users set codigo_recuperacion = 12345 where email = 'frarodi@hotmail.com'; -- si está, update
select codigo_recuperacion from users where email = 'frarodi@hotmail.com' && codigo_recuperacion = 12345; -- es codigo
select codigo_recuperacion from users where email = 'frarodi@hotmail.com' && codigo_recuperacion = 12346; -- no es codigo

-- NUEVA CONTRASEÑA:
update users set pwd = 34567 where email = 'frarodi@hotmail.com'; -- ejemplo contraseña: 34567
update users set codigo_recuperacion = null where email = 'frarodi@hotmail.com';

-- TU PERFIL:
select usr, nombre, apellidos, telefono, email, poblacion, fecha_nacimiento from users;
update users set usr = 'Jose10', nombre = 'Jose', apellidos = 'Romero Saldaña', 
telefono = 656721212, email = 'jorosald@hotmail.com', poblacion = 'Torrelodones', 
fecha_nacimiento = '14 jun 1989' where usr = 'IVAGASA'; -- Ejemplo codigo: 40

delete from users WHERE usr = 'NGMIOE'; -- Este para la basura. Usuario desaparece en eventos.

-- EVENTOS DISPONIBLES:
insert into users_eventos values ('PVMOL', 3); -- Insertar usuario en el evento. 
insert into users_eventos values ('PVMOL', 4);
insert into users_eventos values ('LAROME', 3);

select nombre_deporte, polideportivo, fecha, hora, nivel from deportes 
inner join eventos on deportes.codigo_deporte = eventos.codigo_deporte
inner join users_eventos on eventos.codigo_evento = users_eventos.codigo_evento
where deportes.codigo_deporte = 3; -- Mostrar la info de todos los eventos de ese deporte.

select codigo_evento, COUNT(usr) from users_eventos   -- Mostrar número usuarios del evento.
where codigo_evento = 3 group by codigo_evento;

-- MIS EVENTOS:
select eventos.codigo_evento, nombre_deporte, polideportivo, fecha, hora, nivel from deportes 
inner join eventos on deportes.codigo_deporte = eventos.codigo_deporte
inner join users_eventos on eventos.codigo_evento = users_eventos.codigo_evento
where users_eventos.usr = 'LAROME'; -- Mostrar la info del evento.

select codigo_evento, COUNT(usr) from users_eventos   -- Mostrar número usuarios del evento.
where codigo_evento = 3 group by codigo_evento;

delete from users_eventos WHERE codigo_evento = 1 && usr = 'LAROME'; -- Este para la basura. Eliminas el evento seleccionado
 
-- FORO:
select users.usr, mensaje from mensaje inner join users on mensaje.usr = users.usr 
where codigo_foro = 1; -- Sacar nombre usuario y mensaje
insert into Mensaje VALUES (null, 'Recordad que yo me iré antes', 1, 'FRPER'); -- Guardar nuevo mensaje en ese foro
select users.usr, mensaje from mensaje inner join users on mensaje.usr = users.usr
where codigo_foro = 1; -- Actualizar mensajes 

-- CREAR EVENTO:
INSERT INTO Eventos VALUES (null, '20 jun 2022', '12:00', 'El Torreón', 'Medio', 3);
INSERT INTO Eventos VALUES (null, '23 jun 2022', '10:00', 'Enrique Blas', 'Avanzado', 3);
INSERT INTO users_Eventos values ('RRLOP', 6); -- El que crea evento se une automaticamente
INSERT INTO users_Eventos values ('LTHSER', 7); -- Se une otro usuario.
-- INSERT INTO Foro values (null, 6); -- Al crear evento se genera foro.
-- INSERTS FORO

-- INSERTAMOS FORO:

INSERT INTO Foro VALUES (2, 2);
INSERT INTO Foro VALUES (3, 3);
INSERT INTO Foro VALUES (4, 4);
INSERT INTO Foro VALUES (5, 5);
INSERT INTO Foro VALUES (6, 6);
INSERT INTO Foro VALUES (7, 7);
INSERT INTO Foro VALUES (8, 8);
INSERT INTO Foro VALUES (9, 9);
INSERT INTO Foro VALUES (10, 10);
INSERT INTO Foro VALUES (11, 11);
INSERT INTO Foro VALUES (12, 12);
INSERT INTO Foro VALUES (13, 13);
INSERT INTO Foro VALUES (14, 14);
INSERT INTO Foro VALUES (15, 15);
INSERT INTO Foro VALUES (16, 16);
INSERT INTO Foro VALUES (17, 17);
INSERT INTO Foro VALUES (18, 18);
INSERT INTO Foro VALUES (19, 19);
INSERT INTO Foro VALUES (20, 20);
INSERT INTO Foro VALUES (21, 21);
INSERT INTO Foro VALUES (22, 22);
INSERT INTO Foro VALUES (23, 23);
INSERT INTO Foro VALUES (24, 24);
INSERT INTO Foro VALUES (25, 25);



-- INSERT INTO Foro values (null, 6); -- Al crear evento se genera foro.
-- drop database proyectoIntegrador;