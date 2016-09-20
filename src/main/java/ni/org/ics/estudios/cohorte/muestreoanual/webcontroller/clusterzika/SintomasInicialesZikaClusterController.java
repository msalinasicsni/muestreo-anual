package ni.org.ics.estudios.cohorte.muestreoanual.webcontroller.clusterzika;

import java.util.Arrays;
import java.util.List;
import javax.annotation.Resource;

import ni.org.ics.estudios.cohorte.muestreoanual.domain.clusterzika.SintomasInicialesZikaCluster;
import ni.org.ics.estudios.cohorte.muestreoanual.service.clusterzika.SintomasInicialesZikaClusterService;
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
 * @author Jairo Carey
 */
@Controller
@RequestMapping("/movil/zikacluster/*")
public class SintomasInicialesZikaClusterController {
	@Resource(name="sintomasInicialesZikaClusterService")
	private SintomasInicialesZikaClusterService sintomasInicialesZikaClusterService;
	private static final Logger logger = LoggerFactory.getLogger(SintomasInicialesZikaClusterController.class);

	/**
     * Retorna consentimientos. Acepta una solicitud GET para JSON
     * @return consentimientos JSON
     */
    @RequestMapping(value = "SintomasIniciales", method = RequestMethod.GET, produces = "application/json")
    public @ResponseBody List<SintomasInicialesZikaCluster> descargarSintomasIniciales() {
        logger.info("Descargando toda la informacion de los datos de los SintomasInicialesZikaCluster");
        List<SintomasInicialesZikaCluster> sintomasIniciales = sintomasInicialesZikaClusterService.getSintomasInicialesZikaCluster();
        if (sintomasIniciales == null){
        	logger.debug("Nulo");
        }
        return sintomasIniciales;	
    }
    
    
    
    /**
     * Acepta una solicitud POST con un parametro JSON
     * @param cons Objeto serializado de ConsentimientoZika
     * @return una cadena con el resultado*/
     
    @RequestMapping(value = "sintomasIniciales", method = RequestMethod.POST, consumes = "application/json")
    public @ResponseBody String sendMessageJson(@RequestBody SintomasInicialesZikaCluster[] envio) {
        logger.debug("Insertando/Actualizando SintomasInicialesZikaCluster");
        if (envio == null){
        	logger.debug("Nulo");
        	return "No recibi nada!";
        }
        else{
        	List<SintomasInicialesZikaCluster> sintomasIniciales = Arrays.asList(envio);
        	for (SintomasInicialesZikaCluster sintomaIniciales : sintomasIniciales){
        		sintomasInicialesZikaClusterService.saveSintomasInicialesZikaCluster(sintomaIniciales);
        	}
        }
        return "Datos recibidos!";
    }  
    
    
}
