CREATE DATABASE Proyecto_Integrador
character set Latin1
collate latin1_spanish_ci;
use Proyecto_Integrador;

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

create table usuario (
codigo_usuario int AUTO_INCREMENT,
nombre_usuario varchar(30),
nombre varchar (30),
apellidos varchar (30),
telefono varchar (15),
email varchar (30),
poblacion varchar (30),
fecha_nacimiento varchar (15),
rol varchar (8),
contraseña varchar(30),
estado varchar(11),
codigo_recuperacion int,
primary key (codigo_usuario)
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
codigo_usuario int,
primary key (codigo_mensaje),
foreign key (codigo_foro) references FORO (codigo_foro)
ON UPDATE CASCADE ON DELETE CASCADE,
-- On update cascade ya que al actualziar un foro se actualizan sus mensajes.
-- On delete cascade ya que al borrar un foro se borran también sus mesnajes.
foreign key (codigo_usuario) references USUARIO (codigo_usuario)
ON UPDATE CASCADE ON DELETE SET NULL
-- On update cascade ya que al actualizar un usuario se actualiza también en mensajes.
-- On delete cascade set null ya que al borrar un usuario su codigo queda en null en mensaje.
)engine=innodb;

create table Usuario_Eventos (
codigo_usuario int,
codigo_evento int,
primary key (codigo_usuario, codigo_evento),
foreign key (codigo_usuario) references USUARIO (codigo_usuario)
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
INSERT INTO usuario VALUES (null,'DGP', 'Daniel','González Pérez','656345678','dangonper@hotmail.com','Villalba','1997-03-20', 'usuario', 'dangonper', 'activo', null);
INSERT INTO usuario VALUES (null,'JPR','José','Pascual Rodríguez','658902345','joparod@gmail.com','Galapagar','1990-07-13','usuario', 'joparod', 'activo', null);
INSERT INTO usuario VALUES (null,'IMG','Inés','Martínez Gutiérrez','656882675','inmargut@gmail.com','Las Rozas','1992-12-03', 'usuario', 'inmargut', 'activo', null);
INSERT INTO usuario VALUES (null,'RRM','Rodrigo','Rodríguez Moreno','659382245','rodromo@gmail.com','Torrelodones','1995-08-23', 'usuario', 'rodromo', 'activo', null);
INSERT INTO usuario VALUES (null,'MSE','María','Saldaña Espinosa','651923490','masalesp@yahoo.es','Villalba','2000-02-02', 'usuario', 'masalesp', 'activo', null);
INSERT INTO usuario VALUES (null,'PFO','Pedro','Flores Ortiz','659912456','peflortiz@yahoo.es','Majadahonda','1979-01-03', 'usuario', 'peflortiz', 'activo', null);
INSERT INTO usuario VALUES (null,'JPS','Susana','Benitez Prado','651123987','subepra@gamil.com','Galapagar','1991-05-16', 'usuario', 'subepra', 'activo', null);
INSERT INTO usuario VALUES (null,'CAE','Clara','Alonso Espina','652345768','clalonespi@yahoo.es','Villalba','1985-11-12', 'usuario', 'clalonespi', 'activo', null);
INSERT INTO usuario VALUES (null,'NSF','Nacho','Sánchez Fernández','650234566','nasafer@hotmail.com','Villalba','1985-07-23', 'usuario', 'nasafer', 'activo', null);
INSERT INTO usuario VALUES (null,'SPS','Santiago','Pazos Segura','651234567','sanpase@gmail.com','Galapagar','1977-04-12', 'usuario', 'sanpase', 'activo', null);
INSERT INTO usuario VALUES (null,'MCP','Martin','Cuentos Pérez','652543196','marcupe@yahoo.es','Las Rozas','1979-02-18', 'usuario', 'marcupe', 'activo', null);
INSERT INTO usuario VALUES (null,'MCPI','Marta','Claras Pinto','647890234','marclapi@yahoo.es','Las Rozas','1980-03-03', 'usuario', 'marclapi', 'activo', null);
INSERT INTO usuario VALUES (null,'PVGHA','Paula','Vía Gómez','634781233','pauvigo@hotmail.com','Torrelodones','1984-05-01', 'usuario', 'pauvigo', 'activo', null);
INSERT INTO usuario VALUES (null,'RRLOP','Rocío','Romero López','672345908','rorolop@hotmail.ccom','Pozuelo','1999-04-29', 'usuario', 'rorolop', 'activo', null);
INSERT INTO usuario VALUES (null,'PRRAM','Paula','Ruiz Ramírez','623098123','paururam@gmail.com','Pozuelo','2001-06-03', 'usuario', 'paururam', 'activo', null);
INSERT INTO usuario VALUES (null,'MRPIE', 'Miguel','Ramírez Pérez','678120090','miraper@yahoo.es','Torrelodones','2000-02-21', 'usuario', 'miraper', 'activo', null);
INSERT INTO usuario VALUES (null,'JCMUÑ', 'Jose','Cruz Muñoz','675998877','joscrumu@hotmail.com','Galapagar','1999-06-08', 'usuario', 'joscrumu', 'activo', null);
INSERT INTO usuario VALUES (null,'MSALON', 'Mar','Silva Alonso','623445566','marsial@yahoo.es','Torrelodones','1985-04-23', 'usuario', 'marsial', 'activo', null);
INSERT INTO usuario VALUES (null,'SSCRT', 'Sofía','Soto Contreras','609876161','sosocon@hotmail.com','Villalba','1975-08-06', 'usuario', 'sosocon', 'activo', null);
INSERT INTO usuario VALUES (null,'LTHSER', 'Lidia','Torres Hernández','690324532','litoher@gmail.com','Galapagar','1989-03-25', 'usuario', 'litoher', 'activo', null);
INSERT INTO usuario VALUES (null,'CFCASR', 'Carmen','Flores Castillo','675123432','cafloca@yahoo.es','Las Rozas','2000-02-21', 'usuario', 'cafloca', 'activo', null);
INSERT INTO usuario VALUES (null,'MVPIZA', 'Marco','Valenzuela Pizarro','619830234','marvapi@yahoo.es','Las Rozas','2001-11-20', 'usuario', 'marvapi', 'activo', null);
INSERT INTO usuario VALUES (null,'FRDIZ', 'Francis','Rojas Díaz','657890000','frarodi@hotmail.com','Torrelodones','2000-10-23', 'usuario', 'frarodi', 'activo', null);
INSERT INTO usuario VALUES (null,'ARMIS','Aaron','Ramírez Fuentes','657121213','aarramfu@hotmail.ccom','Pozuelo','2001-10-08', 'usuario', 'aarramfu', 'activo', null);
INSERT INTO usuario VALUES (null,'SMBEN', 'Sergio','Morales Benitez','626982314','semobe@gmail.com','Pozuelo','1998-09-24', 'usuario', 'semobe', 'activo', null);
INSERT INTO usuario VALUES (null,'IJVER', 'Israel','Jara Vergara','656098710','isjave@yahoo.es','Torrelodones','1997-08-06', 'usuario', 'isjave', 'activo', null);
INSERT INTO usuario VALUES (null,'LMCUER', 'Lucía','Miranda Cuervo','610232123','lumicu@hotmail.com','Galapagar','1996-05-13', 'usuario', 'lumicu', 'activo', null);
INSERT INTO usuario VALUES (null,'SCFIER', 'Silvia','Campos Figueroa','689098909','silcafi@yahoo.es','Torrelodones','2001-03-17', 'usuario', 'silcafi', 'activo', null);
INSERT INTO usuario VALUES (null,'GRSAL', 'Ramón','Garrido Salazar','651234567','ragasa@gmail.com','Galapagar','1979-02-12', 'usuario', 'ragasa', 'activo', null);
INSERT INTO usuario VALUES (null,'LAROME', 'Luis','Alarcón Romero','652543196','lualro@yahoo.es','Las Rozas','2001-02-21', 'usuario', 'lualro', 'activo', null);
INSERT INTO usuario VALUES (null,'MVCAC', 'Marcos','Vázquez Cáceres','647890234','mavaca@yahoo.es','Las Rozas','1990-03-28', 'usuario', 'mavaca', 'activo', null);
INSERT INTO usuario VALUES (null,'POSANDO', 'Paula','Orellana Sandoval','634781233','paorsa@hotmail.com','Torrelodones','1992-07-01', 'usuario', 'paorsa', 'activo', null);
INSERT INTO usuario VALUES (null,'INAAGUI', 'Inés','Aguilera Aravena','672345908','inagar@hotmail.ccom','Pozuelo','1997-01-02', 'usuario', 'inagar', 'activo', null);
INSERT INTO usuario VALUES (null,'AELIV','Aureo','Escobar Leiva','623098123','auesle@gmail.com','Pozuelo','2001-05-30', 'usuario', 'auesle', 'activo', null);
INSERT INTO usuario VALUES (null,'FRPER', 'Fernando','Ruiz Pérez','678120090','ferrupe@yahoo.es','Torrelodones','2000-09-12', 'usuario', 'ferrupe', 'activo', null);
INSERT INTO usuario VALUES (null,'PVMOL', 'Pilar','Vega Molina','675998877','pivemo@hotmail.com','Galapagar','1999-08-09', 'usuario', 'pivemo', 'activo', null);
INSERT INTO usuario VALUES (null,'NGMIOE', 'Natalia','García Molinero','623445566','nagamo@yahoo.es','Torrelodones','1985-11-04', 'usuario', 'nagamo', 'activo', null);
INSERT INTO usuario VALUES (null,'IVMOLI', 'Iván','Vera Molina','650234566','ivavemo@hotmail.com','Villalba','1985-07-23', 'usuario', 'ivavemo', 'activo', null);
INSERT INTO usuario VALUES (null,'PSMOLI', 'Pablo','Sánchez Molina','623400066','pasmoo@yahoo.es','Torrelodones','1989-10-04', 'usuario', 'pasmoo', 'activo', null);
INSERT INTO usuario VALUES (null,'IVAGASA', 'Iván','Agapito Sanchez','600234500','ivagasa@hotmail.com','Villalba','1988-02-23', 'usuario', 'ivagasa', 'activo', null);
INSERT INTO usuario VALUES (null,'JCPEREZ', 'Juan','Carlos Pérez','656000000','nuestraapp@hotmail.com','Villalba','1988-02-23', 'administrador', 'nuestraapp', 'activo', null);
INSERT INTO usuario VALUES (null,'PGLOPEZ', 'Pedro','González López','656000000','nuestraapp@hotmail.com','Villalba','1988-02-23', 'administrador', 'nuestraapp', 'activo', null);
INSERT INTO usuario VALUES (null,'JGGRANGE', 'Javier','Guerra Grange','656000000','nuestraapp@hotmail.com','Villalba','1988-02-23', 'administrador', 'nuestraapp', 'activo', null);
INSERT INTO usuario VALUES (null,'APRIVAS', 'Álvaro','Pérez Rivas','656000000','nuestraapp@hotmail.com','Villalba','1988-02-23', 'administrador', 'nuestraapp', 'activo', null);
INSERT INTO usuario VALUES (null,'JMMORENO', 'Jaime','Martí Moreno','656000000','nuestraapp@hotmail.com','Villalba','1988-02-23', 'administrador', 'nuestraapp', 'activo', null);

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
INSERT INTO Eventos VALUES (null, '2022-09-24', '18:00', 'Enrique Blas', 'Avanzado', 1);
INSERT INTO Eventos VALUES (null, '2022-10-14', '19:00', 'La Granadilla', 'Principiante', 2);
INSERT INTO Eventos VALUES (null, '2022-11-12', '13:00', 'El Torreón', 'Medio', 3);
INSERT INTO Eventos VALUES (null, '2022-10-20', '15:00', 'Enrique Blas', 'Avanzado', 4);
INSERT INTO Eventos VALUES (null, '2022-11-18', '19:00', 'El Torreón', 'Medio', 2);

-- INSERTAMOS FORO:
INSERT INTO Foro VALUES (null, 1);

-- INSERTAMOS MENSAJES:
INSERT INTO Mensaje VALUES (null, 'Hola, yo llevo el balón', 1, 30);
INSERT INTO Mensaje VALUES (null, 'Ok, genial', 1, 31);
INSERT INTO Mensaje VALUES (null, 'Nos vemos allí a las 18:00', 1, 33);

-- INSTRUCCIONES NECESARIAS POR CADA PANTALLA DE LA APP:

-- BIENVENIDO:
select nombre_usuario, contraseña from usuario where nombre_usuario = 'DGP' && contraseña = 'dangonper' && estado = 'activo'; -- OK
select nombre_usuario, contraseña from usuario where nombre_usuario = 'DGP' && contraseña = 'dangonperez' && estado = 'activo'; -- ERROR

-- BINEVENIDO ADMIN:
update usuario set estado = 'inactivo' where codigo_usuario = 1; -- Ejemplo codigo: 1. Dejariamos bloqueado a este usuario.
update usuario set estado = 'activo' where codigo_usuario = 1; -- Ejemplo codigo: 1. Volveríamos a dejar activo a este usuario.

-- REGISTRARSE:
select nombre_usuario from usuario where nombre_usuario = 'RPSANT'; -- Comprueba si está el nickname 
INSERT INTO usuario VALUES (null, 'RPSANT', 'Rodrigo','Pintos Santos','657890909','rpsant@hotmail.com','Torrelodones','1994-07-01', 'usuario', 'rpsnt', 'activo', null); -- Inserta si no está
-- Si está, error

-- RECUPERAR CONTRASEÑA:
select email from usuario where email = 'frarodi@hotmail.com'; -- Comprueba si está email (está)
select email from usuario where email = 'frarodindo@hotmail.com';  -- Comprueba si está email (no está)
update usuario set codigo_recuperacion = 12345 where email = 'frarodi@hotmail.com'; -- si está, update
select codigo_recuperacion from usuario where email = 'frarodi@hotmail.com' && codigo_recuperacion = 12345; -- es codigo
select codigo_recuperacion from usuario where email = 'frarodi@hotmail.com' && codigo_recuperacion = 12346; -- no es codigo

-- NUEVA CONTRASEÑA:
update usuario set contraseña = 34567 where email = 'frarodi@hotmail.com'; -- ejemplo contraseña: 34567
update usuario set codigo_recuperacion = null where email = 'frarodi@hotmail.com';

-- TU PERFIL:
select nombre_usuario, nombre, apellidos, telefono, email, poblacion, fecha_nacimiento from usuario;
update usuario set nombre_usuario = 'Jose10', nombre = 'Jose', apellidos = 'Romero Saldaña', 
telefono = 656721212, email = 'jorosald@hotmail.com', poblacion = 'Torrelodones', 
fecha_nacimiento = '1991-05-16' where codigo_usuario = 40; -- Ejemplo codigo: 40

delete from usuario WHERE codigo_usuario = 37; -- Este para la basura. Usuario desaparece en eventos.

-- EVENTOS DISPONIBLES:
insert into usuario_eventos values (30, 3); -- Insertar usuario en el evento. 
insert into usuario_eventos values (30, 4);
insert into usuario_eventos values (32, 3);

select nombre_deporte, polideportivo, fecha, hora, nivel from deportes 
inner join eventos on deportes.codigo_deporte = eventos.codigo_deporte
inner join usuario_eventos on eventos.codigo_evento = usuario_eventos.codigo_evento
where deportes.codigo_deporte = 3; -- Mostrar la info de todos los eventos de ese deporte.

select codigo_evento, COUNT(codigo_usuario) from usuario_eventos   -- Mostrar número usuarios del evento.
where codigo_evento = 3 group by codigo_evento;

-- MIS EVENTOS:
select eventos.codigo_evento, nombre_deporte, polideportivo, fecha, hora, nivel from deportes 
inner join eventos on deportes.codigo_deporte = eventos.codigo_deporte
inner join usuario_eventos on eventos.codigo_evento = usuario_eventos.codigo_evento
where usuario_eventos.codigo_usuario = 30; -- Mostrar la info del evento.

select codigo_evento, COUNT(codigo_usuario) from usuario_eventos   -- Mostrar número usuarios del evento.
where codigo_evento = 3 group by codigo_evento;

delete from usuario_eventos WHERE codigo_evento = 1 && codigo_usuario = 30; -- Este para la basura. Eliminas el evento seleccionado
 
-- FORO:
select nombre_usuario, mensaje from mensaje inner join usuario on mensaje.codigo_usuario = usuario.codigo_usuario 
where codigo_foro = 1; -- Sacar nombre usuario y mensaje
insert into Mensaje VALUES (null, 'Recordad que yo me iré antes', 1, 21); -- Guardar nuevo mensaje en ese foro
select nombre_usuario, mensaje from mensaje inner join usuario on mensaje.codigo_usuario = usuario.codigo_usuario 
where codigo_foro = 1; -- Actualizar mensajes 

-- CREAR EVENTO:
INSERT INTO Eventos VALUES (null, '2022-10-28', '12:00', 'El Torreón', 'Medio', 3);
INSERT INTO Eventos VALUES (null, '2022-09-06', '10:00', 'Enrique Blas', 'Avanzado', 3);
INSERT INTO Usuario_Eventos values (38, 6); -- El que crea evento se une automaticamente
INSERT INTO Usuario_Eventos values (15, 7); -- Se une otro usuario.
INSERT INTO Foro values (null, 6); -- Al crear evento se genera foro.

-- drop database Proyecto_Integrador;


