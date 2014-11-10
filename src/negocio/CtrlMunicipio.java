package negocio;
import java.util.List;
import dao.*;
import dominio.*;

public class CtrlMunicipio {
	private MunicipioDAO daoMiembro = new MunicipioDAO() ;

	public boolean crearMunicipio(String idmunicipio, String iddepto,String nombmunicipio, String username) {
		if (daoMiembro.daMiembroByNombres(nombres) == null) {
			Municipio miembro = new Municipio(idmunicipio,iddepto,nombmunicipio,username);
			daoMiembro.guardaActualiza(miembro) ;
			return true ;
		}
		else
			return false ;
	}
	
	public boolean eliminarMiembro(String municipio) {
		if (daoMiembro.daMiembroById(municipio) != null) {
			Municipio miembro = daoMiembro.daMiembroById(municipio) ;
			daoMiembro.eliminar(miembro) ;
			return true ;
		}
		else
			return false ;
	}
	public boolean actualizar(String idmunicipio, String iddepto,String nombmunicipio, String username) { 
	   	 if (daoMiembro.daMiembroById(idmiembro) != null) {
	           Municipio miembro = new Miembrojrv();
	           miembro.setiddepto(iddepto);
	           miembro.setidmunicipio(idmunicipio);
	           miembro.setnombmunicipio(nombmunicipio);
	           miembro.setUsername(username);
	           daoMiembro.guardaActualiza(miembro);
	           return true ;}
	   	 else
	   		 return false;
	} 
	
	public List<Municipio> daMunicipio(){
		return daoMiembro.daMunicipio() ;
	}
	
	public Municipio daMiembroByNombres(String nombres) {
		return daoMiembro.daMiembroByNombres(nombres) ;
	}

}
