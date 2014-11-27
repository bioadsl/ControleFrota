package br.com.frota.model.DAO;
//control shift O corrige os imports
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import br.com.frota.model.BeanVeiculo;


public class VeiculoDAO {
	public String salvar(BeanVeiculo obj) {
		String mensagem = null;
		String insertSQL = "insert into veiculo "
				+ "(placa, chassi, modelo, ano, proprietario) "
				+ "values (?,?,?,?,?)";
		try {
			// Criando o objeto de conexao
			ConexaoDAO c = new ConexaoDAO();
			
			// Estabelecendo a conexão
			Connection con = c.getConnection();
			
			// Criando um objeto PreparedStatement 
			PreparedStatement pstm = con.prepareStatement(insertSQL);
			
			pstm.setString(1, obj.getPlaca());
			pstm.setString(2, obj.getChassi());
			pstm.setString(3, obj.getModelo());
			pstm.setInt(4, obj.getAno());
			pstm.setString(5, obj.getProprietario());
			
			
			pstm.executeUpdate();
			mensagem = "Registro inserido com sucesso!";
		} catch (SQLException e) {
			e.printStackTrace();
			mensagem = "Erro ao inserir registro!";
		}
		
		return mensagem;
	}
	
	public String editar(BeanVeiculo obj) {
		String mensagem = null;
		String editarSQL = "update veiculo set "
				+ "chassi = ?, modelo = ?, ano = ?, proprietario = ? "
				+ "where placa = ?";
		try {
			// Criando o objeto de conexao
			ConexaoDAO c = new ConexaoDAO();
			
			// Estabelecendo a conexão
			Connection con = c.getConnection();
			
			// Criando um objeto PreparedStatement 
			PreparedStatement pstm = con.prepareStatement(editarSQL);
			
			
			pstm.setString(1, obj.getChassi());
			pstm.setString(2, obj.getModelo());
			pstm.setInt	(3, obj.getAno());
			pstm.setString(4, obj.getProprietario());
			pstm.setString(5, obj.getPlaca());
			
			pstm.executeUpdate();
			mensagem = "Registro alterado com sucesso!";
		} catch (SQLException e) {
			e.printStackTrace();
			mensagem = "Erro ao alterar registro!";
		}
		
		return mensagem;
	}

	public String excluir(String placa) {
		String mensagem = null;
		String deleteSQL = "delete from veiculo "
				+ "where placa = ?";
		try {
			// Criando o objeto de conexao
			ConexaoDAO c = new ConexaoDAO();
			
			// Estabelecendo a conexão
			Connection con = c.getConnection();
			
			// Criando um objeto PreparedStatement 
			PreparedStatement pstm = con.prepareStatement(deleteSQL);
			
			pstm.setString(1, placa);
			
			pstm.executeUpdate();
			mensagem = "Registro excluido com sucesso!";
		} catch (SQLException e) {
			e.printStackTrace();
			mensagem = "Erro ao excuir registro!";
		}
		
		return mensagem;
	}

	public List<BeanVeiculo> consultarTodos (String consultaItem) {
		
		String consultarSQL = "select * from veiculo";
		
		
		
		ArrayList<BeanVeiculo> lista = new ArrayList<BeanVeiculo>();
		
		try {
			// Criando o objeto de conexao
			ConexaoDAO c = new ConexaoDAO();
			
			// Estabelecendo a conexão
			Connection con = c.getConnection();
			
			// Criando um objeto PreparedStatement 
			PreparedStatement pstm = con.prepareStatement(consultarSQL);
			
			if(consultaItem != null){
				
				consultarSQL =  consultarSQL + " where upper(placa) like ? or upper(chassi) like ? or upper(proprietario) like ? "; 
				pstm = con.prepareStatement(consultarSQL);
				pstm.setString(1, "%"+consultaItem.toUpperCase()+"%");
				pstm.setString(2, "%"+consultaItem.toUpperCase()+"%");
				pstm.setString(3, "%"+consultaItem.toUpperCase()+"%");
		
			}
		
			ResultSet rs = pstm.executeQuery();
			
			while(rs.next()){
				BeanVeiculo beanVeiculo = new BeanVeiculo();
				beanVeiculo.setPlaca(rs.getString("placa"));
				beanVeiculo.setChassi(rs.getString("chassi"));
				beanVeiculo.setModelo(rs.getString("modelo"));
				beanVeiculo.setAno(rs.getInt("ano"));
				beanVeiculo.setProprietario(rs.getString("proprietario"));
				
				lista.add(beanVeiculo);
				
			}
			
			rs.close();
			pstm.close();
			con.close();
			
			
		} catch (SQLException e) {
			e.printStackTrace();
		} 
		
		return lista;
	}

	
	
	public BeanVeiculo consultarItem(String placa) {

		String consultarSQL = "select * from veiculo where placa = ?";

		BeanVeiculo beanVeiculo = null;

		try {
			// Criando o objeto de conexao
			ConexaoDAO c = new ConexaoDAO();

			// Estabelecendo a conexão
			Connection con = c.getConnection();

			// Criando um objeto PreparedStatement
			PreparedStatement pstm = con.prepareStatement(consultarSQL);

			pstm.setString(1, placa);

			ResultSet rs = pstm.executeQuery();

			
			while (rs.next()) {

				
				beanVeiculo = new BeanVeiculo();
				beanVeiculo.setPlaca(rs.getString("placa"));
				beanVeiculo.setChassi(rs.getString("chassi"));
				beanVeiculo.setModelo(rs.getString("modelo"));
				beanVeiculo.setAno(rs.getInt("ano"));
				beanVeiculo.setProprietario(rs.getString("proprietario"));

			}

			rs.close();
			pstm.close();
			con.close();

		} catch (SQLException e) {
			e.printStackTrace();
		}

		return beanVeiculo;
	}



}
