package br.com.agenda.dao.daotest;

import br.com.agenda.dao.ContatoDao;
import br.com.agenda.modelo.Contato;

public class TestaUpdate {
	public static void main(String[] args) {
		Contato nv = new Contato();
		nv.setNome("Gustavo");
		nv.setEmail("gustavosant@hotmail.com");
		nv.setEndereco("rua iataporanga, 123");
		nv.setId((long) 2);
		
		ContatoDao nvDao = new ContatoDao();
		nvDao.updateContato(nv);
		System.out.println("Contato atualizado");
	}
}
