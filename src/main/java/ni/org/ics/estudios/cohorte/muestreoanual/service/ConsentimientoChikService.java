package ni.org.ics.estudios.cohorte.muestreoanual.service;

import java.sql.Timestamp;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;
import javax.annotation.Resource;

import ni.org.ics.estudios.cohorte.muestreoanual.domain.ConsentimientoChik;
import ni.org.ics.estudios.cohorte.muestreoanual.domain.ConsentimientoChikId;
import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

/**
 * Servicio para el objeto ConsentimientoChik
 * 
 * @author Brenda Lopez
 * 
 **/

@Service("consentimientoChikService")
@Transactional
public class ConsentimientoChikService {
	
	@Resource(name="sessionFactory")
	private SessionFactory sessionFactory;
	
	
	/**
	 * Regresa todos las ConsentimientoChik
	 * 
	 * @return una lista de <code>ConsentimientoChik</code>(s)
	 */

	@SuppressWarnings("unchecked")
	public List<ConsentimientoChik> getConsentimientoChik() {
		// Retrieve session from Hibernate
		Session session = sessionFactory.getCurrentSession();
		// Create a Hibernate query (HQL)
		Query query = session.createQuery("FROM ConsentimientoChik");
		// Retrieve all
		return  query.list();
	}
	
	/**
	 * Regresa todos las ConsentimientoChik de hoy
	 * 
	 * @return una lista de <code>ConsentimientoChik</code>(s)
	 */

	@SuppressWarnings("unchecked")
	public List<ConsentimientoChik> getConsentimientoChikHoy() {
		// Retrieve session from Hibernate
		Session session = sessionFactory.getCurrentSession();
		SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");      
	    Date dateWithoutTime = null;
		try {
			dateWithoutTime = sdf.parse(sdf.format(new Date()));
		} catch (ParseException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		Timestamp timeStamp = new Timestamp(dateWithoutTime.getTime());
		// Create a Hibernate query (HQL)
		Query query = session.createQuery("FROM ConsentimientoChik cons where cons.movilInfo.today = :fechaHoy");
		query.setTimestamp("fechaHoy", timeStamp);
		// Retrieve all
		return  query.list();
	}
	
	/**
	 * Regresa una ConsentimientoChik
	 * 
	 * @return un <code>ConsentimientoChik</code>
	 */

	public ConsentimientoChik getConsentimientoChik(ConsentimientoChikId consId) {
		// Retrieve session from Hibernate
		Session session = sessionFactory.getCurrentSession();
		Timestamp timeStamp = new Timestamp(consId.getFechaCons().getTime());
		Query query = session.createQuery("FROM ConsentimientoChik cons where cons.consChikId.codigo = " + consId.getCodigo() + " AND cons.consChikId.fechaCons = :fechaC");
		query.setTimestamp("fechaC", timeStamp);
		
		ConsentimientoChik consentimiento = (ConsentimientoChik) query.uniqueResult();
		return consentimiento;
	}
	
	/**
	 * Verifica una ConsentimientoChik
	 * 
	 * @return true or false
	 */

	public Boolean checkConsentimientoChik(ConsentimientoChikId consId) {
		// Retrieve session from Hibernate
		Session session = sessionFactory.getCurrentSession();
		
		Timestamp timeStamp = new Timestamp(consId.getFechaCons().getTime());
		Query query = session.createQuery("FROM ConsentimientoChik cons where cons.consChikId.codigo = " + consId.getCodigo() + " AND cons.consChikId.fechaCons = :fechaC");
		query.setTimestamp("fechaC", timeStamp);
		
		ConsentimientoChik consentimiento = (ConsentimientoChik) query.uniqueResult();
		if(consentimiento!=null){
			return true;
		}
		else{
			return false;
		}
			
	}
	
	/**
	 * Agrega un ConsentimientoChik
	 * 
	 * 
	 */
	public void addConsentimientoChik(ConsentimientoChik cons) {
		Session session = sessionFactory.getCurrentSession();
		session.save(cons);
	}
	
	/**
	 * Actualiza un ConsentimientoChik
	 * 
	 * 
	 */
	public void updateConsentimientoChik(ConsentimientoChik cons) {
		Session session = sessionFactory.getCurrentSession();
		session.update(cons);
	}
	
}
