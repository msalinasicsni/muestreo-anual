package ni.org.ics.estudios.cohorte.muestreoanual.movilcontroller;

import java.util.Date;
import java.util.List;
import javax.annotation.Resource;



import ni.org.ics.estudios.cohorte.muestreoanual.domain.Documentos;
import ni.org.ics.estudios.cohorte.muestreoanual.service.DocumentosService;
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
public class DocumentosController {
	@Resource(name="documentosService")
	private DocumentosService documentosService;
	private static final Logger logger = LoggerFactory.getLogger(DocumentosController.class);

	/**
     * Retorna NewVacuna. Acepta una solicitud GET para JSON
     * @return NewVacuna JSON
     */
    @RequestMapping(value = "documentos", method = RequestMethod.GET, produces = "application/json")
    public @ResponseBody List<Documentos> descargarDocumentos() {
        logger.info("Descargando toda la informacion de los datos de las Documentos");
        List<Documentos> documentos = documentosService.getDocumentos();
        if (documentos == null){
        	logger.debug("Nulo");
        }
        return documentos;	
    }
    
    
    
    /**
     * Acepta una solicitud POST con un parametro JSON
     * @param muestra Objeto serializado de Documentos
     * @return una cadena con el resultado*/
     
    @RequestMapping(value = "documentos", method = RequestMethod.POST, consumes = "application/json")
    public @ResponseBody String sendMessageJson(@RequestBody Documentos envio) {
        logger.debug("Insertando/Actualizando Documentos");
        if (envio == null){
        	logger.debug("Nulo");
        	return "No recibi nada!";
        }
        else{
        	envio.setFechaRecepcion(new Date());
        	documentosService.updateDocumentos(envio);
        }
        return "Datos recibidos!";
    }  
    
    
}
