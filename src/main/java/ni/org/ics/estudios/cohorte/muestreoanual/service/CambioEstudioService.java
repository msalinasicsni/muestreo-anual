package ni.org.ics.estudios.cohorte.muestreoanual.service;

import java.sql.Timestamp;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;
import javax.annotation.Resource;

import ni.org.ics.estudios.cohorte.muestreoanual.domain.CambioEstudio;
import ni.org.ics.estudios.cohorte.muestreoanual.domain.CambioEstudioId;
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

@Service("cambioEstudioService")
@Transactional
public class CambioEstudioService {
	
	@Resource(name="sessionFactory")
	private SessionFactory sessionFactory;
	
	
	/**
	 * Regresa todos las CambioEstudio
	 * 
	 * @return una lista de <code>CambioEstudio</code>(s)
	 */

	@SuppressWarnings("unchecked")
	public List<CambioEstudio> getCambioEstudio() {
		// Retrieve session from Hibernate
		Session session = sessionFactory.getCurrentSession();
		// Create a Hibernate query (HQL)
		Query query = session.createQuery("FROM CambioEstudio");
		// Retrieve all
		return  query.list();
	}
	
	/**
	 * Regresa todos las CambioEstudio de hoy
	 * 
	 * @return una lista de <code>CambioEstudio</code>(s)
	 */

	@SuppressWarnings("unchecked")
	public List<CambioEstudio> getCambioEstudioHoy() {
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
		Query query = session.createQuery("FROM CambioEstudio cambio where cambio.movilInfo.today = :fechaHoy");
		query.setTimestamp("fechaHoy", timeStamp);
		// Retrieve all
		return  query.list();
	}
	
	/**
	 * Regresa una CambioEstudio
	 * 
	 * @return un <code>CambioEstudio</code>
	 */

	public CambioEstudio getCambioEstudio(CambioEstudioId camestId) {
		// Retrieve session from Hibernate
		Session session = sessionFactory.getCurrentSession();
		Timestamp timeStamp = new Timestamp(camestId.getFechaCambio().getTime());
		Query query = session.createQuery("FROM CambioEstudio cs where cs.cambioEstudioId.codigo = " + camestId.getCodigo() + " AND cs.cambioEstudioId.fechaCambio = :fechaC");
		query.setTimestamp("fechaC", timeStamp);
		
		CambioEstudio cambio = (CambioEstudio) query.uniqueResult();
		return cambio;
	}
	
	/**
	 * Verifica una CambioEstudio
	 * 
	 * @return true or false
	 */

	public Boolean checkCambioEstudio(CambioEstudioId camestId) {
		// Retrieve session from Hibernate
		Session session = sessionFactory.getCurrentSession();
		
		Timestamp timeStamp = new Timestamp(camestId.getFechaCambio().getTime());
		Query query = session.createQuery("FROM CambioEstudio cs where cs.cambioEstudioId.codigo = " + camestId.getCodigo() + " AND cs.cambioEstudioId.fechaCambio = :fechaC");
		query.setTimestamp("fechaC", timeStamp);
		
		CambioEstudio cs = (CambioEstudio) query.uniqueResult();
		if(cs!=null){
			return true;
		}
		else{
			return false;
		}
			
	}
	
	/**
	 * Agrega un CambioEstudio
	 * 
	 * 
	 */
	public void addCambioEstudio(CambioEstudio cs) {
		Session session = sessionFactory.getCurrentSession();
		session.save(cs);
	}
	
	/**
	 * Actualiza un CambioEstudio
	 * 
	 * 
	 */
	public void updateCambioEstudio(CambioEstudio cs) {
		Session session = sessionFactory.getCurrentSession();
		session.update(cs);
	}
	
}
