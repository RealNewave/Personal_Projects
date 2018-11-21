package themaopdracht.domein.voorraadbeheer;

public class Product {
	private int productNr;
	private String naam;
	private int aantal;
	private Leverancier deLeverancier;
	
	public Product(int pNr, String nm){
		this.productNr = pNr;
		this.naam = nm;
	}
	
	public Product(int pNr, String nm, int ant){
		this.productNr = pNr;
		this.naam = nm;
		this.aantal = ant;
	}
	
	public Product(int pNr, String nm, int ant, Leverancier l){
		this.productNr = pNr;
		this.naam = nm;
		this.aantal = ant;
		this.deLeverancier = l;
	}
	
	public int getProductNr(){
		return productNr;
	}
	
	public String getNaam(){
		return naam;
	}
	
	public int getAantal(){
		return aantal;
	}
	
	public Leverancier getLeverancier(){
		return deLeverancier;
	}
	
	public void setAantal(int ant){
		this.aantal = ant;
	}
	
	public void setLeverancier(Leverancier l){
		this.deLeverancier = l;
	}
	
	public boolean equals(Object ander){
		boolean b;
		if(ander instanceof Product){
			b = true;
		} else{
			b = false;
		}
		b = b && (this.naam.equals(((Product)ander).naam));
		return b;
	}
	
	public String toString(){
		return productNr + "\t" + naam;
	}
}
