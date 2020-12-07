package negocio;

import java.time.LocalDate;
import java.util.GregorianCalendar;
import java.util.List;
import dao.ClienteDao;
import datos.Cliente;

public class ClienteABM {

	ClienteDao dao = new ClienteDao();

	public Cliente traerCliente(long idCliente) throws Exception {

		Cliente c = dao.traerCliente(idCliente);
		if (c == null) {
			throw new Exception("ERROR: No existe Cliente con este ID.");
		}
		return c;
	}

	public Cliente traerCliente(int dni) throws Exception {
		Cliente c = dao.traerCliente(dni);
		if (c == null) {
			throw new Exception("ERROR: No existe Cliente con este DNI.");
		}
		return c;
	}

	public int agregar(String apellido, String nombre, int dni, LocalDate fechaDeNacimiento) throws Exception {
		if (dao.traerCliente(dni) != null) {
			throw new Exception("ERROR: El cliente ya existe con este Dni.");
		}
		Cliente c = new Cliente(apellido, nombre, dni, fechaDeNacimiento);
		return dao.agregar(c);
	}

	public void modificar(Cliente c) throws Exception {
		if (dao.traerCliente(c.getDni()) != null && dao.traerCliente(c.getIdCliente()) != null) {
			throw new Exception("ERROR: ya hay un cliente con estos datos.");
		}
		dao.actualizar(c);
	}

	public void eliminar(long idCliente) throws Exception {
		Cliente c = dao.traerCliente(idCliente);
		if (c == null) {
			throw new Exception("ERROR: No existe Cliente con este ID.");
		}
		dao.eliminar(c);
		System.out.println("Cliente con ID: " + idCliente + " eliminado exitosamente.");
	}

	public List<Cliente> traerCliente() {
		return dao.traerCliente();
	}

	public Cliente traerClienteYPrestamos(long idCliente) throws Exception {
		Cliente cli = dao.traerClienteYPrestamos(idCliente);
		if (cli.getPrestamos() == null || cli.getPrestamos().size() == 0)
			throw new Exception("El cliente no tiene prestamos.");
		return cli;
	}

}