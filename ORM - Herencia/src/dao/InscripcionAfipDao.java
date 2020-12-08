
package dao;

import java.util.List;

import org.hibernate.HibernateException;
import org.hibernate.Session;
import org.hibernate.Transaction;

import datos.InscripcionAfip;

public class InscripcionAfipDao {
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

	public long agregarInscripcionAfip(InscripcionAfip objeto) {
		int id = 0;
		try {
			iniciaOperacion();
			id = Integer.parseInt(session.save(objeto).toString());
			tx.commit();
		} catch (HibernateException he) {
			manejaExcepcion(he);
			throw he;
		} finally {
			session.close();
		}
		return id;
	}

	public InscripcionAfip traerInscripcionAfip(long idInscripcionAfip) throws HibernateException {

		InscripcionAfip objeto = null;
		try {
			iniciaOperacion();
			String hql = "from InscripcionAfip c where c.idInscripcionAfip=" + idInscripcionAfip;
			objeto = (InscripcionAfip) session.createQuery(hql).uniqueResult();
		} finally {
			session.close();
		}
		return objeto;
	}

	

	public void actualizar(InscripcionAfip objeto) throws HibernateException {
		try {
			iniciaOperacion();
			session.update(objeto);
			tx.commit();
		} catch (HibernateException he) {
			manejaExcepcion(he);
			throw he;
		} finally {
			session.close();
		}
	}

	public void eliminar(InscripcionAfip objeto) {
		try {
			iniciaOperacion();
			session.delete(objeto);
			tx.commit();
		} catch (HibernateException he) {
			manejaExcepcion(he);
			throw he;
		} finally {
			session.close();
		}
	}

	@SuppressWarnings("unchecked")
	public List<InscripcionAfip> traerInscripcionAfip() throws HibernateException {
		List<InscripcionAfip> lista = null;
		try {
			iniciaOperacion();
			lista = session.createQuery("from InscripcionAfip c order by c.idInscripcionAfip").list();
		} finally {
			session.close();
		}
		return lista;
	}
}