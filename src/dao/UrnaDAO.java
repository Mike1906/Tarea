package dao;

import java.util.List;
import org.hibernate.HibernateException;
import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import datos.*;
import dominio.*;

public class UrnaDAO {
	
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
	
	public void guardaActualiza(Urna urna) {
		try {
			iniciaOperacion() ;
			sesion.saveOrUpdate(urna) ;
			tx.commit();
			sesion.flush() ;
		} catch (HibernateException he) {
			manejaExcepcion(he) ;
			throw he ;
		} finally {
			sesion.close() ;
		}
	}
	public void eliminar(Urna urna) {
		try {
			iniciaOperacion() ;
			sesion.delete(urna) ;
			tx.commit() ;
			sesion.flush() ;
		} catch (HibernateException he) {
			manejaExcepcion(he) ;
			throw he ;
		} finally {
			sesion.close() ;
		}
	}
	public Urna daUrnaById(int idurna){
		sesion = sessionFactory.openSession() ;
		// Retorna la instancia persistente de la clase por medio del atributo identidad
		Urna id = (Urna) sesion.get(Urna.class,new String()) ;
		sesion.close() ;
		return id ;
	}
	
	public List<Urna> daUrna() {
		sesion = sessionFactory.openSession() ;
		Query query = sesion.getNamedQuery("Urna.findAll");
		List<Urna> urna = query.list() ;
		sesion.close() ;
		return urna;
	}
	


}