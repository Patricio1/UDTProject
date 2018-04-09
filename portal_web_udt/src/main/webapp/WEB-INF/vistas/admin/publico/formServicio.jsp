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
									Visión General
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
<div class="col-md-12">
<div class="form-group">
		<label class="col-sm-3 control-label no-padding-right" for="nombre"> Nombre </label>
		<div class="col-sm-9">
		<form:input path="nombre" placeholder="Escriba el nombre de la institución.." cssClass="form-control" maxlength="90"/>
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
		<form:radiobutton path="imgOpcion"  value="URL"/>URL
		<form:radiobutton path="imgOpcion" value="Local"/>Local
		<form:errors path="imgOpcion" class="control-label" cssStyle="color:red;font-size:13px;margin-left:9px"/>
		<input id="file" type="file" name="file"/>
		<form:input path="imagen" placeholder="Escriba la url de la imagen.." cssClass="form-control" maxlength="150"/>
		</div>
	</div>
	
	<div class="form-group">
		<div class="col-sm-8 col-md-offset-2">
		
		<c:if test="${servicio.imagen!='no-image'}">
			<img id="imgServicio" src="" alt="${servicio.nombre}" width="400" height="400"/> 
		</c:if>
			
		</div>
	</div>
	<form:input path="idServicio" cssStyle="visibility: hidden" />          
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
    $('#imagen').hide();
    setImageOption();

    var imagen = $('#imagen').val();
    var existeImagen = imageExists(imagen);
    if(existeImagen)
        {
    	 $('#imgServicio').attr('src',imagen);
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

function setImageOption()
{
	$('input[type=radio][name=imgOpcion]').change(function() {
	    if (this.value == 'URL') {
	    	$('#imagen').show();
			$('#file').hide();
			
			$("#imagen").prop('required',true);
			$("#file").prop('required',false);
	    }
	    else if (this.value == 'Local') {
	    	$('#imagen').hide();
			$('#file').show();

			$("#imagen").prop('required',false);
			$("#file").prop('required',true);
	    }
	  
	});
}
</script>