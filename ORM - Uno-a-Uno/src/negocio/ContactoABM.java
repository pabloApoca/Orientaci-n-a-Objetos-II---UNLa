package negocio;

import dao.ContactoDao;
import datos.Cliente;
import datos.Contacto;

public class ContactoABM {
	ContactoDao dao = new ContactoDao();

	public Contacto traer(long idContacto) throws Exception{
		Contacto c = dao.traerContacto(idContacto);
		if(c==null) throw new Exception("ERROR: No existe contacto con ID: "+ idContacto);
		return c;
	}

	public int agregar(String email, String movil, String fijo, Cliente cliente) {
		Contacto c = new Contacto(email, movil, fijo, cliente);
		return dao.agregarContacto(c);
	}

	public void modificar(Contacto c) throws Exception{
		if(traer(c.getIdContacto())==null) throw new Exception("ERROR: No existe contacto a modificar");
		dao.actualizarContacto(c);
	}

	public void eliminar(long idContacto) throws Exception {
		if(traer(idContacto)==null) throw new Exception("ERROR: No existe contacto con ID: "+idContacto);
		Contacto c = dao.traerContacto(idContacto);
		dao.eliminarContacto(c);
		System.out.println("Contacto con ID: "+ idContacto + " eliminado exitosamente.");
	}
}