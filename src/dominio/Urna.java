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
@NamedQuery(name = "Urna.findAll", query = "SELECT u FROM Urna u"),
@NamedQuery(name = "Urna.findByIdUrna", query = "SELECT u FROM Urna u WHERE d.idUrna = :idUrna"),
})


public class Urna implements Serializable {

	private int idurna;  
	private int idmunicipio;  
	private int iddepto;  
	private int numjunta;  
	private String presidente;  
	private String secretario;  
	private int cantvotosnulos;  
	private int cantvotosnovalid;  
	private int username;
	public Urna() {
		super();
		// TODO Auto-generated constructor stub
	}
	public Urna(int idurna, int idmunicipio, int iddepto, int numjunta,
			String presidente, String secretario, int cantvotosnulos,
			int cantvotosnovalid, int username) {
		super();
		this.idurna = idurna;
		this.idmunicipio = idmunicipio;
		this.iddepto = iddepto;
		this.numjunta = numjunta;
		this.presidente = presidente;
		this.secretario = secretario;
		this.cantvotosnulos = cantvotosnulos;
		this.cantvotosnovalid = cantvotosnovalid;
		this.username = username;
	}
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Basic(optional = false)
	@Column(name = "idurna")
	public int getIdurna() {
		return idurna;
	}
	
	
	public void setIdurna(int idurna) {
		this.idurna = idurna;
	}
	
	@Basic(optional = false)
	@Column(name = "idmunicipio")
	public int getIdmunicipio() {
		return idmunicipio;
	}
	
	public void setIdmunicipio(int idmunicipio) {
		this.idmunicipio = idmunicipio;
	}
	
	@Basic(optional = false)
	@Column(name = "iddepto")
	public int getIddepto() {
		return iddepto;
	}
	
	public void setIddepto(int iddepto) {
		this.iddepto = iddepto;
	}
	
	
	@Basic(optional = false)
	@Column(name = "numjunta")
	public int getNumjunta() {
		return numjunta;
	}
	
	public void setNumjunta(int numjunta) {
		this.numjunta = numjunta;
	}
	
	
	@Basic(optional = false)
	@Column(name = "presidente")
	public String getPresidente() {
		return presidente;
	}
	
	public void setPresidente(String presidente) {
		this.presidente = presidente;
	}
	
	
	@Basic(optional = false)
	@Column(name = "secretario")
	public String getSecretario() {
		return secretario;
	}
	
	public void setSecretario(String secretario) {
		this.secretario = secretario;
	}
	
	
	@Basic(optional = false)
	@Column(name = "cantvotosnulos")
	public int getCantvotosnulos() {
		return cantvotosnulos;
	}
	
	public void setCantvotosnulos(int cantvotosnulos) {
		this.cantvotosnulos = cantvotosnulos;
	}
	
	
	@Basic(optional = false)
	@Column(name = "cantvotosnovalid")
	public int getCantvotosnovalid() {
		return cantvotosnovalid;
	}
	
	public void setCantvotosnovalid(int cantvotosnovalid) {
		this.cantvotosnovalid = cantvotosnovalid;
	}
	
	@Basic(optional = false)
	@Column(name = "username")
	public int getUsername() {
		return username;
	}
	
	public void setUsername(int username) {
		this.username = username;
	}  
	
		
}