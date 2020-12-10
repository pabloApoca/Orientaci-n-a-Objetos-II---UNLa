package dao;

import org.hibernate.Hibernate;
import org.hibernate.HibernateException;
import org.hibernate.Session;
import org.hibernate.Transaction;
import java.util.List;

import datos.Cliente;
import datos.Evento;

public class ClienteDao {
	
	private static Session session;
	private Transaction tx;
	
	private void iniciaOperacion() throws HibernateException {
		session = HibernateUtil.getSessionFactory().openSession();
		tx = session.beginTransaction();
	}
	
	private void manejaExcepcion(HibernateException he) throws HibernateException {
		tx.rollback();
		throw new HibernateException("ERROR en la capa de acceso a datos", he);
	}
	
	public long agregarCliente(Cliente objeto) throws HibernateException{
		long id=0;
		try{
			iniciaOperacion();
			id= Long.parseLong(session.save(objeto).toString());
			tx.commit();
		}catch(HibernateException he){
			manejaExcepcion(he);
			throw he;
		}finally{
			session.close();
		}
		return id;
	}
	
	public Cliente traerCliente(long idCliente) throws HibernateException{
		
		Cliente cliente= null;
		try{
			iniciaOperacion();
			cliente= (Cliente) session.createQuery("from Cliente c where c.idCliente = "+ idCliente +"and c.baja=0").uniqueResult();
			// si quiero levantar una baja logica tengo q borrar la parte de c.baja=0 , sino no me deja traer
		}catch(HibernateException he){
			manejaExcepcion(he);
			throw he;
		}finally{
			session.close();
		}
		
		return cliente;
	}
	
	public Cliente traerCliente(int dni)throws HibernateException{
		
		Cliente cliente= null;
		try{
			iniciaOperacion();
			cliente= (Cliente) session.createQuery("from Cliente c where c.dni =" + dni + "and c.baja=0").uniqueResult();
		}catch(HibernateException he){
			manejaExcepcion(he);
			throw he;
		}finally{
			session.close();
		}
		return cliente;
	}
	
	public void actualizarCliente(Cliente objeto) throws HibernateException{
		
		try{
			iniciaOperacion();
			session.update(objeto);
			tx.commit();
		}catch(HibernateException he){
			manejaExcepcion(he);
			throw he;
		}finally{
			session.close();
		}
		
	}
	
	public void eliminarCliente(Cliente objeto) throws HibernateException{
		
		try{
			iniciaOperacion();
			objeto.setBaja(true);
			session.update(objeto);
			tx.commit();
			
		}catch(HibernateException he){
			manejaExcepcion(he);
			throw he;
		}finally{
			session.close();
		}
		
		
	}
	
	public Cliente traerClienteYEventos(long idCliente) throws HibernateException{
		Cliente cliente= null;
		
		try{
			iniciaOperacion();
			cliente= (Cliente) session.createQuery("from Cliente c where c.idCliente= "+idCliente).uniqueResult();
			Hibernate.initialize(cliente.getEventos());
			
		}catch(HibernateException he){
			manejaExcepcion(he);
			throw he;
			
		}finally{
			session.close();
		}
		return cliente;
	}
	
	@SuppressWarnings("unchecked")
	public List<Cliente> traerClientes() throws HibernateException{
		List<Cliente> clientes=null;
		
		try{
			iniciaOperacion();
			clientes= session.createQuery("from Cliente c where c.baja=0 order by idCliente asc").list();
			
		}catch(HibernateException he){
			manejaExcepcion(he);
			throw he;
		}finally{
			session.close();
		}
		return clientes;
	}

}
