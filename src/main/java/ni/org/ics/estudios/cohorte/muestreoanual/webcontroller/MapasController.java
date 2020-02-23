package ni.org.ics.estudios.cohorte.muestreoanual.webcontroller;

import java.text.ParseException;
import java.util.List;
import javax.annotation.Resource;

import ni.org.ics.estudios.cohorte.muestreoanual.dto.PuntoGps;
import ni.org.ics.estudios.cohorte.muestreoanual.service.LabBHCService;
import ni.org.ics.estudios.cohorte.muestreoanual.service.LabPbmcService;
import ni.org.ics.estudios.cohorte.muestreoanual.service.LabSeroService;
import ni.org.ics.estudios.cohorte.muestreoanual.service.MapaService;
import ni.org.ics.estudios.cohorte.muestreoanual.service.ReporteService;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

/**
 * Maneja las solicitudes que van a la aplicacion relacionadas a json
 * 
 * @author Brenda Lopez
 */
@Controller
@RequestMapping("/mapas/*")
public class MapasController {
	@Resource(name="mapaService")
	private MapaService mapaService;
	@Resource(name="labBhcService")
	private LabBHCService labBhcService;
	@Resource(name="labSeroService")
	private LabSeroService labSeroService;
	@Resource(name="labPbmcService")
	private LabPbmcService labPbmcService;
	@Resource(name="reporteService")
	private ReporteService reporteService;
	private static final Logger logger = LoggerFactory.getLogger(MapasController.class);
	
	
	@RequestMapping(value = "/cohorte", method = RequestMethod.GET)
    public String fetchCohorteJSP(Model model) throws ParseException {
    	logger.debug("Mostrando Mapa en JSP");
    	List<PuntoGps> participantes = mapaService.getParticipantesPuntosGps();
    	model.addAttribute("puntos", participantes);
    	List<Object> muestrasTotal = reporteService.getMuestrasTotal();
        model.addAttribute("muestrasTotal", muestrasTotal);
        List<Object> muestrasxEstudio = reporteService.getMuestrasxEstudio();
        model.addAttribute("muestrasEstudio", muestrasxEstudio);
        List<Object> muestrasxTubo = reporteService.getMuestrasxTubo();
        model.addAttribute("muestrasTubo", muestrasxTubo);
    	return "mapas/cohorteOSM";
	}  

	@RequestMapping(value = "/muestras", method = RequestMethod.GET)
    public String fetchMuestrasJSP(Model model) throws ParseException {
    	logger.debug("Mostrando Mapa en JSP");
    	List<PuntoGps> participantes = mapaService.getParticipantesMuestrasGps();
    	model.addAttribute("puntos", participantes);
    	List<Object> muestrasTotal = reporteService.getMuestrasTotal();
        model.addAttribute("muestrasTotal", muestrasTotal);
        List<Object> muestrasxEstudio = reporteService.getMuestrasxEstudio();
        model.addAttribute("muestrasEstudio", muestrasxEstudio);
        List<Object> muestrasxTubo = reporteService.getMuestrasxTubo();
        model.addAttribute("muestrasTubo", muestrasxTubo);
    	return "mapas/muestrasOSM";
	}   	
	
	@RequestMapping(value = "/pendientes", method = RequestMethod.GET)
    public String fetchPendientesJSP(Model model) throws ParseException {
    	logger.debug("Mostrando Mapa en JSP");
    	List<PuntoGps> participantes = mapaService.getParticipantesPendientesGps();
    	model.addAttribute("puntos", participantes);
    	List<Object> muestrasTotal = reporteService.getMuestrasTotal();
        model.addAttribute("muestrasTotal", muestrasTotal);
        List<Object> muestrasxEstudio = reporteService.getMuestrasxEstudio();
        model.addAttribute("muestrasEstudio", muestrasxEstudio);
        List<Object> muestrasxTubo = reporteService.getMuestrasxTubo();
        model.addAttribute("muestrasTubo", muestrasxTubo);
    	return "mapas/pendientesOSM";
	}
}
