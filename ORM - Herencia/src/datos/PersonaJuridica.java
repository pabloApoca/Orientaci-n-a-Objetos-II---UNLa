package datos;

public class PersonaJuridica extends Cliente {

	private int idPersonaJuridica;
	private String razonSocial;
	private String cuit;

	public PersonaJuridica() {
		super();
	}

	public PersonaJuridica(String nroCliente, String razonSocial, String cuit, InscripcionAfip inscripcionAfip) {
		super(nroCliente, inscripcionAfip);
		this.razonSocial = razonSocial;
		this.cuit = cuit;
	}

	public int getIdPersonaJuridica() {
		return idPersonaJuridica;
	}

	public void setIdPersonaJuridica(int idPersonaJuridica) {
		this.idPersonaJuridica = idPersonaJuridica;
	}

	public String getRazonSocial() {
		return razonSocial;
	}

	public void setRazonSocial(String razonSocial) {
		this.razonSocial = razonSocial;
	}

	public String getCuit() {
		return cuit;
	}

	public void setCuit(String cuit) {
		this.cuit = cuit;
	}

	@Override
	public String toString() {
		return "PersonaJuridica [idPersonaJuridica=" + getIdCliente() + ", razonSocial=" + razonSocial + ", cuit="
				+ cuit + ", getNroCliente()=" + getNroCliente() + "]";
	}

}
