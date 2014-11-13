package negocio;

import java.util.List;

import dao. *;
import dominio. *;


public class CtrlUrna {

	private UrnaDAO daoUrna = new UrnaDAO() ;

	public boolean  crearUrna (int idurna, String idmunicipio, String iddepto, int numjunta,String presidente, String secretario, int cantvotosnulos, String cantvotosnovalid, String username)  {
		if (daoUrna.daUrnaById(idurna) == null) {
			Urna urna = new Urna(idurna, idmunicipio,iddepto,numjunta,presidente,secretario,cantvotosnulos,cantvotosnovalid,username);
			daoUrna.guardaActualiza(urna) ;
			return true ;
		}
		else
			return false ;
	}
	
	/*public boolean eliminarUrna(String urna) {
		if (daoUrna.daUrnaById(idurna)!= null) {
			Urna urna = daoUrna.daUrnaById(id);
			daoUrna.eliminar(urna) ;
			return true ;
		}
		else
			return false ;
	}*/
	
	public List<Urna> daUrna(){
		return daoUrna.daUrna() ;
	}
	
	
	
}
