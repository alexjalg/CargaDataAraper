package com.trespsi.bi.araper;

public class Estructura {
	private String nombreCelda = "";
	private int posicionExcel = 0;
	private int posicionCSV = 0;
	private boolean existe = false;
	private boolean existeEnElFormato = false;
	private boolean obligatorio = false;
	private String tipo = "";

	public String getNombreCelda() {
		return nombreCelda;
	}

	public void setNombreCelda(String nombreCelda) {
		this.nombreCelda = nombreCelda;
	}

	public int getPosicionExcel() {
		return posicionExcel;
	}

	public void setPosicionExcel(int posicionExcel) {
		this.posicionExcel = posicionExcel;
	}

	public int getPosicionCSV() {
		return posicionCSV;
	}

	public void setPosicionCSV(int posicionCSV) {
		this.posicionCSV = posicionCSV;
	}

	public boolean isExiste() {
		return existe;
	}

	public void setExiste(boolean existe) {
		this.existe = existe;
	}

	public boolean isExisteEnElFormato() {
		return existeEnElFormato;
	}

	public void setExisteEnElFormato(boolean existeEnElFormato) {
		this.existeEnElFormato = existeEnElFormato;
	}

	public String getTipo() {
		return tipo;
	}

	public void setTipo(String tipo) {
		this.tipo = tipo;
	}

	public boolean isObligatorio() {
		return obligatorio;
	}

	public void setObligatorio(boolean obligatorio) {
		this.obligatorio = obligatorio;
	}

}
