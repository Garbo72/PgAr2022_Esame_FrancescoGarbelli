package it.unibs.esame;

import java.io.File;
import java.io.FileInputStream;
import java.util.ArrayList;

import javax.xml.stream.XMLInputFactory;
import javax.xml.stream.XMLStreamConstants;
import javax.xml.stream.XMLStreamException;
import javax.xml.stream.XMLStreamReader;


public class Xml {

	
	private final static String nomeFile = "livello1.xml";
	XMLInputFactory xmlif;
	XMLStreamReader xmlr ;

	public Xml(String nomeFile) {
		//this.nomeFile = nomeFile;
	}
	
	
	public String[][] creaMappa() throws XMLStreamException {
		
		 String [] [] creazioneMappa = null;
		 int indiceRiga=0;
		 int indiceColonna=0;
		 boolean rigachiusa=false;

			{
				try {
					xmlif = XMLInputFactory.newInstance();
					xmlr = xmlif.createXMLStreamReader(nomeFile , new FileInputStream(nomeFile));
			} catch (Exception e) {
			System.out.println("Errore nell'inizializzazione del reader:");
			System.out.println(e.getMessage());}
			}
			
			
			String next = null;
			//bisogna creare una persona con i dati del file e poi aggiungere la persona al vettore
			Mappa p = new Mappa();
			while (xmlr.hasNext()) { // continua a leggere finch� ha eventi a disposizione
				
				switch (xmlr.getEventType()) { // switch sul tipo di evento
				case XMLStreamConstants.START_DOCUMENT: // inizio del documento: stampa che inizia il documento
					//System.out.println("Start Read Doc " + filenamePersone); 
					break;
				
				case XMLStreamConstants.START_ELEMENT: // inizio di un elemento: stampa il nome del tag e i suoi attributi
				     if (xmlr.getLocalName().equals("mappa")) {
				    	 int height=0; int width =0;
				    	 for (int i = 0; i < xmlr.getAttributeCount(); i++) {
				    		 if(xmlr.getAttributeLocalName(i).equals("width")) {
				    			 width =Integer. parseInt(xmlr.getAttributeValue(i));
				    		 }
				    		 else if(xmlr.getAttributeLocalName(i).equals("height")) {
				    			 height =Integer. parseInt(xmlr.getAttributeValue(i));
				    		 }
				    	 }
				    	 creazioneMappa = new String [height][width];

				     }
				     else if (xmlr.getLocalName().equals("cell")) {
				    	next = "cell";
					     }
				     else if (xmlr.getLocalName().equals("row") && rigachiusa) {
					    	indiceRiga++;
					    	indiceColonna = 0;
					    	rigachiusa = false;
						     }
				     //System.out.println("open-Tag " + xmlr.getLocalName());
				
				case XMLStreamConstants.END_ELEMENT: // fine di un elemento: stampa il nome del tag chiuso
					 if (xmlr.getLocalName().equals("row")) {
						 rigachiusa = true;
				     } 
					//System.out.println("END-Tag " + xmlr.getLocalName()); 
					break;
				
				case XMLStreamConstants.CHARACTERS: // content all�interno di un elemento: stampa il testo
					if (xmlr.getText().trim().length() > 0) {// controlla se il testo non contiene solo spazi
						
						if (next.equals("cell"))
							creazioneMappa [indiceRiga][indiceColonna]= xmlr.getText();
				    	 System.out.println(indiceRiga +" "+ indiceColonna);
						indiceColonna++;
									
					}
				break;
				}
				xmlr.next();
				}
			
			return creazioneMappa;
		
	}
	
	
	
	
	
	
	

}
