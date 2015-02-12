package edu.uniandes.ecos;

import java.util.LinkedList;

/**
 * 
 * @author Jorge Alfonso Beltrán Sandoval
 * Clase realizada para imprimir datos por consola
 *
 */
public class PrintConsole {

	/**
	 * 
	 * printListString(LinkedList<String> values)
	 * printListInteger(LinkedList<Integer> values)
	 * printListArrayDouble(LinkedList<Integer> values) 
	 * 
	 */
	


	/**
	 * 
	 * printListString(LinkedList<String> values){
	 *		Imprime todos los valores recibidos en la lista
	 *		la listaEnlazada debe contener datos tip String
	 *
	 * */
	public void printListString(LinkedList<String> values){
		for(String value: values){
			System.out.print(value+"\t");
		}
		System.out.print("\n");
	}
	

	/**
	 * 
	 * printListInteger(LinkedList<String> values){
	 *		Imprime todos los valores recibidos en la lista
	 *		la listaEnlazada debe contener datos tipo Integer
	 *
	 * */
	public void printListInteger(LinkedList<Integer> values){
		for(Integer value: values){
			System.out.print(value+"\t");
		}
		System.out.print("\n");
	}
	

	/**
	 * 
	 * @parameter values
	 *		Imprime todos los valores recibidos en la lista
	 *		la listaEnlazada debe tener dos dimensiones y
	 *		contener datos tipo Double
	 *
	 * */
	public void printListArrayDouble(LinkedList<LinkedList<Double>> listaDoble){
		for(LinkedList<Double> lista: listaDoble){
			for(double value: lista){
				System.out.print(value+"\t");
			}
			System.out.print("\n");
		}
	}

}
