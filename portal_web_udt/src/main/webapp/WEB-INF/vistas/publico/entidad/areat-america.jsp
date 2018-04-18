<%@page contentType="text/html;charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt"%>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>


 <div id="main" class="clearfix">
  <div style="margin-left:20px;">
    <div id="bc1" class="myBreadcrumb">
         <div><i class="fa fa-home fa-2x"></i></div>
        <div>Áreas de transferencia</div>
    	<div>América</div>
    </div>
</div>
	<div class="inner-wrap clearfix">
   		<div class="front-page-top-section clearfix" style="margin-bottom: 40px"></div>
   		<div class="main-content-section clearfix">
   		
   		

      		<div id="primary">
         		<div id="content" class="clearfix">
         		         <section id="colormag_featured_posts_widget-3" class="widget widget_featured_posts widget_featured_meta clearfix">      <h3 class="widget-title" style="border-bottom-color:#004d40;"><span id="nombreArea" style="background-color:#004d40;"><c:out value="${area.nombre}" /></span></h3>                                                                                                                            
								  <div class="widget widget_featured_posts widget_featured_posts_vertical widget_featured_meta clearfix">                                             
								
								               <div class="single-article clearfix">   

  															 								
 <div class="row" style="margin-top: 28px;">
  <div class="col-md-10 col-md-offset-1">
    <c:if test="${area.img!='no-image'}">
					<img src="${area.img}" alt="${area.nombre}"/>
	</c:if>
    
  </div>
</div> 
<div class="row">
  <div class="col-md-10 col-md-offset-1" >
    <span class="fa fa-map-marker" style="font-size: 18px;color: #00796b"></span><strong> Dirección:</strong> <c:out value="${area.direccion}" /> <br>
    <span class="fa fa-phone" style="font-size: 18px;color: #00796b"></span> <c:out value="${area.telefono}" /><br>
    <span class="fa fa-bus" style="font-size: 18px;color: #00796b"></span> <c:out value="${area.tipoTransp}" />
  </div>  
</div>
 <div class="row" style="margin-top: 10px"> 
  <div class="col-md-4 col-md-offset-4"><h6 style="font-weight: bold">Destinos:</h6></div>
</div>

 <div id="sDestinos">   
  </div>   
								  
								    
								   </div>
								               </div>              
      					</section>
      				          							                     
	         		<div class="clearfix"></div>                        
	            </div>
          </div>
          <script>
          function getListaCooperativas(sCooperativas)
          {
        	  var cooperativas = sCooperativas.split(',');
		      var liOperadoras = "";
		      var ulOperadoras = '<ul class="operadoras">';		        		      	    
		        for (var i = 0; i < cooperativas.length; i++) {
		        	liOperadoras += '<li>'+cooperativas[i]+'</li>';
				}
		        ulOperadoras+=liOperadoras+'</ul>';
		        return ulOperadoras;
          }
          function getDestinos()
          {
        	  var contador = 1;
        	  var row = '<div class="row" style="text-align: center;padding-bottom: 15px;margin-bottom:15px;margin-right:2px;margin-left:2px">';  
        	  var rowComplete = "";
        	  var column = ''; 
        	  var cooperativas = [];
          	$.ajax({
          		type: "GET",
          		url: 'udt/destinos-coop-intercantonal',
          		success: function(data,status,xhr)
          		{
          		var banderin=0;
      			var numeroRegistros =  Object.keys(data).length;  			      			 		
      			$.each(data, function(array,referencia){  				  				  				 
      				if(contador % 3 == 0 && contador > 2)
      					{      					 					
      					//column +='<div class="col-sm-4" ><h6 class="areas-transferencia">AMBATO-'+referencia.destino+'</h6><span class="fa fa-bus" style="font-size: 45px;color:#00796b"></span><p style="margin: 0px 0px 0px 0px;font-weight: bold">Operadoras:</p>'+getListaCooperativas(referencia.cooperativas)+'</div>';      			      
          				column +='<div class="col-sm-4" ><div class="thumbnail" style="padding: 0px;border-color:#a5d6a7"><h6 class="areas-transferencia" style="margin-top:4px">AMBATO-'+referencia.destino+'</h6><span class="fa fa-bus" style="font-size: 45px;color:#00796b;margin-bottom:4px"></span><div style="background: #e8f5e9;padding-left: 10px;padding-bottom: 5px;border-top-color:#a5d6a7;border-top-style: solid;border-top-width: 1px"><p style="margin: 0px 0px 0px 0px;font-weight: bold">Operadoras:</p>'+getListaCooperativas(referencia.cooperativas)+'</div></div></div>';      			               				
          				var auxRow = row+column+"</div>";
          				rowComplete+=auxRow;
          				banderin++;      				
      					}
      				else
      					{  					
      					if(banderin>0)
      						{
      						//column ='<div class="col-sm-4" ><h6 class="areas-transferencia">AMBATO-'+referencia.destino+'</h6><span class="fa fa-bus" style="font-size: 45px;color:#00796b"></span><p style="margin: 0px 0px 0px 0px;font-weight: bold">Operadoras:</p>'+getListaCooperativas(referencia.cooperativas)+'</div>';
      						column ='<div class="col-sm-4" ><div class="thumbnail" style="padding: 0px;border-color:#a5d6a7"><h6 class="areas-transferencia" style="margin-top:4px">AMBATO-'+referencia.destino+'</h6><span class="fa fa-bus" style="font-size: 45px;color:#00796b;margin-bottom:4px"></span><div style="background: #e8f5e9;padding-left: 10px;padding-bottom: 5px;border-top-color:#a5d6a7;border-top-style: solid;border-top-width: 1px"><p style="margin: 0px 0px 0px 0px;font-weight: bold">Operadoras:</p>'+getListaCooperativas(referencia.cooperativas)+'</div></div></div>';       						
      						banderin = 0;
      						}
      					else //column +='<div class="col-sm-4" ><h6 class="areas-transferencia">AMBATO-'+referencia.destino+'</h6><span class="fa fa-bus" style="font-size: 45px;color:#00796b"></span><p style="margin: 0px 0px 0px 0px;font-weight: bold">Operadoras:</p>'+getListaCooperativas(referencia.cooperativas)+'</div>';
      						column +='<div class="col-sm-4" ><div class="thumbnail" style="padding: 0px;border-color:#a5d6a7"><h6 class="areas-transferencia" style="margin-top:4px">AMBATO-'+referencia.destino+'</h6><span class="fa fa-bus" style="font-size: 45px;color:#00796b;margin-bottom:4px"></span><div style="background: #e8f5e9;padding-left: 10px;padding-bottom: 5px;border-top-color:#a5d6a7;border-top-style: solid;border-top-width: 1px"><p style="margin: 0px 0px 0px 0px;font-weight: bold">Operadoras:</p>'+getListaCooperativas(referencia.cooperativas)+'</div></div></div>';       					
      						
          					if(contador == numeroRegistros)
      						{  						
              				var auxRow = row+column+"</div>";
              				rowComplete+=auxRow;
      						}          				
      					}
      				contador++;
          			});          			
          			$('#sDestinos').append(rowComplete);          			
          		},
          		error: function(xhr, status, error)
          		{
          			console.info(xhr);
          			console.info(status);
          			console.info(error);
          		}
          	});
          }
          
          $(document).ready(function() {
        	  var lowerCase = $('#nombreArea').text();
        	  var UpperCase = lowerCase.toUpperCase();
        	  $('#nombreArea').text(UpperCase);
        	  getDestinos();
        	// console.log(getListaCooperativas("hola,mundo,cruel"));
        	});
          </script>