package ni.org.ics.estudios.cohorte.muestreoanual.webcontroller.clusterzika;

import java.util.Arrays;
import java.util.List;
import javax.annotation.Resource;

import ni.org.ics.estudios.cohorte.muestreoanual.domain.clusterzika.MuestrasZikaCluster;
import ni.org.ics.estudios.cohorte.muestreoanual.service.clusterzika.MuestrasZikaClusterService;
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
public class MuestrasZikaClusterController {
	@Resource(name="muestrasZikaClusterService")
	private MuestrasZikaClusterService muestrasZikaClusterService;
	private static final Logger logger = LoggerFactory.getLogger(MuestrasZikaClusterController.class);

	/**
     * Retorna consentimientos. Acepta una solicitud GET para JSON
     * @return consentimientos JSON
     */
    @RequestMapping(value = "muestras", method = RequestMethod.GET, produces = "application/json")
    public @ResponseBody List<MuestrasZikaCluster> descargarMuestras() {
        logger.info("Descargando toda la informacion de los datos de los MuestrasZikaCluster");
        List<MuestrasZikaCluster> muestras = muestrasZikaClusterService.getMuestrasZikaCluster();
        if (muestras == null){
        	logger.debug("Nulo");
        }
        return muestras;	
    }
    
    
    
    /**
     * Acepta una solicitud POST con un parametro JSON
     * @param cons Objeto serializado de MuestrasZikaCluster
     * @return una cadena con el resultado*/
     
    @RequestMapping(value = "muestras", method = RequestMethod.POST, consumes = "application/json")
    public @ResponseBody String sendMessageJson(@RequestBody MuestrasZikaCluster[] envio) {
        logger.debug("Insertando/Actualizando MuestrasZikaCluster");
        if (envio == null){
        	logger.debug("Nulo");
        	return "No recibi nada!";
        }
        else{
        	List<MuestrasZikaCluster> muestras = Arrays.asList(envio);
        	for (MuestrasZikaCluster muestra : muestras){
        		muestrasZikaClusterService.saveMuestrasZikaCluster(muestra);
        	}
        }
        return "Datos recibidos!";
    }  
    
    
}
