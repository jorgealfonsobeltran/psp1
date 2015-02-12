package edu.uniandes.ecos;

import java.util.LinkedList;

import org.eclipse.jetty.server.Server;
import org.eclipse.jetty.servlet.*;

/**
 * 
 * @author JorgeAlfonso Beltrán Sandoval
 * Clase Controlador que llama a los modelos 
 * y realiza la impresion de los datos en las vistas
 */
public class App 
{
    public static void main( String[] args ) throws Exception
    {
    	
    	FileToList archivoLectura=new FileToList();
    	LinkedList<LinkedList<Double>> listaNumeros=archivoLectura.archivoALista();
    	Operations calculos=new Operations();
    	double correlacion=calculos.correlacion(listaNumeros);
    	double b1=calculos.beta1(listaNumeros);
    	double b0=calculos.beta0(listaNumeros,b1);
    	
    	
    	PrintConsole impresoraConsola=new PrintConsole();
    	System.out.println("Tabla de valores, obtenida del archivo arreglo.txt en la base del archivo: ");
    	System.out.println("X \t Y");
    	impresoraConsola.printListArrayDouble(listaNumeros);
    	System.out.println("Correlación: "+correlacion);
    	System.out.println("Correlación al cuadrado: "+Math.pow(correlacion,2));
    	System.out.println("Beta 1: "+b1);
    	System.out.println("Beta 0: "+b0);
    	
    	
    	PrintWeb impresoraWeb=new PrintWeb();
	    impresoraWeb.listaNumeros=listaNumeros;
	    impresoraWeb.correlacion=correlacion;
	    impresoraWeb.b1=b1;
	    impresoraWeb.b0=b0;
	    Server server = new Server(Integer.valueOf(System.getenv("PORT")));
	    ServletContextHandler context = new ServletContextHandler(ServletContextHandler.SESSIONS);
	    context.setContextPath("/");
	    server.setHandler(context);
	    context.addServlet(new ServletHolder(impresoraWeb), "/*");
		server.start();
	    server.join();
    }
}
