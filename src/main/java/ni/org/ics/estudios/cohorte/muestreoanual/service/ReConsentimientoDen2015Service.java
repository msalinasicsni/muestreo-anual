package ni.org.ics.estudios.cohorte.muestreoanual.service;

import java.sql.Timestamp;
import java.util.List;
import javax.annotation.Resource;

import ni.org.ics.estudios.cohorte.muestreoanual.domain.ReConsentimientoDen2015;
import ni.org.ics.estudios.cohorte.muestreoanual.domain.ReConsentimientoDen2015Id;


import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

/**
 * Servicio para el objeto ReConsentimientoDen
 * 
 * @author Brenda Lopez
 * 
 **/

@Service("reconsentimiento2015Service")
@Transactional
public class ReConsentimientoDen2015Service {
	
	@Resource(name="sessionFactory")
	private SessionFactory sessionFactory;
	
	
	/**
	 * Regresa todos las ReConsentimiento
	 * 
	 * @return una lista de <code>ReConsentimientoDen</code>(s)
	 */

	@SuppressWarnings("unchecked")
	public List<ReConsentimientoDen2015> getReConsentimientos() {
		// Retrieve session from Hibernate
		Session session = sessionFactory.getCurrentSession();
		// Create a Hibernate query (HQL)
		Query query = session.createQuery("FROM ReConsentimientoDen2015");
		// Retrieve all
		return  query.list();
	}
	
	
	/**
	 * Regresa una ReConsentimientoDen
	 * 
	 * @return un <code>ReConsentimientoDen</code>
	 */

	public ReConsentimientoDen2015 getReConsentimiento(ReConsentimientoDen2015Id reconsId) {
		// Retrieve session from Hibernate
		Session session = sessionFactory.getCurrentSession();
		Timestamp timeStamp = new Timestamp(reconsId.getFechaCons().getTime());
		Query query = session.createQuery("FROM ReConsentimientoDen2015 recons where recons.reconsdenId.codigo = " + reconsId.getCodigo() + " AND recons.reconsdenId.fechaCons = :fechaC");
		query.setTimestamp("fechaC", timeStamp);
		
		ReConsentimientoDen2015 reconsentimiento = (ReConsentimientoDen2015) query.uniqueResult();
		return reconsentimiento;
	}
	
	/**
	 * Verifica una ReConsentimientoDen
	 * 
	 * @return true or false
	 */

	public Boolean checkReConsentimiento(ReConsentimientoDen2015Id reconsId) {
		// Retrieve session from Hibernate
		Session session = sessionFactory.getCurrentSession();
		
		Timestamp timeStamp = new Timestamp(reconsId.getFechaCons().getTime());
		Query query = session.createQuery("FROM ReConsentimientoDen2015 recons where recons.reconsdenId.codigo = " + reconsId.getCodigo() + " AND recons.reconsdenId.fechaCons = :fechaC");
		query.setTimestamp("fechaC", timeStamp);
		
		ReConsentimientoDen2015 reconsentimiento = (ReConsentimientoDen2015) query.uniqueResult();
		if(reconsentimiento!=null){
			return true;
		}
		else{
			return false;
		}
			
	}
	
	/**
	 * Agrega un ReConsentimientoDen
	 * 
	 * 
	 */
	public void addReConsentimiento(ReConsentimientoDen2015 recons) {
		Session session = sessionFactory.getCurrentSession();
		session.save(recons);
	}
	
	/**
	 * Actualiza un ReConsentimientoDen
	 * 
	 * 
	 */
	public void updateReConsentimiento(ReConsentimientoDen2015 recons) {
		Session session = sessionFactory.getCurrentSession();
		session.update(recons);
	}
	
}
