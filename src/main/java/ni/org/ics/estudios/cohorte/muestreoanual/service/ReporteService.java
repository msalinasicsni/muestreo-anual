package ni.org.ics.estudios.cohorte.muestreoanual.service;

import java.util.List;
import javax.annotation.Resource;

import ni.org.ics.estudios.cohorte.muestreoanual.domain.LabPax;
import ni.org.ics.estudios.cohorte.muestreoanual.domain.TempLab;

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

@Service("reporteService")
@Transactional
public class ReporteService {
	
	@Resource(name="sessionFactory")
	private SessionFactory sessionFactory;
	
	@SuppressWarnings("unchecked")
	public List<Object> getCountRojosLab() {
		// Retrieve session from Hibernate
		Session session = sessionFactory.getCurrentSession();
		// Create a Hibernate query (HQL)
		Query query = session.createSQLQuery("SELECT DATE(fecha_sero), COUNT(codigo) AS Total FROM estudios_ics.labsero WHERE YEAR(fecha_sero) = :anio GROUP BY DATE(fecha_sero);");
		query.setInteger("anio", Constants.ANIOMUESTREO);
		// Retrieve all
		return  query.list();
	}
	
	
	@SuppressWarnings("unchecked")
	public List<TempLab> getTempLab() {
		// Retrieve session from Hibernate
		Session session = sessionFactory.getCurrentSession();
		// Create a Hibernate query (HQL)
		Query query = session.createQuery("From TempLab");
		// Retrieve all
		return  query.list();
	}
	
	@SuppressWarnings("unchecked")
	public List<Object> getStatTempLab() {
		// Retrieve session from Hibernate
		Session session = sessionFactory.getCurrentSession();
		// Create a Hibernate query (HQL)
		Query query = session.createSQLQuery("SELECT DATE(fecha_temp) as fecha, COUNT(temperatura) AS Cuenta, 2 as LimInf, 10 as LimSup, Min(temperatura) AS Minimo, Avg(temperatura) AS Promedio, Max(temperatura) AS Maximo FROM templab GROUP BY DATE(fecha_temp);");
		// Retrieve all
		return  query.list();
	}
	
	@SuppressWarnings("unchecked")
	public List<Object> getCountRojosEst() {
		// Retrieve session from Hibernate
		Session session = sessionFactory.getCurrentSession();
		// Create a Hibernate query (HQL)
		Query query = session.createSQLQuery("SELECT DATE(fecha_muestra), COUNT(codigo) AS Total FROM estudios_ics.muestras WHERE YEAR(fecha_muestra) = :anio AND tuborojo=1 GROUP BY DATE(fecha_muestra);");
		query.setInteger("anio", Constants.ANIOMUESTREO);
		// Retrieve all
		return  query.list();
	}
	
	@SuppressWarnings("unchecked")
	public List<Object> getCountRojosSup() {
		// Retrieve session from Hibernate
		Session session = sessionFactory.getCurrentSession();
		// Create a Hibernate query (HQL)
		Query query = session.createSQLQuery("SELECT DATE(fecha_sero), COUNT(codigo) AS Total FROM estudios_ics.recepcionsero WHERE YEAR(fecha_sero) = :anio GROUP BY DATE(fecha_sero);");
		query.setInteger("anio", Constants.ANIOMUESTREO);
		// Retrieve all
		return  query.list();
	}
	
	@SuppressWarnings("unchecked")
	public List<Object> getCountBHCsLab() {
		// Retrieve session from Hibernate
		Session session = sessionFactory.getCurrentSession();
		// Create a Hibernate query (HQL)
		Query query = session.createSQLQuery("SELECT DATE(fecha_bhc), COUNT(codigo) AS Total FROM estudios_ics.labbhc WHERE YEAR(fecha_bhc) = :anio GROUP BY DATE(fecha_bhc);");
		query.setInteger("anio", Constants.ANIOMUESTREO);
		// Retrieve all
		return  query.list();
	}
	
