package br.com.senac.model.bo;

import java.util.List;

import br.com.senac.controller.VeiculoController;
import br.com.senac.model.seletores.VeiculoSeletor;
import br.com.senac.model.vo.VeiculoVO;

public class VeiculoBO {

	VeiculoController veiculoController = new VeiculoController();


	public String cadastrarVeiculo(VeiculoVO novoVeiculo) {
		return veiculoController.cadastrarVeiculo(novoVeiculo);
	}

	public boolean atualizarCliente(VeiculoVO novoVeiculo) {
		return veiculoController.atualizarVeiculo(novoVeiculo);
	}
	
	public boolean excluirCliente(String veiculoExcluido) {
		return veiculoController.excluirVeiculo(veiculoExcluido);
	}
	
	public List<VeiculoVO> listarVeiculosFiltro(VeiculoSeletor seletor){
		return veiculoController.listarVeiculosFiltro(seletor);
	}
}
