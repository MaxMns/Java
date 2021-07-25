package com.rpa.test.v1;

import java.util.*;

public class Listas {

	public static void main(String[] args) {
		
		List<String> listaDeCamposExcel = new ArrayList<String>();
		List<String> loQueBusco = new ArrayList<String>();
		List<String> excelData = new ArrayList<String>();
		List<String> searchBetween = new ArrayList<String>();
		List<String> extractedData = new ArrayList<String>();
		List<Integer> indexA = new ArrayList<Integer>();
		List<Integer> indexB = new ArrayList<Integer>();
		
		String[] listaDeCamposExcel1 = { "Calle:", "C.P.", "Colonia:", "Estado:", "Municipio:", "Region:",
				"Coordenadas", "Latitud", "Altitud (msnm):", "Longitud", "Referencias:", "Contacto:", "Telefono:",
				"Monto:", };

		String[] loQueBusco1 = { "Calle:", "C.P.", "Colonia:", "Estado:", "Municipio:", "Referencias:", };

		String[] excelData1 = { "Calle:", "", "","", "", "X", "", "", "", "", "", "", "", "",
				"C.P.", "", "", "", "X", "", "", "", "", "", "", "", "", "", "", "", "", "", "", "", "", "Colonia:",
				"", "", "", "", "Sin nombre", "", "", "", "", "", "", "", "", "", "", "", "Estado:", "", "", "", "", "",
				"", "X", "", "", "", "", "", "", "", "", "", "Municipio:", "", "X", "", "", "", "", "", "",
				"Region:", "", "", "", "", "", "7", "", "", "", "", "", "", "", "", "", "", "", "", "", "", "", "", "",
				"", "Coordenadas", "", "", "", "", "", "Latitud", "", "", "", "2", "", "", "", "", "", "", "", "",
				"", "", "", "N", "", "Altitud:","", "", "", "", "", "", "271", "", "", "", "", "", "", "", "", "", "", "",
				"Longitud", "", "", "", "", "", "", "0", "", "", "", "", "", "", "", "", "", "", "", "", "", "",
				"", "", "W", "Referencias:", "", "", "", "", "", "", "", "", "", "", "", "", "", "", "", "", "", "", "",
				"", "", "", "", "", "Contacto:", "", "", "", "", "X", "", "", "", "Telefono:", "", "", "", "",
				"1234566789", "", "", "", "", "", "", "", "", "", "", "", "Monto:", "", "", "", "", "", "", "", "", "",
				"", "", "", "", "X", "", "", "", "", "", "", "", "", "", "", "", "", "", "", "", "", "", "", };



		listaDeCamposExcel = Arrays.asList(listaDeCamposExcel1);
		loQueBusco = Arrays.asList(loQueBusco1);
		excelData = Arrays.asList(excelData1);

		System.out.println("listaDeCamposExcel - tamano = " + listaDeCamposExcel.size());
		System.out.println("loQueBusco - tamano =  " + loQueBusco.size());
		System.out.println("excelData - tamano = " + excelData.size());
		System.out.println("");

		for (int j = 0; j < loQueBusco.size(); j++) {
			for (int k = 0; k < listaDeCamposExcel.size(); k++) {
				if (listaDeCamposExcel.get(k).contains(loQueBusco.get(j))) {
					System.out.println("Lo que busco = " + loQueBusco.get(j));
					System.out.println("La columna que sigue = " + listaDeCamposExcel.get(k + 1));
					searchBetween.add(listaDeCamposExcel.get(k + 1));
					break;
				}
			}
			System.out.println("");
		}
		
		
		indexA = getIndexToStart(excelData,loQueBusco);
		indexB = getIndexToFinish(excelData, searchBetween);
		
		for (int i = 0; i < indexA.size(); i++) {
			String tmpData = getDataBetween(indexA.get(i), indexB.get(i), excelData );
			extractedData.add(tmpData);

		}
		
		System.out.println("");
		System.out.println("###############");
		for (int i = 0; i < loQueBusco.size(); i++) {
			System.out.println(loQueBusco.get(i)+ " "+extractedData.get(i));
		}
		
	}
	
	public static String getDataBetween(Integer start,  Integer end, List<String> excelData ) {
		String data = "";
		for (int i = start+1; i <end; i++) {
			if(excelData.get(i)!="") {
				//System.out.println("i: "+ i + " " +excelData.get(i));
				data = excelData.get(i);
				break;
			}else {
				data = "Campo vacio";
			}
		}
		return data;
	}
	
	public static List<Integer> getIndexToStart(List<String> excelData, List<String> loQueBusco) {
		List<Integer> index = new ArrayList<Integer>();
		for (int i = 0; i < excelData.size(); i++) {
			for (int j = 0; j < loQueBusco.size(); j++) {
				if (excelData.get(i).contains(loQueBusco.get(j))) {
					index.add(i);
					//System.out.println("Coincidencia en pos: " + i);
					//System.out.println("i: " + i + " " + excelData.get(i));
				}
			}
		}
		return index;
	}
	
	public static List<Integer> getIndexToFinish(List<String> excelData, List<String> searchBetween) {
		List<Integer> index = new ArrayList<Integer>();
		for (int i = 0; i < excelData.size(); i++) {
			for (int j = 0; j < searchBetween.size(); j++) {
				if (excelData.get(i).contains(searchBetween.get(j))) {
					index.add(i);
					//System.out.println("Coincidencia en pos: " + i);
					//System.out.println("i: " + i + " " + excelData.get(i));
				}
			}
		}
		return index;
	}

}
