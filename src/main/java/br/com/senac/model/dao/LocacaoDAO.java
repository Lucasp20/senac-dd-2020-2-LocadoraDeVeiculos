package br.com.senac.model.dao;

import java.sql.Connection;
import java.sql.Date;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

import br.com.senac.model.seletores.LocacaoSeletor;
import br.com.senac.model.seletores.VeiculoSeletor;
import br.com.senac.model.vo.ClienteVO;
import br.com.senac.model.vo.LocacaoVO;
import br.com.senac.model.vo.VeiculoVO;

public class LocacaoDAO {
	
	public LocacaoVO inserir (LocacaoVO novaLocacao) {
		Connection conexao = Banco.getConnection();
		
		String sql = "INSERT INTO LOCACAO (DATA_LOCACAO, KMLOCACAO, DATA_ENTREGA, KMENTREGA, IDCLIENTE, IDVEICULO)"
				+ "VALUES (?,?,?,?,?,?)";
		
		PreparedStatement query = Banco.getPreparedStatementWithGeneratedKeys(conexao, sql);
		
		try {
			
			ClienteVO nomeDoCliente = verificarNomeDoCliente(novaLocacao);
			VeiculoVO nomeDoVeiculo = verificarNomeDoVeiculo(novaLocacao);
			
			Date dataLocacaoConvertidaParaSQL = java.sql.Date.valueOf(novaLocacao.getDataLocacao());
			query.setDate(1, dataLocacaoConvertidaParaSQL);
			query.setInt(2, novaLocacao.getKmLocacao());
			Date dataEntregaConvertidaParaSQL = java.sql.Date.valueOf(novaLocacao.getDataEntrega());
			query.setDate(3, dataEntregaConvertidaParaSQL);
			query.setInt(4, novaLocacao.getKmEntrega());
			query.setInt(5, nomeDoCliente.getIdCliente());
			query.setInt(6, nomeDoVeiculo.getIdVeiculo());
			
			int codigoRetorno = query.executeUpdate();
			if(codigoRetorno == Banco.CODIGO_RETORNO_SUCESSO) {
				ResultSet resultado = query.getGeneratedKeys();
				int chaveGerada = resultado.getInt(1);
				
				novaLocacao.setIdLocacao(chaveGerada);
	
			}
		
		} catch (SQLException e) {
			System.out.println("Erro ao inserir locacao.\nCausa: " + e.getMessage());
		}finally {
			Banco.closeStatement(query);
			Banco.closeConnection(conexao);
		}
		
		return novaLocacao;
	}
	
	public boolean alterar(LocacaoVO locacao) {
		String sql = " UPDATE LOCACAO "
				+ " SET DATA_LOCACAO=?, KMLOCACAO=?, DATA_ENTREGA=?, KMENTREGA=?, IDCLIENTE=?, IDVEICULO=? " 
				+ " WHERE IDLOCACAO=? ";
		
		boolean alterou = false;
		ClienteVO nomeDoCliente = verificarNomeDoCliente(locacao);
		VeiculoVO nomeDoVeiculo = verificarNomeDoVeiculo(locacao);
		
		try (Connection conexao = Banco.getConnection();
			PreparedStatement query = Banco.getPreparedStatement(conexao, sql);) {
			Date dataLocacaoConvertidaParaSQL = java.sql.Date.valueOf(locacao.getDataLocacao());
			query.setDate(1, dataLocacaoConvertidaParaSQL);
			query.setInt(2, locacao.getKmLocacao());
			Date dataEntregaConvertidaParaSQL = java.sql.Date.valueOf(locacao.getDataEntrega());
			query.setDate(3, dataEntregaConvertidaParaSQL);
			query.setInt(4, locacao.getKmEntrega());
			query.setInt(5, nomeDoCliente.getIdCliente());
			query.setInt(6, nomeDoVeiculo.getIdVeiculo());
			
			int codigoRetorno = query.executeUpdate();
			alterou = (codigoRetorno == Banco.CODIGO_RETORNO_SUCESSO);
		} catch (SQLException e) {
			System.out.println("Erro ao alterar locacao.\nCausa: " + e.getMessage());
		}
				
		return alterou;
	}
	
	public boolean excluir (int idLocacao) {
		Connection conexao = Banco.getConnection();
		String sql = "DELETE FROM LOCACAO WHERE IDLOCACAO=?";
		
		PreparedStatement query = Banco.getPreparedStatement(conexao, sql);
		boolean excluiu = false;
		
		try {
			query.setInt(1, idLocacao);
			
			int codigoRetorno = query.executeUpdate();
			excluiu = (codigoRetorno == Banco.CODIGO_RETORNO_SUCESSO);
		} catch (SQLException e) { 
			System.out.println("Erro ao excluir locacao (id: "+ idLocacao +" ) .\nCausa: " + e.getMessage());
		}finally {
			Banco.closeStatement(query);
			Banco.closeConnection(conexao);
		}
		
		return excluiu;
	}
	
	public LocacaoVO pesquisarPorNome(String nome) {
		String sql = "SELECT * FROM LOCACAO WHERE NOME=? ";
		LocacaoVO locacaoBuscada = null;
		
		try (Connection conexao = Banco.getConnection();
			PreparedStatement consulta = Banco.getPreparedStatement(conexao, sql);) {
			consulta.setString(1, nome);
			ResultSet conjuntoResultante = consulta.executeQuery();
			
			if(conjuntoResultante.next()) {
				locacaoBuscada = construirLocacaoDoResultSet(conjuntoResultante);
			}
		} catch (SQLException e) {
			System.out.println("Erro ao consultar locacao por nome (" + nome + ") .\\nCausa: " + e.getMessage());
		}
		return locacaoBuscada;
	}

