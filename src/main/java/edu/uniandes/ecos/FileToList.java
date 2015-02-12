package edu.uniandes.ecos;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;
import java.util.LinkedList;

public class FileToList {
	
	public FileToList(){
	}
	
	public LinkedList<LinkedList<Double>> archivoALista() throws IOException{
		LinkedList<LinkedList<Double>> listaNumeros=new LinkedList<LinkedList<Double>>();
		LinkedList<Double> parNumeros=new LinkedList<Double>();
		File archivo=new File("arreglo.txt");
		FileReader lectorArchivo=new FileReader(archivo);
		BufferedReader bufferLector=new BufferedReader(lectorArchivo);
		String linea;
		int numeroLinea=0;
		String[] partes;
		while((linea=bufferLector.readLine ()) != null){
			numeroLinea++;
			partes=linea.split("-");
			try{
				if(partes.length==2){
					parNumeros=new LinkedList<Double>();
					parNumeros.add(Double.parseDouble(partes[0]));
					parNumeros.add(Double.parseDouble(partes[1]));
					listaNumeros.add(parNumeros);
				}
			}
			catch(Exception e){
				System.out.println("La linea "+numeroLinea);
			}
		}
		bufferLector.close();
		return listaNumeros;
	}
}
