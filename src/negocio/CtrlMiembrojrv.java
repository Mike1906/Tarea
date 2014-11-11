package negocio;

import java.awt.Desktop;
import java.io.File;
import java.sql.DriverManager;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import net.sf.jasperreports.engine.JRException;
import net.sf.jasperreports.engine.JasperExportManager;
import net.sf.jasperreports.engine.JasperFillManager;
import net.sf.jasperreports.engine.JasperPrint;

import com.mysql.jdbc.Connection;

import dao.*;
import dominio.*;

public class CtrlMiembrojrv {
	private MiembrojrvDAO daoMiembro = new MiembrojrvDAO() ;

	public boolean crearMiembrojrv(String idmiembro, String nombres,String apellidop, String apellidom,int idjrv, String idtipom, String username) {
		if (daoMiembro.daMiembroById(idmiembro) == null) {
			Miembrojrv miembro = new Miembrojrv(idmiembro,nombres,apellidop,apellidom,idjrv,idtipom, username);
			daoMiembro.guardaActualiza(miembro) ;
			return true ;
		}
		else
			return false ;
	}
	
	public boolean eliminarMiembro(String miembrojrv) {
		if (daoMiembro.daMiembroById(miembrojrv) != null) {
			Miembrojrv miembro = daoMiembro.daMiembroById(miembrojrv) ;
			daoMiembro.eliminar(miembro) ;
			return true ;
		}
		else
			return false ;
	}
	public boolean actualizar(String idmiembro, String nombres,String apellidop, String apellidom,int idjrv, String idtipom, String username) {
		if (daoMiembro.daMiembroById(idmiembro) != null) {
			Miembrojrv miembro = new Miembrojrv(idmiembro,nombres,apellidop,apellidom,idjrv,idtipom, username);
			daoMiembro.guardaActualiza(miembro) ;
			return true ;
		}
		else
			return false ;
	}  
	
	public void reporteMiembroJrv() throws JRException{
   	 String reportPath = "/Miembrosjrv.jasper";
        Map<String, Object> params = new HashMap<String, Object>();
        Connection connection;

       try {

          // JasperReport jasperReport = JasperCompileManager.compileReport(reportSource);
             Class.forName("com.mysql.jdbc.Driver");
             connection = (Connection) DriverManager.getConnection("jdbc:mysql://localhost:3306/tarea?zeroDateTimeBehavior=convertToNull","root","root");
           System.out.println("Filling report...");
           JasperPrint jasperPrint = JasperFillManager.fillReport(reportPath, params, connection);
           JasperExportManager.exportReportToPdfFile(jasperPrint, "C:/tarea/Miembrosjrv.pdf");
           File path = new File ("C:/tarea/Miembrosjrv.pdf");
	        Desktop.getDesktop().open(path);
       //    JasperViewer.viewReport(jasperPrint, false);
           connection.close();
       } catch (Exception e) {
           System.out.println(e.getMessage());
       }
}
	
	
	public List<Miembrojrv> daMiembrojrv(){
		return daoMiembro.daMiembrojrv() ;
	}
	
	public Miembrojrv daMiembroByNombres(String nombres) {
		return daoMiembro.daMiembroByNombres(nombres) ;
	}

}