	@SuppressWarnings("unchecked")
	public List<Object> getCountBHCsEst() {
		// Retrieve session from Hibernate
		Session session = sessionFactory.getCurrentSession();
		// Create a Hibernate query (HQL)
		Query query = session.createSQLQuery("SELECT DATE(fecha_muestra), COUNT(codigo) AS Total FROM estudios_ics.muestras WHERE YEAR(fecha_muestra) = :anio AND tubobhc=1 GROUP BY DATE(fecha_muestra);");
		query.setInteger("anio", Constants.ANIOMUESTREO);
		// Retrieve all
		return  query.list();
	}
	
	@SuppressWarnings("unchecked")
	public List<Object> getCountBHCsSup() {
		// Retrieve session from Hibernate
		Session session = sessionFactory.getCurrentSession();
		// Create a Hibernate query (HQL)
		Query query = session.createSQLQuery("SELECT DATE(fecha_bhc), COUNT(codigo) AS Total FROM estudios_ics.recepcionbhc WHERE YEAR(fecha_bhc) = :anio GROUP BY DATE(fecha_bhc);");
		query.setInteger("anio", Constants.ANIOMUESTREO);
		// Retrieve all
		return  query.list();
	}
	
	@SuppressWarnings("unchecked")
	public List<Object> getCountPBMCsLab() {
		// Retrieve session from Hibernate
		Session session = sessionFactory.getCurrentSession();
		// Create a Hibernate query (HQL)
		Query query = session.createSQLQuery("SELECT DATE(fecha_pbmc), COUNT(codigo) AS Total FROM estudios_ics.labpbmc WHERE YEAR(fecha_pbmc) = :anio GROUP BY DATE(fecha_pbmc);");
		query.setInteger("anio", Constants.ANIOMUESTREO);
		// Retrieve all
		return  query.list();
	}
	
	@SuppressWarnings("unchecked")
	public List<Object> getCountPaxsLab() {
		// Retrieve session from Hibernate
		Session session = sessionFactory.getCurrentSession();
		// Create a Hibernate query (HQL)
		Query query = session.createSQLQuery("SELECT DATE(fecha_pax), COUNT(codigo) AS Total FROM estudios_ics.labpax WHERE YEAR(fecha_pax) = :anio GROUP BY DATE(fecha_pax);");
		query.setInteger("anio", Constants.ANIOMUESTREO);
		// Retrieve all
		return  query.list();
	}
	
	@SuppressWarnings("unchecked")
	public List<LabPax> getLabPax() {
		// Retrieve session from Hibernate
		Session session = sessionFactory.getCurrentSession();
		// Create a Hibernate query (HQL)
		Query query = session.createQuery("From LabPax where YEAR(labPaxId.fechaRecPax) = :anio");
		query.setParameter("anio", Constants.ANIOMUESTREO);
		// Retrieve all
		return  query.list();
	}
	
	@SuppressWarnings("unchecked")
	public List<Object> getCountPBMCsEst() {
		// Retrieve session from Hibernate
		Session session = sessionFactory.getCurrentSession();
		// Create a Hibernate query (HQL)
		Query query = session.createSQLQuery("SELECT DATE(fecha_muestra), COUNT(codigo) AS Total FROM estudios_ics.muestras WHERE YEAR(fecha_muestra) = :anio AND tuboleu=1 GROUP BY DATE(fecha_muestra);");
		query.setInteger("anio", Constants.ANIOMUESTREO);
		// Retrieve all
		return  query.list();
	}
	
