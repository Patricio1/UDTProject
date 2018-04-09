<%@page contentType="text/html;charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt"%>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
<div id="main" class="clearfix">
	<div class="inner-wrap clearfix">
      <div class="front-page-top-section clearfix" style="margin-bottom: 40px">    
             <!--inicio slider para dispositivos moviles -->        
          <div id="myCarousel" class="carousel slide" data-ride="carousel" style="">
                  <!-- Indicators-->
              
                  <ol class="carousel-indicators"> 
                  <c:set var="indiceSlide" value="0" scope="page" />
                  <c:forEach items="${slides}" var="slide">
                    <c:choose>
					  <c:when test="${indiceSlide==0}">
					   <li data-target="#myCarousel" data-slide-to="0" class="active"></li>					  
					  </c:when>
					  <c:otherwise>
					  <li data-target="#myCarousel" data-slide-to="indiceSlide"></li>
					   
					  </c:otherwise>
					  </c:choose>
					   <c:set var="indiceSlide" value="${indiceSlide + 1}" scope="page"/>   
                  </c:forEach>
                  </ol>
                  
                    
                 

                  <!-- Wrapper for slides -->
                  <div class="carousel-inner" >
                  
                 <c:set var="contador" value="0" scope="page" />
                    <c:forEach items="${slides}" var="slide">
                      <c:choose>
					  <c:when test="${contador==0}">
					    <div class="item active">
	                        <div class="row">
	                            <div class="col-sm-2">                       
	                            </div>
	                            <div class="col-sm-8">
	                                <img src="${slide.url}" alt="${slide.descripcion}" style="width:100%;">
	                            </div>
	                            <div class="col-sm-2">                       
	                            </div>
	                        </div>
                    	 </div>  
					  </c:when>
					  <c:otherwise> 
					    <div class="item">
	                        <div class="row">
	                            <div class="col-sm-2">                       
	                            </div>
	                            <div class="col-sm-8">
	                                <img src="${slide.url}" alt="${slide.descripcion}" style="width:100%;">
	                            </div>
	                            <div class="col-sm-2">                       
	                            </div>
	                        </div>
                    	 </div>  
					  </c:otherwise>
					  </c:choose>
					  <c:set var="contador" value="${contador + 1}" scope="page"/>   
                    </c:forEach>
                    
                    
                  </div>

                  <!-- Left and right controls -->
                  <a class="left carousel-control" href="#myCarousel" data-slide="prev">
                    <span class="glyphicon glyphicon-chevron-left"></span>
                    <span class="sr-only">Previous</span>
                  </a>
                  <a class="right carousel-control" href="#myCarousel" data-slide="next">
                    <span class="glyphicon glyphicon-chevron-right"></span>
                    <span class="sr-only">Next</span>
                  </a>
          </div>

            <!-- fin slider para dispositivos moviles-->     
          <div id="sliderFrame">
          
                  <div id="slider">
                        <c:forEach items="${slides}" var="slide">	
                         <img src="${slide.url}" alt="${slide.descripcion}" />            
                        </c:forEach>
                  </div>
                  <!-- <div id="htmlcaption" style="display: none;">
                      <em>HTML</em> caption. Link to <a href="http://www.google.com/">Google</a>.
                  </div>-->
          </div>
          
      </div>
   <div class="main-content-section clearfix">
<div id="primary">
  <div id="content" class="clearfix">



         <section id="colormag_featured_posts_widget-3" class="widget widget_featured_posts widget_featured_meta clearfix">      <h3 class="widget-title" style="border-bottom-color:#177248"><span style="background-color:#177248;">PRÓXIMAS SALIDAS</span></h3>                                                                       
  <div class="widget widget_featured_posts widget_featured_posts_vertical widget_featured_meta clearfix">                                             

               <div class="single-article clearfix">   
<!-- Inicio Slider Proximas salidas-->							
    <div class="row">   

        <div class="well">
            <div id="proximas_Salidas" class="carousel slide">
                
                <!-- Carousel items -->
                <div class="carousel-inner" id="sDestinosProximasSalidas">
                   
                </div>
                <!--/carousel-inner--> 
                <a class="left carousel-control" href="#proximas_Salidas" data-slide="prev">‹</a>

                <a class="right carousel-control" href="#proximas_Salidas" data-slide="next">›</a>
            </div>
            <!--/myCarousel-->
        </div>
        <!--/well-->
    </div>
<!--Fin de Slider Proximas Salidas -->
  
   </div>
               </div>


              
      </section> 

