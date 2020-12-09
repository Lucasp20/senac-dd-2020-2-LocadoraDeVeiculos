package br.com.senac.model.seletores;

import java.sql.Date;
import java.time.LocalDate;

public class LocacaoSeletor {

	private int idCliente;
	private String nomeClienteFiltro;
	private LocalDate dataAluguel;
	private LocalDate dataDevolucao;
	public int getIdCliente() {
		return idCliente;
	}
	
	public LocacaoSeletor(int idCliente, String nomeClienteFiltro, LocalDate dataAluguel, LocalDate dataDevolucao) {
		super();
		this.idCliente = idCliente;
		this.nomeClienteFiltro = nomeClienteFiltro;
		this.dataAluguel = dataAluguel;
		this.dataDevolucao = dataDevolucao;
	}
	
	public LocacaoSeletor() {
		super();
		
	}
	
	public boolean temFiltro() {
		if(this.idCliente > 0) {
		}	
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
	
	
	public void setIdCliente(int idCliente) {
		this.idCliente = idCliente;
	}
	public String getNomeClienteFiltro() {
		return nomeClienteFiltro;
	}
	public void setNomeClienteFiltro(String nomeClienteFiltro) {
		this.nomeClienteFiltro = nomeClienteFiltro;
	}
	public LocalDate getDataAluguel() {
		return dataAluguel;
	}
	public void setDataAluguel(LocalDate localDate) {
		this.dataAluguel = localDate;
	}
	public LocalDate getDataDevolucao() {
		return dataDevolucao;
	}
	public void setDataDevolucao(LocalDate dataDevolucao) {
		this.dataDevolucao = dataDevolucao;
	}
	

	
}
