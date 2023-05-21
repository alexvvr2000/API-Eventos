drop table if exists evento cascade;
drop table if exists fecha cascade;
create table evento (
	idEvento serial primary key,
	descripcion varchar(50)
);
create table fecha (
	idFecha serial primary key,
	idEvento integer references evento(idEvento) on delete cascade,
	lugar varchar(30),
	fecha timestamp,
	asientosDisponibles integer default 0,
	precioAsiento decimal,
	cancelado boolean default false
);
insert into evento (descripcion)
values ('Juan Gabriel en concierto');
insert into fecha (idEvento, lugar, fecha, asientosDisponibles, precioAsiento)
values(1, 'Arena Mexico', NOW(), 500, 2000);
insert into fecha (idEvento, lugar, fecha, asientosDisponibles, precioAsiento)
values(1, 'Domo Care', NOW(), 100, 5000);
