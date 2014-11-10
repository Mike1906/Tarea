package negocio;

import java.util.List;
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
	
	public List<Miembrojrv> daMiembrojrv(){
		return daoMiembro.daMiembrojrv() ;
	}
	
	public Miembrojrv daMiembroByNombres(String nombres) {
		return daoMiembro.daMiembroByNombres(nombres) ;
	}

}
