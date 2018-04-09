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
													<h4 class="widget-title">Comunicados/Noticias de la Institución</h4>

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

													

<form:form class="form-horizontal" role="form" method="post"  modelAttribute="comunicadoNoticia" enctype="multipart/form-data">								

<div class="row">
<div class="col-md-12">
<div class="form-group">
			<div class="col-sm-6 col-sm-offset-3"> 
				<a href="listado-comunicado-noticia" >
				<i class="fa fa-arrow-left" aria-hidden="true"></i>
				Listado Comunicados y Noticias</a>	
			</div>
</div>
<div class="form-group">
		<label class="col-sm-3 control-label no-padding-right" for="titulo"> Título </label>
		<div class="col-sm-9">
		<form:input path="titulo" placeholder="Escriba el título.." cssClass="form-control" maxlength="120" />
		<form:errors path="titulo" class="control-label" cssStyle="color:red;font-size:13px"/>
		</div>
	</div>
	<div class="form-group">
		<label class="col-sm-3 control-label no-padding-right" for="contenido"> Contenido </label>
		<div class="col-sm-9">
		<form:textarea path="contenido"  cols="30" rows="10" cssClass="form-control" placeholder="Escriba el contenido.."/>
		<form:errors path="contenido" class="control-label" cssStyle="color:red;font-size:13px"/>
		</div>
	</div>
	
	
	<div class="form-group">
		<label class="col-sm-3 control-label no-padding-right" > Tipo </label>
		<div class="col-sm-9">
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
		<label class="col-sm-3 control-label no-padding-right" for="fecha"> Fecha </label>
		<div class="col-sm-9">
		<form:input path="fecha" placeholder="yyyy-mm-dd" cssClass="form-control" maxlength="20" />
		<form:errors path="fecha" class="control-label" cssStyle="color:red;font-size:13px"/>
		</div>
	</div>
	<c:set var="now" value="<%=new java.util.Date()%>" />
	 <p id="factual" hidden><fmt:formatDate pattern="yyyy-MM-dd" value="${now}" /></p> 
					 
	
	
	 								
																
      
	<div class="form-group">
		<label class="col-sm-3 control-label no-padding-right" for="descripcion"> Estado </label>
		<div class="col-sm-9">
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

		<!-- bootstrap-imageupload.
            <div class="imageupload panel panel-default">
                <div class="panel-heading clearfix">
                    <h3 class="panel-title pull-left">Imagen</h3>
                    <div class="btn-group pull-right">
                        <button type="button" class="btn btn-default active">PC</button>
                        <button type="button" class="btn btn-default">URL</button>
                    </div>
                </div>
                <div class="file-tab panel-body">
                    <label class="btn btn-default btn-file">
                        <span>Examinar</span>
                        <!-- The file is stored here.
                        <input type="file" name="image-file">
                    </label>
                    <button type="button" class="btn btn-default">Remover</button>
                </div>
                <div class="url-tab panel-body">
                    <div class="input-group">
                        <input type="text" class="form-control hasclear" placeholder="http://">
                        <div class="input-group-btn">
                            <button type="button" class="btn btn-default">Submit</button>
                        </div>
                    </div>
                    <button type="button" class="btn btn-default">Remover</button>
                    <!-- The URL is stored here. 
                    <input type="hidden" name="image-url" value="https://i.pinimg.com/originals/16/70/19/167019cb170901a670a5312ce5440873.gif">
                </div>
            </div>
		 bootstrap-imageupload. -->

		
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
		    
		
		<input type="file" id="file" name="file"/>
		
		<!-- <input id="file" type="file" name="file"/>-->
		<form:input path="imagen" placeholder="http://" cssClass="form-control" maxlength="150"/>
			
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
$(function() {
    $('#contenido').froalaEditor({
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
    })
  });




$(document).ready(function(){




	
    $('#imagen').hide();
    setImageOption();
   
    if($('#fecha').val().length==0)
    	 $('#fecha').val($('#factual').text());
    
    setRequired();
    initInputFileCustom();

    var imagenOpcion = $("input[name='imgOpcion']:checked").val();
	hideShowImageOption(imagenOpcion);
    /**if(imagenOpcion=='Local')
        {
			$('#file').prop('required',true);
			 $('#imagen').hide();
				$('#file').show();
				$('.ace-file-container').show();
			
        }
    else
        {
    	$('#imagen').prop('required',true);
    	$('#imagen').show();
		$('#file').hide();
		$('.ace-file-container').hide();
        }*/

    $("input[name=imgOpcion]").click(function () {
       //if($(this).prop("checked"))
       var opcionImagen = $(this).val();
       if($(this).prop("checked") && opcionImagen=='Local')
    	   hideShowImageOption(opcionImagen);
       else if($(this).prop("checked") && opcionImagen=='URL')     
       	hideShowImageOption(opcionImagen);
         //   { alert("checked!"); }
        //alert('hi: '+opcionImagen);
    });
    //alert("valor: "+user_cat);
    /**if (!$("input[name='imgOpcion']").is(':checked')) {
    	   alert('Nothing is checked!');
    	}
    file*/
    //var  = $('#imagen').val();
    //$('#logoinst').attr('src',logoinst);

 $('#datePicker')
        .datepicker({
            format: 'mm/dd/yyyy'
        })
        .on('changeDate', function(e) {
            // Revalidate the date field
            
        });

    var $imageupload = $('.imageupload');
    $imageupload.imageupload();

   // var $urlInput = $urlTab.find('input[type="text"]');
    //getImageThumbnailHtml("https://i.pinimg.com/originals/16/70/19/167019cb170901a670a5312ce5440873.gif");



    
});
function setRequired()
{
	$('#titulo').prop('required',true);
	$('#contenido').prop('required',true);
	$('#titulo').prop('required',true);
	$('#tipo1').prop('required',true);
	$('#fecha').prop('required',true);
	$('#estado1').prop('required',true);
	$('#imgOpcion1').prop('required',true);
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
function setImageOption()
{
	$('input[type=radio][name=imgOpcion]').change(function() {
		hideShowImageOption(this.value); 
	});
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


</script>