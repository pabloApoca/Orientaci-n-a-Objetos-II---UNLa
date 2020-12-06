package test;

import datos.Contacto;
import negocio.ContactoABM;

public class TestContacto {

	public static void main(String[] args) {

		ContactoABM abm = new ContactoABM();
		long idContacto = 2;
		Contacto con = new Contacto();
		
		try {
			System.out.println("\n--------Modificar Contacto--------");
			con = abm.traer(idContacto);
			System.out.println("Contacto a modificar: "+ con);
			
			con.setEmail("otroEmail@gmail.com");
			con.setMovil("1500770077");
			con.setFijo("5555-5555");
			
			abm.modificar(con);
			System.out.println("Contacto modificado: "+ con);
			
		} catch (Exception e) {
			System.out.println(e);
		}
		

		try {
			System.out.println("\n--------Eliminar Contacto--------");
			abm.eliminar(1232);
			
		} catch (Exception e) {
			System.out.println(e);
		}
		
		
		try {
			System.out.println("\n--------Eliminar Contacto--------");
			abm.eliminar(2);
			
		} catch (Exception e) {
			System.out.println(e);
		}


		
	}

}
