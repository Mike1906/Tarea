package dao;

import java.util.List;
import org.hibernate.HibernateException;
import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;

import datos.*;
import dominio.*;

public class MiembrojrvDAO {

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
		throw new HibernateException("Ocurrió un error en la capa DAO", he);
	}
	
	public void guardaActualiza(Miembrojrv miembrojrv) {
		try {
			iniciaOperacion() ;
			sesion.saveOrUpdate(miembrojrv) ;
			tx.commit();
			sesion.flush() ;
		} catch (HibernateException he) {
			manejaExcepcion(he) ;
			throw he ;
		} finally {
			sesion.close() ;
		}
	}
	public void eliminar(Miembrojrv miembro) {
		try {
			iniciaOperacion() ;
			sesion.delete(miembro) ;
			tx.commit() ;
			sesion.flush() ;
		} catch (HibernateException he) {
			manejaExcepcion(he) ;
			throw he ;
		} finally {
			sesion.close() ;
		}
	}
	public Miembrojrv daMiembroById(String idmiembrojrv){
		sesion = sessionFactory.openSession() ;
		// Retorna la instancia persistente de la clase por medio del atributo identidad
		Miembrojrv id = (Miembrojrv) sesion.get(Miembrojrv.class,new String(idmiembrojrv)) ;
		sesion.close() ;
		return id ;
	}
	
	public List<Miembrojrv> daMiembrojrv() {
		sesion = sessionFactory.openSession() ;
		Query query = sesion.getNamedQuery("Miembrojrv.findAll");
		List<Miembrojrv> miembro = query.list() ;
		sesion.close() ;
		return miembro;
	}
	
	public Miembrojrv daMiembroByNombres(String nombres) {
		sesion = sessionFactory.openSession() ;
		Query query = sesion.getNamedQuery("Miembrojrv.findByNombres");
		query.setParameter("nombres", nombres);
		Miembrojrv miembrojrv = (Miembrojrv) query.uniqueResult();
		sesion.close() ;
		return miembrojrv;
	}
}
