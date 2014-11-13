package negocio;
import java.util.List;
import dao.*;
import dominio.*;

import dao.MunicipioDAO;
import dominio.Miembrojrv;
import dominio.Municipio;

public class CtrlDepartamento {
	private DepartamentoDAO daoMiembro = new DepartamentoDAO() ;

	public boolean crearDepartamento(String iddepto, String nombredepto, String zonageografica, String username) {
		if (daoMiembro.daDepartamentoById(iddepto) == null) {
			Departamento miembro = new Departamento(iddepto, nombredepto, zonageografica, username);
			daoMiembro.guardaActualiza(miembro);
			return true ;
		}
		else
			return false ;
	}
	
	public boolean eliminar(String iddepto) {
		if (daoMiembro.daDepartamentoById(iddepto) != null) {
			Departamento miembro = daoMiembro.daDepartamentoById(iddepto);
			daoMiembro.eliminar(miembro) ;
			return true ;
		}
		else
			return false ;
	}
	public boolean actualizar(String iddepto, String nombredepto, String zonageografica, String username) {
		if (daoMiembro.daDepartamentoById(iddepto) != null) {
			Departamento miembro = new Departamento(iddepto, nombredepto, zonageografica, username);
			daoMiembro.guardaActualiza(miembro);
			return true ;
		}
		else
			return false ;
	} 
	
	public List<Departamento> daDepartamento(){
		return daoMiembro.daDepartamento() ;
	}	
}
