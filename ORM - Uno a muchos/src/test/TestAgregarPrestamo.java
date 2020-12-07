package test;

import java.time.LocalDate;

import datos.Cliente;
import negocio.ClienteABM;
import negocio.PrestamoABM;

public class TestAgregarPrestamo {
	public static void main(String[] args) {

		PrestamoABM abmPrestamo = new PrestamoABM();
		ClienteABM abmCliente = new ClienteABM();
		
		try {
			long idCliente= 1;
			Cliente cliente = abmCliente.traerCliente(idCliente);
			long ultimo = abmPrestamo.agregar(LocalDate.of(2018, 5, 10), 5000, 0.75, 9, cliente);
			System.out.println(ultimo);
			
		} catch (Exception e) {
			System.out.println(e);
		}
		
	}
}
