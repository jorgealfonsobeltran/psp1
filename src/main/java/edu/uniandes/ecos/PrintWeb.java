package edu.uniandes.ecos;

import java.io.IOException;
import java.util.LinkedList;

import javax.servlet.ServletException;
import javax.servlet.http.*;

/**
 * 
 * @author Jorge Alfonso Beltrán Sandoval
 * Clase realizada para imprimir datos por un servlet levantando un servivio en el puerto 5000
 *
 */

public class PrintWeb extends HttpServlet {
	  /**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	public String mensaje;
	public LinkedList<LinkedList<Double>> listaNumeros=new LinkedList<LinkedList<Double>>();
	public double correlacion=0;
	public double b0=0;
	public double b1=0;
	public int LOCcounter;
	
	@Override
	  protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
	      showHome(req,resp);
	  }

	  private void showHome(HttpServletRequest req, HttpServletResponse resp)
	      throws ServletException, IOException {
		    resp.setContentType("text/html");
		    resp.getWriter().print(printHeader());
		    resp.getWriter().print("<table style='table, th, td{ border: 1px solid black; }'><tr><th>Valores Tabla</th><th>Correlacion (R)</th><th>Correlacion al Cuadrado R^2</th><th>B1</th><th>B2</th><th>Formula</th></tr>");
		    resp.getWriter().print("<tr><td>");
		    resp.getWriter().print(printListArrayDouble(listaNumeros));
		    resp.getWriter().print("<td>"+correlacion+"</td>");
		    resp.getWriter().print("<td>"+Math.pow(correlacion,2)+"</td>");
		    resp.getWriter().print("<td>"+b1+"</td>");
		    resp.getWriter().print("<td>"+b0+"</td>");
		    resp.getWriter().print("<td>Yk = "+b0+" + "+b1+" Xk</td>");
		    resp.getWriter().print("</tr></table>");
		    resp.getWriter().print(printFooter());
	  }

		/**
		 * 
		 * @parameter values
		 *		Imprime todos los valores recibidos en la lista
		 *		la listaEnlazada debe tener dos dimensiones y
		 *		contener datos tipo Double
		 *
		 * */
		public String printListArrayDouble(LinkedList<LinkedList<Double>> listaDoble){
			String texto="<table><tr><td>X</td><td>Y</td></tr>";
			for(LinkedList<Double> lista: listaDoble){
				texto+="<tr>";
				for(double value: lista){
					texto+="<td>"+value+"</td>";
				}
				texto+="</tr>";
			}
			texto+="</table>";
			return texto;
		}
		

		/**
		 * 
		 * @return texto
		 *		Imprime la cabecera del documento HTML
		 *
		 * */
		public String printHeader(){
			String texto="<html><head><style>table, th, td {border: solid black 1px;}</style></head><body>";
			return texto;
		}

		/**
		 * 
		 * @return texto
		 *		Imprime el pie de pagina del documento HTML
		 *
		 * */
		public String printFooter(){
			String texto="</body></html>";
			return texto;
		}
}


