package br.com.caelum.agenda.mvc.servlet;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import br.com.caelum.agenda.mvc.logica.Logica;

@WebServlet("/mvc")
public class ControllerServlet extends HttpServlet{
	
	@Override
	protected void service(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		String parametro = request.getParameter("logica");
		String nomeDaClasse = "br.com.caelum.agenda.mvc.logica." + parametro;
		
		try {
			// cria uma representa��o de uma classe
			Class classe = Class.forName(nomeDaClasse);
			// 
			Logica logica = (Logica) classe.newInstance();
			// como response teremos uma string contendo o nome de uma p�gina jsp
			String pagina = logica.executa(request, response);
			request.getRequestDispatcher(pagina).forward(request, response);
			
		} catch (Exception e) {
			throw new ServletException( "a l�gica de neg�cios causou uma exce��o", e);
		}
	}
}
