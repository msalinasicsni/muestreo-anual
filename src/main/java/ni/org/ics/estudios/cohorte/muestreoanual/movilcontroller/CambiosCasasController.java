package ni.org.ics.estudios.cohorte.muestreoanual.movilcontroller;

import java.util.Arrays;
import java.util.List;
import javax.annotation.Resource;

import ni.org.ics.estudios.cohorte.muestreoanual.domain.CambiosCasas;
import ni.org.ics.estudios.cohorte.muestreoanual.service.CambiosCasasService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestBody;
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
public class CambiosCasasController {
	@Resource(name="cambiosCasasService")
	private CambiosCasasService cambiosCasasService;
	private static final Logger logger = LoggerFactory.getLogger(CambiosCasasController.class);

	/**
     * Retorna CambiosCasas. Acepta una solicitud GET para JSON
     * @return Participantes JSON
     */
    @RequestMapping(value = "cambioscasas", method = RequestMethod.GET, produces = "application/json")
    public @ResponseBody List<CambiosCasas> descargarCambiosCasas() {
        logger.info("Descargando toda la informacion de las CambiosCasas");
        List<CambiosCasas> cambiosCasas = cambiosCasasService.getCambiosCasas();
        if (cambiosCasas == null){
        	logger.debug("Nulo");
        }
        return cambiosCasas ;	
    }
    
    
    
    /**
     * Acepta una solicitud POST con un parametro JSON
     * @param Objeto serializado de CambiosCasas
     * @return una cadena con el resultado*/
    @RequestMapping(value = "cambioscasas", method = RequestMethod.POST, consumes = "application/json") 
    public @ResponseBody String sendMessageJson(@RequestBody CambiosCasas[] envio) {
        logger.debug("Insertando/Actualizando las CambiosCasas");
        if (envio == null){
        	logger.debug("Nulo");
        	return "No recibi nada!";
        }
        else{
        	List<CambiosCasas> cambiosEnviados= Arrays.asList(envio);
        	for (CambiosCasas cambioCasa: cambiosEnviados){
        		cambiosCasasService.saveCambiosCasas(cambioCasa);
        	}
        }
        return "Datos recibidos!";
    }  
    
    
}
