package negocio;


import java.awt.Desktop;
import java.io.File;

import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.OutputStream;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import com.mysql.jdbc.Connection;

import net.sf.jasperreports.engine.JREmptyDataSource;
import net.sf.jasperreports.engine.JRException;
import net.sf.jasperreports.engine.JasperCompileManager;
import net.sf.jasperreports.engine.JasperExportManager;
import net.sf.jasperreports.engine.JasperFillManager;
import net.sf.jasperreports.engine.JasperPrint;
import net.sf.jasperreports.engine.JasperReport;
import net.sf.jasperreports.engine.data.JRBeanCollectionDataSource;

import dao.JrvDAO;
import dominio.Jrv;



public class CtrlJrv {
	 private JrvDAO daoJrv = new JrvDAO() ;  
     
     public boolean crearJrv(String iddepto, String idmunicipio, String dui, String username) { 
    	 if (daoJrv.daJrvByClave(dui,idmunicipio,iddepto) == null) {
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
      
     public boolean actualizaJrv(String idjrv,String iddepto, String idmunicipio, String dui,String username) { 
    	 if (daoJrv.daJrvByClave(dui,idmunicipio,iddepto) != null) {
            Jrv jrv = new Jrv() ; 
            jrv.setIdjrv(Short.valueOf(idjrv));
            jrv.setIddepto(iddepto);
            jrv.setIdmunicipio(idmunicipio);
            jrv.setDui(dui);
            jrv.setUsername(username);
              daoJrv.guardaActualiza(jrv) ; 
              return true ;}
    	 else
    		 return false;
     } 
     
     
     public void reporteJrv() throws JRException{
    	 JasperReport jasperReport = JasperCompileManager.compileReport("C:/ConsultaJrv.jrxml");
    	    JasperPrint jasperPrint = JasperFillManager.fillReport(jasperReport,new HashMap(), new JREmptyDataSource());
    	    JasperExportManager.exportReportToPdfFile(jasperPrint, "C:/ConsultaJrv.pdf");
    	    try {
    	        File path = new File ("C:/ConsultaJrv.pdf");
    	        Desktop.getDesktop().open(path);
    	   }catch (IOException ex) {
    	        ex.printStackTrace();
    	   }
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
