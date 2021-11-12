package br.com.caelum.agenda.modelo;

import java.util.Calendar;
import java.util.Date;

public class Contato {
	private Long id;
	private String nome;
	private String email;
	private String endereco;
	private Calendar dataNascimento;
	
	//getter
	public String getNome() {
		return nome;
	}
	public String getEmail() {
		return email;
	}
	public String getEndereco() {
		return endereco;
	}
	public Calendar getDataNascimento() {
		return dataNascimento;
	}
	
	//setters
	public void setNome(String nome) {
		this.nome = nome;
	}
	public void setEmail(String email) {
		this.email = email;
	}
	public void setEndereco(String endereco) {
		this.endereco = endereco;
	}
	public void setDataNascimento(Calendar dataNascimento) {
		this.dataNascimento = dataNascimento;
	}
	public Long getId() {
		return id;
	}
	public void setId(Long id) {
		this.id = id;
	}

}
