<%@page contentType="text/html;charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt"%>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>

 <div id="main" class="clearfix">
  <div style="margin-left:20px;">
    <div id="bc1" class="myBreadcrumb">
         <div><i class="fa fa-home fa-2x"></i></div>
        <div>Servicios al transportista</div>
    	<div>Consulta de multas</div>
    </div>
</div>
    <div class="inner-wrap clearfix">
        <div class="front-page-top-section clearfix" style="margin-bottom: 40px"></div>
        <div class="main-content-section clearfix">
            <div id="primary">
                <div id="content" class="clearfix">
                         <section id="colormag_featured_posts_widget-3" class="widget widget_featured_posts widget_featured_meta clearfix">      <h3 class="widget-title" style="border-bottom-color:#009688;"><span style="background-color:#009688;">MULTAS TRANSPORTISTAS UDT</span></h3>                                                                                                                            
  <div class="widget widget_featured_posts widget_featured_posts_vertical widget_featured_meta clearfix">
               <div class="single-article clearfix">    
 <form:form  method="post" class="form-horizontal" role="form" style="margin-top:22px">  

  <p style="padding-left:20px;padding-bottom:10px">A través de este formulario usted podrá consultar las infracciones que han sido emitidas a una unidad de transporte por el incumplimiento de las normativas internas del terminal terrestre.</p>
   <div class="form-group">
    <label for="ejemplo_email_3" class="col-lg-2 control-label">Placa</label>
    <div class="col-lg-9">
        <div class="input-group">
            <div class="input-group-addon">
              <i class="fa fa-bus"></i> 
            </div>
            <input class="form-control" type="text"  name="placa" id="placa" style="background-color: white" required 
                   placeholder="Escriba la placa de la unidad de transporte.." maxlength="20"/>
                 
        </div> 
              
    </div>
  </div>
  <div class="form-group">   
    <div class="col-md-6 col-md-offset-2">
        <div class="input-group">           
           <div style="margin-bottom: 10px;margin-top: 10px" class="g-recaptcha" 
           data-sitekey="6LfQETMUAAAAALtyOk66Qp4ccagIgKnsaeGfgB-C"></div>							
        </div>
         <p style="color:red"> <c:out value="${error}" /></p> 
    </div>
  </div>    
   <div class="form-group">
     <div class="col-lg-4">&nbsp;</div>
    <div class="col-lg-4">        
 <input type="submit" value="Consultar" />
    </div>
      <div class="col-lg-4">&nbsp;</div>
  </div>
     </form:form>    
    <div class="table-responsive" style="margin-left: 5px;margin-right: 5px" >    
<table id="responsive-example-table" class="table tablamultas" cellspacing="0">
 <thead style="background:#009688;color: white">
    <tr>     
        <th>#</th>        
        <th>Fecha</th>
        <th>Descripción</th>
        <th>Valor</th>             
    </tr>
  </thead>
    <tbody>   
    <c:set var="contador" value="1" scope="page" />
     	<c:forEach items="${multas}" var="multa">
     		<tr>
				<td style="text-align:center"><c:out value="${contador}" /></td>
				<td><c:out value="${multa.fecha}" /></td>
				<td style="width:70%"><c:out value="${multa.detalle}" /></td>
				<td><c:out value="$ ${multa.valor}  " /></td>
				<c:set var="contador" value="${contador + 1}" scope="page"/>
			</tr>																	
		</c:forEach>								                  
    </tbody>
  </table>
  <c:if test = "${multas.size() == 0}">
         <p>No se han encontrado datos.<p>
      </c:if>
 </div>  
   </div>
               </div>              
      </section>                                                         
                    <div class="clearfix"></div>                        
                </div>
          </div>
      