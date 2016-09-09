package ni.org.ics.estudios.cohorte.muestreoanual.movilcontroller;

import java.util.Arrays;
import java.util.Date;
import java.util.List;
import javax.annotation.Resource;



import ni.org.ics.estudios.cohorte.muestreoanual.domain.ConsentimientoZika;
import ni.org.ics.estudios.cohorte.muestreoanual.domain.ConsentimientoZikaId;
import ni.org.ics.estudios.cohorte.muestreoanual.service.ConsentimientoZikaService;
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
public class ConsentimientoZikaController {
	@Resource(name="consentimientoZikaService")
	private ConsentimientoZikaService consentimientoZikaService;
	private static final Logger logger = LoggerFactory.getLogger(ConsentimientoZikaController.class);

	/**
     * Retorna consentimientos. Acepta una solicitud GET para JSON
     * @return consentimientos JSON
     */
    @RequestMapping(value = "conszika", method = RequestMethod.GET, produces = "application/json")
    public @ResponseBody List<ConsentimientoZika> descargarConsentimientos() {
        logger.info("Descargando toda la informacion de los datos de los ConsentimientoZika");
        List<ConsentimientoZika> cons = consentimientoZikaService.getConsentimientoZika();
        if (cons == null){
        	logger.debug("Nulo");
        }
        return cons;	
    }
    
    
    
    /**
     * Acepta una solicitud POST con un parametro JSON
     * @param cons Objeto serializado de ConsentimientoZika
     * @return una cadena con el resultado*/
     
    @RequestMapping(value = "conszika", method = RequestMethod.POST, consumes = "application/json")
    public @ResponseBody String sendMessageJson(@RequestBody ConsentimientoZika[] envio) {
        logger.debug("Insertando/Actualizando ConsentimientoZika");
        if (envio == null){
        	logger.debug("Nulo");
        	return "No recibi nada!";
        }
        else{
        	List<ConsentimientoZika> consents = Arrays.asList(envio);
        	for (ConsentimientoZika cons : consents){
        		ConsentimientoZikaId reconsId = new ConsentimientoZikaId();
        		reconsId.setCodigo(cons.getConsZikaId().getCodigo());
        		reconsId.setFechaCons(new Date(cons.getConsZikaId().getFechaCons().getTime()));
        		Boolean existe = consentimientoZikaService.checkConsentimientoZika(reconsId);
        		if (!existe){
        			consentimientoZikaService.addConsentimientoZika(cons);
        		}
        		else{
        			consentimientoZikaService.updateConsentimientoZika(cons);
        		}
        	}
        }
        return "Datos recibidos!";
    }  
    
    
}
