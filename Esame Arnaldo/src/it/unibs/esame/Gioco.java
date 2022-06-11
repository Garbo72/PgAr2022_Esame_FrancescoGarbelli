package it.unibs.esame;

import java.util.Arrays;
import java.util.List;
import java.util.ListIterator;

import javax.xml.stream.XMLStreamException;

import it.unibs.mylib.InputDati;
import it.unibs.mylib.MyMenu;

public class Gioco {

	Personaggio gio;
	Mappa mappa;
	List<String> nomi = Arrays.asList("livello2.xml", "livello3.xml", "livello4Boss.xml",
			"livello4Princess.xml");
	ListIterator<String> livelli =  nomi
			.listIterator();
	
	public Gioco(Personaggio gi) throws XMLStreamException {
		mappa = new Mappa("livello1.xml");
		gio = gi;
		mappa.stampa();
	}
	
	
	
	/**
	 * metodo principale che muove nella mappa il giocatore, e verifica se deve compiere delle azioni nelle caselle dove si sposta
	 * 
	 * @param gio
	 * @return
	 * @throws InterruptedException 
	 * @throws XMLStreamException 
	 */
	public boolean muovi() throws InterruptedException, XMLStreamException {
		
			 if (spostamento()) {
				 mappa.stampa();
				 return true;
			 }
			 else
				 return false;
		
	}
	
	/**
	 * metodo che fa scegliere al giocatore le coordinate tramite i tasti W A S D, o di tornare al menù
	 * @return ritorna le coordinate scelte, che verranno verificate
	 * @throws XMLStreamException 
	 * @throws InterruptedException 
	 */
	public boolean spostamento() throws InterruptedException, XMLStreamException {
		
		
		boolean giusto = false;
		System.out.println("digitare un comado per spostarsi oppure digitare - se si vuole aprire il menù:\n");
		comandi();
		String comando = InputDati.leggiStringaNonVuota(">");
		do {
			Coordinate attuali = gio.getPosizione();
			int r = attuali.getRiga();
			int c = attuali.getColonna();
			Coordinate prossime = new Coordinate(r,c);
			
			if (comando.equals("W")|| comando.equals("w")) {
				if (verificaCoordinate(prossime.diminuisciRiga())){
					mappa.diventa(attuali, ".");
					attuali.diminuisciRiga();
				return true;
				}
			}
			else if(comando.equals("D")||comando.equals("d")){
				if (verificaCoordinate(prossime.aumentaColonna())){
					mappa.diventa(attuali, ".");
					attuali.aumentaColonna();
				return true;
				}
			}
			else if(comando.equals("A")||comando.equals("a")){
				if (verificaCoordinate(prossime.diminuisciColonna())) {
					mappa.diventa(attuali, ".");
					attuali.diminuisciColonna();
				return true;
				}			
			}
			else if(comando.equals("S")||comando.equals("s")){
				if (verificaCoordinate(prossime.aumentaRiga())){
					mappa.diventa(attuali, ".");
					attuali.aumentaRiga();
				return true;
				}
			}
			else if (comando.equals("-"))
				return false;
			
			else 
				System.out.println("il comando digitato non è corretto, riprovare");
			comando = " ";
			comando = InputDati.leggiStringaNonVuota("digitare un comado per spostarsi oppure digitare - se si vuole aprire il menù:\n");
			
		}while(!giusto );
		return false;
		
	}
	
	/**
	 * metodo d'appoggio a spostamento
	 * @param prox
	 * @return
	 * @throws XMLStreamException 
	 * @throws InterruptedException 
	 */
	private boolean verificaCoordinate(Coordinate prox) throws InterruptedException, XMLStreamException {
		
		if (!(prox.getColonna()<=21 && prox.getColonna()>=0 &&
				prox.getRiga()<=21 && prox.getRiga()>=0)) {
			System.out.println("non tentar di uscir dal retto cammin!");
			return false;
		}
		if(!(mappa.verificaSegno(prox, "#"))) {
			compiEvento(prox);	
			mappa.diventa(prox, "O");
			return true;
		}
		else {
			System.out.println("selezionare una casella dove non c'è un muro, indicato da >#<");
			return false;
		}
	}
	
