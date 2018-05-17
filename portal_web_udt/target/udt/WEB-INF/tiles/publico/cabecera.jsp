<header id="masthead" class="site-header clearfix">
 <div id="header-text-nav-container" class="clearfix">
  <div class="news-bar">
   <div class="inner-wrap clearfix">
     <div class="date-in-header" id="divFecha"></div>
     <div class="breaking-news">
        <strong class="breaking-news-latest">Recientes:</strong>
      	<ul class="newsticker" id="sUltimas4Noticias">      
        </ul>
    </div>
  </div>
 </div>
         
			
			<div id="cabecera" class="inner-wrap">

				<div id="header-text-nav-wrap" class="clearfix">
					<div id="header-left-section">
													<div id="header-logo-image">
								
								<img id="logogad" src=""  alt="">							</div><!-- #header-logo-image -->
												<div id="header-text" class="screen-reader-text">
                        							<h1 id="site-title">
   								<a id="lhome" href="#" title="" rel="home"></a>
   							</h1>
                     							                        <p id="site-description"></p>
                     <!-- #site-description -->
						</div><!-- #header-text -->
						
					</div><!-- #header-left-section -->
					
					<div id="header-right-section">
			            <div id="header-right-sidebar" class="clearfix">
			              <aside id="colormag_728x90_advertisement_widget-9" class="">
			                <div class="">
			                    <div class="advertisement-content">
			                       <img id="imglogoudt" width="265" height="90" src="" class="custom-logo" alt="" itemprop="logo" />             
			                           </div>      
			                </div>
			              </aside>            
			            </div>
          			</div>
				

			   </div><!-- #header-text-nav-wrap -->

			</div><!-- .inner-wrap
menu-item menu-item-type-taxonomy menu-item-object-category current-menu-item menu-item-175
front_page_on
current-menu-item = para marcar opcion actual de menu
       -->

			
			<nav id="site-navigation" class="main-navigation clearfix" role="navigation">
				<div class="inner-wrap clearfix">
					                  <div id="inicio" class="home-icon">
                     <a href="<%=request.getContextPath()%>/inicio" title="UDT"><i class="fa fa-home"></i></a>
                  </div>
                                 <h4 class="menu-toggle"></h4>
               <div class="menu-primary-container"><ul id="menu-primary" class="menu">
               <li class="menu-item menu-item-type-custom menu-item-object-custom menu-item-has-children menu-item-236" id="menu-item-236"><a title="Más información acerca de la UDT" href="#">La Entidad</a>
<ul class="sub-menu"  id="entidad" >
  <li class="menu-item menu-item-type-post_type menu-item-object-page menu-item-193" id="acercade"><a style="width: 100%;" href="<%=request.getContextPath()%>/acerca-de-la-udt">Acerca del Terminal</a></li>
  <li class="menu-item menu-item-type-post_type menu-item-object-page menu-item-196" id="plan-estrategico"><a style="width: 100%;" href="<%=request.getContextPath()%>/plan-estrategico">Misión, Visión y Valores</a></li>       
</ul>
</li>
<li class="menu-item menu-item-type-custom menu-item-object-custom menu-item-has-children menu-item-192" id="areas-transferencia"><a href="#">Áreas de transferencia</a>
<ul class="sub-menu">
  <li class="menu-item menu-item-type-post_type menu-item-object-page menu-item-193" id="area-america"><a style="width: 100%;" href="<%=request.getContextPath()%>/areat-america">América</a></li>
   <li class="menu-item menu-item-type-post_type menu-item-object-page menu-item-193" id="area-cashapamba"><a style="width: 100%;" href="<%=request.getContextPath()%>/areat-cashapamba">Cashapamba</a></li>                            
</ul>
</li>
<li class="menu-item menu-item-type-custom menu-item-object-custom menu-item-has-children menu-item-192" id="servicios-ciudadania"><a href="#">Servicios a la ciudadanía</a>
<ul class="sub-menu">
	<li class="menu-item menu-item-type-post_type menu-item-object-page menu-item-196" id="servicios"><a style="width: 100%;" href="<%=request.getContextPath()%>/servicios">Servicios</a></li>
	<li class="menu-item menu-item-type-post_type menu-item-object-page menu-item-193" id="preguntas-frecuentes"><a style="width: 100%;" href="<%=request.getContextPath()%>/preguntas-frecuentes">Preguntas frecuentes</a></li>
   <li class="menu-item menu-item-type-post_type menu-item-object-page menu-item-193" id="directorio-cooperativas"><a style="width: 100%;" href="<%=request.getContextPath()%>/directorio-cooperativas">Directorio de cooperativas</a></li>
      <li class="menu-item menu-item-type-post_type menu-item-object-page menu-item-194" id="cooperativas"><a style="width: 100%;" href="<%=request.getContextPath()%>/cooperativas">Horario Cooperativas</a></li>
            <li class="menu-item menu-item-type-post_type menu-item-object-page menu-item-194" id="glosario"><a style="width: 100%;" href="<%=request.getContextPath()%>/tarifas-transporte">Tarifas transporte</a></li>  
</ul>
</li>

<li class="menu-item menu-item-type-custom menu-item-object-custom menu-item-has-children menu-item-192" id="menu-item-192"><a href="#">Servicios al Transportista</a>
<ul class="sub-menu">  
   <li class="menu-item menu-item-type-post_type menu-item-object-page menu-item-195" id="tramites-transportistas"><a style="width: 100%;" href="<%=request.getContextPath()%>/tramites">Trámites para transportista</a></li>
   <li class="menu-item menu-item-type-post_type menu-item-object-page menu-item-194" id="consulta-multas"><a style="width: 100%;" href="<%=request.getContextPath()%>/consulta-multas">Consulta de multas</a></li> 
</ul>
</li>

<li class="menu-item menu-item-type-custom menu-item-object-custom menu-item-192" id="contacto"><a href="<%=request.getContextPath()%>/contacto">Contáctenos</a>
</li>
</ul></div>                                    
                                        
               				</div>
			</nav>

		</div><!-- #header-text-nav-container -->	
	</header>
	
	<script>
	(function(){
		$.ajax({
    		type: "GET",
    		url: 'udt/gad',
    		success: function(data,status,xhr)
    		{ 	
			$('#logogad').attr('src',data.url);
			$('#logogad').attr('alt',data.descripcion);
    		},
    		error: function(xhr, status, error)
    		{
    			console.info(xhr);
    			console.info(status);
    			console.info(error);
    		}
    	});
	})();
	 (function(){
			$.ajax({
	    		type: "GET",
	    		url: 'udt/fecha_actual',
	    		success: function(data,status,xhr)
	    		{
	    	     $("#divFecha").text(data);				
	    		},
	    		error: function(xhr, status, error)
	    		{
	    			console.info(xhr);
	    			console.info(status);
	    			console.info(error);
	    		}
	    	});
		})();
	 (function(){
		 var link="";
			$.ajax({
	    		type: "GET",
	    		url: 'udt/ultimas4noticias',
	    		success: function(data,status,xhr)
	    		{
	    			$.each(data, function(array,referencia){
	    				var url_noticia="noticia?n="+referencia.id;
	    				link = "<li><a href='"+url_noticia+"' target='_blank' title='"+referencia.titulo+"'>"+referencia.titulo+"</a></li>";
	    				$("#sUltimas4Noticias").append(link);
	    			});
	    		},
	    		error: function(xhr, status, error)
	    		{
	    			console.info(xhr);
	    			console.info(status);
	    			console.info(error);
	    		}
	    	});
		})();
	
	</script>