	@SuppressWarnings("unchecked")
	public List<Object> getMuestrasxBarrio() {
		// Retrieve session from Hibernate
		Session session = sessionFactory.getCurrentSession();
		// Create a Hibernate query (HQL)
		
		Query query = session.createSQLQuery("DELETE FROM muestrasxdia_barrio;");
		query.executeUpdate();
		query = session.createSQLQuery("INSERT IGNORE INTO muestrasxdia_barrio ( Codigo, fecha, Vol, Obs, Tipo, Fec2 ) " +
				"SELECT labpbmc.Codigo, labpbmc.fecha_pbmc, labpbmc.volpbmc, labpbmc.observacion, 'PBMC' AS Tipo, labpbmc.fecha_registro FROM estudios_ics.labpbmc WHERE (((labpbmc.volpbmc)>0) and YEAR(labpbmc.fecha_pbmc) = "+Constants.ANIOMUESTREO+");");
		query.executeUpdate();
		query = session.createSQLQuery("INSERT IGNORE INTO muestrasxdia_barrio ( Codigo, Tipo, Fecha, Vol, Obs, Fec2 ) " +
				"SELECT labsero.Codigo, 'Rojo' AS Tipo, labsero.fecha_sero, labsero.volsero, labsero.observacion, labsero.fecha_registro FROM estudios_ics.labsero WHERE (((labsero.volsero)>0) and YEAR(labsero.fecha_sero) = "+Constants.ANIOMUESTREO+");");
		query.executeUpdate();
		
		query = session.createSQLQuery("SELECT DISTINCT barrios.nombre, Count(participantes_vw.codigo) AS total, Count(muestrasxdia_barrio.codigo) AS tomadas, " +
				"Count(participantes_vw.codigo) -  Count(muestrasxdia_barrio.codigo) AS faltantes, (Count(muestrasxdia_barrio.codigo))/ Count(participantes_vw.codigo) * 100 as Porcentaje " +
				"FROM (((participantes_vw) INNER JOIN estudios_ics.barrios ON participantes_vw.barrio = barrios.codigo) " +
				"LEFT JOIN muestrasxdia_barrio ON participantes_vw.codigo = muestrasxdia_barrio.codigo) " +
				//"WHERE (((participantes_vw.edad)>=6))  " + //AND ((participantes_vw.est_part)=1) AND ((participantes_vw.codigo)<30000))
				"GROUP BY barrios.nombre;");
		// Retrieve all
		return  query.list();
	}
	
	@SuppressWarnings("unchecked")
	public List<Object> getMuestrasxEdad() {
		// Retrieve session from Hibernate
		Session session = sessionFactory.getCurrentSession();
		// Create a Hibernate query (HQL)
		
		Query query = session.createSQLQuery("DELETE FROM muestrasxdia_barrio;");
		query.executeUpdate();
		query = session.createSQLQuery("INSERT IGNORE INTO muestrasxdia_barrio ( Codigo, fecha, Vol, Obs, Tipo, Fec2 ) " +
				"SELECT labpbmc.Codigo, labpbmc.fecha_pbmc, labpbmc.volpbmc, labpbmc.observacion, 'PBMC' AS Tipo, labpbmc.fecha_registro FROM estudios_ics.labpbmc WHERE (((labpbmc.volpbmc)>0)) and YEAR(fecha_pbmc) = "+Constants.ANIOMUESTREO+";");
		query.executeUpdate();
		query = session.createSQLQuery("INSERT IGNORE INTO muestrasxdia_barrio ( Codigo, Tipo, Fecha, Vol, Obs, Fec2 ) " +
				"SELECT labsero.Codigo, 'Rojo' AS Tipo, labsero.fecha_sero, labsero.volsero, labsero.observacion, labsero.fecha_registro FROM estudios_ics.labsero WHERE (((labsero.volsero)>0)) and YEAR(fecha_sero) = "+Constants.ANIOMUESTREO+";");
		query.executeUpdate();
		
		query = session.createSQLQuery("SELECT participantes_vw.edad AS e, Count(participantes_vw.codigo) AS total, " +
				"Count(muestrasxdia_barrio.codigo) AS tomadas, Count(participantes_vw.codigo) -  Count(muestrasxdia_barrio.codigo) AS faltantes, " +
				"(Count(muestrasxdia_barrio.codigo))/ Count(participantes_vw.codigo) * 100 as Porcentaje " +
				"FROM (((participantes_vw)) LEFT JOIN muestrasxdia_barrio ON participantes_vw.codigo = muestrasxdia_barrio.codigo) " +
				//"WHERE (((participantes_vw.edad)>=6) ) " + //AND ((participantes_vw. est_part)=1) AND ((participantes_vw.codigo)<30000)
				//"GROUP BY TRUNCATE(DATEDIFF(DATE(NOW()),participantes_vw.fechanac) / 365.25,0);");
				"GROUP BY participantes_vw.edad;");
		// Retrieve all
		return  query.list();
	}
	
