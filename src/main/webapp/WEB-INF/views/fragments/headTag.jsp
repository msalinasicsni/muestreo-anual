<%@ taglib prefix="spring" uri="http://www.springframework.org/tags"%>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt"%>

<!--
ICS-Nicaragua :: Muestreo anual
-->

<head>
<meta http-equiv="Content-Type" content="text/html; charset=iso-8859-1" />
<meta charset="iso-8859-1">
<title><fmt:message key="title" /></title>
<meta name="viewport" content="width=device-width, initial-scale=1.0">
<meta name="description" content="">
<meta name="keywords" content="">
<meta name="author" content="">

<!-- Stylesheets -->
<spring:url value="/resources/style/bootstrap.css" var="bootstrap" />
<link href="${bootstrap}" rel="stylesheet">
<!-- Font awesome icon -->
<spring:url value="/resources/style/font-awesome.css" var="fontawesome" />
<link rel="stylesheet" href="${fontawesome}">
<!-- jQuery UI -->
<spring:url value="/resources/style/jquery-ui.css" var="jqueryUi" />
<link rel="stylesheet" href="${jqueryUi}">
<!-- Main stylesheet -->
<spring:url value="/resources/style/style.css" var="style" />
<link href="${style}" rel="stylesheet">
<!-- Widgets stylesheet -->
<spring:url value="/resources/style/widgets.css" var="widgets" />
<link href="${widgets}" rel="stylesheet">
<!-- Calendar -->
<spring:url value="/resources/style/fullcalendar.css" var="fullcalendar" />
<link href="${fullcalendar}" rel="stylesheet">
<!-- prettyPhoto -->
<spring:url value="/resources/style/prettyPhoto.css" var="prettyPhoto" />
<link href="${prettyPhoto}" rel="stylesheet">
<!-- Star rating -->
<spring:url value="/resources/style/rateit.css" var="rateit" />
<link href="${rateit}" rel="stylesheet">
<!-- Date picker -->
<spring:url value="/resources/style/bootstrap-datetimepicker.min.css"
	var="datetimepicker" />
<link href="${datetimepicker}" rel="stylesheet">
<!-- CLEditor -->
<spring:url value="/resources/style/jquery.cleditor.css"
	var="jquerycleditor" />
<link href="${jquerycleditor}" rel="stylesheet">
<!-- Bootstrap toggle -->
<spring:url value="/resources/style/bootstrap-switch.css"
	var="bootstrapswitch" />
<link rel="stylesheet" href="${bootstrapswitch}">

<spring:url value="/resources/style/dataTables.bootstrap.css"
	var="dtbootstrap" />
<link href="${dtbootstrap}" rel="stylesheet">

<spring:url value="/resources/validation/css/screen.css" var="validationCss" />
<link href="${validationCss}" rel="stylesheet"></link>

<!-- HTML5 Support for IE -->
<!--[if lt IE 9]>
  <script src="js/html5shim.js"></script>
  <![endif]-->

<!-- Favicon -->
<spring:url value="/resources/img/favicon/favicon.png" var="favicon" />
<link rel="shortcut icon" href="${favicon}">
</head>