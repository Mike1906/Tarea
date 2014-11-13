package dao;

import java.util.List;

import org.hibernate.HibernateException;
import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;

import dominio.TipoMiembro;
import dominio.Votacion;
import datos.HibernateUtil;

public class VotacionDAO {
	private HibernateUtil hibernateUtil = new HibernateUtil() ;   
	  private SessionFactory sessionFactory = hibernateUtil.getSessionFactory() 
	; 
	  private Session sesion;  
	    private Transaction tx;  
	     
	  private void iniciaOperacion() throws HibernateException   {  
	    sesion = sessionFactory.openSession() ; 
	    tx = sesion.beginTransaction() ; 
	    }
	  private void manejaExcepcion(HibernateException he) throws 
	  HibernateException   { 
	          tx.rollback();  
	          throw new HibernateException("Ocurrió un error en la capa DAO", he);  
	      }  
	     
	    public void guardaActualiza(Votacion votacion) { 
	      try { 
	           iniciaOperacion() ; 
	             sesion.saveOrUpdate(votacion) ; 
	             tx.commit() ; 
	               sesion.flush() ; 
	        } catch (HibernateException he) { 
	           manejaExcepcion(he) ; 
	           throw he ; 
	        } finally { 
	          sesion.close() ;   
	        } 
	      } 
	      
	      public void eliminar(Votacion votacion) { 
	      try { 
	           iniciaOperacion() ; 
	             sesion.delete(votacion) ;  
	             tx.commit() ; 
	             sesion.flush() ; 
	        } catch (HibernateException he) { 
	           manejaExcepcion(he) ; 
	           throw he ; 
	        } finally { 
	          sesion.close() ;   
	        }       
	      } 
	     
	    public Votacion daVotacionById(String idvotacion){
	  		sesion = sessionFactory.openSession() ;
	  		// Retorna la instancia persistente de la clase por medio del atributo identidad
	  		Votacion id = (Votacion) sesion.get(Votacion.class,new String(idvotacion)) ;
	  		sesion.close() ;
	  		return id ;
	  	}
	      
	     public List<Votacion> daVotacion() { 
	        sesion = sessionFactory.openSession() ; 
	        Query query = sesion.getNamedQuery("Votacion.findAll"); 
	          List <Votacion>votacion = query.list() ; 
	          sesion.close() ; 
	        return votacion ; 
	     }	    
	     
}
