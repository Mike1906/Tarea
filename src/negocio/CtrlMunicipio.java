package negocio;
import java.util.List;
import dao.*;
import dominio.*;

public class CtrlMunicipio {
	private MunicipioDAO daoMiembro = new MunicipioDAO() ;

	public boolean crearMunicipio(String idmunicipio, String iddepto,String nombmunicipio, String username) {
		if (daoMiembro.daMunicipioById(idmunicipio) == null) {
			Municipio miembro = new Municipio(idmunicipio, iddepto, nombmunicipio, username);
			daoMiembro.guardaActualiza(miembro) ;
			return true ;
		}
		else
			return false ;
	}
	
	public boolean eliminar(String idmunicipio) {
		if (daoMiembro.daMunicipioById(idmunicipio) != null) {
			Municipio miembro = daoMiembro.daMunicipioById(idmunicipio) ;
			daoMiembro.eliminar(miembro) ;
			return true ;
		}
		else
			return false ;
	}
	
	public List<Municipio> daMunicipio(){
		return daoMiembro.daMunicipio() ;
	}
	

}
