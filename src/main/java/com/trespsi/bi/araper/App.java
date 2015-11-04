package com.trespsi.bi.araper;

import java.io.File;
import java.io.IOException;
import java.util.Iterator;

import org.apache.poi.openxml4j.exceptions.InvalidFormatException;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.ss.usermodel.WorkbookFactory;

/**
 * Hello world!
 *
 */
public class App {

	public static void main(String[] args) {
		Workbook wb = null;
		// Abrimos el archivo excel
		try {
			wb = WorkbookFactory.create(new File("C:\\xls\\alejo.xlsx"));
		} catch (InvalidFormatException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		}
		// Abrimos la hojita
		if(wb == null) return;
		Sheet sheet = wb.getSheetAt(0);
		// obtenemos la data
		@SuppressWarnings("rawtypes")
		Iterator ite = sheet.rowIterator();
		int numUltimaCelda = 0;
		if(ite.hasNext()){
			Row row = (Row) ite.next();
			numUltimaCelda = row.getLastCellNum();
			for (int i = 0; i < numUltimaCelda; i++) {
				System.out.println(row.getCell(i).toString());
			}
			System.out.println();
		}
		while (ite.hasNext()) {
			Row row = (Row) ite.next();
			numUltimaCelda = row.getLastCellNum();
			for (int i = 0; i < numUltimaCelda; i++) {
				System.out.println(row.getCell(i).toString());
			}
			System.out.println();
		}
	}
}
