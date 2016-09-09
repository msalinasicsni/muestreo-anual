package ni.org.ics.estudios.cohorte.muestreoanual.webcontroller.clusterzika;

import java.util.Arrays;
import java.util.List;
import javax.annotation.Resource;



import ni.org.ics.estudios.cohorte.muestreoanual.domain.clusterzika.TamizajeZikaCluster;
import ni.org.ics.estudios.cohorte.muestreoanual.service.clusterzika.TamizajeZikaClusterService;

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
@RequestMapping("/movil/zikacluster/*")
public class TamizajeZikaClusterController {
	@Resource(name="tamizajeZikaClusterService")
	private TamizajeZikaClusterService tamizajeZikaClusterService;
	private static final Logger logger = LoggerFactory.getLogger(TamizajeZikaClusterController.class);

	/**
     * Retorna consentimientos. Acepta una solicitud GET para JSON
     * @return consentimientos JSON
     */
    @RequestMapping(value = "tamizajes", method = RequestMethod.GET, produces = "application/json")
    public @ResponseBody List<TamizajeZikaCluster> descargarTamizajes() {
        logger.info("Descargando toda la informacion de los datos de los TamizajeZikaCluster");
        List<TamizajeZikaCluster> tamizajes = tamizajeZikaClusterService.getTamizajeZikaCluster();
        if (tamizajes == null){
        	logger.debug("Nulo");
        }
        return tamizajes;	
    }
    
    
    
    /**
     * Acepta una solicitud POST con un parametro JSON
     * @param cons Objeto serializado de ConsentimientoZika
     * @return una cadena con el resultado*/
     
    @RequestMapping(value = "tamizajes", method = RequestMethod.POST, consumes = "application/json")
    public @ResponseBody String sendMessageJson(@RequestBody TamizajeZikaCluster[] envio) {
        logger.debug("Insertando/Actualizando TamizajeZikaCluster");
        if (envio == null){
        	logger.debug("Nulo");
        	return "No recibi nada!";
        }
        else{
        	List<TamizajeZikaCluster> tamizajes = Arrays.asList(envio);
        	for (TamizajeZikaCluster tam : tamizajes){
        		tamizajeZikaClusterService.saveTamizajeZikaCluster(tam);
        	}
        }
        return "Datos recibidos!";
    }  
    
    
}
