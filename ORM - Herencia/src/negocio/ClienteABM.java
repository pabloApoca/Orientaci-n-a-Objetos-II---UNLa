package negocio;

import java.util.List;
import dao.ClienteDao;
import datos.Cliente;
import datos.InscripcionAfip;
import datos.PersonaFisica;
import datos.PersonaJuridica;

public class ClienteABM {
	private static ClienteABM instancia = null;// Patrón Singleton

	protected ClienteABM() {
	}

	public static ClienteABM getInstance() {
		if (instancia == null)
			instancia = new ClienteABM();
		return instancia;
	}

	public int agregarPersonaFisica(String nroCliente, String apellido, String nombre, int dni,
			InscripcionAfip inscripcionAfip) {
		PersonaFisica pf = new PersonaFisica(nroCliente, apellido, nombre, dni, inscripcionAfip);
		return ClienteDao.getInstance().agregar(pf);
	}

	public int agregarPersonaJuridica(String nroCliente, String razonSocial, String cuit,
			InscripcionAfip inscripcionAfip) {
		PersonaJuridica pj = new PersonaJuridica(nroCliente, razonSocial, cuit, inscripcionAfip);
		return ClienteDao.getInstance().agregar(pj);
	}

	public Cliente traer(long idCliente) {
		return ClienteDao.getInstance().traerCliente(idCliente);
	}

	public List<Cliente> traer() {
		return ClienteDao.getInstance().traerCliente();
	}

	public List<Cliente> traerList(long idInscripcion) {
		return ClienteDao.getInstance().traerCliente2(idInscripcion);
	}
}