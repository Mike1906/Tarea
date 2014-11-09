package dao;

import java.util.List;
import org.hibernate.HibernateException;
import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;

import datos.*;
import dominio.*;

public class DepartamentoDAO {
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
	
	public void guardaActualiza(Departamento departamento) {
		try {
			iniciaOperacion() ;
			sesion.saveOrUpdate(departamento) ;
			tx.commit();
			sesion.flush() ;
		} catch (HibernateException he) {
			manejaExcepcion(he) ;
			throw he ;
		} finally {
			sesion.close() ;
		}
	}
	public void eliminar(Departamento departamento) {
		try {
			iniciaOperacion() ;
			sesion.delete(departamento) ;
			tx.commit() ;
			sesion.flush() ;
		} catch (HibernateException he) {
			manejaExcepcion(he) ;
			throw he ;
		} finally {
			sesion.close() ;
		}
	}
	public Departamento daDepartamentoById(String iddepto){
		sesion = sessionFactory.openSession() ;
		// Retorna la instancia persistente de la clase por medio del atributo identidad
		Departamento id = (Departamento) sesion.get(Departamento.class,new String(iddepto)) ;
		sesion.close() ;
		return id ;
	}
	
	public List<Departamento> daDepartamento() {
		sesion = sessionFactory.openSession() ;
		Query query = sesion.getNamedQuery("Departamento.findAll");
		List<Departamento> departamento = query.list() ;
		sesion.close() ;
		return departamento;
	}
	
	public Departamento daDepartamentoByNombres(String nombres) {
		sesion = sessionFactory.openSession() ;
		Query query = sesion.getNamedQuery("Departamento.findByNombres");
		query.setParameter("nombres", nombres);
		Departamento departamento = (Departamento) query.uniqueResult();
		sesion.close() ;
		return departamento;
	}
	
	
}
