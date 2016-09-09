package ni.org.ics.estudios.cohorte.muestreoanual.webcontroller.clusterzika;

import java.util.Arrays;
import java.util.List;
import javax.annotation.Resource;



import ni.org.ics.estudios.cohorte.muestreoanual.domain.clusterzika.CasaZikaCluster;
import ni.org.ics.estudios.cohorte.muestreoanual.service.clusterzika.CasaZikaClusterService;
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
public class CasaZikaClusterController {
	@Resource(name="casaZikaClusterService")
	private CasaZikaClusterService casaZikaClusterService;
	private static final Logger logger = LoggerFactory.getLogger(CasaZikaClusterController.class);

	/**
     * Retorna consentimientos. Acepta una solicitud GET para JSON
     * @return consentimientos JSON
     */
    @RequestMapping(value = "casas", method = RequestMethod.GET, produces = "application/json")
    public @ResponseBody List<CasaZikaCluster> descargarCasas() {
        logger.info("Descargando toda la informacion de los datos de los CasaZikaCluster");
        List<CasaZikaCluster> casas = casaZikaClusterService.getCasaZikaCluster();
        if (casas == null){
        	logger.debug("Nulo");
        }
        return casas;	
    }
    
    
    
    /**
     * Acepta una solicitud POST con un parametro JSON
     * @param cons Objeto serializado de CasaZikaCluster
     * @return una cadena con el resultado*/
     
    @RequestMapping(value = "casas", method = RequestMethod.POST, consumes = "application/json")
    public @ResponseBody String sendMessageJson(@RequestBody CasaZikaCluster[] envio) {
        logger.debug("Insertando/Actualizando CasaZikaCluster");
        if (envio == null){
        	logger.debug("Nulo");
        	return "No recibi nada!";
        }
        else{
        	List<CasaZikaCluster> casas = Arrays.asList(envio);
        	for (CasaZikaCluster casa : casas){
        		casaZikaClusterService.saveCasaZikaCluster(casa);
        	}
        }
        return "Datos recibidos!";
    }  
    
    
}
