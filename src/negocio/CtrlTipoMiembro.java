package negocio;

import java.util.List;

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
	           TipoMiembro tipom = new TipoMiembro();
	           tipom.setIdtipomiembro(idtipomiembro);
	           tipom.setDescripcion(descripcion);
	           tipom.setDescripcion(username);          
	           daoTipoMiembro.guardaActualiza(tipom);
	             return true ;}
	   	 else
	   		 return false;
	    } 
	
	public List<TipoMiembro> daTipoMiembro(){
		return daoTipoMiembro.daTipoMiembro() ;
	}
	
	public TipoMiembro daTipoMiembroByDesc(String descripcion) {
		return daoTipoMiembro.daTipoMiembroByDesc(descripcion) ;
	}
}
