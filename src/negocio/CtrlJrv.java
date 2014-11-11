package negocio;


import java.awt.Desktop;
import java.io.File;

import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.OutputStream;
import java.sql.DriverManager;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import com.mysql.jdbc.Connection;

import net.sf.jasperreports.engine.JREmptyDataSource;
import net.sf.jasperreports.engine.JRException;
import net.sf.jasperreports.engine.JRExporterParameter;
import net.sf.jasperreports.engine.JasperCompileManager;
import net.sf.jasperreports.engine.JasperExportManager;
import net.sf.jasperreports.engine.JasperFillManager;
import net.sf.jasperreports.engine.JasperPrint;
import net.sf.jasperreports.engine.JasperReport;
import net.sf.jasperreports.engine.data.JRBeanCollectionDataSource;
import net.sf.jasperreports.engine.export.ooxml.JRXlsxExporter;
import net.sf.jasperreports.export.ExporterInput;
import net.sf.jasperreports.export.SimpleExporterInput;
import net.sf.jasperreports.export.SimpleOutputStreamExporterOutput;
import net.sf.jasperreports.export.SimpleXlsxReportConfiguration;
import net.sf.jasperreports.view.JasperViewer;

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
     
     
    /* public void reporteJrv() throws JRException{
    	 JasperReport jasperReport = JasperCompileManager.compileReport("C:/ConsultaJrv.jrxml");
    	    JasperPrint jasperPrint = JasperFillManager.fillReport(jasperReport,new HashMap(), new JREmptyDataSource());
    	    JasperExportManager.exportReportToPdfFile(jasperPrint, "C:/ConsultaJrv.pdf");
    	    try {
    	        File path = new File ("C:/ConsultaJrv.pdf");
    	        Desktop.getDesktop().open(path);
    	   }catch (IOException ex) {
    	        ex.printStackTrace();
    	   }
     }*/
     
    
	public void reporteJrv() {
    	 String reportPath = "/ConsultaJrv.jasper";
         Map<String, Object> params = new HashMap<String, Object>();
         Connection connection;
         
        try {
           // JasperReport jasperReport = JasperCompileManager.compileReport(reportSource);
              Class.forName("com.mysql.jdbc.Driver");
              connection = (Connection) DriverManager.getConnection("jdbc:mysql://localhost:3306/tarea","root","root");
            System.out.println("Filling report...");
            JasperPrint jasperPrint = JasperFillManager.fillReport(reportPath, params, connection);
            JasperExportManager.exportReportToPdfFile(jasperPrint, "C:/ConsultaJrv.pdf");
            File path = new File ("C:/ConsultaJrv.pdf");
	        Desktop.getDesktop().open(path);
	        
	        
	        
	        File xlsx = new File("C:/sample.xls");
	        JRXlsxExporter xlsEexporter = new JRXlsxExporter();
	        xlsEexporter.setExporterInput((ExporterInput) new SimpleExporterInput(reportPath));
	        xlsEexporter.setExporterOutput(new SimpleOutputStreamExporterOutput(new File("C:/sample.xlsx")));
	        SimpleXlsxReportConfiguration config = new SimpleXlsxReportConfiguration();
	        xlsEexporter.setConfiguration(config);
	        xlsEexporter.exportReport();
	        
	        
	        
	        
           // JasperViewer.viewReport(jasperPrint, false);
            connection.close();
        } catch (Exception e) {
            System.out.println(e.getMessage());
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
