package negocio;

import java.util.List;

import dao.*;
import dominio.*;

public class CtrlTipoMiembro {
	private TipoMiembroDAO daoTipoMiembro = new TipoMiembroDAO() ;

	public boolean crearTipoMiembro(String idtipomiembro, String descripcion, String username) {
		if (daoTipoMiembro.daTipoMiembroByDesc(descripcion) == null) {
			TipoMiembro tipomiembro = new TipoMiembro(idtipomiembro, descripcion, username);
			daoTipoMiembro.guardaActualiza(tipomiembro) ;
			return true ;
		}
		else
			return false ;
	}
	public boolean eliminarTipoMiembro(String descripcion) {
		if (daoTipoMiembro.daTipoMiembroByDesc(descripcion) != null) {
			TipoMiembro tipomiembro =	daoTipoMiembro.daTipoMiembroByDesc(descripcion) ;
			daoTipoMiembro.eliminar(tipomiembro) ;
			return true ;
		}
		else
			return false ;
	}
	public List<TipoMiembro> daTipoMiembro(){
		return daoTipoMiembro.daTipoMiembro() ;
	}
	
	public TipoMiembro daTipoMiembroByDesc(String descripcion) {
		return daoTipoMiembro.daTipoMiembroByDesc(descripcion) ;
	}
}
