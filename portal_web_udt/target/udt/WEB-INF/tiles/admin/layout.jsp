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

<link rel='stylesheet'
href="${pageContext.request.contextPath}/recursos/admin/css/ace.min.css" class="ace-main-stylesheet" id="main-ace-style" />
<link rel='stylesheet'  
href="${pageContext.request.contextPath}/recursos/admin/css/fonts.googleapis.com.css" type='text/css' media='all' />
<link rel='stylesheet' id='colormag-fontawesome-css'  href="${pageContext.request.contextPath}/recursos/publico/css/font-awesome.css" type='text/css' media='all' />
<link rel="stylesheet" href="${pageContext.request.contextPath}/recursos/admin/css/bootstrap-datepicker3.min.css"/>
<link rel="stylesheet" href="${pageContext.request.contextPath}/recursos/admin/css/ace-skins.min.css" />
<link rel="stylesheet" href="${pageContext.request.contextPath}/recursos/admin/css/ace-rtl.min.css" />
		
<script type='text/javascript' src="${pageContext.request.contextPath}/recursos/admin/js/ace-extra.min.js"></script>
<script type='text/javascript' src="${pageContext.request.contextPath}/recursos/publico/js/jquery.min.js"></script>

<!-- ace scripts -->
		<script src="${pageContext.request.contextPath}/recursos/admin/js/ace-elements.min.js"></script>
		<script src="${pageContext.request.contextPath}/recursos/admin/js/ace.min.js"></script>
		
</head>
<body class="no-skin" >

<tiles:insertAttribute name="cabecera" />
<tiles:insertAttribute name="menu" />
<tiles:insertAttribute name="cuerpo" />	
<tiles:insertAttribute name="pie" />			
		

		<script type="text/javascript">
			if('ontouchstart' in document.documentElement) document.write("<script src='${pageContext.request.contextPath}/recursos/admin/js/jquery.mobile.custom.min.js'>"+"<"+"/script>");
		</script>
		
<script type='text/javascript' src='https://maxcdn.bootstrapcdn.com/bootstrap/3.3.7/js/bootstrap.min.js'></script>
<script type='text/javascript' src='${pageContext.request.contextPath}/recursos/admin/js/bootstrap-datepicker.min.js'></script>

		<script src="${pageContext.request.contextPath}/recursos/admin/js/jquery-ui.custom.min.js"></script>
		<script src="${pageContext.request.contextPath}/recursos/admin/js/jquery.ui.touch-punch.min.js"></script>
		<script src="${pageContext.request.contextPath}/recursos/admin/js/jquery.easypiechart.min.js"></script>
		<script src="${pageContext.request.contextPath}/recursos/admin/js/jquery.sparkline.index.min.js"></script>
		<script src="${pageContext.request.contextPath}/recursos/admin/js/jquery.flot.min.js"></script>
		<script src="${pageContext.request.contextPath}/recursos/admin/js/jquery.flot.pie.min.js"></script>
		<script src="${pageContext.request.contextPath}/recursos/admin/js/jquery.flot.resize.min.js"></script>

		
		

</body>
</html>