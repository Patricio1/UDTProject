package uta.gad.udt.controllers;

import java.math.BigDecimal;
import javax.servlet.http.HttpServletRequest;
import org.springframework.stereotype.Controller;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.beans.factory.annotation.Autowired;
import uta.gad.udt.models.dao.ContactFormValidator;
import uta.gad.udt.models.dao.VerifyRecaptcha;
import uta.gad.udt.models.entity.Contacto;
import uta.gad.udt.models.entity.Institucion;
import uta.gad.udt.models.entity.Link;
import uta.gad.udt.models.service.PublicoService;
import org.springframework.ui.Model;
import org.springframework.ui.ModelMap;

@Controller
@RequestMapping("/")
//@SessionAttributes("institucion")
public class InicioControlador {

	 	@Autowired
	    private PublicoService publicoService;
	 	
	 	@Autowired
		ContactFormValidator contactFormValidator;
		//Set a form validator
		/*@InitBinder
		protected void initBinder(WebDataBinder binder) {
			binder.setValidator(contactFormValidator);
		}*/
	
		@RequestMapping(method = RequestMethod.GET)		
		public ModelAndView defaultPage() {			
			ModelAndView model = new ModelAndView("inicio");
			model.addObject("destinos", publicoService.listarDestinosConProximasSalidas());
			model.addObject("comunicados", publicoService.listarComunicados());
			model.addObject("cooperativas", publicoService.getCooperativasTrabajanTerminal());
			model.addObject("slides", publicoService.getSlides());
			return model;
		}
		
		@RequestMapping(value="inicio", method = RequestMethod.GET)		
		public ModelAndView inicio() {			
			ModelAndView model = new ModelAndView("inicio");
			model.addObject("destinos", publicoService.listarDestinosConProximasSalidas());
			model.addObject("comunicados", publicoService.listarComunicados());
			model.addObject("cooperativas", publicoService.getCooperativasTrabajanTerminal());
			model.addObject("slides", publicoService.getSlides());
			
			Link link = new Link();
			link.setNombre("PA");
			link.setIcono("PE");
			link.setUrl("PI");
			//publicoService.addLink(link);
			
			BigDecimal lat = new BigDecimal(-12.455);
			BigDecimal lon = new BigDecimal(-34.88912);
			Institucion institucion = new Institucion
					(1,"sas", 
					"sas", 
					"Llegamos a todos los rincones del país", 
					"Av. Quito 5-23", 
					"0986385023,032768889", 
					"apatriciol_@hotmail.com",
					"8:00h-12:00|14:00-17:00", 
					"logo.png", 
					"mision", 
					"vision", 
					"valores", 
					"acercaDe", 
					lat, 
					lon);
			//publicoService.updateInstitucion(institucion);
			//administracionService.getInfoInstitucion();
		
			
			return model;
		}
		@RequestMapping(value="plan-estrategico" ,method = RequestMethod.GET)
		public ModelAndView planestrategico() {			
			ModelAndView model = new ModelAndView("plan-estrategico");
			model.addObject("planestrategico",publicoService.getPlanificacionEstrategica());
			return model;
		}
		@RequestMapping(value="tarifas-transporte" ,method = RequestMethod.GET)
		public ModelAndView tarifasTransporte() {			
			ModelAndView model = new ModelAndView("tarifas-transporte");
			model.addObject("listaTarifas",publicoService.getTarifaTransporte());
			return model;
		}
		
