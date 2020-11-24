package br.com.senac.model.seletores;

public class VeiculoSeletor {

	private String marcaFiltro;
	private String anoFiltro;
	private String corFiltro;
	
	public VeiculoSeletor(String marcaFiltro, String anoFiltro, String corFiltro) {
		super();
		this.marcaFiltro = marcaFiltro;
		this.anoFiltro = anoFiltro;
		this.corFiltro = corFiltro;
	}
	
public boolean temFiltro() {
		if(this.anoFiltro != null) {
			return true;
		}
		if(this.marcaFiltro != null) {
			return true;
		}
		if(this.corFiltro != null) {
			return true;
		}
		return false;
	}
	public String getMarcaFiltro() {
		return marcaFiltro;
	}

	public void setMarcaFiltro(String marcaFiltro) {
		this.marcaFiltro = marcaFiltro;
	}

	public String getAnoFiltro() {
		return anoFiltro;
	}

	public void setAnoFiltro(String anoFiltro) {
		this.anoFiltro = anoFiltro;
	}

	public String getCorFiltro() {
		return corFiltro;
	}

	public void setCorFiltro(String corFiltro) {
		this.corFiltro = corFiltro;
	}

	public VeiculoSeletor() {
		super();
		// TODO Auto-generated constructor stub
	}

	
	
		
}
