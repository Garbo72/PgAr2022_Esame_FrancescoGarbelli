package it.unibs.esame;

public class Coordinate {

	 private int riga;
	 private int colonna;
	 
		
	 public Coordinate (int r, int c)
		{
		  riga=r;
		  colonna=c;
		}
		

	 public int getRiga() {
		return riga;
	}


	public void setRiga(int riga) {
		this.riga = riga;
	}


	public int getColonna() {
		return colonna;
	}


	public void setColonna(int colonna) {
		this.colonna = colonna;
	}


	public Coordinate aumentaColonna() {
		 this.colonna++;

		return this;
	 }
	 public Coordinate diminuisciColonna() {
		 this.colonna--;

		 return this;
	 }
	 public Coordinate aumentaRiga() {
		 this.riga++;

		 return this;
	 }
	 public Coordinate diminuisciRiga() {
		 this.riga--;

		 return this;
	 }


	 public String toString()
		{
		 return "RIGA:" + (riga) + ";COLONNA:" + (colonna);
		}


}


