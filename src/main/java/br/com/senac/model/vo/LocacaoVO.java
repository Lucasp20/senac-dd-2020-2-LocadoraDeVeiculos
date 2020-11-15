package br.com.senac.model.vo;

import java.time.LocalDate;

public class LocacaoVO {

	private int idLocacao;
	private LocalDate dataLocacao;
	private int kmLocacao;
	private LocalDate dataEntrega;
	private int kmEntrega;
	private ClienteVO cliente;
	private VeiculoVO veiculo;

	public LocacaoVO(int idLocacao, LocalDate dataLocacao, int kmLocacao, LocalDate dataEntrega, int kmEntrega,
			ClienteVO cliente, VeiculoVO veiculo) {
		super();
		this.idLocacao = idLocacao;
		this.dataLocacao = dataLocacao;
		this.kmLocacao = kmLocacao;
		this.dataEntrega = dataEntrega;
		this.kmEntrega = kmEntrega;
		this.cliente = cliente;
		this.veiculo = veiculo;
	}
	
	public LocacaoVO() {
		super();
		
	}

	public int getIdLocacao() {
		return idLocacao;
	}

	public void setIdLocacao(int idLocacao) {
		this.idLocacao = idLocacao;
	}

	public LocalDate getDataLocacao() {
		return dataLocacao;
	}

	public void setDataLocacao(LocalDate dataLocacao) {
		this.dataLocacao = dataLocacao;
	}

	public int getKmLocacao() {
		return kmLocacao;
	}

	public void setKmLocacao(int kmLocacao) {
		this.kmLocacao = kmLocacao;
	}

	public LocalDate getDataEntrega() {
		return dataEntrega;
	}

	public void setDataEntrega(LocalDate dataEntrega) {
		this.dataEntrega = dataEntrega;
	}

	public int getKmEntrega() {
		return kmEntrega;
	}

	public void setKmEntrega(int kmEntrega) {
		this.kmEntrega = kmEntrega;
	}

	public ClienteVO getCliente() {
		return cliente;
	}

	public void setCliente(ClienteVO cliente) {
		this.cliente = cliente;
	}

	public VeiculoVO getVeiculo() {
		return veiculo;
	}

	public void setVeiculo(VeiculoVO veiculo) {
		this.veiculo = veiculo;
	}
	
	
}