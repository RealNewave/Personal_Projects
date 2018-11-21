package themaopdracht.domein.voorraadbeheer;

public class Brandstof extends Product{
	private enum Brandstoftype{BENZINE, DIESEL, ONBEKEND};
	private Brandstoftype type;
	private int aantalLiters;
	private String TSIC;
	
	public Brandstof(int pNr, String nm, int a, String t, String TSIC){
		super(pNr, nm);
		this.aantalLiters = a;
		this.TSIC = TSIC;
		if(t.equals("DIESEL")){
			this.type = Brandstoftype.DIESEL;
		} else if(t.equals("BENZINE")){
			this.type = Brandstoftype.BENZINE;
		} else{
			this.type = Brandstoftype.ONBEKEND;
		}
	}
	
	public Brandstoftype getType(){
		return type;
	}
	
	public int getAantalLiters(){
		return aantalLiters;
	}
	
	public void setAantalLiters(int aL) { //nieuw
		aantalLiters = aL;
	}
	
	public String getTSIC(){
		return TSIC;
	}
}
