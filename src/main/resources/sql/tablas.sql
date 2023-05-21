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
	filas jsonb,
	cancelado boolean default false
);
insert into evento (descripcion)
values ('Juan Gabriel en concierto');
insert into fecha (idEvento, lugar, fecha, filas)
values(1, 'Arena Mexico', NOW(), '{"A" : {"1": true, "2": true, "precio": 9000},"B" : {"1": false, "2": false, "precio": 1000}}');
insert into fecha (idEvento, lugar, fecha, filas)
values(1, 'Domo Care', NOW(), '{"A" : {"1": true, "2": true, "precio": 10000},"B" : {"1": true, "2": true, "precio": 2000}}');