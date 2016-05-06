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
		<div class="section-title">
			<h2>
				<fmt:message key="libelle.cp_title" />
			</h2>
		</div>
		<form class="form-horizontal" method="post"
			action="./CreerPartie?action=createPartie">
			<div class="form-group">
				<label for="inputPartie" class="col-sm-5 control-label"><fmt:message
						key="libelle.cp_form_nameP_ph" /></label>
				<div class="col-sm-4">
					<input type="text" class="form-control" id="inputPartie"
						name="inputPartie"
						placeholder="<fmt:message key="libelle.cp_form_nameP_ph" />">
				</div>
			</div>
			<div class="form-group">
				<label for="nbJoueur" class="col-sm-5 control-label"><fmt:message
						key="libelle.cp_form_nbJ" /></label>
				<div class="col-sm-1" >
					<input type="number" class="form-control" id="nbJoueur"
						name="nbJoueur" min="2" max="10" value="2">
				</div>
			</div>
			<div class="row">
				<p class="col-sm-offset-4">
					<small><fmt:message key="libelle.acc_form_lib_requiere" /></small>
				</p>
			</div>
			<div class="form-group">
				<div class="col-sm-offset-5 col-sm-7">
					<button type="submit" class="btn btn-default">
						<fmt:message key="libelle.acc_form_submit" />
					</button>
				</div>
			</div>
		</form>
	</div>
	<!-- Footer -->
	<%@ include file="footer.jsp"%>
</body>
</html>