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
            <div class="col-sm-3 pull-left">
                <select name="tipoMuestra" id="tipoMuestra" class="form-control select2-single">
                    <option selected value=""><spring:message code="lbl.select.sample.type" /></option>
                    <option value="0"><spring:message code="pbmcpax" /></option>
                    <option value="1"><spring:message code="samples.pbmc" /></option>
                    <option value="2"><spring:message code="rojopax" /></option>
                    <option value="3"><spring:message code="samples.red" /></option>
                    <option value="all"><spring:message code="lbl.all" /></option>
                </select>
            </div>
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
    <spring:url value="/mapas/pendientesGps" var="puntosUrl"/>
	<script src="https://unpkg.com/leaflet@1.6.0/dist/leaflet.js"
             integrity="sha512-gZwIG9x3wUXg2hdXF6+rVkLF/0Vi9U8D2Ntg4Ga5I5BZpVkVxlJWbSQtXPSiUTtC0TjtGOmxa1AJPuV0CPthew=="
             crossorigin=""></script>
    <script>
        var redIcon = L.icon({
            iconUrl: '../resources/images/red.png',
            iconSize:     [20, 20], // size of the icon
            iconAnchor:   [15, 15], // point of the icon which will correspond to marker's location
            popupAnchor:  [-3, -76] // point from which the popup should open relative to the iconAnchor
        });
        var yellowIcon = L.icon({
            iconUrl: '../resources/images/yellow.png',
            iconSize:     [20, 20], // size of the icon
            iconAnchor:   [15, 15], // point of the icon which will correspond to marker's location
            popupAnchor:  [-3, -76] // point from which the popup should open relative to the iconAnchor
        });
        var simpleIcon = L.icon({
            iconUrl: '../resources/images/simple.png',
            iconSize:     [20, 20], // size of the icon
            iconAnchor:   [15, 15], // point of the icon which will correspond to marker's location
            popupAnchor:  [-3, -76] // point from which the popup should open relative to the iconAnchor
        });
        var greenIcon = L.icon({
            iconUrl: '../resources/images/green.png',
            iconSize:     [20, 20], // size of the icon
            iconAnchor:   [15, 15], // point of the icon which will correspond to marker's location
            popupAnchor:  [-3, -76] // point from which the popup should open relative to the iconAnchor
        });

        var map;
        var markersLayer = new L.LayerGroup(); // NOTE: Layer is created here!
        var updateMap = function(tipoMuestra) {
            // NOTE: The first thing we do here is clear the markers from the layer.
            markersLayer.clearLayers();
            var locationCoor = [];
            var tipopunto;
            $.getJSON("${puntosUrl}"
                , function (data) {
                    var len = Object.keys(data).length;
                    for (var i = 0; i < len; i++) {
                        var miLat = data[i].latitud;
                        var miLong =data[i].longitud;
                        locationCoor[i] = [miLat, miLong];
                        if (data[i].pbmc=='Si' && data[i].paxgene=='Si' && (tipoMuestra==="0" || tipoMuestra === "all")) {
                            theMarker = L.marker([miLat, miLong], {icon: greenIcon}).addTo(map);
                            tipopunto = "0";
                        } else if (data[i].pbmc=='Si' && (tipoMuestra==="1" || tipoMuestra === "all")){
                            theMarker = L.marker([miLat, miLong], {icon: yellowIcon}).addTo(map);
                            tipopunto = "1";
                        }else if (data[i].paxgene=='Si' && (tipoMuestra==="2" || tipoMuestra === "all")){
                            theMarker = L.marker([miLat, miLong], {icon: simpleIcon}).addTo(map);
                            tipopunto = "2";
                        }else{
                            if (tipoMuestra==="3" || tipoMuestra === "all") {
                                theMarker = L.marker([miLat, miLong], {icon: redIcon}).addTo(map);
                                tipopunto = "3";
                            }
                        }
                        theMarker.bindTooltip(""+data[i].codigo+"");
                        if (tipoMuestra === 'all') {
                            markersLayer.addLayer(theMarker);
                        }else if (tipopunto === tipoMuestra) {
                            markersLayer.addLayer(theMarker);
                        }
                    }
                    var bounds = new L.latLngBounds(locationCoor);
                    map.fitBounds(bounds, {padding: [50,50]});
                }).fail(function (XMLHttpRequest, textStatus, errorThrown) {
                //toastr.error(errorThrown,"Error",{timeOut: 0});
                console.log(errorThrown);
            });
        };

        $(document).ready(function(){
            map = L.map('mapid').setView([12.15597, -86.28516], 17);
            L.tileLayer('http://a.tile.openstreetmap.fr/hot/{z}/{x}/{y}.png?access_token=pk.eyJ1IjoibXNhbGluYXNpY3MiLCJhIjoiY2s2dG8xcXV5MDE1bTNmbHRoMzg1eDMxdCJ9.fsBf-Ea0Anezq8pwsXxPSw', {
                maxZoom: 19,
                attribution: 'Map data &copy; <a href="https://www.openstreetmap.org/">OpenStreetMap</a> contributors, ' +
                    '<a href="https://creativecommons.org/licenses/by-sa/2.0/">CC-BY-SA</a>, ' +
                    'Imagery © <a href="https://www.mapbox.com/">Mapbox</a>',
                id: 'mapbox.streets'
            }).addTo(map);
            /*Legend specific*/
            var legend = L.control({position: 'topright'});
            legend.onAdd = function (map) {
                var div = L.DomUtil.create('div', 'legend');
                div.innerHTML += "<h4>Leyenda</h4>";
                div.innerHTML +=  '<img src="../resources/images/green.png">' + ' PBMC+Pax ' + '<br>';
                div.innerHTML +=  '<img src="../resources/images/yellow.png">'  + ' PBMC ' + '<br>';
                div.innerHTML +=  '<img src="../resources/images/simple.png">' + ' Rojo+Pax' + '<br>';
                div.innerHTML +=  '<img src="../resources/images/red.png">'  + ' Rojo' + '<br>';
                return div;
            };
            legend.addTo(map);
            markersLayer.addTo(map);
            updateMap('all');
            $("#tipoMuestra").on("change", function () {
                if (this.value !== ''){
                    updateMap(this.value);
                }
            });
        });
    </script>
  </body>
</html>
