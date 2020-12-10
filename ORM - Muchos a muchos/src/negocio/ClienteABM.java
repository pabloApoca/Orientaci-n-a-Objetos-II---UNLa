package negocio;

import dao.ClienteDao;
import datos.Cliente;
import datos.Evento;

import java.util.ArrayList;
import java.util.GregorianCalendar;
import java.util.List;

public class ClienteABM {

	ClienteDao dao = new ClienteDao();

	public long agregarCliente(String nombre, String apellido, int dni, GregorianCalendar fechaDeNacimiento) {
		Cliente cliente = new Cliente(nombre, apellido, dni, fechaDeNacimiento);
		return dao.agregarCliente(cliente);
	}

	public Cliente traerCliente(long idCliente) throws Exception {
		if (dao.traerCliente(idCliente) == null)
			throw new Exception("ERROR: cliente no existe");
		return dao.traerCliente(idCliente);
	}

	public Cliente traerCliente(int dni) throws Exception {
		if (dao.traerCliente(dni) == null)
			throw new Exception("ERROR: cliente no existe");
		return dao.traerCliente(dni);
	}

	public void modificarCliente(Cliente cliente) throws Exception {
		if (dao.traerCliente(cliente.getIdCliente()) == null)
			throw new Exception("ERROR: no se encuentra cliente");
		dao.actualizarCliente(cliente);
	}

	public void eliminarCliente(Cliente cliente) throws Exception {
		if (dao.traerCliente(cliente.getIdCliente()) == null)
			throw new Exception("ERROR: no se encuentra cliente");
		dao.eliminarCliente(cliente);
	}

	public Cliente traerClienteYEventos(long idCliente) throws Exception {
		if (dao.traerCliente(idCliente) == null)
			throw new Exception("ERROR: no se encuentra Cliente");
		return dao.traerClienteYEventos(idCliente);
	}

	public List<Cliente> traerClientes() {
		return dao.traerClientes();
	}

	public boolean agregarEvento(Cliente cliente, Evento evento) throws Exception {

		return cliente.agregar(evento);

	}

	public boolean eliminarEvento(Cliente cliente, Evento evento) throws Exception {

		return cliente.eliminar(evento);
	}

}
