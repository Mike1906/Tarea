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

public class CtrlTipoMiembro {
	private TipoMiembroDAO daoTipoMiembro = new TipoMiembroDAO() ;

	public boolean crearTipoMiembro(String idtipomiembro, String descripcion, String username) {
		if (daoTipoMiembro.daTipoMiembroById(idtipomiembro) == null) {
			TipoMiembro tipomiembro = new TipoMiembro(idtipomiembro, descripcion, username);
			daoTipoMiembro.guardaActualiza(tipomiembro) ;
			return true ;
		}
		else
			return false ;
	}
	public boolean eliminarTipoMiembro(String idtipomiembro) {
		if (daoTipoMiembro.daTipoMiembroById(idtipomiembro) != null) {
			TipoMiembro tipomiembro = daoTipoMiembro.daTipoMiembroById(idtipomiembro) ;
			daoTipoMiembro.eliminar(tipomiembro) ;
			return true ;
		}
		else
			return false ;
	}
	public boolean actualizar(String idtipomiembro, String descripcion, String username) {
		if (daoTipoMiembro.daTipoMiembroById(idtipomiembro) != null) {
			TipoMiembro tipomiembro = new TipoMiembro(idtipomiembro, descripcion, username);
			daoTipoMiembro.guardaActualiza(tipomiembro) ;
			return true ;
		}
		else
			return false ;
	} 
	
	 public void reporteTipoMiembro() throws JRException{
    	 String reportPath = "/TiposMiembros.jasper";
         Map<String, Object> params = new HashMap<String, Object>();
         Connection connection;

        try {

           // JasperReport jasperReport = JasperCompileManager.compileReport(reportSource);
              Class.forName("com.mysql.jdbc.Driver");
              connection = (Connection) DriverManager.getConnection("jdbc:mysql://localhost:3306/tarea?zeroDateTimeBehavior=convertToNull","root","root");
            System.out.println("Filling report...");
            JasperPrint jasperPrint = JasperFillManager.fillReport(reportPath, params, connection);
            JasperExportManager.exportReportToPdfFile(jasperPrint, "C:/TiposMiembros.pdf");
            File path = new File ("C:/TiposMiembros.pdf");
	        Desktop.getDesktop().open(path);
        //    JasperViewer.viewReport(jasperPrint, false);
            connection.close();
        } catch (Exception e) {
            System.out.println(e.getMessage());
        }
 }
	
	public List<TipoMiembro> daTipoMiembro(){
		return daoTipoMiembro.daTipoMiembro() ;
	}
	
	public TipoMiembro daTipoMiembroByDesc(String descripcion) {
		return daoTipoMiembro.daTipoMiembroByDesc(descripcion) ;
	}
}
