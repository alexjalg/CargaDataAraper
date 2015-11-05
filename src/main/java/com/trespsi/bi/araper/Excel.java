package com.trespsi.bi.araper;

import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

import org.apache.poi.openxml4j.exceptions.InvalidFormatException;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.ss.usermodel.WorkbookFactory;

public class Excel {

	private List<List<CeldaCSV>> lData = new ArrayList<List<CeldaCSV>>();;
	private List<Estructura> lEstructuraReal = new ArrayList<Estructura>();
	private List<Estructura> lEstructura = new ArrayList<Estructura>();
	private String ruta = "";
	private int numeroMes = 0;
	private File file = null;

	public Excel(String ruta) {
		this.ruta = ruta;
		this.file = new File(ruta);
	}

	public Excel(File file) {
		this.file = file;
	}

	@SuppressWarnings("rawtypes")
	public Iterator listarData() {
		Workbook wb = null;
		// Abrimos el archivo excel
		try {
			// wb = WorkbookFactory.create(new File("C:\\xls\\alejo.xlsx"));
			wb = WorkbookFactory.create(this.file);
		} catch (InvalidFormatException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		}
		// Abrimos la hojita
		if (wb == null)
			return null;
		Sheet sheet = wb.getSheetAt(0);
		// obtenemos la data
		return sheet.rowIterator();
	}

	@SuppressWarnings("rawtypes")
	private void cargarEstructuraReal(Iterator iterator) {
		Estructura estructura = null;
		int numUltimaCelda = 0;
		String nombreCelda = "";
		boolean existe = false;
		if (iterator.hasNext()) {
			Row row = (Row) iterator.next();
			String cellValue = "";
			numUltimaCelda = row.getLastCellNum();
			for (int i = 0; i < numUltimaCelda; i++) {
				cellValue = row.getCell(i).toString().trim();
				cellValue = cellValue.replace(" ", "").toLowerCase();
				existe = false;
				for (Estructura e : lEstructura) {
					nombreCelda = e.getNombreCelda().trim();
					nombreCelda = nombreCelda.replace(" ", "").toLowerCase();
					if (cellValue.indexOf(nombreCelda) > -1) {
						existe = true;
						estructura = new Estructura();
						estructura.setPosicionCSV(e.getPosicionCSV());
						estructura.setNombreCelda(e.getNombreCelda().trim());
						estructura.setTipo(e.getTipo());
						
						if (cellValue.indexOf(dateMonth(numeroMes)) > -1) {
							estructura.setObligatorio(true);
						} else {
							estructura.setObligatorio(e.isObligatorio());
						}

						estructura.setPosicionExcel(i);
						estructura.setExiste(true);
						estructura.setExisteEnElFormato(true);
						this.lEstructuraReal.add(estructura);
						break;
					}
				}
				if (!existe) {
					System.out.println(cellValue + ": Esta fila no corresponde al formato");
				}
			}
		}
	}

	private void cargarFaltantes() {
		Estructura estructura = null;
		boolean noExiste = true;
		String nombreCelda = "";
		String nombreCelda2 = "";
		for (Estructura e : this.lEstructura) {
			noExiste = true;
			if (e.isObligatorio()) {
				nombreCelda = e.getNombreCelda().trim();
				nombreCelda = nombreCelda.replace(" ", "").toLowerCase();
				for (Estructura e2 : this.lEstructuraReal) {
					nombreCelda2 = e2.getNombreCelda().trim();
					nombreCelda2 = nombreCelda2.replace(" ", "").toLowerCase();
					if (nombreCelda.indexOf(nombreCelda2) > -1) {
						noExiste = false;
					}
				}
				if (noExiste) {
					estructura = new Estructura();
					estructura.setPosicionCSV(e.getPosicionCSV());
					estructura.setNombreCelda(e.getNombreCelda().trim());
					estructura.setObligatorio(e.isObligatorio());
					estructura.setTipo(e.getTipo());
					estructura.setPosicionExcel(-1);
					estructura.setExiste(false);
					estructura.setExisteEnElFormato(false);
					this.lEstructuraReal.add(estructura);
				}
			}
		}
	}

