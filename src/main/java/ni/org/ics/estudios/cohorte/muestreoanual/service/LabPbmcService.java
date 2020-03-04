package ni.org.ics.estudios.cohorte.muestreoanual.service;

import java.sql.Timestamp;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;
import javax.annotation.Resource;

import ni.org.ics.estudios.cohorte.muestreoanual.domain.LabPbmc;

import ni.org.ics.estudios.cohorte.muestreoanual.utils.Constants;
import org.hibernate.Query;
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

@Service("labPbmcService")
@Transactional
public class LabPbmcService {
	
	@Resource(name="sessionFactory")
	private SessionFactory sessionFactory;
	
	
	/**
	 * Regresa todos las Sero
	 * 
	 * @return una lista de <code>RecepcionSero</code>(s)
	 */

	@SuppressWarnings("unchecked")
	public List<LabPbmc> getLabPbmcs() {
		// Retrieve session from Hibernate
		Session session = sessionFactory.getCurrentSession();
		// Create a Hibernate query (HQL)
		Query query = session.createQuery("FROM LabPbmc where  YEAR(labPbmcId.fechaRecPbmc) = :anio");
		query.setParameter("anio", Constants.ANIOMUESTREO);
		// Retrieve all
		return  query.list();
	}
	
	
	@SuppressWarnings("unchecked")
	public List<LabPbmc> getLabPbmcsHoy() {
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
		Query query = session.createQuery("FROM LabPbmc pbmc where pbmc.labPbmcId.fechaRecPbmc = :fechaRecPbmc");
		query.setTimestamp("fechaRecPbmc", timeStamp);
		// Retrieve all
		return  query.list();
	}
	
	@SuppressWarnings("unchecked")
	public List<LabPbmc> getCompPbmcLabEstHoy() {
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
		Query query = session.createSQLQuery("select labpbmc.codigo, labpbmc.fecha_registro, labpbmc.volpbmc, labpbmc.observacion, labpbmc.username " +
				"from estudios_ics.labpbmc left join estudios_ics.muestras on labpbmc.codigo = muestras.codigo and labpbmc.fecha_pbmc = muestras.fecha_registro " +
				"where ((labpbmc.fecha_pbmc = :fechaRecPbmc) and (muestras.codigo Is Null or labpbmc.fecha_pbmc <> muestras.fecha_registro or muestras.tuboleu=0) " +
				"and (YEAR(labpbmc.fecha_pbmc) = :anio));");
		query.setTimestamp("fechaRecPbmc", timeStamp);
		query.setInteger("anio", Constants.ANIOMUESTREO);
		// Retrieve all
		return  query.list();
	}
	

}
