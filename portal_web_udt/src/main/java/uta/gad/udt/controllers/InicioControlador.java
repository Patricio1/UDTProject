package uta.gad.udt.controllers;



import java.io.BufferedOutputStream;

import java.io.File;

import java.io.FileOutputStream;
import java.io.IOException;

import java.math.BigDecimal;

import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;



import javax.servlet.ServletContext;
import javax.servlet.http.HttpServletRequest;

import javax.servlet.http.HttpSession;




import org.springframework.stereotype.Controller;
import org.springframework.validation.BindingResult;

import org.springframework.web.bind.annotation.ModelAttribute;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.multipart.commons.CommonsMultipartFile;

import org.springframework.web.servlet.ModelAndView;

import org.springframework.beans.factory.annotation.Autowired;

import uta.gad.udt.models.dao.ContactFormValidator;
import uta.gad.udt.models.dao.VerifyRecaptcha;
import uta.gad.udt.models.entity.ComunicadoNoticia;
import uta.gad.udt.models.entity.Contacto;
import uta.gad.udt.models.entity.Institucion;
import uta.gad.udt.models.entity.Link;
import uta.gad.udt.models.entity.Recurso;
import uta.gad.udt.models.entity.Servicio;
import uta.gad.udt.models.service.AdministracionService;
import uta.gad.udt.models.service.PublicoService;
import uta.gad.udt.validator.ComuNoticFormValidator;
import uta.gad.udt.validator.InstitucionFormValidator;
import uta.gad.udt.validator.RecursoFormValidator;
import uta.gad.udt.validator.ServicioFormValidator;

import org.springframework.ui.Model;
import org.springframework.ui.ModelMap;




@Controller
@RequestMapping("/")
//@SessionAttributes("institucion")
public class InicioControlador {
	
		private HttpServletRequest httprequest;
	
	    @Autowired
	    public void setRequest(HttpServletRequest httprequest) {
	        this.httprequest = httprequest;
	    }
    
		@Autowired
	    private AdministracionService administracionService;
	
	 	@Autowired
	    private PublicoService publicoService;
	 	
	 	@Autowired
		ContactFormValidator contactFormValidator;
	 	@Autowired
		ServicioFormValidator servicioFormValidator;
	 	@Autowired
	 	ComuNoticFormValidator comuNoticFormValidator;
	 	
	 	@Autowired
	 	InstitucionFormValidator institucionFormValidator;
	 	