		@RequestMapping(value="directorio" ,method = RequestMethod.GET)
		public String directorio() {			
			// retornamos la vista form
			return "directorio";
		}
		@RequestMapping(value="organigrama" ,method = RequestMethod.GET)
		public String organigrama() {			
			// retornamos la vista form
			return "organigrama";
		}
		@RequestMapping(value="acerca-de-la-udt" ,method = RequestMethod.GET)
		public ModelAndView acercade() {			
			ModelAndView model = new ModelAndView("acercade");
			model.addObject("info",publicoService.getCoordenadasInstalacionesInstitucion());
			return model;
		}
		@RequestMapping(value="contacto" ,method = RequestMethod.GET)
		public ModelAndView contactenos(Model model) {			
			ModelAndView modelo = new ModelAndView("contacto");
			modelo.addObject("info",publicoService.getCoordenadasInstalacionesInstitucion());		
			Contacto mailData = new Contacto();
	        model.addAttribute("maildata", mailData);
			return modelo;
		}
		@RequestMapping(value="contacto" ,method = RequestMethod.POST)
		public String contacto(HttpServletRequest request,@ModelAttribute("maildata") Contacto mail,ModelMap model,BindingResult result) {
			//@ModelAttribute("userForm") @Validated User user,
			//BindingResult result, Model model,
			//final RedirectAttributes redirectAttributes
			
			
			/**contactFormValidator.validate(mail, result);
			if (result.hasErrors()) {*/
		
				
				MailSender ms = new MailSender(); 

				boolean resultado = ms.send("smtp-mail.outlook.com","apatriciol_@hotmail.com", 
				"landalaura@hotmail.com ","landalaura@hotmail.com", "landalaura@hotmail.com" , 
				"mail de prueba", false, new StringBuffer("hola"),true); 

				System.out.print("Resultado del envío del mensaje : " + resultado); 
				//model.addAttribute("error", "* Campos requeridos");
				model.addAttribute("error", "Resultado del envío del mensaje : " + resultado);
				// Reading Email Form Input Parameters		
				/**emailSubject = "prueba";
				emailMessage = "Saludos cordiales";
				emailToRecipient = "apatriciol_@hotmail.com";
				mailSenderObj.send(new MimeMessagePreparator() {
					public void prepare(MimeMessage mimeMessage) throws Exception {

						MimeMessageHelper mimeMsgHelperObj = new MimeMessageHelper(mimeMessage, true, "UTF-8");				
						mimeMsgHelperObj.setTo(emailFromRecipient);
						mimeMsgHelperObj.setFrom(emailToRecipient);				
						mimeMsgHelperObj.setText(emailMessage);
						mimeMsgHelperObj.setSubject(emailSubject);

					}
				});*/
				
			/*}
			else
			{
				//model.addAttribute("error", "Campos validos");
				try 
				{
					String gRecaptchaResponse = request.getParameter("g-recaptcha-response");
					boolean verify = VerifyRecaptcha.verify("6LfQETMUAAAAADPirHP4e824B8GAmfIoqwdijhLK", gRecaptchaResponse);
					if (verify) {
						//this.dataService.myservice(myfield);
						//model.addAttribute("envio", "Tu mensaje ha sido enviado.");
						model.addAttribute("envio", "Tus datos son válidos.");
						return "contacto";
					}
					else {
						model.addAttribute("error", "Por favor, prueba que no eres un robot");
					}
				} catch (Exception e) {
					throw e;
				}			
			}*/
			
			return "contacto";
		}
		
