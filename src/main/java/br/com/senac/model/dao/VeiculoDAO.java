package br.com.senac.model.dao;

import java.sql.Connection;
import java.sql.Date;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import br.com.senac.model.vo.VeiculoVO;


public class VeiculoDAO {

	public VeiculoVO inserir(VeiculoVO veiculo) {
		Connection conexao = Banco.getConnection();

		String sql = "INSERT INTO PESSOA (PLACA, RENAVAM, CHASSI, MARCA, MODELO, ANO, COR, MOTOR,TRANSMISSAO) "
				+ "VALUES (?,?,?,?,?,?,?,?,?,?)";

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
			System.out.println("Erro ao inserir pessoa.\nCausa: " + e.getMessage());
		} finally {
			Banco.closeStatement(query);
			Banco.closeConnection(conexao);
		}

		return veiculo;
	}
	
	public int excluir(int idVeiculo) {
		Connection conexao = Banco.getConnection();
		String sql = " DELETE FROM VEICULO WHERE idVeiculo=? ";
		
		PreparedStatement query = Banco.getPreparedStatement(conexao, sql);
		int excluiu = 0;
		
		try {
			query.setInt(1, idVeiculo);
			
			int codigoRetorno = query.executeUpdate();
			
		} catch (SQLException e) {
			System.out.println("Erro ao excluir veiculo (id: " + idVeiculo + ") .\nCausa: " + e.getMessage());
		}finally {
			Banco.closeStatement(query);
			Banco.closeConnection(conexao);
		}
				
		return excluiu;
	}

	public boolean alterar (VeiculoVO veiculo) {
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
	
	public static VeiculoVO pesquisarPorMarca(String marca) {
		String sql = " SELECT * FROM VEICULO WHERE MARCA=? ";
		VeiculoVO veiculobuscado = null;
		
		try (Connection conexao = Banco.getConnection();
			PreparedStatement consulta = Banco.getPreparedStatement(conexao, sql);) {
			consulta.setString(1, marca);
			ResultSet conjuntoResultante = consulta.executeQuery();
			
			if(conjuntoResultante.next()) {
				veiculobuscado = contruirVeiculoDoResultSet(conjuntoResultante);
			}
		} catch (SQLException e) {
			System.out.println("Erro ao consultar veiculo por Id (id: " + marca + ") .\nCausa: " + e.getMessage());
		}
		
		return veiculobuscado;
	}
	

	public static List<VeiculoVO> pesquisarTodos() {
		Connection conexao = Banco.getConnection();
		String sql = "SQL * FROM VEICULO ";

		PreparedStatement consulta = Banco.getPreparedStatement(conexao,  sql);
		List<VeiculoVO> veiculosBuscados = new ArrayList<VeiculoVO>();
	
		try { 
			ResultSet conjuntoResultante = consulta.executeQuery();
			while(conjuntoResultante.next()) {
			VeiculoVO veiculoBuscado = contruirVeiculoDoResultSet(conjuntoResultante);					
			veiculosBuscados.add(veiculoBuscado);
			}
		} catch (SQLException e) {
			System.out.println("Erro ao consultar todos os veiculos .\nCausa: " + e.getMessage());
		}finally {			
			Banco.closeStatement(consulta);			
			Banco.closeConnection(conexao);
		}	
			return veiculosBuscados;
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
	
}

