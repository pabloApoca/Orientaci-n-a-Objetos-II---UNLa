package datos;
import java.util.ArrayList;
import java.util.GregorianCalendar;
import java.util.Iterator;
import java.util.List;
import java.util.Set;
import funciones.Funciones;


public class Evento {

	private long idEvento;
	private String evento;
	private GregorianCalendar fecha;
	private Set<Cliente> clientes;
	
	public Evento(){
		}
	
	public Evento(String evento, GregorianCalendar fecha) {
		super();
		this.evento = evento;
		this.fecha = fecha;
	}

	public long getIdEvento() {
		return idEvento;
	}

	protected void setIdEvento(long idEvento) {
		this.idEvento = idEvento;
	}

	public String getEvento() {
		return evento;
	}

	public void setEvento(String evento) {
		this.evento = evento;
	}

	public GregorianCalendar getFecha() {
		return fecha;
	}

	public void setFecha(GregorianCalendar fecha) {
		this.fecha = fecha;
	}

	public Set<Cliente> getClientes() {
		return clientes;
	}

	public void setClientes(Set<Cliente> clientes) {
		this.clientes = clientes;
	}

	public boolean equals(Evento evento){
	
		if(evento.getIdEvento()==idEvento)
			return true;
		else
			return false;
	}

	public boolean agregar(Cliente cliente) throws Exception{
		
		List<Cliente> listaClientes= new ArrayList(this.clientes);
		//listaClientes.addAll(this.clientes);
		for(int i=0;i<listaClientes.size();i++)
		{
			if(listaClientes.get(i).equals(cliente)) throw new Exception ("ERROR: el cliente ya esta en evento");
			
		}
		return this.clientes.add(cliente);
	}

	public boolean eliminar(Cliente cliente) throws Exception{
		
		List<Cliente> listaClientes= new ArrayList(this.clientes);
		boolean encontrado=false;
		
		for(int i=0;i<listaClientes.size();i++)
		{
			if(listaClientes.get(i).equals(cliente)){ 
				encontrado= true;
			}
		}
		if(!encontrado) throw new Exception("ERROR: cliente no esta en lista");
		return this.clientes.remove(cliente);
	}
	
	public Cliente traerClienteEvento(long idCliente) throws Exception{
		
		List<Cliente> clientes= new ArrayList(this.clientes);
		Cliente cliente=null;
		for(int i=0;i<clientes.size();i++)
		{
			if(clientes.get(i).getIdCliente()==idCliente) 
				cliente= clientes.get(i);
			
		}
		if(cliente==null) throw new Exception("ERROR: cliente no esta en lista");
		return cliente;
		
	}
	
	
	

	public String toString(){
		return idEvento+" "+evento+" "+Funciones.traerFechaCorta(fecha)+" "+Funciones.traerHora(fecha);
	}
	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((evento == null) ? 0 : evento.hashCode());
		return result;
	}
	
	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Evento other = (Evento) obj;
		if (evento == null) {
			if (other.evento != null)
				return false;
		} else if (!evento.equals(other.evento))
			return false;
		return true;
	}
	
	



}
