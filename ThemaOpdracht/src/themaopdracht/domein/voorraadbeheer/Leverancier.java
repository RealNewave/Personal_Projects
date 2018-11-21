package themaopdracht.domein.voorraadbeheer;

public class Leverancier {
	private String naam;
	private String adres;
	private String emailAdres;
	
	public Leverancier(String nm, String ad, String eAd){
		this.naam = nm;
		this.adres = ad;
		this.emailAdres = eAd;
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
	
	public boolean equals(Object ander){
		boolean b;
		if(ander instanceof Leverancier){
			b = true;
		} else{
			b = false;
		}
		b = b && (this.naam.equals(((Leverancier)ander).naam));
		b = b && (this.adres.equals(((Leverancier)ander).adres));
		b = b && (this.emailAdres.equals(((Leverancier)ander).emailAdres));
		return b;
	}
	
	public String toString(){
		return naam + "\t\t\t" + adres + "\t\t\t" + emailAdres;
	}
}
