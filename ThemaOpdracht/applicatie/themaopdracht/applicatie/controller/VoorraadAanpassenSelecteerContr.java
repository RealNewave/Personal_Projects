package themaopdracht.applicatie.controller;

import java.util.ArrayList;

import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import themaopdracht.domein.voorraadbeheer.Brandstof;
import themaopdracht.domein.voorraadbeheer.Product;
import themaopdracht.domein.voorraadbeheer.Voorraad;

public class VoorraadAanpassenSelecteerContr {
	private Voorraad voorraad;
	
	public VoorraadAanpassenSelecteerContr(Voorraad v){
		this.voorraad = v;
	}
	
	public ObservableList<Product> vulComboBoxMetProducten(){
		ObservableList<Product> producten = FXCollections.observableArrayList();
		for(Product p : voorraad.getAlleProducten()){
			producten.add(p);
		}
		return producten;
	}
	
	public ObservableList<Brandstof> vulComboBoxMetBrandstof(){
		ObservableList<Brandstof> alleBrandstof = FXCollections.observableArrayList();
		for(Brandstof b : voorraad.getAlleBrandstof()){
			alleBrandstof.add(b);
		}
		return alleBrandstof;	
	}
	
	public Product getEersteProduct(){
		ArrayList<Product> producten = voorraad.getAlleProducten();
		Product p = producten.get(0);
		return p;
	}
	
	public Brandstof getEersteBrandstof(){
		ArrayList<Brandstof> alleBrandstof = voorraad.getAlleBrandstof();
		Brandstof b = alleBrandstof.get(0);
		return b;
	}
}
