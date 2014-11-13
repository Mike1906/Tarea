package dominio;

import java.io.Serializable;

import javax.persistence.Basic;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.Table;

@Entity
@Table(name = "departamento", catalog = "tarea", schema = "")
@NamedQuery(name = "Departamento.findAll", query = "SELECT d FROM Departamento d")

public class Departamento implements Serializable{
	private static final long serialVersionUID = 1L;
	private String iddepto;
	private String nombredepto;
	private String zonageografica;
	private String username;
 
	public Departamento(){}

	public Departamento(String iddepto, String nombredepto,	String zonageografica, String username) {
		this.iddepto = iddepto;
		this.nombredepto = nombredepto;
		this.zonageografica = zonageografica;
		this.username = username;
	}

	@Id		
	@Basic(optional = false)	
	@Column(name = "iddepto")
	public String getIddepto() {
		return iddepto;
	}

	public void setIddepto(String iddepto) {
		this.iddepto = iddepto;
	}

	@Basic(optional = false)
	@Column(name = "nombredepto")
	public String getNombredepto() {
		return nombredepto;
	}

	public void setNombredepto(String nombredepto) {
		this.nombredepto = nombredepto;
	}

	@Basic(optional = false)
	@Column(name = "zonageografica")
	public String getZonageografica() {
		return zonageografica;
	}

	public void setZonageografica(String zonageografica) {
		this.zonageografica = zonageografica;
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




