package negocio;

import java.awt.Desktop;
import java.io.File;
import java.io.IOException;
import java.math.BigDecimal;
import java.sql.DriverManager;
import java.util.Date;
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
import net.sf.jasperreports.view.JasperViewer;

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
      
     /*public void reportePadron() throws JRException{
    	 JasperReport jasperReport = JasperCompileManager.compileReport("C:/ReportePadron.jrxml");
    	    JasperPrint jasperPrint = JasperFillManager.fillReport(jasperReport,new HashMap(), new JREmptyDataSource());
    	    JasperExportManager.exportReportToPdfFile(jasperPrint, "C:/ReportePadron.pdf");
    	    try {
    	        File path = new File ("C:/ReportePadron.pdf");
    	        Desktop.getDesktop().open(path);
    	   }catch (IOException ex) {
    	        ex.printStackTrace();
    	   }
     }*/
     
     public void reportePadron() throws JRException{
    	 String reportPath = "/ReportePadron.jasper";
         Map<String, Object> params = new HashMap<String, Object>();
         Connection connection;

        try {

           // JasperReport jasperReport = JasperCompileManager.compileReport(reportSource);
              Class.forName("com.mysql.jdbc.Driver");
              connection = (Connection) DriverManager.getConnection("jdbc:mysql://localhost:3306/tarea?zeroDateTimeBehavior=convertToNull","root","root");
            System.out.println("Filling report...");
            JasperPrint jasperPrint = JasperFillManager.fillReport(reportPath, params, connection);
            JasperExportManager.exportReportToPdfFile(jasperPrint, "C:/ReportePadron.pdf");
            File path = new File ("C:/ReportePadron.pdf");
	        Desktop.getDesktop().open(path);
        //    JasperViewer.viewReport(jasperPrint, false);
            connection.close();
        } catch (Exception e) {
            System.out.println(e.getMessage());
        }
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
