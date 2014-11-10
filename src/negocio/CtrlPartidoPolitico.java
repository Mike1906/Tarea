package negocio;

import java.util.Date;
import java.util.List;
import dominio.PartidoPolitico;
import dao.PartidoPoliticoDAO;

public class CtrlPartidoPolitico {
	private PartidoPoliticoDAO daoPartidoPolitico = new PartidoPoliticoDAO() ;
	
	public boolean crearPartidoPolitico(String idPartidoPolitico,String nombrePartido,Date fechaDeFundacion, String nombreSecretarioGeneral,String username) {
		PartidoPolitico partidopolitico = daoPartidoPolitico.daPartidoPoliticoById(idPartidoPolitico);
		if (partidopolitico == null) {
		 partidopolitico = new PartidoPolitico(idPartidoPolitico,nombrePartido,fechaDeFundacion,nombreSecretarioGeneral,username);
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
	public boolean actualizar(String idPartidoPolitico, String nombrePartido,Date fechaDeFundacion,String nombreSecretarioGeneral, String username) { 
	   	 if (daoPartidoPolitico.daPartidoPoliticoById(idPartidoPolitico) != null) {
	           PartidoPolitico partidopolitico = new PartidoPolitico();
	           partidopolitico.setIdPartidoPolitico(idPartidoPolitico);
	           partidopolitico.setNombrePartido(nombrePartido);
	           partidopolitico.setFechaDeFundacion(fechaDeFundacion);
	           partidopolitico.setNombreSecretarioGeneral(nombreSecretarioGeneral);
	           partidopolitico.setUsername(username);          
	           daoPartidoPolitico.guardaActualiza(partidopolitico);
	             return true ;}
	   	 else
	   		 return false;
	    } 
	public List<PartidoPolitico> daPartido(){ 
        return daoPartidoPolitico.daPartido() ; 
    } 

    
    public PartidoPolitico daPartidoPoliticoByNombrePartido(String nombrePartido) { 
        return daoPartidoPolitico.daPartidoPoliticoByNombre(nombrePartido)  ; 
   } 
}

