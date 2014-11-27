package br.com.frota.model.DAO;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class ConexaoDAO {

	public  Connection getConnection(){
		// URL de acesso ao banco de dados
		String url = "jdbc:postgresql://127.0.0.1:5432/dbescola";
		Connection  conexao = null;
		try{
			// Carregando o driver JDBC do banco de dados
			Class.forName("org.postgresql.Driver");
			
			// Estabelecendo a conexao com o banco de dados
			conexao = DriverManager.getConnection(url, "postgres", "aluno");
			
			System.out.println("Conexao realizada com sucesso!");
			
		}catch(ClassNotFoundException e){
			System.out.println("Driver não localizado!");
			e.printStackTrace();
		}
		catch(SQLException e){
			System.out.println("Erro ao conectar com o banco de dados!");
			e.printStackTrace();
		}
		
		// Devolvendo a conexao com o banco de dados
		return conexao;
	}
	
}