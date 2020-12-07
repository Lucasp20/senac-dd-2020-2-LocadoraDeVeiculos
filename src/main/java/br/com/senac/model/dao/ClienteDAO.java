package br.com.senac.model.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import javax.swing.JOptionPane;

import br.com.senac.model.vo.ClienteVO;
import br.com.senac.model.vo.VeiculoVO;
import br.com.senac.model.dao.Banco;
import br.com.senac.model.seletores.ClienteSeletor;
import br.com.senac.view.PainelRelatorioLocacao;

public class ClienteDAO {

	public ClienteVO inserir(ClienteVO cliente) {
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
			query.setString(10, cliente.getCep());

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

	public String excluir(String cpf) {
		Connection conexao = Banco.getConnection();

		String sql = "DELETE FROM CLIENTE WHERE CPF =?";

		PreparedStatement query = Banco.getPreparedStatement(conexao, sql);
		String excluiu = null;

		try {
			query.setString(1, cpf);
		} catch (SQLException e) {
			System.out.println("Erro ao excluir o CPF (cpf: " + cpf + ").\nCausa: " + e.getMessage());
		} finally {
			Banco.closeStatement(query);
			Banco.closeConnection(conexao);
		}

		return excluiu;
	}

	public boolean alterar(ClienteVO cliente) {

		String sql = " UPDATE CLIENTE "
				+ " SET NOME=?, SOBRENOME=?, CPF=?, EMAIL=?, CNH=?, TELEFONE=?, ENDERECO=?, CIDADE=?, ESTADO=?, CEP=? "
				+ " WHERE CPF = ? ";

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

	public static ClienteVO pesquisarPorCpf(String cpf) {
		String sql = " SELECT * FROM CLIENTE WHERE CPF=? ";
		ClienteVO clientebuscado = null;

		try (Connection conexao = Banco.getConnection();
				PreparedStatement consulta = Banco.getPreparedStatement(conexao, sql);) {
			consulta.setString(1, cpf);
			ResultSet conjuntoResultante = consulta.executeQuery();

			if (conjuntoResultante.next()) {
				clientebuscado = contruirClienteDoResultSet(conjuntoResultante);
			}
		} catch (SQLException e) {
			System.out.println("Erro ao consultar cliente por cpf (cpf" + cpf + ") .\nCausa: " + e.getMessage());
		}

		return clientebuscado;
	}

	public ClienteVO pesquisarPorNome(String nome) {
		String sql = "SELECT * FROM CLIENTE WHERE NOME=?";
		ClienteVO clientebuscado = null;

		try (Connection conexao = Banco.getConnection();
				PreparedStatement consulta = Banco.getPreparedStatement(conexao, sql);) {
			consulta.setString(1, nome);
			ResultSet conjuntoResultante = consulta.executeQuery();

			if (conjuntoResultante.next()) {
				clientebuscado = contruirClienteDoResultSet(conjuntoResultante);
			}

		} catch (SQLException e) {
			System.out.println("Erro ao consultar cliente por nome (id: " + nome + ") .\nCausa: " + e.getMessage());
		}

		return clientebuscado;
	}

	public static List<ClienteVO> pesquisarTodos() {
		Connection conexao = Banco.getConnection();
		String sql = "SELECT * FROM CLIENTE ";

		PreparedStatement consulta = Banco.getPreparedStatement(conexao, sql);
		List<ClienteVO> clientesBuscados = new ArrayList<ClienteVO>();

		try {
			ResultSet conjuntoResultante = consulta.executeQuery();
			while (conjuntoResultante.next()) {
				ClienteVO clienteBuscado = contruirClienteDoResultSet(conjuntoResultante);
				clientesBuscados.add(clienteBuscado);
			}
		} catch (SQLException e) {
			System.out.println("Erro ao consultar todos os clientes .\nCausa: " + e.getMessage());
		} finally {
			Banco.closeStatement(consulta);
			Banco.closeConnection(conexao);
		}
		return clientesBuscados;
	}
	
	private static ClienteVO contruirClienteDoResultSet(ResultSet conjuntoResultante) throws SQLException {

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

	public ArrayList<ClienteVO> listarComSeletor(ClienteSeletor seletor) {
		String sql = "SELECT * FROM CLIENTE ";

		if (seletor.temFiltro()) {
			sql = criarFiltros(seletor, sql);
		}
		Connection conexao = Banco.getConnection();

		PreparedStatement consulta = Banco.getPreparedStatement(conexao, sql);
		ArrayList<ClienteVO> clientesBuscados = new ArrayList<ClienteVO>();

		try {
			ResultSet conjuntoResultante = consulta.executeQuery();
			while (conjuntoResultante.next()) {
				ClienteVO clienteBuscado = contruirClienteDoResultSet(conjuntoResultante);
				clientesBuscados.add(clienteBuscado);
			}
		} catch (SQLException e) {
			System.out.println("Erro ao consultar clientes com filtros .\nCausa: " + e.getMessage());
		} finally {
			Banco.closeStatement(consulta);
			Banco.closeConnection(conexao);
		}
		return clientesBuscados;
	}


	
	private String criarFiltros(ClienteSeletor seletor, String sql) {
		sql += " WHERE ";
		boolean primeiro = true;

		if ((seletor.getNomeFiltro() != null) && (seletor.getNomeFiltro().trim().length() > 0)) {
			if (!primeiro) {
				sql += " AND ";
			}
			sql += "CLIENTE.NOME LIKE '%= " + seletor.getNomeFiltro() + "%'";
			primeiro = false;
		}

		if ((seletor.getCidadeFiltro() != null) && (seletor.getCidadeFiltro().trim().length() > 0)) {
			if (!primeiro) {
				sql += " AND ";
			}
			sql += "CLIENTE.CIDADE LIKE '%= " + seletor.getCidadeFiltro() + "%'";
			primeiro = false;
		}

		if ((seletor.getEstadoFiltro() != null) && (seletor.getEstadoFiltro().trim().length() > 0)) {
			if (!primeiro) {
				sql += " AND ";
			}
			sql += "CLIENTE.ESTADO LIKE '%= " + seletor.getEstadoFiltro() + "%'";
			primeiro = false;
		}
		return sql;
	}


}
