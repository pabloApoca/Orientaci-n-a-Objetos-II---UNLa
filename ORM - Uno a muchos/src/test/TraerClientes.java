package test;

import java.util.ArrayList;
import java.util.List;

import datos.Cliente;
import negocio.ClienteABM;

public class TraerClientes {

	public static void main(String[] args) {

		ClienteABM abm = new ClienteABM();
		
		try {
			
			System.out.println("\n------------------Traer Cliente por ID y DNI------------------");
			long id= 1;
			Cliente c = abm.traerCliente(id);
			System.out.println(c);

			 c = abm.traerCliente(11223366);
			System.out.println(c);

			
			System.out.println("\n------------------Traer lista de Clientes------------------");
			List<Cliente> listaDeClientes = abm.traerCliente();
			
			for(Cliente cli : listaDeClientes ) {
				System.out.println(cli);
			}
			


		} catch (Exception e) {
			System.out.println(e);
		}
		
		
		
	}

}