	 	@Autowired
	 	RecursoFormValidator recursoFormValidator;
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
		public String planestrategico() {			
			// retornamos la vista form
			return "plan-estrategico";
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
		public String acercade() {			
			// retornamos la vista form
			return "acercade";
		}
		@RequestMapping(value="contacto" ,method = RequestMethod.GET)
		public String contactenos(Model model) {			
			// retornamos la vista form Model model
			Contacto mailData = new Contacto();
	        model.addAttribute("maildata", mailData);
			return "contacto";
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
			model.addObject("preguntas", publicoService.getPreguntaGlosario("P"));
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
		public String tramitesTransportistas() {			
			// retornamos la vista form
			return "tramites";
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
		@RequestMapping(value="admin" ,method = RequestMethod.GET)
		public String panelAdmin() {					
			return "admin";
		}
		@RequestMapping(value="institucion-info" ,method = RequestMethod.GET)
		public String panelInstitucion(Model model) {					
			//Institucion institucion_info = new Institucion();
			Institucion institucion_info = administracionService.getInfoInstitucion();
			//institucion_info.setImgOpcion("Local");
	        model.addAttribute("institucion_info", institucion_info);
			return "institucion";
		}
		@RequestMapping(value="institucion-info" ,method = RequestMethod.POST)
		public String panelInstitucion(@ModelAttribute("institucion_info") Institucion institucion_info,
				BindingResult result,Model model,
				@RequestParam CommonsMultipartFile file,
                HttpSession session
				) {
			String logo_="no-image";
			
			//RequestContext context_ = RequestContextHolder.getRequestContext();
			//pageContext.request.contextPath
			
			String UPLOAD_DIRECTORY ="/recursos/publico/img"; 
			 ServletContext context = session.getServletContext();  
			    String path = context.getRealPath(UPLOAD_DIRECTORY);  
			    String filename = file.getOriginalFilename();  
			  
			    System.out.println(path+" "+filename);  
		      
		        String contextPath = httprequest.getContextPath();
		        
		        

			    byte[] bytes = file.getBytes();  
			    BufferedOutputStream stream;
				try {
					  institucionFormValidator.validate(institucion_info, result);
						if (result.hasErrors()) {
							model.addAttribute("fail", "La información ingresada tiene errores revísala");
							
						}
						else
						{
							logo_ = institucion_info.getImgOpcion().equals("Local")?contextPath+UPLOAD_DIRECTORY+"/"+filename:institucion_info.getLogo();
							model.addAttribute("ok", "Información ingresada correctamente ");				
							institucion_info.setLogo(logo_);
							publicoService.updateInstitucion(institucion_info);
							stream = new BufferedOutputStream(new FileOutputStream(  new File(path + File.separator + filename)));
							 stream.write(bytes);  
							    stream.flush();  
							    stream.close();
						}
					
					   
					   
					   // logo_=contextPath+UPLOAD_DIRECTORY+"/"+filename;
				} catch (Exception e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}  
			   
			           
			   // return new ModelAndView("uploadform","filesuccess","File successfully saved!");  
			
			
		  
			
			return "institucion";
		}
		
		@RequestMapping(value="listado-servicios" ,method = RequestMethod.GET)
		public ModelAndView listadoServicios() {
			ModelAndView model = new ModelAndView("listado-servicios");
			model.addObject("listaServicios", administracionService.getServicios());
			return model;
		}
		@RequestMapping(value="form-servicio" ,method = RequestMethod.GET)
		public Servicio formServicio(@RequestParam(value = "id", required = false, defaultValue = "0") short id, Model model) {
			Servicio servicio = null;
		        if (id > 0) {
		        	servicio = administracionService.getServicio(id);
		        } else {
		        	servicio = new Servicio();
		        	servicio.setImgOpcion("Local");
		        }
			return servicio;
		}
		@RequestMapping(value="form-servicio" ,method = RequestMethod.POST)
		public String processServicioSubmit(
				@ModelAttribute("servicio") Servicio servicio,
				BindingResult result,Model model,
				@RequestParam CommonsMultipartFile file,
                HttpSession session
                ) {		
			String imagen="no-image";
			String UPLOAD_DIRECTORY ="/recursos/publico/img"; 
			 ServletContext context = session.getServletContext();  
			    String path = context.getRealPath(UPLOAD_DIRECTORY);  
			    String filename = file.getOriginalFilename();  
		        String contextPath = httprequest.getContextPath();
		        
		       

			    byte[] bytes = file.getBytes();  
			    BufferedOutputStream stream;
				try {
					
					    
					    servicioFormValidator.validate(servicio, result);
						if (result.hasErrors()) {
							model.addAttribute("fail", "La información ingresada tiene errores revísala");			
						}
						else
						{
							 imagen = servicio.getImgOpcion().equals("Local")?contextPath+UPLOAD_DIRECTORY+"/"+filename:servicio.getImagen();
							servicio.setImagen(imagen);
							model.addAttribute("ok", "Información ingresada correctamente ");
							administracionService.saveServicio(servicio);
							
							 
								stream = new BufferedOutputStream(new FileOutputStream(  new File(path + File.separator + filename)));
								 stream.write(bytes);  
								    stream.flush();  
								    stream.close();
						}
				} catch (Exception e) {					
					model.addAttribute("fail","Error al subir la imagen");
				}  
				
			
			
		    //return "redirect:listado-servicios";
		    return  "form-servicio";
		}
	/**	@RequestMapping(value="institucion-servicios/edit{idServicio}" ,method = RequestMethod.GET)
		public String updateServicios() {					
			//Institucion institucion_info = administracionService.getInfoInstitucion();
			
			ModelAndView model = new ModelAndView("servicio");
			Servicio servicio  = new Servicio();
			servicio.setImgOpcion("Local");
			model.addObject("servicios", servicio);
			model.addObject("listaServicios", administracionService.getServicios());
 
			return "edit_servicio";
		}*/
		@RequestMapping(value="eServicio" ,method = RequestMethod.GET)
		public String deleteServicio(@RequestParam("id") short id) {					
			 Servicio servicio = administracionService.getServicio(id);
		        if (null != servicio) {
		        	administracionService.deleteServicio(servicio);
		        }
			return "redirect:listado-servicios";
		}
		@RequestMapping(value="listado-comunicado-noticia" ,method = RequestMethod.GET)
		public ModelAndView listadoComunicadoNoticia() {
			ModelAndView model = new ModelAndView("listado-comunicado-noticia");
			model.addObject("listaComServ", administracionService.getComunicadoNoticia());
			return model;
		}
		@RequestMapping(value="form-comunicadoNoticia" ,method = RequestMethod.GET)
		public ComunicadoNoticia formComunicadoNoticia(@RequestParam(value = "id", required = false, defaultValue = "0") int id, Model model) {
			ComunicadoNoticia comunicadoNoticia = null;
		        if (id > 0) {
		        	comunicadoNoticia = administracionService.getComunicadoNoticiaById(id);
		        	comunicadoNoticia.setImgOpcion("URL");
		        	//comunicadoNoticia.set_fecha(comunicadoNoticia.getFecha().toString());
		        } else {
		        	comunicadoNoticia = new ComunicadoNoticia();
		        	comunicadoNoticia.setImgOpcion("Local");
		        	comunicadoNoticia.setEstado(true);
		        	
		        	//comunicadoNoticia.setFecha(fecha);
		        }
			return comunicadoNoticia;
		}
		//https://www.jqueryscript.net/form/Image-Upload-Preview-Plugin-With-jQuery-Bootstrap-img-upload.html
		@RequestMapping(value="form-comunicadoNoticia" ,method = RequestMethod.POST)
		public String processcomunicadoNoticiaSubmit(
				@ModelAttribute("comunicadoNoticia") ComunicadoNoticia comunicadoNoticia,
				BindingResult result,Model model,
				@RequestParam CommonsMultipartFile file,
                HttpSession session
                ) {
			
			String imagen="no-image";
			String UPLOAD_DIRECTORY ="/recursos/publico/img"; 
			 ServletContext context = session.getServletContext();  
			    String path = context.getRealPath(UPLOAD_DIRECTORY);  
			    String filename = file.getOriginalFilename();  
		        String contextPath = httprequest.getContextPath();
		        
		       

			    byte[] bytes = file.getBytes();  
			    BufferedOutputStream stream;
				try {
					
					//String string = "January 2, 2010";
					//DateFormat format = new SimpleDateFormat("MMMM d, yyyy", Locale.ENGLISH);
					/** SimpleDateFormat formatter = new SimpleDateFormat("E, MMM dd yyyy");
				        //String dateInString = "Fri, June 7 2013";
				        
					String string = comunicadoNoticia.getFecha().toString();
					 Date date_ = formatter.parse(string);
			            System.out.println("fecha1: "+date_);
			            System.out.println("fecha2: "+formatter.format(date_));
			            
					System.out.print("FECHA==> "+string+" :)");
					DateFormat format = new SimpleDateFormat("yyyy-MM-dd");*/
					//Date date = format.parse(string);
					 //comunicadoNoticia.setFecha(date);
					 if(comunicadoNoticia.getImgOpcion().equals("Local"))
					 {
						stream = new BufferedOutputStream(new FileOutputStream(  new File(path + File.separator + filename)));
						 stream.write(bytes);  
						    stream.flush();  
						    stream.close();
					 }
					 imagen = comunicadoNoticia.getImgOpcion().equals("Local")?contextPath+UPLOAD_DIRECTORY+"/"+filename:comunicadoNoticia.getImagen();
					 comunicadoNoticia.setImagen(imagen);
					 
					comuNoticFormValidator.validate(comunicadoNoticia, result);
						if (result.hasErrors()) {
							model.addAttribute("fail", "La información ingresada tiene errores revísala");			
						}
						else
						{
							
							
							
							
							//String fecha = comunicadoNoticia.getFecha().toString();
							// SimpleDateFormat formatter = new SimpleDateFormat("dd-MMM-yyyy");
						       

						        

						           // Date date = formatter.parse(fecha);	
							 model.addAttribute("ok", "Información ingresada correctamente ");
							administracionService.saveComunicadoNoticia(comunicadoNoticia);
							
							/**SimpleDateFormat df = new SimpleDateFormat("yyyy/MM/dd");
							String s = comunicadoNoticia.getFecha().toString();
		                    Date d = df.parse(s); 
		                    comunicadoNoticia.setFecha(d);
		                    */
							
						}
				} catch (Exception e) {					
					model.addAttribute("fail","Error al subir la imagen: "+e.getMessage());
				}  
				
			
		  //  return "redirect:listado-comunicado-noticia";
				 return "form-comunicadoNoticia";
		}
		@RequestMapping(value="eComunicadoNoticia" ,method = RequestMethod.GET)
		public String deleteComunicadoNoticia(@RequestParam("id") int id) {					
			ComunicadoNoticia comunicadoNoticia = administracionService.getComunicadoNoticiaById(id);
		        if (null != comunicadoNoticia) {
		        	administracionService.deleteComunicadoNoticia(comunicadoNoticia);
		        }
			return "redirect:listado-comunicado-noticia";
		}
		
		//Recursos		
		@RequestMapping(value="listado-recursos" ,method = RequestMethod.GET)
		public ModelAndView listadoRecursos() {
			
			ModelAndView model = new ModelAndView("listado-recursos");
			model.addObject("listaRecursos", administracionService.getRecursos());
			return model;
		}
		@RequestMapping(value="form-recurso" ,method = RequestMethod.GET)
		public Recurso formRecurso(@RequestParam(value = "id", required = false, defaultValue = "0") int id, Model model) {
			Recurso recurso = null;
		        if (id > 0) {
		        	recurso = administracionService.getRecursosById(id);		        
		        } else {
		        	recurso = new Recurso();		        	
		        }
			return recurso;
		}
		@RequestMapping(value="form-recurso" ,method = RequestMethod.POST)
		public @ResponseBody  String processRecursoSubmit(
				@ModelAttribute("recurso") Recurso recurso,
				BindingResult result,Model model,
				@RequestParam("file") MultipartFile file,
				HttpSession session
                ) {	
			       	String resource="no-recurso";
			       	if(recurso.getId()<=0)
			       	recurso.setUrl(resource);
			       	// directorio donde se guarda el archivo
			       	String UPLOAD_DIRECTORY ="/recursos/publico/upload"; 
					ServletContext context = session.getServletContext();  
					String rootPath = context.getRealPath(UPLOAD_DIRECTORY);
					    String filename = file.getOriginalFilename();  
				        String contextPath = httprequest.getContextPath();
					    try {
				            recursoFormValidator.validate(recurso, result);
							if (result.hasErrors()) {
								model.addAttribute("fail", "La información ingresada tiene errores revísala");			
							}
							else
							{
								byte[] bytes = null;
					            Path path = null;
								//si el archivo no esta vacio
								if(!file.isEmpty()){
									
									//seccion prueba froala editor
									
							      
									//fin seccion pureba froala editor
									
									
									
								// obtener el archivo y guardarlo
					            bytes = file.getBytes();
					            path = Paths.get(rootPath + file.getOriginalFilename());
					           
					            resource = contextPath+UPLOAD_DIRECTORY+"/"+filename;
									if(recurso.getId()>0) //update
									{
										try{
										administracionService.deleteFile(getRealPathFile(session,recurso.getUrl()));
										}catch(Exception ex){}
										}
								recurso.setUrl(resource);
								}
								//System.out.println("RECURSO ID: "+recurso.getId());
								if(administracionService.saveRecurso(recurso)>0)
									{
									if(!file.isEmpty()) Files.write(path, bytes); 
									model.addAttribute("ok", "Información ingresada correctamente ");									
									}
								else model.addAttribute("fail", "Información NO ingresada");					
							}
				        } catch (IOException e) {
				        	model.addAttribute("fail", "La información ingresada tiene errores revísala: "+e.getMessage());			
				        }
				 return "form-recurso";
		}
		//prueba metodo upload file froala
		
		//fin metodo upload file froala
		@RequestMapping(value="eRecurso" ,method = RequestMethod.GET)
		public String deleteRecurso(@RequestParam("id") int id,HttpSession session) {					
			 Recurso recurso = administracionService.getRecursosById(id);
		        if (null != recurso) {		        	
		        	String tempUrl= recurso.getUrl();
		        	int resultado = administracionService.deleteRecurso(recurso);	        	 
		        	if(resultado>0)
		        	{
		        		administracionService.deleteFile(getRealPathFile(session,tempUrl));
		        		tempUrl=null;
		        	}		        	
		        }
			return "redirect:listado-recursos";
		}
		public String getRealPathFile(HttpSession session,String urlFile)
		{
			 ServletContext context = session.getServletContext(); 
    		 String[] aux_path = urlFile.split("/");
    		 String url="/";
    		 for (int i = 2; i < aux_path.length; i++) {
    			 url+=aux_path[i]+"/";
			}
			return context.getRealPath(url);
		}
}
