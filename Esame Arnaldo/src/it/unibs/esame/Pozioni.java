package it.unibs.esame;

public class Pozioni extends Oggetto{

	public Pozioni() {
		setRecupero(.5);
	}

	@Override
	public String toString() {
		String mess = "questa pozione ti ridar� met� della tua vita" ;
		return mess;
	}

}
