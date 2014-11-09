package negocio;

import java.math.BigDecimal;
import java.util.Date;
import java.util.List;

import dao.PadronElectoralDAO;
import dominio.Jrv;
import dominio.PadronElectoral;
import dominio.Urna;


public class CtrlPadronElectoral {
	 private PadronElectoralDAO daoPadron = new PadronElectoralDAO() ;  
     
     public boolean crearPadron(String dui, String nombre, String apellidos,
    		 String domicilio,String estadovotacion,Urna urna, String username,Date fechanac) { 
        if (daoPadron.daPadronByDui(dui) == null ) { 
         PadronElectoral padron = new PadronElectoral(dui,nombre,apellidos,domicilio,estadovotacion,urna,username,fechanac); 
              daoPadron.guardaActualiza(padron) ; 
              return true;
        } 
        else 
          return false ; 
     } 
     
     
     public boolean actualizaPadron(String dui, String nombre, String apellidos,String domicilio, 
    		 String estadovotacion, Urna urna,String username, Date fechanac) { 
    	 if (daoPadron.daPadronByDui(dui) != null) {
            PadronElectoral padron=new PadronElectoral();
            padron.setDui(dui);
            padron.setNombre(nombre);
            padron.setApellidos(apellidos);
            padron.setDomicilio(domicilio);
            padron.setEstadovotacion(estadovotacion);
            padron.setUrna(urna);
            padron.setUsername(username);
            padron.setFechanac(fechanac);
            daoPadron.guardaActualiza(padron);
              return true ;}
    	 else
    		 return false;
     } 
      
     public boolean borrarPadron(String dui) { 
       if (daoPadron.daPadronByDui(dui) != null ) { 
    	   PadronElectoral padron = daoPadron.daPadronByDui(dui) ; 
    	   daoPadron.eliminar(padron) ; 
         return true ; 
       } 
       else  
         return false ; 
     } 
      
     
     
     public List<PadronElectoral> daPadrones(){ 
         return daoPadron.daPadron() ; 
     } 

     public PadronElectoral daPadronByDui(String dui) { 
          return daoPadron.daPadronByDui(dui)  ; 
     } 
      
    /* public PadronElectoral daPadronByUrna(String id_urna){ 
          return daoPadron.daPadronByUrna(id_urna); 
     }*/
}
