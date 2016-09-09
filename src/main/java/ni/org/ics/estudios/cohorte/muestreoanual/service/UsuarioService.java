package ni.org.ics.estudios.cohorte.muestreoanual.service;

import java.util.Date;
import java.util.List;
import javax.annotation.Resource;


import ni.org.ics.estudios.cohorte.muestreoanual.domain.Authority;
import ni.org.ics.estudios.cohorte.muestreoanual.domain.Rol;
import ni.org.ics.estudios.cohorte.muestreoanual.domain.User;
import ni.org.ics.estudios.cohorte.muestreoanual.log.RolLog;
import ni.org.ics.estudios.cohorte.muestreoanual.log.UserLog;

import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

/**
 * Servicio para el objeto Vivienda
 * 
 * @author William Aviles
 * 
 **/

@Service("usuarioService")
@Transactional
public class UsuarioService {
	
	@Resource(name="sessionFactory")
	private SessionFactory sessionFactory;
	
	
	/**
	 * Regresa todos los usuarios
	 * 
	 * @return una lista de <code>User</code>(s)
	 */

	@SuppressWarnings("unchecked")
	public List<User> getUsers() {
		// Retrieve session from Hibernate
		Session session = sessionFactory.getCurrentSession();
		// Create a Hibernate query (HQL)
		Query query = session.createQuery("FROM User");
		// Retrieve all
		return  query.list();
	}
	

	/**
	 * Regresa un User
	 * 
	 * @return un <code>User</code>
	 */

	public User getUser(String username) {
		// Retrieve session from Hibernate
		Session session = sessionFactory.getCurrentSession();
		Query query = session.createQuery("FROM User u where " +
				"u.username = '" + username + "'");
		User user = (User) query.uniqueResult();
		return user;
	}
	
	/**
	 * Verifica un User
	 * 
	 * @return boolean
	 */

	public Boolean checkUser(String username) {
		// Retrieve session from Hibernate
		Session session = sessionFactory.getCurrentSession();
		Query query = session.createQuery("FROM User u where " +
				"u.username = '" + username + "'");
		User user = (User) query.uniqueResult();
		if (user!=null){
			return true;
		}
		else{
			return false;
		}
	}
	
	/**
	 * Agrega un user
	 * 
	 * 
	 */
	public void addUser(User user) {
		Session session = sessionFactory.getCurrentSession();
		UserLog uLog = new UserLog(new Date(), user.getUsername(), user.getPassword(),
				user.getCompleteName(), user.getEmail(), user.getEnabled(), user.getUsuario());
		session.save(user);
		session.save(uLog);
	}
	
	/**
	 * Agrega un rol
	 * 
	 * 
	 */
	public void addAuthority(Authority auth) {
		Session session = sessionFactory.getCurrentSession();
		RolLog authLog = new RolLog(new Date(), auth.getAuthId().getUsername(),
				auth.getAuthId().getAuthority(), auth.getUser().getUsuario());
		session.save(auth);
		session.save(authLog);
	}
	
	/**
	 * Actualiza un user
	 * 
	 * 
	 */
	public void updateUser(User user) {
		Session session = sessionFactory.getCurrentSession();
		UserLog uLog = new UserLog(new Date(), user.getUsername(), user.getPassword(),
				user.getCompleteName(), user.getEmail(), user.getEnabled(), user.getUsuario());
		session.update(user);
		session.save(uLog);
	}
	
	/**
	 * Regresa todos los niveles usuarios
	 * 
	 * @return una lista de <code>Nivel</code>(es)
	 */

	@SuppressWarnings("unchecked")
	public List<Rol> getRoles() {
		// Retrieve session from Hibernate
		Session session = sessionFactory.getCurrentSession();
		// Create a Hibernate query (HQL)
		Query query = session.createQuery("FROM Rol");
		// Retrieve all
		return  query.list();
	}
	
	/**
	 * Borra todos los roles
	 * 
	 * 
	 */

	public Integer deleteRoles(String userName) {
		// Retrieve session from Hibernate
		Session s = sessionFactory.openSession();
		Transaction tx = s.beginTransaction();

		String hqlDelete = "delete Authority auth where auth.authId.username = :userName and" +
				" auth.authId.authority <> 'ROLE_ADMIN'";
		int deletedEntities = s.createQuery( hqlDelete )
		        .setString( "userName", userName )
		        .executeUpdate();
		tx.commit();
		s.close();
		return deletedEntities;
	}
	
	
	/**
	 * Borra rol admin
	 * 
	 * 
	 */

	public Integer deleteRoleAdmin(String userName) {
		// Retrieve session from Hibernate
		Session s = sessionFactory.openSession();
		Transaction tx = s.beginTransaction();

		String hqlDelete = "delete Authority auth where auth.authId.username = :userName and" +
				" auth.authId.authority = 'ROLE_ADMIN'";
		int deletedEntities = s.createQuery( hqlDelete )
		        .setString( "userName", userName )
		        .executeUpdate();
		tx.commit();
		s.close();
		return deletedEntities;
	}
	
	/**
	 * Borra rol super
	 * 
	 * 
	 */

	public Integer deleteRoleSuper(String userName) {
		// Retrieve session from Hibernate
		Session s = sessionFactory.openSession();
		Transaction tx = s.beginTransaction();

		String hqlDelete = "delete Authority auth where auth.authId.username = :userName and" +
				" auth.authId.authority = 'ROLE_SUPER'";
		int deletedEntities = s.createQuery( hqlDelete )
		        .setString( "userName", userName )
		        .executeUpdate();
		tx.commit();
		s.close();
		return deletedEntities;
	}
	
	/**
	 * Borra rol web
	 * 
	 * 
	 */

	public Integer deleteRoleWeb(String userName) {
		// Retrieve session from Hibernate
		Session s = sessionFactory.openSession();
		Transaction tx = s.beginTransaction();

		String hqlDelete = "delete Authority auth where auth.authId.username = :userName and" +
				" auth.authId.authority = 'ROLE_WEB'";
		int deletedEntities = s.createQuery( hqlDelete )
		        .setString( "userName", userName )
		        .executeUpdate();
		tx.commit();
		s.close();
		return deletedEntities;
	}
	
	/**
	 * Borra rol terreno
	 * 
	 * 
	 */

	public Integer deleteRoleTerreno(String userName) {
		// Retrieve session from Hibernate
		Session s = sessionFactory.openSession();
		Transaction tx = s.beginTransaction();

		String hqlDelete = "delete Authority auth where auth.authId.username = :userName and" +
				" auth.authId.authority = 'ROLE_MOVIL'";
		int deletedEntities = s.createQuery( hqlDelete )
		        .setString( "userName", userName )
		        .executeUpdate();
		tx.commit();
		s.close();
		return deletedEntities;
	}
}
