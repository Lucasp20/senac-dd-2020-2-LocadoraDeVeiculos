package br.com.senac.controller;

import java.util.List;

import br.com.senac.constante.Mensagens;
import br.com.senac.model.bo.VeiculoBO;
import br.com.senac.model.dao.VeiculoDAO;
import br.com.senac.model.seletores.VeiculoSeletor;
import br.com.senac.model.util.GeradorPlanilhaCliente;
import br.com.senac.model.util.GeradorPlanilhaVeiculo;
import br.com.senac.model.vo.ClienteVO;
import br.com.senac.model.vo.VeiculoVO;

public class VeiculoController {

	VeiculoDAO veiculoDAO = new VeiculoDAO();
	VeiculoVO veiculoVO = new VeiculoVO();

	private String mensagem = "";
	private String mensagemExcluido = "";

	public String cadastrarVeiculo(VeiculoVO novoVeiculo) {
		if (validarPlaca(novoVeiculo) && validarRenavam(novoVeiculo) && validarChassi(novoVeiculo)
				&& validarMarca(novoVeiculo) && validarModelo(novoVeiculo) && validarAno(novoVeiculo)
				&& validarCor(novoVeiculo) && validarMotor(novoVeiculo) && validarTransmissao(novoVeiculo)) {

			veiculoDAO.inserir(novoVeiculo);

			mensagem = Mensagens.VEICULO_SUCESSO;
		}

		return mensagem;
	}

	private boolean validarPlaca(VeiculoVO novoVeiculo) {
		if (novoVeiculo.getPlaca().trim().length() < 3 || novoVeiculo.getPlaca().isEmpty()) {
			mensagem = Mensagens.VEICULO_ERRO_PLACA;
			return false;

		} else if (veiculoDAO.placaJaCadastrada(novoVeiculo.getPlaca())) {
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

	public boolean atualizarVeiculo(VeiculoVO novoVeiculo) {

		return false;
	}

	public String excluirVeiculo(String placa) {
		VeiculoBO veiculoBO = new VeiculoBO();
		String mensagem = veiculoBO.excluir(placa);

		return mensagem;
	} 

	public List<VeiculoVO> listarVeiculosFiltro(VeiculoSeletor seletor) {
		VeiculoDAO dao = new VeiculoDAO();

		return dao.listarComSeletor(seletor);
	}

<<<<<<< HEAD
	public String gerarPlanilha(List<VeiculoVO> dadosConsultados, String caminho) {
		GeradorPlanilhaVeiculo gerador = new GeradorPlanilhaVeiculo();
		return gerador.gerarPlanilhaVeiculos(caminho, dadosConsultados);
=======
	public VeiculoVO pesquisarPorPlaca(String placa) {

		return veiculoDAO.pesquisarPorPlaca(placa) ;
	}

	public void excluir(String placa) {
		
>>>>>>> branch 'master' of https://github.com/Lucasp20/senac-dd-2020-2-LocadoraDeVeiculos.git
	}

}
