package dominio;

import javax.persistence.Basic;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.Table;

@Entity
@Table(name = "departamento", catalog = "tarea", schema = "")
@NamedQueries({
@NamedQuery(name = "Departamento.findAll", query = "SELECT m FROM Departamento m"),
@NamedQuery(name = "Departamento.findByNombres", query = "SELECT m FROM Departamento m WHERE m.nombres = :nombres")})

public class Departamento {
  private String iddepto;
 private String nombdepto;
 private String zonageografica;
 private String username;
 
 private Departamento(){}
 
 public Departamento(String nombdepto, String iddepto, String zonageografica,String username){		
		this.nombdepto = nombdepto;
		this.iddepto = idepto;
		this.zonageografica = zonageografica;
		this.username = username;
	}
	
	@Id		
	@Basic(optional = false)	
	@Column(name = "nombdepto")
	public String getnombdepto() {
		return nombdepto;
	}

	public void setnombdepto(String nombdepto) {
		this.nombdepto = nombdepto;
	}
	@Basic(optional = false)	
	@Column(name = "iddepto")
	public String getiddepto() {
		return iddepto;
	}

	public void setiddepto(String iddepto) {
		this.iddepto = iddepto;
	}
	@Basic(optional = false)	
	@Column(name = "zonageografica")
	public String getzonageografica() {
		return zonageografica;
	}

	public void setzonageografica(String zonageografica) {
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




