package br.com.senac.model.dao;

import java.sql.Connection;
import java.sql.Date;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import javax.swing.JOptionPane;

import br.com.senac.model.seletores.VeiculoSeletor;
import br.com.senac.model.vo.ClienteVO;
import br.com.senac.model.vo.VeiculoVO;


public class VeiculoDAO {

	public VeiculoVO inserir(VeiculoVO veiculo) {
		Connection conexao = Banco.getConnection();

		String sql = "INSERT INTO VEICULO (PLACA, RENAVAM, CHASSI, MARCA, MODELO, ANO, COR, MOTOR,TRANSMISSAO) "
				+ "VALUES (?,?,?,?,?,?,?,?,?)";

		PreparedStatement query = Banco.getPreparedStatementWithGeneratedKeys(conexao, sql);

		try {

			query.setString(1, veiculo.getPlaca());
			query.setString(2, veiculo.getRenavam());
			query.setString(3, veiculo.getChassi());
			query.setString(4, veiculo.getMarca());
			query.setString(5, veiculo.getModelo());
			query.setInt(6, veiculo.getAno());
			query.setString(7, veiculo.getCor());
			query.setString(8, veiculo.getMotor());
			query.setString(9, veiculo.getTransmissao());

			int codigoRetorno = query.executeUpdate();

			if (codigoRetorno == Banco.CODIGO_RETORNO_SUCESSO) {
				ResultSet resultado = query.getGeneratedKeys();
				int chaveGerada = resultado.getInt(1);

				veiculo.setIdVeiculo(chaveGerada);
			}

		} catch (SQLException e) {
			System.out.println("Erro ao inserir veiculo.\nCausa: " + e.getMessage());
		} finally {
			Banco.closeStatement(query);
			Banco.closeConnection(conexao);
		}

		return veiculo;
	}

	public boolean excluir(String placa) {
		Connection conexao = Banco.getConnection();
		String sql = "DELETE FROM VEICULO WHERE PLACA=?";

		PreparedStatement query = Banco.getPreparedStatement(conexao, sql);
		boolean excluiu = false;

		try {
			query.setString(1, placa);
			int codigoRetorno = query.executeUpdate();
			excluiu = (codigoRetorno == Banco.CODIGO_RETORNO_SUCESSO);
		} catch (SQLException e) {
			System.out.println("Erro ao excluir a PLACA (placa: " + placa + ").\nCausa: " + e.getMessage());
		} finally {
			Banco.closeStatement(query);
			Banco.closeConnection(conexao);
		}

		return excluiu;
	}

	public boolean alterar(VeiculoVO veiculo) {
		String sql = "UPDATE VEICULO "
				+ "SET PLACA=?, RENAVAM=?, CHASSI=?, MARCA=?, MODELO=?, ANO=?, COR=?, MOTOR=?,TRANSMISSAO=?"
				+ "WHERE idVeiculo=? ";

		boolean alterou = false;

		try (Connection conexao = Banco.getConnection();
				PreparedStatement query = Banco.getPreparedStatement(conexao, sql);) {
			query.setString(1, veiculo.getPlaca());
			query.setString(2, veiculo.getRenavam());
			query.setString(3, veiculo.getChassi());
			query.setString(4, veiculo.getMarca());
			query.setString(5, veiculo.getModelo());
			query.setInt(6, veiculo.getAno());
			query.setString(7, veiculo.getCor());
			query.setString(8, veiculo.getMotor());
			query.setString(9, veiculo.getTransmissao());

			int codigoRetorno = query.executeUpdate();
			alterou = (codigoRetorno == Banco.CODIGO_RETORNO_SUCESSO);
		} catch (SQLException e) {
			System.out.println("Erro ao alterar veiculo. \nCausa: " + e.getMessage());
		}

		return alterou;
	}

	public VeiculoVO pesquisarPorPlaca(String placa) {
		String sql = " SELECT * FROM VEICULO WHERE PLACA=? ";
		VeiculoVO veiculobuscado = null;

		try (Connection conexao = Banco.getConnection();
				PreparedStatement consulta = Banco.getPreparedStatement(conexao, sql);) {
			consulta.setString(1, placa);
			ResultSet conjuntoResultante = consulta.executeQuery();

			if (conjuntoResultante.next()) {
				veiculobuscado = contruirVeiculoDoResultSet(conjuntoResultante);
			}
		} catch (SQLException e) {
			System.out.println("Erro ao consultar veiculo por placa (placa: " + placa + ") .\nCausa: " + e.getMessage());
		}

		return veiculobuscado;
	}

	public static VeiculoVO pesquisarPorMarca(String marca) {
		String sql = " SELECT * FROM VEICULO WHERE MARCA=? ";
		VeiculoVO veiculobuscado = null;

		try (Connection conexao = Banco.getConnection();
				PreparedStatement consulta = Banco.getPreparedStatement(conexao, sql);) {
			consulta.setString(1, marca);
			ResultSet conjuntoResultante = consulta.executeQuery();

			if (conjuntoResultante.next()) {
				veiculobuscado = contruirVeiculoDoResultSet(conjuntoResultante);
			}
		} catch (SQLException e) {
			System.out.println("Erro ao consultar veiculo por Id (id: " + marca + ") .\nCausa: " + e.getMessage());
		}

		return veiculobuscado;
	}

