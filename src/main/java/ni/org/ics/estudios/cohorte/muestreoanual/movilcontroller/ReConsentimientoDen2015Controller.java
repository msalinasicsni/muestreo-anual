package ni.org.ics.estudios.cohorte.muestreoanual.movilcontroller;

import java.util.Arrays;
import java.util.Date;
import java.util.List;
import javax.annotation.Resource;



import ni.org.ics.estudios.cohorte.muestreoanual.domain.ReConsentimientoDen2015;
import ni.org.ics.estudios.cohorte.muestreoanual.domain.ReConsentimientoDen2015Id;
import ni.org.ics.estudios.cohorte.muestreoanual.service.ReConsentimientoDen2015Service;
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
public class ReConsentimientoDen2015Controller {
	@Resource(name="reconsentimiento2015Service")
	private ReConsentimientoDen2015Service reconsentimiento2015Service;
	private static final Logger logger = LoggerFactory.getLogger(ReConsentimientoDen2015Controller.class);

	/**
     * Retorna consentimientos. Acepta una solicitud GET para JSON
     * @return consentimientos JSON
     */
    @RequestMapping(value = "recons2015", method = RequestMethod.GET, produces = "application/json")
    public @ResponseBody List<ReConsentimientoDen2015> descargarReConsentimientos() {
        logger.info("Descargando toda la informacion de los datos de los ReConsentimientoDen2015");
        List<ReConsentimientoDen2015> recons = reconsentimiento2015Service.getReConsentimientos();
        if (recons == null){
        	logger.debug("Nulo");
        }
        return recons;	
    }
    
    
    
    /**
     * Acepta una solicitud POST con un parametro JSON
     * @param cons Objeto serializado de ReConsentimientoDen
     * @return una cadena con el resultado*/
     
    @RequestMapping(value = "recons2015", method = RequestMethod.POST, consumes = "application/json")
    public @ResponseBody String sendMessageJson(@RequestBody ReConsentimientoDen2015[] envio) {
        logger.debug("Insertando/Actualizando ReConsentimientoDen2015");
        if (envio == null){
        	logger.debug("Nulo");
        	return "No recibi nada!";
        }
        else{
        	List<ReConsentimientoDen2015> reconss = Arrays.asList(envio);
        	for (ReConsentimientoDen2015 recons : reconss){
        		ReConsentimientoDen2015Id reconsId = new ReConsentimientoDen2015Id();
        		reconsId.setCodigo(recons.getReconsdenId().getCodigo());
        		reconsId.setFechaCons(new Date(recons.getReconsdenId().getFechaCons().getTime()));
        		Boolean existe = reconsentimiento2015Service.checkReConsentimiento(reconsId);
        		if (!existe){
        			reconsentimiento2015Service.addReConsentimiento(recons);
        		}
        		else{
        			reconsentimiento2015Service.updateReConsentimiento(recons);
        		}
        	}
        }
        return "Datos recibidos!";
    }  
    
    
}
