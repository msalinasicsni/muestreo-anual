package ni.org.ics.estudios.cohorte.muestreoanual.movilcontroller;

import java.util.Arrays;
import java.util.Date;
import java.util.List;
import javax.annotation.Resource;



import ni.org.ics.estudios.cohorte.muestreoanual.domain.ReConsentimientoDen;
import ni.org.ics.estudios.cohorte.muestreoanual.domain.ReConsentimientoDenId;
import ni.org.ics.estudios.cohorte.muestreoanual.service.ReConsentimientoDenService;

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
public class ReConsentimientoDenController {
	@Resource(name="reconsentimientoService")
	private ReConsentimientoDenService reconsentimientoService;
	private static final Logger logger = LoggerFactory.getLogger(ReConsentimientoDenController.class);

	/**
     * Retorna consentimientos. Acepta una solicitud GET para JSON
     * @return consentimientos JSON
     */
    @RequestMapping(value = "recons", method = RequestMethod.GET, produces = "application/json")
    public @ResponseBody List<ReConsentimientoDen> descargarReConsentimientos() {
        logger.info("Descargando toda la informacion de los datos de los ReConsentimientoDen");
        List<ReConsentimientoDen> recons = reconsentimientoService.getReConsentimientos();
        if (recons == null){
        	logger.debug("Nulo");
        }
        return recons;	
    }
    
    
    
    /**
     * Acepta una solicitud POST con un parametro JSON
     * @param cons Objeto serializado de ReConsentimientoDen
     * @return una cadena con el resultado*/
     
    @RequestMapping(value = "recons", method = RequestMethod.POST, consumes = "application/json")
    public @ResponseBody String sendMessageJson(@RequestBody ReConsentimientoDen[] envio) {
        logger.debug("Insertando/Actualizando ReConsentimientoDen");
        if (envio == null){
        	logger.debug("Nulo");
        	return "No recibi nada!";
        }
        else{
        	List<ReConsentimientoDen> reconss = Arrays.asList(envio);
        	for (ReConsentimientoDen recons : reconss){
        		ReConsentimientoDenId reconsId = new ReConsentimientoDenId();
        		reconsId.setCodigo(recons.getReconsdenId().getCodigo());
        		reconsId.setFechaCons(new Date(recons.getReconsdenId().getFechaCons().getTime()));
        		Boolean existe = reconsentimientoService.checkReConsentimiento(reconsId);
        		if (!existe){
        			reconsentimientoService.addReConsentimiento(recons);
        		}
        		else{
        			reconsentimientoService.updateReConsentimiento(recons);
        		}
        	}
        }
        return "Datos recibidos!";
    }  
    
    
}
