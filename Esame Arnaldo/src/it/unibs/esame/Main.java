package it.unibs.esame;
import javax.xml.stream.XMLStreamException;

import it.unibs.mylib.InputDati;
import it.unibs.mylib.MyMenu;


public class Main {

	public static void main(String[] args) throws XMLStreamException, InterruptedException {


		System.out.println("benvenuto viaggiatore il cerchio ha deciso la tua prossima missione:");
		System.out.println("è stato trovato un luogo nascosto, pieno di mostri e con una principessa da salvare.");
		Thread.sleep(1500);
		System.out.println("ovviamente il tuo scopo primario sarà sopravvivere");
		Thread.sleep(2500);
		System.out.println("in breve, nelle ceste si trovano oggetti utili, i mostri sono invece da combattere e sconfiggere");
		Thread.sleep(1500);
		System.out.println("scoprirai man mano cosa ti aspetta, e ricorda:");
		Thread.sleep(1500);
		System.out.println("il gioco non è ancora finito (:");
		
		String nome = InputDati.leggiStringaNonVuota("inserire il nome del personaggio");
		Personaggio persona = new Personaggio(nome);
		Gioco gioco = new Gioco(persona);

		String vociMenu[] = {"Inventario","Statistiche", "Esci dal Menù","Abbandona la partita"};
		String vociInventario[] = {"visualizza elenco oggetti","cambia oggetto"};
		//String vociLuna[] = {"aggiungi una nuova luna","togli una luna ","trova il percorso per una luna"};

		MyMenu menuPrincipale = new MyMenu("scegliere un opzione",vociMenu);
		
		MyMenu menuinventario = new MyMenu("scegliere cosa fare con il pianeta",vociInventario);
		
		//MyMenu menuLuna = new MyMenu("scegliere cosa fare con una luna",vociLuna);
			
		

		boolean fine = true;
		while(fine) {
	
		while (gioco.muovi());
		
		boolean continua = true;
		//ciclo menù principale
		while (continua) {
			
			switch (menuPrincipale.scegli()) {
			
			//primo caso del menu, INVENTARIO
			case 1:		
				switch(menuinventario.scegli()) {
				//menu scelta 1, 
				case 1: 
					//persona.stampaInventario();	
					//non sono riuscito  a farlo per tempo ):
															
					break;
				//menu scelta 2, 
				case 2:
					break;						
				}
				break;
				
				
			//secondo caso del menu principale, STATISTICHE
			case 2:
				break;
				
			}				
		}

	}
	}

}
