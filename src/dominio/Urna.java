package dominio;

import java.util.Date;

public class Urna {

	private int idUrna;
	private int idMunicipio;
	private int numJunta;
	private String presidente;
	private String secretario;
	private int cantVotosNulos;
	private String usename;
	private Date fecha;
	private String userm;
	private Date fechaM;
	
	
	
	public Urna() {
	
		// TODO Auto-generated constructor stub
	}



	public Urna(int idUrna, int idMunicipio, int numJunta, String presidente,
			String secretario, int cantVotosNulos, String usename, Date fecha,
			String userm, Date fechaM) {
		super();
		this.idUrna = idUrna;
		this.idMunicipio = idMunicipio;
		this.numJunta = numJunta;
		this.presidente = presidente;
		this.secretario = secretario;
		this.cantVotosNulos = cantVotosNulos;
		this.usename = usename;
		this.fecha = fecha;
		this.userm = userm;
		this.fechaM = fechaM;
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



	public String getUsename() {
		return usename;
	}



	public void setUsename(String usename) {
		this.usename = usename;
	}



	public Date getFecha() {
		return fecha;
	}



	public void setFecha(Date fecha) {
		this.fecha = fecha;
	}



	public String getUserm() {
		return userm;
	}



	public void setUserm(String userm) {
		this.userm = userm;
	}



	public Date getFechaM() {
		return fechaM;
	}



	public void setFechaM(Date fechaM) {
		this.fechaM = fechaM;
	}
	
	
	
	
}
