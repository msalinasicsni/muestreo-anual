<%@ taglib prefix="spring" uri="http://www.springframework.org/tags" %>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
<%@ taglib prefix="fn" uri="http://java.sun.com/jsp/jstl/functions" %>

<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
  <head>
    <meta name="viewport" content="width=device-width, initial-scale=1.0, user-scalable=no">
    <style>
       html, body, #map_canvas {
        margin: 0;
        padding: 0;
        width: 100%;
        height: 100%;
      }
    </style>
    <jsp:include page="../fragments/headTag.jsp" />
  </head>
  <body>
 	<jsp:include page="../fragments/bodyHeader.jsp" />
	<jsp:include page="../fragments/bodyNavigation.jsp" />
	<div id="map_canvas"></div>
	<!-- Footer starts -->
	<jsp:include page="../fragments/footer.jsp" />
	<!-- Scroll to top -->
	<span class="totop"><a href="#"><i class="icon-chevron-up"></i></a></span>
	<jsp:include page="../fragments/scripts.jsp" />
	<script src="https://maps.googleapis.com/maps/api/js?key=AIzaSyAK1XE7g46S15tf9qfCr7eKnzruEcflJiU"></script>
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
    	        var marcador = new google.maps.Marker({
    	    	    position: myLatlng,
    	    	    title: "${punto[0]}",
    	    	    icon: image,
    	    	    map: map
    	    	  });

    	     </c:forEach>	
    	  
    	}
      google.maps.event.addDomListener(window, 'load', initialize);
    </script>
  </body>
</html>
