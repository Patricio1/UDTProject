<%@page contentType="text/html;charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt"%>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
<link rel="stylesheet" href="${pageContext.request.contextPath}/recursos/publico/css/lightbox.css">
<script src="${pageContext.request.contextPath}/recursos/publico/js/lightbox-plus-jquery.min.js"></script>

 <div id="main" class="clearfix">
    <div class="inner-wrap clearfix">
        <div class="front-page-top-section clearfix" style="margin-bottom: 40px"></div>
        <div class="main-content-section clearfix">
            <div id="primary">
                <div id="content" class="clearfix">
                          <section id="colormag_featured_posts_widget-3" class="widget widget_featured_posts widget_featured_meta clearfix">      <h3 class="widget-title" style="border-bottom-color:#82ada1;"><span style="background-color:#82ada1;">NUESTROS SERVICIOS</span></h3>                                                                                                                            
  <div class="widget widget_featured_posts widget_featured_posts_vertical widget_featured_meta clearfix">
               <div class="single-article clearfix">   
 <div style="padding-left: 30px;padding-right: 30px; text-align: justify;" >
    <p>Ponemos a disposición de la ciudadanía todos los servicios con las que cuenta la 
    <strong>Unidad Desconcentrada de Terminales Ambato</strong>.
 </div><br>
 
  <!--  Inicio seccion servicios -->
     <c:forEach items="${servicios}" var="servicio">
     	  <div class="row">
		    <div class="col-sm-2" style="margin-left: 10px" >
		   			 <c:choose>
					  <c:when test="${servicio.imagen!='sinimagen'}">
					   <a class="example-image-link" href="${servicio.imagen}" data-lightbox="example-set" data-title="${servicio.nombre}">
                            <img class="example-image" src="${servicio.imagen}" alt="${servicio.nombre}" width="360" height="360" />
                       </a> 
                            
					  
					  </c:when>
					  <c:otherwise>					    
					  </c:otherwise>
					  </c:choose>
		    </div>
		    <div class="col-sm-9">
			    <strong>${servicio.nombre}</strong>
				<p style="text-align:justify">${servicio.descripcion}</p> 
		    </div>
		    <div class="col-sm-1" >	    
		    </div>
 		 </div>
 		 <div style="border-top-width: 1px; border-top-style: dotted; border-top-color: #82ada1;margin-bottom: 10px;margin-left: 10px;margin-right: 10px"></div>																
	</c:forEach>
     <!-- Fin seccion servicios --> 
   </div>
               </div>              
      </section>                                                        
                    <div class="clearfix"></div>                        
                </div>
          </div>