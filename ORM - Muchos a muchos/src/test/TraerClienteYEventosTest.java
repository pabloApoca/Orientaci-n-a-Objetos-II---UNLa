package test;



import datos.Cliente;
import datos.Evento;

import negocio.*;

import java.util.List;
import java.util.GregorianCalendar;
	
	
public class TraerClienteYEventosTest {
	
public static void limpiarPantalla(){
		
		for(int i=0; i<10;i++){
			System.out.println();
		}
	}
	
	
	public static void main(String args[]) throws Exception{
		
		try{
			//Cliente clienteNuevo= new Cliente("Agustin","Chaves", 10000000,new GregorianCalendar(1999,02,16));
			ClienteABM abm= new ClienteABM();
			long idCliente=2;
			Cliente cliente= abm.traerClienteYEventos(idCliente);
			
			System.out.println(cliente);
			
			System.out.println(cliente.getEventos());
			
			
		}catch(Exception e){
			System.out.println(e.getMessage());
			e.printStackTrace();
		}
	}

}
