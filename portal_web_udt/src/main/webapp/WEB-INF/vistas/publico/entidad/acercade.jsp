<%@page contentType="text/html;charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt"%>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
 <div id="main" class="clearfix">
  <div style="margin-left:20px;">
    <div id="bc1" class="myBreadcrumb">
         <div><i class="fa fa-home fa-2x"></i></div>
        <div>La Entidad</div>
    	<div>Acerca de</div>
    </div>
</div>
	<div class="inner-wrap clearfix">
   		<div class="front-page-top-section clearfix" style="margin-bottom: 40px"></div>
   		<div class="main-content-section clearfix">
      		<div id="primary">
         		<div id="content" class="clearfix">
         		        <section id="colormag_featured_posts_widget-3" class="widget widget_featured_posts widget_featured_meta clearfix">      <h3 class="widget-title" style="border-bottom-color:#d8a0c2;"><span style="background-color:#d8a0c2;">ACERCA DE LA UDT</span></h3>                                                      
							  <div class="widget widget_featured_posts widget_featured_posts_vertical widget_featured_meta clearfix">                                             
							               <div class="single-article clearfix">   
							  <div class="row" style="text-align: justify;">
							    <div class="col-sm-1" >      
							    </div>
							    <div class="col-sm-10">
							    ${info.acercaDe}
								 </div>
								    <div class="col-sm-1">    
								    </div>
								  </div>
								   </div>
								               </div>              
      					</section>           							                      
	         		<div class="clearfix"></div>                        
	            </div>
          </div> 