package ni.org.ics.estudios.cohorte.muestreoanual.service;

import java.sql.Timestamp;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;
import javax.annotation.Resource;

import ni.org.ics.estudios.cohorte.muestreoanual.domain.LabBHC;

import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

/**
 * Servicio para el objeto LabBHC
 * 
 * @author Brenda Lopez
 * 
 **/

@Service("labBhcService")
@Transactional
public class LabBHCService {
	
	@Resource(name="sessionFactory")
	private SessionFactory sessionFactory;
	
	
	/**
	 * Regresa todos las BHC
	 * 
	 * @return una lista de <code>LabBHC</code>(s)
	 */

	@SuppressWarnings("unchecked")
	public List<LabBHC> getLabBHCs() {
		// Retrieve session from Hibernate
		Session session = sessionFactory.getCurrentSession();
		// Create a Hibernate query (HQL)
		Query query = session.createQuery("FROM LabBHC");
		// Retrieve all
		return  query.list();
	}
	
	@SuppressWarnings("unchecked")
	public List<LabBHC> getLabBHCsHoy() {
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
		Query query = session.createQuery("FROM LabBHC bhc where bhc.labBhcId.fechaRecBHC = :fechaBHC");
		query.setTimestamp("fechaBHC", timeStamp);
		// Retrieve all
		return  query.list();
	}
	
	@SuppressWarnings("unchecked")
	public List<LabBHC> getCompBHCLabSupHoy() {
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
		Query query = session.createSQLQuery("select labbhc.codigo, labbhc.fecha_registro, labbhc.volbhc, labbhc.observacion, labbhc.username " +
				"from labbhc left join recepcionbhc on labbhc.codigo = recepcionbhc.codigo and labbhc.fecha_bhc = recepcionbhc.fecha_bhc	" +
				"where ((labbhc.fecha_bhc = :fechaBHC) and (recepcionbhc.codigo Is Null or labbhc.fecha_bhc <> recepcionbhc.fecha_bhc));");
		query.setTimestamp("fechaBHC", timeStamp);
		// Retrieve all
		return  query.list();
	}
	
	@SuppressWarnings("unchecked")
	public List<LabBHC> getCompBHCLabEstHoy() {
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
		Query query = session.createSQLQuery("select labbhc.codigo, labbhc.fecha_registro, labbhc.volbhc, labbhc.observacion, labbhc.username	" +
				"from labbhc left join muestras on labbhc.codigo = muestras.codigo and muestras.fecha_registro = labbhc.fecha_bhc " +
				"where ((labbhc.fecha_bhc = :fechaBHC) and (muestras.codigo Is Null or labbhc.fecha_bhc <> muestras.fecha_registro or muestras.tubobhc=0));");
		query.setTimestamp("fechaBHC", timeStamp);
		// Retrieve all
		return  query.list();
	}
}
