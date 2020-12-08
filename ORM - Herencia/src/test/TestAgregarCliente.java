package test;


import datos.InscripcionAfip;
import negocio.ClienteABM;
import negocio.InscripcionAfipABM;

public class TestAgregarCliente {
	public static void main(String[] args) {
		InscripcionAfipABM abmIns = new InscripcionAfipABM();
		
		try {
			long idInscripcionAfip =3;
			InscripcionAfip inscripcion = abmIns.traerInscripcionAfip(idInscripcionAfip);
			System.out.println("\n"+inscripcion);
			long ultimo =ClienteABM.getInstance().agregarPersonaFisica("0000000", "Martinez", "Martin", 11223344, inscripcion);
			System.out.println("Id con el que fue creado: " + ultimo);
			System.out.println(ClienteABM.getInstance().traer(ultimo));
		} catch (Exception e) {
			System.out.println(e);
		}
				

		try {
			long idInscripcionAfip =4;
			InscripcionAfip inscripcion = abmIns.traerInscripcionAfip(idInscripcionAfip);
			System.out.println("\n"+inscripcion);
			long ultimo = ClienteABM.getInstance().agregarPersonaJuridica("4444444", "Sancor", "20112233448", inscripcion);
			System.out.println("Id con el que fue creado: " + ultimo);
			System.out.println(ClienteABM.getInstance().traer(ultimo));
		} catch (Exception e) {
			System.out.println(e);
		}
		


		
	}
}