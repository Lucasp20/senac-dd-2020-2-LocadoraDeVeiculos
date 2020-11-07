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
	
}