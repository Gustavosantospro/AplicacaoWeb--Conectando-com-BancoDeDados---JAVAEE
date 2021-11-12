package br.com.caelum.agenda.servlet;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebInitParam;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet(urlPatterns = {"/ola"},
			initParams = { @WebInitParam(name= "aloha", value ="aloha")})

public class OiMundo extends HttpServlet {

	@Override
	protected void service(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		
		PrintWriter out = resp.getWriter();
		out.println("<html>");
		out.println("<head>");
		out.println("<title>AAAA</title>");
		out.println("</head>");
		out.println("<body>");
		out.println("<h1>QUALE</h1>");
		out.println("</body>");
		out.println("</html>");
		
		String param = getServletConfig().getInitParameter("aloha");
		out.println("Parametro 1 = " + param);
	}
	
	
}