	/**
	 * metodo di stampa dei comandi disponibili per muoversi
	 */
	private void comandi() {
		System.out.printf("%8s\n", 'W');
		System.out.printf("%5s %5s\n", 'A', 'D');
		System.out.printf("%8s\n", 'S');
	}

//------------------------------------------------------------------eventi----------------------------------------------------------------
	
	private void compiEvento(Coordinate pos) throws InterruptedException, XMLStreamException {
		
		System.out.println(pos);
		if (mappa.verificaSegno(pos, ".")){			
		}
		else if (mappa.verificaSegno(pos, "M")) {
			combattiMostro();
		}
		else if (mappa.verificaSegno(pos, "S")) {
//			compraNegozio();
		}
		else if (mappa.verificaSegno(pos, "T")) {
			scaleSu();
		}
		else if (mappa.verificaSegno(pos, "t")) {
			scaleGiu();
		}
		else if (mappa.verificaSegno(pos, "b")) {
			combattiMostroScale();
		}
		else if (mappa.verificaSegno(pos, "P")) {
//			powerUp();
		}
		else if (mappa.verificaSegno(pos, "C")) {
			apriChest();
		}

	}




	/**
	 * metodo che scende di un piano
	 * @throws XMLStreamException
	 */
	private void scaleGiu() throws XMLStreamException {
		mappa = new Mappa(livelli.previous());
		System.out.println("forse è meglio tornare di sotto");
		mappa.stampa();
	
}


	/**
	 * metodo che sale di un piano
	 * @throws XMLStreamException
	 */
	private void scaleSu() throws XMLStreamException {
		mappa = new Mappa(livelli.next());
		System.out.println("complimenti, vediamo com'è il prossimo piano");
		mappa.stampa();

	}


	/**
	 * metodo che apre una chest sulla mappa e aggiunge il contenuto al giocatore se possibile
	 */
	private void apriChest() {
		
		System.out.println("proviamo ad aprire questa cassa:");
		Chest cassa = new Chest();
		Oggetto ogg = cassa.oggettoCasuale();
		System.out.println(ogg);
		if (ogg instanceof Arma) {
			if (InputDati.yesOrNo("si vuole cambiare la propria spada per questa?"))
				gio.setArma((Arma) ogg);
		}
		else if (ogg instanceof Scudo) {
		}
		else {
			if (InputDati.yesOrNo("si vuole prendere questa poszione?"))
				gio.aggiungiOggetto(((Pozioni) ogg));
		}

	}


//-----------------------------------------------------------combattimenti--------------------------------------------------

	private void combattiMostroScale() throws InterruptedException {
		Mostro mostroScale = new Mostro("Mostro scaloso", 30, 7);
		battaglia(mostroScale);

	}

	

	private void combattiMostro() throws InterruptedException {
		Mostro nuovo = new Mostro();
		battaglia(nuovo);

	}


	/**
	 * metodo principale dello scontro fra il personaggio e i mostri
	 * 
	 * @param gio personaggio
	 * @param mostro mostro
	 * @throws InterruptedException
	 */
	private void battaglia(Mostro mostro) throws InterruptedException {
		boolean entrambiVivi = true;
		while(entrambiVivi) {
			gio.colpo(mostro);
			entrambiVivi = gio.isVivo() && mostro.isVivo();
			if(entrambiVivi)
				mostro.colpo(gio);
			else 
				break;
			entrambiVivi = gio.isVivo() && mostro.isVivo();
		}
		
		if (!gio.isVivo())
			fine(gio);
		else 
			System.out.println("complimenti per aver sconfitto il mostro");
		
	}



	private void fine(Personaggio gio) throws InterruptedException {
		System.out.println("giocatore, il nostro viaggio è giunto al termine...");
		Thread.sleep(1500);
		System.out.println("dopo tante cruente battaglie, la tua vita si è consumata, così come la tua forza");
		Thread.sleep(1500);
		System.out.println("ma c'è ancora una speranza, infatti il Cerchio non ha finito con te");
		Thread.sleep(1500);
		System.out.println("si narra di battaglie ancor più gloriose per bottini più regali...");
		Thread.sleep(1500);
		System.out.println("ma ");
		for (int i = 0; i < 3; i++) {
			System.out.printf(".");
			Thread.sleep(1500);
		}
		System.out.println("questa è un'altra storia");
		Thread.sleep(500);
		System.out.println("FINE");
		
	}










	
	
	
	
}
