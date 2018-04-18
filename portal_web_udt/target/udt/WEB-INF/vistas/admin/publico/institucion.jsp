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

						<div class="nav-search" id="nav-search">
							<form class="form-search">
								<span class="input-icon">
									<input type="text" placeholder="Buscar ..." class="nav-search-input" id="nav-search-input" autocomplete="off" />
									<i class="ace-icon fa fa-search nav-search-icon"></i>
								</span>
							</form>
						</div><!-- /.nav-search -->
					</div>

					<div class="page-content">


						<div class="page-header">
							<h1>
								Panel de Administración
								<small>
									<i class="ace-icon fa fa-angle-double-right"></i>
									Institución
								</small>
							</h1>
						</div><!-- /.page-header -->

						<div class="row">
							<div class="col-xs-12">
								<!-- PAGE CONTENT BEGINS -->
							
								<div class="row">

								<div class="col-sm-10">
											<div class="widget-box">
												<div class="widget-header">
													<h4 class="widget-title">Datos de la Institución</h4>

													<span class="widget-toolbar">																						
														<a href="#" data-action="collapse">
															<i class="ace-icon fa fa-chevron-up"></i>
														</a>													
													</span>
												</div>

												<div class="widget-body">
													<div class="widget-main">

													

<form:form class="form-horizontal" role="form" method="post"  modelAttribute="institucion_info" enctype="multipart/form-data">								

<div class="row">
<div class="col-md-12">
           <div class="panel with-nav-tabs panel-info">
                <div class="panel-heading">
                        <ul class="nav nav-tabs">
                            <li class="active"><a href="#tab1info" data-toggle="tab"><span class="fa fa-home"></span> Básico</a></li>
                            <li><a href="#tab2info" data-toggle="tab"><span class="fa fa-phone"></span> De contacto y ubicación</a></li>
                            <li><a href="#tab3info" data-toggle="tab"><span class="fa fa-slideshare"></span> Estratégico</a></li>
                 
                        </ul>
                </div>
                <div class="panel-body">
                    <div class="tab-content">
                        <div class="tab-pane fade in active" id="tab1info">
	
	<div class="form-group">
		<label class="col-sm-3 control-label no-padding-right" for="nombre"> Nombre </label>
		<div class="col-sm-9">
		<form:input path="nombre" placeholder="Escriba el nombre de la institución.." cssClass="form-control" maxlength="120" />
		<form:errors path="nombre" class="control-label" cssStyle="color:red;font-size:13px"/>
		</div>
	</div>
	<div class="form-group">
		<label class="col-sm-3 control-label no-padding-right" for="abreviatura"> Abreviatura </label>
		<div class="col-sm-9">
		<form:input path="abreviatura" placeholder="Escriba la abreviatura.." cssClass="form-control" maxlength="20" />
		</div>
	</div>
	<div class="form-group">
		<label class="col-sm-3 control-label no-padding-right" for="slogan"> Slogan </label>
		<div class="col-sm-9">
		<form:input path="slogan" placeholder="Escriba el slogan  institucional.." cssClass="form-control" maxlength="250" />
		</div>
	</div>
	<div class="form-group">
		<label class="col-sm-3 control-label no-padding-right" for="horarioAtencion"> Horario de atención </label>
		<div class="col-sm-9">
		<form:input path="horarioAtencion" placeholder="Escriba el horario de atención.." cssClass="form-control" maxlength="110"/>
		<form:errors path="horarioAtencion" class="control-label" cssStyle="color:red;font-size:13px"/>
		</div>
	</div>
	<div class="form-group">
		<label class="col-sm-3 control-label no-padding-right" for="logo"> Logo Institucional </label>
		<div class="col-sm-9">
			<div class="radio">
				<label>
				 <form:radiobutton path="imgOpcion"  value="URL" cssClass="ace"/>													
					<span class="lbl"> URL</span>
				</label>
			</div>
			<div class="radio">
				<label>
				 <form:radiobutton path="imgOpcion"  value="Local" cssClass="ace"/>			
					<span class="lbl"> Local</span>
				</label>
		    </div>
	
		<form:errors path="imgOpcion" class="control-label" cssStyle="color:red;font-size:13px;margin-left:9px"/>
		<input id="file" type="file" name="file"/>
		<form:input path="logo" placeholder="Escriba la url de la imagen.." cssClass="form-control" maxlength="150"/>
		</div>
	</div>
	
	<div class="form-group">
		<div class="col-sm-8 col-md-offset-2">
		<c:if test="${institucion_info.logo!='no-image'}"></c:if>
			<img id="logoinst" src="" width="200" height="200"/> 
		</div>
	</div>
	<form:input path="id" cssStyle="visibility: hidden" />
</div>

