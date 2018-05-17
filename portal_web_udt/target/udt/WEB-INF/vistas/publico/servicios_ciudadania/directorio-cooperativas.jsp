<%@page contentType="text/html;charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt"%>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>

<style>
	.column {
	  position: relative;
	  float: left;
	  min-height: 1px;
	  width: 33.3%;
	  padding-left: 4px;
	  padding-right: 4px;
	  /* Space between tiles */
	  margin-top: 8px;
	}
	
	.col-span {
	  width: 50%;
	}
	
	.my-sizer-element {
	  width: 8.33333%;
	}
	
	/* default styles so shuffle doesn't have to set them (it will if they're missing) */
	.my-shuffle {
	  position: relative;
	  overflow: hidden;
	}
	
	/* Ensure images take up the same space when they load */
	/* https://vestride.github.io/Shuffle/images */
	.aspect {
	  position: relative;
	  width: 100%;
	  height: 0;
	  padding-bottom: 100%;
	  overflow: hidden;
	}
	
	.aspect__inner {
	  position: absolute;
	  top: 0;
	  right: 0;
	  bottom: 0;
	  left: 0;
	}
	/* Small reset */
	*,
	::before,
	::after {
	  box-sizing: border-box;
	}
	figure {
	  margin: 0;
	  padding: 0;
	}
	figure:nth-child(2n){
	  margin-bottom:30px;
	}
	figure:nth-child(2n+1){
	  margin-top:30px;
	}
	.pag
	{
	background-color:#c62828;
	}
	.pag:hover
	{
	background-color:#c62828;
	}
	.pag1
	{
	background-color:e54e53;
	}
	.pag1:hover
	{
	background-color:#c62828;
	}
</style>
 <div id="main" class="clearfix">
  <div style="margin-left:20px;">
    <div id="bc1" class="myBreadcrumb">
         <div><i class="fa fa-home fa-2x"></i></div>
        <div>Servicios a la ciudadanía</div>
    	<div>Directorio de cooperativas</div>
    </div>
</div>
    <div class="inner-wrap clearfix">
        <div class="front-page-top-section clearfix" style="margin-bottom: 40px"></div>
        <div class="main-content-section clearfix">
            <div id="primary">
                <div id="content" class="clearfix">
                         <section id="colormag_featured_posts_widget-3" class="widget widget_featured_posts widget_featured_meta clearfix">      <h3 class="widget-title" style="border-bottom-color:#e54e53;"><span style="background-color:#e54e53;">DIRECTORIO DE COOPERATIVAS</span></h3>                                                                                                                            
  <div class="widget widget_featured_posts widget_featured_posts_vertical widget_featured_meta clearfix">
               <div class="single-article clearfix">   
 <div style="padding-left: 30px;padding-right: 30px; text-align: justify;" >
 </div>
 <div id="sButtons" class="row" style="margin-bottom: 15px;margin-right:0px;margin-left:0px">
 <button class="pag1" id='all' style="padding-top: 5px;
    padding-right: 10px;
    padding-bottom: 5px;
    padding-left: 10px;margin-bottom: 1px">Todos</button>
 <c:forEach var="inicial" items="${letraInicialCooperativas}" >
 <button class="pag1" id='${inicial.letra}' style="padding-top: 5px;
    padding-right: 10px;
    padding-bottom: 5px;
    padding-left: 10px;margin-bottom: 1px">${inicial.letra}</button>
 </c:forEach> </div>
  

  
  <!-- Inicio seccion directorio de cooperativas-->
  
 
  <div class="row my-shuffle-container" style="margin-right:0px;margin-left:0px" id="directorio">
 
 <c:forEach var="coop" items="${listadoCooperativas}" >
	  <div  class="col-4@sm picture-item column" data-groups='["${coop.inicial}"]' data-title="${coop.cooperativa }">
		   <div class="thumbnail" style="padding: 0px">
		      <h6 style="text-align: center;padding-top: 8px" class="logo">
		      ${coop.cooperativa}
		      </h6>
		      <c:if test="${coop.logo!='no-logo'}">
		      <img src="${coop.logo}" style="width: 65%;width: 65%" />
		      </c:if>
		      <div style="background: #eee;padding-left: 10px;padding-bottom: 5px">
		         <p style="margin: 0px 0px 0px 0px"><strong>N° cubículo :</strong> ${coop.cubiculo}</p>
		         <c:if test="${not empty coop.telefono}">
				   <p style="margin: 0px 0px 0px 0px;" >
		         	<i class="fa fa-phone" aria-hidden="true" style="color: #177248"></i>
		 			${coop.telefono}
		 		  </p>
				</c:if>
		         
				<c:if test="${not empty coop.horario}">
				   <p style="margin: 0px 0px 0px 0px"><i class="fa fa-clock-o" aria-hidden="true" style="color: #177248"></i>
					<strong>Venta boletos:</strong> ${coop.horario}
				</p>
				</c:if>
					 <c:if test="${coop.website!='no-website'}">
						<p style="margin: 0px 0px 0px 0px"><i class="fa fa-globe" aria-hidden="true" style="color: #177248"></i>
						<strong>Sitio web:</strong>
					      <a href="<c:out value="${coop.website}" />" target="_blank" style="color:#337ab7" >${coop.website}</a>
					     </p>
				      </c:if>
				<p class="destinos" style="margin: 0px 0px 0px 0px"><i class="fa fa-bus" aria-hidden="true" style="color: #177248"></i>
					<strong>Destinos:</strong> ${coop.destinos}
				</p>
					
				
		      </div>
		  </div>
	 </div>
 </c:forEach>

