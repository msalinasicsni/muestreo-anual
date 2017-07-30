package ni.org.ics.estudios.cohorte.muestreoanual.webcontroller;

import java.io.IOException;
import java.io.UnsupportedEncodingException;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import javax.annotation.Resource;
import javax.validation.Valid;

import ni.org.ics.estudios.cohorte.muestreoanual.domain.Barrio;
import ni.org.ics.estudios.cohorte.muestreoanual.domain.Participante;
import ni.org.ics.estudios.cohorte.muestreoanual.domain.Sms;
import ni.org.ics.estudios.cohorte.muestreoanual.service.CasaService;
import ni.org.ics.estudios.cohorte.muestreoanual.service.ParticipanteService;
import ni.org.ics.estudios.cohorte.muestreoanual.service.ReporteService;
import ni.org.ics.estudios.cohorte.muestreoanual.service.SmsService;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.support.SessionStatus;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;
import org.apache.http.HttpEntity;
import org.apache.http.HttpHost;
import org.apache.http.HttpResponse;
import org.apache.http.auth.AuthScope;
import org.apache.http.auth.UsernamePasswordCredentials;
import org.apache.http.client.AuthCache;
import org.apache.http.client.entity.UrlEncodedFormEntity;
import org.apache.http.client.methods.HttpPost;
import org.apache.http.client.protocol.ClientContext;
import org.apache.http.impl.auth.BasicScheme;
import org.apache.http.impl.client.BasicAuthCache;
import org.apache.http.impl.client.DefaultHttpClient;
import org.apache.http.message.BasicNameValuePair;
import org.apache.http.protocol.BasicHttpContext;
import org.apache.http.util.EntityUtils;

import org.json.JSONException;
import org.json.JSONObject;

import com.google.gson.Gson;


/**
 * Controlador web de peticiones relacionadas a sms
 * 
 * @author William Aviles
 */
@Controller
@RequestMapping("/sms/*")
public class SmsController {
	
	@Resource(name="smsService")
	private SmsService smsService;
	@Resource(name="reporteService")
	private ReporteService reporteService;
	@Resource(name="casaService")
	private CasaService casaService;
	@Resource(name="participanteService")
	private ParticipanteService participanteService;
	
	private static final Logger logger = LoggerFactory.getLogger(SmsController.class);
    
    @RequestMapping(value = "/admin/sms", method = RequestMethod.GET)
    public String initCreationSms(Model model) {
    	logger.debug("Creando SMS");
    	Sms sms = new Sms();
    	model.addAttribute(sms);
    	List<Object> muestrasTotal = reporteService.getMuestrasTotal();
        model.addAttribute("muestrasTotal", muestrasTotal);
        List<Object> muestrasxEstudio = reporteService.getMuestrasxEstudio();
        model.addAttribute("muestrasEstudio", muestrasxEstudio);
        List<Object> muestrasxTubo = reporteService.getMuestrasxTubo();
        model.addAttribute("muestrasTubo", muestrasxTubo);
        return "sms/CreateSmsForm";
    }
    
    @RequestMapping(value = "/admin/sms2", method = RequestMethod.GET)
    public String initCreationSms2(Model model) {
    	logger.debug("Creando SMS en lote");
    	List<Object> muestrasTotal = reporteService.getMuestrasTotal();
        model.addAttribute("muestrasTotal", muestrasTotal);
        List<Object> muestrasxEstudio = reporteService.getMuestrasxEstudio();
        model.addAttribute("muestrasEstudio", muestrasxEstudio);
        List<Object> muestrasxTubo = reporteService.getMuestrasxTubo();
        model.addAttribute("muestrasTubo", muestrasxTubo);
        List<Barrio> barrios = casaService.getBarrios();
        model.addAttribute("barrios", barrios);
        List<Object> mensajes = casaService.getMensajesSms();
        model.addAttribute("mensajes", mensajes);
        return "sms/CreateSmsBatchForm";
    }
      
    @RequestMapping(value = "/admin/sms", method = RequestMethod.POST)
    public String processCreationSms(@Valid Sms sms, BindingResult result, SessionStatus status, RedirectAttributes redirectAttributes) throws UnsupportedEncodingException {
    	String respuesta="";
    	String apiKey = casaService.getApiKeySms();
    	String projectId = casaService.getProjectIdSms();
        String phoneId1 = casaService.getPhone1Sms();
        //String phoneId2 = casaService.getPhone2Sms();
    	respuesta = sendSms(sms.getContent(),sms.getToNumber(),apiKey,projectId,phoneId1);
    	redirectAttributes.addFlashAttribute("respuesta", respuesta);
        return "redirect:sms";
    }
    
