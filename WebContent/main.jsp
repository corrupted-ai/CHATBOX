<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Start</title>
<jsp:include page="common/head.jsp"></jsp:include>
<link rel="stylesheet" href="common/styling.css">
<link rel="stylesheet" href="common/lumen.css">
</head>
<meta charset="ISO-8859-1">
<title>Welcome ${user.name}</title>
</head>
<body style="overflow-x: hidden; ">
	<jsp:include page="common/nav.jsp"></jsp:include>
	<div class="row">
		<div class="col" style="overflow-y:scroll;oveflow-x:hidden;">
			<div class="row">
				<div style="margin-left: 45px; overflow: hidden;"
					class="col-lg-2 cardbox">
					<jsp:include page="${leftblock}"></jsp:include>
				</div>

				<div style="margin-left: 8px;" class="col-lg-7 cardbox">
					<div class="row"">
						<jsp:include page="common/navs.jsp"></jsp:include>
					</div>

					<div class="row" style="overflow-y: auto;max-height: 450px">
						<jsp:include page="${middleblock}"></jsp:include>
					</div>
				</div>

				<div style="margin-left: 8px;" class="col-lg-2 cardbox">
					<div class="row">
						<jsp:include page="${righttop}"></jsp:include>
					</div>
					<div class="row" style="overflow-y: auto;max-height: 350px;margin-top: 8px">
						<jsp:include page="${rightbottom}"></jsp:include>
					</div>
				</div>
			</div>
		</div>
	</div>
</body>
</html>