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
            Votacion votacion = new Votacion() ; 
            votacion.setIdvotacion(idvotacion);
            votacion.setIdurna(idurna);
            votacion.setIdpartido(idpartido);
            votacion.setCantvotosvalidos(cantvotosvalidos);
            votacion.setUsername(username);
              daoVotacion.guardaActualiza(votacion) ; 
              return true ;}
    	 else
    		 return false;
     } 
     public void reporteVotacion() {
    	 String reportPath = "/ConsultaVotacion.jasper";
         Map<String, Object> params = new HashMap<String, Object>();
         Connection connection;
         
        try {
           // JasperReport jasperReport = JasperCompileManager.compileReport(reportSource);
              Class.forName("com.mysql.jdbc.Driver");
              connection = (Connection) DriverManager.getConnection("jdbc:mysql://localhost:3306/tarea","root","root");
            System.out.println("Filling report...");
            JasperPrint jasperPrint = JasperFillManager.fillReport(reportPath, params, connection);
            JasperExportManager.exportReportToPdfFile(jasperPrint, "C:/ConsultaVotacion.pdf");
            File path = new File ("C:/ConsultaVotacion.pdf");
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
    
    public List<Votacion> daVotacion(){ 
        return daoVotacion.daVotacion() ; 
    } 


}
