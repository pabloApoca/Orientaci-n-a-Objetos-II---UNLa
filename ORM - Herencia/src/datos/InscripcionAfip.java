package datos;

import java.util.Set;

public class InscripcionAfip {
	private long idInscripcionAfip;
	private String inscripcionAfip;
	private Set<Cliente> clientes;

	public InscripcionAfip() {
		super();

	}

	public InscripcionAfip(String inscripcionAfip) {
		super();
		this.inscripcionAfip = inscripcionAfip;
	}

	public long getIdInscripcionAfip() {
		return idInscripcionAfip;
	}

	public void setIdInscripcionAfip(long idInscripcionAfip) {
		this.idInscripcionAfip = idInscripcionAfip;
	}

	public String getInscripcionAfip() {
		return inscripcionAfip;
	}

	public void setInscripcionAfip(String inscripcionAfip) {
		this.inscripcionAfip = inscripcionAfip;
	}

	public Set<Cliente> getClientes() {
		return clientes;
	}

	public void setClientes(Set<Cliente> clientes) {
		this.clientes = clientes;
	}

	@Override
	public String toString() {
		return "InscripcionAfip [idInscripcionAfip=" + idInscripcionAfip + ", inscripcionAfip=" + inscripcionAfip + "]";
	}

}