	public static List<VeiculoVO> pesquisarTodos() {
		Connection conexao = Banco.getConnection();
		String sql = "SELECT * FROM VEICULO ";

		PreparedStatement consulta = Banco.getPreparedStatement(conexao, sql);
		List<VeiculoVO> veiculosBuscados = new ArrayList<VeiculoVO>();

		try {
			ResultSet conjuntoResultante = consulta.executeQuery();
			while (conjuntoResultante.next()) {
				VeiculoVO veiculoBuscado = contruirVeiculoDoResultSet(conjuntoResultante);
				veiculosBuscados.add(veiculoBuscado);
			}
		} catch (SQLException e) {
			System.out.println("Erro ao consultar todos os veiculos .\nCausa: " + e.getMessage());
		} finally {
			Banco.closeStatement(consulta);
			Banco.closeConnection(conexao);
		}
		return veiculosBuscados;
	}
	
	public boolean placaJaCadastrada(String placa) {
		boolean jaCadastrado = false;
	
		String sql = "SELECT * FROM VEICULO WHERE PLACA =?";
	
		try {Connection conexao = Banco.getConnection();
			PreparedStatement consulta = Banco.getPreparedStatement(conexao, sql);
			consulta.setString(1, placa);
			ResultSet conjuntoResultante = consulta.executeQuery();
			
			if(conjuntoResultante.next()) {
				jaCadastrado = true;
			}
			
		} catch (SQLException e) {
			System.out.println("Erro ao verificar placa (placa: " + placa + ").\nCausa: " + e.getMessage());

		}
		
		return jaCadastrado;
	}
	
	private static VeiculoVO contruirVeiculoDoResultSet(ResultSet conjuntoResultante) throws SQLException {

		VeiculoVO veiculoBuscado = new VeiculoVO();
		veiculoBuscado.setIdVeiculo(conjuntoResultante.getInt("idVeiculo"));
		veiculoBuscado.setPlaca(conjuntoResultante.getString("placa"));
		veiculoBuscado.setRenavam(conjuntoResultante.getString("renavam"));
		veiculoBuscado.setChassi(conjuntoResultante.getString("chassi"));
		veiculoBuscado.setMarca(conjuntoResultante.getString("marca"));
		veiculoBuscado.setModelo(conjuntoResultante.getString("modelo"));
		veiculoBuscado.setAno(conjuntoResultante.getInt("ano"));
		veiculoBuscado.setCor(conjuntoResultante.getString("cor"));
		veiculoBuscado.setMotor(conjuntoResultante.getString("motor"));
		veiculoBuscado.setChassi(conjuntoResultante.getString("chassi"));
		veiculoBuscado.setTransmissao(conjuntoResultante.getString("transmissao"));

		return veiculoBuscado;
	}

	public List<VeiculoVO> listarComSeletor(VeiculoSeletor seletor) {
		String sql = "SELECT * FROM VEICULO ";

		if (seletor.temFiltro()) {
			sql = criarFiltros(seletor, sql);
		}
		Connection conexao = Banco.getConnection();

		PreparedStatement consulta = Banco.getPreparedStatement(conexao, sql);
		ArrayList<VeiculoVO> veiculosBuscados = new ArrayList<VeiculoVO>();

		try {
			ResultSet conjuntoResultante = consulta.executeQuery();
			while (conjuntoResultante.next()) {
				VeiculoVO veiculoBuscado = contruirVeiculoDoResultSet(conjuntoResultante);
				veiculosBuscados.add(veiculoBuscado);
			}
		} catch (SQLException e) {
			System.out.println("Erro ao consultar veiculos com filtros .\nCausa: " + e.getMessage());
		} finally {
			Banco.closeStatement(consulta);
			Banco.closeConnection(conexao);
		}
		return veiculosBuscados;
	}

	private String criarFiltros(VeiculoSeletor seletor, String sql) {
		sql += " WHERE ";
		boolean primeiro = true;

		if ((seletor.getAnoFiltro() != null)) {
			if (!primeiro) {
				sql += " AND ";
			}
			sql += "VEICULO.ANO LIKE '%= " + seletor.getAnoFiltro() + "%'";
			primeiro = false;
		}

		if (seletor.getCorFiltro() != null && seletor.getCorFiltro().trim().length() > 0) {
			if (!primeiro) {
				sql += " AND ";
			}
			sql += "VEICULO.COR LIKE '%= " + seletor.getCorFiltro() + "%'";
			primeiro = false;
		}

		if ((seletor.getMarcaFiltro() != null) && (seletor.getMarcaFiltro().trim().length() > 0)) {
			if (!primeiro) {
				sql += " AND ";
			}
			sql += "VEICULO.MARCA LIKE '%= " + seletor.getMarcaFiltro() + "%'";
			primeiro = false;
		}
		return sql;
	}

}
