package ni.org.ics.estudios.cohorte.muestreoanual.movilcontroller;

import java.util.Arrays;
import java.util.Date;
import java.util.List;
import javax.annotation.Resource;



import ni.org.ics.estudios.cohorte.muestreoanual.domain.ReConsentimientoFlu2015;
import ni.org.ics.estudios.cohorte.muestreoanual.domain.ReConsentimientoFlu2015Id;
import ni.org.ics.estudios.cohorte.muestreoanual.service.ReConsentimientoFlu2015Service;

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
public class ReConsentimientoFlu2015Controller {
	@Resource(name="reConsentimientoFlu2015Service")
	private ReConsentimientoFlu2015Service reConsentimientoFlu2015Service;
	private static final Logger logger = LoggerFactory.getLogger(ReConsentimientoFlu2015Controller.class);

	/**
     * Retorna consentimientos. Acepta una solicitud GET para JSON
     * @return consentimientos JSON
     */
    @RequestMapping(value = "reconsflu2015", method = RequestMethod.GET, produces = "application/json")
    public @ResponseBody List<ReConsentimientoFlu2015> descargarReConsentimientos() {
        logger.info("Descargando toda la informacion de los datos de los ReConsentimientoDen2015");
        List<ReConsentimientoFlu2015> recons = reConsentimientoFlu2015Service.getReConsentimientos();
        if (recons == null){
        	logger.debug("Nulo");
        }
        return recons;	
    }
    
    
    
    /**
     * Acepta una solicitud POST con un parametro JSON
     * @param cons Objeto serializado de ReConsentimientoDen
     * @return una cadena con el resultado*/
     
    @RequestMapping(value = "reconsflu2015", method = RequestMethod.POST, consumes = "application/json")
    public @ResponseBody String sendMessageJson(@RequestBody ReConsentimientoFlu2015[] envio) {
        logger.debug("Insertando/Actualizando ReConsentimientoFlu2015");
        if (envio == null){
        	logger.debug("Nulo");
        	return "No recibi nada!";
        }
        else{
        	List<ReConsentimientoFlu2015> reconss = Arrays.asList(envio);
        	for (ReConsentimientoFlu2015 recons : reconss){
        		ReConsentimientoFlu2015Id reconsId = new ReConsentimientoFlu2015Id();
        		reconsId.setCodigo(recons.getReconsfluId().getCodigo());
        		reconsId.setFechaCons(new Date(recons.getReconsfluId().getFechaCons().getTime()));
        		Boolean existe = reConsentimientoFlu2015Service.checkReConsentimiento(reconsId);
        		if (!existe){
        			reConsentimientoFlu2015Service.addReConsentimiento(recons);
        		}
        		else{
        			reConsentimientoFlu2015Service.updateReConsentimiento(recons);
        		}
        	}
        }
        return "Datos recibidos!";
    }  
    
    
}
