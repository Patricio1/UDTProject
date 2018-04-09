<%@page contentType="text/html;charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt"%>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
<script src='https://www.google.com/recaptcha/api.js'></script>
 <div id="main" class="clearfix">
	<div class="inner-wrap clearfix">
   		<div class="front-page-top-section clearfix" style="margin-bottom: 40px"></div>
   		<div class="main-content-section clearfix">
      		<div id="primary">
         		<div id="content" class="clearfix">
         		         <section id="colormag_featured_posts_widget-3" class="widget widget_featured_posts widget_featured_meta clearfix">      <h3 class="widget-title" style="border-bottom-color:#81d742;"><span style="background-color:#81d742;">CONTÁCTESE CON NOSOTROS</span></h3>                                                                                                                            
							  <div class="widget widget_featured_posts widget_featured_posts_vertical widget_featured_meta clearfix">
							               <div class="single-article clearfix">
							               
	<div class="row" style="text-align: justify;">
	    <div class="col-sm-1" >      
	    </div>
	    <div class="col-sm-10">
			<p>Recuerda que estamos ubicados en la Av. Colombia 332 y Paraguay (Ingahurco)</p>
			 <div id="map" style=" width: 100%;height: 400px;margin-bottom: 20px"></div>     
	    </div>
	    <div class="col-sm-1">    
	    </div>
  	</div>   
							 <div style="padding-left: 30px;padding-right: 30px; text-align: justify;" >
							    <p><span class="fa fa-question-circle" style="font-size:48px;color:#289dcc"></span> A través de este formulario, usted podrá presentar peticiones, quejas, reclamos, sugerencias o felicitaciones ante la <strong>Unidad Desconcentrada de Terminales Ambato</strong>.
							<br>Será un gusto atenderle</p>
							 </div>
							  <form:form class="form-horizontal" method="post"
                modelAttribute="maildata" >
                <!-- Inicio asunto -->          
                <div class="form-group">
					<label for="asunto" class="col-lg-2 control-label">Asunto</label>
						<div class="col-lg-9">
							<div class="input-group">
							  <div class="input-group-addon">
							    <i class="fa fa-comments"></i> 
							   </div>
							 <form:input cssClass="form-control" path="asunto"  cssStyle="background-color: white"  placeholder="Escriba el asunto.."/>												                   
							 </div>
							 <form:errors path="asunto" class="control-label" cssStyle="color:red;font-size:13px"/>						  
						</div>
						
						
						
				</div>
			  <!-- Fin asunto -->
			  <!-- Inicio nombre -->
			  <div class="form-group">
				<label for="nombre" class="col-lg-2 control-label">Nombre</label>
					<div class="col-lg-9">
						<div class="input-group">
							<div class="input-group-addon">
							   <i class="fa fa-user"></i> 
							 </div>
							 <form:input path="nombre" cssClass="form-control" cssStyle="background-color: white" placeholder="Escriba su nombre.." />							 	
						</div>	
						<form:errors path="nombre" class="control-label" cssStyle="color:red;font-size:13px"/>					
					</div>
			  </div>
			 <!-- Fin nombre -->
			 <!-- Inicio correo -->
			  <div class="form-group">
				<label for="correo" class="col-lg-2 control-label">Correo</label>
					<div class="col-lg-9">
						<div class="input-group">
							<div class="input-group-addon">
							   <i class="fa fa-envelope-o"></i> 
							 </div>
							 <form:input path="correo" cssClass="form-control" cssStyle="background-color: white" placeholder="Escriba su correo.."/>							 	
						</div>
						<form:errors path="correo" class="control-label" cssStyle="color:red;font-size:13px"/>				
					</div>				
			  </div>
			 <!-- Fin correo -->
			 <!-- Inicio mensaje -->
			  <div class="form-group">
				<label for="mensaje" class="col-lg-2 control-label">Mensaje</label>
					<div class="col-lg-9">										
					  <form:textarea path="mensaje"  cols="30" rows="10" cssClass="form-control" placeholder="Escriba su mensaje.."/>						  						
					</div>										
			  </div>
			  <div class="form-group">
			  <div class="col-lg-8 col-lg-offset-2">										
					  <form:errors path="mensaje" class="control-label" cssStyle="color:red;font-size:13px"/>						  						
			  </div>				  
			  </div>
			 <!-- Fin mensaje -->
			 <!-- Inicio capcha -->
			 <div class="form-group">
				<div class="col-lg-4 col-lg-offset-3"> 
					<div style="margin-bottom: 10px;margin-top: 10px" class="g-recaptcha" data-sitekey="6LfQETMUAAAAALtyOk66Qp4ccagIgKnsaeGfgB-C"></div>
					 <p style="color:red"> <c:out value="${error}" /></p>
					 <p style="color:#388e3c"> <c:out value="${envio}" /></p>
					 <input type="submit" value="Enviar mensaje" />
				</div>
			 </div>
			 <!-- Fin capcha -->
                </form:form>
							  
							  
							  
							   </div>
							               </div>              
      				</section>          		                  							                     
	         		<div class="clearfix"></div>                        
	            </div>
          </div>
<script type="text/javascript">
function MostrarEnMapa() { //-1.236065, -78.616254
        var uluru = {lat: -1.236081,  lng: -78.616272};
        var map = new google.maps.Map(document.getElementById('map'), {
          zoom: 17,
          center: uluru
        });
        var marker = new google.maps.Marker({
          position: uluru,
          map: map
        });
      }
</script>
 <script async defer
    src="https://maps.googleapis.com/maps/api/js?key=AIzaSyCezc8l2OVC6ma2kJG53NkgGd1uEjQz6v4&callback=MostrarEnMapa">
 </script>  