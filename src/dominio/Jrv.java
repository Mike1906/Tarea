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
import javax.persistence.Table;
import javax.persistence.NamedQuery;



@Entity 
@Table(name = "jrv", catalog = "tarea", schema = "") 
@NamedQueries({ 
 @NamedQuery(name = "jrv.findAll", query = "SELECT j FROM Jrv j"), 
 @NamedQuery(name = "jrv.findById", query = "SELECT j FROM Jrv j WHERE j.idjrv = :idjrv"),
 @NamedQuery(name = "jrv.findByDui", query = "SELECT j FROM Jrv j WHERE j.dui = :dui")
 }) 
public class Jrv implements Serializable{
	private static final long serialVersionUID = 1L;
 private Short idjrv;
 private String iddepto;
 private String idmunicipio;
 private String dui;
 private String username;

 
 public Jrv(){
	 
 }

public Jrv(String iddepto, String idmunicipio, String dui,
		String username) {
	super();
	this.iddepto = iddepto;
	this.idmunicipio = idmunicipio;
	this.dui = dui;
	this.username = username;
}





@Id 
@GeneratedValue(strategy = GenerationType.IDENTITY) 
@Basic(optional = false) 
@Column(name = "idjrv") 
public Short getIdjrv() {
	return idjrv;
}


public void setIdjrv(Short idjrv) {
	this.idjrv = idjrv;
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
@Column(name = "idmunicipio")
public String getIdmunicipio() {
	return idmunicipio;
}


public void setIdmunicipio(String idmunicipio) {
	this.idmunicipio = idmunicipio;
}

@Basic(optional = false) 
@Column(name = "dui")
public String getDui() {
	return dui;
}


public void setDui(String dui) {
	this.dui = dui;
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
