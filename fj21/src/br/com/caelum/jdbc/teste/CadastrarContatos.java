package br.com.caelum.jdbc.teste;

import java.sql.SQLException;
import java.util.Calendar;

import br.com.caelum.jdbc.dao.ContatoDao;
import br.com.caelum.jdbc.modelo.Contato;

public class CadastrarContatos {
public static void main(String[] args) throws SQLException  {
	//conectando	
	Contato contato = new Contato();
	
	//preenche os valores
	/*contato.setNome("Elaine");
	contato.setEmail("lainenany123@gmail.com");
	contato.setEndereco("R. Dois 07");
	contato.setDataNascimento(Calendar.getInstance());*/
	
	ContatoDao dao = new ContatoDao();
	
	//dao.adiciona(contato);
	dao.consulta(contato);
	
	System.out.println("Gravado!");
	}
}

