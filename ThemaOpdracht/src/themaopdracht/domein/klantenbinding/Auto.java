package themaopdracht.domein.klantenbinding;

import java.util.Calendar;

public class Auto {
	private String kenteken;
	private int aantalBeurtenPerJaar;
	private Calendar laatsteBezoek;
	private Calendar laatsteOnderhoud;
	private Klant eigenaar;
	
	public Auto(Klant eignr, String kt, int aBpJ){
		this.eigenaar = eignr;
		this.kenteken = kt;
		this.aantalBeurtenPerJaar = aBpJ;
	}
	
	public String getKenteken(){
		return kenteken;
	}
	
	public Klant getEigenaar(){
		return eigenaar;
	}
	
	public Calendar getLaatsteBezoek(){
		return laatsteBezoek;
	}
	
	public Calendar getLaatsteOnderhoud(){
		return laatsteOnderhoud;
	}
	
	public void setLaatsteBezoek(Calendar d){
		this.laatsteBezoek = d;
	}
	
	public void setLaatsteOnderhoud(Calendar d){
		this.laatsteOnderhoud = d;
	}
	
	public boolean toeAanOnderhoud(){
		//bekijk in de hoeveel maanden de auto op controle moet
		int frequentie = 12 / aantalBeurtenPerJaar;
		Calendar vergelijkDatum = Calendar.getInstance();
		vergelijkDatum.add(Calendar.MONTH, -frequentie);
		//controleer of termijn verstreken is
		if(laatsteOnderhoud != null && laatsteOnderhoud.before(vergelijkDatum)){
			return true;
		}
		return false;
	}
	
	public boolean equals(Object ander){
		boolean b;
		if(ander instanceof Auto){
			b = true;
		}
		else{
			b = false;
		}
		b = b && (this.eigenaar.equals(((Auto)ander).eigenaar));
		b = b && (this.kenteken.equals(((Auto)ander).kenteken));
		b = b && (this.aantalBeurtenPerJaar == (((Auto)ander).aantalBeurtenPerJaar));
		return b;
	}
	
	public String toString(){
		return eigenaar.getNaam() + "\t\t" + kenteken + "\t\t" + aantalBeurtenPerJaar;
	}
}
