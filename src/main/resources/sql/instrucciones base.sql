-- evento y fechas disponibles
select 
	descripcion, 
	array(select idFecha from fecha) as IdFechas
from evento where idEvento = 1;
-- Todos los id de eventos;
select array(select idEvento from evento) as IdEventos;
-- Asientos disponibles
select filas from fecha where idEvento = 1 and idFecha = 1;
-- horario de fecha
select fecha from fecha where idEvento = 1 and idFecha = 1;
-- existe evento
select exists(
	select descripcion from evento where idEvento = 1
) as existeEvento;
-- existe fecha
select exists(
	select fecha from fecha 
	where idEvento = 1 and idFecha = 2
) as existeEvento;