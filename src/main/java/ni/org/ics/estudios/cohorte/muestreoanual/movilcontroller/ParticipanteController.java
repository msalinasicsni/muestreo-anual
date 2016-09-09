package ni.org.ics.estudios.cohorte.muestreoanual.movilcontroller;

import java.util.Arrays;
import java.util.Date;
import java.util.List;
import javax.annotation.Resource;

import ni.org.ics.estudios.cohorte.muestreoanual.domain.Participante;
import ni.org.ics.estudios.cohorte.muestreoanual.service.ParticipanteService;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

/**
 * Maneja las solicitudes que van a la aplicacion relacionadas a json
 * 
 * @author William Aviles
 */
@Controller
@RequestMapping("/movil/*")
public class ParticipanteController {
	@Resource(name="participanteService")
	private ParticipanteService participanteService;
	private static final Logger logger = LoggerFactory.getLogger(ParticipanteController.class);
    
	/**
     * Retorna participantes. Acepta una solicitud GET para JSON
     * @return participantes JSON
     */
    @RequestMapping(value = "participantes", method = RequestMethod.GET, produces = "application/json")
    public @ResponseBody List<Participante> descargarParticipantes() {
        logger.info("Descargando toda la informacion de participantes");
        List<Participante> participantes = participanteService.getParticipantes();
        if (participantes == null){
        	logger.debug(new Date() + " - Nulo");
        }
        return participantes;	
    }
    
    /**
     * Retorna participantes activos. Acepta una solicitud GET para JSON
     * @return participantes JSON
     */
    @RequestMapping(value = "participantesactivos", method = RequestMethod.GET, produces = "application/json")
    public @ResponseBody List<Participante> descargarParticipantesActivos() {
        logger.info("Descargando toda la informacion de participantes activos");
        List<Participante> participantes = participanteService.getParticipantesActivos();
        if (participantes == null){
        	logger.debug("Nulo");
        }
        return participantes;	
    }
    
    /**
     * Retorna participante. Acepta una solicitud GET para JSON
     * @return participante JSON
     */
    @RequestMapping(value = "participante/{codigo}", method = RequestMethod.GET, produces = "application/json")
    public @ResponseBody List<Participante> descargarParticipante(@PathVariable Integer codigo) {
        logger.info("Descargando toda la informacion del participante "+codigo);
        List<Participante> participantes = participanteService.getParticipanteMovil(codigo);
		if (participantes == null){
        	logger.debug(new Date() + " - Nulo");
        }
        return participantes;	
    }
    
    /**
     * Retorna codigo casa. Acepta una solicitud GET para JSON
     * @return participante JSON
     */
    @RequestMapping(value = "checkcasa/{codigo}", method = RequestMethod.GET, produces = "application/json")
    public @ResponseBody Integer checkCasa(@PathVariable Integer codigo) {
        logger.info("Descargando codigo de casa del participante");
		Integer codCasa = participanteService.checkCasa(codigo);
        if (codCasa == null){
        	logger.debug("Nulo");
        }
        return codCasa;	
    }
    
      
    /**
     * Acepta una solicitud POST con un parametro JSON
     * @param participante Objeto serializado de Participante
     * @return una cadena con el resultado*/
     
    @RequestMapping(value = "participantes", method = RequestMethod.POST, consumes = "application/json")
    public @ResponseBody String sendMessageJson(@RequestBody Participante[] envio) {
        if (envio == null){
        	logger.debug(new Date() + " - Nulo");
        	return "No recibi nada!";
        }
        else{
        	List<Participante> participantes = Arrays.asList(envio);
        	for (Participante participante : participantes){
        		Integer codigo = participante.getCodigo();
        		Boolean existe = participanteService.checkParticipante(codigo);
                if (!existe){
                	logger.debug(new Date() + " - Insertando participante "+codigo);
                	participanteService.addParticipante(participante);
                }
                else{
                	logger.debug(new Date() + " - Modificando participante "+codigo);
                	participanteService.updateParticipante(participante);
                } 
        	}
        }
        return "Datos recibidos!";
    }
    
}
