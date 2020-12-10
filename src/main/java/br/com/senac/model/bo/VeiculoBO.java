package br.com.senac.model.bo;

import java.util.List;

import br.com.senac.constante.Mensagens;
import br.com.senac.controller.VeiculoController;
import br.com.senac.model.dao.VeiculoDAO;
import br.com.senac.model.seletores.VeiculoSeletor;
import br.com.senac.model.vo.VeiculoVO;

public class VeiculoBO {

	VeiculoDAO dao = new VeiculoDAO();

	String mensagem = "";

	public String cadastrarVeiculo(VeiculoVO novoVeiculo) {
		if (validarPlaca(novoVeiculo) && validarRenavam(novoVeiculo) && validarChassi(novoVeiculo)
				&& validarMarca(novoVeiculo) && validarModelo(novoVeiculo) && validarAno(novoVeiculo)
				&& validarCor(novoVeiculo) && validarMotor(novoVeiculo) && validarTransmissao(novoVeiculo)) {

			dao.inserir(novoVeiculo);

			mensagem = Mensagens.VEICULO_SUCESSO;
		}

		return mensagem;
	}

	private boolean validarPlaca(VeiculoVO novoVeiculo) {
		if (novoVeiculo.getPlaca().trim().length() < 3 || novoVeiculo.getPlaca().isEmpty()) {
			mensagem = Mensagens.VEICULO_ERRO_PLACA;
			return false;

		} else if (dao.placaJaCadastrada(novoVeiculo.getPlaca())) {
			mensagem = Mensagens.VEICULO_ERRO_PLACA_EXISTE;
			return false;
		}
		return true;
	}

	private boolean validarRenavam(VeiculoVO novoVeiculo) {
		if (novoVeiculo.getRenavam().trim().length() != 11) {
			mensagem = Mensagens.VEICULO_ERRO_RENAVAM;
			return false;
		}
		return true;
	}

	private boolean validarChassi(VeiculoVO novoVeiculo) {
		if (novoVeiculo.getChassi().trim().length() != 17 || novoVeiculo.getChassi().isEmpty()) {
			mensagem = Mensagens.VEICULO_ERRO_CHASSI;
			return false;
		}
		return true;
	}

	private boolean validarMarca(VeiculoVO novoVeiculo) {
		if (novoVeiculo.getMarca() == null || novoVeiculo.getMarca().isEmpty()) {
			mensagem = Mensagens.VEICULO_ERRO_MARCA;
			return false;
		}
		return true;
	}

	private boolean validarModelo(VeiculoVO novoVeiculo) {
		if (novoVeiculo.getModelo() == null || novoVeiculo.getModelo().isEmpty()) {
			mensagem = Mensagens.VEICULO_ERRO_MODELO;
			return false;
		}
		return true;
	}

	private boolean validarAno(VeiculoVO ano) {
		if (ano == null) {
			mensagem = Mensagens.VEICULO_ERRO_ANO;
			return false;
		}
		return true;
	}

	private boolean validarCor(VeiculoVO novoVeiculo) {
		if (novoVeiculo.getCor().isEmpty()) {
			mensagem = Mensagens.VEICULO_ERRO_COR;
			return false;
		}
		return true;
	}

	private boolean validarMotor(VeiculoVO novoVeiculo) {
		if (novoVeiculo.getMotor() == null || novoVeiculo.getMotor().isEmpty()) {
			mensagem = Mensagens.VEICULO_ERRO_MOTOR;
			return false;
		}
		return true;
	}

	private boolean validarTransmissao(VeiculoVO novoVeiculo) {
		if (novoVeiculo.getTransmissao() == null || novoVeiculo.getTransmissao().isEmpty()) {
			mensagem = Mensagens.VEICULO_ERRO_TRANSMISSAO;
			return false;
		}
		return true;
	}   
	
	public String excluir(String placa) {
		//TODO verificar se o veiculo pode ser excluido(sem locacao)
	
		boolean excluiu = dao.excluir(placa);

		if (excluiu) {
			mensagem = "Veículo excluido com sucesso!";
		} else {
			mensagem = "Erro ao excluir veículo";
		}

		return mensagem;
	}

}
