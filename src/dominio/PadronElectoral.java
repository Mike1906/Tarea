package dominio;

import java.io.Serializable;
import java.util.Date;

import javax.persistence.Basic;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.Table;

@Entity 
@Table(name = "padronelectoral", catalog = "tarea", schema = "") 
@NamedQueries({ 
 @NamedQuery(name = "PadronElectoral.findAll", query = "SELECT p FROM PadronElectoral p"), 
 @NamedQuery(name = "PadronElectoral.findByDui", query = "SELECT p FROM PadronElectoral p WHERE p.dui = :dui")
 }) 
public class PadronElectoral implements Serializable{
	private static final long serialVersionUID = 1L;
	private String dui;
	private String nombre;
	private String apellidos;
	private Date fechanac;
	private String domicilio;
	private String estadovotacion;
	//private int idurna;
	private Urna urna;
	private String username;
	
	public PadronElectoral(){
		
	}

	

	public PadronElectoral(String dui, String nombre, String apellidos,String domicilio, String estadovotacion, Urna urna,String username, Date fechanac) {
		super();
		this.dui = dui;
		this.nombre = nombre;
		this.apellidos = apellidos;
		this.domicilio = domicilio;
		this.estadovotacion = estadovotacion;
		this.urna = urna;
		this.username = username;
		this.fechanac = fechanac;
	}



	@Id 
	@Basic(optional = false) 
	@Column(name = "dui") 
	public String getDui() {
		return dui;
	}

	public void setDui(String dui) {
		this.dui = dui;
	}

	@Basic(optional = false) 
	@Column(name = "nombre") 
	public String getNombre() {
		return nombre;
	}

	public void setNombre(String nombre) {
		this.nombre = nombre;
	}

	@Basic(optional = false) 
	@Column(name = "apellidos") 
	public String getApellidos() {
		return apellidos;
	}

	public void setApellidos(String apellidos) {
		this.apellidos = apellidos;
	}

	@Basic(optional = false) 
	@Column(name = "fechanac") 
	public Date getFechanac() {
		return fechanac;
	}

	public void setFechanac(Date fechanac) {
		this.fechanac = fechanac;
	}

	@Basic(optional = false) 
	@Column(name = "domicilio") 
	public String getDomicilio() {
		return domicilio;
	}

	public void setDomicilio(String domicilio) {
		this.domicilio = domicilio;
	}

	@Basic(optional = false) 
	@Column(name = "estadovotacion") 
	public String getEstadovotacion() {
		return estadovotacion;
	}

	public void setEstadovotacion(String estadovotacion) {
		this.estadovotacion = estadovotacion;
	}

	@Basic(optional = false) 
	@Column(name = "username") 
	public String getUsername() {
		return username;
	}

	public void setUsername(String username) {
		this.username = username;
	}


	@JoinColumn(name = "idurna", referencedColumnName = "idurna") 
	@ManyToOne(optional = false)
	public Urna getUrna() {
		return urna;
	}



	public void setUrna(Urna urna) {
		this.urna = urna;
	}

	

	

	
	
	
}
