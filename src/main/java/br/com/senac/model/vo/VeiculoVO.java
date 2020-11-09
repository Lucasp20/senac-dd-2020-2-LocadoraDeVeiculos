package br.com.senac.model.vo;

public class VeiculoVO {

	private int idVeiculo;
	private String placa;
	private String renavam;
	private String chassi;
	private String marca;
	private String modelo;
	private int ano;
	private String cor;
	private int motor;
	private String transmissao; 
	private String situacao;

	public VeiculoVO(int idVeiculo, String placa, String renavam, String chassi, String marca, String modelo, int ano,
			String cor, int motor, String transmissao, String situacao) {
		super();
		this.idVeiculo = idVeiculo;
		this.placa = placa;
		this.renavam = renavam;
		this.chassi = chassi;
		this.marca = marca;
		this.modelo = modelo;
		this.ano = ano;
		this.cor = cor;
		this.motor = motor;
		this.transmissao = transmissao;
		this.situacao = situacao;
	}
	
	public VeiculoVO() {
		super();
		
	}

	public int getIdVeiculo() {
		return idVeiculo;
	}

	public void setIdVeiculo(int idVeiculo) {
		this.idVeiculo = idVeiculo;
	}

	public String getPlaca() {
		return placa;
	}

	public void setPlaca(String placa) {
		this.placa = placa;
	}

	public String getRenavam() {
		return renavam;
	}

	public void setRenavam(String renavam) {
		this.renavam = renavam;
	}

	public String getChassi() {
		return chassi;
	}

	public void setChassi(String chassi) {
		this.chassi = chassi;
	}

	public String getMarca() {
		return marca;
	}

	public void setMarca(String marca) {
		this.marca = marca;
	}

	public String getModelo() {
		return modelo;
	}

	public void setModelo(String modelo) {
		this.modelo = modelo;
	}

	public int getAno() {
		return ano;
	}

	public void setAno(int ano) {
		this.ano = ano;
	}

	public String getCor() {
		return cor;
	}

	public void setCor(String cor) {
		this.cor = cor;
	}

	public int getMotor() {
		return motor;
	}

	public void setMotor(int motor) {
		this.motor = motor;
	}

	public String getTransmissao() {
		return transmissao;
	}

	public void setTransmissao(String transmissao) {
		this.transmissao = transmissao;
	}

	public String getSituacao() {
		return situacao;
	}

	public void setSituacao(String situacao) {
		this.situacao = situacao;
	}
	
	
	
}