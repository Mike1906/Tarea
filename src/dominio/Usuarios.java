package dominio;

import java.io.Serializable;

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
@Table(name = "usuarios", catalog = "tarea", schema = "")
@NamedQueries({
@NamedQuery(name = "Usuarios.findAll", query = "SELECT u FROM Usuarios u"),
@NamedQuery(name = "Usuarios.findByUsername", query = "SELECT u FROM Usuarios u WHERE u.username = :username")})
public class Usuarios implements Serializable{
	private static final long serialVersionUID = 1L;
	private int id;
	private String nombre;
	private String apellido;
	private String username;
	private String password;
	private int tipo;
	
	private Usuarios(){
		
	}
	
	public Usuarios(String nombre, String apellido, String username,String password, int tipo) {		
		this.nombre = nombre;
		this.apellido = apellido;
		this.username = username;
		this.password = password;
		this.tipo = tipo;
	}
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)	
	@Basic(optional = false)
	@Column(name = "id")
	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
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
	@Column(name = "apellido")
	public String getApellido() {
		return apellido;
	}

	public void setApellido(String apellido) {
		this.apellido = apellido;
	}
	@Basic(optional = false)
	@Column(name = "username")
	public String getUsername() {
		return username;
	}

	public void setUsername(String username) {
		this.username = username;
	}
	@Basic(optional = false)
	@Column(name = "password")
	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}
	@Basic(optional = false)
	@Column(name = "tipo")
	public int getTipo() {
		return tipo;
	}

	public void setTipo(int tipo) {
		this.tipo = tipo;
	} 
	
	

}