	@SuppressWarnings("unchecked")
	public List<Object> getMuestrasxEstudio() {
		// Retrieve session from Hibernate
		Session session = sessionFactory.getCurrentSession();
		// Create a Hibernate query (HQL)
		
		Query query = session.createSQLQuery("DELETE FROM muestrasxdia_barrio;");
		query.executeUpdate();
		query = session.createSQLQuery("INSERT IGNORE INTO muestrasxdia_barrio ( Codigo, fecha, Vol, Obs, Tipo, Fec2 ) " +
				"SELECT labpbmc.Codigo, labpbmc.fecha_pbmc, labpbmc.volpbmc, labpbmc.observacion, 'PBMC' AS Tipo, labpbmc.fecha_registro FROM estudios_ics.labpbmc WHERE (((labpbmc.volpbmc)>0)) and YEAR(fecha_pbmc) = "+Constants.ANIOMUESTREO+";");
		query.executeUpdate();
		query = session.createSQLQuery("INSERT IGNORE INTO muestrasxdia_barrio ( Codigo, Tipo, Fecha, Vol, Obs, Fec2 ) " +
				"SELECT labsero.Codigo, 'Rojo' AS Tipo, labsero.fecha_sero, labsero.volsero, labsero.observacion, labsero.fecha_registro FROM estudios_ics.labsero WHERE (((labsero.volsero)>0)) and YEAR(fecha_sero) = "+Constants.ANIOMUESTREO+";");
		query.executeUpdate();
		
		query = session.createSQLQuery("SELECT DISTINCT estudio, Count(participantes_vw.codigo) AS total, Count(muestrasxdia_barrio.codigo) AS tomadas, " +
				"Count(participantes_vw.codigo) -  Count(muestrasxdia_barrio.codigo) AS faltantes, (Count(muestrasxdia_barrio.codigo))/ Count(participantes_vw.codigo) * 100 as Porcentaje " +
				"FROM (((participantes_vw)) LEFT JOIN muestrasxdia_barrio ON participantes_vw.codigo = muestrasxdia_barrio.codigo) " +
				//"WHERE (((participantes_vw.edad)>=6) ) " + //AND ((participantes_vw.est_part)=1) AND ((participantes_vw.codigo)<30000)
				"GROUP BY estudio;");
		// Retrieve all
		return  query.list();
	}
	
	@SuppressWarnings("unchecked")
	public List<Object> getMuestrasxTubo() {
		// Retrieve session from Hibernate
		Session session = sessionFactory.getCurrentSession();
		// Create a Hibernate query (HQL)
		Query query = session.createSQLQuery("SELECT DISTINCT pbmc, Count(participantes_vw.codigo) AS total, Count(labsero.codigo)+Count(labpbmc.codigo) AS tomadas, " +
		"Count(participantes_vw.codigo)-Count(labsero.codigo)-Count(labpbmc.codigo) AS faltantes, Count(labsero.codigo) AS rojos, " +
		"Count(labpbmc.codigo) AS pbmcs, (Count(labsero.codigo)+Count(labpbmc.codigo))/Count(participantes_vw.codigo)*100 AS Porcentaje " +
		"FROM participantes_vw LEFT JOIN estudios_ics.labsero ON participantes_vw.codigo = labsero.codigo LEFT JOIN estudios_ics.labpbmc ON participantes_vw.codigo = labpbmc.codigo " +
		//"WHERE (((participantes_vw.edad)>=6)) " + //AND ((participantes_vw.est_part)=1) AND ((participantes_vw.codigo)<30000)
				"WHERE ((YEAR(fecha_sero) = :anio and YEAR(fecha_pbmc) = :anio )) " +
				"GROUP BY pbmc;");
		query.setParameter("anio", Constants.ANIOMUESTREO);
		// Retrieve all
		return  query.list();
	}
	
