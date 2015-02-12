package edu.uniandes.ecos;

import java.util.LinkedList;

import junit.framework.Test;
import junit.framework.TestCase;
import junit.framework.TestSuite;

/**
 * Unit test for simple App.
 */
public class AppTest 
    extends TestCase
{
    /**
     * Create the test case
     *
     * @param testName name of the test case
     */
    public AppTest( String testName )
    {
        super( testName );
    }

    /**
     * @return the suite of tests being tested
     */
    public static Test suite()
    {
        return new TestSuite( AppTest.class );
    }

    /**
     * Rigourous Test :-)
     */
    public void testApp()
    {
    	Operations calculos=new Operations();
    	LinkedList<Double> pares=new LinkedList<Double>();
    	LinkedList<LinkedList<Double>> lista1=new LinkedList<LinkedList<Double>>();
    	String texto="130-186,650-699,99-132,150-272,128-291,302-331,95-199,945-1890,368-788,961-1601";
    	String[] paresLista=texto.split(",");
    	String[] numeros;
		for(String textoPar: paresLista){
			numeros=textoPar.split("-");
			if(numeros.length==2){
				pares=new LinkedList<Double>();
				pares.add(Double.parseDouble(numeros[0]));
				pares.add(Double.parseDouble(numeros[1]));
				lista1.add(pares);
			}
		}
        assertEquals("Para la lista 1 la correlacion debe ser ",	0.9544965741046826,  calculos.correlacion(lista1));
        
        
    }
}
