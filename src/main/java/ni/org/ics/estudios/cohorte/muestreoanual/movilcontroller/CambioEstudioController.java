package ni.org.ics.estudios.cohorte.muestreoanual.movilcontroller;

import java.util.Arrays;
import java.util.Date;
import java.util.List;
import javax.annotation.Resource;



import ni.org.ics.estudios.cohorte.muestreoanual.domain.CambioEstudio;
import ni.org.ics.estudios.cohorte.muestreoanual.domain.CambioEstudioId;
import ni.org.ics.estudios.cohorte.muestreoanual.service.CambioEstudioService;
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
public class CambioEstudioController {
	@Resource(name="cambioEstudioService")
	private CambioEstudioService cambioEstudioService;
	private static final Logger logger = LoggerFactory.getLogger(CambioEstudioController.class);

	/**
     * Retorna cambios de estudio. Acepta una solicitud GET para JSON
     * @return cambios de estudio JSON
     */
    @RequestMapping(value = "cambest", method = RequestMethod.GET, produces = "application/json")
    public @ResponseBody List<CambioEstudio> descargarCambioEstudios() {
        logger.info("Descargando toda la informacion de los datos de los CambioEstudio");
        List<CambioEstudio> cambios = cambioEstudioService.getCambioEstudio();
        if (cambios == null){
        	logger.debug("Nulo");
        }
        return cambios;	
    }
    
    
    
    /**
     * Acepta una solicitud POST con un parametro JSON
     * @param cons Objeto serializado de CambioEstudio
     * @return una cadena con el resultado*/
     
    @RequestMapping(value = "cambest", method = RequestMethod.POST, consumes = "application/json")
    public @ResponseBody String sendMessageJson(@RequestBody CambioEstudio[] envio) {
        logger.debug("Insertando/Actualizando CambioEstudio");
        if (envio == null){
        	logger.debug("Nulo");
        	return "No recibi nada!";
        }
        else{
        	List<CambioEstudio> cambios = Arrays.asList(envio);
        	for (CambioEstudio cambio : cambios){
        		CambioEstudioId cambioId = new CambioEstudioId();
        		cambioId.setCodigo(cambio.getCambioEstudioId().getCodigo());
        		cambioId.setFechaCambio(new Date(cambio.getCambioEstudioId().getFechaCambio().getTime()));
        		Boolean existe = cambioEstudioService.checkCambioEstudio(cambioId);
        		if (!existe){
        			cambioEstudioService.addCambioEstudio(cambio);
        		}
        		else{
        			cambioEstudioService.updateCambioEstudio(cambio);
        		}
        	}
        }
        return "Datos recibidos!";
    }  
    
    
}