<div class="tab-pane fade" id="tab2info">
<div class="form-group">
	<label class="col-sm-3 control-label no-padding-right" for="telefono"> Teléfono 
	<a href="javascript:void();" data-toggle="tooltip" title="Escriba los telefónos separados por comas. Ejemplo: 0986385023,032748878"><li class="fa fa-info-circle" style="font-size:16px"></li></a>
	</label>
	<div class="col-sm-9">
	<form:input path="telefono" placeholder="Escriba el teléfono" cssClass="form-control" maxlength="80" />
	<form:errors path="telefono" class="control-label" cssStyle="color:red;font-size:13px"/>
	</div>
</div>
<div class="form-group">
	<label class="col-sm-3 control-label no-padding-right" for="correoAdmin"> Correo </label>
	<div class="col-sm-9">
	<form:input path="correoAdmin" placeholder="Escriba el correo del administrador.." cssClass="form-control" maxlength="110"/>
	<form:errors path="correoAdmin" class="control-label" cssStyle="color:red;font-size:13px"/>
	</div>
</div>
<div class="form-group">
	<label class="col-sm-3 control-label no-padding-right" for="direccion"> Dirección 
	<a href="javascript:void();" data-toggle="tooltip" title="Escriba la Dirección de las Instalaciones de la Institución, calle, avenida, sector, etc."><li class="fa fa-info-circle" style="font-size:16px"></li></a>
	</label>
	<div class="col-sm-9">
	<form:input path="direccion" placeholder="Escriba la dirección.." cssClass="form-control" maxlength="150"/>
	<form:errors path="direccion" class="control-label" cssStyle="color:red;font-size:13px"/>
	</div>
</div>
<div class="form-group">
	<label class="col-sm-3 control-label no-padding-right">Ubicación 
	<a href="javascript:void();" data-toggle="tooltip" title="Escriba la ubicación en coordenadas de las Instalaciones de la Institución; si no conoce busque en Google Maps"><li class="fa fa-info-circle" style="font-size:16px"></li></a>
	</label>
	<div class="col-sm-9">
	<span class="input-icon">
	<form:input path="lat" placeholder="Latitud" maxlength="13"/>
	<i class="ace-icon fa fa-map-marker blue"></i>	
	</span>
	<form:errors path="lat" class="control-label" cssStyle="color:red;font-size:13px"/>
	<span class="input-icon input-icon-right">
	<form:input path="lon" placeholder="Longitud" maxlength="13"/>
	<i class="ace-icon fa fa-map-marker green"></i>	
	</span>
	<form:errors path="lon" class="control-label" cssStyle="color:red;font-size:13px"/>
	
	</div>
</div>
</div>

<div class="tab-pane fade" id="tab3info">
<div class="form-group">
	<label class="col-sm-2 control-label no-padding-right" for="mision"> Misión </label>
	<div class="col-sm-10">
	<form:textarea path="mision"  cols="30" rows="10" cssClass="form-control" placeholder="Escriba la misión.." maxlength="950"/>
	<form:errors path="mision" class="control-label" cssStyle="color:red;font-size:13px"/>
	</div>
</div>
														
<div class="form-group">
	<label class="col-sm-2 control-label no-padding-right" for="vision"> Visión </label>
	<div class="col-sm-10">
	<form:textarea path="vision"  cols="30" rows="10" cssClass="form-control" placeholder="Escriba la visión.." maxlength="950"/>
	<form:errors path="vision" class="control-label" cssStyle="color:red;font-size:13px"/>
	</div>
</div>
														
<div class="form-group">
	<label class="col-sm-2 control-label no-padding-right" for="valores"> Valores Institucionales </label>
	<div class="col-sm-10">
	<form:textarea path="valores"  cols="30" rows="10" cssClass="form-control" placeholder="Escriba los valores institucionales.."/>
	<form:errors path="valores" class="control-label" cssStyle="color:red;font-size:13px"/>
	</div>
</div>
														
<div class="form-group">
	<label class="col-sm-2 control-label no-padding-right" for="acercaDe"> Acerca de </label>
	<div class="col-sm-10">
	<form:textarea path="acercaDe"  cols="30" rows="10" cssClass="form-control" placeholder="Escriba acerca de la institución.."/>
	<form:errors path="acercaDe" class="control-label" cssStyle="color:red;font-size:13px"/>
	</div>
</div>

</div>
  <!--                       <div class="tab-pane fade" id="tab4info">Info 4</div>
                        <div class="tab-pane fade" id="tab5info">Info 5</div>-->
                    </div>
                </div>
            </div>
        </div>
</div>
										
