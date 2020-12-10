package test;

import java.util.GregorianCalendar;

import datos.Evento;
import negocio.EventoABM;

public class EventoTest {
	
public static void limpiarPantalla(){
		
		for(int i=0; i<10;i++){
			System.out.println();
		}
	}
	
	
	public static void main(String args[]) throws Exception{
		
		try{
			EventoABM abmEvento= new EventoABM();
			
			String nombre="evento1";
			
			GregorianCalendar fecha= new GregorianCalendar(2016,3,20,16,0,0);
			
			long idEvento= abmEvento.agregarEvento(nombre,fecha);    // Agregar evento
			Evento Evento1= abmEvento.traerEvento(idEvento);
			System.out.println(Evento1); // Muestra el Evento que agregamos recien
			
			
			//Evento Evento2= abmEvento.traerEvento(38701487);
			//System.out.println(Evento2);		
			//System.out.println(Evento1.equals(Evento2));
			//limpiarPantalla();
			
			//System.out.println(abmEvento.traerEventos());
			
			limpiarPantalla();
			
			abmEvento.eliminarEvento(abmEvento.traerEvento(4)); // Elimina el evento de id 4
			
		  System.out.println(abmEvento.traerEventos());
			
			
			/*long idEvento=3;
			Evento evento1= abmEvento.traerEvento(idEvento);
			evento1.setEvento("Evento modificado");
			abmEvento.modificarEvento(evento1);
			
			System.out.println(abmEvento.traerEvento(idEvento));*/
			
		}catch(Exception e){
			System.out.println(e.getMessage());
			e.printStackTrace();
		}

	}
}