    @RequestMapping(value = "/admin/sms2", method = RequestMethod.GET, produces = "application/json")
    public @ResponseBody List<Participante> fetchParticipantesJson(@RequestParam(value = "barrio", required = true) Integer barrio,
    		@RequestParam(value = "tubo", required = true) String tubo,
    		@RequestParam(value = "estudio", required = true) String estudio,
    		@RequestParam(value = "mensaje", required = true) Integer mensaje,
    		@RequestParam(value = "edad", required = true) String edad){
        logger.info("Obteniendo los participantes en JSON");
        List<Participante> participantes = participanteService.getParticipantesMensajes(barrio,tubo,estudio,edad);
        if (participantes == null){
        	logger.debug("Nulo");
        }
        return participantes;	
    }
    
    @RequestMapping(value = "/admin/smssend", method = RequestMethod.POST)
    public ResponseEntity<String> processCreationBatchSms(@RequestParam(value = "barrio", required = true) Integer barrio,
    		@RequestParam(value = "tubo", required = true) String tubo,
    		@RequestParam(value = "estudio", required = true) String estudio,
    		@RequestParam(value = "mensaje", required = true) Integer mensaje,
    		@RequestParam(value = "edad", required = true) String edad) {
    	
    	List<Participante> participantes = participanteService.getParticipantesMensajes(barrio,tubo,estudio,edad);
    	String mensajeEnviar = casaService.getMensajeSms(mensaje);
    	String apiKey = casaService.getApiKeySms();
    	String projectId = casaService.getProjectIdSms();
        String phoneId1 = casaService.getPhone1Sms();
        String phoneId2 = casaService.getPhone2Sms();
    	int i = 0;
    	for(Participante participante:participantes){
    		i++;
    		if(i % 2 == 0){
    			sendSms(mensajeEnviar,participante.getTelefono(),apiKey,projectId,phoneId1);
    		}
    		else{
    			sendSms(mensajeEnviar,participante.getTelefono(),apiKey,projectId,phoneId2);
    		}
    		
    	}
    	return createJsonResponse("Listo");
    }
    
    public String sendSms(String mensaje, String telefono, 
    		String apiKey, String projectId, String phone){
    	logger.debug("Creando SMSs");
    	HttpHost host = new HttpHost("api.telerivet.com", 443, "https");        
        HttpPost request = new HttpPost("/v1/projects/"+projectId+"/messages/outgoing");
        ArrayList<BasicNameValuePair> params = new ArrayList<BasicNameValuePair>();
        params.add(new BasicNameValuePair("content", mensaje));
        params.add(new BasicNameValuePair("phone_id", phone));
        params.add(new BasicNameValuePair("to_number", telefono));
        try {
			request.setEntity(new UrlEncodedFormEntity(params, "UTF-8"));
		} catch (UnsupportedEncodingException e) {
			e.printStackTrace();
		}
        AuthCache authCache = new BasicAuthCache();
        BasicScheme basicAuth = new BasicScheme();
        authCache.put(host, basicAuth);        
        BasicHttpContext context = new BasicHttpContext();
        context.setAttribute(ClientContext.AUTH_CACHE, authCache);
        DefaultHttpClient client = new DefaultHttpClient();        
        client.getCredentialsProvider().setCredentials(
                new AuthScope(host.getHostName(), host.getPort()),
                new UsernamePasswordCredentials(apiKey, ""));      
        try
        {
            HttpResponse response = client.execute(host, request, context);
            HttpEntity entity = response.getEntity();
            String responseStr = EntityUtils.toString(entity, "UTF-8");
            JSONObject json = new JSONObject(responseStr);
            if (json.has("error"))
            {
                System.err.println(json); // do something with the error
                EntityUtils.consume(entity);  
                String error = json.getJSONObject("error").getString("message");
                return "Error: "+ error;
            }
            else
            {
            	Sms sms = new Sms();
            	sms.setContent(mensaje);
            	sms.setToNumber(telefono);
            	sms.setCreated(new Date());
            	smsService.addSms(sms);
                System.out.println(json); // do something with the response
                logger.debug("SMS Enviado y guardado");
                EntityUtils.consume(entity);   
                return "SMS Enviado y guardado";
            }
        }
        catch (JSONException ex)
        {
            ex.printStackTrace(System.err);
            return ex.getLocalizedMessage();
        }
        catch (IOException ex)
        {
            ex.printStackTrace(System.err);
            return ex.getLocalizedMessage(); 
        }
        finally 
        {
            client.getConnectionManager().shutdown();
        }
    }
    
    private ResponseEntity<String> createJsonResponse( Object o )
	{
	    HttpHeaders headers = new HttpHeaders();
	    headers.set("Content-Type", "application/json");
	    Gson gson = new Gson();
	    String json = gson.toJson( o );
	    return new ResponseEntity<String>( json, headers, HttpStatus.CREATED );
	}
	
}
