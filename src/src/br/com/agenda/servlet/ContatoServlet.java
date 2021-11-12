package br.com.caelum.agenda.servlet;

import java.io.IOException;
import java.io.PrintWriter;
import java.sql.SQLException;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import br.com.caelum.agenda.dao.ContatoDao;
import br.com.caelum.agenda.modelo.Contato;

@WebServlet("/adicionaContato")

public class ContatoServlet extends HttpServlet {

	@Override
	protected void service(HttpServletRequest request, HttpServletResponse response) throws IOException {

		/** wrapping parameters of requests */
		String nome = request.getParameter("nome");
		String email = request.getParameter("email");
		String endereco = request.getParameter("endereco");

		/** create a reference a object of Contato */
		Contato contato = new Contato();
		contato.setNome(nome);
		contato.setEmail(email);
		contato.setEndereco(endereco);

		ContatoDao dao = new ContatoDao();
		dao.adciona(contato);

		RequestDispatcher rd = request.getRequestDispatcher("contato-adicionado.jsp");
		try {
			rd.forward(request, response);
		} catch (ServletException e) {
			System.out.println("erro no redirecionamento de requisição");
			e.printStackTrace();
		}
	}
}
