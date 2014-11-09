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
import javax.persistence.NamedQuery;
import javax.persistence.Table;

@Entity
@Table(name = "tipomiembro", catalog = "tarea", schema = "")
@NamedQueries({
@NamedQuery(name = "TipoMiembro.findAll", query = "SELECT t FROM TipoMiembro t"),
@NamedQuery(name = "TipoMiembro.findByDesc", query = "SELECT t FROM TipoMiembro t WHERE t.descripcion = :descripcion")})
public class TipoMiembro implements Serializable{
	private static final long serialVersionUID = 1L;
	private String idtipomiembro;
	private String descripcion;
	private String username;
		
	
	public TipoMiembro(){
		
	}
	public TipoMiembro(String idtipomiembro, String descripcion, String username) {
		this.idtipomiembro = idtipomiembro;
		this.descripcion = descripcion;
		this.username = username;
	}
	
	@Id		
	@Basic(optional = false)	
	@Column(name = "idtipomiembro")
	public String getIdtipomiembro() {
		return idtipomiembro;
	}
	public void setIdtipomiembro(String idtipomiembro) {
		this.idtipomiembro = idtipomiembro;
	}
	
	@Basic(optional = false)
	@Column(name = "descripcion")
	public String getDescripcion() {
		return descripcion;
	}
	public void setDescripcion(String descripcion) {
		this.descripcion = descripcion;
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
