package br.com.caelum.agenda.jdbc;

import java.util.Calendar;

import br.com.caelum.agenda.dao.ContatoDao;
import br.com.caelum.agenda.modelo.Contato;

public class TestaInsere {

	public static void main(String[] args) throws ClassNotFoundException {
		
		Contato nv = new Contato();
		nv.setNome("Rivert");
		nv.setEmail("riv@hotmail.com");
		nv.setEndereco("ruaasdgtavinhoepa");
		//nv.setDataNascimento(Calendar.getInstance());
		
		ContatoDao contDao = new ContatoDao();
		contDao.adciona(nv);
		System.out.println("Gravado!");
	}
}
