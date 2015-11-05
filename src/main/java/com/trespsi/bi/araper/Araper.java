package com.trespsi.bi.araper;

import java.io.File;
import java.util.Collections;
import java.util.List;

public class Araper {

	private String rutaArchivos = "C:\\araper";

	public File[] listarArchivos() {
		File[] ficheros = null;
		File f = new File(this.rutaArchivos);
		if (f.exists()) {
			ficheros = f.listFiles();
		}
		return ficheros;
	}

	public void generarCSV() {
		String nombre = "";
		String tipo = "";
		String fecha = "";
		File[] ficheros = this.listarArchivos();
		Excel excel = null;
		for (int x = 0; x < ficheros.length; x++) {
			nombre = ficheros[x].getName().trim();
			fecha = nombre.substring(3, 13);
			tipo = nombre.substring(0, 2);

			excel = new Excel(ficheros[x]);
			excel.cargarData();

			System.out.println(nombre + "  " + fecha + "  " + tipo);

			// if (nombre.indexOf("LI") >= 0) {
			// } else if (nombre.indexOf("CO") >= 0) {
			// } else if (nombre.indexOf("CA") >= 0) {
			// } else if (nombre.indexOf("OM") >= 0) {
			// }

		}
	}

	public static void main(String[] args) {
		// Araper araper = new Araper();
		// araper.generarCSV();
		Excel excel = new Excel("C:\\xls\\alejo.xlsx");
		excel.setNumeroMes(1);
		excel.cargarData();
//		System.out.println();
//		for (Estructura e : excel.getlEstructura()) {
//			System.out.println(e.getPosicionCSV() + " " + e.getNombreCelda()
//					+ " " + e.isObligatorio());
//		}
//		System.out.println();

		for (List<CeldaCSV> list : excel.getlData()) {
			Collections.sort(list);
			for (CeldaCSV celda : list) {
				System.out
						.println(celda.getPosicion() + " " + celda.getValor());
			}
			System.out.println("--- :)=");
		}

	}

}
