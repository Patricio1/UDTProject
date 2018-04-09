<%@ taglib uri="http://tiles.apache.org/tags-tiles" prefix="tiles"%>
<!DOCTYPE html>
<html lang="en">
<head>
<meta charset="utf-8">
<meta http-equiv="X-UA-Compatible" content="IE=edge">
<meta name="viewport" content="width=device-width, initial-scale=1">
<title><tiles:insertAttribute name="title" ignore="true" /></title>
<!-- Bootstrap -->
<link rel="stylesheet" type="text/css" href="${pageContext.request.contextPath}/recursos/publico/css/bootstrap.min.css" />
<style>
.btn-ver-lista-proximas-salidas
{
  background:#81d742;
  border-color: #81d742;
}
ul.operadoras{
  list-style-type: square;
  text-align:center;  
}
ul.operadoras>li{
  list-style-position: inside;
}
ul.requisitos
{
  list-style-type: square;
}
table.tablamultas>tbody>tr>td
{
 /*text-align: justify;*/
}
table.tablamultas>thead>tr>th
{
 /* text-align: center;*/
}
.carousel-control {
  padding-top:10%;
  width:5%;
  }
  .logo {
  font-family: 'Open Sans', sans-serif;
  color: #555;
  text-decoration: none;
  text-transform: uppercase;
  font-size: 24px;
  font-weight: 800;
  letter-spacing: -3px;
  line-height: 1;
  text-shadow: #EDEDED 3px 2px 0;
  position: relative;
}
.logo:after {
  content:"dreamdealer";
  position: absolute;
  left: 8px;
  top: 32px;
}
.logo:after {
  -webkit-background-clip: text;
  -webkit-text-fill-color: transparent;
  z-index: -5;
  display: block;
  text-shadow: none;
}
.areas-transferencia
{
  font-size: 18px;
  font-weight: bold;
}
</style>
<link rel='stylesheet' id='colormag_google_fonts-css'  
href="${pageContext.request.contextPath}/recursos/publico/css/fonts.css" type='text/css' media='all' />
<link rel='stylesheet' id='colormag_style-css'  
href="${pageContext.request.contextPath}/recursos/publico/css/style.css" type='text/css' media='all' />
<link rel='stylesheet' id='colormag-fontawesome-css'  href="${pageContext.request.contextPath}/recursos/publico/css/font-awesome.css" type='text/css' media='all' />
<link rel='stylesheet'   href="${pageContext.request.contextPath}/recursos/publico/css/etiquetas_ps.css" type='text/css' media='all' />

<script type='text/javascript' src="${pageContext.request.contextPath}/recursos/publico/js/jquery.min.js"></script>
<script type='text/javascript' src='https://maxcdn.bootstrapcdn.com/bootstrap/3.3.7/js/bootstrap.min.js'></script>
<!--fecha regresar arriba -->
<script type='text/javascript' src="${pageContext.request.contextPath}/recursos/publico/js/colormag-custom.js"></script>
<script type='text/javascript' src="${pageContext.request.contextPath}/recursos/publico/js/jquery-simplyscroll/jquery.simplyscroll.js"></script>
<link rel="stylesheet" href="${pageContext.request.contextPath}/recursos/publico/css/jquery-simplyscroll/jquery.simplyscroll.css" media="all" type="text/css">

<link href="${pageContext.request.contextPath}/recursos/publico/css/js-image-slider/js-image-slider.css" rel="stylesheet" type="text/css" />
<script src="${pageContext.request.contextPath}/recursos/publico/js/js-image-slider/js-image-slider.js" type="text/javascript"></script>
<meta property="og:type" content="website" />
<meta property="og:title" content="UDT" />
<meta property="og:description" content="Unidad Desconcentrada de Terminales Ambato" />
<meta property="og:url" content="https://www.udt.gob.ec" />
<meta property="og:site_name" content="UDT" />
<meta property="og:image" content="https://s0.wp.com/i/blank.jpg" />
<meta property="og:locale" content="es_EC" />
<script src='https://www.google.com/recaptcha/api.js'></script>
</head>
<body >


<div id="page" class="hfeed site">
<tiles:insertAttribute name="cabecera" />
		<tiles:insertAttribute name="cuerpo" />		
		<tiles:insertAttribute name="noticias" />
		<tiles:insertAttribute name="pie" />
	
	<a href="#masthead" id="scroll-up"><i class="fa fa-chevron-up"></i></a>
