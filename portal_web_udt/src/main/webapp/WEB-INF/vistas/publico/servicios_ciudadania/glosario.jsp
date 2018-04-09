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
                              <section id="colormag_featured_posts_widget-3" class="widget widget_featured_posts widget_featured_meta clearfix">      <h3 class="widget-title" style="border-bottom-color:#289dcc;"><span style="background-color:#289dcc;">GLOSARIO DE TÉRMINOS</span></h3>                                                                                                                            
  <div class="widget widget_featured_posts widget_featured_posts_vertical widget_featured_meta clearfix">
               <div class="single-article clearfix">   
 <div style="padding-left: 30px;padding-right: 30px; text-align: justify;" >
 </div>
 
 <!--  Inicio seccion glosario -->
     <c:forEach items="${glosario}" var="termino">
    	 <div class="row">
		    <div class="col-sm-10 col-sm-offset-1" style="text-align: justify;">
		     <span class="fa fa-question-circle" style="color:#289dcc"></span><strong> ${termino.nombre}</strong>
			 <p>${termino.descripcion}</p> 
		    </div>
  		</div>			 																
	</c:forEach>
     <!-- Fin seccion glosario --> 
   </div>
               </div>              
      </section>                                                      
                    <div class="clearfix"></div>                        
                </div>
          </div>