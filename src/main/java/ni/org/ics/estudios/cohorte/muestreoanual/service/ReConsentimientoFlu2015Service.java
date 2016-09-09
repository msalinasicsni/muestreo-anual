package ni.org.ics.estudios.cohorte.muestreoanual.service;

import java.sql.Timestamp;
import java.util.List;
import javax.annotation.Resource;

import ni.org.ics.estudios.cohorte.muestreoanual.domain.ReConsentimientoFlu2015;
import ni.org.ics.estudios.cohorte.muestreoanual.domain.ReConsentimientoFlu2015Id;


import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

/**
 * Servicio para el objeto ReConsentimientoFlu
 * 
 * @author Brenda Lopez
 * 
 **/

@Service("reConsentimientoFlu2015Service")
@Transactional
public class ReConsentimientoFlu2015Service {
	
	@Resource(name="sessionFactory")
	private SessionFactory sessionFactory;
	
	
	/**
	 * Regresa todos las ReConsentimiento
	 * 
	 * @return una lista de <code>ReConsentimientoFlu2015</code>(s)
	 */

	@SuppressWarnings("unchecked")
	public List<ReConsentimientoFlu2015> getReConsentimientos() {
		// Retrieve session from Hibernate
		Session session = sessionFactory.getCurrentSession();
		// Create a Hibernate query (HQL)
		Query query = session.createQuery("FROM ReConsentimientoFlu2015");
		// Retrieve all
		return  query.list();
	}
	
	
	/**
	 * Regresa una ReConsentimientoFlu2015
	 * 
	 * @return un <code>ReConsentimientoFlu2015</code>
	 */

	public ReConsentimientoFlu2015 getReConsentimiento(ReConsentimientoFlu2015Id reconsId) {
		// Retrieve session from Hibernate
		Session session = sessionFactory.getCurrentSession();
		Timestamp timeStamp = new Timestamp(reconsId.getFechaCons().getTime());
		Query query = session.createQuery("FROM ReConsentimientoFlu2015 recons where recons.reconsfluId.codigo = " + reconsId.getCodigo() + " AND recons.reconsfluId.fechaCons = :fechaC");
		query.setTimestamp("fechaC", timeStamp);
		
		ReConsentimientoFlu2015 reconsentimiento = (ReConsentimientoFlu2015) query.uniqueResult();
		return reconsentimiento;
	}
	
	/**
	 * Verifica una ReConsentimientoFlu2015
	 * 
	 * @return true or false
	 */

	public Boolean checkReConsentimiento(ReConsentimientoFlu2015Id reconsId) {
		// Retrieve session from Hibernate
		Session session = sessionFactory.getCurrentSession();
		
		Timestamp timeStamp = new Timestamp(reconsId.getFechaCons().getTime());
		Query query = session.createQuery("FROM ReConsentimientoFlu2015 recons where recons.reconsfluId.codigo = " + reconsId.getCodigo() + " AND recons.reconsfluId.fechaCons = :fechaC");
		query.setTimestamp("fechaC", timeStamp);
		
		ReConsentimientoFlu2015 reconsentimiento = (ReConsentimientoFlu2015) query.uniqueResult();
		if(reconsentimiento!=null){
			return true;
		}
		else{
			return false;
		}
			
	}
	
	/**
	 * Agrega un ReConsentimientoFlu2015
	 * 
	 * 
	 */
	public void addReConsentimiento(ReConsentimientoFlu2015 recons) {
		Session session = sessionFactory.getCurrentSession();
		session.save(recons);
	}
	
	/**
	 * Actualiza un ReConsentimientoFlu2015
	 * 
	 * 
	 */
	public void updateReConsentimiento(ReConsentimientoFlu2015 recons) {
		Session session = sessionFactory.getCurrentSession();
		session.update(recons);
	}
	
}
