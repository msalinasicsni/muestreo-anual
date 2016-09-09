package ni.org.ics.estudios.cohorte.muestreoanual.service;

import java.sql.Timestamp;
import java.util.List;
import javax.annotation.Resource;

import ni.org.ics.estudios.cohorte.muestreoanual.domain.VisitaTerreno;
import ni.org.ics.estudios.cohorte.muestreoanual.domain.VisitaTerrenoId;

import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

/**
 * Servicio para el objeto Muestra
 * 
 * @author Brenda Lopez
 * 
 **/

@Service("visitaTerrenoService")
@Transactional
public class VisitaTerrenoService {
	
	@Resource(name="sessionFactory")
	private SessionFactory sessionFactory;
	
	
	/**
	 * Regresa todos las VisitaTerreno
	 * 
	 * @return una lista de <code>VisitaTerreno</code>(s)
	 */

	@SuppressWarnings("unchecked")
	public List<VisitaTerreno> getVisitaTerrenos() {
		// Retrieve session from Hibernate
		Session session = sessionFactory.getCurrentSession();
		// Create a Hibernate query (HQL)
		Query query = session.createQuery("FROM VisitaTerreno");
		// Retrieve all
		return  query.list();
	}
	
	

	public VisitaTerreno getVisitaTerreno(VisitaTerrenoId vtId) {
		// Retrieve session from Hibernate
		Session session = sessionFactory.getCurrentSession();
		Timestamp timeStamp = new Timestamp(vtId.getFechaVisita().getTime());
		Query query = session.createQuery("FROM VisitaTerreno vt where " +
				"vt.visitaId.codigo = " + vtId.getCodigo() + " AND vt.visitaId.fechaVisita = :fechaV");
		query.setTimestamp("fechaV", timeStamp);
		
		VisitaTerreno visita = (VisitaTerreno) query.uniqueResult();
		return visita;
	}
	
	/**
	 * Verifica una VisitaTerreno
	 * 
	 * @return true or false
	 */

	public Boolean checkMuestra(VisitaTerrenoId vtId) {
		// Retrieve session from Hibernate
		Session session = sessionFactory.getCurrentSession();
		Timestamp timeStamp = new Timestamp(vtId.getFechaVisita().getTime());
		Query query = session.createQuery("FROM VisitaTerreno vt where " +
				"vt.visitaId.codigo = " + vtId.getCodigo() + " AND vt.visitaId.fechaVisita = :fechaV");
		query.setTimestamp("fechaV", timeStamp);
		
		VisitaTerreno visita = (VisitaTerreno) query.uniqueResult();
		if(visita!=null){
			return true;
		}
		else{
			return false;
		}
			
	}
	
	/**
	 * Agrega un VisitaTerreno
	 * 
	 * 
	 */
	public void addVisitaTerreno(VisitaTerreno visita) {
		Session session = sessionFactory.getCurrentSession();
		session.save(visita);
	}
	
	/**
	 * Actualiza un VisitaTerreno
	 * 
	 * 
	 */
	public void updateVisitaTerreno(VisitaTerreno visita) {
		Session session = sessionFactory.getCurrentSession();
		session.update(visita);
	}
	
}
