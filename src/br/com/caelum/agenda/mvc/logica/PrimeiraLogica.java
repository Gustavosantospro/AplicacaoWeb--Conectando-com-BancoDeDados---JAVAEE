package br.com.caelum.agenda.mvc.logica;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class PrimeiraLogica implements Logica {

	@Override
	public String executa(HttpServletRequest req, HttpServletResponse res) {
		System.out.println("executando a l�gica");
		System.out.println("retornando onome da p�gina");
		return "primeira-logica.jsp";
		// TODO Auto-generated method stub
		
	}

}
