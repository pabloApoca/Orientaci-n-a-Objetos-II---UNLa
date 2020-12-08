package test;

import java.util.List;

import datos.Cliente;
import datos.InscripcionAfip;
import negocio.ClienteABM;
import negocio.InscripcionAfipABM;

public class TestInscripcionAfip {

	public static void main(String[] args) {

		InscripcionAfipABM abmIns = new InscripcionAfipABM();
		
		try {
			
			//prueba 1
		/*	System.out.println("-----Agregar Inscripciones al Afip-----");
			long ultimo = abmIns.agregar("Credencial de Pago Monotributo Social");
			System.out.println("ID de ultima Inscripcion: "+ ultimo);
			System.out.println(abmIns.traer(ultimo) +"\n");
			
			
			 ultimo = abmIns.agregar("Actividades Económicas");
			System.out.println("ID de ultima Inscripcion: "+ ultimo);
			System.out.println(abmIns.traer(ultimo) +"\n");
			 
			
			 ultimo = abmIns.agregar("Estados Administrativos de la C.U.I.T. - RG 3358");
			System.out.println("ID de ultima Inscripcion: "+ ultimo);
			System.out.println(abmIns.traer(ultimo) +"\n");

			
			ultimo = abmIns.agregar("Bajas de oficio");
			System.out.println("ID de ultima Inscripcion: "+ ultimo);
			System.out.println(abmIns.traer(ultimo) +"\n");*/
			
			
			//prueba 1  
			System.out.println("----Traer Inscripcion por ID----");
			long idInscripcionAfip = 1;
			System.out.println(abmIns.traerInscripcionAfip(idInscripcionAfip));
			
			 idInscripcionAfip = 3;
			System.out.println(abmIns.traerInscripcionAfip(idInscripcionAfip));
			
			System.out.println("\n----Traer lista de Inscripciones de Afip con sus Clientes----");
			for(InscripcionAfip isn : abmIns.traerInscripcionAfip()) {
				System.out.println("\n"+isn);
				long idin = isn.getIdInscripcionAfip();
				List<Cliente>  list = ClienteABM.getInstance().traerList(idin);
				for(Cliente cli : list){
					System.out.println(cli);
				}
			}
			
			
		} catch (Exception e) {
			System.out.println(e);
		}

		
		
		
	}
}
