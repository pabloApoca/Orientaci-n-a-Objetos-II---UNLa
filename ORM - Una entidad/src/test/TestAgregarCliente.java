package test;

import java.time.LocalDate;
import negocio.ClienteABM;

public class TestAgregarCliente {
	public static void main(String[] args) {
		
		try {

		ClienteABM abm = new ClienteABM();
		long ultimoIdCliente = abm.agregar("Lopez", "Martin", 11223366, LocalDate.of(1994, 04, 18));
		
		System.out.println("Id con el que fue creado: " + ultimoIdCliente);
		System.out.println(abm.traerCliente(ultimoIdCliente));
	
		}catch (Exception e) {
	
		System.out.println(e);
		}
		
	}
}