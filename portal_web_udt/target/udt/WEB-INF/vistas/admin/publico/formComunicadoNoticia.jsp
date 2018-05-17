<%@page contentType="text/html;charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt"%>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
<!-- Inicio recursos froala editor -->
<link rel="stylesheet" type="text/css" href="${pageContext.request.contextPath}/recursos/admin/css/codemirror.min.css" />
<script type='text/javascript' src="${pageContext.request.contextPath}/recursos/admin/js/codemirror.min.js"></script>
<script type='text/javascript' src="${pageContext.request.contextPath}/recursos/admin/js/xml.min.js"></script>
<script type='text/javascript' src="${pageContext.request.contextPath}/recursos/admin/js/froala_editor.pkgd.min.js"></script>

<link rel="stylesheet" type="text/css" href="${pageContext.request.contextPath}/recursos/admin/css/froala_editor.pkgd.min.css" />
<link rel="stylesheet" type="text/css" href="${pageContext.request.contextPath}/recursos/admin/css/froala_style.min.css" />

<!-- Fin recursos froala editor -->
<link rel="stylesheet" type="text/css" href="${pageContext.request.contextPath}/recursos/admin/css/bootstrap-imageupload.css" />
<script type='text/javascript' src="${pageContext.request.contextPath}/recursos/admin/js/bootstrap-imageupload.js"></script>

<div class="sidebar-toggle sidebar-collapse" id="sidebar-collapse">
					<i id="sidebar-toggle-icon" class="ace-icon fa fa-angle-double-left ace-save-state" data-icon1="ace-icon fa fa-angle-double-left" data-icon2="ace-icon fa fa-angle-double-right"></i>
				</div>
			</div>

			<div class="main-content">
				<div class="main-content-inner">
					<div class="breadcrumbs ace-save-state" id="breadcrumbs">
						<ul class="breadcrumb">
							<li>
								<i class="ace-icon fa fa-home home-icon"></i>
								<a href="#">Inicio</a>
							</li>
							<li class="active">Panel de Administración</li>
						</ul><!-- /.breadcrumb -->					
					</div>

					<div class="page-content">


						<div class="page-header">
							<h1>
								Panel de Administración
								<small>
									<i class="ace-icon fa fa-angle-double-right"></i>
									Comunicados y Noticias
								</small>
							</h1>
						</div><!-- /.page-header -->

						<div class="row">
							<div class="col-xs-12">
								<!-- PAGE CONTENT BEGINS -->
							
								<div class="row">

								<div class="col-sm-12">
											<div class="widget-box">
												<div class="widget-header">
													<h4 class="widget-title">Comunicados y Noticias de la Institución</h4>

													<span class="widget-toolbar">
														<!--<a href="#" data-action="settings">
															<i class="ace-icon fa fa-cog"></i>
														</a>-->

														<!--<a href="#" data-action="reload">
															<i class="ace-icon fa fa-refresh"></i>
														</a>-->

														<a href="#" data-action="collapse">
															<i class="ace-icon fa fa-chevron-up"></i>
														</a>

														<!--<a href="#" data-action="close">
															<i class="ace-icon fa fa-times"></i>
														</a>-->
													</span>
												</div>

												<div class="widget-body">
													<div class="widget-main">

													

<form:form class="form-horizontal" role="form" method="post"  modelAttribute="comunicadoNoticia">								

<div class="row">
<div class="col-md-12" style="margin-bottom:-70px">
<div class="form-group">
			<div class="col-sm-6 col-sm-offset-3"> 
				<a href="listado-comunicado-noticia" >
				<i class="fa fa-arrow-left" aria-hidden="true"></i>
				Listado Comunicados y Noticias</a>	
			</div>
