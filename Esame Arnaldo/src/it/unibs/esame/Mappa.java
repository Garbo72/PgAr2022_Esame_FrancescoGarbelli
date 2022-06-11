package it.unibs.esame;

import java.io.File;

import javax.xml.stream.XMLStreamException;

public class Mappa {
	
	private String [] [] mappa;
	
	public Mappa(String nome) throws XMLStreamException {
		Xml comu = new Xml(nome);
		mappa = comu.creaMappa();
	}

	public Mappa() {
		
	}
	
	public void stampa() {
		for (int i=0; i<mappa.length; i++) {
			System.out.printf("      ");
			for (int j=0; j<mappa[0].length; j++) {
				System.out.printf(" "+ mappa[i][j]);
			}
			System.out.println();
		}
	}
	
	
	



}
