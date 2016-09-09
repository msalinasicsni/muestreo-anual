package ni.org.ics.estudios.cohorte.muestreoanual.service;

import java.sql.Timestamp;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;
import javax.annotation.Resource;

import ni.org.ics.estudios.cohorte.muestreoanual.domain.CambioEstudio;
import ni.org.ics.estudios.cohorte.muestreoanual.domain.ConsentimientoChik;
import ni.org.ics.estudios.cohorte.muestreoanual.domain.ReConsentimientoDen;
import ni.org.ics.estudios.cohorte.muestreoanual.domain.ReConsentimientoDenId;

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

@Service("reconsentimientoService")
@Transactional
public class ReConsentimientoDenService {
	
	@Resource(name="sessionFactory")
	private SessionFactory sessionFactory;
	
	
	/**
	 * Regresa todos las ReConsentimiento
	 * 
	 * @return una lista de <code>ReConsentimientoDen</code>(s)
	 */

	@SuppressWarnings("unchecked")
	public List<ReConsentimientoDen> getReConsentimientos() {
		// Retrieve session from Hibernate
		Session session = sessionFactory.getCurrentSession();
		// Create a Hibernate query (HQL)
		Query query = session.createQuery("FROM ReConsentimientoDen");
		// Retrieve all
		return  query.list();
	}
	
	@SuppressWarnings("unchecked")
	public List<ConsentimientoChik> getConsentimientosChik() {
		// Retrieve session from Hibernate
		Session session = sessionFactory.getCurrentSession();
		// Create a Hibernate query (HQL)
		Query query = session.createQuery("FROM ConsentimientoChik");
		// Retrieve all
		return  query.list();
	}
	
	@SuppressWarnings("unchecked")
	public List<Object> getCountConsentimientosChik() {
		// Retrieve session from Hibernate
		Session session = sessionFactory.getCurrentSession();
		// Create a Hibernate query (HQL)
		Query query = session.createSQLQuery("SELECT DATE(fecha_cons), COUNT(codigo) AS Total FROM consentimientochik WHERE partefden=1 GROUP BY DATE(fecha_cons);");
		// Retrieve all
		return  query.list();
	}
	
	@SuppressWarnings("unchecked")
	public List<CambioEstudio> getCambiosEstudio() {
		// Retrieve session from Hibernate
		Session session = sessionFactory.getCurrentSession();
		// Create a Hibernate query (HQL)
		Query query = session.createQuery("FROM CambioEstudio");
		// Retrieve all
		return  query.list();
	}
	
	@SuppressWarnings("unchecked")
	public List<Object> getCountCambios() {
		// Retrieve session from Hibernate
		Session session = sessionFactory.getCurrentSession();
		// Create a Hibernate query (HQL)
		Query query = session.createSQLQuery("SELECT DATE(fecha_cambio), COUNT(codigo) AS Total FROM cambioestudio GROUP BY DATE(fecha_cambio);");
		// Retrieve all
		return  query.list();
	}
	
	/**
	 * Regresa todos las ReConsentimientoDen de hoy
	 * 
	 * @return una lista de <code>ReConsentimientoDen</code>(s)
	 */

	@SuppressWarnings("unchecked")
	public List<ReConsentimientoDen> getReConsentimientoDenHoy() {
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
		Query query = session.createQuery("FROM ReConsentimientoDen recons where recons.movilInfo.today = :fechaHoy");
		query.setTimestamp("fechaHoy", timeStamp);
		// Retrieve all
		return  query.list();
	}
	
	/**
	 * Regresa una ReConsentimientoDen
	 * 
	 * @return un <code>ReConsentimientoDen</code>
	 */

	public ReConsentimientoDen getReConsentimiento(ReConsentimientoDenId reconsId) {
		// Retrieve session from Hibernate
		Session session = sessionFactory.getCurrentSession();
		Timestamp timeStamp = new Timestamp(reconsId.getFechaCons().getTime());
		Query query = session.createQuery("FROM ReConsentimientoDen recons where recons.reconsdenId.codigo = " + reconsId.getCodigo() + " AND recons.reconsdenId.fechaCons = :fechaC");
		query.setTimestamp("fechaC", timeStamp);
		
		ReConsentimientoDen reconsentimiento = (ReConsentimientoDen) query.uniqueResult();
		return reconsentimiento;
	}
	
	/**
	 * Verifica una ReConsentimientoDen
	 * 
	 * @return true or false
	 */

	public Boolean checkReConsentimiento(ReConsentimientoDenId reconsId) {
		// Retrieve session from Hibernate
		Session session = sessionFactory.getCurrentSession();
		
		Timestamp timeStamp = new Timestamp(reconsId.getFechaCons().getTime());
		Query query = session.createQuery("FROM ReConsentimientoDen recons where recons.reconsdenId.codigo = " + reconsId.getCodigo() + " AND recons.reconsdenId.fechaCons = :fechaC");
		query.setTimestamp("fechaC", timeStamp);
		
		ReConsentimientoDen reconsentimiento = (ReConsentimientoDen) query.uniqueResult();
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
	public void addReConsentimiento(ReConsentimientoDen recons) {
		Session session = sessionFactory.getCurrentSession();
		session.save(recons);
	}
	
	/**
	 * Actualiza un ReConsentimientoDen
	 * 
	 * 
	 */
	public void updateReConsentimiento(ReConsentimientoDen recons) {
		Session session = sessionFactory.getCurrentSession();
		session.update(recons);
	}
	
}
