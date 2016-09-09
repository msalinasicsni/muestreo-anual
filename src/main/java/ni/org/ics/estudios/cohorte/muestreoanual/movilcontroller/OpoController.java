package ni.org.ics.estudios.cohorte.muestreoanual.movilcontroller;

import java.util.Date;
import java.util.List;

import javax.annotation.Resource;

import ni.org.ics.estudios.cohorte.muestreoanual.domain.Opo;
import ni.org.ics.estudios.cohorte.muestreoanual.service.OpoService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;

/**
 * Maneja las solicitudes que van a la aplicacion relacionadas a json
 * 
 * @author Brenda Lopez
 */
@Controller
@RequestMapping("/sensors/*")
public class OpoController {
	
	@Resource(name="opoService")
	private OpoService opoService;
	private static final Logger logger = LoggerFactory.getLogger(OpoController.class);

	
	@RequestMapping(value = "opo", method = RequestMethod.GET, produces = "application/json")
    public @ResponseBody List<Opo> enviaropos() {
        logger.info(new Date() + " - Descargando toda la informacion de los datos de los sensores");
        List<Opo> opos = opoService.getOpo();
        if (opos == null){
        	logger.debug("Nulo");
        }
        return opos;
    }
	
    @RequestMapping(value = "opo", method = RequestMethod.POST, consumes = "application/json") 
    public @ResponseBody String recibiropos(@RequestBody String envio) {
        logger.debug("Insertando/Actualizando las Opos");
        if (envio == null){
        	logger.debug("Nulo");
        	return "No recibi nada!";
        }
        else{
        	Gson gson = new GsonBuilder().create();
        	Opo opo = gson.fromJson(envio, Opo.class);
        	opo.setCreated(new Date());
        	opoService.addOpo(opo);
        }
        return "Datos recibidos!";
    }  
    
    
}
