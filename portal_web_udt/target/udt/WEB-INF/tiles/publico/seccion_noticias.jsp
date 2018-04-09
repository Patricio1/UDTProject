<div id="secondary">  <!-- inicia seccion noticias-->
		<aside id="colormag_300x250_advertisement_widget-5" class="widget widget_300x250_advertisement clearfix"></aside>
      <aside id="colormag_featured_posts_vertical_widget-5" class="widget widget_featured_posts widget_featured_posts_vertical widget_featured_meta clearfix">      <h3 class="widget-title" style="border-bottom-color:#a38a6d;"><span style="background-color:#a38a6d;">Noticias</span></h3>
                <div class="first-post" id="sNoticiaPrincipal">                             
                </div>                                 
                <div class="following-post" id="sNoticias">                                                    
                </div>      
      </aside>                    
</div>   <!-- fin seccion noticias-->
 </div>
		</div><!-- .inner-wrap -->
	</div><!-- #main -->
	<script>
	 (function ()
		      {  
		       var indice=0;
		      	$.ajax({
		      		type: "GET",
		      		url: 'udt/titularesnoticias',
		      		success: function(data,status,xhr)
		      		{ 			
		  			$.each(data, function(array,referencia){  				  				  				 		  				
		  			var item_noticia;
		  			var url_noticia="noticia?n="+referencia.id;
		  			if(indice>0)
		  			{
			  			if(referencia.imagen=='sinimagen')
			  				{
			  				item_noticia="<div class='single-article clearfix'><div class='article-content'><h3 class='entry-title'><a href='"+url_noticia+"' title='"+referencia.titulo+"'>"+referencia.titulo+"</a></h3><div class='below-entry-meta'><span class='posted-on'><i class='fa fa-calendar-o'></i><time style='font-size:11px' class='entry-date published' datetime='"+referencia.contenido+"'>"+referencia.contenido+"</time></span><span class='comments'><i class='fa fa-newspaper-o'></i></span></div></div></div>";
			  				}
			  			else
			  				{
			  				item_noticia="<div class='single-article clearfix'><figure><a href='"+url_noticia+"' title='"+referencia.titulo+"'><img width='130' height='90' src='"+referencia.imagen+"' class='attachment-colormag-featured-post-small size-colormag-featured-post-small wp-post-image' alt='"+referencia.titulo+"' title='"+referencia.titulo+"' srcset='"+referencia.imagen+"' sizes='(max-width: 130px) 100vw, 130px' /></a></figure><div class='article-content'><h3 class='entry-title'><a href='"+url_noticia+"' title='"+referencia.titulo+"'>"+referencia.titulo+"</a></h3><div class='below-entry-meta'><span class='posted-on'><i class='fa fa-calendar-o'></i><time style='font-size:11px' class='entry-date published' datetime='"+referencia.contenido+"'>"+referencia.contenido+"</time></span><span class='comments'><i class='fa fa-newspaper-o'></i></span></div></div></div>";
			  				}
		  				$("#sNoticias").append(item_noticia);	
		  			}
		  			indice++;
		  			
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
	 
	 (function ()
		      {    	   	
		      	$.ajax({
		      		type: "GET",
		      		url: 'udt/noticia-principal',
		      		success: function(data,status,xhr)
		      		{
		      			//console.log(data.id+" "+data.titulo+" "+data.contenido+" "+data._fecha+" "+data.imagen);
		  							  				  				 		  				
		  			var noticia;
		  			var url_noticia="noticia?n="+data.id;
		  			if(data.imagen=='sinimagen')
		  				{
		  				noticia="<div class='single-article clearfix'><div class='article-content'><h3 class='entry-title'><a href='"+url_noticia+"' title='"+data.titulo+"'>"+data.titulo+"</a></h3><div class='below-entry-meta'><span class='posted-on'><i class='fa fa-calendar-o'></i><time class='entry-date published' datetime='"+data._fecha+"'>"+data._fecha+"</time></span><span class='comments'><i class='fa fa-newspaper-o'></i></span></div><div class='entry-content'><p style='text-align:justify'>"+data.contenido+"</p></div></div></div>";
		  				}
		  			else
		  				{
		  				noticia="<div class='single-article clearfix'><figure><a href='"+url_noticia+"' title='"+data.titulo+"'><img width='390' height='205' src='"+data.imagen+"' class='attachment-colormag-featured-post-medium size-colormag-featured-post-medium wp-post-image' alt='"+data.titulo+"' title='"+data.titulo+"' /></a></figure><div class='article-content'><h3 class='entry-title'><a href='"+url_noticia+"' title='"+data.titulo+"'>"+data.titulo+"</a></h3><div class='below-entry-meta'><span class='posted-on'><i class='fa fa-calendar-o'></i><time class='entry-date published' datetime='"+data._fecha+"'>"+data._fecha+"</time></span><span class='comments'><i class='fa fa-newspaper-o'></i></span></div><div class='entry-content'><p style='text-align:justify'>"+data.contenido+"</p></div></div></div>";
		  				}
		  			$("#sNoticiaPrincipal").append(noticia);	
		  		        			
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