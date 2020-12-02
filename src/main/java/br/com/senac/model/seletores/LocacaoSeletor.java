package br.com.senac.model.seletores;

import java.sql.Date;

public class LocacaoSeletor {

	private String nomeClienteFiltro;
	private Date dataAluguel;
	private Date dataDevolucao;
	
	public LocacaoSeletor(String nomeClienteFiltro, Date dataAluguel, Date dataDevolucao) {
		super();
		this.nomeClienteFiltro = nomeClienteFiltro;
		this.dataAluguel = dataAluguel;
		this.dataDevolucao = dataDevolucao;
	}
	
	public LocacaoSeletor() {
		super();
	
	}
	public boolean temFiltro() {
		if((this.nomeClienteFiltro != null) && (this.nomeClienteFiltro.trim().length() > 0)) {
			return true;
		}
		if(this.dataAluguel != null) {
			return true;
		}
		if(this.dataDevolucao != null) {
			return true;
		}
		return false;
	}


	public String getNomeClienteFiltro() {
		return nomeClienteFiltro;
	}

	public void setNomeClienteFiltro(String nomeClienteFiltro) {
		this.nomeClienteFiltro = nomeClienteFiltro;
	}

	public Date getDataAluguel() {
		return dataAluguel;
	}

	public void setDataAluguel(Date dataAluguel) {
		this.dataAluguel = dataAluguel;
	}

	public Date getDataDevolucao() {
		return dataDevolucao;
	}

	public void setDataDevolucao(Date dataDevolucao) {
		this.dataDevolucao = dataDevolucao;
	}
	
	
}
