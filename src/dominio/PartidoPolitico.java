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
@NamedQuery(name = "PartidoPolitico.findAll", query = "SELECT p FROM PartidoPolitico p"), 
@NamedQuery(name = "PartidoPolitico.findById", query = "SELECT p FROM PartidoPolitico e WHERE p.idpartido = :idpartido"),  
@NamedQuery(name = "PartidoPolitico.findByMNombrePartido", query = "SELECT p FROM PartidoPolitico p WHERE p.nombpartido = :nombpartido")}) 

public class PartidoPolitico implements Serializable {
	private static final long serialVersionUID = 1L;
	private String idPartidoPolitico;
	private String nombrePartido;
	private Date fechaDeFundacion;
	private String nombreSecretarioGeneral;
	private String username;
	
	public PartidoPolitico(){
		
	}
public PartidoPolitico(String idPartidoPolitico,String nombrePartido,Date fechaDeFundacion,String nombreSecretarioGeneral,String username){
	this.idPartidoPolitico=idPartidoPolitico;
	this.nombrePartido=nombrePartido;
	this.fechaDeFundacion=fechaDeFundacion;
	this.nombreSecretarioGeneral=nombreSecretarioGeneral;
	this.username=username;
}
@Id
@GeneratedValue(strategy = GenerationType.IDENTITY)
@Basic(optional = false)
@Column(name = "idpartido")
public String getIdPartidoPolitico() {
return idPartidoPolitico;
}
public void setIdPartidoPolitico(String idPartidoPolitico){
	this.idPartidoPolitico=idPartidoPolitico;
}

@Basic(optional = false)
@Column(name = "nombpartido")
public String getNombrePartido(){
	return nombrePartido;
}
public void setNombrePartido(String nombrePartido){
	this.nombrePartido=nombrePartido;
}
@Basic(optional = false)
@Column(name = "fechafundac")
public Date getFechaDeFundacion(){
	return fechaDeFundacion;
}
public void setFechaDeFundacion(Date fechaDeFundacion){
	this.fechaDeFundacion=fechaDeFundacion;
}
@Basic(optional = false)
@Column(name = "nombsecretariogral")
public String getNombreSecretarioGeneral(){
	return nombreSecretarioGeneral;
}
public void setNombreSecretarioGeneral(String nombreSecretarioGeneral){
	this.nombreSecretarioGeneral=nombreSecretarioGeneral;
}
@Basic(optional = false)
@Column(name = "username")
public String getUsername(){
	return username;
}
public void setUsername(String username){
	this.username=username;
}
	
}
