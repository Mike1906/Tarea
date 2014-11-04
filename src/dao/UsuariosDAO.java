package dao;

import java.util.List;
import org.hibernate.HibernateException;
import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import datos.HibernateUtil;
import dominio.*;

public class UsuariosDAO {
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
	
	public void guardaActualiza(Usuarios usuarios) {
		try {
			iniciaOperacion() ;
			sesion.saveOrUpdate(usuarios) ;
			tx.commit() ;
			sesion.flush() ;
		} catch (HibernateException he) {
			manejaExcepcion(he) ;
			throw he ;
		} finally {
			sesion.close() ;
		}
	}
	public List daUsuarios() {
		sesion = sessionFactory.openSession() ;
		Query query = sesion.getNamedQuery("Usuarios.findAll");
		List usuarios = query.list() ;
		sesion.close() ;
		return usuarios;
	}
	
	public Usuarios daUsuarioByUsername(String username) {
		sesion = sessionFactory.openSession() ;
		Query query = sesion.getNamedQuery("Usuarios.findByUsername");
		query.setParameter("username", username);
		Usuarios usuarios = (Usuarios) query.uniqueResult();
		sesion.close() ;
		return usuarios;
	}
}
