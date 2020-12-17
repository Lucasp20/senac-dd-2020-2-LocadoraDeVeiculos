package br.com.senac.controller;

import java.sql.SQLException;
import java.util.List;

import br.com.senac.constante.Mensagens;
import br.com.senac.model.bo.LocacaoBO;
import br.com.senac.model.dao.LocacaoDAO;
import br.com.senac.model.dao.VeiculoDAO;
import br.com.senac.model.seletores.LocacaoSeletor;
import br.com.senac.model.seletores.VeiculoSeletor;
import br.com.senac.model.util.GeradorPlanilhaLocacao;
import br.com.senac.model.util.GeradorPlanilhaVeiculo;
import br.com.senac.model.vo.LocacaoVO;
import br.com.senac.model.vo.VeiculoVO;

public class LocacaoController {
	/*
	 * 
	 * Locacao deve possuir data de entrega posterior a data de retirada Veiculo não
	 * pode ser alugado por duas pessoas ao mesmo tempo Km de entrega deve ser maior
	 * que km de de retirada
	 * 
	 */
	private LocacaoDAO locacaoDAO = new LocacaoDAO();
	LocacaoBO locacaoBO = new LocacaoBO();
	
	public String cadastrarLocacao(LocacaoVO novaLocacao) {
		return locacaoBO.cadastrarLocacao(novaLocacao);
	}
	
	public List<LocacaoVO> listarLocacaoFiltro(LocacaoSeletor seletor) {
		LocacaoDAO dao = new LocacaoDAO();
		
		return dao.listarComSeletor(seletor);
	}

	public String gerarPlanilha(List<LocacaoVO> dadosConsultados, String caminho) {
		GeradorPlanilhaLocacao gerador = new GeradorPlanilhaLocacao();
		return gerador.gerarPlanilhaLocacao(caminho, dadosConsultados);
	}
}
