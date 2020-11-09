package br.com.senac.model.dao;

import java.sql.Connection;
import java.sql.Date;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import br.com.senac.model.vo.VeiculoVO;

public class VeiculoDAO {

	public VeiculoVO inserir(VeiculoVO veiculo) {
		Connection conexao = Banco.getConnection();

		String sql = "INSERT INTO PESSOA (PLACA, RENAVAM, CHASSI, MARCA, MODELO, ANO, COR, MOTOR,TRANSMISSAO, SITUACAO) "
				+ "VALUES (?,?,?,?,?,?,?,?,?,?)";

		PreparedStatement query = Banco.getPreparedStatementWithGeneratedKeys(conexao, sql);

		try {
			
			query.setString(1, veiculo.getPlaca());
			query.setString(1, veiculo.getPlaca());
			query.setString(1, veiculo.getPlaca());
			query.setString(1, veiculo.getPlaca());
			query.setString(1, veiculo.getPlaca());
			query.setString(1, veiculo.getPlaca());

			int codigoRetorno = query.executeUpdate();

			if (codigoRetorno == Banco.CODIGO_RETORNO_SUCESSO) {
				ResultSet resultado = query.getGeneratedKeys();
				int chaveGerada = resultado.getInt(1);

				pessoa.setIdPessoa(chaveGerada);
			}

		} catch (SQLException e) {
			System.out.println("Erro ao inserir pessoa.\nCausa: " + e.getMessage());
		} finally {
			Banco.closeStatement(query);
			Banco.closeConnection(conexao);
		}

		return pessoa;
	}
}

