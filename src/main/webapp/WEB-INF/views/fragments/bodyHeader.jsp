<%@ taglib prefix="spring" uri="http://www.springframework.org/tags"%>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="sec"
	uri="http://www.springframework.org/security/tags"%>

<div class="navbar navbar-fixed-top bs-docs-nav" role="banner">

	<div class="conjtainer">
		<!-- Menu button for smaller screens -->
		<div class="navbar-header">
			<button class="navbar-toggle btn-navbar" type="button"
				data-toggle="collapse" data-target=".bs-navbar-collapse">
				<span><fmt:message key="menu" /></span>
			</button>
			<!-- Site name for smaller screens -->
			<a href="<spring:url value="/" htmlEscape="true" />"
				class="navbar-brand hidden-lg"><fmt:message key="heading" /></a>
		</div>



		<!-- Navigation starts -->
		<nav class="collapse navbar-collapse bs-navbar-collapse"
			role="navigation">
			<ul class="nav navbar-nav">

				<!-- Class "dropdown-big" creates big dropdown -->



				<li class="dropdown dropdown-big"><a href="#"
					class="dropdown-toggle" data-toggle="dropdown"><span
						class="label label-info"><i class="icon-zoom-in"></i></span> <fmt:message
							key="progress.study" /></a> <!-- Dropdown -->
					<ul class="dropdown-menu">
						<li>
							<!-- Progress bar --> <c:forEach var="muestrasEstudio"
								items="${muestrasEstudio}">
								<p>
									<c:out value="${muestrasEstudio[0]}" />
									-
									<c:out value="${muestrasEstudio[4]}" />
									%
								</p>
								<!-- Bootstrap progress bar -->
								<c:choose>
									<c:when test="${muestrasEstudio[4] <= 25}">
										<c:set var="clase" value="progress-bar progress-bar-danger" />
									</c:when>
									<c:when test="${muestrasEstudio[4] <= 50}">
										<c:set var="clase" value="progress-bar progress-bar-warning" />
									</c:when>
									<c:when test="${muestrasEstudio[4] <= 75}">
										<c:set var="clase" value="progress-bar progress-bar-info" />
									</c:when>
									<c:otherwise>
										<c:set var="clase" value="progress-bar progress-bar-success" />
									</c:otherwise>
								</c:choose>

								<div class="progress progress-striped active">
									<div class="<c:out value="${clase}" />" role="progressbar"
										aria-valuenow="<c:out value="${muestrasEstudio[4]}" />"
										aria-valuemin="0" aria-valuemax="100"
										style="width: <c:out value="${muestrasEstudio[4]}" />%">
									</div>
								</div>
								<hr />
							</c:forEach>

						</li>
					</ul></li>


				<li class="dropdown dropdown-big"><a href="#"
					class="dropdown-toggle" data-toggle="dropdown"><span
						class="label label-danger"><i class="icon-tint"></i></span> <fmt:message
							key="progress.type" /></a> <!-- Dropdown -->
					<ul class="dropdown-menu">
						<li>
							<!-- Progress bar --> <c:forEach var="muestrasTubo"
								items="${muestrasTubo}">
								<c:choose>
									<c:when test="${muestrasTubo[0] == 'No'}">
										<c:set var="tipotubo" value="Rojo" />
									</c:when>
									<c:otherwise>
										<c:set var="tipotubo" value="Pbmc" />
									</c:otherwise>
								</c:choose>
								<p>
									<c:out value="${tipotubo}" />
									-
									<c:out value="${muestrasTubo[6]}" />
									%
								</p>
								<!-- Bootstrap progress bar -->
								<c:choose>
									<c:when test="${muestrasTubo[6] <= 25}">
										<c:set var="clase2" value="progress-bar progress-bar-danger" />
									</c:when>
									<c:when test="${muestrasTubo[6] <= 50}">
										<c:set var="clase2" value="progress-bar progress-bar-warning" />
									</c:when>
									<c:when test="${muestrasTubo[6] <= 75}">
										<c:set var="clase2" value="progress-bar progress-bar-info" />
									</c:when>
									<c:otherwise>
										<c:set var="clase2" value="progress-bar progress-bar-success" />
									</c:otherwise>
								</c:choose>

								<div class="progress progress-striped active">
									<div class="<c:out value="${clase2}" />" role="progressbar"
										aria-valuenow="<c:out value="${muestrasTubo[6]}" />"
										aria-valuemin="0" aria-valuemax="100"
										style="width: <c:out value="${muestrasTubo[6]}" />%"></div>
								</div>
								<hr />
							</c:forEach>

						</li>
					</ul></li>
			</ul>
			<!-- Links -->
			<ul class="nav navbar-nav pull-right">
				<li class="dropdown pull-right"><a data-toggle="dropdown"
					class="dropdown-toggle" href="#"> <i class="icon-user"></i> <sec:authentication
							property="principal.username" /> <b class="caret"></b>
				</a> <!-- Dropdown menu -->
					<ul class="dropdown-menu">
						<!--<li><a
							href="<spring:url value="/usuarios/mod/password" htmlEscape="true" />"><i
								class="icon-cogs"></i> <fmt:message key="users.changepass" /></a></li>-->
						<li><a
							href="<spring:url value="/j_spring_security_logout" htmlEscape="true" />"><i
								class="icon-off"></i> <fmt:message key="log_out" /></a></li>
					</ul></li>

			</ul>
		</nav>

	</div>
