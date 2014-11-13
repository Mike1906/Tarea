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
@Table(name = "votacion", catalog = "tarea", schema = "") 
@NamedQueries({ 
@NamedQuery(name = "Votacion.findAll", query = "SELECT v FROM Votacion v"),
@NamedQuery(name = "Votacion.findById", query = "SELECT v FROM Votacion v.idvotacion = :idvotacion")
}) 
public class Votacion implements Serializable{
	private static final long serialVersionUID = 1L;
	public String idvotacion;
	public int idurna;
	public String idpartido;
	public int cantvotosvalidos;
	public String username;
	
	public Votacion(){
		
	}
	
	public Votacion(String idvotacion, int idurna, String idpartido, int cantvotosvalidos, String username) {		
		this.idvotacion = idvotacion;
		this.idurna = idurna;
		this.idpartido = idpartido;
		this.cantvotosvalidos = cantvotosvalidos;
		this.username = username;
	}

	@Id		
	@Basic(optional = false)	
	@Column(name = "idvotacion")
	public String getIdvotacion() {
		return idvotacion;
	}

	public void setIdvotacion(String idvotacion) {
		this.idvotacion = idvotacion;
	}

	@Basic(optional = false)
	@Column(name = "idurna")
	public int getIdurna() {
		return idurna;
	}

	public void setIdurna(int idurna) {
		this.idurna = idurna;
	}

	@Basic(optional = false)
	@Column(name = "idpartido")
	public String getIdpartido() {
		return idpartido;
	}

	public void setIdpartido(String idpartido) {
		this.idpartido = idpartido;
	}

	@Basic(optional = false)
	@Column(name = "cantvotosvalidos")
	public int getCantvotosvalidos() {
		return cantvotosvalidos;
	}

	public void setCantvotosvalidos(int cantvotosvalidos) {
		this.cantvotosvalidos = cantvotosvalidos;
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

