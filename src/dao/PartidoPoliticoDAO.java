package dao;

import java.util.List;

import org.hibernate.HibernateException;
import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import dominio.PartidoPolitico;
import datos.HibernateUtil;

public class PartidoPoliticoDAO {

	private HibernateUtil hibernateUtil = new HibernateUtil() ;
	private SessionFactory sessionFactory = hibernateUtil.getSessionFactory();
	private Session sesion;
	private Transaction tx;
	private void iniciaOperacion() throws HibernateException {
	sesion = sessionFactory.openSession() ;
	tx = sesion.beginTransaction() ;
	}
	private void manejaExcepcion(HibernateException he) throws
	HibernateException {
	tx.rollback();
	throw new HibernateException("Ocurrió un error en la capa DAO", he);
	}
	public void guardaActualiza(PartidoPolitico partidopolitico) {
		try {
		iniciaOperacion() ;
		sesion.saveOrUpdate(partidopolitico) ;
		tx.commit() ;
		sesion.flush() ;
		} catch (HibernateException he) {
		manejaExcepcion(he) ;
		throw he ;
		} finally {
		sesion.close() ;
		}
		}
	public void eliminar(PartidoPolitico partidopolitico) {
		try {
		iniciaOperacion() ;
		sesion.delete(partidopolitico) ;
		tx.commit() ;
		sesion.flush() ;
		} catch (HibernateException he) {
		manejaExcepcion(he) ;
		throw he ;
		} finally {
		sesion.close() ;
		}
		}
	public PartidoPolitico daPartidoPoliticoById(String idPartidoPolitico){
		sesion = sessionFactory.openSession() ;
		PartidoPolitico id = (PartidoPolitico) sesion.get(PartidoPolitico.class,new String(idPartidoPolitico)) ;
		sesion.close() ;
		return id ;
		}
	public List<PartidoPolitico> daPartido() { 
        sesion = sessionFactory.openSession() ; 
        Query query = sesion.getNamedQuery("PartidoPolitico.findAll"); 
          List <PartidoPolitico>partido = query.list() ; 
          sesion.close() ; 
        return partido ; 
     } 
	
	public PartidoPolitico daPartidoPoliticoByNombre(String nombrePartido) {
		sesion = sessionFactory.openSession() ;
		Query query = sesion.getNamedQuery("PartidoPolitico.findByNombrePartido");
		query.setParameter("NombrePartido", nombrePartido);
		PartidoPolitico partido = (PartidoPolitico) query.uniqueResult();
		sesion.close() ;
		return partido ;
		}
	
	
}
