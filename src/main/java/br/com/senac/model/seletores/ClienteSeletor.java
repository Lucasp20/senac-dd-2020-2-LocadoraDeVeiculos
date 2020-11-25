package br.com.senac.model.seletores;

public class ClienteSeletor {

	private String nomeFiltro;
	private String cidadeFiltro;
	private String estadoFiltro;
	public ClienteSeletor(String nomeFiltro, String cidadeFiltro, String estadoFiltro) {
		super();
		this.nomeFiltro = nomeFiltro;
		this.cidadeFiltro = cidadeFiltro;
		this.estadoFiltro = estadoFiltro;
	}
	
	
	public ClienteSeletor() {
		super();
		// TODO Auto-generated constructor stub
	}

	
	public boolean temFiltro() {
		if(this.cidadeFiltro != null) {
			return true;
		}
		if(this.nomeFiltro != null) {
			return true;
		}
		if(this.estadoFiltro != null) {
			return true;
		}
		return false;
	}
	
	
	
	

	public String getNomeFiltro() {
		return nomeFiltro;
	}
	public void setNomeFiltro(String nomeFiltro) {
		this.nomeFiltro = nomeFiltro;
	}
	public String getCidadeFiltro() {
		return cidadeFiltro;
	}
	public void setCidadeFiltro(String cidadeFiltro) {
		this.cidadeFiltro = cidadeFiltro;
	}
	public String getEstadoFiltro() {
		return estadoFiltro;
	}
	public void setEstadoFiltro(String estadoFiltro) {
		this.estadoFiltro = estadoFiltro;
	}
	
		
	
}