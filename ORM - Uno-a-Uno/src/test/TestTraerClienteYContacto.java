package test;

import java.util.List;

import datos.Cliente;
import negocio.ClienteABM;

public class TestTraerClienteYContacto {
	public static void main(String[] args) {
		ClienteABM abmCliente = new ClienteABM();
		
		try {
			long idCliente = 1;
			Cliente c = abmCliente.traerClienteYContacto(idCliente);
			System.out.println("\n---------Traer Cliente y Contacto---------\n" + c + "\n" + c.getContacto());
			
		} catch (Exception e) {
			System.out.println(e);
		}
		
		try {
			System.out.println("\n---------Traer lista de Clientes y Contactos---------\n");
			List<Cliente> listClientesCo = abmCliente.traerCliente();
			for(Cliente cliCo : listClientesCo ) {
				System.out.println(cliCo);
				System.out.println(cliCo.getContacto() + "\n");
			}
			
		} catch (Exception e) {
			System.out.println(e);
		}
		

	}
}