</div>


<!-- Header starts -->
<header>
	<div class="container">
		<div class="row">

			<!-- Logo section -->
			<div class="col-md-4">
				<!-- Logo. -->
				<br />
				<div class="logo">
					<h1>
						<a href="<spring:url value="/" htmlEscape="true" />"><fmt:message
								key="heading" /><span class="bold"> <fmt:message
									key="year" />
						</span></a>
					</h1>
					<p class="meta">
						<fmt:message key="ics" />
					</p>
				</div>
				<!-- Logo ends -->
			</div>
			<!-- Data section -->

			<div class="col-md-4">
				<div class="header-data">
					<br />
					<!-- Traffic data -->
					<c:forEach var="muestrasTotal" items="${muestrasTotal}">
						<c:set var="totalBhc" value="${muestrasTotal[3]}"/>
						<c:set var="totalRojo" value="${muestrasTotal[4]}"/>
						<c:set var="totalPbmc" value="${muestrasTotal[5]}"/>
						<c:set var="totalPax" value="${muestrasTotal[8]}"/>
					</c:forEach>
					<c:set var="totalPart" value="${0.00}"/>
					<c:set var="totalTaken" value="${0.00}"/>
					<c:set var="totalPending" value="${0.00}"/>
					<c:forEach var="muestrasEstudio" items="${muestrasEstudio}">
						<c:set var="totalPart" value="${totalPart + muestrasEstudio[1]}"/>
						<c:set var="totalTaken" value="${totalTaken + muestrasEstudio[2]}"/>
						<c:set var="totalPending" value="${totalPending + muestrasEstudio[3]}"/>
					</c:forEach>
					<fmt:parseNumber var="numPart" type="number" value="${totalPart}" />
					<fmt:parseNumber var="numTaken" type="number" value="${totalTaken}" />
					<c:set var="totalProgreso" value="${numTaken * 100 / numPart}"/>
					<div class="hdata">
						<div class="mcol-left">
							<!-- Icon with red background -->
							<i class="icon-tint bviolet"></i>
						</div>
						<div class="mcol-right">
							<!-- Number of visitors -->
							<p>
								<a
									href="<spring:url value="/muestras/bhcs" htmlEscape="true" />"><c:out
										value="${totalBhc}" /></a> <em><fmt:message
										key="samples.bhc" /></em>
							</p>
						</div>
						<div class="clearfix"></div>
					</div>

					<!-- Members data -->
					<div class="hdata">
						<div class="mcol-left">
							<!-- Icon with blue background -->
							<i class="icon-tint bred"></i>
						</div>
						<div class="mcol-right">
							<!-- Number of visitors -->
							<p>
								<a
									href="<spring:url value="/muestras/rojos" htmlEscape="true" />"><c:out
										value="${totalRojo}" /></a> <em><fmt:message
										key="samples.red" /></em>
							</p>
						</div>
						<div class="clearfix"></div>
					</div>

					<!-- Members data -->
					<div class="hdata">
						<div class="mcol-left">
							<!-- Icon with blue background -->
							<i class="icon-tint bblue"></i>
						</div>
						<div class="mcol-right">
							<!-- Number of visitors -->
							<p>
								<a
									href="<spring:url value="/muestras/pbmcs" htmlEscape="true" />"><c:out
										value="${totalPbmc}" /></a> <em><fmt:message
										key="samples.pbmc" /></em>
							</p>
						</div>
						<div class="clearfix"></div>
					</div>
					
					<!-- Members data -->
					<div class="hdata">
						<div class="mcol-left">
							<!-- Icon with blue background -->
							<i class="icon-tint bgreen"></i>
						</div>
						<div class="mcol-right">
							<!-- Number of visitors -->
							<p>
								<a
									href="<spring:url value="/laboratorio/paxs" htmlEscape="true" />"><c:out
										value="${totalPax}" /></a> <em><fmt:message
										key="pax" /></em>
							</p>
						</div>
						<div class="clearfix"></div>
					</div>
					
				</div>
			</div>
			<div class="col-md-4">
				<br /><br />
				<div class="alert alert-info">
                      <span class="bold"><fmt:message key="summary.prog" /> : <fmt:formatNumber value="${totalProgreso}" type="number"/>%</span>
            	</div>
			</div>
		</div>
	</div>
</header>

<!-- Header ends -->