</div>
  <!-- Fin seccion directorio de cooperativas -->
  
  
   </div>
               </div>              
      </section>                                                           
                    <div class="clearfix"></div>                        
                </div>
          </div>
          
          
<script type='text/javascript' src="${pageContext.request.contextPath}/recursos/publico/js/shuffle.js"></script>
<script>
///inicio de codigo de prueba
/*var contenido = $('.destinos').text();
var aux = new Array();
aux = contenido.split("Destinos:");
var destinos = new Array();
var aDestinos = new Array();
for ( var i=0;i<aux.length;i++) {
	var clase = aux[i].trim().valueOf();
	destinos = aux[i].trim().split(",");
	for ( var j=0; j<destinos.length;j++) {
		if(destinos[j].trim().length>0)
		aDestinos.push(destinos[j].trim());
	}
}

var a = aDestinos;//["1", "1", "2", "3", "3", "1"];
var unique = a.filter(function(item, i, ar){ return ar.indexOf(item) === i; });
unique.sort();
var buttons ="";
for ( var i=0;i<unique.length;i++) {
var button = '<button class="pag1" id='+unique[i]+' style="padding-top: 5px;margin-right: 5px;padding-bottom: 5px;padding-left: 10px;margin-bottom: 2px">'+unique[i]+'</button>';
buttons+=button;
}

$('#sButtons').append(buttons);
/**(function() {
    'use strict'
    var todos_botones = $('#sButtons > button');
    todos_botones.click(function(){
        var currentButton = $(this).attr('id');
            todos_botones.each(function(){
                if(currentButton == $(this).attr('id'))
                    {
                    }
                else $(this).attr('class','pag1');
             });
        $(this).attr('class','pag');
        var letra = $(this).text();
        $('.destinos').each(function(){
            //var dest = this('.destinos').text();
        	//$(this).hide();
        	console.log("jaja: "+$(this).text());
        	var nombre =letra;
        	if($(this).text().includes(nombre))
            	{
        		$(this).parent().parent().parent().show();
            	}
        	else
				{
        		$(this).parent().parent().parent().hide();
        		}
    		if(letra=='Todos')
        		{
    			$(this).parent().parent().parent().show();
        		}
            	
        	
            console.log("jaja: "+dest);
        })


        
    });
	}());*/






//////////fin codigo de prueba
	var Shuffle = window.Shuffle;
	var element = document.querySelector('.my-shuffle-container');
	var sizer = element.querySelector('.my-sizer-element');
	
	var shuffleInstance = new Shuffle(element, {
	  itemSelector: '.picture-item',
	  sizer: sizer // could also be a selector: '.my-sizer-element'
	});
	  
	(function() {
    'use strict'
    var todos_botones = $('#sButtons > button');
    todos_botones.click(function(){
        var currentButton = $(this).attr('id');
            todos_botones.each(function(){
                if(currentButton == $(this).attr('id'))
                    {
                    }
                else $(this).attr('class','pag1');
             });
        $(this).attr('class','pag');
        var letra = $(this).text();
        shuffleInstance.filter(letra=='Todos'?'':letra);
    });
	}());
	$('#directorio').children().each(function(){
	    var $img = $(this).find("img");
	    var value = imageExists($img.attr('src'));
	    if(!value)
		    {
	    	$img.hide();
		    }
	});
	function imageExists(image_url){

	    var http = new XMLHttpRequest();

	    http.open('HEAD', image_url, false);
	    http.send();

	    return http.status != 404;
	}
</script>