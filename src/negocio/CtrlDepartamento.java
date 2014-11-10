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
		if (daoMiembro.daMiembroByNombres(nombres) == null) {
			Municipio miembro = new Municipio(nombdepto,iddepto,zonageografica,username);
			daoMiembro.guardaActualiza(miembro) ;
			return true ;
		}
		else
			return false ;
	}
	
	public boolean eliminarMiembro(String departamento) {
		if (daoMiembro.daMiembroById(departamento) != null) {
			Departamento miembro = daoMiembro.daMiembroById(departamento) ;
			daoMiembro.eliminar(miembro) ;
			return true ;
		}
		else
			return false ;
	}
	public boolean actualizar(String nombdepto, String iddepto,String zonageografica, String username) { 
	   	 if (daoMiembro.daMiembroById(iddepto) != null) {
	           Departamento miembro = new Departamento();
	          miembro.setiddepto(iddepto);
	          miembro.setnombdepto(nombdepto);
	          miembro.setzonageografica(zonageografica);
	          miembro.setUsername(username);
	          daoMiembro.guardaActualiza(miembro);
	           return true ;}
	   	 else
	   		 return false;
	} 
	
	public List<Departamento> daDepartamento(){
		return daoMiembro.daDepartamento() ;
	}
	
	public Departamento daMiembroByNombres(String nombres) {
		return daoMiembro.daMiembroByNombres(nombres) ;
	}
}
