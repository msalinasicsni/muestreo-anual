package ni.org.ics.estudios.cohorte.muestreoanual.service;

import java.sql.Timestamp;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;
import javax.annotation.Resource;

import ni.org.ics.estudios.cohorte.muestreoanual.domain.TempRojoBhc;
import ni.org.ics.estudios.cohorte.muestreoanual.domain.TempRojoBhcId;

import ni.org.ics.estudios.cohorte.muestreoanual.utils.Constants;
import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

/**
 * Servicio para el objeto TempRojoBhc
 * 
 * @author Brenda Lopez
 * 
 **/

@Service("tRojoBhcService")
@Transactional
public class TempRojoBhcService {
	
	@Resource(name="sessionFactory")
	private SessionFactory sessionFactory;
	
	
	/**
	 * Regresa todos las TempRojoBhc
	 * 
	 * @return una lista de <code>TempRojoBhc</code>(s)
	 */

	@SuppressWarnings("unchecked")
	public List<TempRojoBhc> getTempRojoBhcs() {
		// Retrieve session from Hibernate
		Session session = sessionFactory.getCurrentSession();
		// Create a Hibernate query (HQL)
		Query query = session.createQuery("FROM TempRojoBhc WHERE year(tempRojoBhcId.fechaTempRojoBhc) = :anio");
		query.setInteger("anio", Constants.ANIOMUESTREO);
		// Retrieve all
		return  query.list();
	}
	
	
	@SuppressWarnings("unchecked")
	public List<Object> getStatTempRojos() {
		// Retrieve session from Hibernate
		Session session = sessionFactory.getCurrentSession();
		// Create a Hibernate query (HQL)
		Query query = session.createSQLQuery("SELECT DATE(fecha_temp) as fecha, COUNT(temperatura) AS Cuenta, 2 as LimInf, 10 as LimSup, Min(temperatura) AS Minimo, Avg(temperatura) AS Promedio, Max(temperatura) AS Maximo FROM estudios_ics.temp_rojo_bhc WHERE YEAR(fecha_temp) = :anio GROUP BY DATE(fecha_temp);");
		query.setInteger("anio", Constants.ANIOMUESTREO);
		// Retrieve all
		return  query.list();
	}
	
	/**
	 * Regresa todos las TempRojoBhc de hoy
	 * 
	 * @return una lista de <code>TempRojoBhc</code>(s)
	 */

	@SuppressWarnings("unchecked")
	public List<TempRojoBhc> getTempRojoBhcsHoy() {
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
		Query query = session.createQuery("FROM TempRojoBhc tr where tr.fecreg = :fechaTemp");
		query.setTimestamp("fechaTemp", timeStamp);
		// Retrieve all
		return  query.list();
	}
	
	
	@SuppressWarnings("unchecked")
	public List<TempRojoBhc> getTempRojoBhcsFueradeRango() {
		// Retrieve session from Hibernate
		Session session = sessionFactory.getCurrentSession();
		// Create a Hibernate query (HQL)
		Query query = session.createQuery("FROM TempRojoBhc tr where (tr.temperatura < 2 or tr.temperatura > 8)");
		// Retrieve all
		return  query.list();
	}
	
	
	
	/**
	 * Regresa una TempRojoBhc
	 * 
	 * @return un <code>TempRojoBhc</code>
	 */

	public TempRojoBhc getTempRojoBhc(TempRojoBhcId trojoId) {
		// Retrieve session from Hibernate
		Session session = sessionFactory.getCurrentSession();
		Timestamp timeStamp = new Timestamp(trojoId.getFechaTempRojoBhc().getTime());
		Query query = session.createQuery("FROM TempRojoBhc trojo where trojo.tempRojoBhcId.recurso = '"
				+ trojoId.getRecurso() +  "' AND trojo.tempRojoBhcId.fechaTempRojoBhc = :fechaTempRojoBhc");
		query.setTimestamp("fechaTempRojoBhc", timeStamp);
		
		TempRojoBhc trojo = (TempRojoBhc) query.uniqueResult();
		return trojo;
	}
	
	/**
	 * Verifica una TempRojoBhc
	 * 
	 * @return true or false
	 */

	public Boolean checkTempRojoBhc(TempRojoBhcId trojoId) {
		// Retrieve session from Hibernate
		Session session = sessionFactory.getCurrentSession();
		
		Timestamp timeStamp = new Timestamp(trojoId.getFechaTempRojoBhc().getTime());
		Query query = session.createQuery("FROM TempRojoBhc trojo where trojo.tempRojoBhcId.recurso = '"
				+ trojoId.getRecurso() +  "' AND trojo.tempRojoBhcId.fechaTempRojoBhc = :fechaTempRojoBhc");
		query.setTimestamp("fechaTempRojoBhc", timeStamp);
		
		TempRojoBhc trojo = (TempRojoBhc) query.uniqueResult();
		if(trojo!=null){
			return true;
		}
		else{
			return false;
		}
			
	}
	
	/**
	 * Agrega un TempRojoBhc
	 * 
	 * 
	 */
	public void addTempRojoBhc(TempRojoBhc trojo) {
		Session session = sessionFactory.getCurrentSession();
		session.save(trojo);
	}
	
	/**
	 * Actualiza un TempRojoBhc
	 * 
	 * 
	 */
	public void updateTempRojoBhc(TempRojoBhc trojo) {
		Session session = sessionFactory.getCurrentSession();
		session.update(trojo);
	}
	
}