</div>
<div class="form-group">
		<label class="col-sm-1 control-label no-padding-right" for="titulo"> Título </label>
		<div class="col-sm-11">
		<form:input path="titulo" placeholder="Escriba el título.." cssClass="form-control" maxlength="120" />
		<form:errors path="titulo" class="control-label" cssStyle="color:red;font-size:13px"/>
		</div>
	</div>
	<div class="form-group">
		<label class="col-sm-1 control-label no-padding-right" for="contenido"> Contenido </label>
		<div class="col-sm-11">
		<form:textarea path="contenido"  cols="30" rows="10" cssClass="form-control" placeholder="Escriba el contenido.."/>
		<form:errors path="contenido" class="control-label" cssStyle="color:red;font-size:13px"/>
		</div>
	</div>
	
	
	<div class="form-group">
		<label class="col-sm-1 control-label no-padding-right" > Tipo </label>
		<div class="col-sm-11">
			<div class="radio">
				<label>
				 <form:radiobutton path="tipo"  value="C" cssClass="ace"/>													
					<span class="lbl"> Comunicado</span>
				</label>
			</div>
			<div class="radio">
				<label>
				 <form:radiobutton path="tipo"  value="N" cssClass="ace"/>			
					<span class="lbl"> Noticia</span>
				</label>
		    </div>	
		</div>
	</div>
		
	<div class="form-group">
		<label class="col-sm-1 control-label no-padding-right" for="fecha"> Fecha </label>
		<div class="col-sm-11">
		<form:input path="fecha" placeholder="yyyy-mm-dd" cssClass="form-control" maxlength="20" />
		<form:errors path="fecha" class="control-label" cssStyle="color:red;font-size:13px"/>
		</div>
	</div>
	<c:set var="now" value="<%=new java.util.Date()%>" />
	 <p id="factual" hidden><fmt:formatDate pattern="yyyy-MM-dd" value="${now}" /></p> 
					 
	
	
	 								
																
      
	<div class="form-group">
		<label class="col-sm-1 control-label no-padding-right" for="descripcion"> Estado </label>
		<div class="col-sm-11">
			<div class="radio">
				<label>
				 <form:radiobutton path="estado"  value="1" cssClass="ace"/>													
					<span class="lbl"> Publicado</span>
				</label>
			</div>
			<div class="radio">
				<label>
				 <form:radiobutton path="estado"  value="0" cssClass="ace"/>			
					<span class="lbl"> No Publicado</span>
				</label>
		    </div>

	

		
		</div>
	</div>
	
	
	<div class="form-group">
		<div class="col-sm-8 col-md-offset-2">
			<img id="imgcn" src=""/> 
		</div>
	</div>
	<form:input path="id" cssStyle="visibility: hidden" />          
        </div>
</div>


										
<div class="clearfix">
<div class="col-md-offset-3 col-md-9">
<p style="color:#428bca;visibility:hidden;" id="ms"> <c:out value="${ok}" /></p>
<button class="btn btn-info" type="submit">
<i class="ace-icon fa fa-check bigger-110"></i>
Guardar
</button>
&nbsp; &nbsp; &nbsp;																
</div>
</div>

</form:form>

 
 
<div class="space space-8"></div>														
</div>
</div>
</div>
</div>
									

									


								</div><!-- /.row -->

								<!-- PAGE CONTENT ENDS -->
							</div><!-- /.col -->
						</div><!-- /.row -->
						
						
					</div><!-- /.page-content -->
				</div>
			</div><!-- /.main-content -->
	
<script>
$(function() {
    $('#contenido').froalaEditor({
      // Set the file upload URL.
      toolbarButtons: ['fullscreen', 'bold', 'italic', 'underline', 'strikeThrough', 'subscript', 'superscript', '|', 'fontFamily', 'fontSize', 'color', 'inlineStyle', 'paragraphStyle', '|', 'paragraphFormat', 'align', 'formatOL', 'formatUL', 'outdent', 'indent', 'quote', '-', 'insertLink', 'insertImage', 'insertVideo', 'insertFile', 'insertTable', '|', 'emoticons', 'specialCharacters', 'insertHR', 'selectAll', 'clearFormatting', '|', 'print', 'help', 'html', '|', 'undo', 'redo'],
      fileUploadURL: '/udt/upload_file',
      imageUploadURL:'/udt/upload_image',
      videoUploadURL:'/udt/upload_video',
      fileUploadParams: {
        id: 'my_editor'
      },
      imageManagerLoadURL: '/udt/load_images',
      imageManagerDeleteURL: "/udt/delete_image",
      imageManagerDeleteMethod: "POST"
      
    })
  });




$(document).ready(function(){
	$('#oCN').attr('class','active');
	$('#oPublico').attr('class','open');
   
    if($('#fecha').val().length==0)
    	 $('#fecha').val($('#factual').text());
    
    setRequired();

    $("div.fr-wrapper a").css( "visibility", "hidden" );

 $('#datePicker')
        .datepicker({
            format: 'mm/dd/yyyy'
        })
        .on('changeDate', function(e) {
            // Revalidate the date field
            
        });

    if($('#ms').text().trim().indexOf("1|") >= 0)
        {
    	mensajeSuccess($('#ms').text());
        }
    else if($('#ms').text().trim().indexOf("2|") >= 0)
    {
    	mensajeError($('#ms').text());
    }
});
function mensajeSuccess(mensaje) {
    alertify.success(mensaje);
}
function mensajeError(mensaje) {
    alertify.error(mensaje);
}
function getUrlParameter(sParam) {
    var sPageURL = decodeURIComponent(window.location.search.substring(1)),
        sURLVariables = sPageURL.split('&'),
        sParameterName,
        i;

    for (i = 0; i < sURLVariables.length; i++) {
        sParameterName = sURLVariables[i].split('=');

        if (sParameterName[0] === sParam) {
            return sParameterName[1] === undefined ? true : sParameterName[1];
        }
    }
};
function setRequired()
{
	$('#titulo').prop('required',true);
	$('#contenido').prop('required',true);
	$('#titulo').prop('required',true);
	$('#tipo1').prop('required',true);
	$('#fecha').prop('required',true);
	$('#estado1').prop('required',true);
}


</script>