</div><!-- #fin de pagina -->	
<script type='text/javascript' src="${pageContext.request.contextPath}/recursos/publico/js/navigation.js"></script>
<script type='text/javascript' src="${pageContext.request.contextPath}/recursos/publico/js/jquery.newsTicker.min.js"></script>
<script type='text/javascript' src="${pageContext.request.contextPath}/recursos/publico/js/ticker-setting.js"></script>
<script type='text/javascript' src="${pageContext.request.contextPath}/recursos/publico/js/jquery.sticky.js"></script>
<script type='text/javascript' src="${pageContext.request.contextPath}/recursos/publico/js/sticky-setting.js"></script>
<script type="text/javascript"  >
(function($) {	
	$(function() {
		$("#scroller").simplyScroll();						
	});
})(jQuery);
</script>   
<script type="text/javascript">
  /**
 * jQuery.browser.mobile (http://detectmobilebrowser.com/)
 * jQuery.browser.mobile will be true if the browser is a mobile device
 **/
var isMobile = {
    Android: function() {
        return navigator.userAgent.match(/Android/i);
    },
    BlackBerry: function() {
        return navigator.userAgent.match(/BlackBerry/i);
    },
    iOS: function() {
        return navigator.userAgent.match(/iPhone|iPad|iPod/i);
    },
    Opera: function() {
        return navigator.userAgent.match(/Opera Mini/i);
    },
    Windows: function() {
        return navigator.userAgent.match(/IEMobile/i);
    },
    any: function() {
        return (isMobile.Android() || isMobile.BlackBerry() || isMobile.iOS() || isMobile.Opera() || isMobile.Windows());
    }
};
  if(isMobile.any()) {
 $("#myCarousel").show();
 $('#sliderFrame').hide();
}
else
{
  $('#sliderFrame').show();
  $('#myCarousel').hide();
}
  var current_page_URL = location.href;
  $( "a" ).each(function() {
     //if ($(this).attr("href") !== "#") {
       var target_URL = $(this).prop("href");
       if (target_URL == current_page_URL) {
          $('nav a').parents('li, ul').removeClass('menu-item menu-item-type-post_type menu-item-object-page menu-item-196 current-menu-item');
          $(this).parent('li').addClass('menu-item menu-item-type-post_type menu-item-object-page menu-item-196 current-menu-item');
          var padre =  $(this).parent('li').parent().parent().attr('id');
            $('#'+padre).attr('class','menu-item menu-item-type-custom menu-item-object-custom menu-item-has-children current-menu-item');
            //$('#inicio').attr('class','home-icon');
          return false;
       }
     //}
  });
</script> 	
 <script>
$(window).scroll(function() {    
   posicionarMenu();   
});
function posicionarMenu() {
    var altura_del_header = $('#cabecera').outerHeight(true);
    var altura_del_menu = $('#site-navigation').outerHeight(true);
    if ($(window).scrollTop() >= altura_del_header){   
          $('#site-navigation').addClass('main-navigation clearfix');
          $('#site-navigation').css('background-color', '#232323');             
    } else {             
       $('#site-navigation').addClass('main-navigation clearfix');
        $('#site-navigation').css('background-color', '#303030c4');
    }
}
posicionarMenu();

function getInfoInstitucion()
{	  	  	
    	$.ajax({
    		type: "GET",
    		url: 'udt/info-udt',
    		success: function(data,status,xhr)
    		{ 
    			$('#site-description').text(data.nombre);
    			$('#lhome').text(data.abreviatura);
    			$('#lhome').attr('title',data.abreviatura);
    			$('#imglogoudt').attr('src',data.logo);
    			$('#imglogoudt').attr('alt',data.abreviatura);
    			$('#ludt').text(data.nombre);
    			$('#udtDireccion').text(" "+ data.direccion);
    			$('#udtTelefono').text(" "+data.telefono);					    			        		
    		},
    		error: function(xhr, status, error)
    		{
    			console.info(xhr);
    			console.info(status);
    			console.info(error);
    		}
    	}); 
}
getInfoInstitucion();
function getNombresAreaTransferencia()
{	  	  	
    	$.ajax({
    		type: "GET",
    		url: 'udt/nombres-areas-transferencia',
    		success: function(data,status,xhr)
    		{ 
    			$('#art1').text(data[0].nombre);
    			$('#art2').text(data[1].nombre);    			    						    			       
    		},
    		error: function(xhr, status, error)
    		{
    			console.info(xhr);
    			console.info(status);
    			console.info(error);
    		}
    	}); 
}
getNombresAreaTransferencia();
</script>  

</body>
</html>