package negocio;

import dao.PrestamoDao;
import java.time.LocalDate;
import java.util.List;
import datos.Cliente;
import datos.Prestamo;

public class PrestamoABM {
	private PrestamoDao dao = new PrestamoDao();
	ClienteABM abmCliente = new ClienteABM();

	public Prestamo traerPrestamo(long idPrestamo) throws Exception {
		Prestamo p = dao.traer(idPrestamo);
		if (p == null)
			throw new Exception("ERROR: No existe el prestamo con ID: " + idPrestamo);
		return p;
	}

	public List<Prestamo> traerPrestamo(Cliente c) throws Exception {

		List<Prestamo> list = dao.traer(c);
		if (list == null || list.size() == 0)
			throw new Exception("El Cliente no tiene prestamos.");
		return list;
	}

	public int agregar(LocalDate fecha, double monto, double interes, int cantCuotas, Cliente cliente)
			throws Exception {
		if (abmCliente.traerCliente(cliente.getIdCliente()) == null)
			throw new Exception("ERROR: El cliente no existe.");
		Prestamo p = new Prestamo(fecha, monto, interes, cantCuotas, cliente);
		return dao.agregar(p);
	}

	public void modificar(Prestamo p) throws Exception {
		dao.actualizar(p);
	}
}