<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
    <%@taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
    <%@ taglib prefix="spring" uri="http://www.springframework.org/tags"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html>
<html xmlns="http://www.w3.org/1999/xhtml"
	xmlns:th="http://www.thymeleaf.org">
<head>
		<meta charset="utf-8" />
		<title>Document Management System</title>
		<link rel="stylesheet" href="css/admin.css">
<script src="https://code.jquery.com/jquery-1.11.1.min.js"></script>
<script src="https://code.jquery.com/jquery-3.3.1.js"></script> 
<script src="https://cdn.datatables.net/1.10.20/js/jquery.dataTables.min.js"></script>
<script src="https://cdn.datatables.net/1.10.20/js/dataTables.jqueryui.min.js"></script>
<script src="https://cdn.datatables.net/scroller/2.0.1/js/dataTables.scroller.min.js"></script>
<link rel="stylesheet" href="https://code.jquery.com/ui/1.12.1/themes/base/jquery-ui.css">	
<link rel="stylesheet" href="https://cdn.datatables.net/1.10.20/css/dataTables.jqueryui.min.css">	
<link rel="stylesheet" href="https://cdn.datatables.net/scroller/2.0.1/css/scroller.jqueryui.min.css">	
  <script src="js/temptable.js"></script>
</head>
<body>
<div id="document">
<div id="header">
 <jsp:include page="common/header.jsp"/>
</div>
<div id="main">
	<div class="main-container">
	<div class="container-fluid">
		<div class="main-content-wrapper">
		<div class="row">
			<h2>Documents</h2>
			<a href="/uploaddoc"><button class="btn btn-primary"  id="uploaddoc">Upload</button> </a>
			<button class="cssp btn btn-primary" onclick="javascript:deleteFiles()">Delete Files</button>
		   </div>
		   <br>
			<div id="templateTableContainer">
			<jsp:include page="documenttable.jsp"></jsp:include>
			</div>
		</div>
			
	</div>
</div>
<br>
   <br>
   </div>
   <div id="footer">
    <jsp:include page="common/footer.jsp"/>
</div>
</div>
</body>

</html>

