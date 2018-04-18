<%@ taglib uri="http://tiles.apache.org/tags-tiles" prefix="tiles"%>
<!DOCTYPE html>
<html lang="en">
<head>
<meta charset="utf-8">
<meta http-equiv="X-UA-Compatible" content="IE=edge">
<meta name="viewport" content="width=device-width, initial-scale=1">
<title><tiles:insertAttribute name="title" ignore="true" /></title>
<!-- Bootstrap -->

	<!-- bootstrap & fontawesome -->
	<link rel="stylesheet" type="text/css" href="${pageContext.request.contextPath}/recursos/publico/css/bootstrap.min.css" />
<link rel='stylesheet' id='colormag-fontawesome-css'  href="${pageContext.request.contextPath}/recursos/publico/css/font-awesome.css" type='text/css' media='all' />

		<!-- page specific plugin styles -->
		<link rel="stylesheet" href="${pageContext.request.contextPath}/recursos/admin/css/jquery-ui.custom.min.css" />
		<link rel="stylesheet" href="${pageContext.request.contextPath}/recursos/admin/css/chosen.min.css" />
		<link rel="stylesheet" href="${pageContext.request.contextPath}/recursos/admin/css/bootstrap-datepicker3.min.css" />
		<link rel="stylesheet" href="${pageContext.request.contextPath}/recursos/admin/css/bootstrap-timepicker.min.css" />
		<link rel="stylesheet" href="${pageContext.request.contextPath}/recursos/admin/css/daterangepicker.min.css" />
		<link rel="stylesheet" href="${pageContext.request.contextPath}/recursos/admin/css/bootstrap-datetimepicker.min.css" />
		<link rel="stylesheet" href="${pageContext.request.contextPath}/recursos/admin/css/bootstrap-colorpicker.min.css" />

		<!-- text fonts -->
		<link rel="stylesheet" href="${pageContext.request.contextPath}/recursos/admin/css/fonts.googleapis.com.css" />

		<!-- ace styles -->
		<link rel="stylesheet" href="${pageContext.request.contextPath}/recursos/admin/css/ace.min.css" class="ace-main-stylesheet" id="main-ace-style" />

		<!--[if lte IE 9]>
			<link rel="stylesheet" href="assets/css/ace-part2.min.css" class="ace-main-stylesheet" />
		<![endif]-->
		<link rel="stylesheet" href="${pageContext.request.contextPath}/recursos/admin/css/ace-skins.min.css" />
		<link rel="stylesheet" href="${pageContext.request.contextPath}/recursos/admin/css/ace-rtl.min.css" />



<!-- 

<link rel='stylesheet'
href="${pageContext.request.contextPath}/recursos/admin/css/ace.min.css" class="ace-main-stylesheet" id="main-ace-style" />
<link rel='stylesheet'  
href="${pageContext.request.contextPath}/recursos/admin/css/fonts.googleapis.com.css" type='text/css' media='all' />

<link rel="stylesheet" href="${pageContext.request.contextPath}/recursos/admin/css/bootstrap-datepicker3.min.css"/>
<link rel="stylesheet" href="${pageContext.request.contextPath}/recursos/admin/css/ace-skins.min.css" />
<link rel="stylesheet" href="${pageContext.request.contextPath}/recursos/admin/css/ace-rtl.min.css" />
-->
<script type='text/javascript' src="${pageContext.request.contextPath}/recursos/publico/js/jquery.min.js"></script>


	<script type="text/javascript">
			if('ontouchstart' in document.documentElement) document.write("<script src='${pageContext.request.contextPath}/recursos/admin/js/jquery.mobile.custom.min.js'>"+"<"+"/script>");
		</script>
		
<script type='text/javascript' src='https://maxcdn.bootstrapcdn.com/bootstrap/3.3.7/js/bootstrap.min.js'></script>

		<script src="${pageContext.request.contextPath}/recursos/admin/js/jquery-ui.custom.min.js"></script>
		<script src="${pageContext.request.contextPath}/recursos/admin/js/jquery.ui.touch-punch.min.js"></script>
		<script src="${pageContext.request.contextPath}/recursos/admin/js/chosen.jquery.min.js"></script>
		<script src="${pageContext.request.contextPath}/recursos/admin/js/spinbox.min.js"></script>
		<script src="${pageContext.request.contextPath}/recursos/admin/js/bootstrap-datepicker.min.js"></script>
		<script src="${pageContext.request.contextPath}/recursos/admin/js/bootstrap-timepicker.min.js"></script>
		<script src="${pageContext.request.contextPath}/recursos/admin/js/moment.min.js"></script>
		<script src="${pageContext.request.contextPath}/recursos/admin/js/daterangepicker.min.js"></script>

		<script src="${pageContext.request.contextPath}/recursos/admin/js/bootstrap-colorpicker.min.js"></script>
		<script src="${pageContext.request.contextPath}/recursos/admin/js/jquery.knob.min.js"></script>
		<script src="${pageContext.request.contextPath}/recursos/admin/js/autosize.min.js"></script>
		<script src="${pageContext.request.contextPath}/recursos/admin/js/jquery.inputlimiter.min.js"></script>
		<script src="${pageContext.request.contextPath}/recursos/admin/js/jquery.maskedinput.min.js"></script>
		<script src="${pageContext.request.contextPath}/recursos/admin/js/bootstrap-tag.min.js"></script>

		<!-- ace scripts -->
		<script src="${pageContext.request.contextPath}/recursos/admin/js/ace-elements.min.js"></script>
		<script src="${pageContext.request.contextPath}/recursos/admin/js/ace.min.js"></script>
		


<!-- libreria alertify-->
<link href="${pageContext.request.contextPath}/recursos/admin/css/alertify.core.css" rel="stylesheet prefetch" />
<link href="${pageContext.request.contextPath}/recursos/admin/css/alertify.default.css" rel="stylesheet prefetch" />
<script src="${pageContext.request.contextPath}/recursos/admin/js/alertify.js"></script>
	
</head>
<body class="no-skin" >

<tiles:insertAttribute name="cabecera" />
<tiles:insertAttribute name="menu" />
<tiles:insertAttribute name="cuerpo" />	
<tiles:insertAttribute name="pie" />			
		
	
	
		<!-- 
		<script type='text/javascript' src="${pageContext.request.contextPath}/recursos/admin/js/ace-extra.min.js"></script>
<script type='text/javascript' src="${pageContext.request.contextPath}/recursos/publico/js/jquery.min.js"></script>


		<script src="${pageContext.request.contextPath}/recursos/admin/js/ace-elements.min.js"></script>
		<script src="${pageContext.request.contextPath}/recursos/admin/js/ace.min.js"></script>
		
		<script src="${pageContext.request.contextPath}/recursos/admin/js/jquery.easypiechart.min.js"></script>
		<script src="${pageContext.request.contextPath}/recursos/admin/js/jquery.sparkline.index.min.js"></script>
		<script src="${pageContext.request.contextPath}/recursos/admin/js/jquery.flot.min.js"></script>
		<script src="${pageContext.request.contextPath}/recursos/admin/js/jquery.flot.pie.min.js"></script>
		<script src="${pageContext.request.contextPath}/recursos/admin/js/jquery.flot.resize.min.js"></script>
-->
		
		

</body>
</html>