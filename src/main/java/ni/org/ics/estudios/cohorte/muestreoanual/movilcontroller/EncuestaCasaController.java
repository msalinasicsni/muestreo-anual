package ni.org.ics.estudios.cohorte.muestreoanual.movilcontroller;

import java.util.Arrays;
import java.util.Date;
import java.util.List;
import javax.annotation.Resource;


import ni.org.ics.estudios.cohorte.muestreoanual.domain.EncuestaCasa;
import ni.org.ics.estudios.cohorte.muestreoanual.domain.EncuestaCasaId;
import ni.org.ics.estudios.cohorte.muestreoanual.service.EncuestaCasaService;

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
public class EncuestaCasaController {
	@Resource(name="encuestaCasaService")
	private EncuestaCasaService encuestaCasaService;
	private static final Logger logger = LoggerFactory.getLogger(EncuestaCasaController.class);

	/**
     * Retorna Encuesta de casas. Acepta una solicitud GET para JSON
     * @return casas JSON
     */
    @RequestMapping(value = "encuestascasas", method = RequestMethod.GET, produces = "application/json")
    public @ResponseBody List<EncuestaCasa> descargarEncuestasCasas() {
        logger.info("Descargando toda la informacion de las encuestas de casas");
        List<EncuestaCasa> encuestasCasas = encuestaCasaService.getEncuestasCasas();
        if (encuestasCasas == null){
        	logger.debug("Nulo");
        }
        return encuestasCasas ;	
    }
    
    
    
    /**
     * Acepta una solicitud POST con un parametro JSON
     * @param encuesta de casa Objeto serializado de encuesta de Casa
     * @return una cadena con el resultado*/
    @RequestMapping(value = "encuestascasas", method = RequestMethod.POST, consumes = "application/json") 
    public @ResponseBody String sendMessageJson(@RequestBody EncuestaCasa[] envio) {
        logger.debug("Insertando/Actualizando las encuestas de casas");
        if (envio == null){
        	logger.debug("Nulo");
        	return "No recibi nada!";
        }
        else{
        	List<EncuestaCasa> casas = Arrays.asList(envio);
        	for (EncuestaCasa encuestaCasa: casas){
        		EncuestaCasaId encCasaId = new EncuestaCasaId();
        		encCasaId.setCodCasa(encuestaCasa.getEncCasaId().getCodCasa());
        		encCasaId.setFechaEncCasa(new Date(encuestaCasa.getEncCasaId().getFechaEncCasa().getTime()));
        		
        		Boolean existe = encuestaCasaService.checkEncuestaCasa(encCasaId);
        		if (!existe){
        			encuestaCasaService.addEncuestaCasa(encuestaCasa);
        		}
        		else{
        			encuestaCasaService.updateEncuestaCasa(encuestaCasa);
        		}
        	}
        }
        return "Datos recibidos!";
    }  
    
    
}
