package test;

import datos.Cliente;
import negocio.ClienteABM;
import negocio.ContactoABM;

public class TestAgregarContacto {
	public static void main(String[] args) {
		ClienteABM abmCliente = new ClienteABM();
		ContactoABM abmContacto = new ContactoABM();

		try {
			
			long idCliente = 3;
			Cliente cliente = abmCliente.traerCliente(idCliente);
			System.out.println(cliente);
			
			int ultimo =abmContacto.agregar("pablo_mtv08@hotmail.com", "1511223344", "4444-4444", cliente);
			long idContacto= ultimo;
			
			System.out.println("\n"+ abmContacto.traer(idContacto));
			
		} catch (Exception e) {
			System.out.println(e);
		}

	}
}
