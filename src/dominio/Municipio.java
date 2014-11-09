package dominio;
import javax.persistence.Basic;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.Table;

@Entity
@Table(name = "municipio", catalog = "tarea", schema = "")
@NamedQueries({
@NamedQuery(name = "Municipio.findAll", query = "SELECT m FROM Municipio m"),
@NamedQuery(name = "Municipio.findByNombres", query = "SELECT m FROM Municipio m WHERE m.nombres = :nombres")})

public class Municipio {
 private String idmunicipio;
 private String iddepto;
 private String nombmunicipio;
 private String username;
	
 private Municipio(){}
 
 public Municipio(String idmunicipio, String iddepto, String nombmunicipio,String username){		
		this.idmunicipio = idmunicipio;
		this.iddepto = idepto;
		this.nombmunicipio = nombmunicipio;
		this.username = username;
	}
	
	@Id		
	@Basic(optional = false)	
	@Column(name = "idmunicipio")
	public String getidmunicipio() {
		return idmunicipio;
	}

	public void setidmunicipio(String idmunicipio) {
		this.idmunicipio = idmunicipio;
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
	@Column(name = "nombmunicipio")
	public String getnombmunicipio() {
		return nombmunicipio;
	}

	public void setnombmunicipio(String nombmunicipio) {
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

 
 
 
 
 
	

