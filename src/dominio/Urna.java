package dominio;

import java.util.Date;

public class Urna {

	private int idUrna;
	private int idMunicipio;
	private int idDepartamento;
	private int numJunta;
	private String presidente;
	private String secretario;
	private int cantVotosNulos;
	private int cantVotosNoValidos;
	private String userName;




	public Urna() {

		// TODO Auto-generated constructor stub
	}




	public Urna(int idUrna, int idMunicipio, int idDepartamento, int numJunta,
			String presidente, String secretario, int cantVotosNulos,
			int cantVotosNoValidos, String userName) {
		super();
		this.idUrna = idUrna;
		this.idMunicipio = idMunicipio;
		this.idDepartamento = idDepartamento;
		this.numJunta = numJunta;
		this.presidente = presidente;
		this.secretario = secretario;
		this.cantVotosNulos = cantVotosNulos;
		this.cantVotosNoValidos = cantVotosNoValidos;
		this.userName = userName;
	}




	public int getIdUrna() {
		return idUrna;
	}




	public void setIdUrna(int idUrna) {
		this.idUrna = idUrna;
	}




	public int getIdMunicipio() {
		return idMunicipio;
	}




	public void setIdMunicipio(int idMunicipio) {
		this.idMunicipio = idMunicipio;
	}




	public int getIdDepartamento() {
		return idDepartamento;
	}




	public void setIdDepartamento(int idDepartamento) {
		this.idDepartamento = idDepartamento;
	}




	public int getNumJunta() {
		return numJunta;
	}




	public void setNumJunta(int numJunta) {
		this.numJunta = numJunta;
	}




	public String getPresidente() {
		return presidente;
	}




	public void setPresidente(String presidente) {
		this.presidente = presidente;
	}




	public String getSecretario() {
		return secretario;
	}




	public void setSecretario(String secretario) {
		this.secretario = secretario;
	}




	public int getCantVotosNulos() {
		return cantVotosNulos;
	}




	public void setCantVotosNulos(int cantVotosNulos) {
		this.cantVotosNulos = cantVotosNulos;
	}




	public int getCantVotosNoValidos() {
		return cantVotosNoValidos;
	}




	public void setCantVotosNoValidos(int cantVotosNoValidos) {
		this.cantVotosNoValidos = cantVotosNoValidos;
	}




	public String getUserName() {
		return userName;
	}




	public void setUserName(String userName) {
		this.userName = userName;
	}




}
