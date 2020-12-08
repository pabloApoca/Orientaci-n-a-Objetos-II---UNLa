package test;

import datos.Cliente;
import negocio.ClienteABM;

public class TraerClientes {
	public static void main(String[] args) {

		
		long idCliente = 3;
		System.out.println("\nTraer Cliente con ID: " + idCliente);
		Cliente cli = ClienteABM.getInstance().traer(idCliente);
		System.out.println(cli);
		if(cli.getContacto()!=null)
		System.out.println(cli.getContacto());

		
		idCliente = 2;
		System.out.println("\nTraer Cliente con ID: " + idCliente);
		cli = ClienteABM.getInstance().traer(idCliente);
		System.out.println(cli);
		if(cli.getContacto()!=null)
		System.out.println(cli.getContacto());

		
		System.out.println("\n------Traer lista de Clientes------");
		for (Cliente c : ClienteABM.getInstance().traer()) {
			System.out.println("\n" + c);
			if(c.getContacto()!=null)
			System.out.println(c.getContacto());
		}
		
	}
}
