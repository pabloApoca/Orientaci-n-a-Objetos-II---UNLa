package test;

import datos.Cliente;
import datos.Evento;
import negocio.ClienteABM;
import negocio.EventoABM;

public class AgregarEventoAClienteTest {
	
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
			
			long idCliente=4;
			Cliente cliente= abmCliente.traerClienteYEventos(idCliente); //traigo cliente
			
			long idEvento=1;
			Evento evento= abm.traerEvento(idEvento); // traigo evento con clientes
			
			System.out.println(cliente.getEventos());
			System.out.println(cliente); //muestro evento
			
			abmCliente.agregarEvento(cliente,evento); //agrego cliente
			abmCliente.modificarCliente(cliente);
			
			System.out.println(cliente.getEventos()); //muestro clientes
		
			/*	
			evento.eliminar(cliente);
			abm.modificarEvento(evento);
			*/
			
			
		}catch(Exception e){
			System.out.println(e.getMessage());
			e.printStackTrace();
		}
	}

}
