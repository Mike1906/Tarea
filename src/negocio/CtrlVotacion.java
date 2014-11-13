package negocio;

import java.util.List;
import dao.VotacionDAO;
import dominio.Votacion;


public class CtrlVotacion {
	private VotacionDAO daoVotacion = new VotacionDAO() ;
	
	public boolean crearVotacion(String idvotacion, int idurna, String idpartido, int cantvotosvalidos, String username) { 
   	 if (daoVotacion.daVotacionById(idvotacion) == null) {
           Votacion votacion = new Votacion(idvotacion,idurna,idpartido,cantvotosvalidos,username) ; 
             daoVotacion.guardaActualiza(votacion) ; 
             return true ;}
   	 else
   		 return false;
    } 
     
    public boolean borrarVotacion(String idvotacion) { 
      if (daoVotacion.daVotacionById(idvotacion) != null ) { 
        Votacion votacion = daoVotacion.daVotacionById(idvotacion) ; 
        daoVotacion.eliminar(votacion) ; 
        return true ; 
      } 
      else  
        return false ; 
       
    } 
    public boolean actualizarVotacion(String idvotacion,int idurna, String idpartido, int cantvotosvalidos  ,String username) { 
    	 if (daoVotacion.daVotacionById(idvotacion)!= null) {
            Votacion v = new Votacion() ; 
            v.setIdvotacion(idvotacion);
            v.setIdurna(idurna);
            v.setIdpartido(idpartido);
            v.setCantvotosvalidos(cantvotosvalidos);
            v.setUsername(username);
              daoVotacion.guardaActualiza(v) ; 
              return true ;}
    	 else
    		 return false;
     } 
    
    public List<Votacion> daVotacion(){ 
        return daoVotacion.daVotacion() ; 
    } 


}
