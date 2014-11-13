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
@NamedQuery(name = "Urna.findAll", query = "SELECT u FROM Urna u")

public class Urna  implements Serializable {
	private static final long serialVersionUID = 1L;
	private int idurna;  
	private String idmunicipio;  
	private String iddepto;  
	private int numjunta;  
	private String presidente;  
	private String secretario;  
	private int cantvotosnulos;  
	private String cantvotosnovalid;  
	private String username;
	
	public Urna() {		
	}

	public Urna(int idurna, String idmunicipio, String iddepto, int numjunta,String presidente, String secretario, int cantvotosnulos, String cantvotosnovalid, String username) {
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
	public String getIdmunicipio() {
		return idmunicipio;
	}

	public void setIdmunicipio(String idmunicipio) {
		this.idmunicipio = idmunicipio;
	}

	@Basic(optional = false) 
	@Column(name = "iddepto")
	public String getIddepto() {
		return iddepto;
	}

	public void setIddepto(String iddepto) {
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
	public String getCantvotosnovalid() {
		return cantvotosnovalid;
	}

	public void setCantvotosnovalid(String cantvotosnovalid) {
		this.cantvotosnovalid = cantvotosnovalid;
	}

	@Basic(optional = false) 
	@Column(name = "username")
	public String getUsername() {
		return username;
	}

	public void setUsername(String username) {
		this.username = username;
	}
	
			
}