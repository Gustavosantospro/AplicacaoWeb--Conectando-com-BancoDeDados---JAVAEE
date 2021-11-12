package br.com.caelum.agenda.dao.daotest;

import br.com.caelum.agenda.dao.ContatoDao;
import br.com.caelum.agenda.modelo.Contato;

public class TestaDelete {
	public static void main(String[] args) {
		
		Contato nv = new Contato();
		nv.setId((long) 15);
		nv.setNome("contatovaiserexc");
		nv.setEmail("excludo");
		
		
		ContatoDao nvDao = new ContatoDao();
		nvDao.deleteContato(nv);
		
		System.out.println("contato deletado");
	}
}
