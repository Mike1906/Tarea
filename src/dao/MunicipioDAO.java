package dao;

import java.util.List;
import org.hibernate.HibernateException;
import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;

import datos.*;
import dominio.*;

public class MunicipioDAO {
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
	public void guardaActualiza(Municipio municipio) {
		try {
			iniciaOperacion() ;
			sesion.saveOrUpdate(municipio) ;
			tx.commit();
			sesion.flush() ;
		} catch (HibernateException he) {
			manejaExcepcion(he) ;
			throw he ;
		} finally {
			sesion.close() ;
		}
	}
	public void eliminar(Municipio municipio) {
		try {
			iniciaOperacion() ;
			sesion.delete(municipio) ;
			tx.commit() ;
			sesion.flush() ;
		} catch (HibernateException he) {
			manejaExcepcion(he) ;
			throw he ;
		} finally {
			sesion.close() ;
		}
	}
	public Municipio daMunicipioById(String idmunicipio){
		sesion = sessionFactory.openSession() ;
		// Retorna la instancia persistente de la clase por medio del atributo identidad
		Municipio id = (Municipio) sesion.get(Municipio.class,new String(idmunicipio)) ;
		sesion.close() ;
		return id ;
	}
	
	public List<Municipio> daMunicipio() {
		sesion = sessionFactory.openSession() ;
		Query query = sesion.getNamedQuery("Municipio.findAll");
		List<Municipio> municipio = query.list() ;
		sesion.close() ;
		return municipio;
	}
	
}

