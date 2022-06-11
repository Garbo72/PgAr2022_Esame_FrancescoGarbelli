package it.unibs.esame;

import javax.xml.stream.XMLStreamException;


public class Mappa {
	
	private String [] [] mappa;
	
	public Mappa(String nome) throws XMLStreamException {
		Xml comu = new Xml(nome);
		mappa = comu.creaMappa();
	}

	public Mappa() {

	}
	

	/**
	 * metodo di stampa della mappa
	 */
	public void stampa() {
		for (int i=0; i<mappa.length; i++) {
			System.out.printf("      ");
			for (int j=0; j<mappa[0].length; j++) {
				System.out.printf(" "+ mappa[i][j]);
			}
			System.out.println();
		}
	}

	public void diventa(Coordinate attuali, String segno) {
		mappa[attuali.getRiga()][attuali.getColonna()] = segno; 
		
	}
	
	public boolean verificaSegno(Coordinate xy, String segno) {
		return mappa[xy.getRiga()][xy.getColonna()].equals(segno);
	}

	
	
	



}
