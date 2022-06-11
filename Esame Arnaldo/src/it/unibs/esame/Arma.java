package it.unibs.esame;

import java.util.Random;

public class Arma extends Oggetto{
	
	public Arma() {
		setPotenza(potenzaCasuale());
	}
	
	
	private static int potenzaCasuale() {
		int min = 35;
		int max = 55;
		Random rand = new Random();
		int randomNum = rand.nextInt((max - min) + 1) + min;
		return randomNum;
	}
	
	@Override
	public String toString() {
		String mess = "questa spada ha una potenza di " + getPotenza();
		if (getPotenza() > 40)
			mess +=  ", è l'ideale per uccidere mostri";
		else if (getPotenza()  >53)
			mess +=  ", è un'ammazza titani";
		else 
			mess +=  ", non è prorpio il massimo, ma di sicuro meglio che a mani nude";
		return mess;
	}
	
	
}
