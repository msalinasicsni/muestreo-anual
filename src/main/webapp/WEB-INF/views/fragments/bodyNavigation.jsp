<%@ taglib prefix="spring" uri="http://www.springframework.org/tags"%>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt"%>

<!-- Main content starts -->

<div class="content">

	<!-- Sidebar -->
	<div class="sidebar">
		<div class="sidebar-dropdown"><a href="#"><fmt:message key="nav" /></a></div>

		<!--- Sidebar navigation -->
		<!-- If the main navigation has sub navigation, then add the class "has_sub" to "li" of main navigation. -->
		<ul id="nav">
			<!-- Main menu with font awesome icon -->
			<li><a href="<spring:url value="/" htmlEscape="true" />"><i class="icon-home"></i>
					<fmt:message key="home" /></a></li>
			<li class="has_sub"><a href="#"><i class="icon-tablet"></i><fmt:message key="est" /><span class="pull-right"><i class="icon-chevron-right"></i></span></a>
				<ul>
					<li><a href="<spring:url value="/estaciones/bhcs" htmlEscape="true" />"><fmt:message key="samples.bhc" /></a></li>
					<li><a href="<spring:url value="/estaciones/rojos" htmlEscape="true" />"><fmt:message key="samples.red" /></a></li>
					<li><a href="<spring:url value="/estaciones/pbmcs" htmlEscape="true" />"><fmt:message key="samples.pbmc" /></a></li>
					<li><a href="<spring:url value="/estaciones/obsequios" htmlEscape="true" />"><fmt:message key="obsequios.menu" /></a></li>
					<li><a href="<spring:url value="/estaciones/consentimientoschik" htmlEscape="true" />"><fmt:message key="conschik" /></a></li>
					<li><a href="<spring:url value="/estaciones/chgest" htmlEscape="true" />"><fmt:message key="chgest" /></a></li>
				</ul>
			</li>
			<li class="has_sub"><a href="#"><i class="icon-user-md"></i><fmt:message key="sup" /><span class="pull-right"><i class="icon-chevron-right"></i></span></a>
				<ul>
					<li><a href="<spring:url value="/supervisores/bhcs" htmlEscape="true" />"><fmt:message key="samples.bhc" /></a></li>
					<li><a href="<spring:url value="/supervisores/rojos" htmlEscape="true" />"><fmt:message key="samples.red" /></a></li>
					<li><a href="<spring:url value="/supervisores/temp1" htmlEscape="true" />"><fmt:message key="temp.menu" /> <fmt:message key="temp.pbmc" /></a></li>
					<li><a href="<spring:url value="/supervisores/temp2" htmlEscape="true" />"><fmt:message key="temp.menu" /> <fmt:message key="temp.rojo" /></a></li>
					<li><a href="<spring:url value="/supervisores/pinchazos" htmlEscape="true" />"><fmt:message key="tubo.pin" /></a></li>
				</ul>
			</li>
			<li class="has_sub"><a href="#"><i class="icon-hospital"></i><fmt:message key="lab" /><span class="pull-right"><i class="icon-chevron-right"></i></span></a>
				<ul>
					<li><a href="<spring:url value="/laboratorio/bhcs" htmlEscape="true" />"><fmt:message key="samples.bhc" /></a></li>
					<li><a href="<spring:url value="/laboratorio/rojos" htmlEscape="true" />"><fmt:message key="samples.red" /></a></li>
					<li><a href="<spring:url value="/laboratorio/pbmcs" htmlEscape="true" />"><fmt:message key="samples.pbmc" /></a></li>
					<li><a href="<spring:url value="/laboratorio/paxs" htmlEscape="true" />"><fmt:message key="pax" /></a></li>
					<li><a href="<spring:url value="/laboratorio/temperaturas" htmlEscape="true" />"><fmt:message key="temp.menu" /></a></li>
				</ul>
			</li>
			<li class="has_sub"><a href="#"><i class="icon-ok"></i><fmt:message key="qc.menu" /><span class="pull-right"><i class="icon-chevron-right"></i></span></a>
				<ul>
					<li><a href="<spring:url value="/muestras/compbhc" htmlEscape="true" />"><fmt:message key="samples.bhc" /></a></li>
					<li><a href="<spring:url value="/muestras/comprojo" htmlEscape="true" />"><fmt:message key="samples.red" /></a></li>
					<li><a href="<spring:url value="/muestras/comppbmc" htmlEscape="true" />"><fmt:message key="samples.pbmc" /></a></li>
				</ul>
			</li>
			<li class="has_sub"><a href="#"><i class="icon-folder-open"></i><fmt:message key="reps.menu" /><span class="pull-right"><i class="icon-chevron-right"></i></span></a>
				<ul>
					<li><a href="<spring:url value="/reporte/sxday" htmlEscape="true" />"><fmt:message key="reps.sxday" /></a></li>
					<li><a href="<spring:url value="/reporte/sxnei" htmlEscape="true" />"><fmt:message key="reps.sxnei" /></a></li>
					<li><a href="<spring:url value="/reporte/sxage" htmlEscape="true" />"><fmt:message key="reps.sxage" /></a></li>
					<li><a href="<spring:url value="/reporte/sxest" htmlEscape="true" />"><fmt:message key="reps.sxest" /></a></li>
				</ul>
			</li>
			<li class="has_sub"><a href="#"><i class="icon-map-marker"></i><fmt:message key="mapas.menu" /><span class="pull-right"><i class="icon-chevron-right"></i></span></a>
				<ul>
					<li><a href="<spring:url value="/mapas/cohorte" htmlEscape="true" />"><fmt:message key="mapas.cohorte" /></a></li>
					<li><a href="<spring:url value="/mapas/muestras" htmlEscape="true" />"><fmt:message key="mapas.muestras" /></a></li>
					<li><a href="<spring:url value="/mapas/pendientes" htmlEscape="true" />"><fmt:message key="mapas.pendientes" /></a></li>
				</ul>
			</li>
			<li class="has_sub"><a href="#"><i class="icon-download"></i><fmt:message key="down" /><span class="pull-right"><i class="icon-chevron-right"></i></span></a>
				<ul>
					<li><a href="<spring:url value="/resources/apk/ODK MA.apk" htmlEscape="true" />"><fmt:message key="down.odk" /></a></li>
					<li><a href="<spring:url value="/resources/apk/muestreo-anual-app.apk" htmlEscape="true" />"><fmt:message key="down.ma" /></a></li>
					<li><a href="<spring:url value="/resources/apk/BarcodeScanner4.31.apk" htmlEscape="true" />"><fmt:message key="down.bc1" /></a></li>
					<li><a href="<spring:url value="/resources/apk/BarcodeScanner3.53.apk" htmlEscape="true" />"><fmt:message key="down.bc2" /></a></li>
				</ul>
			</li>
			<li class="has_sub"><a href="#"><i class="icon-envelope"></i><fmt:message key="sms" /><span class="pull-right"><i class="icon-chevron-right"></i></span></a>
				<ul>
					<li><a href="<spring:url value="/sms/admin/sms" htmlEscape="true" />"><fmt:message key="sms.ind" /></a></li>
					<li><a href="<spring:url value="/sms/admin/sms2" htmlEscape="true" />"><fmt:message key="sms.batch" /></a></li>
					<li><a href="<spring:url value="/sms/admin/stats" htmlEscape="true" />"><fmt:message key="sms.stats" /></a></li>
				</ul>
			</li>
			<li><a href="<spring:url value="/usuarios/admin/list" htmlEscape="true" />"><i class="icon-group"></i> <fmt:message key="users" /></a></li>
			<!-- Main content starts <li><a href="<spring:url value="/usuarios/admin/sms" htmlEscape="true" />"><i class="icon-envelope"></i> <fmt:message key="sms" /></a></li>-->
		</ul>
	</div>
</div>

