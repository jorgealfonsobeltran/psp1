package edu.uniandes.ecos;

import java.math.BigDecimal;
import java.util.LinkedList;



public class Operations {

	public double promedio(LinkedList<Double> lista){
		double suma=0,resultado=0;
		for(Double valor : lista){
			suma+=valor;
		}
		resultado=suma/lista.size();
		BigDecimal decimal=new BigDecimal(resultado);
		resultado=Double.parseDouble(decimal.setScale(2,decimal.ROUND_HALF_UP).toString());
		return resultado;
	}
	public double desviacion(LinkedList<Double> lista){
		double sumaDispersion=0,resultado=0;
		double valorPromedio=promedio(lista);
		for(double valor : lista){
			sumaDispersion+=Math.pow(valor-valorPromedio,2);
		}
		resultado=Math.sqrt(sumaDispersion/(lista.size()-1));
		BigDecimal decimal=new BigDecimal(resultado);
		resultado=Double.parseDouble(decimal.setScale(2,decimal.ROUND_HALF_UP).toString());
		return resultado;
	}
	/**
	 * 
	 * @param lista
	 * @return sumatoria
	 */
	public double sumatoria(LinkedList<Double> lista){
		double suma=0;
		for(Double valor : lista){
			suma+=valor;
		}
		return suma;
	}
	/**
	 * 
	 * @param lista, de dos dimensiones donde 
	 * el indice 0 es X y el indice 1 es Y
	 * @return r valor correlacion
	 */
	public double correlacion(LinkedList<LinkedList<Double>> lista){
		double r;
		LinkedList<Double> listaMultiplicacionXY=new LinkedList<Double>();
		LinkedList<Double> listaCuadradoX=new LinkedList<Double>();
		LinkedList<Double> listaCuadradoY=new LinkedList<Double>();
		LinkedList<Double> listaX=new LinkedList<Double>();
		LinkedList<Double> listaY=new LinkedList<Double>();
		for(LinkedList<Double> valor : lista){
			listaMultiplicacionXY.add(valor.getFirst()*valor.getLast());
			listaCuadradoX.add(valor.getFirst()*valor.getFirst());
			listaCuadradoY.add(valor.getLast()*valor.getLast());
			listaX.add(valor.getFirst());
			listaY.add(valor.getLast());
		}
		r=(lista.size()*sumatoria(listaMultiplicacionXY)-sumatoria(listaX)*sumatoria(listaY))/Math.sqrt((lista.size()*sumatoria(listaCuadradoX)-Math.pow(sumatoria(listaX),2))*(lista.size()*sumatoria(listaCuadradoY)-Math.pow(sumatoria(listaY),2)));
		return r;
	}

	/**
	 * 
	 * @param lista, de dos dimensiones donde 
	 * el indice 0 es X y el indice 1 es Y
	 * @return b1
	 */
	public double beta1(LinkedList<LinkedList<Double>> lista){
		double b1;
		LinkedList<Double> listaMultiplicacionXY=new LinkedList<Double>();
		LinkedList<Double> listaCuadradoX=new LinkedList<Double>();
		double promedioX=0;
		double promedioY=0;
		LinkedList<Double> listaX=new LinkedList<Double>();
		LinkedList<Double> listaY=new LinkedList<Double>();
		for(LinkedList<Double> valor : lista){
			listaMultiplicacionXY.add(valor.getFirst()*valor.getLast());
			listaCuadradoX.add(valor.getFirst()*valor.getFirst());
			listaX.add(valor.getFirst());
			listaY.add(valor.getLast());
		}
		promedioX=promedio(listaX);
		promedioY=promedio(listaY);
		b1=(sumatoria(listaMultiplicacionXY)-(promedioX*promedioY*lista.size()))/(sumatoria(listaCuadradoX)-(Math.pow(promedioX,2)*lista.size()));
		return b1;
	}

	/**
	 * 
	 * @param lista, de dos dimensiones donde 
	 * el indice 0 es X y el indice 1 es Y
	 * @param b1 valor Beta1 en caso de ser 0 se procesa la lista para
	 * obtenerlo de nuevo
	 * @return b0
	 */
	public double beta0(LinkedList<LinkedList<Double>> lista,double b1){
		double b0;
		double promedioX=0;
		double promedioY=0;
		LinkedList<Double> listaX=new LinkedList<Double>();
		LinkedList<Double> listaY=new LinkedList<Double>();
		if(b1==0){
			b1=beta1(lista);
		}
		for(LinkedList<Double> valor : lista){
			listaX.add(valor.getFirst());
			listaY.add(valor.getLast());
		}
		promedioX=promedio(listaX);
		promedioY=promedio(listaY);
		b0=promedioY-(promedioX*b1);
		return b0;
	}
}
