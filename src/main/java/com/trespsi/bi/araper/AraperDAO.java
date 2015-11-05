package com.trespsi.bi.araper;

import java.util.List;
import java.util.ArrayList;

public class AraperDAO {

	// public List<Estructura> listarEstructuraA(){
	// List<Estructura> lEstructura = new ArrayList<Estructura>();
	// Estructura estru = new Estructura();
	// estru.setNombreCelda("nombre personal");
	// estru.setPosicionCSV(1);
	// lEstructura.add(estru);
	// estru = new Estructura();
	// estru.setNombreCelda("apellidos");
	// estru.setPosicionCSV(2);
	// lEstructura.add(estru);
	// estru = new Estructura();
	// estru.setNombreCelda("edad");
	// estru.setPosicionCSV(3);
	// lEstructura.add(estru);
	// return lEstructura;
	// }

	public List<Estructura> listarEstructura() {
		List<Estructura> lEstructura = new ArrayList<Estructura>();
		Estructura estru = new Estructura();
		estru.setNombreCelda("nombre personal");
		estru.setPosicionCSV(1);
		estru.setTipo("string");
		estru.setObligatorio(true);
		lEstructura.add(estru);
		estru = new Estructura();
		estru.setNombreCelda("apellidos");
		estru.setPosicionCSV(2);
		estru.setTipo("string");
		estru.setObligatorio(true);
		lEstructura.add(estru);
		estru = new Estructura();
		estru.setNombreCelda("edad");
		estru.setPosicionCSV(3);
		estru.setTipo("integer");
		estru.setObligatorio(true);
		lEstructura.add(estru);
		estru = new Estructura();
		estru.setNombreCelda("departamento");
		estru.setPosicionCSV(4);
		estru.setTipo("string");
		estru.setObligatorio(true);
		lEstructura.add(estru);
		estru = new Estructura();
		estru.setNombreCelda("precio de lista");
		estru.setPosicionCSV(5);
		estru.setTipo("decimal");
		estru.setObligatorio(true);
		lEstructura.add(estru);

		estru = new Estructura();
		estru.setNombreCelda("enero");
		estru.setPosicionCSV(7);
		estru.setTipo("integer");
		lEstructura.add(estru);
		estru = new Estructura();
		estru.setNombreCelda("febrero");
		estru.setPosicionCSV(7);
		estru.setTipo("integer");
		lEstructura.add(estru);
		estru = new Estructura();
		estru.setNombreCelda("marzo");
		estru.setPosicionCSV(7);
		estru.setTipo("integer");
		lEstructura.add(estru);
		estru = new Estructura();
		estru.setNombreCelda("abril");
		estru.setPosicionCSV(7);
		estru.setTipo("integer");
		lEstructura.add(estru);
		estru = new Estructura();
		estru.setNombreCelda("mayo");
		estru.setPosicionCSV(7);
		estru.setTipo("integer");
		lEstructura.add(estru);
		estru = new Estructura();
		estru.setNombreCelda("junio");
		estru.setPosicionCSV(7);
		estru.setTipo("integer");
		lEstructura.add(estru);
		estru = new Estructura();
		estru.setNombreCelda("julio");
		estru.setPosicionCSV(7);
		estru.setTipo("integer");
		lEstructura.add(estru);
		estru = new Estructura();
		estru.setNombreCelda("agosto");
		estru.setPosicionCSV(7);
		estru.setTipo("integer");
		lEstructura.add(estru);
		estru = new Estructura();
		estru.setNombreCelda("septiembre");
		estru.setPosicionCSV(7);
		estru.setTipo("integer");
		lEstructura.add(estru);
		estru = new Estructura();
		estru.setNombreCelda("octubre");
		estru.setPosicionCSV(7);
		estru.setTipo("integer");
		lEstructura.add(estru);
		estru = new Estructura();
		estru.setNombreCelda("noviembre");
		estru.setPosicionCSV(7);
		estru.setTipo("integer");
		lEstructura.add(estru);
		estru = new Estructura();
		estru.setNombreCelda("diciembre");
		estru.setPosicionCSV(7);
		estru.setTipo("integer");
		lEstructura.add(estru);

		return lEstructura;
	}

}
