package datos;
import java.util.ArrayList;
import java.util.GregorianCalendar;
import java.util.Iterator;
import java.util.List;
import java.util.Set;
import funciones.Funciones;
public class Cliente {
	
	private long idCliente;
	private String apellido;
	private String nombre;
	private int dni;
	private GregorianCalendar fechaDeNacimiento;
	private boolean baja;
	private Set<Evento> eventos;
	
	public Cliente(){}
	
	public Cliente(String nombre, String apellido, int dni,
	GregorianCalendar fechaDeNacimiento) {
		super();
		this.nombre = nombre;
		this.apellido = apellido;
		this.dni= dni;
		this.fechaDeNacimiento = fechaDeNacimiento;
		this.baja=false;
	}
	
	public long getIdCliente() {
	return idCliente;
	}
	
	protected void setIdCliente(long idCliente) {
	this.idCliente = idCliente;
	}
	
	public String getApellido() {
	return apellido;
	}
	
	public void setApellido(String apellido) {
	this.apellido = apellido;
	}
	
	public String getNombre() {
	return nombre;
	}
	
	public void setNombre(String nombre) {
	this.nombre = nombre;
	}
	
	public int getDni() {
	return dni;
	}
	
	public void setDni(int dni) {
	this.dni = dni;
	}
	
	public GregorianCalendar getFechaDeNacimiento() {
	return fechaDeNacimiento;
	}
	
	public void setFechaDeNacimiento(GregorianCalendar fechaDeNacimiento) {
	this.fechaDeNacimiento = fechaDeNacimiento;
	}
	
	public boolean isBaja() {
	return baja;
	}
	
	public void setBaja(boolean baja) {
	this.baja = baja;
	}
	
	public Set<Evento> getEventos() {
	return eventos;
	}
	
	protected void setEventos(Set<Evento> eventos) {
		this.eventos = eventos;
	}

	
	
	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + dni;
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
		Cliente other = (Cliente) obj;
		if (dni != other.dni)
			return false;
		return true;
	}

	public boolean agregar(Evento evento) throws Exception{
		
		List<Evento> listaEventos= new ArrayList(this.eventos);
		//listaClientes.addAll(this.clientes);
		for(int i=0;i<listaEventos.size();i++)
		{
			if(listaEventos.get(i).equals(evento)) throw new Exception ("ERROR: el cliente ya esta en evento");
			
		}
		return this.eventos.add(evento);
		
	}
	
	public boolean eliminar(Evento evento) throws Exception{
		List<Evento> listaEventos= new ArrayList(this.eventos);
		//listaEventos.addAll(this.clientes);
		boolean encontrado=false;
		for(int i=0;i<listaEventos.size();i++)
		{
			if(listaEventos.get(i).equals(evento))
				encontrado=true;
		}
		if(!encontrado) throw new Exception("ERROR: el evento no esta en lista");
		return eventos.remove(evento);
	}
	
	public String toString(){
		return ("\n" +idCliente+" "+apellido+" "+nombre+" DNI: "+dni+" F.de Nacimiento: "
				+Funciones.traerFechaCorta(fechaDeNacimiento)+" "+baja);
	}
}
