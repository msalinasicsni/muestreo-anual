package ni.org.ics.estudios.cohorte.muestreoanual.service;

import java.util.List;

import javax.annotation.Resource;

import ni.org.ics.estudios.cohorte.muestreoanual.domain.Casa;

import ni.org.ics.estudios.cohorte.muestreoanual.dto.PuntoGps;
import ni.org.ics.estudios.cohorte.muestreoanual.utils.Constants;
import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.transform.Transformers;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

/**
 * Servicio para presentar mapas
 * 
 * @author Brenda Lopez
 * 
 **/

@Service("mapaService")
@Transactional
public class MapaService {
	
	@Resource(name="sessionFactory")
	private SessionFactory sessionFactory;


	@SuppressWarnings("unchecked")
	public List<Casa> getPuntos() {
		// Retrieve session from Hibernate
		Session session = sessionFactory.getCurrentSession();
		// Create a Hibernate query (HQL)
		Query query = session.createQuery("From Casa cas " +
				"where cas.latitud is not null and cas.latitud >0");
		// Retrieve all
		return  query.list();
	}
	
	@SuppressWarnings("unchecked")
	public List<Object> getParticipantesPuntos() {
		// Retrieve session from Hibernate
		Session session = sessionFactory.getCurrentSession();
		// Create a Hibernate query (HQL)
		Query query = session.createSQLQuery("select participantes_vw.codigo, nombre1, nombre2,apellido1,apellido2, participantes_vw.casa, " +
				"participantes_vw.desc_barrio, latitud, longitud, pbmc, tubobhc, tuborojo, tuboleu " +
				"from participantes_vw left join estudios_ics.muestras on participantes_vw.codigo = muestras.codigo " +
				"where latitud is not null and est_part = 1 order by participantes_vw.codigo;");
		// Retrieve all
		return  query.list();
	}

	@SuppressWarnings("unchecked")
	public List<PuntoGps> getParticipantesPuntosGps() {
		// Retrieve session from Hibernate
		Session session = sessionFactory.getCurrentSession();
		// Create a Hibernate query (HQL)
		Query query = session.createSQLQuery("select distinct participantes_vw.codigo as codigo, latitud as latitud, longitud as longitud " +
				"from participantes_vw left join estudios_ics.muestras on participantes_vw.codigo = muestras.codigo " +
				"where latitud is not null and est_part = 1 order by participantes_vw.codigo;");
		// Retrieve all
		query.setResultTransformer(Transformers.aliasToBean(PuntoGps.class));
		return  query.list();
	}
	
	@SuppressWarnings("unchecked")
	public List<Object> getParticipantesMuestras() {
		// Retrieve session from Hibernate
		Session session = sessionFactory.getCurrentSession();
		// Create a Hibernate query (HQL)
		Query query = session.createSQLQuery("select participantes_vw.codigo, nombre1, nombre2,apellido1,apellido2, participantes_vw.casa, " +
				"desc_barrio, latitud, longitud, pbmc, tubobhc, tuborojo, tuboleu " +
				"from participantes_vw left join estudios_ics.muestras on participantes_vw.codigo = muestras.codigo " +
				"where latitud is not null and latitud > 0 and est_part = 1 and (tuborojo=1 or tuboleu=1) order by participantes_vw.codigo;");
		// Retrieve all
		return  query.list();
	}

	@SuppressWarnings("unchecked")
	public List<PuntoGps> getParticipantesMuestrasGps() {
		// Retrieve session from Hibernate
		Session session = sessionFactory.getCurrentSession();
		// Create a Hibernate query (HQL)
		Query query = session.createSQLQuery("select distinct participantes_vw.codigo as codigo, latitud as latitud, longitud as longitud, tuboleu as tuboleu " +
				"from participantes_vw left join estudios_ics.muestras on participantes_vw.codigo = muestras.codigo " +
				"where latitud is not null and latitud > 0 and est_part = 1 and (tuborojo=1 or tuboleu=1) " +
				"AND YEAR(muestras.fecha_registro) = :anio order by participantes_vw.codigo;");
		query.setInteger("anio", Constants.ANIOMUESTREO);
		// Retrieve all
		query.setResultTransformer(Transformers.aliasToBean(PuntoGps.class));
		return  query.list();
	}
	
	
	@SuppressWarnings("unchecked")
	public List<Object> getParticipantesPendientes() {
		// Retrieve session from Hibernate
		Session session = sessionFactory.getCurrentSession();
		// Create a Hibernate query (HQL)
		Query query = session.createSQLQuery("select participantes_vw.codigo, nombre1, nombre2,apellido1,apellido2, participantes_vw.casa, " +
				"desc_barrio, latitud, longitud, pbmc, paxgene, tubobhc, tuborojo, tuboleu " +
				"from participantes_vw left join estudios_ics.muestras on participantes_vw.codigo = muestras.codigo " +
				"where latitud is not null and latitud > 0 and est_part = 1 and muestras.codigo is null order by participantes_vw.codigo;");
		// Retrieve all
		return  query.list();
	}

	@SuppressWarnings("unchecked")
	public List<PuntoGps> getParticipantesPendientesGps() {
		// Retrieve session from Hibernate
		Session session = sessionFactory.getCurrentSession();
		// Create a Hibernate query (HQL)
		Query query = session.createSQLQuery("select distinct participantes_vw.codigo as codigo, latitud as latitud, longitud as longitud, pbmc as pbmc, paxgene as paxgene " +
				"from participantes_vw left join estudios_ics.muestras on participantes_vw.codigo = muestras.codigo " +
				"where latitud is not null and latitud > 0 and est_part = 1 and muestras.codigo is null order by participantes_vw.codigo;");
		// Retrieve all
		query.setResultTransformer(Transformers.aliasToBean(PuntoGps.class));
		return  query.list();
	}
	
	@SuppressWarnings("unchecked")
	public List<Object> getParticipantesPendientes(Integer barrio) {
		// Retrieve session from Hibernate
		Session session = sessionFactory.getCurrentSession();
		// Create a Hibernate query (HQL)
		Query query = session.createSQLQuery("select participantes.codigo, nombre1, nombre2,apellido1,apellido2, cod_casa, " +
				"desc_barrio, latitud, longitud, pbmc, tubobhc, tuborojo, tuboleu " +
				"from participantes left join muestras on participantes.codigo = muestras.codigo " +
				"where latitud is not null and latitud > 0 and est_part = 1 and casas.barrio = " + barrio +" and muestras.codigo is null order by codigo;");
		// Retrieve all
		return  query.list();
	}
	
	
	
}