	@SuppressWarnings("rawtypes")
	public void cargarData() {
		AraperDAO dao = new AraperDAO();
		Iterator iterator = this.listarData();
		lEstructura = dao.listarEstructura();
		int numUltimaCelda = 0;
		this.cargarEstructuraReal(iterator);
		this.cargarFaltantes();

		List<CeldaCSV> lCelda;
		CeldaCSV celda;
		while (iterator.hasNext()) {
			Row row = (Row) iterator.next();
			lCelda = new ArrayList<CeldaCSV>();
			numUltimaCelda = row.getLastCellNum();
			for (int i = 0; i < numUltimaCelda; i++) {
				for (Estructura e : lEstructuraReal) {
					if (e.getPosicionExcel() == i && e.isObligatorio()) {
						// if (e.getNombreCelda().equalsIgnoreCase("acumulado"))
						// {
						// celda = new CeldaCSV();
						// celda.setPosicion(e.getPosicionCSV());
						// celda.setValor(row.getCell(i - 1).toString());
						// lCelda.add(celda);
						// break;
						// } else {
						celda = new CeldaCSV();
						celda.setPosicion(e.getPosicionCSV());
						celda.setValor(row.getCell(i).toString());
						lCelda.add(celda);
						break;
						// }
					}
				}

			}
			for (Estructura e : lEstructuraReal) {
				if (e.getPosicionExcel() == -1) {
					celda = new CeldaCSV();
					celda.setPosicion(e.getPosicionCSV());
					if (e.getTipo().equalsIgnoreCase("string")) {
						celda.setValor("");
					} else if (e.getTipo().equalsIgnoreCase("integer")) {
						celda.setValor("0");
					} else if (e.getTipo().equalsIgnoreCase("decimal")) {
						celda.setValor("0.0");
					}

					lCelda.add(celda);
				}
			}
			lData.add(lCelda);
		}
	}

	static String dateMonth(int numeroMes) {
		String result = "";
		switch (numeroMes) {
		case 1: {
			result = "enero";
			break;
		}
		case 2: {
			result = "febrero";
			break;
		}
		case 3: {
			result = "marzo";
			break;
		}
		case 4: {
			result = "abril";
			break;
		}
		case 5: {
			result = "mayo";
			break;
		}
		case 6: {
			result = "junio";
			break;
		}
		case 7: {
			result = "julio";
			break;
		}
		case 8: {
			result = "agosto";
			break;
		}
		case 9: {
			result = "septiembre";
			break;
		}
		case 10: {
			result = "octubre";
			break;
		}
		case 11: {
			result = "noviembre";
			break;
		}
		case 12: {
			result = "diciembre";
			break;
		}
		default: {
			result = "error";
			break;
		}
		}
		return result;
	}

	public List<List<CeldaCSV>> getlData() {
		return lData;
	}

	public void setlData(List<List<CeldaCSV>> lData) {
		this.lData = lData;
	}

	public List<Estructura> getlEstructuraReal() {
		return lEstructuraReal;
	}

	public void setlEstructuraReal(List<Estructura> lEstructuraReal) {
		this.lEstructuraReal = lEstructuraReal;
	}

	public List<Estructura> getlEstructura() {
		return lEstructura;
	}

	public void setlEstructura(List<Estructura> lEstructura) {
		this.lEstructura = lEstructura;
	}

	public String getRuta() {
		return ruta;
	}

	public void setRuta(String ruta) {
		this.ruta = ruta;
	}

	public int getNumeroMes() {
		return numeroMes;
	}

	public void setNumeroMes(int numeroMes) {
		this.numeroMes = numeroMes;
	}

	public File getFile() {
		return file;
	}

	public void setFile(File file) {
		this.file = file;
	}

}