<!-- Inicio sección cooperativas que trabajan con nosotros -->
      <section id="colormag_featured_posts_widget-3" class="widget widget_featured_posts widget_featured_meta clearfix">      <h3 class="widget-title" style="border-bottom-color:#bd4cce;"><span style="background-color:#bd4cce;">COOPERATIVAS QUE TRABAJAN CON NOSOTROS</span></h3>                                                                                                                        
          <div class="widget widget_featured_posts widget_featured_posts_vertical widget_featured_meta clearfix">                                             
              <div class="single-article clearfix">   
                 <ul id="scroller">
                 <c:forEach items="${cooperativas}" var="coop">				     
				     <c:choose>
					  <c:when test="${coop.logo!='sinlogo'}">
					  
					  <c:choose>
					  <c:when test="${coop.website!='sinwebsite'}">
					   <li ><a href="${coop.website}" target="_blank"><img src="${coop.logo}" width="110" height="110" /></a></li>
					  </c:when>
					  <c:otherwise>
					     <li ><img src="${coop.logo}" width="110" height="110" /></li>
					  </c:otherwise>
					  </c:choose>
					
					  </c:when>
					  <c:otherwise>
					  <li   style="padding: 18px 0px 0px 0px"><a class="logo" href="directorio-cooperativas">${coop.cooperativa}</a></li>
					  </c:otherwise>
					</c:choose>				     
 				 </c:forEach>
                 </ul>
              </div>
          </div>             
      </section>
<!-- Fin sección cooperativas que trabajan con nosotros -->

     <!--  Inicio seccion comunicados -->
     <c:forEach items="${comunicados}" var="comunicado">
     <div class="clearfix"></div>
      <a href="<%=request.getContextPath()%>/comunicado?c=${comunicado.id}">
         		<section id="comunicado" class="widget widget_featured_posts widget_featured_meta clearfix">      <h3 class="widget-title" style="border-bottom-color:#dd5a5a;"><span style="background-color:#dd5a5a;">COMUNICADO</span></h3>                                                                                                                        
          			<div class="widget widget_featured_posts widget_featured_posts_vertical widget_featured_meta clearfix">                                             
                       <div class="single-article clearfix">   
           					<h5 style="text-align: center;margin-top: 5px">${comunicado.titulo}</h5>
           					<div class="posted-on" style="float: right;font-size: 15px;padding-right: 10px;padding-bottom: 5px">
           					<i class="fa fa-calendar-o"></i> Publicado: <time class="entry-date published" 
           					datetime="${comunicado.fecha}">${comunicado.fecha}</time></div>      
           				</div>
                    </div>             
            </section> 
      </a>							 																
	</c:forEach>
     <!-- Fin seccion comunicados -->       
     
      <div class="clearfix"></div>       
  </div>
