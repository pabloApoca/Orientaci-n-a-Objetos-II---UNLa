package test;

import java.time.LocalDate;

import datos.Cliente;
import negocio.ClienteABM;

public class TestActualizarCliente {
	public static void main(String[] args) {
		
		try {
		ClienteABM abm = new ClienteABM();
		long id = 1;
		
		Cliente c = abm.traerCliente(id);
		System.out.println("Cliente a Modificar -->" + c);
		
		c.setApellido("Martinez");
		c.setNombre("Juan");
		c.setDni(11228855);
		c.setFechaDeNacimiento(LocalDate.of(2000, 12, 5));
		abm.modificar(c);
		
		System.out.println("Cliente Modificado -->" + c);
		
		}catch (Exception e) {
			System.out.println(e);
		}
	}
}