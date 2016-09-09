package ni.org.ics.estudios.cohorte.muestreoanual.webcontroller;

import java.text.ParseException;
import java.util.List;
import javax.annotation.Resource;

import ni.org.ics.estudios.cohorte.muestreoanual.domain.ReConsentimientoDen;
import ni.org.ics.estudios.cohorte.muestreoanual.service.LabBHCService;
import ni.org.ics.estudios.cohorte.muestreoanual.service.LabPbmcService;
import ni.org.ics.estudios.cohorte.muestreoanual.service.LabSeroService;
import ni.org.ics.estudios.cohorte.muestreoanual.service.ReConsentimientoDenService;
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
@RequestMapping("/consentimientos/*")
public class ConsentimientosController {
	@Resource(name="reconsentimientoService")
	private ReConsentimientoDenService reconsentimientoService;
	@Resource(name="labBhcService")
	private LabBHCService labBhcService;
	@Resource(name="labSeroService")
	private LabSeroService labSeroService;
	@Resource(name="labPbmcService")
	private LabPbmcService labPbmcService;
	@Resource(name="reporteService")
	private ReporteService reporteService;
	private static final Logger logger = LoggerFactory.getLogger(ConsentimientosController.class);

	@RequestMapping(value = "/consentimientos", method = RequestMethod.GET)
    public String fetchConsentimientosJSP(Model model) throws ParseException { 	
    	logger.debug("Mostrando Consentimientos en JSP");
    	List<ReConsentimientoDen> consentimientos = reconsentimientoService.getReConsentimientos();
    	model.addAttribute("consentimientos", consentimientos);
    	List<Object> muestrasTotal = reporteService.getMuestrasTotal();
        model.addAttribute("muestrasTotal", muestrasTotal);  
        List<Object> muestrasxEstudio = reporteService.getMuestrasxEstudio();
        model.addAttribute("muestrasEstudio", muestrasxEstudio);
        List<Object> muestrasxTubo = reporteService.getMuestrasxTubo();
        model.addAttribute("muestrasTubo", muestrasxTubo);
    	return "consentimientos/consentimientos";
	}   
}
