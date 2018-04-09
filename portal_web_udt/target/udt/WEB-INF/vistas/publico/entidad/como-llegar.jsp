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
         		            <section id="colormag_featured_posts_widget-3" class="widget widget_featured_posts widget_featured_meta clearfix">      <h3 class="widget-title" style="border-bottom-color:#e5e220;"><span style="background-color:#e5e220;">COMO LLEGAR HASTA LA UDT</span></h3>                                                                                                                            
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