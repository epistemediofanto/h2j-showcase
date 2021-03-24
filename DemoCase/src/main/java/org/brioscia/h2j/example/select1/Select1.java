package org.brioscia.h2j.example.select1;

import java.util.ArrayList;
import java.util.List;

import javax.annotation.PostConstruct;
import javax.enterprise.context.RequestScoped;
import javax.inject.Named;

@Named
@RequestScoped
public class Select1 {

	private List<SelectBean1> lista;
	private String valore;

	@PostConstruct
	private void init() {
		this.lista = new ArrayList<SelectBean1>();
		this.lista.add(new SelectBean1("Achille", "1-Achille"));
		this.lista.add(new SelectBean1("Maria", "2-Maria"));
	}

	public List<SelectBean1> getLista() {
		return lista;
	}

	public void setLista(List<SelectBean1> lista) {
		this.lista = lista;
	}

	public String getValore() {
		return valore;
	}

	public void setValore(String valore) {
		this.valore = valore;
	}

}
