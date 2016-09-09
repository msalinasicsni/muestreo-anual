package ni.org.ics.estudios.cohorte.muestreoanual.movilcontroller;

import java.util.Date;
import java.util.List;
import javax.annotation.Resource;


import ni.org.ics.estudios.cohorte.muestreoanual.domain.Authority;
import ni.org.ics.estudios.cohorte.muestreoanual.domain.User;
import ni.org.ics.estudios.cohorte.muestreoanual.service.RoleService;
import ni.org.ics.estudios.cohorte.muestreoanual.service.UserService;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

/**
 * Maneja las solicitudes que van a la aplicacion relacionadas a json
 * 
 * @author Brenda Lopez
 */
@Controller
@RequestMapping("/movil/*")
public class UserController {
	@Resource(name="userService")
	private UserService userService;
	@Resource(name="roleService")
	private RoleService roleService;
	private static final Logger logger = LoggerFactory.getLogger(UserController.class);

	/**
     * Retorna usuarios. Acepta una solicitud GET para JSON
     * @return barrios JSON
     */
    @RequestMapping(value = "usuarios", method = RequestMethod.GET, produces = "application/json")
    public @ResponseBody List<User> descargarUsuarios() {
        logger.info("Descargando toda la informacion de los datos de los usuarios");
        List<User> usuarios = userService.getUsuarios();
        if (usuarios == null){
        	logger.debug(new Date() + " - Nulo");
        }
        else{
        	for (User user : usuarios) {
        		user.setAuthorities(null);
        	}
        }
        return usuarios;	
    }
    
    /**
     * Retorna roles. Acepta una solicitud GET para JSON
     * @return barrios JSON
     */
    @RequestMapping(value = "roles", method = RequestMethod.GET, produces = "application/json")
    public @ResponseBody List<Authority> descargarRoles() {
        logger.info("Descargando toda la informacion de los datos de los roles");
        List<Authority> roles = roleService.getRoles();
        if (roles == null){
        	logger.debug(new Date() + " - Nulo");
        }
        else{
        	for (Authority auth : roles) {
        		auth.setUser(null);
        		auth.setRol(null);
        	}
        }
        return roles;	
    }
    
    /**
     * Retorna roles. Acepta una solicitud GET para JSON
     * @return barrios JSON
     */
    @RequestMapping(value = "roles/{username}", method = RequestMethod.GET, produces = "application/json")
    public @ResponseBody List<Authority> descargarRolesUsuario(@PathVariable String username) {
        logger.info("Descargando toda la informacion de los datos de los roles para el usuario "+username);
        List<Authority> roles = roleService.getRoles(username);
        if (roles == null){
        	logger.debug(new Date() + " - Nulo");
        }
        else{
        	for (Authority auth : roles) {
        		auth.setUser(null);
        		auth.setRol(null);
        	}
        }
        return roles;	
    }
    
    /**
     * Retorna usuarios. Acepta una solicitud GET para JSON
     * @return String JSON
     */
    @RequestMapping(value = "role/{username}", method = RequestMethod.GET, produces = "application/json")
    public @ResponseBody Boolean checkRole(@PathVariable String username) {
        logger.info("Verificando Rol de Admin");
        Boolean tienePermiso = roleService.checRoleAdmin(username);
        return tienePermiso;	
    }
       
}
