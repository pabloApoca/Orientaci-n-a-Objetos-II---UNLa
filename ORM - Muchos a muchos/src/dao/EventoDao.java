package dao;

	import java.util.List;

import org.hibernate.Hibernate;
	import org.hibernate.HibernateException;
	import org.hibernate.Session;
	import org.hibernate.Transaction;

	import datos.Evento;
	import datos.Evento;

	public class EventoDao {
		
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
		
		public long agregarEvento(Evento objeto) throws HibernateException{
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
		
		public Evento traerEvento(long idEvento) throws HibernateException{
			
			Evento evento= null;
			try{
				iniciaOperacion();
				evento= (Evento) session.createQuery("from Evento e where e.idEvento = "+ idEvento).uniqueResult();
				
			}catch(HibernateException he){
				manejaExcepcion(he);
				throw he;
			}finally{
				session.close();
			}
			
			return evento;
		}
		
		
		public void actualizarEvento(Evento objeto) throws HibernateException{
			
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
		
		public void eliminarEvento(Evento objeto) throws HibernateException{
			
			try{
				iniciaOperacion();
				session.delete(objeto);
				tx.commit();
				
			}catch(HibernateException he){
				manejaExcepcion(he);
				throw he;
			}finally{
				session.close();
			}
			
			
		}
		
		public Evento traerEventoYClientes(long idEvento) throws HibernateException{
			Evento Evento= null;
			
			try{
				iniciaOperacion();
				Evento= (Evento) session.createQuery("from Evento e where e.idEvento= "+idEvento).uniqueResult();
				Hibernate.initialize(Evento.getClientes());
				
			}catch(HibernateException he){
				manejaExcepcion(he);
				throw he;
				
			}finally{
				session.close();
			}
			return Evento;
		}
		
		@SuppressWarnings("unchecked")
		public List<Evento> traerEventos() throws HibernateException{
			List<Evento> eventos=null;
			
			try{
				iniciaOperacion();
				eventos= session.createQuery("from Evento e order by idEvento asc").list();
				
			}catch(HibernateException he){
				manejaExcepcion(he);
				throw he;
			}finally{
				session.close();
			}
			return eventos;
		}


}
