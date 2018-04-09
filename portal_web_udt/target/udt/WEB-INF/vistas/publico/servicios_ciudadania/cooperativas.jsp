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
                           <section id="colormag_featured_posts_widget-3" class="widget widget_featured_posts widget_featured_meta clearfix">      <h3 class="widget-title" style="border-bottom-color:#DC4937;"><span style="background-color:#DC4937;">COOPERATIVAS</span></h3>                                                                                                                            
  <div class="widget widget_featured_posts widget_featured_posts_vertical widget_featured_meta clearfix">
               <div class="single-article clearfix">   
 <div style="padding-left: 30px;padding-right: 30px; text-align: justify;" >
 </div>
 <div class="row" style="margin-left: 5px;margin-bottom: 15px;margin-right: 5px;margin-top:10px">
    <div class="col-sm-6"  > 
    <label for="">Destino</label>
    <select id="cmbDestinos">
     <option value="">--Escoja Destino--</option>
	   <c:forEach items="${destinos}" var="destino">
			<option  value="${destino.idDestino}">${destino.nombreDestino}</option>																								
		</c:forEach>								       
    </select>       
    </div>
    <div class="col-sm-6" style="text-align: justify;">    
     <label for="">Cooperativa</label>
       <select name="" id="cmbCooperativas">
      <option value="">--Escoja Cooperativa--</option>      
    </select>     
    </div>          
  </div>
<div class="table-responsive" style="margin-left: 10px;margin-right: 10px">    
<table  class="table" cellspacing="0" id="tablaHorarios">
 <thead>
    <tr>     
        <th>#</th>              
        <th>Horario</th>
        <th>Anden</th>        
    </tr>
  </thead>
    <tbody>     
      <!-- <tr>
        <td>1</td>       
        <td style="font-size: 17px"><strong>$ 5</strong></td>
        <td>12:35 - 20:00</td>
        <td>6</td>        
      </tr>
      <tr>
        <td>2</td>       
        <td style="font-size: 17px"><strong>$ 4.5</strong></td>
        <td>12:35 - 20:00</td>
        <td>7</td>   
      </tr>
      <tr>
       <td>3</td>       
        <td style="font-size: 17px;font-style: bold"><strong>$ 2.5</strong></td>
        <td>7:35 - 10:00 - 14:00 - 18:00 - 22:00</td>
        <td>4</td>   
      </tr>    -->   
       
    </tbody>
  </table>
 </div>
   </div>
               </div>              
      </section>                                                          
                    <div class="clearfix"></div>                        
                </div>
          </div>
            <script>                             
          function listarCooperativas(dato)
          {     
        	$('#cmbCooperativas').empty().append('<option selected="selected" value="">--Escoja Cooperativa--</option>');

            var url_ = 'udt/destino-cooperativas/'+dato;                       
          	$.ajax({
          		type: "GET",
          		url: url_,
          		success: function(data,status,xhr)
          		{          			
          			$.each(data, function(array,referencia){          				
          			$('#cmbCooperativas').append($("<option />").val(referencia.idCooperativa).text(referencia.nombreCooperativa));
          			//console.log(referencia.idCooperativa);
          			});          		          			      		
          		},
          		error: function(xhr, status, error)
          		{
          			console.info(xhr);
          			console.info(status);
          			console.info(error);
          		}
          	});
          }
          function listarHorarioCooperativas(idDestino,idCooperativa)
          {       
        	$('#tablaHorarios tbody>tr').remove();  
        	var dat = {"idDestino":9,"idCooperativa":1041};
        	var datos = JSON.stringify(dat);
            var url_ = 'udt/horario-cooperativas/'+idDestino+'/'+idCooperativa; 
            var contador = 1;
          	$.ajax({
          		type: "GET",
          		contentType : 'application/json; charset=utf-8',
          	    dataType : 'json',
          		url: url_,          	
          		success: function(data,status,xhr)
          		{          			
          			$.each(data, function(array,referencia){          				
          			//console.log(referencia.horario);
          				$('#tablaHorarios').append("<tr><td>"+contador+"</td><td>"+referencia.dias+"<br>"+referencia.hora+"</td><td>"+referencia.anden+"</td></tr>");
          				contador++;
          			});          		          			      		
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
        	  $('#cmbDestinos').on('change',function(){        		 
        		  listarCooperativas(this.value);        		 
        	  }) 
        	   $('#cmbCooperativas').on('change',function(){        		 
        		  var dest = $('#cmbDestinos').val();
             	  var coop = $('#cmbCooperativas').val();  
             	  //console.log("destino: "+dest+" coop: "+coop);
             	  listarHorarioCooperativas(dest,coop);      		 
        	  })
        });
                  
          </script>