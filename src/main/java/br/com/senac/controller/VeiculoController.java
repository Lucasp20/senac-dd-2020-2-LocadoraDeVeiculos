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
	VeiculoBO veiculoBO = new VeiculoBO();

	public String cadastrarVeiculo(VeiculoVO novoVeiculo) {
		return veiculoBO.cadastrarVeiculo(novoVeiculo);
	}

	public String excluirVeiculo(String placa) {
		VeiculoBO veiculoBO = new VeiculoBO();
		String mensagem = veiculoBO.excluir(placa);

		return mensagem;
	}
	
	public boolean atualizarVeiculo(VeiculoVO novoVeiculo) {
		return false;
	}


	public List<VeiculoVO> listarVeiculosFiltro(VeiculoSeletor seletor) {
		VeiculoDAO dao = new VeiculoDAO();
		return dao.listarComSeletor(seletor);
	}

	public String gerarPlanilha(List<VeiculoVO> dadosConsultados, String caminho) {
		GeradorPlanilhaVeiculo gerador = new GeradorPlanilhaVeiculo();

		return gerador.gerarPlanilhaVeiculos(caminho, dadosConsultados);
	}

	public VeiculoVO pesquisarPorPlaca(String placa) {
		return veiculoDAO.pesquisarPorPlaca(placa);
	}

	public void excluir(String placa) {

	}

}
