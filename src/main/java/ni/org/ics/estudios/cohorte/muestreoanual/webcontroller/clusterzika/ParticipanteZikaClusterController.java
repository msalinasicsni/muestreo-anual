package ni.org.ics.estudios.cohorte.muestreoanual.webcontroller.clusterzika;

import java.util.Arrays;
import java.util.List;
import javax.annotation.Resource;



import ni.org.ics.estudios.cohorte.muestreoanual.domain.clusterzika.ParticipanteZikaCluster;
import ni.org.ics.estudios.cohorte.muestreoanual.service.clusterzika.ParticipanteZikaClusterService;

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
public class ParticipanteZikaClusterController {
	@Resource(name="participanteZikaClusterService")
	private ParticipanteZikaClusterService participanteZikaClusterService;
	private static final Logger logger = LoggerFactory.getLogger(ParticipanteZikaClusterController.class);

	/**
     * Retorna consentimientos. Acepta una solicitud GET para JSON
     * @return consentimientos JSON
     */
    @RequestMapping(value = "participantes", method = RequestMethod.GET, produces = "application/json")
    public @ResponseBody List<ParticipanteZikaCluster> descargarParticipantes() {
        logger.info("Descargando toda la informacion de los datos de los ParticipanteZikaCluster");
        List<ParticipanteZikaCluster> participantes = participanteZikaClusterService.getParticipanteZikaCluster();
        if (participantes == null){
        	logger.debug("Nulo");
        }
        return participantes;	
    }
    
    
    
    /**
     * Acepta una solicitud POST con un parametro JSON
     * @param cons Objeto serializado de ParticipanteZikaCluster
     * @return una cadena con el resultado*/
     
    @RequestMapping(value = "participantes", method = RequestMethod.POST, consumes = "application/json")
    public @ResponseBody String sendMessageJson(@RequestBody ParticipanteZikaCluster[] envio) {
        logger.debug("Insertando/Actualizando ParticipanteZikaCluster");
        if (envio == null){
        	logger.debug("Nulo");
        	return "No recibi nada!";
        }
        else{
        	List<ParticipanteZikaCluster> participantes = Arrays.asList(envio);
        	for (ParticipanteZikaCluster participante : participantes){
        		participanteZikaClusterService.saveParticipanteZikaCluster(participante);
        	}
        }
        return "Datos recibidos!";
    }  
    
    
}
