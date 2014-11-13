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
@Table(name = "municipio", catalog = "tarea", schema = "")
@NamedQuery(name = "Municipio.findAll", query = "SELECT m FROM Municipio m")

public class Municipio implements Serializable{
     private static final long serialVersionUID = 1L;
	 private String idmunicipio;
	 private String iddepto;
	 private String nombmunicipio;
	 private String username;
	
	 public Municipio(){}
	
	 public Municipio(String idmunicipio, String iddepto, String nombmunicipio,String username) {
		this.idmunicipio = idmunicipio;
		this.iddepto = iddepto;
		this.nombmunicipio = nombmunicipio;
		this.username = username;
	}
	
	@Id		
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
	@Column(name = "nombmunicipio")
	public String getNombmunicipio() {
		return nombmunicipio;
	}
	
	public void setNombmunicipio(String nombmunicipio) {
		this.nombmunicipio = nombmunicipio;
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

 
 
 
 
 
	

