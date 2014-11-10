package negocio;
import java.util.List;
import dao.*;
import dominio.*;

import dao.MunicipioDAO;
import dominio.Miembrojrv;
import dominio.Municipio;

public class CtrlDepartamento {
	private DepartamentoDAO daoMiembro = new DepartamentoDAO() ;

	public boolean crearDepartamento(String nombdepto, String iddepto,String zonageografica, String username) {
		if (daoMiembro.daDepartamentoByNombres(nombdepto) == null) {
			Departamento miembro = new Departamento(nombdepto,iddepto,zonageografica,username);
			daoMiembro.guardaActualiza(miembro);
			return true ;
		}
		else
			return false ;
	}
	
	public boolean eliminar(String nombdepto) {
		if (daoMiembro.daDepartamentoByNombres(nombdepto) != null) {
			Departamento miembro = daoMiembro.daDepartamentoByNombres(nombdepto) ;
			daoMiembro.eliminar(miembro) ;
			return true ;
		}
		else
			return false ;
	}
	public boolean actualizar(String nombdepto, String iddepto,String zonageografica, String username) {
		if (daoMiembro.daDepartamentoByNombres(nombdepto) != null) {
			Departamento miembro = new Departamento(nombdepto,iddepto,zonageografica,username);
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
