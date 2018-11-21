package themaopdracht.domein.klantenbinding;

import java.util.ArrayList;
import java.util.Calendar;

import themaopdracht.domein.exceptions.ExistingInstanceException;

/**
 * 
 * @author Rogier Pijpers
 *
 *Klantbeheer bevat een ArrayList van de klasse Klant en
 *een ArrayList van de klasse Auto.
 *alle auto's en klanten worden binnen deze klasse Klantbeheer opgeslagen.
 *
 *Elke list heeft een zoek en voeg toe methode.
 *De lijst van klanten heeft een verwijdermethode.
 *Wanneer de klant verwijderd wordt, worden alle auto's van deze klant ook verwijderd.
 *
 *voegKlantToe() - genereert zelf een opvolgend klantnummer
 *
 *getKlantenToeAanOnderhoud() - returned een ArrayList met daar in alle klanten die een
 *auto hebben waar van de onderhoudsperiode overschreden is.
 *
 *getKlantenMaandenAfwezig(aantalMaanden) - returned een ArrayList met alle klanten die langer dan
 *een bepaalde periode niet langs zijn geweest.
 *@aantalMaanden - de periode waarin klanten niet langs zijn geweest
 */

public class Klantbeheer {
	private ArrayList<Klant> alleKlanten;
	private ArrayList<Auto> alleAutos;

	public Klantbeheer() {
		alleKlanten = new ArrayList<Klant>();
		alleAutos = new ArrayList<Auto>();
		
		//TEST //TEST //TEST //TEST //TEST //TEST //TEST 
		try {
			voegKlantToe("Wesley Noordam", "De Groendijck", "wesley@live.com");
			voegKlantToe("Henk van Dijk", "Nijenoord", "info@henk.nl");
			voegKlantToe("Jan-Peter Balkenende", "Binnenhof", "petertje@gmail.com");
			Klant k1 = zoekKlant("Wesley Noordam");
			Klant k2 = zoekKlant("Henk van Dijk");
			Klant k3 = zoekKlant("Jan-Peter Balkenende");
			voegAutoToe(k1, "RL-BS-29", 1);
			voegAutoToe(k2, "KM-69-ZG", 2);
			voegAutoToe(k3, "ZW-66-6Z", 1);
			Auto a1 = zoekAuto("RL-BS-29");
			Auto a2 = zoekAuto("KM-69-ZG");
			Auto a3 = zoekAuto("ZW-66-6Z");
			
			Calendar d1 = Calendar.getInstance();
			d1.add(Calendar.MONTH, -13);
			a1.setLaatsteBezoek(d1);
			a1.setLaatsteOnderhoud(d1);
			
			Calendar d2 = Calendar.getInstance();
			d2.add(Calendar.MONTH, -7);
			a2.setLaatsteBezoek(d2);
			a2.setLaatsteOnderhoud(d2);
			
			Calendar d3 = Calendar.getInstance();
			d3.add(Calendar.MONTH, -11);
			Calendar d4 = Calendar.getInstance();
			d4.add(Calendar.MONTH, -5);
			a3.setLaatsteBezoek(d4);
			a3.setLaatsteOnderhoud(d3);
		} catch (ExistingInstanceException e) {
			e.printStackTrace();
		}
		//TEST //TEST //TEST //TEST //TEST //TEST //TEST //TEST 
	}

	public ArrayList<Klant> getKlantenToeAanOnderhoud() {
		ArrayList<Klant> klantenOnderhoud = new ArrayList<Klant>();
		for (Auto a : alleAutos) {
			if (a.toeAanOnderhoud()) {
				Klant k = a.getEigenaar();
				if (!klantenOnderhoud.contains(k)) {
					klantenOnderhoud.add(k);
				}
			}
		}
		return klantenOnderhoud;
	}

	public Klant zoekKlantBijAuto(Auto a) {
		Klant resultaat = a.getEigenaar();
		return resultaat;
	}

	public ArrayList<Klant> getKlantenMaandenAfwezig(int aantalMaanden) {
		ArrayList<Klant> afwezigeKlanten = new ArrayList<Klant>();
		// Maakt een vergelijkingsdatum aan van variabele 'aantalMaanden'
		// geleden
		Calendar vergelijkDatum = Calendar.getInstance();
		vergelijkDatum.add(Calendar.MONTH, -aantalMaanden);
		//
		for (Auto a : alleAutos) {
			if (a.getLaatsteBezoek() != null
					&& a.getLaatsteBezoek().before(vergelijkDatum)) {
				Klant k = a.getEigenaar();
				if (!afwezigeKlanten.contains(k)) {
					afwezigeKlanten.add(k);
				}
			}
		}
		return afwezigeKlanten;
	}

	public Klant zoekKlant(String nm) {
		Klant resultaat = null;
		for (Klant k : alleKlanten) {
			if (k.getNaam().equals(nm)) {
				resultaat = k;
			}
		}
		return resultaat;
	}
	
	public ArrayList<Klant> getAlleKlanten(){
		return alleKlanten;
	}

	public Auto zoekAuto(String kt) {
		Auto resultaat = null;
		for (Auto a : alleAutos) {
			if (a.getKenteken().equals(kt)) {
				resultaat = a;
			}
		}
		return resultaat;
	}

	public void voegKlantToe(String nm, String adr, String eAdr)throws ExistingInstanceException {
		// genereer klantNr;
		int nr = 1;
		if (!alleKlanten.isEmpty()) {
			Klant kTemp = alleKlanten.get(alleKlanten.size() - 1);
			nr = kTemp.getKlantNr() + 1;
		}
		//
		Klant k = new Klant(nm, adr, eAdr, nr);
		if (!alleKlanten.contains(k)) {
			alleKlanten.add(k);
		} else{
			throw new ExistingInstanceException();
		}
	}

	public void voegAutoToe(Klant eignr, String kt, int aBpJ) throws ExistingInstanceException{
		Auto a = new Auto(eignr, kt, aBpJ);
		if (!alleAutos.contains(a)) {
			alleAutos.add(a);
		} else{
			throw new ExistingInstanceException();
		}
	}

	public void verwijderKlant(Klant k) {
		//creëer een bin van alle auto's van de betreffende klant
		ArrayList<Auto> bin = new ArrayList<Auto>();
		for(Auto a : alleAutos){
			if(a.getEigenaar().equals(k)){
				bin.add(a);
			}
		}
		//verwijder alle auto's van de klant
		alleAutos.removeAll(bin);
		//
		alleKlanten.remove(k);
	}

	public String toString() {
		String s = "";
		for (Klant k : alleKlanten) {
			s += k + "\n";
		}
		for (Auto a : alleAutos) {
			s += a + "\n";

		}
		return s;
	}
}
