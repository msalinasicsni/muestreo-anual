package ni.org.ics.estudios.cohorte.muestreoanual;

import java.util.List;

import javax.annotation.Resource;

import ni.org.ics.estudios.cohorte.muestreoanual.domain.User;
import ni.org.ics.estudios.cohorte.muestreoanual.service.ReporteService;
import ni.org.ics.estudios.cohorte.muestreoanual.service.UserService;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

/**
 * Maneja las solicitudes que van a la aplicacion
 * 
 * @author William Aviles
 */
@Controller
@RequestMapping("/*")
public class HomeController {
	@Resource(name="userService")
	private UserService userService;
	@Resource(name="reporteService")
	private ReporteService reporteService;
    private static final Logger logger = LoggerFactory.getLogger(HomeController.class);

    /**
     * Selecciona la vista principal regresando su nombre.
     */
    @RequestMapping(value = "/", method = RequestMethod.GET)
    public String home(Model model) {
        logger.info("Muestreo Anual Iniciado");
        List<Object> conteoBHCLab = reporteService.getCountBHCsLab();
        model.addAttribute("labBhcsTotales", conteoBHCLab);
        List<Object> conteoRojoLab = reporteService.getCountRojosLab();
        model.addAttribute("labRojosTotales", conteoRojoLab);
        List<Object> conteoPbmcLab = reporteService.getCountPBMCsLab();
        model.addAttribute("labPbmcsTotales", conteoPbmcLab);
        List<Object> conteoPaxLab = reporteService.getCountPaxsLab();
        model.addAttribute("labPaxsTotales", conteoPaxLab);
        List<Object> muestrasxBarrio = reporteService.getMuestrasxBarrio();
        model.addAttribute("muestrasBarrio", muestrasxBarrio);
        List<Object> muestrasxEdad = reporteService.getMuestrasxEdad();
        model.addAttribute("muestrasEdad", muestrasxEdad);
        List<Object> muestrasxEstudio = reporteService.getMuestrasxEstudio();
        model.addAttribute("muestrasEstudio", muestrasxEstudio);
        List<Object> muestrasxTubo = reporteService.getMuestrasxTubo();
        model.addAttribute("muestrasTubo", muestrasxTubo);
        List<Object> muestrasTotal = reporteService.getMuestrasTotal();
        model.addAttribute("muestrasTotal", muestrasTotal);
        return "home";
    }
    
    @RequestMapping(value="/login", method = RequestMethod.GET)
	public String login(ModelMap model) {
 
		return "login";
 
	}
    
    @RequestMapping(value="/loginfailed", method = RequestMethod.GET)
	public String loginerror(ModelMap model) {
    	model.addAttribute("error", "true");
		return "login";
 
	}
    
    @RequestMapping(value="/logout", method = RequestMethod.GET)
	public String logout(ModelMap model) {
 
		return "login";
 
	}
    
	
	
	@RequestMapping(value="/403", method = RequestMethod.GET)
	public String noAcceso() {
 
		return "403";
 
	}
    
    /**
     * Selecciona la vista ayuda regresando su nombre.
     */
    @RequestMapping(value = "/ayuda", method = RequestMethod.GET)
    public String ayuda() {
        logger.info("Presentando menu de ayuda");
        return "ayuda";
    }
    
    /**
     * Selecciona la vista de salida
     */
    @RequestMapping(value = "/salida", method = RequestMethod.GET)
    public String salida() {
        logger.info("Cohorte Bebe Terminado");
        return "salida";
    }
    
    @RequestMapping(value = "/movil/ingreso/{username}", method = RequestMethod.GET, produces = "application/json")
    public @ResponseBody User getMessage(@PathVariable String username) {
    	logger.info("Accessando a la aplicacion " + username);
    	User user = userService.getUsuario(username);
    	user.setAuthorities(null);
    	return user;
    }
    
}
