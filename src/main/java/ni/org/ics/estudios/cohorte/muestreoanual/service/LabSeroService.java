package ni.org.ics.estudios.cohorte.muestreoanual.service;

import java.sql.Timestamp;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;
import javax.annotation.Resource;

import ni.org.ics.estudios.cohorte.muestreoanual.domain.LabSero;

import ni.org.ics.estudios.cohorte.muestreoanual.utils.Constants;
import org.hibernate.Query;
import org.hibernate.QueryException;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

/**
 * Servicio para el objeto RecepcionSero
 * 
 * @author Brenda Lopez
 * 
 **/

@Service("labSeroService")
@Transactional
public class LabSeroService {
	
	@Resource(name="sessionFactory")
	private SessionFactory sessionFactory;
	
	
	/**
	 * Regresa todos las Sero
	 * 
	 * @return una lista de <code>RecepcionSero</code>(s)
	 */

	@SuppressWarnings("unchecked")
	public List<LabSero> getLabSeros() {
		// Retrieve session from Hibernate
		Session session = sessionFactory.getCurrentSession();
		// Create a Hibernate query (HQL)
		Query query = session.createQuery("FROM LabSero where YEAR(labSeroId.fechaRecSero) = :anio ");
		query.setParameter("anio", Constants.ANIOMUESTREO);
		// Retrieve all
		return  query.list();
	}
	
	@SuppressWarnings("unchecked")
	public List<LabSero> getLabSerosHoy() {
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
		Query query = session.createQuery("FROM LabSero sero where sero.labSeroId.fechaRecSero = :fechaRecSero");
		query.setTimestamp("fechaRecSero", timeStamp);
		// Retrieve all
		return  query.list();
	}
	
	
	@SuppressWarnings("unchecked")
	public List<LabSero> getCompSeroLabSupHoy() {
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
		Query query = session.createSQLQuery("select labsero.codigo, labsero.fecha_registro, labsero.volsero, labsero.observacion, labsero.username	" +
				"from estudios_ics.labsero left join estudios_ics.recepcionsero on labsero.codigo = recepcionsero.codigo and labsero.fecha_sero = recepcionsero.fecha_sero " +
				"where ((labsero.fecha_sero = :fechaRecSero) and (recepcionsero.codigo Is Null or labsero.fecha_sero <> recepcionsero.fecha_sero) " +
				"and (YEAR(labsero.fecha_sero) = :anio AND YEAR(recepcionsero.fecha_sero) = :anio));");
		query.setTimestamp("fechaRecSero", timeStamp);
		query.setInteger("anio", Constants.ANIOMUESTREO);
		// Retrieve all
		return  query.list();
	}
	
	
	@SuppressWarnings("unchecked")
	public List<LabSero> getCompSeroLabEstHoy() {
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
		Query query = session.createSQLQuery("select labsero.codigo, labsero.fecha_registro, labsero.volsero, labsero.observacion, labsero.username	" +
				"from estudios_ics.labsero left join estudios_ics.muestras on labsero.codigo = muestras.codigo and labsero.fecha_sero = muestras.fecha_registro " +
				"where ((labsero.fecha_sero = :fechaRecSero) and (muestras.codigo Is Null or labsero.fecha_sero <> muestras.fecha_registro or muestras.tuborojo=0) " +
				"and (YEAR(labsero.fecha_sero) = :anio AND YEAR(muestras.fecha_registro) = :anio));");
		query.setTimestamp("fechaRecSero", timeStamp);
		query.setInteger("anio", Constants.ANIOMUESTREO);
		// Retrieve all
		return  query.list();
	}
	

}
