package ni.org.ics.estudios.cohorte.muestreoanual.movilcontroller;

import java.util.Arrays;
import java.util.Date;
import java.util.List;
import javax.annotation.Resource;



import ni.org.ics.estudios.cohorte.muestreoanual.domain.Vacuna;
import ni.org.ics.estudios.cohorte.muestreoanual.domain.VacunaId;
import ni.org.ics.estudios.cohorte.muestreoanual.service.VacunaService;

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
public class VacunaController {
	@Resource(name="vacunaService")
	private VacunaService vacunaService;
	private static final Logger logger = LoggerFactory.getLogger(VacunaController.class);

	/**
     * Retorna muestras. Acepta una solicitud GET para JSON
     * @return muestras JSON
     */
    @RequestMapping(value = "vacunas", method = RequestMethod.GET, produces = "application/json")
    public @ResponseBody List<Vacuna> descargarVacunas() {
        logger.info("Descargando toda la informacion de los datos de las Vacunas");
        List<Vacuna> vacunas = vacunaService.getVacunas();
        if (vacunas == null){
        	logger.debug("Nulo");
        }
        return vacunas;	
    }
    
    
    
    /**
     * Acepta una solicitud POST con un parametro JSON
     * @param muestra Objeto serializado de Vacuna
     * @return una cadena con el resultado*/
     
    @RequestMapping(value = "vacunas", method = RequestMethod.POST, consumes = "application/json")
    public @ResponseBody String sendMessageJson(@RequestBody Vacuna[] envio) {
        logger.debug("Insertando/Actualizando Vacunas");
        if (envio == null){
        	logger.debug("Nulo");
        	return "No recibi nada!";
        }
        else{
        	List<Vacuna> vacunas = Arrays.asList(envio);
        	for (Vacuna vacuna : vacunas){
        		VacunaId vacId = new VacunaId();
        		vacId.setCodigo(vacuna.getVacunaId().getCodigo());
        		vacId.setFechaVacuna(new Date(vacuna.getVacunaId().getFechaVacuna().getTime()));
        		Boolean existe = vacunaService.checkVacuna(vacId);
        		if (!existe){
        			vacunaService.addVacuna(vacuna);
        		}
        		else{
        			vacunaService.updateVacuna(vacuna);
        		}
        	}
        }
        return "Datos recibidos!";
    }  
    
    
}
