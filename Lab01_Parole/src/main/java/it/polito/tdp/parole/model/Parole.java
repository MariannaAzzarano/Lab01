package it.polito.tdp.parole.model;

import java.util.ArrayList;
import java.util.Collections;
import java.util.LinkedList;
import java.util.List;

public class Parole {
	
	List<String> listaParole;
		
	public Parole() {
		listaParole = new LinkedList<String>();     //per fare ultimo punto cambio solo LinkedList o ArrayList!!!
	}
	
	public void addParola(String p) {
		listaParole.add(p);
	}
	
	public List<String> getElenco() {
		ComparatoreParole c = new ComparatoreParole();
		Collections.sort(listaParole, c);
		return listaParole;
	}
	
	public void reset() {
		listaParole.clear();
	}
	
	public void cancella(String daCancellare) {
		listaParole.remove(daCancellare);       //funziona o devo eliminare l'oggetto anzichè la stringa
	}

}
