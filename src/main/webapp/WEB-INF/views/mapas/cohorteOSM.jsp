<%@ taglib prefix="spring" uri="http://www.springframework.org/tags" %>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
<%@ taglib prefix="fn" uri="http://java.sun.com/jsp/jstl/functions" %>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
  <head>
    <meta name="viewport" content="width=device-width, initial-scale=1.0, user-scalable=no">
      <link rel="stylesheet" href="https://unpkg.com/leaflet@1.6.0/dist/leaflet.css"
            integrity="sha512-xwE/Az9zrjBIphAcBb3F6JVqxf46+CDLwfLMHloNu6KEQCAWi6HcDUbeOfBIptF7tcCzusKFjFw2yuvEpDL9wQ=="
            crossorigin=""/>
      <style>
          .map {
              position: absolute;
              height: 80%;
              width: 85%;
              outline: none;
              touch-action: none;
              background-color: #445a71;
          }
          .legend {
              background-color: #f9f9f9;
              text-align: left;
          }
      </style>
    <jsp:include page="../fragments/headTag.jsp" />
  </head>
  <body>
 	<jsp:include page="../fragments/bodyHeader.jsp" />
	<jsp:include page="../fragments/bodyNavigation.jsp" />
    <!-- Main bar -->
    <div class="mainbar">

        <!-- Page heading -->
        <div class="page-head">
            <h2 class="pull-left">
                <i class="icon-tint"></i>
                <fmt:message key="samples.menu" />
            </h2>

            <!-- Breadcrumb -->
            <div class="bread-crumb pull-right">
                <a href="<spring:url value="/" htmlEscape="true" />"><i
                        class="icon-home"></i> <fmt:message key="home" /></a>
            </div>

            <div class="clearfix"></div>
        </div>
        <!-- Page heading ends -->
        <!-- Matter -->

        <div class="matter">
            <div class="container">
                <div id="mapid" class="map"></div>
            </div>
            <!-- Matter ends -->
        </div>
        <!-- Mainbar ends -->
        <div class="clearfix"></div>

    </div>


	<!-- Scroll to top -->
	<span class="totop"><a href="#"><i class="icon-chevron-up"></i></a></span>
	<jsp:include page="../fragments/scripts.jsp" />
	<script src="https://unpkg.com/leaflet@1.6.0/dist/leaflet.js"
             integrity="sha512-gZwIG9x3wUXg2hdXF6+rVkLF/0Vi9U8D2Ntg4Ga5I5BZpVkVxlJWbSQtXPSiUTtC0TjtGOmxa1AJPuV0CPthew=="
             crossorigin=""></script>
    <script>
        //var mymap = L.map('mapid').setView([12.1537, -86.2878], 16);
        var mymap = L.map('mapid').setView([12.15597, -86.28516], 17);
        var theMarker = {};
        var locMarkers = new L.FeatureGroup();
        L.tileLayer('http://a.tile.openstreetmap.fr/hot/{z}/{x}/{y}.png?access_token=pk.eyJ1IjoibXNhbGluYXNpY3MiLCJhIjoiY2s2dG8xcXV5MDE1bTNmbHRoMzg1eDMxdCJ9.fsBf-Ea0Anezq8pwsXxPSw', {
            maxZoom: 18,
            attribution: 'Map data &copy; <a href="https://www.openstreetmap.org/">OpenStreetMap</a> contributors, ' +
                '<a href="https://creativecommons.org/licenses/by-sa/2.0/">CC-BY-SA</a>, ' +
                'Imagery © <a href="https://www.mapbox.com/">Mapbox</a>',
            id: 'mapbox.streets'
        }).addTo(mymap);
        var simpleIcon = L.icon({
            iconUrl: '../resources/images/simple.png',
            //shadowUrl: '../resources/images/simple.png',
            iconSize:     [20, 20], // size of the icon
            //shadowSize:   [15, 15], // size of the shadow
            iconAnchor:   [15, 15], // point of the icon which will correspond to marker's location
            //shadowAnchor: [4, 15],  // the same for the shadow
            popupAnchor:  [-3, -76] // point from which the popup should open relative to the iconAnchor
        });
        <c:forEach var="punto" items="${puntos}">
            var miLat = ${punto.latitud};
            var miLong = ${punto.longitud};
            theMarker = L.marker([miLat, miLong], {icon: simpleIcon}).addTo(mymap);
            theMarker.addTo(locMarkers);
            theMarker.bindTooltip("${punto.codigo}");
        </c:forEach>
        mymap.fitBounds(locMarkers.getBounds());
        var popup = L.popup();
    </script>
  </body>
</html>
