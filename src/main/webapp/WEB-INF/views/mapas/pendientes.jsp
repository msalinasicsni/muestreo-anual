<%@ taglib prefix="spring" uri="http://www.springframework.org/tags"%>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt"%>
<%@ taglib prefix="fn" uri="http://java.sun.com/jsp/jstl/functions"%>

<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta name="viewport"
	content="width=device-width, initial-scale=1.0, user-scalable=no">
<style>
html,body,#map_canvas {
	margin: 0;
	padding: 0;
	height: 100%;
}
#legend {
        font-family: Arial, sans-serif;
        background: #fff;
        padding: 10px;
        margin: 10px;
        border: 3px solid #000;
      }
      #legend h3 {
        margin-top: 0;
      }
      #legend img {
        vertical-align: middle;
      }
</style>
<jsp:include page="../fragments/headTag.jsp" />
</head>
<body>
	<jsp:include page="../fragments/bodyHeader.jsp" />
	<jsp:include page="../fragments/bodyNavigation.jsp" />
	<div id="map_canvas"></div>
	<div id="legend"><h3>Leyenda</h3></div>
	<!-- Footer starts -->
	<jsp:include page="../fragments/footer.jsp" />
	<!-- Scroll to top -->
	<span class="totop"><a href="#"><i class="icon-chevron-up"></i></a></span>
	<jsp:include page="../fragments/scripts.jsp" />
	<script
	src="https://maps.googleapis.com/maps/api/js?key=AIzaSyBPnElIQTm02hCnvAMZGDTd0zdGk-zoLF8&sensor=false"></script>
<script>
    function initialize() {
    	  var mapOptions = {
    	    zoom: 16,
    	    center: new google.maps.LatLng(12.153, -86.283),
    	    mapTypeId: google.maps.MapTypeId.ROADMAP
    	  };
    	  
    	  var image = {url: "../resources/images/simple.png"};
    	  var map = new google.maps.Map(document.getElementById('map_canvas'),
    	      mapOptions);
    	     <c:forEach var="punto" items="${puntos}">
    	        var myLatlng = new google.maps.LatLng("${punto[7]}","${punto[8]}");
    	        if ("${punto[9]}"=='Si' && "${punto[10]}"=='Si'){
    	        	image = {url: "../resources/images/green.png"};
    	        }
    	        else if ("${punto[9]}"=='Si'){
    	        	image = {url: "../resources/images/yellow.png"};
    	        }
    	        else if ("${punto[10]}"=='Si'){
    	        	image = {url: "../resources/images/simple.png"};
    	        }
    	        else {
    	        	image = {url: "../resources/images/red.png"};
    	        }
    	        var marcador = new google.maps.Marker({
    	    	    position: myLatlng,
    	    	    title: "${punto[0]}",
    	    	    icon: image,
    	    	    map: map
    	    	  });
    	     </c:forEach>	
    	     var legend = document.getElementById('legend');
    	     var div = document.createElement('div');
    	     div.innerHTML = '<img src="../resources/images/green.png"> ' + 'PBMC+Pax';
    	     legend.appendChild(div);
    	     var div = document.createElement('div');
    	     div.innerHTML = '<img src="../resources/images/yellow.png"> ' + 'PBMC';
    	     legend.appendChild(div);
    	     var div = document.createElement('div');
    	     div.innerHTML = '<img src="../resources/images/simple.png"> ' + 'Rojo+Pax';
    	     legend.appendChild(div);
    	     var div = document.createElement('div');
    	     div.innerHTML = '<img src="../resources/images/red.png"> ' + 'Rojo';
    	     legend.appendChild(div);
    	     map.controls[google.maps.ControlPosition.RIGHT_TOP].push(legend);
    	}
      google.maps.event.addDomListener(window, 'load', initialize);
    </script>
</body>
</html>
