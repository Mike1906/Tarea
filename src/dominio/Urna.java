package dominio;

import java.io.Serializable;
import javax.persistence.Entity;
import javax.persistence.Basic;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.Table;


@Entity
@Table(name = "urna", catalog = "tarea", schema = "")
@NamedQueries({
@NamedQuery(name = "Urna.findAll", query = "SELECT d FROM Urna d"),
@NamedQuery(name = "Urna.findByIdUrna", query = "SELECT d FROM Urna d WHERE d.idUrna = :idUrna"),
})


public class Urna implements Serializable {

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



	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Basic(optional = false)
	@Column(name = "IdUrna")
	public int getIdUrna() {
		return idUrna;
	}




	public void setIdUrna(int idUrna) {
		this.idUrna = idUrna;
	}



	@Basic(optional = false)
	@Column(name = "IdMunicipio")
	public int getIdMunicipio() {
		return idMunicipio;
	}




	public void setIdMunicipio(int idMunicipio) {
		this.idMunicipio = idMunicipio;
	}



	@Basic(optional = false)
	@Column(name = "IdDepartamento")
	public int getIdDepartamento() {
		return idDepartamento;
	}




	public void setIdDepartamento(int idDepartamento) {
		this.idDepartamento = idDepartamento;
	}



	@Basic(optional = false)
	@Column(name = "NumJunta")
	public int getNumJunta() {
		return numJunta;
	}




	public void setNumJunta(int numJunta) {
		this.numJunta = numJunta;
	}



	@Basic(optional = false)
	@Column(name = "Presidente")
	public String getPresidente() {
		return presidente;
	}




	public void setPresidente(String presidente) {
		this.presidente = presidente;
	}



	@Basic(optional = false)
	@Column(name = "Secretario")
	public String getSecretario() {
		return secretario;
	}




	public void setSecretario(String secretario) {
		this.secretario = secretario;
	}



	@Basic(optional = false)
	@Column(name = "CantVotosNulos")
	public int getCantVotosNulos() {
		return cantVotosNulos;
	}




	public void setCantVotosNulos(int cantVotosNulos) {
		this.cantVotosNulos = cantVotosNulos;
	}



	@Basic(optional = false)
	@Column(name = "CantVotosValidos")
	public int getCantVotosNoValidos() {
		return cantVotosNoValidos;
	}




	public void setCantVotosNoValidos(int cantVotosNoValidos) {
		this.cantVotosNoValidos = cantVotosNoValidos;
	}



	@Basic(optional = false)
	@Column(name = "UserName")
	public String getUserName() {
		return userName;
	}




	public void setUserName(String userName) {
		this.userName = userName;
	}




}
