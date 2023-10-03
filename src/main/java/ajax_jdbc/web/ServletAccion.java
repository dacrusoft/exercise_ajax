package ajax_jdbc.web;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;

import ajax_servlet.model.Persona;
import jakarta.servlet.ServletException;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

/**
 * Servlet implementation class ServletAccion
 */
public class ServletAccion extends HttpServlet {
	private static final long serialVersionUID = 1L;
	private ArrayList<Persona> personaArray = new ArrayList<>();

	public ServletAccion() {
		super();
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

		response.setContentType("text/html; charset=iso-8859-1");
		PrintWriter out = response.getWriter();

		String nombre = request.getParameter("nombre");
		String apellido = request.getParameter("apellido");
		String edad = request.getParameter("edad");

		if (!nombre.equals("") && !apellido.equals("") && !edad.equals("")) {
			Persona persona = new Persona(nombre, apellido, edad);
			personaArray.add(persona);
		} 

		out.print("<table style= cellspacing='1' bgcolor='#0099cc'>");
		out.print("<tr>");
		out.print("<td style = rowspan='7' aling='center' bgcolor='#f8f8f8'> NOMBRE </td>");
		out.print("<td style = rowspan='7' aling='center' bgcolor='#f8f8f8'> APELLIDO </td>");
		out.print("<td style = rowspan='7' aling='center' bgcolor='#f8f8f8'> EDAD </td>");
		out.print("</tr>");
		for (int i = 0; i < personaArray.size(); i++) {
			Persona persona = personaArray.get(i);
			out.print("<tr>");
			out.print("<td style = rowspan='7' aling='center' bgcolor='#f8f8f8'>" + persona.getNombre() + "</td>");
			out.print("<td style = rowspan='7' aling='center' bgcolor='#f8f8f8'> " + persona.getApellido() + " </td>");
			out.print("<td style = rowspan='7' aling='center' bgcolor='#f8f8f8'> " + persona.getEdad() + " </td>");
			out.print("</tr>");
		}
		out.print("</table>");

	}

}
