package themaopdracht.domein.klantenbinding;

public class Klant {
	private String naam;
	private String adres;
	private String emailAdres;
	private int klantNr;
	private boolean kredietWaardig;
	
	public Klant(String nm, String adr, String eAdr, int kNr){
		this.naam = nm;
		this.adres = adr;
		this.emailAdres = eAdr;
		this.klantNr = kNr;
		
		kredietWaardig = true;
	}
	
	public void setNaam(String nm) {
		naam = nm;
	}
	
	public void setAdres(String adr) {
		adres = adr;
	}
	
	public void setEmailAdres(String eAdr) {
		emailAdres = eAdr;
	}
	
	public String getNaam(){
		return naam;
	}
	
	public String getAdres(){
		return adres;
	}
	
	public String getEmailAdres(){
		return emailAdres;
	}
	
	public int getKlantNr(){
		return klantNr;
	}
	
	public boolean getKredietWaardig(){
		return kredietWaardig;
	}
	
	public void setKredietWaardig(boolean b){
		this.kredietWaardig = b;
	}
	
	public boolean equals(Object ander){
		boolean b;
		if(ander instanceof Klant){
			b = true;
		}
		else{
			b = false;
		}
		b = b && (this.naam.equals(((Klant)ander).naam));
		b = b && (this.adres.equals(((Klant)ander).adres));
		b = b && (this.emailAdres.equals(((Klant)ander).emailAdres));
		return b;
	}
	
	public String toString(){
		return klantNr + "\t\t" + naam;
	}
}
