package test;

import negocio.ClienteABM;
import datos.Cliente;
import datos.Prestamo;

public class TestTraerClienteYPrestamos {
	public static void main(String[] args) {
		
		
		ClienteABM cliAbm = new ClienteABM();
		
		try {//Prueba 1
			long idCliente = 1;
			Cliente c = cliAbm.traerClienteYPrestamos(idCliente);
			System.out.println("\n---> Traer Cliente y Prestamos idCliente=" + idCliente);
			System.out.println("\n" + c);
			
			for (Prestamo p : c.getPrestamos())
				System.out.println("\n" + p);
			
		} catch (Exception e) {
			System.out.println(e);
		}
		
		try {//Prueba 2
			long idCliente = 2;
			Cliente c = cliAbm.traerClienteYPrestamos(idCliente);
			System.out.println("\n---> Traer Cliente y Prestamos idCliente=" + idCliente);
			System.out.println("\n" + c);
			
			for (Prestamo p : c.getPrestamos())
				System.out.println("\n" + p);
			
		} catch (Exception e) {
			System.out.println(e);
		}

	}
}