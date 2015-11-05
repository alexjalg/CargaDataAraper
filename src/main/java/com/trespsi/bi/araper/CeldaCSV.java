package com.trespsi.bi.araper;

public class CeldaCSV implements Comparable<CeldaCSV> {
	private int posicion = 0;
	private String valor = "";

	public int getPosicion() {
		return posicion;
	}

	public void setPosicion(int posicion) {
		this.posicion = posicion;
	}

	public String getValor() {
		return valor;
	}

	public void setValor(String valor) {
		this.valor = valor;
	}

	public int compareTo(CeldaCSV o) {
		String a = new String(String.valueOf(this.getPosicion()));
		String b = new String(String.valueOf(o.getPosicion()));
		return a.compareTo(b);
	}

}
