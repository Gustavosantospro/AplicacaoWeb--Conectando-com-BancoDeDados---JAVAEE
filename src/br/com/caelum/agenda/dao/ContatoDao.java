package br.com.caelum.agenda.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import java.sql.Date;
import br.com.caelum.agenda.jdbc.ConnectionFactory;
import br.com.caelum.agenda.modelo.Contato;

public class ContatoDao {
	
	private Connection con;
	
	public ContatoDao()  {
		this.con = new ConnectionFactory().getConnection();
	}
	
	/**metodo para adicionar contato ao banco de dados*/
	public void adciona(Contato contato) {
	
	String sql = "insert into contatos2" +
				 "(nome, email, endereco)" +
				 "values (?,?,?)";
	
	try {
		PreparedStatement stmt = con.prepareStatement(sql);
		stmt.setString(1, contato.getNome());
		stmt.setString(2, contato.getEmail());
		stmt.setString(3, contato.getEndereco());
		stmt.execute();
		stmt.close();
		
	} catch (SQLException e) {
		
		throw new RuntimeException(e);
	} 
	}
	
	/** método para listar contatos*/
	public List<Contato> getContatos() {
		
		String sql = "select * from contatos2";
		List<Contato> contatoList = new ArrayList<>();
		
		try {
			PreparedStatement getStmt = con.prepareStatement(sql);
			ResultSet rs = getStmt.executeQuery();
			
			/** adicionando contatos a lista de contatos(contatoList)*/
			
			while (rs.next()) {
				Contato contato = new Contato();
				contato.setNome(rs.getString("nome"));
				contato.setEmail(rs.getString("email"));
				contato.setEndereco(rs.getString("endereco"));
				
				contatoList.add(contato);
			}
				rs.close();
				getStmt.close();
				con.close();
		} catch (SQLException e) {
			throw new RuntimeException(e);
		}
		
		
		return contatoList;
	}
	
	/** método para atualizar contato*/
	public void updateContato(Contato contato) {
		String update = "update contatos2 set " +
					 	"nome= ?, email= ?, endereco= ?" +
					 	"where id= ?";
		try {
			PreparedStatement stmt = con.prepareStatement(update);
			stmt.setString(1, contato.getNome());
			stmt.setString(2, contato.getEmail());
			stmt.setString(3, contato.getEndereco());
			stmt.setLong(4, contato.getId());
			stmt.execute();
			stmt.close();
			
		} catch (SQLException e) {
			System.out.println("erro de statement");
			e.printStackTrace();
		} finally {
			try {
				con.close();
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				System.out.println("we a have a problem in close connection with database");
				throw new RuntimeException(e);
			}
		}
		
	}
	
	public void deleteContato(Contato contato) {
		
		String delete = "delete from contatos2 where id=?";
		try {
			PreparedStatement stmt = con.prepareStatement(delete);
			stmt.setLong(1, contato.getId());
			stmt.execute();
			stmt.close();
			
		} catch (SQLException e) {
			System.out.println("erro em deletar contato");
			throw new RuntimeException(e);
		} finally {
			try {
				con.close();
			} catch (SQLException e) {
				
				throw new RuntimeException(e);
			}
		}
		
	}
	
}


