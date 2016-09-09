package ni.org.ics.estudios.cohorte.muestreoanual.movilcontroller;

import java.util.Arrays;
import java.util.Date;
import java.util.List;
import javax.annotation.Resource;

import ni.org.ics.estudios.cohorte.muestreoanual.domain.Casa;
import ni.org.ics.estudios.cohorte.muestreoanual.service.CasaService;

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
 * @author Brenda Lopez
 */
@Controller
@RequestMapping("/movil/*")
public class CasaController {
	@Resource(name="casaService")
	private CasaService casaService;
	private static final Logger logger = LoggerFactory.getLogger(CasaController.class);

	/**
     * Retorna casas. Acepta una solicitud GET para JSON
     * @return casas JSON
     */
    @RequestMapping(value = "casas", method = RequestMethod.GET, produces = "application/json")
    public @ResponseBody List<Casa> descargarcasas() {
        logger.info(new Date() + " - Descargando toda la informacion de los datos de las casas");
        List<Casa> casas = casaService.getCasas();
        if (casas == null){
        	logger.debug(new Date() + " - Nulo");
        }
        return casas;	
    }
    
    /**
     * Retorna casa. Acepta una solicitud GET para JSON
     * @return participante JSON
     */
    @RequestMapping(value = "casa/{casa}", method = RequestMethod.GET, produces = "application/json")
    public @ResponseBody List<Casa> descargarCasa(@PathVariable Integer casa) {
        logger.info(new Date() + " - Descargando toda la informacion de la casa" + casa);
        List<Casa> casaPar = casaService.getCasaParticipante(casa);
        if (casaPar == null){
        	logger.debug(new Date() + " - Nulo");
        }
        return casaPar;	
    }
    
    /**
     * Acepta una solicitud POST con un parametro JSON
     * @param casa Objeto serializado de Casa
     * @return una cadena con el resultado*/
     
    @RequestMapping(value = "casas", method = RequestMethod.POST, consumes = "application/json")
    public @ResponseBody String sendMessageJson(@RequestBody Casa[] envio) {
        if (envio == null){
        	logger.debug(new Date() + " - Nulo");
        	return "No recibi nada!";
        }
        else{
        	List<Casa> casas = Arrays.asList(envio);
        	for (Casa casa: casas){
        		Boolean existe = casaService.checkCasa(casa.getCodCasa());
        		if (!existe){
        			logger.debug(new Date() + " - Insertando casa " + casa.getCodCasa());
        			casaService.addCasa(casa);
        		}
        		else{
        			logger.debug(new Date() + " - Modificando casa " + casa.getCodCasa());
        			casaService.updateCasa(casa);
        		}
        	}
        }
        return "Datos recibidos!";
    }  
    
    
}
