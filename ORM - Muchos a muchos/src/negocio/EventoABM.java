package negocio;

import java.util.GregorianCalendar;
import java.util.List;

import dao.EventoDao;
import datos.Evento;

public class EventoABM {

	EventoDao dao = new EventoDao();

	public long agregarEvento(String evento, GregorianCalendar fecha) {
		Evento eventoObjeto = new Evento(evento, fecha);
		return dao.agregarEvento(eventoObjeto);
	}

	public Evento traerEvento(long idEvento) throws Exception {
		if (dao.traerEvento(idEvento) == null)
			throw new Exception("ERROR: Evento no existe");
		return dao.traerEvento(idEvento);
	}

	public void modificarEvento(Evento evento) throws Exception {
		if (dao.traerEvento(evento.getIdEvento()) == null)
			throw new Exception("ERROR: no se encuentra Evento");
		dao.actualizarEvento(evento);
	}

	public void eliminarEvento(Evento evento) throws Exception {
		if (dao.traerEvento(evento.getIdEvento()) == null)
			throw new Exception("ERROR: no se encuentra Evento");
		dao.eliminarEvento(evento);
	}

	public Evento traerEventoYClientes(long idEvento) throws Exception {
		if (dao.traerEvento(idEvento) == null)
			throw new Exception("ERROR: no se encuentra Evento");
		return dao.traerEventoYClientes(idEvento);
	}

	public List<Evento> traerEventos() {
		return dao.traerEventos();
	}

}
