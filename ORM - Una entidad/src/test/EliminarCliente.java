package test;

import negocio.ClienteABM;

public class EliminarCliente {

	public static void main(String[] args) {

		ClienteABM abm =  new ClienteABM();
		
		try {
			long idCliente=2;
			abm.eliminar(idCliente);

		} catch (Exception e) {
			System.out.println(e);
		}

		
		try {
			long idCliente =1111111111;
			abm.eliminar(idCliente);

		} catch (Exception e) {
			System.out.println(e);
		}
		
	}

}
