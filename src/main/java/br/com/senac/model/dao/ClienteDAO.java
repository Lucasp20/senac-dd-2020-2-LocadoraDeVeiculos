package br.com.senac.model.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;

import model.dao.Banco;
import model.vo.ClienteVO;

/*
 * 
 * public ClienteVO(int idCliente, String nome, String sobrenome, String cpf, String email, String cnh,
			String telefone, String endereco, String cidade, String estado, String cep) {
		super();
		this.idCliente = idCliente;
		this.nome = nome;
		this.sobrenome = sobrenome;
		this.cpf = cpf;
		this.email = email;
		this.cnh = cnh;
		this.telefone = telefone;
		this.endereco = endereco;
		this.cidade = cidade;
		this.estado = estado;
		this.cep = cep;
	 * 
 */

public class ClienteDAO {
	
	int novoId = -1;

	String sql = " INSERT INTO CLIENTE (NOME, SOBRENOME, CPF, EMAIL, CNH, TELEFONE, ENDERECO, CIDADE, ESTADO, CEP) "
			+ " VALUES (?,?,?,?,?,?,?,?,?,?) ";

	Connection conexao = Banco.getConnection();
	PreparedStatement prepStmt = Banco.getPreparedStatement(conexao, sql, 
			java.sql.Statement.RETURN_GENERATED_KEYS);}

	try {
		prepStmt.setString(1, a.getNome());
		prepStmt.setString(2, a.getMatricula());
		prepStmt.setDouble(3, a.getNotaProva1());
		prepStmt.setDouble(4, a.getNotaProva2());
		prepStmt.setDouble(5, a.getNotaTrabalho1());
		prepStmt.setDouble(6, a.getNotaTrabalho2());
		prepStmt.setString(7, a.getSobrenome());
		prepStmt.setString(8, a.getNivel());
		prepStmt.setString(9, a.getSituacao());
		prepStmt.setDouble(10, a.getNotaFinal());

		prepStmt.execute();

		ResultSet generatedKeys = prepStmt.getGeneratedKeys();
		if (generatedKeys.next()) {
			novoId = generatedKeys.getInt(1);
		}
	} catch (SQLException e) {
		System.out.println("Erro ao inserir aluno. Causa: \n:" + e.getCause());
	} finally{
		Banco.closePreparedStatement(prepStmt);
		Banco.closeConnection(conexao);
	}

	return novoId;
}

public boolean atualizar(Aluno a){
	boolean sucessoUpdate = false;

	String sql = " UPDATE ALUNO P SET NOME=?, MATRICULA=?, NOTA_P1=?, NOTA_P2=?, NOTA_T1=?, NOTA_T2=?, "
			+ "SOBRENOME=?, NIVEL=?, SITUACAO=?, NOTA_FINAL=? "
			+ " WHERE ID = ? ";

	Connection conexao = Banco.getConnection();
	PreparedStatement prepStmt = Banco.getPreparedStatement(conexao, sql);

	try {
		prepStmt.setString(1, a.getNome());
		prepStmt.setString(2, a.getMatricula());
		prepStmt.setDouble(3, a.getNotaProva1());
		prepStmt.setDouble(4, a.getNotaProva2());
		prepStmt.setDouble(5, a.getId());
		prepStmt.setDouble(6, a.getNotaTrabalho2());
		prepStmt.setString(7, a.getSobrenome());
		prepStmt.setString(8, a.getNivel());
		prepStmt.setString(9, a.getSituacao());
		prepStmt.setDouble(10, a.getNotaFinal());

		int codigoRetorno = prepStmt.executeUpdate();

		if(codigoRetorno == 1){
			sucessoUpdate = true;
		}

	} catch (SQLException e) {
		System.out.println("Erro ao atualizar aluno. Causa: \n:" + e.getCause());
	}finally{
		Banco.closePreparedStatement(prepStmt);
		Banco.closeConnection(conexao);
	}

	return sucessoUpdate;
}

public boolean remover(int id){
	boolean sucessoDelete = false;

	String sql = " DELETE FROM ALUNO "
			+ " WHERE ID = ? ";

	Connection conexao = Banco.getConnection();
	PreparedStatement prepStmt = Banco.getPreparedStatement(conexao, sql);
	try {
		prepStmt.setInt(1, id);
		int codigoRetorno = prepStmt.executeUpdate();
		if(codigoRetorno == 1){//1 - sucesso na execuÃ§Ã£o
			sucessoDelete = true;
		}
	} catch (SQLException e) {
		System.out.println("Erro ao remover aluno. Causa: \n:" + e.getCause());
	}finally{
		Banco.closePreparedStatement(prepStmt);
		Banco.closeConnection(conexao);
	}
	return sucessoDelete;
}

public ArrayList<Aluno> listarTodos(){
	String sql = " SELECT * FROM ALUNO ";
	
	Connection conexao = Banco.getConnection();
	PreparedStatement prepStmt = Banco.getPreparedStatement(conexao, sql);
	ArrayList<Aluno> alunos = new ArrayList<Aluno>();
	
	try {
		ResultSet result = prepStmt.executeQuery();
		
		while(result.next()){
			Aluno aluno = new Aluno();
			
			aluno.setId(result.getInt("ID"));
			aluno.setNome(result.getString("NOME"));
			aluno.setMatricula(result.getString("MATRICULA"));
			aluno.setNotaProva1(result.getDouble("NOTA_P1"));
			aluno.setNotaProva2(result.getDouble("NOTA_P2"));
			aluno.setNotaTrabalho1(result.getDouble("NOTA_T1"));
			aluno.setNotaTrabalho2(result.getDouble("NOTA_T2"));
			aluno.setSobrenome(result.getString("SOBRENOME"));
			aluno.setNivel(result.getString("NIVEL"));
			aluno.setSituacao(result.getString("SITUACAO"));
			aluno.setNotaFinal(result.getDouble("NOTA_FINAL"));
			
			alunos.add(aluno);
		}
	} catch (SQLException e) {
		System.out.println("Erro listar todos os alunos. Causa: \n:" + e.getCause());
	}
	return alunos;
}

public Aluno obterPorId(int id){
	String sql = " SELECT * FROM ALUNO "
			+ " WHERE ID=?";
	
	Connection conexao = Banco.getConnection();
	PreparedStatement prepStmt = Banco.getPreparedStatement(conexao, sql);
	Aluno aluno = null;
	
	try {
		prepStmt.setInt(1, id);
		ResultSet result = prepStmt.executeQuery();
		
		while(result.next()){
			aluno = new Aluno();
			
			aluno.setId(result.getInt("ID"));
			aluno.setNome(result.getString("NOME"));
			aluno.setMatricula(result.getString("MATRICULA"));
			aluno.setNotaProva1(result.getDouble("NOTA_P1"));
			aluno.setNotaProva2(result.getDouble("NOTA_P2"));
			aluno.setNotaTrabalho1(result.getDouble("NOTA_T1"));
			aluno.setNotaTrabalho2(result.getDouble("NOTA_T2"));
			aluno.setSobrenome(result.getString("SOBRENOME"));
			aluno.setNivel(result.getString("NIVEL"));
			aluno.setSituacao(result.getString("SITUACAO"));
			aluno.setNotaFinal(result.getDouble("NOTA_FINAL"));
		}
	} catch (SQLException e) {
		System.out.println("Erro buscar um aluno. Causa: \n:" + e.getCause());
	}
	return aluno;
}
	
	
}
