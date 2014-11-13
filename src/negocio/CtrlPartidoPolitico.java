package negocio;

import java.util.Date;
import java.util.List;
import dominio.PartidoPolitico;
import dao.PartidoPoliticoDAO;

public class CtrlPartidoPolitico {
	private PartidoPoliticoDAO daoPartidoPolitico = new PartidoPoliticoDAO() ;
	
	public boolean crearPartidoPolitico(String idpartido, String nombpartido,Date fechafundac, String nombsecretariogral, String username) {
		PartidoPolitico partidopolitico = daoPartidoPolitico.daPartidoPoliticoById(idpartido);
		if (partidopolitico == null) {
			partidopolitico = new PartidoPolitico(idpartido, nombpartido,fechafundac,nombsecretariogral,username);
			daoPartidoPolitico.guardaActualiza(partidopolitico) ;
		return true ;
		}
		else
			return false ;
			}
	public boolean eliminarPartidoPolitico(String idPartidoPolitico) {
		if (daoPartidoPolitico.daPartidoPoliticoById(idPartidoPolitico) != null) {
			PartidoPolitico partidopolitico = daoPartidoPolitico.daPartidoPoliticoById (idPartidoPolitico) ;
			daoPartidoPolitico.eliminar(partidopolitico) ;
			return true ;
		}
		else
			return false ;
	}
	public boolean actualizar(String idpartido, String nombpartido, Date fechafundac, String nombsecretariogral, String username) {
         	if (daoPartidoPolitico.daPartidoPoliticoById(idpartido) != null) {
            PartidoPolitico partidopolitico = new PartidoPolitico(idpartido,nombpartido,fechafundac,nombsecretariogral, username);
			daoPartidoPolitico.guardaActualiza(partidopolitico) ;
			return true ;
		}
    	 else
    		 return false;
     } 
	public List<PartidoPolitico> daPartido(){ 
        return daoPartidoPolitico.daPartido() ; 
    } 
    
}

