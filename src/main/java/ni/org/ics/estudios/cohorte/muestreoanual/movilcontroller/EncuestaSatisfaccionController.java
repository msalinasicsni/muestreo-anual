package ni.org.ics.estudios.cohorte.muestreoanual.movilcontroller;

import java.util.Arrays;
import java.util.List;
import javax.annotation.Resource;

import ni.org.ics.estudios.cohorte.muestreoanual.domain.EncuestaSatisfaccion;
import ni.org.ics.estudios.cohorte.muestreoanual.service.EncuestaSatisfaccionService;

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
public class EncuestaSatisfaccionController {
	@Resource(name="encuestaSatisfaccionService")
	private EncuestaSatisfaccionService encuestaSatisfaccionService;
	private static final Logger logger = LoggerFactory.getLogger(EncuestaSatisfaccionController.class);

	/**
     * Retorna Encuesta de Satisfaccion. Acepta una solicitud GET para JSON
     * @return Participantes JSON
     */
    @RequestMapping(value = "encuestassatisfaccion", method = RequestMethod.GET, produces = "application/json")
    public @ResponseBody List<EncuestaSatisfaccion> descargarEncuestasSatisfaccion() {
        logger.info("Descargando toda la informacion de las encuestas de Satisfaccion");
        List<EncuestaSatisfaccion> encuestasSatisfaccion = encuestaSatisfaccionService.getEncuestasSatisfaccion();
        if (encuestasSatisfaccion == null){
        	logger.debug("Nulo");
        }
        return encuestasSatisfaccion ;	
    }
    
    
    
    /**
     * Acepta una solicitud POST con un parametro JSON
     * @param encuesta de Satisfaccion Objeto serializado de encuesta de Satisfaccion
     * @return una cadena con el resultado*/
    @RequestMapping(value = "encuestassatisfaccion", method = RequestMethod.POST, consumes = "application/json") 
    public @ResponseBody String sendMessageJson(@RequestBody EncuestaSatisfaccion[] envio) {
        logger.debug("Insertando/Actualizando las encuestas de Satisfaccion");
        if (envio == null){
        	logger.debug("Nulo");
        	return "No recibi nada!";
        }
        else{
        	List<EncuestaSatisfaccion> encuestasSatisfaccion= Arrays.asList(envio);
        	for (EncuestaSatisfaccion encuestaSatisfaccion: encuestasSatisfaccion){
        		Boolean existe = encuestaSatisfaccionService.checkEncuestaSatisfaccion(encuestaSatisfaccion.getFechaEncuesta().getTime());
        		if (!existe){
        			encuestaSatisfaccionService.addEncuestaSatisfaccion(encuestaSatisfaccion);
        		}
        		else{
        			encuestaSatisfaccionService.updateEncuestaSatisfaccion(encuestaSatisfaccion);
        		}
        	}
        }
        return "Datos recibidos!";
    }  
    
    
}
