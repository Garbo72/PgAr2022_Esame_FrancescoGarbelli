package it.unibs.esame;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;
import java.util.Random;

public class Mostro extends Ruolo{

	String dij = " ";
	
	
	
	public Mostro(String nome, int vita, int attacco) {
		super(nome, vita, attacco);
	}
	
	public Mostro() {
		super(nomeCasuale(), vitaCasuale(),5 );
	}

	
	
	
	
	
	
	private static String nomeCasuale() {
		String nome = " ";
		ArrayList<String> poi = new ArrayList<>();
		poi.add("u");
		List<String> nomi = Arrays.asList("d", "i", "j", "k", "s", "t", "r","a");
		Collections.shuffle(nomi);
		for (String string : nomi) {
			nome +=string;
		}
		return nome;
	}

	private static int vitaCasuale() {
		int min = 15;
		int max = 25;
		Random rand = new Random();
		int randomNum = rand.nextInt((max - min) + 1) + min;
		return randomNum;
	}
	
	
	
	
	
}
