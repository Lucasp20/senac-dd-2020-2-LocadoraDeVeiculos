package br.com.senac.model.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import br.com.senac.model.vo.ClienteVO;
import br.com.senac.model.vo.VeiculoVO;
import br.com.senac.model.dao.Banco;


public class ClienteDAO {
	
	public ClienteVO inserir(ClienteVO cliente){
	Connection conexao = Banco.getConnection();

	String sql = " INSERT INTO CLIENTE (NOME, SOBRENOME, CPF, EMAIL, CNH, TELEFONE, ENDERECO, CIDADE, ESTADO, CEP) "
			+ " VALUES (?,?,?,?,?,?,?,?,?,?) ";

	PreparedStatement query = Banco.getPreparedStatementWithGeneratedKeys(conexao, sql);

	try {
		query.setString(1, cliente.getNome());
		query.setString(2, cliente.getSobrenome());
		query.setString(3, cliente.getCpf());
		query.setString(4, cliente.getEmail());
		query.setString(5, cliente.getCnh());
		query.setString(6, cliente.getTelefone());
		query.setString(7, cliente.getEndereco());
		query.setString(8, cliente.getCidade());
		query.setString(9, cliente.getEstado());
		query.setString(10,cliente.getCep());

		int codigoRetorno = query.executeUpdate();

		if (codigoRetorno == Banco.CODIGO_RETORNO_SUCESSO) {
			ResultSet resultado = query.getGeneratedKeys();
			int chaveGerada = resultado.getInt(1);

			cliente.setIdCliente(chaveGerada);
		}

	} catch (SQLException e) {
		System.out.println("Erro ao inserir cliente.\nCausa: " + e.getMessage());
	} finally {
		Banco.closeStatement(query);
		Banco.closeConnection(conexao);
	}

	return cliente;
}
	
	public boolean excluir(int idCliente){
		Connection conexao = Banco.getConnection();

		String sql = "DELETE FROM cliente WHERE idPessoa = " + idCliente;

		PreparedStatement query = Banco.getPreparedStatement(conexao, sql);
		boolean excluiu = false;
		
		try {
			
			int codigoRetorno = query.executeUpdate();
			excluiu = (codigoRetorno == Banco.CODIGO_RETORNO_SUCESSO);
		} catch (SQLException e) {
			System.out.println("Erro ao excluir Pessoa (id: " + idCliente + ") .\nCausa: " + e.getMessage());
		}finally {
			Banco.closeStatement(query);
			Banco.closeConnection(conexao);
		}
				
		return excluiu;
	}

public boolean alterar(ClienteVO cliente){
	
	String sql = " UPDATE CLIENTE "
			+ " SET NOME=?, SOBRENOME=?, CPF=?, EMAIL=?, CNH=?, TELEFONE=?, ENDERECO=?, CIDADE=?, ESTADO=?, CEP=? "
			+ " WHERE IDCLIENTE = ? ";

	boolean alterou = false;
	
	

	try (Connection conexao = Banco.getConnection();
			PreparedStatement query = Banco.getPreparedStatement(conexao, sql);) {
		query.setString(1, cliente.getNome());
		query.setString(2, cliente.getSobrenome());
		query.setString(3, cliente.getCpf());
		query.setString(4, cliente.getEmail());
		query.setString(5, cliente.getCnh());
		query.setString(6, cliente.getTelefone());
		query.setString(7, cliente.getEndereco());
		query.setString(8, cliente.getCidade());
		query.setString(9, cliente.getEstado());
		query.setString(10, cliente.getCep());

		int codigoRetorno = query.executeUpdate();
		alterou = (codigoRetorno == Banco.CODIGO_RETORNO_SUCESSO);
	} catch (SQLException e) {
		System.out.println("Erro ao alterar cliente.\nCausa: " + e.getMessage());
	}
			
	return alterou;
}

public static ClienteVO pesquisarPorNome(String nome) {
	String sql = " SELECT * FROM CLIENTE WHERE NOME=? ";
	ClienteVO clientebuscado = null;
	
	try (Connection conexao = Banco.getConnection();
		PreparedStatement consulta = Banco.getPreparedStatement(conexao, sql);) {
		consulta.setString(1, nome);
		ResultSet conjuntoResultante = consulta.executeQuery();
		
		if(conjuntoResultante.next()) {
			clientebuscado = contruirVeiculoDoResultSet(conjuntoResultante);
		}
	} catch (SQLException e) {
		System.out.println("Erro ao consultar cliente por nome (id: " + nome + ") .\nCausa: " + e.getMessage());
	}
	
	return clientebuscado;
	}

public static List<ClienteVO> pesquisarTodos() {
	Connection conexao = Banco.getConnection();
	String sql = "SQL * FROM VEICULO ";

	PreparedStatement consulta = Banco.getPreparedStatement(conexao,  sql);
	List<ClienteVO> clientesBuscados = new ArrayList<ClienteVO>();

	try { 
		ResultSet conjuntoResultante = consulta.executeQuery();
		while(conjuntoResultante.next()) {
		ClienteVO veiculoBuscado = contruirVeiculoDoResultSet(conjuntoResultante);					
		clientesBuscados.add(veiculoBuscado);
		}
	} catch (SQLException e) {
		System.out.println("Erro ao consultar todos os clientes .\nCausa: " + e.getMessage());
	}finally {			
		Banco.closeStatement(consulta);			
		Banco.closeConnection(conexao);
	}	
		return clientesBuscados;
}

private static ClienteVO contruirVeiculoDoResultSet(ResultSet conjuntoResultante) throws SQLException{

	ClienteVO clienteBuscado = new ClienteVO();
	clienteBuscado.setIdCliente(conjuntoResultante.getInt("idCliente"));
	clienteBuscado.setNome(conjuntoResultante.getString("Nome"));
	clienteBuscado.setSobrenome(conjuntoResultante.getString("sobrenome"));
	clienteBuscado.setCpf(conjuntoResultante.getString("cpf"));
	clienteBuscado.setEmail(conjuntoResultante.getString("email"));
	clienteBuscado.setCnh(conjuntoResultante.getString("cnh"));
	clienteBuscado.setTelefone(conjuntoResultante.getString("telefone"));
	clienteBuscado.setEndereco(conjuntoResultante.getString("endereco"));
	clienteBuscado.setCidade(conjuntoResultante.getString("cidade"));
	clienteBuscado.setEstado(conjuntoResultante.getString("estado"));
	clienteBuscado.setCep(conjuntoResultante.getString("cep"));
			
	return clienteBuscado;
	}
}
