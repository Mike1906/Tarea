package dao;

import java.util.List;

import org.hibernate.HibernateException;
import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;

import datos.HibernateUtil;
import dominio.PadronElectoral;


public class PadronElectoralDAO {
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
	     
	    public void guardaActualiza(PadronElectoral padron) { 
	      try { 
	           iniciaOperacion() ; 
	             sesion.saveOrUpdate(padron) ; 
	             tx.commit() ; 
	               sesion.flush() ; 
	        } catch (HibernateException he) { 
	           manejaExcepcion(he) ; 
	           throw he ; 
	        } finally { 
	          sesion.close() ;   
	        } 
	      } 
	      
	      public void eliminar(PadronElectoral padron) { 
	      try { 
	           iniciaOperacion() ; 
	             sesion.delete(padron) ;  
	             tx.commit() ; 
	             sesion.flush() ; 
	        } catch (HibernateException he) { 
	           manejaExcepcion(he) ; 
	           throw he ; 
	        } finally { 
	          sesion.close() ;   
	        }       
	      } 
	     
	     public List daPadron() { 
	        sesion = sessionFactory.openSession() ; 
	        Query query = sesion.getNamedQuery("PadronElectoral.findAll"); 
	          List padron = query.list() ; 
	          sesion.close() ; 
	        return padron ; 
	     } 
	          
	     
	     public PadronElectoral daPadronByDui(String dui){ 
	      sesion = sessionFactory.openSession() ; 
	      PadronElectoral pdui = (PadronElectoral) sesion.get(PadronElectoral.class, new String(dui)); 
	      sesion.close() ; 
	      return pdui ; 
	    		     } 
	    		     
	    		     /*
	    		     public PadronElectoral daPadronByUrna(String id_urna) { 
		    		      sesion = sessionFactory.openSession() ; 
		    		      Query consulta = sesion.getNamedQuery("PadronElectoral.findByIdUrna"); 
		    		      consulta.setParameter("id_urna", id_urna) ; 
		    		      PadronElectoral padron = (PadronElectoral) consulta.uniqueResult(); 
		    		      sesion.close() ; 
		    		      return padron ; 
		    		     }*/
}
