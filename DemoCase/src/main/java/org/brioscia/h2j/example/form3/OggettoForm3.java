package org.brioscia.h2j.example.form3;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import javax.enterprise.context.RequestScoped;
import javax.inject.Named;

@Named
@RequestScoped
public class OggettoForm3 {

	private List<Dato3> dati;
	
	public OggettoForm3() {
		this.dati = new ArrayList<Dato3>();
		this.dati.add(new Dato3("Maria", "Sany", new Date()));
		this.dati.add(new Dato3("Anna", "Maria", new Date()));
	}

	public String addDato(Dato3 d) {
		this.dati.add(d);
		return "target.xhtml";
	}

	public List<Dato3> getDati() {
		return dati;
	}

	public void setDati(List<Dato3> dati) {
		this.dati = dati;
	}

}
