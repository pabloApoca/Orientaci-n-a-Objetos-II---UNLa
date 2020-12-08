package negocio;

import java.util.List;

import dao.InscripcionAfipDao;
import datos.InscripcionAfip;

public class InscripcionAfipABM {
	InscripcionAfipDao dao = new InscripcionAfipDao();

	public InscripcionAfip traerInscripcionAfip(long idInscripcionAfip) throws Exception {
		InscripcionAfip c = dao.traerInscripcionAfip(idInscripcionAfip);
		if (c == null)
			throw new Exception("ERROR: No existe Inscripcion Afip con ID: " + idInscripcionAfip);
		return c;
	}

	public long agregar(String inscripcionAfip) {
		InscripcionAfip c = new InscripcionAfip(inscripcionAfip);
		return dao.agregarInscripcionAfip(c);
	}

	public void modificar(InscripcionAfip c) throws Exception {
		dao.actualizar(c);
	}

	public void eliminar(long idInscripcionAfip) throws Exception {
		InscripcionAfip c = dao.traerInscripcionAfip(idInscripcionAfip);
		dao.eliminar(c);
		System.out.println("Contacto con ID: " + idInscripcionAfip + " eliminado exitosamente.");
	}

	public List<InscripcionAfip> traerInscripcionAfip() {
		return dao.traerInscripcionAfip();
	}
}