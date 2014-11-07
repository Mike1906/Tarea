package negocio;


import java.util.List;

import dao.JrvDAO;
import dominio.Jrv;



public class CtrlJrv {
	 private JrvDAO daoJrv = new JrvDAO() ;  
     
     public boolean crearJrv(String iddepto, String idmunicipio, String dui, String username) { 
    	 if (daoJrv.daJrvByDui(dui) == null) {
            Jrv jrv = new Jrv(iddepto, idmunicipio, dui,  username  ) ; 
              daoJrv.guardaActualiza(jrv) ; 
              return true ;}
    	 else
    		 return false;
     } 
      
     public boolean borrarJrv(Short id_jrv) { 
       if (daoJrv.daJrvById(id_jrv) != null ) { 
         Jrv jrv = daoJrv.daJrvById(id_jrv) ; 
         daoJrv.eliminar(jrv) ; 
         return true ; 
       } 
       else  
         return false ; 
        
     } 
      
     public List<Jrv> daJrv(){ 
         return daoJrv.daJrv() ; 
     } 

     /*
     public List daJrvByDepto(String id_Depto) { 
          return daoJrv.daJrvByDepto(id_Depto)  ; 
     } */
      
     public Jrv daJrvById(short id_jrv){ 
          return daoJrv.daJrvById(id_jrv) ; 
     }
}
