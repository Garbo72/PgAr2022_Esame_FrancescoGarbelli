package it.unibs.esame;


public class Chest {
	
	private double probArmi = 0.4;
	private double probScudi = 0.35;
	private double probPozioni = 0.25;
	
	public Oggetto oggettoCasuale() 
	{
		double casuale = Math.random();
		
		if ( casuale <  probArmi)
		{
			System.out.println("complimenti, hai trovato una spada!");
			return new Arma();
			
		}
		else
		if ( casuale < (probArmi+probScudi) )
		{
			System.out.println("complimenti, hai trovato uno scudo!");
			return new Scudo(); 
		}
		else
		{
			System.out.println("complimenti, hai trovato una pozione!");
			return new Pozioni(); 
		}
	}
	
	
	

}
