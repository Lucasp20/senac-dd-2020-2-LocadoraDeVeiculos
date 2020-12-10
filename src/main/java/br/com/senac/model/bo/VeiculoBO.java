package br.com.senac.model.bo;

import java.util.List;

import br.com.senac.controller.VeiculoController;
import br.com.senac.model.dao.VeiculoDAO;
import br.com.senac.model.seletores.VeiculoSeletor;
import br.com.senac.model.vo.VeiculoVO;

public class VeiculoBO {

	VeiculoDAO dao = new VeiculoDAO();

	String mensagem = "";
	
	public String excluir(String placa) {
		//TODO verificar se o veiculo pode ser excluido(sem locacao)
	
		boolean excluiu = dao.excluir(placa);

		if (excluiu) {
			mensagem = "Veículo excluido com sucesso!";
		} else {
			mensagem = "Erro ao excluir Veículo";
		}

		return mensagem;
	}

}
