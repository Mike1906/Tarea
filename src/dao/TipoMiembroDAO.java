package dao;

import java.util.List;

import org.hibernate.HibernateException;
import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import datos.HibernateUtil;
import dominio.*;

public class TipoMiembroDAO {
	private HibernateUtil hibernateUtil = new HibernateUtil() ;
	private SessionFactory sessionFactory = hibernateUtil.getSessionFactory();
	private Session sesion;
	private Transaction tx;
	
	private void iniciaOperacion() throws HibernateException {
		sesion = sessionFactory.openSession() ;
		tx = sesion.beginTransaction() ;
	}
	
	private void manejaExcepcion(HibernateException he) throws HibernateException {
		tx.rollback();
		throw new HibernateException("Ocurri� un error en la capa DAO", he);
	}
	
	public void guardaActualiza(TipoMiembro tipomiembro) {
		try {
			iniciaOperacion() ;
			sesion.saveOrUpdate(tipomiembro) ;
			tx.commit();
			sesion.flush() ;
		} catch (HibernateException he) {
			manejaExcepcion(he) ;
			throw he ;
		} finally {
			sesion.close() ;
		}
	}
	public void eliminar(TipoMiembro tipomiembro) {
		try {
			iniciaOperacion() ;
			sesion.delete(tipomiembro) ;
			tx.commit() ;
			sesion.flush() ;
		} catch (HibernateException he) {
			manejaExcepcion(he) ;
			throw he ;
		} finally {
			sesion.close() ;
		}
	}
	public List daTipoMiembro() {
		sesion = sessionFactory.openSession() ;
		Query query = sesion.getNamedQuery("TipoMiembro.findAll");
		List tipomiembro = query.list() ;
		sesion.close() ;
		return tipomiembro;
	}
	/*public TipoMiembro daTipoMiembroById(String Idtipomiembro){
		sesion = sessionFactory.openSession() ;
		// Retorna la instancia persistente de la clase por medio del atributo identidad
		TipoMiembro id = (TipoMiembro) sesion.get(TipoMiembro.class,new String(Idtipomiembro)) ;
		sesion.close() ;
		return id ;
	}*/	
	
	public TipoMiembro daTipoMiembroByDesc(String descripcion) {
		sesion = sessionFactory.openSession() ;
		Query query = sesion.getNamedQuery("TipoMiembro.findByDesc");
		query.setParameter("descripcion", descripcion);
		TipoMiembro tipomiembro = (TipoMiembro) query.uniqueResult();
		sesion.close() ;
		return tipomiembro;
	}

}
