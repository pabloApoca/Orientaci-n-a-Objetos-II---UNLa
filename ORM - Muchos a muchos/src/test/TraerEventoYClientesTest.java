package test;



import datos.Evento;
import datos.Evento;

import negocio.*;

import java.util.List;
import java.util.GregorianCalendar;
	
	
public class TraerEventoYClientesTest {

	public static void limpiarPantalla(){
		
		for(int i=0; i<10;i++){
			System.out.println();
		}
	}
	
	
	public static void main(String args[]) throws Exception{
		
		try{
			//Evento EventoNuevo= new Evento("Agustin","Chaves", 10000000,new GregorianCalendar(1999,02,16));
			EventoABM abm= new EventoABM();
			long idEvento=1;
			Evento evento= abm.traerEventoYClientes(idEvento);
			
			System.out.println(evento);
			
			System.out.println(evento.getClientes());
			
			
		}catch(Exception e){
			System.out.println(e.getMessage());
			e.printStackTrace();
		}
	}
	
	
	
}
