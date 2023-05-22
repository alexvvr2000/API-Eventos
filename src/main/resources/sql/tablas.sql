delete from public."Evento";
delete from public."Fecha";
insert into public."Evento" (descripcion)
values ('Juan Gabriel en concierto');
insert into public."Fecha" (idEvento, ubicacion, dia, hora, asientosDisponibles, precioAsiento)
values(1, 'Arena Mexico', NOW(), NOW(), 500, 2000);
insert into "Fecha" (idEvento, ubicacion, dia, hora, asientosDisponibles, precioAsiento)
values(1, 'Domo Care', NOW(), NOW(), 100, 5000);
