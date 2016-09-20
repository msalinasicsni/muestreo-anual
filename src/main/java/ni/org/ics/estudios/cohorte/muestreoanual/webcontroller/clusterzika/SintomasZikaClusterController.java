package ni.org.ics.estudios.cohorte.muestreoanual.webcontroller.clusterzika;

import java.util.Arrays;
import java.util.List;
import javax.annotation.Resource;



import ni.org.ics.estudios.cohorte.muestreoanual.domain.clusterzika.CasaZikaCluster;
import ni.org.ics.estudios.cohorte.muestreoanual.domain.clusterzika.SintomasZikaCluster;
import ni.org.ics.estudios.cohorte.muestreoanual.service.clusterzika.CasaZikaClusterService;
import ni.org.ics.estudios.cohorte.muestreoanual.service.clusterzika.SintomasZikaClusterService;

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
public class SintomasZikaClusterController {
	@Resource(name="sintomasZikaClusterService")
	private SintomasZikaClusterService sintomasZikaClusterService;
	private static final Logger logger = LoggerFactory.getLogger(SintomasZikaClusterController.class);

	/**
     * Retorna consentimientos. Acepta una solicitud GET para JSON
     * @return consentimientos JSON
     */
    @RequestMapping(value = "Sintomas", method = RequestMethod.GET, produces = "application/json")
    public @ResponseBody List<SintomasZikaCluster> descargarCasas() {
        logger.info("Descargando toda la informacion de los datos de los SintomasZikaCluster");
        List<SintomasZikaCluster> Sintomas = sintomasZikaClusterService.getSintomasZikaCluster();
        if (Sintomas == null){
        	logger.debug("Nulo");
        }
        return Sintomas;	
    }
    
    
    
    /**
     * Acepta una solicitud POST con un parametro JSON
     * @param cons Objeto serializado de SintomasZikaCluster
     * @return una cadena con el resultado*/
     
    @RequestMapping(value = "sintomas", method = RequestMethod.POST, consumes = "application/json")
    public @ResponseBody String sendMessageJson(@RequestBody SintomasZikaCluster[] envio) {
        logger.debug("Insertando/Actualizando SintomasZikaCluster");
        if (envio == null){
        	logger.debug("Nulo");
        	return "No recibi nada!";
        }
        else{
        	List<SintomasZikaCluster> sintomas = Arrays.asList(envio);
        	for (SintomasZikaCluster sintoma : sintomas){
        		sintomasZikaClusterService.saveSintomasZikaCluster(sintoma);
        	}
        }
        return "Datos recibidos!";
    }  
    
    
}
