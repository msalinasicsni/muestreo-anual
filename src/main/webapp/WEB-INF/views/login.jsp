<!DOCTYPE html>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt"%>
<%@ taglib prefix="spring" uri="http://www.springframework.org/tags"%>
<html>

<!--
ICS-Nicaragua :: Muestreo anual
-->

<head>
<title><fmt:message key="loginpage" /></title>
<meta name="viewport" content="width=device-width, initial-scale=1.0">
<meta name="description" content="">
<meta name="keywords" content="">
<meta name="author" content="">
<style>
.errorblock {
	color: #ff0000;
	background-color: #ffEEEE;
	border: 3px solid #ff0000;
	padding: 8px;
	margin: 16px;
	width: 350px;
}
</style>
<!-- Stylesheets -->
<spring:url value="/resources/style/bootstrap.css" var="bootstrap" />
<link href="${bootstrap}" rel="stylesheet">
<spring:url value="/resources/style/font-awesome.css" var="fontawesome" />
<link rel="stylesheet" href="${fontawesome}">
<spring:url value="/resources/style/style.css" var="style" />
<link href="${style}" rel="stylesheet">
<!-- Favicon -->
<spring:url value="/resources/img/favicon/favicon.png" var="favicon" />
<link rel="shortcut icon" href="${favicon}">
</head>

<body>
	<!-- Form area -->
	<div class="admin-form">
		<div class="container">

			<div class="row">
				<div class="col-md-12">
					<!-- Widget starts -->
					<div class="widget worange">
						<!-- Widget head -->
						<div class="widget-head">
							<i class="icon-lock"></i>
							<fmt:message>loginpage</fmt:message>
						</div>

						<div class="widget-content">
							<div class="padd">
								<!-- Login form -->
								<form class="form-horizontal"
									action="<c:url value='j_spring_security_check' />"
									method='POST'>
									<!-- Email -->
									<div class="form-group">
										<label class="control-label col-lg-3" for="j_username"><fmt:message>users.user</fmt:message></label>
										<div class="col-lg-9">
											<input type="text" class="form-control" id="username"
												name='j_username' value=''
												placeholder="<fmt:message>users.user</fmt:message>">
										</div>
									</div>
									<!-- Password -->
									<div class="form-group">
										<label class="control-label col-lg-3" for="j_password"><fmt:message>users.password</fmt:message></label>
										<div class="col-lg-9">
											<input type="password" class="form-control" name='j_password'
												placeholder="<fmt:message>users.password</fmt:message>">
										</div>
									</div>
									<!-- Remember me checkbox and sign in button -->
									<div class="form-group"></div>
									<div class="col-lg-9 col-lg-offset-2">
										<button name="submit" type="submit" class="btn btn-default">
											<fmt:message>send</fmt:message>
										</button>
										<button name="reset" type="reset" class="btn btn-default">
											<fmt:message>reset</fmt:message>
										</button>
									</div>
									<br />
								</form>

							</div>
						</div>
					</div>
				</div>
			</div>
		</div>
		<c:if test="${not empty error}">
			<div class="errorblock">
				<fmt:message key="loginfailed" />
				<br>
				<c:out value="${SPRING_SECURITY_LAST_EXCEPTION.message}" />
			</div>
		</c:if>
	</div>



	<!-- JS -->
	<spring:url value="/resources/js/jquery.js" var="jQuery" />
	<script src="${jQuery}"></script>

	<spring:url value="/resources/js/bootstrap.js" var="bootstrap" />
	<script src="${bootstrap}"></script>
</body>
</html>