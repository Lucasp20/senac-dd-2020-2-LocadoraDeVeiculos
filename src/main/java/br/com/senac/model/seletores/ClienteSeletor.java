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
	
	}

	
	public boolean temFiltro() {
		if((this.cidadeFiltro != null) && (this.cidadeFiltro.trim().length() > 0)) {
			return true;
		}
		if((this.nomeFiltro != null) && (this.nomeFiltro.trim().length() > 0)) {
			return true;
		}
		if((this.estadoFiltro != null) && (this.estadoFiltro.trim().length() > 0)) {
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
