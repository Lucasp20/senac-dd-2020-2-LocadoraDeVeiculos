package br.com.senac.controller;

import br.com.senac.model.bo.VeiculoBO;
import br.com.senac.model.vo.VeiculoVO;

public class VeiculoController {

	
	
	/*
	 * 
	 * 1 - Veiculo Deve possuir Renavam válido 11 caracteres numericos
	 * 2 - Veiculo possuir marca, modelo e cor
	 * 3- Veiculo possuir placa válida 3 letras 4 numeros
	 * 
	 * 
	 */
	private VeiculoBO bo = new VeiculoBO();
	
	public String salvar(VeiculoVO novoVeiculo) {
		String situacao;
		situacao = "AQUI VÃO SER TRABALHADOS OS CONTROLLERS - apenas testandooo";
		return situacao;
		
	}
}