	@SuppressWarnings("unchecked")
	public List<Object> getMuestrasTotal() {
		// Retrieve session from Hibernate
		Session session = sessionFactory.getCurrentSession();
		// Create a Hibernate query (HQL)
		Query query = session.createSQLQuery("SELECT DISTINCT Count(participantes_vw.codigo) AS total, Count(labsero.codigo)+Count(labpbmc.codigo) AS tomadas, " +
				"Count(participantes_vw.codigo)-Count(labsero.codigo)-Count(labpbmc.codigo) AS faltantes, Count(labbhc.codigo) AS bhcs, " +
				"Count(labsero.codigo) AS rojos, Count(labpbmc.codigo) AS pbmcs, (Count(labsero.codigo)+Count(labpbmc.codigo))/Count(participantes_vw.codigo)*100 AS Porc_Realizados, " +
				"((Count(participantes_vw.codigo)-Count(labsero.codigo)-Count(labpbmc.codigo))/Count(participantes_vw.codigo))*100 AS Porc_Faltantes, " +
				"Count(labpax.codigo) AS paxs FROM (((participantes_vw LEFT JOIN estudios_ics.labsero ON participantes_vw.codigo = labsero.codigo) LEFT JOIN estudios_ics.labpbmc ON participantes_vw.codigo = labpbmc.codigo)" +
				" LEFT JOIN estudios_ics.labbhc ON participantes_vw.codigo = labbhc.codigo) " +
				"LEFT JOIN estudios_ics.labpax ON participantes_vw.codigo = labpax.codigo  " +
				//"(((participantes_vw.edad)>=6) );"); //AND ((participantes_vw.est_part)=1) AND ((participantes_vw.codigo)<30000)
		"WHERE ((YEAR(labsero.fecha_sero) = :anio or YEAR(labpbmc.fecha_pbmc) = :anio or YEAR(labbhc.fecha_bhc) = :anio or YEAR(labpax.fecha_pax) = :anio)); ");
		query.setParameter("anio", Constants.ANIOMUESTREO);
		// Retrieve all
		return  query.list();
	}
	
	
	@SuppressWarnings("unchecked")
	public List<Object> getMuestrasDia() {
		// Retrieve session from Hibernate
		Session session = sessionFactory.getCurrentSession();
		// Create a Hibernate query (HQL)
		Query query = session.createSQLQuery("DELETE FROM muestrasxdia;");
		query.executeUpdate();
		query = session.createSQLQuery("INSERT IGNORE INTO muestrasxdia ( Codigo, fecha, Vol, Obs, Tipo, Fec2 ) " +
				"SELECT labpbmc.Codigo, labpbmc.fecha_pbmc, labpbmc.volpbmc, labpbmc.observacion, 'PBMC' AS Tipo, labpbmc.fecha_registro FROM estudios_ics.labpbmc WHERE (((labpbmc.volpbmc)>0) and YEAR(labpbmc.fecha_pbmc) = "+Constants.ANIOMUESTREO+");");
		query.executeUpdate();
		query = session.createSQLQuery("INSERT IGNORE INTO muestrasxdia ( Codigo, Tipo, Fecha, Vol, Obs, Fec2 ) " +
				"SELECT labsero.Codigo, 'Rojo' AS Tipo, labsero.fecha_sero, labsero.volsero, labsero.observacion, labsero.fecha_registro FROM estudios_ics.labsero WHERE (((labsero.volsero)>0) and YEAR(labsero.fecha_sero) = "+Constants.ANIOMUESTREO+");");
		query.executeUpdate();
		query = session.createSQLQuery("SELECT fecha, COUNT( codigo ) AS Total, " +
				"SUM( CASE Tipo WHEN 'PBMC' THEN 1 ELSE 0 END ) AS 'PBMC', " +
				"SUM( CASE Tipo WHEN 'Rojo' THEN 1 ELSE 0 END ) AS 'Rojo' FROM muestrasxdia GROUP BY fecha;");
		// Retrieve all
		return  query.list();
	}


}