</div> 
     
      
       <script>
          //$('#parrafo').text("HOLA MUNDO");
          
          </script>
     
  
      <script>
      function listarProximasSalidas()
      {
    	  var contador = 1;
    	  var row = '<div class="item active"><div class="row" style="text-align: center;">';  
    	  var rowComplete = "";
    	  var column = '';    	
      	$.ajax({
      		type: "GET",
      		url: 'udt/destinos-proximas-salidas',
      		success: function(data,status,xhr)
      		{
      		var banderin=0;
  			var numeroRegistros =  Object.keys(data).length;  			
  			//console.log(data[0].nombreOrigen);  			
  			$.each(data, function(array,referencia){  				  				  				 
  				if(contador % 3 == 0 && contador > 2)
  					{
  					if(contador==3)
  					{
  					row = '<div class="item active"><div class="row" style="text-align: center;">'; 
  					}
  					else  
  						{
  						row = '<div class="item"><div class="row" style="text-align: center;">';
  						}  					
  					column +='<a href="proximas-salidas?no='+referencia.nombreOrigen+'&io='+referencia.idOrigen+'&nd='+referencia.nombreDestino+'&id='+referencia.idDestino+'"><div class="col-sm-4"><div class="col-item" style="background: url('+referencia.imgDestino+') no-repeat;-webkit-background-size: cover;-moz-background-size: cover;-o-background-size: cover;background-size: cover;height: 100%;width: 100% ;text-align: center;"><div style="margin-top: 10px" ><img alt="" src="http://static.websguru.com.ar/var/m_4/4d/4d9/34457/540392-icono-bus.png" style="width: 35%;width: 35%"></div><div class="info"><div class="row info-pasaje"><h6 class="col-md-10 col-xs-9"><p style="margin: 0px 0px 0px 0px;font-weight: bold" >'+referencia.nombreOrigen+ "-"+ referencia.nombreDestino+'</p></h6></div><div class="clearfix"></div></div></div></div></a>';
      				var auxRow = row+column+"</div></div>";
      				rowComplete+=auxRow;
      				banderin++;      				
  					}
  				else
  					{  					
  					if(banderin>0)
  						{
  						column ='<a href="proximas-salidas?no='+referencia.nombreOrigen+'&io='+referencia.idOrigen+'&nd='+referencia.nombreDestino+'&id='+referencia.idDestino+'"><div class="col-sm-4"><div class="col-item" style="background: url('+referencia.imgDestino+') no-repeat;-webkit-background-size: cover;-moz-background-size: cover;-o-background-size: cover;background-size: cover;height: 100%;width: 100% ;text-align: center;"><div style="margin-top: 10px" ><img alt="" src="http://static.websguru.com.ar/var/m_4/4d/4d9/34457/540392-icono-bus.png" style="width: 35%;width: 35%"></div><div class="info"><div class="row info-pasaje"><h6 class="col-md-10 col-xs-9"><p style="margin: 0px 0px 0px 0px;font-weight: bold" >'+referencia.nombreOrigen+ "-"+ referencia.nombreDestino+'</p></h6></div><div class="clearfix"></div></div></div></div></a>';
  						banderin = 0;
  						}
  					else column +='<a href="proximas-salidas?no='+referencia.nombreOrigen+'&io='+referencia.idOrigen+'&nd='+referencia.nombreDestino+'&id='+referencia.idDestino+'"><div class="col-sm-4"><div class="col-item" style="background: url('+referencia.imgDestino+') no-repeat;-webkit-background-size: cover;-moz-background-size: cover;-o-background-size: cover;background-size: cover;height: 100%;width: 100% ;text-align: center;"><div style="margin-top: 10px" ><img alt="" src="http://static.websguru.com.ar/var/m_4/4d/4d9/34457/540392-icono-bus.png" style="width: 35%;width: 35%"></div><div class="info"><div class="row info-pasaje"><h6 class="col-md-10 col-xs-9"><p style="margin: 0px 0px 0px 0px;font-weight: bold" >'+referencia.nombreOrigen+ "-"+ referencia.nombreDestino+'</p></h6></div><div class="clearfix"></div></div></div></div></a>';
  					
  					if(contador == numeroRegistros)
  						{  						
          				var auxRow = row+column+"</div></div>";
          				rowComplete+=auxRow;
  						}          				
  					}
  				contador++;
      			});
      			//console.log(rowComplete);
      			$('#sDestinosProximasSalidas').append(rowComplete);          			
      		},
      		error: function(xhr, status, error)
      		{
      			console.info(xhr);
      			console.info(status);
      			console.info(error);
      		}
      	});
      }
      
      $(document).ready(function() {
    	  listarProximasSalidas();
    	
        $('#proximas_Salidas').carousel({
      interval: 30000
      })        
        $('#proximas_Salidas').on('slid.bs.carousel', function() {         
      });               
    });

      $('#inicio').attr('class','home-icon front_page_on');
   
      
     
   function mostrarFecha(dia, mes, anio)
      {	 
		var sFecha = mes+"/"+dia+"/"+anio;
		var d = new Date(sFecha);
						     	                 
    	  var sdiaSemana = "";
          var sFecha = "";
          var diasSemana = {
             1:"Lunes",
             2:"Martes",
             3:"Miércoles",
             4:"Jueves",
             5:"Viernes",
             6:"Sábado",
             7:"Domingo"};
          var nombreDia = diasSemana[d.getDay()+1];
          console.log(d.getDay());
 		 
          var nombreMeses = 
          {
             1:"Enero",
             2:"Febrero",
             3:"Marzo",
             4:"Abril",
             5:"Mayo",
             6:"Junio",
             7:"Julio",
             8:"Agosto",
             9:"Septiembre",
             10:"Octubre",
             11:"Noviembre",
             12:"Diciembre"
          };          
           sFecha = nombreDia+" "+dia+" "+nombreMeses[mes]+" "+", "+anio;
          return sFecha;
      }
      $(".posted-on").children().each(function(){    	
    	if($(this).is(".entry-date"))
    		{		
    		var fecha = $(this).attr('datetime');
    		var auxFecha = fecha.split('-');  		
    		var anio = parseInt(auxFecha[0]);
    		var mes = parseInt(auxFecha[1]);
    		var dia= parseInt(auxFecha[2]); 		
    		var fechaModificada = mostrarFecha(dia,mes,anio);  	
    		$(this).text(fechaModificada);   		    	    	   		
    		}    	
    	})     
      </script>
      
       
       