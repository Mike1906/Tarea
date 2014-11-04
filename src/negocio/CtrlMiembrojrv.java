package negocio;

import dao.*;
import dominio.*;

public class CtrlMiembrojrv {
	private MiembrojrvDAO daoMiembro = new MiembrojrvDAO() ;

	public boolean crearMiembrojrv(String idmiembro, String nombres,String apellidop, String apellidom,int idjrv, String idtipom, String username) {
		if (daoMiembro.daMiembroByNombres(nombres) == null) {
			Miembrojrv miembro = new Miembrojrv(idmiembro,nombres,apellidop,apellidom,idjrv,idtipom, username);
			daoMiembro.guardaActualiza(miembro) ;
			return true ;
		}
		else
			return false ;
	}
	
	public Miembrojrv daMiembroByNombres(String nombres) {
		return daoMiembro.daMiembroByNombres(nombres) ;
	}

}
