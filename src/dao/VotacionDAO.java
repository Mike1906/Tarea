package dao;

import java.util.List;

import org.hibernate.HibernateException;
import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
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
	     
	     public List<Votacion> daVotacion() { 
	        sesion = sessionFactory.openSession() ; 
	        Query query = sesion.getNamedQuery("votacion.findAll"); 
	          List <Votacion>votacion = query.list() ; 
	          sesion.close() ; 
	        return votacion ; 
	     } 
	     public Votacion daVotacionById(float idVotacion){ 
		      sesion = sessionFactory.openSession() ; 
		      Votacion votacion = (Votacion) sesion.get(Votacion.class, new Float(idVotacion)); 
		    		      sesion.close() ; 
		    		      return votacion ; 
		    		     } 
	     public Votacion daVotacionByUrna(float idUrna) { 
		      sesion = sessionFactory.openSession() ; 
		      Query consulta = sesion.getNamedQuery("votacion.findByUrna"); 
		      consulta.setParameter("id_urna", idUrna) ; 
		      Votacion votacion = (Votacion) consulta.uniqueResult(); 
		      sesion.close() ; 
		      return votacion ; 
		     } 
	     public Votacion daVotacionByClave(float idVotacion,float idUrna,String idPartidoPolitico) { 
		      sesion = sessionFactory.openSession() ; 
		      Query consulta = sesion.getNamedQuery("votacion.findByClave"); 
		      consulta.setParameter("IdVotacion",idVotacion);
		      consulta.setParameter("IdUrna", idUrna) ; 
		      consulta.setParameter("IdPartidoPolitico",idPartidoPolitico);
		      Votacion votacion = (Votacion) consulta.uniqueResult(); 
		      sesion.close() ; 
		      return votacion; 
		     }

}
