package ni.org.ics.estudios.cohorte.muestreoanual.webcontroller.clusterzika;

import java.util.Arrays;
import java.util.Date;
import java.util.List;
import javax.annotation.Resource;

import ni.org.ics.estudios.cohorte.muestreoanual.domain.MovilInfo;
import ni.org.ics.estudios.cohorte.muestreoanual.domain.clusterzika.EncuestaParticipanteZikaCluster;
import ni.org.ics.estudios.cohorte.muestreoanual.service.clusterzika.EncuestaParticipanteZikaClusterService;
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
public class EncuestaParticipanteZikaClusterController {
	@Resource(name="encuestaParticipanteZikaClusterService")
	private EncuestaParticipanteZikaClusterService encuestaParticipanteZikaClusterService;
	private static final Logger logger = LoggerFactory.getLogger(EncuestaParticipanteZikaClusterController.class);

	/**
     * Retorna consentimientos. Acepta una solicitud GET para JSON
     * @return consentimientos JSON
     */
    @RequestMapping(value = "encuestaParticipante", method = RequestMethod.GET, produces = "application/json")
    public @ResponseBody List<EncuestaParticipanteZikaCluster> descargarEncuestaParticipante() {
        logger.info("Descargando toda la informacion de los datos de las EncuestaParticipanteZikaCluster");
        List<EncuestaParticipanteZikaCluster> encParticipantes = encuestaParticipanteZikaClusterService.getEncuestaParticipanteZikaCluster();
        if (encParticipantes == null){
        	logger.debug("Nulo");
        }
        return encParticipantes;	
    }
    
    
    @RequestMapping(value = "crearEncuestaParticipante", method = RequestMethod.GET, produces = "application/json")
    public @ResponseBody List<EncuestaParticipanteZikaCluster> crearEncuestaParticipante() {
        logger.info("Creando toda la informacion de los datos de las EncuestaParticipanteZikaCluster");
        EncuestaParticipanteZikaCluster ep = new EncuestaParticipanteZikaCluster();
        ep.setCodigo(999);
        ep.setMovilInfo(new MovilInfo(1, "t", "t", false, "t", "t", "t", "t", "t", "t", new Date(), "2", 999, 999));
        encuestaParticipanteZikaClusterService.saveEncuestaParticipanteZikaCluster(ep);
        List<EncuestaParticipanteZikaCluster> encParticipantes = encuestaParticipanteZikaClusterService.getEncuestaParticipanteZikaCluster();
        if (encParticipantes == null){
        	logger.debug("Nulo");
        }
        return encParticipantes;	
    }
    
    @RequestMapping(value = "consultarEncuestaParticipante", method = RequestMethod.GET, produces = "application/json")
    public @ResponseBody EncuestaParticipanteZikaCluster consultarEncuestaParticipante() {
        logger.info("Creando toda la informacion de los datos de las EncuestaParticipanteZikaCluster");
        
        EncuestaParticipanteZikaCluster encParticipante = encuestaParticipanteZikaClusterService.getEncuestaParticipanteZikaCluster(999);

        return encParticipante;	
    }
    
    
    
    /**
     * Acepta una solicitud POST con un parametro JSON
     * @param cons Objeto serializado de CasaZikaCluster
     * @return una cadena con el resultado*/
     
    @RequestMapping(value = "encuestaParticipante", method = RequestMethod.POST, consumes = "application/json")
    public @ResponseBody String sendMessageJson(@RequestBody EncuestaParticipanteZikaCluster[] envio) {
        logger.debug("Insertando/Actualizando EncuestaParticipanteZikaCluster");
        if (envio == null){
        	logger.debug("Nulo");
        	return "No recibi nada!";
        }
        else{
        	List<EncuestaParticipanteZikaCluster> encParticipantes = Arrays.asList(envio);
        	for (EncuestaParticipanteZikaCluster encParticipante : encParticipantes){
        		encuestaParticipanteZikaClusterService.saveEncuestaParticipanteZikaCluster(encParticipante);
        	}
        }
        return "Datos recibidos!";
    }  
    
    
}
