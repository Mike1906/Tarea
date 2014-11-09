package dao;

import java.util.List;

import org.hibernate.HibernateException;
import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;

import datos.HibernateUtil;
import dominio.Jrv;


public class JrvDAO {
	private HibernateUtil hibernateUtil = new HibernateUtil() ;   
	private SessionFactory sessionFactory = hibernateUtil.getSessionFactory(); 
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
	     
	    public void guardaActualiza(Jrv jrv) { 
	      try { 
	           iniciaOperacion() ; 
	             sesion.saveOrUpdate(jrv) ; 
	             tx.commit() ; 
	               sesion.flush() ; 
	        } catch (HibernateException he) { 
	           manejaExcepcion(he) ; 
	           throw he ; 
	        } finally { 
	          sesion.close() ;   
	        } 
	      } 
	      
	      public void eliminar(Jrv jrv) { 
	      try { 
	           iniciaOperacion() ; 
	             sesion.delete(jrv) ;  
	             tx.commit() ; 
	             sesion.flush() ; 
	        } catch (HibernateException he) { 
	           manejaExcepcion(he) ; 
	           throw he ; 
	        } finally { 
	          sesion.close() ;   
	        }       
	      } 
	     
	     public List daJrv() { 
	        sesion = sessionFactory.openSession() ; 
	        Query query = sesion.getNamedQuery("jrv.findAll"); 
	          List jrv = query.list() ; 
	          sesion.close() ; 
	        return jrv ; 
	     } 
	     
	     
	     /*
	     public List daJrvByDepto(String id_Depto) { 
	        sesion = sessionFactory.openSession() ; 
	        String condicion = "select j from JRV j join fetch  j.departamento d where d.id_Depto = :id_depto" ; 
	        Query query = sesion.createQuery(condicion) ; 
	        query.setParameter("ID_DEPTO", id_Depto) ; 
	        List listado = query.list() ; 
	          sesion.close() ; 
	        return listado ; 
	     } 
	     */
	     public Jrv daJrvById(short idjrv){ 
	      sesion = sessionFactory.openSession() ; 
	      Jrv jrv = (Jrv) sesion.get(Jrv.class, new Short(idjrv)); 
	    		      sesion.close() ; 
	    		      return jrv ; 
	    		     } 
	     
	     
	    		     
	     /*    public Jrv daJrvByMunicipio(String id_municipio) { 
	    		      sesion = sessionFactory.openSession() ; 
	    		      Query consulta = sesion.getNamedQuery("jrv.findByMunicipio"); 
	    		      consulta.setParameter("id_municipio", id_municipio) ; 
	    		      Jrv jrv = (Jrv) consulta.uniqueResult(); 
	    		      sesion.close() ; 
	    		      return jrv ; 
	    		     }  
	    		     */
	    		     
	    		     public Jrv daJrvByDui(String dui) { 
		    		      sesion = sessionFactory.openSession() ; 
		    		      Query consulta = sesion.getNamedQuery("jrv.findByDui"); 
		    		      consulta.setParameter("dui", dui) ; 
		    		      Jrv jrv = (Jrv) consulta.uniqueResult(); 
		    		      sesion.close() ; 
		    		      return jrv ; 
		    		     }
	    		     
	    		     public Jrv daJrvByClave(String dui,String idmunicipio,String iddepto) { 
		    		      sesion = sessionFactory.openSession() ; 
		    		      Query consulta = sesion.getNamedQuery("jrv.findByClave"); 
		    		      consulta.setParameter("dui", dui) ; 
		    		      consulta.setParameter("idmunicipio", idmunicipio);
		    		      consulta.setParameter("iddepto", iddepto);
		    		      Jrv jrv = (Jrv) consulta.uniqueResult(); 
		    		      sesion.close() ; 
		    		      return jrv ; 
		    		     }
}
