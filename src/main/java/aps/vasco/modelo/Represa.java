package aps.vasco.modelo;

public class Represa {
	private String nome;
	private String volume_armazenado;
	private String pluviometria_do_dia;
	private String pluviometria_acumulada_no_mes;
	private String media_historica_do_mes;
	public String getNome() {
		return nome;
	}
	public void setNome(String nome) {
		this.nome = nome;
	}
	
	public String getVolume_armazenado() {
		return volume_armazenado;
	}
	public void setVolume_armazenado(String volume_armazenado) {
		this.volume_armazenado = volume_armazenado;
	}
	public String getPluviometria_do_dia() {
		return pluviometria_do_dia;
	}
	public void setPluviometria_do_dia(String pluviometria_do_dia) {
		this.pluviometria_do_dia = pluviometria_do_dia;
	}
	public String getPluviometria_acumulada_no_mes() {
		return pluviometria_acumulada_no_mes;
	}
	public void setPluviometria_acumulada_no_mes(String pluviometria_acumulada_no_mes) {
		this.pluviometria_acumulada_no_mes = pluviometria_acumulada_no_mes;
	}
	public String getMedia_historica_do_mes() {
		return media_historica_do_mes;
	}
	public void setMedia_historica_do_mes(String media_historica_do_mes) {
		this.media_historica_do_mes = media_historica_do_mes;
	}
	
	

}