<div class="clearfix">
<div class="col-md-offset-3 col-md-9">
<p style="color:red"> <c:out value="${fail}" /></p>
<p style="color:#428bca"> <c:out value="${ok}" /></p>
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
  function iniciarFroalaEditor(idTextArea)
  {
		    $('#'+idTextArea).froalaEditor({
		      // Set the file upload URL.
		      toolbarButtons: ['fullscreen', 'bold', 'italic', 'underline', 'strikeThrough', 'subscript', 'superscript', '|', 'fontFamily', 'fontSize', 'color', 'inlineStyle', 'paragraphStyle', '|', 'paragraphFormat', 'align', 'formatOL', 'formatUL', 'outdent', 'indent', 'quote', '-', 'insertLink', 'insertImage', 'insertVideo', 'insertFile', 'insertTable', '|', 'emoticons', 'specialCharacters', 'insertHR', 'selectAll', 'clearFormatting', '|', 'print', 'help', 'html', '|', 'undo', 'redo'],
		      fileUploadURL: 'http://localhost:8080/udt/upload_file',
		      imageUploadURL:'http://localhost:8080/udt/upload_image',
		      videoUploadURL:'http://localhost:8080/udt/upload_video',
		      fileUploadParams: {
		        id: 'my_editor'
		      },
		      imageManagerLoadURL: 'http://localhost:8080/udt/load_images',
		      imageManagerDeleteURL: "http://localhost:8080/udt/delete_image",
		      imageManagerDeleteMethod: "POST"
		    });	 
  }


$(document).ready(function(){
    $('[data-toggle="tooltip"]').tooltip();
    iniciarFroalaEditor('vision');
    iniciarFroalaEditor('mision');
    iniciarFroalaEditor('valores');
    iniciarFroalaEditor('acercaDe');

	$('#oInstitucion').attr('class','active');
	$('#oPublico').attr('class','open');
    
    setImageOption();
    initInputFileCustom();
    setRequired();
    var logoinst = $('#logo').val();
    if(logoinst.length>0)
		{
    	hideShowImageOption('URL');
    	$('#imgOpcion1').attr('checked',true);
    	}
    else {
    	hideShowImageOption('Local');
    	$('#imgOpcion2').attr('checked',true);
        }
    var existeImagen = imageExists(logoinst);
    console.log("EXISTE IMAGEN: "+existeImagen);
    if(existeImagen)
        {
    	$('#logoinst').attr('src',logoinst);
    	$('#logoinst').show();  
        }
    else
		{
    	$('#logoinst').hide();
    	}
   
   // console.log("existe "+imageExists(logoinst));
   
    $('#lon').keypress(function (event) {
        return isNumber(event, this)
    });
    $('#lat').keypress(function (event) {
        return isNumber(event, this)
    });
});

function setImageOption()
{
	$('input[type=radio][name=imgOpcion]').change(function() {
		hideShowImageOption(this.value); 
	});
}
function hideShowImageOption(opcionImagen)
{
	 if (opcionImagen == 'URL') {
	    	$('#logo').show();
			$('#file').hide();
			$('.ace-file-container').hide();
			
			$("#logo").prop('required',true);
			$("#file").prop('required',false);
	    }
	    else if (opcionImagen == 'Local') {
	    	$('#logo').hide();
			$('#file').show();
			$('.ace-file-container').show();

			$("#logo").prop('required',false);
			$("#file").prop('required',true);
	    }
}
function isNumber(evt, element) {

    var charCode = (evt.which) ? evt.which : event.keyCode

    if (
        (charCode != 45 || $(element).val().indexOf('-') != -1) &&      // “-” CHECK MINUS, AND ONLY ONE.
        (charCode != 46 || $(element).val().indexOf('.') != -1) &&      // “.” CHECK DOT, AND ONLY ONE.
        (charCode < 48 || charCode > 57))
        return false;

    return true;
} 
function imageExists(image_url){

    var http = new XMLHttpRequest();

    http.open('HEAD', image_url, false);
    http.send();

    return http.status != 404;
}
function setRequired()
{
	$("#nombre").prop('required',true);
	$("#abreviatura").prop('required',true);
	$("#horarioAtencion").prop('required',true);
	$("#telefono").prop('required',true);
	$("#correoAdmin").prop('required',true);	
	$("#direccion").prop('required',true);	
	$("#lat").prop('required',true);	
	$("#lon").prop('required',true);	
	$("#mision").prop('required',true);
	$("#vision").prop('required',true);	
	$("#valores").prop('required',true);	
	$("#acercaDe").prop('required',true);
}
function initInputFileCustom()
{
	$('#file').ace_file_input({
		style: 'well',
		btn_choose: 'Arrastre aquí la imagen o click para seleccionar',
		btn_change: null,
		no_icon: 'ace-icon fa fa-cloud-upload',
		droppable: true,
		thumbnail: 'small'//large | fit
		,
		preview_error : function(filename, error_code) {		
		}

	}).on('change', function(){
	});
}
</script>