package dominio;

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
@Table(name = "votacion", catalog = "tarea", schema = "") 
@NamedQueries({ 
 @NamedQuery(name = "votacion.findAll", query = "SELECT v FROM Votacion v"), 
 @NamedQuery(name = "votacion.findById", query = "SELECT v FROM Votacion v WHERE j.IdVotacion = :IdVotacion"),
 @NamedQuery(name = "votacion.findByUrna", query = "SELECT v FROM Votacion v WHERE j.IdUrna = :IdUrna"),
 @NamedQuery(name = "votacion.findByClave", query = "SELECT v FROM Votacion v WHERE v.IdVotacion = :IdVotacion and v.IdUrna = :IdUrna and v.IdPartidoPolitico=:IdPartidoPolitico")
 }) 

public class Votacion {
	
	private float idVotacion;
	private float idUrna;
	private String idPartidoPolitico;
	private float cantidadVotosValidos;
	private String username;
	
	public Votacion(){
}
	public Votacion(float idVotacion,float idUrna,String idPartidoPolitico,float cantidadVotosValidos,String username){
		this.idVotacion=idVotacion;
		this.idUrna=idUrna;
		this.idPartidoPolitico=idPartidoPolitico;
		this.cantidadVotosValidos=cantidadVotosValidos;
		this.username=username;
		
		
	}
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Basic(optional = false)
	@Column(name = "idvotacion")
	public float getIdVotacion() {
	return idVotacion;
	}
	public void setIdVotacion(float idVotacion) {
		this.idVotacion = idVotacion;
		}
	@Basic(optional = false)
	@Column(name = "idurna")
	public float getIdUrna(){
		return idUrna;
	}
		public void setIdUrna(float idUrna){
			this.idUrna=idUrna;
		
		}
		@Basic(optional = false)
		@Column(name = "idpartido")
		public String getIdPartidoPolitico(){
			return idPartidoPolitico;
		}
		public void setIdPartidoPolitico(String idPartdiPolitico){
			this.idPartidoPolitico=idPartidoPolitico;
		}
	@Basic(optional = false)
	@Column(name = "cantvotosvalidos")
	public float getCantidadVotosValidos(){
		return cantidadVotosValidos;
	}
	public void setCantidadVotosValidos(float cantidadVotosValidos){
		this.cantidadVotosValidos=cantidadVotosValidos;
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

