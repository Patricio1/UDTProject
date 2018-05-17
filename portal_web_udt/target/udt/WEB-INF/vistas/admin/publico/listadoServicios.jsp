<%@page contentType="text/html;charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt"%>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
<!-- Recursos para tabla -->
<link rel="stylesheet" type="text/css" href="${pageContext.request.contextPath}/recursos/admin/css/dataTables.bootstrap.min.css" />
<script type='text/javascript' src="${pageContext.request.contextPath}/recursos/admin/js/jquery.dataTables.min.js"></script>
<script type='text/javascript' src="${pageContext.request.contextPath}/recursos/admin/js/dataTables.bootstrap.min.js"></script>

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
									Servicios de la Institución
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


<a class="btn btn-success" href="<c:url value="form-servicio"/>"
role="button">Agregar Servicio <span class="fa fa-plus"></span> </a>
				
<div class="table-responsive" style="margin-left: 5px;margin-right: 5px;margin-top:10px" >    
<table id="tabla-servicios" class="table table-striped table-bordered" style="width:100%"">
 <thead style="background:#009688;color: white">
    <tr>             
        <th>Nombre</th>
        <th>Descripción</th>
        <th>Imagen</th>
        <th><i class="fa fa-cog" aria-hidden="true"></i></th>         
    </tr>
  </thead>
    <tbody>   
     	<c:forEach items="${listaServicios}" var="servicio_">
     		<tr>			
				<td><c:out value="${servicio_.nombre}" /></td>
				<td><c:out value="${servicio_.descripcion}" /></td>
				<td>
				<img src="${servicio_.imagen}" width="50" height="50"/>
				</td>
				<td>
				<a href="<c:url value="form-servicio?id=${servicio_.idServicio}"/>" class="btn btn-info btn-xs"><i class="fa fa-pencil-square-o"></i>  Editar&nbsp;&nbsp;&nbsp;</a>
				<a onclick="return confirm('Esta seguro?');" href="<c:url value="eServicio?id=${servicio_.idServicio}"/>" class="btn btn-danger btn-xs"><i class="fa fa-trash"></i> Eliminar</a>
				</td>
			</tr>																	
		</c:forEach>								                  
    </tbody>
  </table>
  <c:if test = "${listaServicios.size() == 0}">
         <p>No se han encontrado datos.<p>
      </c:if>
 </div> 
 
 
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
		$(document).ready(function() {
			$('#tabla-servicios').DataTable({
				responsive: true,
				 "lengthMenu": [[5, 15, 25, -1], [5, 10, 25, "All"]]
				});
			$('#oServicios').attr('class','active');
			$('#oPublico').attr('class','open');		
		} );	
</script>			