		@RequestMapping(value="como-llegar" ,method = RequestMethod.GET)
		public String comollegar() {			
			// retornamos la vista form
			return "como-llegar";
		}
		@RequestMapping(value="areas-transferencia" ,method = RequestMethod.GET)
		public String areasTransferencia() {			
			// retornamos la vista form
			return "areas-transferencia";
		}
		@RequestMapping(value="servicios" ,method = RequestMethod.GET)
		public ModelAndView serviciosCiudadania() {			
			ModelAndView model = new ModelAndView("servicios");
			model.addObject("servicios", publicoService.listarServicios());
			return model;
		}
		@RequestMapping(value="preguntas-frecuentes" ,method = RequestMethod.GET)
		public ModelAndView preguntasFrecuentes() {			
			ModelAndView model = new ModelAndView("preguntas-frecuentes");
			model.addObject("listaPreguntas", publicoService.getPreguntasFrecuentes());
			return model;
		}
		@RequestMapping(value="glosario" ,method = RequestMethod.GET)
		public ModelAndView glosario() {			
			ModelAndView model = new ModelAndView("glosario");
			model.addObject("glosario", publicoService.getPreguntaGlosario("G"));
			return model;
		}
		@RequestMapping(value="directorio-cooperativas" ,method = RequestMethod.GET)
		public ModelAndView directorioCooperativas() {			
			ModelAndView model = new ModelAndView("directorio-cooperativas");
			model.addObject("letraInicialCooperativas", publicoService.getLetraInicialCooperativa());
			model.addObject("listadoCooperativas",publicoService.getDetalleCooperativa());
			return model;
		}
		@RequestMapping(value="rutas" ,method = RequestMethod.GET)
		public String rutas() {			
			// retornamos la vista form
			return "rutas";
		}
		@RequestMapping(value="cooperativas" ,method = RequestMethod.GET)
		public ModelAndView cooperativas() {			
			ModelAndView model = new ModelAndView("cooperativas");
			model.addObject("destinos", publicoService.listarDestinosFrecuencia());
			return model;
		}
		@RequestMapping(value="cooperativas" ,method = RequestMethod.POST)
		public ModelAndView cooperativas_horario() {			
			ModelAndView model = new ModelAndView("cooperativas");
			model.addObject("destinos", publicoService.listarDestinosFrecuencia());
			//model.addObject("cooperativas", publicoService.listarDestinosFrecuencia());	
			return model;
		}
		@RequestMapping(value="proximas-salidas" ,method = RequestMethod.GET)
		public ModelAndView proximasSalidas() {						
			ModelAndView model = new ModelAndView("proximas-salidas");
			model.addObject("proximas_salidas", publicoService.listarProximasSalidas());
			return model;
		}
		@RequestMapping(value="tramites" ,method = RequestMethod.GET)
		public ModelAndView tramitesTransportistas() {			
			ModelAndView model = new ModelAndView("tramites");
			model.addObject("tramite", publicoService.getTramiteTransportista());
			return model;
		}
		@RequestMapping(value="consulta-multas" ,method = RequestMethod.GET)
		public String consultaMultas() {			
			// retornamos la vista form
			return "consulta-multas";
		}	
		@RequestMapping(value="consulta-multas" ,method = RequestMethod.POST)
		public String consultaMultasPorPlaca(HttpServletRequest request,Model model,@RequestParam("placa") String placaUnidadTransporte){			
		//	model.addAttribute("multas", publicoService.listarMultaPorPlacaUnidadT(placaUnidadTransporte));
			//return "consulta-multas";
			try {
				String gRecaptchaResponse = request.getParameter("g-recaptcha-response");
				boolean verify = VerifyRecaptcha.verify("6LfQETMUAAAAADPirHP4e824B8GAmfIoqwdijhLK", gRecaptchaResponse);
				if (verify) {
					//this.dataService.myservice(myfield);
					model.addAttribute("multas", publicoService.listarMultaPorPlacaUnidadT(placaUnidadTransporte));
					return "consulta-multas";
				}
				else {
					model.addAttribute("error", "Por favor, prueba que no eres un robot");
				}
			} catch (Exception e) {
				throw e;
			}
			return "consulta-multas";
		}
		@RequestMapping(value="areat-america" ,method = RequestMethod.GET)
		public String areaAmerica(Model model) {			
			// retornamos la vista form
			model.addAttribute("area", publicoService.getAreaTransferenciaPorNombre("América"));
			return "areat-america";
		}
		@RequestMapping(value="areat-cashapamba" ,method = RequestMethod.GET)
		public String areaCashapamba(Model model) {			
			// retornamos la vista form
			model.addAttribute("area", publicoService.getAreaTransferenciaPorNombre("Cashapamba"));
			return "areat-cashapamba";
		}
		@RequestMapping(value="comunicado" ,method = RequestMethod.GET)
		public String getComunicado(Model model, @ModelAttribute(value="c") String c) {			
			// retornamos la vista form
			try
			{
				int idComunicado= Integer.valueOf(c);
				model.addAttribute("comunicado", publicoService.getComunicadoNoticiaPorId("C", idComunicado));
			}
			catch(Exception ex)
			{				
			}			
			return "comunicado";
		}
		@RequestMapping(value="noticia" ,method = RequestMethod.GET)
		public String getNoticia(Model model, @ModelAttribute(value="n") String c) {			
			// retornamos la vista form
			try
			{
				int idNoticia= Integer.valueOf(c);
				model.addAttribute("noticia", publicoService.getComunicadoNoticiaPorId("N", idNoticia));
			}
			catch(Exception ex)
			{				
			}			
			return "noticia";
		}
		
		
		
		
	
		
		
		
		
		
}
