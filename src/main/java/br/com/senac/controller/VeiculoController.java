package br.com.senac.controller;

import br.com.senac.model.bo.VeiculoBO;
import br.com.senac.model.dao.VeiculoDAO;
import br.com.senac.model.vo.VeiculoVO;

public class VeiculoController {

	/*
	 * 
	 * 1 - Veiculo Deve possuir Renavam válido 11 caracteres numericos
	 * 2 - Veiculo possuir marca, modelo e cor
	 * 3- Veiculo possuir placa válida 3 letras 4 numeros
	 * 
	 * private VeiculoBO bo = new VeiculoBO();
	
	public String salvar(VeiculoVO novoVeiculo) {
		String situacao;
		situacao = "AQUI VÃO SER TRABALHADOS OS CONTROLLERS - apenas testandooo";
		return situacao;
		
	 */
	
	private String mensagem = "";
	
	public String cadastrarVeiculo(VeiculoVO novoVeiculo) {
		if(validarPlaca(novoVeiculo)
				&& validarRenavam(novoVeiculo)
				&& validarChassi(novoVeiculo)
				&& validarMarca(novoVeiculo)
				&& validarModelo(novoVeiculo)
				&& validarAno(novoVeiculo)
				&& validarCor(novoVeiculo)
				&& validarMotor(novoVeiculo)
				&& validarTransmissao(novoVeiculo)) {
			VeiculoDAO veiculoDAO = new VeiculoDAO();
			veiculoDAO.inserir(novoVeiculo);
			
			mensagem = "Veículo Cadastrado Com Sucesso";
		}
		
		return mensagem;
	}

	private boolean validarPlaca(VeiculoVO novoVeiculo) {
		if(novoVeiculo.getPlaca().trim().length() < 3 
				|| novoVeiculo.getPlaca().isEmpty() ) {
			mensagem = "Deve Preencher O Campo Placa";
			return false;
		}
		return true;
	}
	private boolean validarRenavam(VeiculoVO novoVeiculo) {
		if(novoVeiculo.getRenavam().trim().length() != 11) {
			mensagem = "Renavam Deve Conter 11 Caracteres Númericos";
			return false;
		}
		return true;
	}

	private boolean validarChassi(VeiculoVO novoVeiculo) {
		if(novoVeiculo.getChassi().trim().length() !=17
				|| novoVeiculo.getChassi().isEmpty() ) {
			mensagem = "Chassi Deve Conter 11 Caracteres Alfanúmericos";
			return false;
		}
		return true;
	}
	private boolean validarMarca(VeiculoVO novoVeiculo) {
		if(novoVeiculo.getMarca() == null 
				|| novoVeiculo.getMarca().isEmpty()) {
			mensagem = "Deve Preencher O Campo Marca";
			return false;
		}
		return true;
	}

	private boolean validarModelo(VeiculoVO novoVeiculo) {
		if(novoVeiculo.getModelo() == null
				 || novoVeiculo.getModelo().isEmpty() ) {
			mensagem = "Deve Preencher O Campo Modelo";
			return false;
		}
		return true;
	}

	private boolean validarAno(VeiculoVO ano) {
		if(ano == null ) {
			mensagem = "Deve Preencher O Campo Ano";
			return false;
		}
		return true;
	}

	private boolean validarCor(VeiculoVO novoVeiculo) {
		if(novoVeiculo.getCor().isEmpty() ) {
			mensagem = "Deve Preencher O Campo Cor";
			return false;
		}
		return true;
	}

	private boolean validarMotor(VeiculoVO novoVeiculo) {
		if(novoVeiculo.getMotor() == null
				 ||novoVeiculo.getMotor().isEmpty() ) {
			mensagem = "Deve Preencher O Campo Motor";
			return false;
		}
		return true;
	}

	private boolean validarTransmissao(VeiculoVO novoVeiculo) {
		if(novoVeiculo.getTransmissao() == null
				 ||novoVeiculo.getTransmissao().isEmpty() ) {
			mensagem = "Deve preencher o campo transmissão";
			return false;
		}
		return true;
	}

}
