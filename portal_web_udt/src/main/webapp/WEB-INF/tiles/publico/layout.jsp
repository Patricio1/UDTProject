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
<style>
.myBreadcrumb {
	display: inline-block;
	box-shadow: 0 0 15px 1px rgba(0, 0, 0, 0.35);
	overflow: hidden;
	border-radius: 5px;
}

.myBreadcrumb > * {
	text-decoration: none;
	outline: none;
	display: block;
	float: left;
	font-size: 12px;
	line-height: 36px;
    color: black;
	/*need more margin on the left of links to accomodate the numbers*/
	padding: 0 10px 0 30px;
	background: white;
	position: relative;
    transition: all 0.5s;
}

.myBreadcrumb > * div {
    white-space: nowrap;
    overflow: hidden;
    text-overflow: ellipsis;    
}

/*since the first link does not have a triangle before it we can reduce the left padding to make it look consistent with other links*/
.myBreadcrumb > *:first-child {
	padding-left: 10px;
	border-radius: 5px 0 0 5px; /*to match with the parent's radius*/
}

.myBreadcrumb >*:first-child i {
    vertical-align: sub;
}

.myBreadcrumb > *:last-child {
	border-radius: 0 5px 5px 0; /*this was to prevent glitches on hover*/
	padding-right: 20px;
    padding-right: 8px;
}

/*hover/active styles*/
.myBreadcrumb a.active, .myBreadcrumb a:hover{
	/*background: #e54e53;
	color:white;*/
}
.myBreadcrumb a.active:after, .myBreadcrumb a:hover:after {
	/*background: #e54e53;*/
}

/*adding the arrows for the myBreadcrumbs using rotated pseudo elements*/
.myBreadcrumb > *:after {
	content: '';
	position: absolute;
	top: 0; 
	right: -18px; /*half of square's length*/
	/*same dimension as the line-height of .myBreadcrumb a */
	width: 36px; 
	height: 36px;
	/*as you see the rotated square takes a larger height. which makes it tough to position it properly. So we are going to scale it down so that the diagonals become equal to the line-height of the link. We scale it to 70.7% because if square's: 
	length = 1; diagonal = (1^2 + 1^2)^0.5 = 1.414 (pythagoras theorem)
	if diagonal required = 1; length = 1/1.414 = 0.707*/
	transform: scale(0.707) rotate(45deg);
    -ms-transform:scale(0.707) rotate(45deg);
    -webkit-transform:scale(0.707) rotate(45deg);
    
	/*we need to prevent the arrows from getting buried under the next link*/
	z-index: 1;
	/*background same as links but the gradient will be rotated to compensate with the transform applied*/
	background: white;
	/*stylish arrow design using box shadow*/
	box-shadow: 
		2px -2px 0 2px rgba(0, 0, 0, 0.4), 
		3px -3px 0 2px rgba(255, 255, 255, 0.1);
	/*
		5px - for rounded arrows and 
		50px - to prevent hover glitches on the border created using shadows*/
	border-radius: 0 5px 0 50px;
    transition: all 0.5s;
}
/*we dont need an arrow after the last link*/
.myBreadcrumb > *:last-child:after {
	content: none;
}
/*we will use the :before element to show numbers*/
.myBreadcrumb > *:before {
	/*some styles now*/
	border-radius: 100%;
	width: 20px;
	height: 20px;
	line-height: 20px;
	margin: 8px 0;
	position: absolute;
	top: 0;
	left: 30px;
    background: white;
	background: linear-gradient(#444, #222);
	font-weight: bold;
    box-shadow: 0 0 0 1px #ccc;
}

.myBreadcrumb > *:nth-child(n+2) {
  display:none;
}


@media (max-width: 767px) {
    .myBreadcrumb > *:nth-last-child(-n+4) {
        display:block;
    } 
    .myBreadcrumb > * div {
        max-width: 100px;
    }
}

@media (min-width: 768px) {
    .myBreadcrumb > *:nth-last-child(-n+6) {
        display:block;
    } 
    .myBreadcrumb > * div {
        max-width: 175px;
    }
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
          //console.log("item: "+$(this).parent('li').parent().text()+" - "+$(this).text());
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