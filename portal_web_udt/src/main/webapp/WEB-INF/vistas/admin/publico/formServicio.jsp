<%@page contentType="text/html;charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt"%>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>

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
									Servicios
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
													<h4 class="widget-title">Servicios de la Institución</h4>

													<span class="widget-toolbar">													

														<a href="#" data-action="collapse">
															<i class="ace-icon fa fa-chevron-up"></i>
														</a>													
													</span>
												</div>

												<div class="widget-body">
													<div class="widget-main">

													

<form:form class="form-horizontal" role="form" method="post"  modelAttribute="servicio" enctype="multipart/form-data">								

<div class="row">
<div class="col-md-12" style="margin-bottom:-50px">
<div class="form-group">
			<div class="col-sm-6 col-sm-offset-3"> 
				<a href="listado-servicios" >
				<i class="fa fa-arrow-left" aria-hidden="true"></i>
				Listado Servicios</a>	
			</div>
</div>
<div class="form-group">
		<label class="col-sm-3 control-label no-padding-right" for="nombre"> Nombre </label>
		<div class="col-sm-9">
		<form:input path="nombre" placeholder="Escriba el nombre del servicio.." cssClass="form-control" maxlength="90"/>
		<form:errors path="nombre" class="control-label" cssStyle="color:red;font-size:13px"/>
		</div>
	</div>
	<div class="form-group">
		<label class="col-sm-3 control-label no-padding-right" for="descripcion"> Descripción </label>
		<div class="col-sm-9">
		<form:textarea path="descripcion"  cols="30" rows="10" cssClass="form-control" placeholder="Escriba la descripción.."/>
		<form:errors path="descripcion" class="control-label" cssStyle="color:red;font-size:13px"/>
		</div>
	</div>
	<div class="form-group">
		<label class="col-sm-3 control-label no-padding-right" for="imagen"> Imagen </label>
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
		<form:input path="imagen" placeholder="http://" cssClass="form-control" maxlength="150"/>
		</div>
	</div>
	
	<div class="form-group">
		<div class="col-sm-8 col-md-offset-2">
		
		<c:if test="${servicio.imagen!='no-image'}">
			<img id="imgServicio" src="${servicio.imagen}" alt="${servicio.nombre}" width="200" height="200"/> 
		</c:if>
			
		</div>
	</div>
	<form:input path="idServicio" cssStyle="visibility: hidden" />          
        </div>
</div>
										
<div class="clearfix">
<div class="col-md-offset-3 col-md-9">
<p style="color:red;visibility:hidden;" id="me"> <c:out value="${fail}" /></p>
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
$(document).ready(function(){
	$('#oServicios').attr('class','active');
	$('#oPublico').attr('class','open');	
	$('#nombre').prop('required',true);
	$('#descripcion').prop('required',true);
	$('#imgOpcion1').prop('required',true);
    //$('#imagen').hide();
    setImageOption();
    initInputFileCustom();

    var imagen = $('#imagen').val();
    var existeImagen = imageExists(imagen);
    if(existeImagen)
        {
    	 $('#imgServicio').attr('src',imagen);
    	 $('#imgServicio').show();
        }
    else
        {
    	$('#imgServicio').hide();
        }


    var imagenOpcion = $("input[name='imgOpcion']:checked").val();
	hideShowImageOption(imagenOpcion);

	 if($('#ms').text().trim()=='1')
     {
 	mensajeSuccess("Se ha actualizado correctamente");
     }
	 else if($('#ms').text().trim()=='2')
	 {
	 	mensajeSuccess("Se ha registrado correctamente");
	 }
  
    
    //var  = $('#imagen').val();
    //$('#logoinst').attr('src',logoinst);
});
function imageExists(image_url){

    var http = new XMLHttpRequest();

    http.open('HEAD', image_url, false);
    http.send();

    return http.status != 404;
}
function hideShowImageOption(opcionImagen)
{
	 if (opcionImagen == 'URL') {
	    	$('#imagen').show();
			$('#file').hide();
			$('.ace-file-container').hide();
			
			$("#imagen").prop('required',true);
			$("#file").prop('required',false);
	    }
	    else if (opcionImagen == 'Local') {
	    	$('#imagen').hide();
			$('#file').show();
			$('.ace-file-container').show();

			$("#imagen").prop('required',false);
			$("#file").prop('required',true);
	    }
}
function setImageOption()
{
	$('input[type=radio][name=imgOpcion]').change(function() {
		hideShowImageOption(this.value); 
	});
}
function initInputFileCustom()
{
	$('#file').ace_file_input({
		style: 'well',
		btn_choose: 'Drop files here or click to choose',
		btn_change: null,
		no_icon: 'ace-icon fa fa-cloud-upload',
		droppable: true,
		thumbnail: 'small'//large | fit
		,
		preview_error : function(filename, error_code) {
		}
	}).on('change', function(){
	});
		var whitelist_ext, whitelist_mime;
		var btn_choose
		var no_icon
			btn_choose = "Arrastre aquí la imagen o click para seleccionar";
			no_icon = "ace-icon fa fa-picture-o";
			whitelist_ext = ["jpeg", "jpg", "png", "gif" , "bmp"];
			whitelist_mime = ["image/jpg", "image/jpeg", "image/png", "image/gif", "image/bmp"];		
		var file_input = $('#file');
		file_input
		.ace_file_input('update_settings',
		{
			'btn_choose': btn_choose,
			'no_icon': no_icon,
			'allowExt': whitelist_ext,
			'allowMime': whitelist_mime
		})
		file_input.ace_file_input('reset_input');
		file_input
		.off('file.error.ace')
		.on('file.error.ace', function(e, info) {
		});
}
function mensajeSuccess(mensaje) {
    alertify.success(mensaje);
}
function mensajeError(mensaje) {
    alertify.error(mensaje);
}
</script>