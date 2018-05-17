	<footer id="colophon" class="clearfix">			
<div class="footer-widgets-wrapper">
  <div class="inner-wrap">
    <div class="footer-widgets-area clearfix">
         <div class="tg-footer-main-widget">
        <div class="tg-first-footer-widget">
	          <aside id="text-3" class="widget widget_text clearfix">
	            <div class="textwidget">
	            	<img id="imgAmbatoTL" alt="" src="">
	            </div>
    		  </aside>         
    	</div>
         </div>
         <div class="tg-footer-other-widgets">
        <div class="tg-second-footer-widget">
              <aside id="text-5" class="widget widget_text clearfix"><h3 class="widget-title"><span>Dirección</span></h3>     
          <div class="textwidget"><ul>
<li> <a id="ludt" href="javascript:void();"></a></li>
<span id="udtDireccion" class="fa fa-map-marker" style="font-size: 17px"></span> 
<span id="udtTelefono" class="fa fa-phone" style="font-size: 17px"></span> 
</ul></div>
    </aside>      
        </div>
            <div class="tg-third-footer-widget">
               <aside id="text-4" class="widget widget_text clearfix"><h3 class="widget-title"><span>Áreas de Transferencia</span></h3>      
	               <div class="textwidget">
	                   <ul>                    
	                      <li> <a id="art1"  href="<%=request.getContextPath()%>/areat-america"></a></li>                     
	                      <li> <a id="art2"  href="<%=request.getContextPath()%>/areat-cashapamba"></a></li>                     
	                   </ul>
	                </div>
    			</aside>            
    </div>
            <div class="tg-fourth-footer-widget">
            <aside id="text-5" class="widget widget_text clearfix">
                  <h3 class="widget-title">
                    <span>Links de Interés</span>
                  </h3>      
                    <div class="textwidget">
                      <ul id="linksInteres">
                         <!--  <li> <a href="http://www.ambato.gob.ec/" target="_blank"><img src="${pageContext.request.contextPath}/recursos/publico/img/logo_gad.png" height="35" width="35" alt="GAD Municipalidad de Ambato"></a></li>
                          <li> <a href="http://www.ant.gob.ec/" target="_blank"><img src="${pageContext.request.contextPath}/recursos/publico/img/ant_logo.png" height="35" width="35" alt="Agencia Nacional de Tránsito"> </a></li>  -->                     
                      </ul>
                    </div>
              </aside>     
            </div>
         </div>
    </div>
  </div>
</div>  		
		</footer>
		<script>
		(function(){
			$.ajax({
	    		type: "GET",
	    		url: 'udt/ambatotl',
	    		success: function(data,status,xhr)
	    		{ 	
				$('#imgAmbatoTL').attr('src',data.url);
				$('#imgAmbatoTL').attr('alt',data.descripcion);
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
	    		url: 'udt/linksInteres',
	    		success: function(data,status,xhr)
	    		{	    			
	    			$.each(data, function(array,referencia){ 	    
	    			link = "<li> <a href='"+referencia.url+"' target='_blank'><img style='margin-bottom:0px' src='"+referencia.icono+"' height='35' width='35' alt='"+referencia.nombre+"'>  "+referencia.nombre+"</a></li>";
	    			$('#linksInteres').append(link);
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