package br.com.caelum.jdbc.teste;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class JDBCExemplo {

	public static void main(String[] args) throws SQLException {
		// TODO Auto-generated method stub
		// Para obter uma conexão com o banco de dados
		// O metodo getConnection cria novas conexões.
		Connection conexao = DriverManager.getConnection(
		"jdbc:mysql://127.0.0.1:3306/fj21", "fj21", "fj21");
		System.out.println("Conectado");
		conexao.close();
	}
}
