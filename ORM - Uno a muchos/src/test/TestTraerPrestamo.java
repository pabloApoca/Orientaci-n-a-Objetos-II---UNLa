package test;

import java.util.List;
import datos.Cliente;
import datos.Prestamo;
import negocio.ClienteABM;
import negocio.PrestamoABM;

public class TestTraerPrestamo {
	public static void main(String[] args) {
		
			PrestamoABM prestamoABM = new PrestamoABM();
			ClienteABM clienteABM = new ClienteABM();

		try {//Prueba 1
			long idPrestamo = 1;
			System.out.println("\n---> TraerPrestamo idPrestamo=" + idPrestamo + "\n\n");
			Prestamo p = prestamoABM.traerPrestamo(idPrestamo);
			System.out.println(p + "\nPertenece a " + p.getCliente());
		} catch (Exception e) {
			System.out.println(e);
		}
		
		
		try {//Prueba 2
			long idPrestamo = 111;
			System.out.println("\n---> TraerPrestamo idPrestamo=" + idPrestamo + "\n\n");
			Prestamo p = prestamoABM.traerPrestamo(idPrestamo);
			System.out.println(p + "\nPertenece a " + p.getCliente());
		} catch (Exception e) {
			System.out.println(e);
		}
			
		
		try {//Prueba 3
			int dni = 11223366;
			Cliente c = clienteABM.traerCliente(dni);
			System.out.println("\n---> TraerPrestamos del Cliente=" + c + "\n\n");
						
			List<Prestamo> prestamos = prestamoABM.traerPrestamo(c);
			for (Prestamo o : prestamos) {
				System.out.println(o + "\nPertenece a" + o.getCliente());
			}
		} catch (Exception e) {
			System.out.println(e);
		}
		
		
		try {//Prueba 4
			int dni = 11223344;
			Cliente c = clienteABM.traerCliente(dni);
			System.out.println("\n---> TraerPrestamos del Cliente=" + c + "\n\n");
						
			List<Prestamo> prestamos = prestamoABM.traerPrestamo(c);
			for (Prestamo o : prestamos) {
					System.out.println(o + "\nPertenece a" + o.getCliente());
			}
		} catch (Exception e) {
			System.out.println(e);
		}
		
	}
}