package br.com.senac.model.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;

import br.com.senac.model.vo.ClienteVO;
import br.com.senac.model.dao.Banco;


public class ClienteDAO {
	
	public int inserir(ClienteVO cliente){
	int novoId = -1;

	String sql = " INSERT INTO CLIENTE (NOME, SOBRENOME, CPF, EMAIL, CNH, TELEFONE, ENDERECO, CIDADE, ESTADO, CEP) "
			+ " VALUES (?,?,?,?,?,?,?,?,?,?) ";

	Connection conexao = Banco.getConnection();
	PreparedStatement prepStmt = Banco.getPreparedStatementWithGeneratedKeys(conexao, sql);

	try {
		prepStmt.setString(1, cliente.getNome());
		prepStmt.setString(2, cliente.getSobrenome());
		prepStmt.setString(3, cliente.getCpf());
		prepStmt.setString(4, cliente.getEmail());
		prepStmt.setString(5, cliente.getCnh());
		prepStmt.setString(6, cliente.getTelefone());
		prepStmt.setString(7, cliente.getEndereco());
		prepStmt.setString(8, cliente.getCidade());
		prepStmt.setString(9, cliente.getEstado());
		prepStmt.setString(10, cliente.getCep());

		prepStmt.execute();

		ResultSet generatedKeys = prepStmt.getGeneratedKeys();
		if (generatedKeys.next()) {
			novoId = generatedKeys.getInt(1);
		}
	} catch (SQLException e) {
		System.out.println("Erro ao inserir Cliente. Causa: \n:" + e.getCause());
	} finally{
		Banco.closePreparedStatement(prepStmt);
		Banco.closeConnection(conexao);
	}

	return novoId;
}

public boolean atualizar(ClienteVO cliente){
	boolean sucessoUpdate = false;

	String sql = " UPDATE CLIENTE P SET NOME=?, SOBRENOME=?, CPF=?, EMAIL=?, CNH=?, TELEFONE=?, "
			+ "ENDERECO=?, CIDADE=?, ESTADO=?, CEP=? "
			+ " WHERE ID = ? ";

	Connection conexao = Banco.getConnection();
	PreparedStatement prepStmt = Banco.getPreparedStatement(conexao, sql);

	try {
		prepStmt.setString(1, cliente.getNome());
		prepStmt.setString(2, cliente.getSobrenome());
		prepStmt.setString(3, cliente.getCpf());
		prepStmt.setString(4, cliente.getEmail());
		prepStmt.setString(5, cliente.getCnh());
		prepStmt.setString(6, cliente.getTelefone());
		prepStmt.setString(7, cliente.getEndereco());
		prepStmt.setString(8, cliente.getCidade());
		prepStmt.setString(9, cliente.getEstado());
		prepStmt.setString(10, cliente.getCep());

		int codigoRetorno = prepStmt.executeUpdate();

		if(codigoRetorno == 1){
			sucessoUpdate = true;
		}

	} catch (SQLException e) {
		System.out.println("Erro ao atualizar CLiente. Causa: \n:" + e.getCause());
	}finally{
		Banco.closePreparedStatement(prepStmt);
		Banco.closeConnection(conexao);
	}

	return sucessoUpdate;
}

public boolean remover(int idCliente){
	boolean sucessoDelete = false;

	String sql = " DELETE FROM CLIENTE "
			+ " WHERE ID = ? ";

	Connection conexao = Banco.getConnection();
	PreparedStatement prepStmt = Banco.getPreparedStatement(conexao, sql);
	try {
		prepStmt.setInt(1, idCliente);
		int codigoRetorno = prepStmt.executeUpdate();
		if(codigoRetorno == 1){//1 - sucesso na execução
			sucessoDelete = true;
		}
	} catch (SQLException e) {
		System.out.println("Erro ao remover Cliente. Causa: \n:" + e.getCause());
	}finally{
		Banco.closePreparedStatement(prepStmt);
		Banco.closeConnection(conexao);
	}
	return sucessoDelete;
}

public ArrayList<ClienteVO> listarTodos(){
	String sql = " SELECT * FROM CLIENTE ";
	
	Connection conexao = Banco.getConnection();
	PreparedStatement prepStmt = Banco.getPreparedStatement(conexao, sql);
	ArrayList<ClienteVO> clientes = new ArrayList<ClienteVO>();
	
	try {
		ResultSet result = prepStmt.executeQuery();
		
		while(result.next()){
			ClienteVO cliente = new ClienteVO();
			
			cliente.setIdCliente(result.getInt("ID"));
			cliente.setNome(result.getString("NOME"));
			cliente.setSobrenome(result.getString("SOBRENOME"));
			cliente.setCpf(result.getString("CPF"));
			cliente.setEmail(result.getString("EMAIL"));
			cliente.setCnh(result.getString("CNH"));
			cliente.setTelefone(result.getString("TELEFONE"));
			cliente.setEndereco(result.getString("ENDERECO"));
			cliente.setCidade(result.getString("CIDADE"));
			cliente.setEstado(result.getString("ESTADO"));
			cliente.setCep(result.getString("CEP"));
			
			clientes.add(cliente);
		}
	} catch (SQLException e) {
		System.out.println("Erro listar todos os alunos. Causa: \n:" + e.getCause());
	}
	return clientes;
}

public ClienteVO obterPorId(int idCliente){
	String sql = " SELECT * FROM ALUNO "
			+ " WHERE ID=?";
	
	Connection conexao = Banco.getConnection();
	PreparedStatement prepStmt = Banco.getPreparedStatement(conexao, sql);
	ClienteVO cliente = null;
	
	try {
		prepStmt.setInt(1, idCliente);
		ResultSet result = prepStmt.executeQuery();
		
		while(result.next()){
			cliente = new ClienteVO();
			
			cliente.setIdCliente(result.getInt("ID"));
			cliente.setNome(result.getString("NOME"));
			cliente.setSobrenome(result.getString("SOBRENOME"));
			cliente.setCpf(result.getString("CPF"));
			cliente.setEmail(result.getString("EMAIL"));
			cliente.setCnh(result.getString("CNH"));
			cliente.setTelefone(result.getString("TELEFONE"));
			cliente.setEndereco(result.getString("ENDERECO"));
			cliente.setCidade(result.getString("CIDADE"));
			cliente.setEstado(result.getString("ESTADO"));
			cliente.setCep(result.getString("CEP"));
		}
	} catch (SQLException e) {
		System.out.println("Erro buscar um CLiente. Causa: \n:" + e.getCause());
	}
	return cliente;
}
	
	
}
