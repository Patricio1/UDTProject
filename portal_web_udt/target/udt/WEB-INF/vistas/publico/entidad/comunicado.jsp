<%@page contentType="text/html;charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt"%>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
 <div id="main" class="clearfix">
	<div class="inner-wrap clearfix">
   		<div class="front-page-top-section clearfix" style="margin-bottom: 40px"></div>
   		<div class="main-content-section clearfix">
      		<div id="primary">
         		<div id="content" class="clearfix">
         		        <section id="colormag_featured_posts_widget-3" class="widget widget_featured_posts widget_featured_meta clearfix">      <h3 class="widget-title" style="border-bottom-color:#dd5a5a;"><span style="background-color:#dd5a5a;">COMUNICADO</span></h3>                                                      
							  <div class="widget widget_featured_posts widget_featured_posts_vertical widget_featured_meta clearfix">                                             
							               <div class="single-article clearfix">   
							  <div class="row" style="text-align: justify;">
							    
							    <div class="col-sm-10 col-sm-offset-1">
							    
							    
							    <div style="padding-top:20px; text-align: justify;">
 <h3>${comunicado.titulo} </h3>
 <div class="posted-on" style="float: right;font-size: 15px"><i class="fa fa-calendar-o"></i> <time id="fechaComunicado" class="entry-date published" datetime="${comunicado.fecha}">Publicado: ${comunicado.fecha}</time></div> 
<br><br>
    <p>${comunicado.contenido}
    </p>
    <c:if test="${not empty  comunicado.imagen}">  
    <!-- <img src="${comunicadoNoticia.imagen}">-->
    </c:if>
  
 </div>							    							    							    							    							
								    </div>
								   
								  </div>
								   </div>
								               </div>              
      					</section>           							                      
	         		<div class="clearfix"></div>                        
	            </div>
          </div> 
          
         
        