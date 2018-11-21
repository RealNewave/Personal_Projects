package themaopdracht.domein.voorraadbeheer;
import java.util.ArrayList;

import themaopdracht.domein.exceptions.ExistingInstanceException;
/**
 * 
 * @author Rogier Pijpers
 * 
 *Voorraad heeft een ArrayList van de klasse Product
 *en een ArrayList van de klasse Leveranciers.
 *alle producten en leveranciers worden binnen deze klasse Voorraad opgeslagen.
 *
 * getAlleProductNamen() - geeft een ArrayList van alle namen van de producten
 * door deze methode is het makkelijk om bijvoorbeeld een combobox met namen te vullen
 * 
 * Verder is er voor elke ArrayList een voeg toe, verwijder en zoek methode.
 * 
 * toString() - geeft een overzicht van alle aanwezige producten.
 * 
 */

public class Voorraad {
	private ArrayList<Product> producten;
	private ArrayList<Brandstof> alleBrandstof;
	private ArrayList<Leverancier> alleLeveranciers;
	
	public Voorraad(){
		producten = new ArrayList<Product>();
		alleBrandstof = new ArrayList<Brandstof>();
		alleLeveranciers = new ArrayList<Leverancier>();
		
		try {
			Leverancier l1 = new Leverancier("Henk van Dijk", "Nijenoord 1", "gekkehenkie@gmail.com");
			Leverancier l2 = new Leverancier("Jan-peter Balkenende", "'t Binnenhof", "normenenwaarden@balkenende.net");
			Leverancier l3 = new Leverancier("Brandstofboer", "Shell express", "kerozine@zonnet.nl");
			voegProductToe("Stuurkogel", 15, l1);
			voegProductToe("Carterpan", 4, l1);
			voegProductToe("Stuur", 5, l1);
			voegProductToe("Bougie", 89, l2);
			voegProductToe("Fusékogel", 53, l2);
			voegProductToe("Velg", 18, l2);
			voegBrandstofToe("Euro 95", 400, "BENZINE", "ID-481-SHELL", l3);
			voegBrandstofToe("V-Power", 600, "BENZINE", "ID-666-SHELL", l3);
			voegBrandstofToe("Diesel", 200, "DIESEL", "ID-354-BP", l3);
		} catch (ExistingInstanceException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		
	}
	
	public ArrayList<Product> getAlleProducten(){
		return producten;
	}
	
	public ArrayList<Brandstof> getAlleBrandstof(){
		return alleBrandstof;
	}
	
	public void voegProductToe(String nm, int ant, Leverancier l) throws ExistingInstanceException{
		//genereer opvolgend nummer
		int nr = 1;
		if(!producten.isEmpty()){
			Product pTemp = producten.get(producten.size() -1);
			nr = pTemp.getProductNr() + 1;
		}
		//
		Product p = new Product(nr, nm, ant);
		p.setLeverancier(l);
		//controleer of object nog niet bestaat
		if(!producten.contains(p)){
			producten.add(p);
		} else{
			throw new ExistingInstanceException();
		}
	}
	
	public void voegBrandstofToe(String nm, int ant, String type, String TSIC, Leverancier l) throws ExistingInstanceException{
		int nr = 1;
		if(!alleBrandstof.isEmpty()){
			Product pTemp = alleBrandstof.get(alleBrandstof.size() -1);
			nr = pTemp.getProductNr() + 1;
		}
		Brandstof b = new Brandstof(nr, nm, ant, type, TSIC);
		b.setLeverancier(l);
		if(!alleBrandstof.contains(b)){
			alleBrandstof.add(b);
		} else{
			throw new ExistingInstanceException();
		}
	}
	
	public void verwijderProduct(String nm){
		Product p = zoekProduct(nm);
		producten.remove(p);
	}
	
	public void voegLeverancierToe(String nm, String adr, String eAdr) throws ExistingInstanceException{
		Leverancier l = new Leverancier(nm, adr, eAdr);
		//controleer of object nog niet bestaat
		if(!alleLeveranciers.contains(l)){
			alleLeveranciers.add(l);
		} else{
			throw new ExistingInstanceException();
		}
	}
	
	public void verwijderLeverancier(String nm){
		for(Leverancier l : alleLeveranciers){
			if(l.getNaam().equals(nm)){
				alleLeveranciers.remove(l);
			}
		}
	}
	
	public Product zoekProduct(String nm){
		Product resultaat = null;
		for(Product p : producten){
			if(p.getNaam().equals(nm)){
				resultaat = p;
			}
		}
		return resultaat;
	}
	
	public Leverancier zoekLeverancier(String nm){
		Leverancier resultaat = null;
		for(Leverancier l : alleLeveranciers){
			if(l.getNaam().equals(nm)){
				resultaat = l;
			}
		}
		return resultaat;
	}
	
	public String toString(){
		String a = "nr:\t\t\taantal:\t\t\tnaam:\n";
		String b = "";
		for(Product p : producten){
			b += p.toString() + "\n";
		}
		return a + b;
	}
}
