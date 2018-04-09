<%@page contentType="text/html;charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt"%>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
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
							</h1>
						</div><!-- /.page-header -->

						<div class="row">
							<div class="col-xs-12">
								<!-- PAGE CONTENT BEGINS -->
							
								<div class="row">

								<div class="col-sm-10">
											<div class="widget-box">
												<div class="widget-header">
													<h4 class="widget-title">Subir recursos del portal web</h4>

													<span class="widget-toolbar">													

														<a href="#" data-action="collapse">
															<i class="ace-icon fa fa-chevron-up"></i>
														</a>													
													</span>
												</div>

												<div class="widget-body">
													<div class="widget-main">

													

<form:form class="form-horizontal" role="form" method="post" modelAttribute="recurso" enctype="multipart/form-data">								

<div class="row">
	

<div class="col-md-12">
	<div class="form-group">
			<div class="col-sm-6 col-sm-offset-3"> 
				<a href="listado-recursos" >
				<i class="fa fa-arrow-left" aria-hidden="true"></i>
				Listado Recursos</a>	
			</div>
	</div>
	<div class="form-group">
			<label class="col-sm-3 control-label no-padding-right" for="contenido"> Archivo a subir </label>
			<div class="col-sm-9">
			<form:input path="url" placeholder="Escriba la url del recurso.." cssClass="form-control" />
			</div>
			
			
			
	</div>
	<div class="form-group">
			
			
		<label class="col-sm-3 control-label no-padding-right" for="contenido"> Nombre </label>
		<div class="col-sm-9">
		<form:input path="nombre" placeholder="Escriba el nombre para el recurso.." cssClass="form-control" maxlength="120" />
		<form:errors path="nombre" class="control-label" cssStyle="color:red;font-size:13px"/>
		</div>
	</div>
	<div class="form-group">
		<label class="col-sm-3 control-label no-padding-right" for="contenido"> Descripción </label>
		<div class="col-sm-9">
		<form:input path="descripcion" placeholder="Escriba una descripción para el recurso.." cssClass="form-control" maxlength="120" />
		<form:errors path="descripcion" class="control-label" cssStyle="color:red;font-size:13px"/>
		</div>
	</div>
	<div class="form-group">
		<label class="col-sm-3 control-label no-padding-right" > Tipo </label>
		<div class="col-sm-9">
			<div class="radio">
				<label>
				 <form:radiobutton path="tipo"  value="I" cssClass="ace"/>													
					<span class="lbl"> Imagen</span>
				</label>
			</div>
			<div class="radio">
				<label>
				 <form:radiobutton path="tipo"  value="S" cssClass="ace"/>			
					<span class="lbl"> Slider</span>
				</label>
		    </div>
		    <div class="radio">
				<label>
				 <form:radiobutton path="tipo"  value="A" cssClass="ace"/>			
					<span class="lbl"> Archivo</span>
				</label>
		    </div>
		    <div class="radio">
				<label>
				 <form:radiobutton path="tipo"  value="M" cssClass="ace"/>			
					<span class="lbl"> Multimedia(audio-video)</span>
				</label>
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
$(document).ready(function(){
	  //$("#nombre").prop('required',true);
	  //$("#descripcion").prop('required',true);
    //$('#imagen').hide();
    //setImageOption();

    /**var imagen = $('#imagen').val();
    var existeImagen = imageExists(imagen);
    if(existeImagen)
        {
    	 $('#imgServicio').attr('src',imagen);
        }*/
    //var  = $('#imagen').val();
    //$('#logoinst').attr('src',logoinst);
     initInputFileCustom();
     //setRequired();
});
function imageExists(image_url){

    var http = new XMLHttpRequest();

    http.open('HEAD', image_url, false);
    http.send();

    return http.status != 404;
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
			//name of the file that failed
			//error_code values
			//1 = 'FILE_LOAD_FAILED',
			//2 = 'IMAGE_LOAD_FAILED',
			//3 = 'THUMBNAIL_FAILED'
			//alert(error_code);
		}

	}).on('change', function(){
		//console.log($(this).data('ace_input_files'));
		//console.log($(this).data('ace_input_method'));
	});
}
function setRequired()
{
	$('#nombre').prop('required',true);
	$('#tipo1').prop('required',true);
}
</script>