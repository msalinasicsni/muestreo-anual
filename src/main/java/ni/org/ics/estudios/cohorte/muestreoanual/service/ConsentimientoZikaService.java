package ni.org.ics.estudios.cohorte.muestreoanual.service;

import java.sql.Timestamp;
import java.util.List;
import javax.annotation.Resource;

import ni.org.ics.estudios.cohorte.muestreoanual.domain.ConsentimientoZika;
import ni.org.ics.estudios.cohorte.muestreoanual.domain.ConsentimientoZikaId;
import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

/**
 * Servicio para el objeto ConsentimientoZika
 * 
 * @author Brenda Lopez
 * 
 **/

@Service("consentimientoZikaService")
@Transactional
public class ConsentimientoZikaService {
	
	@Resource(name="sessionFactory")
	private SessionFactory sessionFactory;
	
	
	/**
	 * Regresa todos las ConsentimientoZika
	 * 
	 * @return una lista de <code>ConsentimientoZika</code>(s)
	 */

	@SuppressWarnings("unchecked")
	public List<ConsentimientoZika> getConsentimientoZika() {
		// Retrieve session from Hibernate
		Session session = sessionFactory.getCurrentSession();
		// Create a Hibernate query (HQL)
		Query query = session.createQuery("FROM ConsentimientoZika");
		// Retrieve all
		return  query.list();
	}
	
	
	/**
	 * Regresa una ConsentimientoZika
	 * 
	 * @return un <code>ConsentimientoZika</code>
	 */

	public ConsentimientoZika getConsentimientoZika(ConsentimientoZikaId consZikaId) {
		// Retrieve session from Hibernate
		Session session = sessionFactory.getCurrentSession();
		Timestamp timeStamp = new Timestamp(consZikaId.getFechaCons().getTime());
		Query query = session.createQuery("FROM ConsentimientoZika cons where cons.consZikaId.codigo = " + consZikaId.getCodigo() + " AND cons.consZikaId.fechaCons = :fechaC");
		query.setTimestamp("fechaC", timeStamp);
		
		ConsentimientoZika consZika = (ConsentimientoZika) query.uniqueResult();
		return consZika;
	}
	
	/**
	 * Verifica una ConsentimientoZika
	 * 
	 * @return true or false
	 */

	public Boolean checkConsentimientoZika(ConsentimientoZikaId consId) {
		// Retrieve session from Hibernate
		Session session = sessionFactory.getCurrentSession();
		
		Timestamp timeStamp = new Timestamp(consId.getFechaCons().getTime());
		Query query = session.createQuery("FROM ConsentimientoZika cons where cons.consZikaId.codigo = " + consId.getCodigo() + " AND cons.consZikaId.fechaCons = :fechaC");
		query.setTimestamp("fechaC", timeStamp);
		
		ConsentimientoZika consentimiento = (ConsentimientoZika) query.uniqueResult();
		if(consentimiento!=null){
			return true;
		}
		else{
			return false;
		}
			
	}
	
	/**
	 * Agrega un ConsentimientoZika
	 * 
	 * 
	 */
	public void addConsentimientoZika(ConsentimientoZika cons) {
		Session session = sessionFactory.getCurrentSession();
		session.save(cons);
	}
	
	/**
	 * Actualiza un ConsentimientoZika
	 * 
	 * 
	 */
	public void updateConsentimientoZika(ConsentimientoZika cons) {
		Session session = sessionFactory.getCurrentSession();
		session.update(cons);
	}
	
}
