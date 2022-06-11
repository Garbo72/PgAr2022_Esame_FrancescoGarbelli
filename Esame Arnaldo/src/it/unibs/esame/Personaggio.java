package it.unibs.esame;

import java.util.ArrayList;

import it.unibs.mylib.InputDati;

public class Personaggio extends Ruolo{

	private boolean chiaveScale = false;
	private boolean impugnaOggetto = false;
	private boolean impugnascudo = false;
	private Scudo scudo;
	private ArrayList<Oggetto> inventario = new ArrayList<>();
	
	
	public Personaggio(String nome) {
		super(nome, 20, new Coordinate(21, 0));
	}


	public boolean isChiaveScale() {
		return chiaveScale;
	}

	public void setChiaveScale(boolean chiaveScale) {
		this.chiaveScale = chiaveScale;
	}
	
	public void aggiungiOggetto(Oggetto o) {
		inventario.add(o);
	}
	public void togliOggetto(Oggetto o) {
		inventario.remove(o);
	}
	
	public void mostraInventario() {
		for (Oggetto oggetto : inventario) {
			System.out.println(oggetto);
		}
	}
	
	
	
	
	

}
