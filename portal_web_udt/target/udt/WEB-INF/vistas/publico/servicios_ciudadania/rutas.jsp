<%@page contentType="text/html;charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt"%>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
 <div id="main" class="clearfix">
    <div class="inner-wrap clearfix">
        <div class="front-page-top-section clearfix" style="margin-bottom: 40px"></div>
        <div class="main-content-section clearfix">
            <div id="primary">
                <div id="content" class="clearfix">
                           <section id="colormag_featured_posts_widget-3" class="widget widget_featured_posts widget_featured_meta clearfix">      <h3 class="widget-title" style="border-bottom-color:#f57c00;"><span style="background-color:#f57c00;">RUTAS</span></h3>                                                                                                                            
  <div class="widget widget_featured_posts widget_featured_posts_vertical widget_featured_meta clearfix">                                             

               <div class="single-article clearfix">   
 <div style="padding-left: 30px;padding-right: 30px; text-align: justify;" >  
 </div>
 

 <!--<form action="#" name="form" onsubmit="setDirections(this.from.value,this.to.value,this.locale.value);return false">
                              Origen<input type="text" name="from" id="fromAddress"  />
                              Destino<input type="text" name="to" id="toAddress" />    <br>                        
                              <input type="submit" name="Submit" value="Calcular Ruta"/>
                           </form>-->
                                                              
                           <!--<div id="direcciones" style=" width: 100%;height: 400px;"></div>  -->
    

   <form action="" name="form" class="form-horizontal" method="post">  
  <div class="form-group">
    <label for="txtOrigen" class="col-lg-2 control-label">Origen</label>
    <div class="col-lg-9">
        <div class="input-group">
            <div class="input-group-addon">
              <i class="fa fa-map-marker"></i> 
            </div>
            <input class="form-control" type="text"  id="txtOrigen" name="txtOrigen" style="background-color: white" required 
                   placeholder="Escriba el origen.."/>
        </div>
    </div>
  </div>

   <div class="form-group">
    <label for="txtDestino" class="col-lg-2 control-label">Destino</label>
    <div class="col-lg-9">
        <div class="input-group">
            <div class="input-group-addon">
              <i class="fa fa-map-marker"></i> 
            </div>
            <input class="form-control" type="text"  id="txtDestino" name="txtDestino" style="background-color: white" required 
                   placeholder="Escriba el destino.."/>
        </div>
    </div>
  </div>
   <div class="form-group">
      <div class="col-lg-4">&nbsp;</div>
       <div class="col-lg-4">                   
          <input type="button" class="btn btn-primary btnSeccion" id="calcularRuta" value="Obtener Ruta"/>
       </div>
      <div class="col-lg-4">&nbsp;</div>
  </div>
     </form>
 <div id="mapa_ruta" style=" width: 100%;height: 400px;"></div> 
                          <div class="row-fluid">
                            <div class="span12" id="direcciones">                              
                            </div>
                          </div> 
   </div>
               </div>              
      </section>                                                          
                    <div class="clearfix"></div>                        
                </div>
          </div>
<script src="https://pagead2.googlesyndication.com/pub-config/r20160913/ca-pub-2363340242556503.js" style=""></script>
    <script src="http://maps.google.com/maps?file=api&amp;v=2&amp;oe=ISO-8859-1;&amp;key=ABQIAAAAXfyLOV-DBHsmkpuY-LUUzBRvMuQNe3bCQ9tCDXjXwHZUjgdNBhQG32AJg5mKqo03Q&#10;mq9WX7GTGdmvw" type="text/javascript"></script>

    <script type="text/javascript">

    $("#calcularRuta").click(function(event) {
   var origen = $('#txtOrigen').val();
   var destino = $('#txtDestino').val();
   setDirections(origen.trim(),destino.trim(),'es');return false
    event.preventDefault();
})

var map;
var gdir;
var geocoder = null;
var addressMarker;

function initialize() {
if (GBrowserIsCompatible()) { 
map = new GMap2(document.getElementById("mapa_ruta"));
map.addControl(new GLargeMapControl());
map.addControl(new GMapTypeControl());
map.addControl(new GOverviewMapControl());
map.addControl(new GScaleControl());
gdir = new GDirections(map, document.getElementById("direcciones"));
GEvent.addListener(gdir, "load", onGDirectionsLoad);
GEvent.addListener(gdir, "error", handleErrors);
}
} 

function setDirections(fromAddress, toAddress, locale) {
  if(fromAddress.trim().length==0 || toAddress.trim().length==0 || locale.trim().length==0)
  {
    alert("Ingrese todos los datos");
  }
  else
  {
    try
    {
      gdir.load("from: " + fromAddress + " to: " + toAddress, { "locale": locale });
    }catch(err)
    {
      alert("Error al consultar");
    }          
}

}

function handleErrors(){
if (gdir.getStatus().code == G_GEO_UNKNOWN_ADDRESS)
alert("Dirección no disponible.\nError code: " + gdir.getStatus().code);
else if (gdir.getStatus().code == G_GEO_SERVER_ERROR)
alert("A geocoding or directions request could not be successfully processed, yet the exact reason for the failure is not known.\n Error code: " + gdir.getStatus().code); 
else if (gdir.getStatus().code == G_GEO_MISSING_QUERY)
alert("El parámetro HTTP q faltaba o no tenía valor. Para las solicitudes de geocodificador, esto significa que se especificó una dirección vacía como entrada. Para solicitudes de instrucciones, esto significa que no se especificó ninguna consulta en la entrada.\n Error code: " + gdir.getStatus().code); 
else if (gdir.getStatus().code == G_GEO_BAD_KEY)
alert("La clave dada no es válida o no coincide con el dominio para el que se proporcionó. \n Error code: " + gdir.getStatus().code);
else if (gdir.getStatus().code == G_GEO_BAD_REQUEST)
alert("Una solicitud de dirección no se pudo convertir correctamente.\n Código de error: " + gdir.getStatus().code); 
else alert("Un error desconocido a ocurrido."); 
}
function onGDirectionsLoad(){ 
}
</script>