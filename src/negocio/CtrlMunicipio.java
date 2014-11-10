package negocio;
import java.util.List;
import dao.*;
import dominio.*;

public class CtrlMunicipio {
	private MunicipioDAO daoMiembro = new MunicipioDAO() ;

	public boolean crearMunicipio(String idmunicipio, String iddepto,String nombmunicipio, String username) {
		if (daoMiembro.daMiembroByNombres(idmunicipio) == null) {
			Municipio miembro = new Municipio(idmunicipio,iddepto,nombmunicipio,username);
			daoMiembro.guardaActualiza(miembro) ;
			return true ;
		}
		else
			return false ;
	}
	
	public boolean eliminar(String idmunicipio) {
		if (daoMiembro.daMiembroById(idmunicipio) != null) {
			Municipio miembro = daoMiembro.daMiembroById(idmunicipio) ;
			daoMiembro.eliminar(miembro) ;
			return true ;
		}
		else
			return false ;
	}
	public boolean actualizar(String idmunicipio, String iddepto,String nombmunicipio, String username) {
		if (daoMiembro.daMiembroByNombres(idmunicipio) != null) {
			Municipio miembro = new Municipio(idmunicipio,iddepto,nombmunicipio,username);
			daoMiembro.guardaActualiza(miembro) ;
			return true ;
		}
		else
			return false ;
	}
	
	public List<Municipio> daMunicipio(){
		return daoMiembro.daMunicipio() ;
	}
	
	public Municipio daMiembroByNombres(String nombres) {
		return daoMiembro.daMiembroByNombres(nombres) ;
	}

}
