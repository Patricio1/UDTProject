package uta.gad.udt.controllers;

import java.math.BigDecimal;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.mail.SimpleMailMessage;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.security.authentication.AuthenticationTrustResolver;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.web.authentication.logout.SecurityContextLogoutHandler;
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
	 	
	 	 @Autowired
	 	 private JavaMailSender mailSender;
	 	 
	 	 //secuity spring mvc+hibernate
	 	 //http://websystique.com/spring-security/spring-security-4-password-encoder-bcrypt-example-with-hibernate/
	 	 
	 	 //Cross Site Request Forgery (CSRF)
	 	//https://docs.spring.io/spring-security/site/docs/current/reference/html/csrf.html
	 	
	
		/**@RequestMapping(method = RequestMethod.GET)		
		public ModelAndView defaultPage() {			
			ModelAndView model = new ModelAndView("inicio");
			model.addObject("destinos", publicoService.listarDestinosConProximasSalidas());
			model.addObject("comunicados", publicoService.listarComunicados());
			model.addObject("cooperativas", publicoService.getCooperativasTrabajanTerminal());
			model.addObject("slides", publicoService.getSlides());
			
			
			
			return model;
		}*/
	 	/**@RequestMapping(value = "login", method = RequestMethod.GET)
	    public String loginPage() {
	        if (isCurrentAuthenticationAnonymous()) {
	            return "login";
	        } else {
	            return "redirect:/list";  
	        }
	    }*/
	 	 /**
	     * This method returns the principal[user-name] of logged-in user.
	     */
	 	@RequestMapping(value = "login", method = RequestMethod.GET)
	    public String loginPage() {
	        return "login";
	    }
	 	
	 	@RequestMapping(value="logout", method = RequestMethod.GET)
	    public String logoutPage (HttpServletRequest request, HttpServletResponse response) {
	        Authentication auth = SecurityContextHolder.getContext().getAuthentication();
	        if (auth != null){    
	            new SecurityContextLogoutHandler().logout(request, response, auth);
	        }
	        return "redirect:/login?logout";
	    }
	 	@RequestMapping(value = "no_autorizado", method = RequestMethod.GET)
	    public String accessDeniedPage(ModelMap model) {
	        model.addAttribute("user", getPrincipal());
	        return "no-autorizado";
	    }
	 	  private String getPrincipal(){
		        String userName = null;
		        Object principal = SecurityContextHolder.getContext().getAuthentication().getPrincipal();
		 
		        if (principal instanceof UserDetails) {
		            userName = ((UserDetails)principal).getUsername();
		        } else {
		            userName = principal.toString();
		        }
		        return userName;
		    }
	     
	    
	    
	     /** This method returns true if users is already authenticated [logged-in], else false.
	     
	    private boolean isCurrentAuthenticationAnonymous() {
	        final Authentication authentication = SecurityContextHolder.getContext().getAuthentication();
	        return authenticationTrustResolver.isAnonymous(authentication);
	    }*/
	    
	 	/**@RequestMapping(value="login" ,method = RequestMethod.GET)
		public String login(Model model, String error, String logout) {
	 		if (error != null)
	            model.addAttribute("error", "Your username and password is invalid.");

	        if (logout != null)
	            model.addAttribute("message", "You have been logged out successfully.");
	        return "login";
	 		//ModelAndView model = new ModelAndView("login");
			//return model;
		}*/
		
		@RequestMapping(value="inicio", method = RequestMethod.GET)		
		public ModelAndView inicio() {			
			ModelAndView model = new ModelAndView("inicio");
			model.addObject("destinos", publicoService.listarDestinosConProximasSalidas());
			model.addObject("comunicados", publicoService.listarComunicados());
			model.addObject("cooperativas", publicoService.getCooperativasTrabajanTerminal());
			model.addObject("slides", publicoService.getSlides());			
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
			contactFormValidator.validate(mail, result);
			model.addAttribute("info",publicoService.getCoordenadasInstalacionesInstitucion());
			if (result.hasErrors()) {
				model.addAttribute("error", "* Campos requeridos");			
			}
			else
			{
				try 
				{
					String gRecaptchaResponse = request.getParameter("g-recaptcha-response");
					boolean verify = VerifyRecaptcha.verify("6LfQETMUAAAAADPirHP4e824B8GAmfIoqwdijhLK", gRecaptchaResponse);
					if (verify) {
						model.addAttribute("envio", "Tus correo ha sido enviado.");
						String recipientAddress = "patriciomanotoa@gmail.com";
				        String subject = mail.getNombre()+" - "+ mail.getAsunto();
				        String message = "De "+mail.getCorreo()+" : \n"+mail.getMensaje();
				         	         
				        // creacion de un objeto simple e-mail
				        SimpleMailMessage email = new SimpleMailMessage();
				        email.setTo(recipientAddress);
				        email.setSubject(subject);
				        email.setText(message);
				         
				        //envio el email
				        mailSender.send(email);
						return "contacto";
					}
					else {
						model.addAttribute("error", "Por favor, prueba que no eres un robot");
					}
				} catch (Exception e) {
					throw e;
				}			
			}
			
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
