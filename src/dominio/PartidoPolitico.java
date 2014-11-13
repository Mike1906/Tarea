package dominio;

import java.io.Serializable;
import java.util.Date;
import javax.persistence.Basic;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.NamedQueries;
import javax.persistence.Table;
import javax.persistence.NamedQuery;
@Entity 
@Table(name = "partidopolitico", catalog = "tarea", schema = "") 
@NamedQueries({ 
@NamedQuery(name = "PartidoPolitico.findAll", query = "SELECT p FROM PartidoPolitico p") 
@NamedQuery(name = "PartidoPolitico.findById", query = "SELECT p FROM PartidoPolitico p") 
})
public class PartidoPolitico implements Serializable {
	private static final long serialVersionUID = 1L;
	private String idpartido;
	private String nombpartido;
	private Date fechafundac;
	private String nombsecretariogral;
	private String username;
	
	public PartidoPolitico(){		
	}

	public PartidoPolitico(String idpartido, String nombpartido,Date fechafundac, String nombsecretariogral, String username) {
		this.idpartido = idpartido;
		this.nombpartido = nombpartido;
		this.fechafundac = fechafundac;
		this.nombsecretariogral = nombsecretariogral;
		this.username = username;
	}

	@Id		
	@Basic(optional = false)	
	@Column(name = "idpartido")
	public String getIdpartido() {
		return idpartido;
	}

	public void setIdpartido(String idpartido) {
		this.idpartido = idpartido;
	}
	
	@Basic(optional = false)
	@Column(name = "nombpartido")
	public String getNombpartido() {
		return nombpartido;
	}

	public void setNombpartido(String nombpartido) {
		this.nombpartido = nombpartido;
	}

	@Basic(optional = false)
	@Column(name = "fechafundac")
	public Date getFechafundac() {
		return fechafundac;
	}

	public void setFechafundac(Date fechafundac) {
		this.fechafundac = fechafundac;
	}

	@Basic(optional = false)
	@Column(name = "nombsecretariogral")
	public String getNombsecretariogral() {
		return nombsecretariogral;
	}

	public void setNombsecretariogral(String nombsecretariogral) {
		this.nombsecretariogral = nombsecretariogral;
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
