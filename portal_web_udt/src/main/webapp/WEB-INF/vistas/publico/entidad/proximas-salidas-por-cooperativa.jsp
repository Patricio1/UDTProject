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
				<section id="colormag_featured_posts_widget-3" class="widget widget_featured_posts widget_featured_meta clearfix">
					<h3 class="widget-title" style="border-bottom-color:#177248;">
						<span id="tituloProximaSalida" style="background-color:#177248;">
						</span>
					</h3>                                                                                                                            
				  	<div class="widget widget_featured_posts widget_featured_posts_vertical widget_featured_meta clearfix">
				      <div class="single-article clearfix" id="sProximaSalida"> 				        				 		
				   	  </div>
				    </div>              
				</section>                                              
                    <div class="clearfix"></div>                        
                </div>
          </div>
          
          <script>                             
          function listarDetalleProximasSalidas()
          {
        	  var url = window.location;
              var urlDecode = decodeURI(url);
               var no = /no=([^&]+)/.exec(urlDecode)[1];
               var io = /io=([^&]+)/.exec(urlDecode)[1]; 
               var nd = /nd=([^&]+)/.exec(urlDecode)[1];           
               var id = /id=([^&]+)/.exec(urlDecode)[1];         
               var url_ = 'udt/detalle-proximas-salidas/'+io+'/'+id;
               
        	  var contador = 1;
        	  var row = '<div class="row" style="text-align: center;">';  
        	  var rowComplete = "";
        	  var column = '';
        	  //var cooperativa = '';
          	$.ajax({
          		type: "GET",
          		url: url_,
          		success: function(data,status,xhr)
          		{
          			var banderin=0;
          			var numeroRegistros =  Object.keys(data).length;
          			//numeroRegistros+=1;
          			console.log(numeroRegistros);
          			//mostrarTabla(data);
          			$.each(data, function(array,referencia){          				
          				if(contador % 3 == 0 && contador > 2)
          					{
          					column +='<div class="col-sm-4"><div class="col-item"><div style="margin-top: 5px" ><h6>'+no+'-'+nd+'</h6><img alt="" src="http://static.websguru.com.ar/var/m_4/4d/4d9/34457/540392-icono-bus.png" style="width: 35%;width: 35%"></div><div class="info"><div class="row info-pasaje"><h6 class="col-md-10 col-xs-9"><p style="margin: 0px 0px 0px 0px;" >COOP.: '+'<strong>'+referencia.cooperativa+'</strong></p><p style="margin: 0px 0px 0px 0px">ANDEN : '+'<strong>'+referencia.anden+'</strong></p></h6><div class="col-md-2"><div class="cartel"><div class="cartel-day">Hoy</div><div class="cartel-hour">'+referencia.hora+'</div></div></div></div><div class="clearfix"></div></div></div></div>';
              				var auxRow = row+column+"</div><br>";
              				rowComplete+=auxRow;
              				banderin++;              				
          					}
          				else
          					{
          					//column = '<div class="col-sm-4"><div class="col-item"><div style="margin-top: 5px" ><h6>'+referencia.origen+'-'+referencia.destino+'</h6><img alt="" src="http://static.websguru.com.ar/var/m_4/4d/4d9/34457/540392-icono-bus.png" style="width: 35%;width: 35%"></div><div class="info"><div class="row info-pasaje"><h6 class="col-md-10 col-xs-9"><p style="margin: 0px 0px 0px 0px">ANDEN : '+referencia.anden+'</p><p style="margin: 0px 0px 0px 0px;font-weight: bold" >'+referencia.cooperativa+'</p></h6><div class="col-md-2"><div class="cartel"><div class="cartel-day">Hoy</div><div class="cartel-hour">'+referencia.hora+'</div></div></div></div><div class="clearfix"></div></div></div></div>';
          					if(banderin>0)
          						{
          						column ='<div class="col-sm-4"><div class="col-item"><div style="margin-top: 5px" ><h6>'+no+'-'+nd+'</h6><img alt="" src="http://static.websguru.com.ar/var/m_4/4d/4d9/34457/540392-icono-bus.png" style="width: 35%;width: 35%"></div><div class="info"><div class="row info-pasaje"><h6 class="col-md-10 col-xs-9"><p style="margin: 0px 0px 0px 0px;" >COOP.: '+'<strong>'+referencia.cooperativa+'</strong></p><p style="margin: 0px 0px 0px 0px">ANDEN : '+'<strong>'+referencia.anden+'</strong></p></h6><div class="col-md-2"><div class="cartel"><div class="cartel-day">Hoy</div><div class="cartel-hour">'+referencia.hora+'</div></div></div></div><div class="clearfix"></div></div></div></div>';
          						banderin = 0;
          						}
          					else column +='<div class="col-sm-4"><div class="col-item"><div style="margin-top: 5px" ><h6>'+no+'-'+nd+'</h6><img alt="" src="http://static.websguru.com.ar/var/m_4/4d/4d9/34457/540392-icono-bus.png" style="width: 35%;width: 35%"></div><div class="info"><div class="row info-pasaje"><h6 class="col-md-10 col-xs-9"><p style="margin: 0px 0px 0px 0px;" >COOP.: '+'<strong>'+referencia.cooperativa+'</strong></p><p style="margin: 0px 0px 0px 0px">ANDEN : '+'<strong>'+referencia.anden+'</strong></p></h6><div class="col-md-2"><div class="cartel"><div class="cartel-day">Hoy</div><div class="cartel-hour">'+referencia.hora+'</div></div></div></div><div class="clearfix"></div></div></div></div>';
          					
          					if(contador == numeroRegistros)
          						{
          						//column +='<div class="col-sm-4"><div class="col-item"><div style="margin-top: 5px" ><h6>'+referencia.origen+'-'+referencia.destino+'</h6><img alt="" src="http://static.websguru.com.ar/var/m_4/4d/4d9/34457/540392-icono-bus.png" style="width: 35%;width: 35%"></div><div class="info"><div class="row info-pasaje"><h6 class="col-md-10 col-xs-9"><p style="margin: 0px 0px 0px 0px">ANDEN : '+referencia.anden+'</p><p style="margin: 0px 0px 0px 0px;font-weight: bold" >'+referencia.cooperativa+'</p></h6><div class="col-md-2"><div class="cartel"><div class="cartel-day">Hoy</div><div class="cartel-hour">'+referencia.hora+'</div></div></div></div><div class="clearfix"></div></div></div></div>';
                  				var auxRow = row+column+"</div><br>";
                  				rowComplete+=auxRow;
          						}          				
          					}
          				contador++;
          				

          			});
          			//console.log(rowComplete);
          			$('#sProximaSalida').append(rowComplete);
          			$('#tituloProximaSalida').text('PRÓXIMAS SALIDAS: '+no+'-'+nd);
          			if(contador==1)
          				{
          				$('#sProximaSalida').append('<p><strong>NO SE HAN ENCONTRADO RESULTADOS</strong></p>');
          				}
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
        	  listarDetalleProximasSalidas();                                      
        });
          </script>