	public List<LocacaoVO> pesquisarTodos() {
		Connection conexao = Banco.getConnection();
		String sql = "SQL * FROM LOCACAO ";
		
		PreparedStatement consulta = Banco.getPreparedStatement(conexao, sql);
		List<LocacaoVO> locacoesBuscadas = new ArrayList<LocacaoVO>();
		
		try {
			ResultSet conjuntoResultante = consulta.executeQuery();
			while(conjuntoResultante.next()) {
				LocacaoVO locacaoBuscado = construirLocacaoDoResultSet(conjuntoResultante);
				locacoesBuscadas.add(locacaoBuscado);
			}
		} catch (SQLException e) {
			System.out.println("Erro ao consultar todas as locações .\nCausa: " + e.getMessage());
		}finally {
			Banco.closeStatement(consulta);
			Banco.closeConnection(conexao);
		}
		
		return locacoesBuscadas;
	}
	
	private ClienteVO verificarNomeDoCliente(LocacaoVO locacao) {
		ClienteVO nomeDoCliente = locacao.getCliente();
		if(nomeDoCliente != null) {
			if(nomeDoCliente.getIdCliente() == 0) {
				
				ClienteDAO endDAO = new ClienteDAO();
				nomeDoCliente = endDAO.inserir(locacao.getCliente());
			}
		}
		
		return nomeDoCliente;
	}
	
	private VeiculoVO verificarNomeDoVeiculo(LocacaoVO locacao) {
		VeiculoVO nomeDoVeiculo = locacao.getVeiculo();
		if(nomeDoVeiculo != null) {
			if(nomeDoVeiculo.getIdVeiculo() == 0) {
				
				VeiculoDAO endDAO = new VeiculoDAO();
				nomeDoVeiculo = endDAO.inserir(locacao.getVeiculo());
			}
		}
		
		return nomeDoVeiculo;
	}
	
	private LocacaoVO construirLocacaoDoResultSet(ResultSet conjuntoResultante) throws SQLException {
		LocacaoVO locacaoBuscada = new LocacaoVO();
		locacaoBuscada.setIdLocacao(conjuntoResultante.getInt("id"));
		Date datalocacao = conjuntoResultante.getDate("data_locacao");
		LocalDate dataLocacao = datalocacao.toLocalDate();
		locacaoBuscada.setDataLocacao(dataLocacao);
		locacaoBuscada.setKmLocacao(conjuntoResultante.getInt("kmlocacao"));
		Date dataentrega = conjuntoResultante.getDate("data_entrega");
		LocalDate dataEntrega = dataentrega.toLocalDate();
		locacaoBuscada.setDataEntrega(dataEntrega);
		locacaoBuscada.setKmEntrega(conjuntoResultante.getInt("kmentrega"));
					
		//Preenche o nome do cliente
		ClienteDAO clienteDAO = new ClienteDAO();
		String nome = conjuntoResultante.getString("NOME");
		ClienteVO nomeDoCliente = clienteDAO.pesquisarPorNome(nome);
		locacaoBuscada.setCliente(nomeDoCliente);
		
		//Preenche o nome do veiculo
		VeiculoDAO veiculoDAO = new VeiculoDAO();
		String marca = conjuntoResultante.getString("MARCA");
		VeiculoVO nomeDoVeiuclo = veiculoDAO.pesquisarPorMarca(marca);
		locacaoBuscada.setVeiculo(nomeDoVeiuclo);
		
		return locacaoBuscada;
	}
	
	public List<LocacaoVO> listarComSeletor(LocacaoSeletor seletor) {
		String sql = "SELECT * FROM LOCACAO ";

		if (seletor.temFiltro()) {
			sql = criarFiltros(seletor, sql);
		}
		Connection conexao = Banco.getConnection();

		PreparedStatement consulta = Banco.getPreparedStatement(conexao, sql);
		ArrayList<LocacaoVO> locacoesBuscadas = new ArrayList<LocacaoVO>();

		try {
			ResultSet conjuntoResultante = consulta.executeQuery();
			while (conjuntoResultante.next()) {
				LocacaoVO locacaoBuscado = construirLocacaoDoResultSet(conjuntoResultante);
				locacoesBuscadas.add(locacaoBuscado);
			}
		} catch (SQLException e) {
			System.out.println("Erro ao consultar locação com filtros .\nCausa: " + e.getMessage());
		} finally {
			Banco.closeStatement(consulta);
			Banco.closeConnection(conexao);
		}
		return locacoesBuscadas;
	}

	private String criarFiltros(LocacaoSeletor seletor, String sql) {
		sql += " WHERE ";
		boolean primeiro = true;
		
		if(seletor.getIdCliente() >0) {
			if(!primeiro) {
				sql+= "AND";
			}
			sql += "LOCACAO.id = " + seletor.getIdCliente();
			primeiro = false;
		}
		
		if ((seletor.getNomeClienteFiltro() != null)) {
			if (!primeiro) {
				sql += " AND ";
			}
			sql += "LOCACAO.NOME LIKE '%= " + seletor.getNomeClienteFiltro() + "%'";
			primeiro = false;
		}
		if (seletor.getDataAluguel() != null) {
			if (!primeiro) {
				sql += " AND ";
			}
			sql += "LOCACAO.DATA_LOCACAO LIKE '%= " + seletor.getDataAluguel() + "%'";
			primeiro = false;
		}

		if (seletor.getDataDevolucao() != null)  {
			if (!primeiro) {
				sql += " AND ";
			}
			sql += "LOCACAO.DATA_ENTREGA LIKE '%= " + seletor.getDataDevolucao() + "%'";
			primeiro = false;
		}

		
		return sql;
	}
	
	
}
