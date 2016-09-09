package ni.org.ics.estudios.cohorte.muestreoanual.movilcontroller;

import java.util.Arrays;
import java.util.List;
import javax.annotation.Resource;

import ni.org.ics.estudios.cohorte.muestreoanual.domain.CodigosCasas;
import ni.org.ics.estudios.cohorte.muestreoanual.service.CodigosCasasService;
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
public class CodigosCasasController {
	@Resource(name="codigosCasasService")
	private CodigosCasasService codigosCasasService;
	private static final Logger logger = LoggerFactory.getLogger(CodigosCasasController.class);

	/**
     * Retorna CodigosCasas. Acepta una solicitud GET para JSON
     * @return Participantes JSON
     */
    @RequestMapping(value = "codigoscasas", method = RequestMethod.GET, produces = "application/json")
    public @ResponseBody List<CodigosCasas> descargarEncuestasSatisfaccion() {
        logger.info("Descargando toda la informacion de las CodigosCasas");
        List<CodigosCasas> codigosCasas = codigosCasasService.getCodigosCasas();
        if (codigosCasas == null){
        	logger.debug("Nulo");
        }
        return codigosCasas ;	
    }
    
    
    
    /**
     * Acepta una solicitud POST con un parametro JSON
     * @param encuesta de Satisfaccion Objeto serializado de encuesta de Satisfaccion
     * @return una cadena con el resultado*/
    @RequestMapping(value = "codigoscasas", method = RequestMethod.POST, consumes = "application/json") 
    public @ResponseBody String sendMessageJson(@RequestBody CodigosCasas[] envio) {
        logger.debug("Insertando/Actualizando las CodigosCasas");
        if (envio == null){
        	logger.debug("Nulo");
        	return "No recibi nada!";
        }
        else{
        	List<CodigosCasas> codigosEnviados= Arrays.asList(envio);
        	for (CodigosCasas codigoCasas: codigosEnviados){
        		Boolean existe = codigosCasasService.checkCodigosCasas(codigoCasas.getFechaRegistro().getTime());
        		if (!existe){
        			codigosCasasService.addCodigosCasas(codigoCasas);
        		}
        		else{
        			codigosCasasService.updateCodigosCasas(codigoCasas);
        		}
        	}
        }
        return "Datos recibidos!";
    }  
    
    
}
