package negocio;

import java.util.Date;
import java.util.List;
import dao.VotacionDAO;
import dominio.Votacion;


public class CtrlVotacion {
	private VotacionDAO daoVotacion = new VotacionDAO() ;
	
	public boolean crearVotacion(float idVotacion,float idUrna, String idPartidoPolitico,float cantidadVotosValidos, String username) { 
   	 if (daoVotacion.daVotacionByClave(idVotacion,idUrna,idPartidoPolitico) == null) {
           Votacion votacion = new Votacion(idVotacion, idUrna, idPartidoPolitico,cantidadVotosValidos,username ) ; 
             daoVotacion.guardaActualiza(votacion) ; 
             return true ;}
   	 else
   		 return false;
    } 
     
    public boolean borrarVotacion(float idVotacion) { 
      if (daoVotacion.daVotacionById(idVotacion) != null ) { 
        Votacion votacion = daoVotacion.daVotacionById(idVotacion) ; 
        daoVotacion.eliminar(votacion) ; 
        return true ; 
      } 
      else  
        return false ; 
       
    } 
     
    public boolean actualizaVotacion(float idVotacion,float idUrna, String idPartidoPolitico, float cantidadVotosValidos,String username) { 
   	 if (daoVotacion.daVotacionByClave(idVotacion,idUrna,idPartidoPolitico) != null) {
           Votacion votacion = new Votacion() ; 
           votacion.setIdVotacion(idVotacion);
           votacion.setIdUrna(idUrna);
           votacion.setIdPartidoPolitico(idPartidoPolitico);
           votacion.setCantidadVotosValidos(cantidadVotosValidos);
           votacion.setUsername(username);
             daoVotacion.guardaActualiza(votacion) ; 
             return true ;}
   	 else
   		 return false;
    } 
    public List<Votacion> daVotacion(){ 
        return daoVotacion.daVotacion() ; 
    } 




}
