package test;

import datos.Cliente;
import datos.Evento;
import datos.Evento;

import negocio.*;

import java.util.List;
import java.util.GregorianCalendar;


public class AgregarClienteAEventoTest {
	
	public static void limpiarPantalla(){
		
		for(int i=0; i<10;i++){
			System.out.println();
		}
	}
	
	
	public static void main(String args[]) throws Exception{
		
		try{
			//Evento EventoNuevo= new Evento("Agustin","Chaves", 10000000,new GregorianCalendar(1999,02,16));
			EventoABM abm= new EventoABM();
			ClienteABM abmCliente= new ClienteABM();
			
			long idCliente=2;					;
			Cliente cliente= abmCliente.traerCliente(idCliente); //traigo cliente
			
			long idEvento=1;
			Evento evento= abm.traerEventoYClientes(idEvento); // traigo evento con clientes
			
			System.out.println(evento.getClientes());
			System.out.println(evento); //muestro evento
			
			evento.agregar(cliente); //agrego cliente
			abm.modificarEvento(evento);
			
			System.out.println(evento.getClientes()); //muestro clientes
			
			/*
			 * Esto es para volver a borrar el cliente nuevo y que la BD quede como estaba.
			 * 
			 * 		evento.eliminar(cliente); 
			 * 		abm.modificarEvento(evento); 
			 * */
			
		}catch(Exception e){
			System.out.println(e.getMessage());
			e.printStackTrace();
		}
	}
	

}
