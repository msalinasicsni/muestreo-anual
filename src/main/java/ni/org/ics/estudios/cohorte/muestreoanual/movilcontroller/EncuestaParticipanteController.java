package ni.org.ics.estudios.cohorte.muestreoanual.movilcontroller;

import java.util.Arrays;
import java.util.Date;
import java.util.List;
import javax.annotation.Resource;


import ni.org.ics.estudios.cohorte.muestreoanual.domain.EncuestaParticipante;
import ni.org.ics.estudios.cohorte.muestreoanual.domain.EncuestaParticipanteId;
import ni.org.ics.estudios.cohorte.muestreoanual.service.EncuestaParticipanteService;

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
public class EncuestaParticipanteController {
	@Resource(name="encuestaParticipanteService")
	private EncuestaParticipanteService encuestaParticipanteService;
	private static final Logger logger = LoggerFactory.getLogger(EncuestaParticipanteController.class);

	/**
     * Retorna Encuesta de Participantes. Acepta una solicitud GET para JSON
     * @return Participantes JSON
     */
    @RequestMapping(value = "encuestasparticipantes", method = RequestMethod.GET, produces = "application/json")
    public @ResponseBody List<EncuestaParticipante> descargarEncuestasParticipantes() {
        logger.info("Descargando toda la informacion de las encuestas de participantes");
        List<EncuestaParticipante> encuestasParticipantes = encuestaParticipanteService.getEncuestasParticipantes();
        if (encuestasParticipantes == null){
        	logger.debug("Nulo");
        }
        return encuestasParticipantes ;	
    }
    
    
    
    /**
     * Acepta una solicitud POST con un parametro JSON
     * @param encuesta de Participante Objeto serializado de encuesta de Participante
     * @return una cadena con el resultado*/
    @RequestMapping(value = "encuestasparticipantes", method = RequestMethod.POST, consumes = "application/json") 
    public @ResponseBody String sendMessageJson(@RequestBody EncuestaParticipante[] envio) {
        logger.debug("Insertando/Actualizando las encuestas de Participantes");
        if (envio == null){
        	logger.debug("Nulo");
        	return "No recibi nada!";
        }
        else{
        	List<EncuestaParticipante> encuestasParticipantes= Arrays.asList(envio);
        	for (EncuestaParticipante encuestaParticipante: encuestasParticipantes){
        		EncuestaParticipanteId epId = new EncuestaParticipanteId();
        		epId.setCodigo(encuestaParticipante.getEpId().getCodigo());
        		epId.setFechaEncPar(new Date(encuestaParticipante.getEpId().getFechaEncPar().getTime()));
        		Boolean existe = encuestaParticipanteService.checkEncuestaParticipante(epId);
        		if (!existe){
        			encuestaParticipanteService.addEncuestaParticipante(encuestaParticipante);
        		}
        		else{
        			encuestaParticipanteService.updateEncuestaParticipante(encuestaParticipante);
        		}
        	}
        }
        return "Datos recibidos!";
    }  
    
    
}
