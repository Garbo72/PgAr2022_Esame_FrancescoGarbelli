package it.unibs.esame;

public class Scudo extends Oggetto{
	
	public Scudo() {
		setVita(5);
	}
	
	@Override
	public String toString() {
		String mess = "questo scudo ha una vita di "+ getVita() + " unità";
		return mess;
	}
	

}
