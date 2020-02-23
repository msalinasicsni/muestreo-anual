package ni.org.ics.estudios.cohorte.muestreoanual.service;

import java.sql.Timestamp;
import java.util.List;
import javax.annotation.Resource;

import ni.org.ics.estudios.cohorte.muestreoanual.domain.Pinchazo;
import ni.org.ics.estudios.cohorte.muestreoanual.domain.PinchazoId;

import ni.org.ics.estudios.cohorte.muestreoanual.utils.Constants;
import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

/**
 * Servicio para el objeto Pinchazo
 * 
 * @author Brenda Lopez
 * 
 **/

@Service("pinService")
@Transactional
public class PinchazoService {
	
	@Resource(name="sessionFactory")
	private SessionFactory sessionFactory;
	
	
	/**
	 * Regresa todos las Pinchazo
	 * 
	 * @return una lista de <code>Pinchazo</code>(s)
	 */

	@SuppressWarnings("unchecked")
	public List<Pinchazo> getPinchazo() {
		// Retrieve session from Hibernate
		Session session = sessionFactory.getCurrentSession();
		// Create a Hibernate query (HQL)
		Query query = session.createQuery("FROM Pinchazo where year(pinId.fechaPinchazo) = :anio");
		query.setInteger("anio", Constants.ANIOMUESTREO);
		// Retrieve all
		return  query.list();
	}
	
	@SuppressWarnings("unchecked")
	public List<Object> getCountPinchazos() {
		// Retrieve session from Hibernate
		Session session = sessionFactory.getCurrentSession();
		// Create a Hibernate query (HQL)
		Query query = session.createSQLQuery("SELECT DATE(fecha_pin), COUNT(codigo) AS Total FROM pinchazos WHERE YEAR(fecha_pin) = :anio GROUP BY DATE(fecha_pin);");
		query.setInteger("anio", Constants.ANIOMUESTREO);
		// Retrieve all
		return  query.list();
	}
	
	/**
	 * Regresa una Pinchazo
	 * 
	 * @return un <code>Pinchazo</code>
	 */

	public Pinchazo getPinchazo(PinchazoId pinId) {
		// Retrieve session from Hibernate
		Session session = sessionFactory.getCurrentSession();
		Timestamp timeStamp = new Timestamp(pinId.getFechaPinchazo().getTime());
		Query query = session.createQuery("FROM Pinchazo pin where pin.pinId.codigo = "
				+ pinId.getCodigo() +  " AND pin.pinId.fechaPinchazo = :fechaPinchazo");
		query.setTimestamp("fechaPinchazo", timeStamp);
		
		Pinchazo pinchazo = (Pinchazo) query.uniqueResult();
		return pinchazo;
	}
	
	/**
	 * Verifica una Pinchazo
	 * 
	 * @return true or false
	 */

	public Boolean checkPinchazo(PinchazoId pinId) {
		// Retrieve session from Hibernate
		Session session = sessionFactory.getCurrentSession();
		
		Timestamp timeStamp = new Timestamp(pinId.getFechaPinchazo().getTime());
		Query query = session.createQuery("FROM Pinchazo pin where pin.pinId.codigo = "
				+ pinId.getCodigo() +  " AND pin.pinId.fechaPinchazo = :fechaPinchazo");
		query.setTimestamp("fechaPinchazo", timeStamp);
		
		Pinchazo pinchazo = (Pinchazo) query.uniqueResult();
		if(pinchazo!=null){
			return true;
		}
		else{
			return false;
		}
			
	}
	
	/**
	 * Agrega un Pinchazo
	 * 
	 * 
	 */
	public void addPinchazo(Pinchazo pinchazo) {
		Session session = sessionFactory.getCurrentSession();
		session.save(pinchazo);
	}
	
	/**
	 * Actualiza un Pinchazo
	 * 
	 * 
	 */
	public void updatePinchazo(Pinchazo pinchazo) {
		Session session = sessionFactory.getCurrentSession();
		session.update(pinchazo);
	}
	
}
