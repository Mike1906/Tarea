package dominio;

import javax.persistence.Basic;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.Table;

@Entity
@Table(name = "miembrojrv", catalog = "tarea", schema = "")
@NamedQueries({
@NamedQuery(name = "Miembrojrv.findAll", query = "SELECT m FROM Miembrojrv m"),
@NamedQuery(name = "Miembrojrv.findByNombres", query = "SELECT m FROM Miembrojrv m WHERE m.nombres = :nombres")})

public class Miembrojrv {
	private String idmiembrojrv;
	private String nombres;
	private String apellidop;
	private String apellidom;
	private int idjrv;
	private String idtipomiembro;
	private String username;
	
	private Miembrojrv(){		
	}

	public Miembrojrv(String idmiembrojrv, String nombres, String apellidop,String apellidom, int idjrv, String idtipomiembro, String username) {		
		this.idmiembrojrv = idmiembrojrv;
		this.nombres = nombres;
		this.apellidop = apellidop;
		this.apellidom = apellidom;
		this.idjrv = idjrv;
		this.idtipomiembro = idtipomiembro;
		this.username = username;
	}
	
	@Id		
	@Basic(optional = false)	
	@Column(name = "idmiembrojrv")
	public String getIdmiembrojrv() {
		return idmiembrojrv;
	}

	public void setIdmiembrojrv(String idmiembrojrv) {
		this.idmiembrojrv = idmiembrojrv;
	}
	@Basic(optional = false)	
	@Column(name = "nombres")
	public String getNombres() {
		return nombres;
	}

	public void setNombres(String nombres) {
		this.nombres = nombres;
	}
	@Basic(optional = false)	
	@Column(name = "apellidop")
	public String getApellidop() {
		return apellidop;
	}

	public void setApellidop(String apellidop) {
		this.apellidop = apellidop;
	}
	@Basic(optional = false)	
	@Column(name = "apellidom")
	public String getApellidom() {
		return apellidom;
	}

	public void setApellidom(String apellidom) {
		this.apellidom = apellidom;
	}
	@Basic(optional = false)	
	@Column(name = "idjrv")
	public int getIdjrv() {
		return idjrv;
	}

	public void setIdjrv(int idjrv) {
		this.idjrv = idjrv;
	}
	@Basic(optional = false)	
	@Column(name = "idtipomiembro")
	public String getIdtipomiembro() {
		return idtipomiembro;
	}

	public void setIdtipomiembro(String idtipomiembro) {
		this.idtipomiembro = idtipomiembro;
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
