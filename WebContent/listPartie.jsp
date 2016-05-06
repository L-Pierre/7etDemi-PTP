<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt"%>
<c:set var="language"
	value="${not empty param.language ? param.language : not empty language ? language : pageContext.request.locale}"
	scope="session" />
<fmt:setLocale value="${language}" />
<fmt:setBundle basename="langues_${language}" />
<!DOCTYPE html>
<html lang="${language}">
<head>
<script src="script/jquery-2.2.1.min.js"></script>
<script type="text/javascript">
	// permet de changer la langue du site
	function changeLocale(language) {
		$.ajax({
			url : ctx + "/locale.do",
			data : "language=" + language,
			success : function(msg) {
				location.reload();
			}
		});
	};
</script>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<link href="css/bootstrap.css" rel="stylesheet">
<link href="css/style.css" rel="stylesheet">
<title><fmt:message key="libelle.acc_title" /></title>
</head>
<body class="pace-done">
	<%@ include file="menu.jsp"%>
	<div class="container">
		<div class="row">
			<div class="col-md-11 col-md-offset-1">
				<h3><fmt:message key="lp.listPartieRunning" /></h3>
				<table class="table table-bordered text-center table-striped">
					<thead>
						<tr>
							<th class="text-center"><fmt:message key="lp.table_nameP" /></th>
							<th class="text-center"><fmt:message key="lp.table_nbJoueur" /></th>
							<th class="text-center"><fmt:message key="lp.table_Join" /></th>
						</tr>
					</thead>
					<tbody>
						<c:forEach var="unePartie" items="${lesParties}">
							<tr>
								<td class="text-center">${unePartie.name}</td>
								<td class="text-center">${unePartie.maxPlayer}</td>
								<td class="text-center"><a
									class="form-control btn-primary btn-sm"
									href="./JoinPartie?p=${unePartie.id}"><fmt:message key="lp.table_Join" /></a></td>
							</tr>
						</c:forEach>
					</tbody>
				</table>
			</div>
		</div>
	</div>
	<!-- Footer -->
	<%@ include file="footer.jsp"%>
</body>