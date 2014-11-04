package dao;

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
	
	public Miembrojrv daMiembroByNombres(String nombres) {
		sesion = sessionFactory.openSession() ;
		Query query = sesion.getNamedQuery("Miembrojrv.findByNombres");
		query.setParameter("nombres", nombres);
		Miembrojrv miembrojrv = (Miembrojrv) query.uniqueResult();
		sesion.close() ;
		return miembrojrv;
	}
}
