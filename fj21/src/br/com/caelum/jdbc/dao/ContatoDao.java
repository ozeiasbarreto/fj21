package br.com.caelum.jdbc.dao;

import java.sql.Connection;
import java.sql.Date;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import br.com.caelum.jdbc.modelo.Contato;
import br.com.jdbc.caelum.ConnectionFactory;

// O papel dessa classe será genreciar a conexão e inserir Contatos no banco de dados.
public class ContatoDao {
	
	//a conexão com o banco de dados;
	private Connection connection;
	public ContatoDao() throws SQLException {
			this.connection = new ConnectionFactory().getConnection();
		}
	
public void adiciona(Contato contato) {
		
		String sql = "insert into contatos" + 
			"(nome, email, endereco, dataNascimento)" + 
				"values(?,?,?,?)";
		try {
			//prepared statement para inserção
			PreparedStatement stmt = connection.prepareStatement(sql);
			
			//seta os valores
			stmt.setString(1, contato.getNome());
			stmt.setString(2, contato.getEmail());
			stmt.setString(3, contato.getEndereco());
			stmt.setDate( 4, new Date(
					contato.getDataNascimento().getTimeInMillis()));
			
			//executa
			stmt.execute();
			stmt.close();
		}catch(SQLException e) {
			throw new RuntimeException(e);
		}
	}

public void consulta(Contato contato) throws SQLException{
	//pega a conexão eo Statement
	
	PreparedStatement stmt = this.connection.prepareStatement("SELECT * FROM contatos");
	
	ResultSet rs = stmt.executeQuery(); // Retorna todos os registros de uma determinda query
	
	//List<Contato>contatos = new ArrayList<Contato>();
	
	//itera no ResultSet
	while(rs.next()) {
		String nome = rs.getString("nome"); 
		String email = rs.getString("email");
		
		System.out.println(nome + "_" + email);
	}	
	stmt.close();
	connection.close();
	}
}
