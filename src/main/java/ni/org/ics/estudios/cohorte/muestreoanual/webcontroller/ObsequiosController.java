package ni.org.ics.estudios.cohorte.muestreoanual.webcontroller;

import java.text.ParseException;
import java.util.List;
import javax.annotation.Resource;

import ni.org.ics.estudios.cohorte.muestreoanual.domain.Obsequio;
import ni.org.ics.estudios.cohorte.muestreoanual.service.LabBHCService;
import ni.org.ics.estudios.cohorte.muestreoanual.service.LabPbmcService;
import ni.org.ics.estudios.cohorte.muestreoanual.service.LabSeroService;
import ni.org.ics.estudios.cohorte.muestreoanual.service.ObsequioService;
import ni.org.ics.estudios.cohorte.muestreoanual.service.ReporteService;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

/**
 * Maneja las solicitudes que van a la aplicacion relacionadas a json
 * 
 * @author Brenda Lopez
 */
@Controller
@RequestMapping("/obsequios/*")
public class ObsequiosController {
	@Resource(name="obsequioService")
	private ObsequioService obsequioService;
	@Resource(name="labBhcService")
	private LabBHCService labBhcService;
	@Resource(name="labSeroService")
	private LabSeroService labSeroService;
	@Resource(name="labPbmcService")
	private LabPbmcService labPbmcService;
	@Resource(name="reporteService")
	private ReporteService reporteService;
	private static final Logger logger = LoggerFactory.getLogger(ObsequiosController.class);

	@RequestMapping(value = "/obsequios", method = RequestMethod.GET)
    public String fetchPBMCsJSP(Model model) throws ParseException { 	
    	logger.debug("Mostrando Obsequios en JSP");
    	List<Obsequio> obsequios = obsequioService.getObsequiosSi();
    	model.addAttribute("obsequios", obsequios);
    	List<Object> muestrasTotal = reporteService.getMuestrasTotal();
        model.addAttribute("muestrasTotal", muestrasTotal);
        List<Object> muestrasxEstudio = reporteService.getMuestrasxEstudio();
        model.addAttribute("muestrasEstudio", muestrasxEstudio);
        List<Object> muestrasxTubo = reporteService.getMuestrasxTubo();
        model.addAttribute("muestrasTubo", muestrasxTubo);
    	return "obsequios/obsequios";
	}   
}
