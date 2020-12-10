package test;

import datos.Cliente;
import datos.Evento;
import negocio.ClienteABM;
import negocio.EventoABM;

public class EliminarClienteDeEventoTest {

	
	
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
			
			long idCliente=2;
			Cliente cliente= abmCliente.traerCliente(idCliente); //traigo cliente
			
			long idEvento=1;
			Evento evento= abm.traerEventoYClientes(idEvento); // traigo evento con clientes
						
			System.out.println(evento.getClientes());
			System.out.println(evento); //muestro evento
			
			System.out.println(evento.eliminar(cliente));
			
			abm.modificarEvento(evento);	
			
			System.out.println(evento.getClientes()); //muestro clientes
			
			
			/*System.out.println(evento.traerClienteEvento(idCliente)); // Muestra el Cliente de id=2 que tiene ese Evento
			System.out.println(evento.getClientes()); // Muestra todos los clientes que tiene el Evento id=1 */ 
			
		}catch(Exception e){
			System.out.println(e.getMessage());
			e.printStackTrace();
		}
	}
	
	
}
