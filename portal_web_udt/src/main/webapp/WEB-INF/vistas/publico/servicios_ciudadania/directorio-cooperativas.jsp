<%@page contentType="text/html;charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt"%>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>

<style>
	.column {
	  position: relative;
	  float: left;
	  min-height: 1px;
	  width: 25%;
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
</style>
 <div id="main" class="clearfix">
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
 <button class="pag" id='all' style="padding-top: 5px;
    padding-right: 10px;
    padding-bottom: 5px;
    padding-left: 10px;margin-bottom: 1px">Todos</button>
 <c:forEach var="inicial" items="${letraInicialCooperativas}" >
 <button class="pag" id='${inicial.letra}' style="padding-top: 5px;
    padding-right: 10px;
    padding-bottom: 5px;
    padding-left: 10px;margin-bottom: 1px">${inicial.letra}</button>
 </c:forEach> </div>
 <br><br>
  

  
  <!-- Inicio seccion directorio de cooperativas-->
  
  <div class="row my-shuffle-container" style="margin-right:0px;margin-left:0px">
 
 <c:forEach var="coop" items="${listadoCooperativas}" >
	  <div class="col-4@sm picture-item column" data-groups='["${coop.inicial}"]' data-title="${coop.cooperativa }">
		   <div class="thumbnail" style="padding: 0px">
		      <h6 style="text-align: center;padding-top: 8px" class="logo">
		      ${coop.cooperativa}
		      </h6>
		      <c:if test="${coop.logo!='sinlogo'}">
		      <img src="${coop.logo}" style="width: 65%;width: 65%" />
		      </c:if>
		      <div style="background: #eee;padding-left: 10px;padding-bottom: 5px">
		         <p style="margin: 0px 0px 0px 0px"><strong>N° cubículo :</strong> ${coop.cubiculo}</p>
		         <p style="margin: 0px 0px 0px 0px;" >
		         	<i class="fa fa-phone" aria-hidden="true" style="color: #177248"></i>
		 			${coop.telefono}
		 		 </p>
		         <p style="margin: 0px 0px 0px 0px"><i class="fa fa-clock-o" aria-hidden="true" style="color: #177248"></i>
					<strong>Venta boletos:</strong> ${coop.horario}
				</p>
					 <c:if test="${coop.website!='sinwebsite'}">
						<p style="margin: 0px 0px 0px 0px"><i class="fa fa-globe" aria-hidden="true" style="color: #177248"></i>
						<strong>Sitio web:</strong>
					      <a href="${coop.website}" style="color:#337ab7" >${coop.cooperativa}</a>
					     </p>
				      </c:if>
					
				
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
          
          
<script src="https://unpkg.com/shufflejs@5"></script>
<script>
	var Shuffle = window.Shuffle;
	var element = document.querySelector('.my-shuffle-container');
	var sizer = element.querySelector('.my-sizer-element');
	
	var shuffleInstance = new Shuffle(element, {
	  itemSelector: '.picture-item',
	  sizer: sizer // could also be a selector: '.my-sizer-element'
	});
	// shuffleInstance.filter('animal');
	(function() {
    'use strict'
    var todos_botones = $('#sButtons > button');
    todos_botones.click(function(){
        var letra = $(this).text();
        shuffleInstance.filter(letra=='Todos'?'':letra);
    });
	}());

	/**$("#all").on("click", function(){
	   shuffleInstance.filter();
	});
	$("#btn-animal").on("click", function(){
	   shuffleInstance.filter('A');
	});
	$("#btn-city").on("click", function(){
	   shuffleInstance.filter('B');
	});
	$("#btn-nature").on("click", function(){
	   shuffleInstance.filter('C');
	});*/
</script>