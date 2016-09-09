package ni.org.ics.estudios.cohorte.muestreoanual.movilcontroller;

import java.util.Arrays;
import java.util.Date;
import java.util.List;
import javax.annotation.Resource;

import ni.org.ics.estudios.cohorte.muestreoanual.domain.Muestra;
import ni.org.ics.estudios.cohorte.muestreoanual.domain.MuestraId;
import ni.org.ics.estudios.cohorte.muestreoanual.service.MuestraService;

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
public class MuestraController {
	@Resource(name="muestraService")
	private MuestraService muestraService;
	private static final Logger logger = LoggerFactory.getLogger(MuestraController.class);

	/**
     * Retorna muestras. Acepta una solicitud GET para JSON
     * @return muestras JSON
     */
    @RequestMapping(value = "muestras", method = RequestMethod.GET, produces = "application/json")
    public @ResponseBody List<Muestra> descargarmuestras() {
        logger.info("Descargando toda la informacion de los datos de las muestras");
        List<Muestra> muestras = muestraService.getMuestras();
        if (muestras == null){
        	logger.debug("Nulo");
        }
        return muestras;	
    }
    
    
    
    /**
     * Acepta una solicitud POST con un parametro JSON
     * @param muestra Objeto serializado de Muestras
     * @return una cadena con el resultado*/
     
    @RequestMapping(value = "muestras", method = RequestMethod.POST, consumes = "application/json")
    public @ResponseBody String sendMessageJson(@RequestBody Muestra[] envio) {
        logger.debug("Insertando/Actualizando muestras");
        if (envio == null){
        	logger.debug("Nulo");
        	return "No recibi nada!";
        }
        else{
        	List<Muestra> muestras = Arrays.asList(envio);
        	for (Muestra muestra : muestras){
        		MuestraId mId = new MuestraId();
        		mId.setCodigo(muestra.getmId().getCodigo());
        		mId.setFechaMuestra(new Date(muestra.getmId().getFechaMuestra().getTime()));
        		Boolean existe = muestraService.checkMuestra(mId);
        		if (!existe){
        			muestraService.addMuestra(muestra);
        		}
        		else{
        			muestraService.updateMuestra(muestra);
        		}
        	}
        }
        return "Datos recibidos!";
    }  
    
    
}
