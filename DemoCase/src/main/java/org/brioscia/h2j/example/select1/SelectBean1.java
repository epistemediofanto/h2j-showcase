package org.brioscia.h2j.example.select1;

import java.io.Serializable;

public class SelectBean1 implements Serializable {

	private static final long serialVersionUID = 1L;

	private String nome;
	private String valore;
	
	public SelectBean1() {}
	
	public SelectBean1(String nome, String valore) {
		this.nome = nome;
		this.valore = valore;
	}
	
	public String getNome() {
		return nome;
	}
	public void setNome(String nome) {
		this.nome = nome;
	}
	public String getValore() {
		return valore;
	}
	public void setValore(String valore) {
		this.valore = valore;
	}
	
}
