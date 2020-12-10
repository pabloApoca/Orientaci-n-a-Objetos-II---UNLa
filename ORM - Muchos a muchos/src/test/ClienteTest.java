package test;

import datos.Cliente;
import datos.Evento;

import negocio.*;

import java.util.List;
import java.util.GregorianCalendar;

public class ClienteTest {
	
	public static void limpiarPantalla(){
		
		for(int i=0; i<10;i++){
			System.out.println();
		}
	} 
	
	
	public static void main(String args[]) throws Exception{
		
		try{
			ClienteABM abmCliente= new ClienteABM();
			
			/* Como levantar una BAJA LOGICA
			 * 
			 * Cliente cliente = abmCliente.traerCliente(2L);
			cliente.setBaja(false);
			abmCliente.modificarCliente(cliente);
			
			System.out.println(abmCliente.traerClientes()); */
			
			
			
			
			/*AGREGAR UN NUEVO CLIENTE Y COMPARAR SI SON IGUALES A TRAVEZ DEL EQUALS
			
			String nombre="Pablo";
			String apellido="Narvaja";
			int dni=14000001;
			GregorianCalendar fechaDeNacimiento= new GregorianCalendar(1970,10,11);
			
			long idCliente= abmCliente.agregarCliente(nombre, apellido, dni, fechaDeNacimiento);
			
			Cliente cliente1= abmCliente.traerCliente(idCliente);
			
		System.out.println(cliente1);
			
			Cliente cliente2= abmCliente.traerCliente(14000001);
			
			System.out.println(cliente2);
			
			System.out.println(cliente1.equals(cliente2));
			
			limpiarPantalla();
			
			System.out.println(abmCliente.traerClientes()); */
			
		limpiarPantalla();
			
			// ELIMINAR UN CLIENTE 
		//abmCliente.eliminarCliente(abmCliente.traerCliente(2l)); 
		// No se va a eliminar el cliente del todo, sino que la Baja se pone en 1 . " Baja Logica "
		
			
			System.out.println(abmCliente.traerClientes()); 
			
			/* MODIFICAR UN ATRIBUTO DEL CLIENTE 
			
			int dniModificar=12000000;
			long idCliente=1;
			Cliente cliente1= abmCliente.traerCliente(idCliente);
			cliente1.setDni(dniModificar);
			abmCliente.modificarCliente(cliente1);*/
			
			//System.out.println(abmCliente.traerCliente(idCliente));
			
		}catch(Exception e){
			System.out.println(e.getMessage());
			e.printStackTrace();
		}
	}
}
