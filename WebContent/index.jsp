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
<script type="text/javascript">
	$(document).ready(function() {
		var statutAuth =
<%out.print(request.getAttribute("errorAuth"));%>
	if (statutAuth == null || statutAuth == false) {
			$("#failAuth").hide();
		}
<%request.setAttribute("errorAuth", null);%>
	var statutAuth =
<%out.print(request.getAttribute("errorNewAcc"));%>
	if (statutAuth == null) {
			$("#failAcc").hide();
			$("#mkAcc").hide();
		}else if(statutAuth == true){
			$("#mkAcc").hide();
		}else{
			$("#failAcc").hide();
		}
<%request.setAttribute("errorNewAcc", null);%>
	}
	);
</script>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<link href="css/bootstrap.css" rel="stylesheet">
<link href="css/style.css" rel="stylesheet">
<title><fmt:message key="libelle.acc_title" /></title>
</head>
<body class="pace-done">
	<main id="top" class="masthead" role="main">
	<div class="container">
		<div class="logo">
			<a href="#"><img src="img/logo_acc.png" alt="startup-logo"></a>
		</div>
		<div class="row text-shadow">
			<h1>
				<strong><fmt:message key="libelle.acc_1" /></strong> <br>
				<fmt:message key="libelle.acc_2" />
			</h1>
		</div>
		<div class="row">
			<div class="col-md-6 col-sm-12 col-md-offset-3 subscribe">
				<div class="alert alert-danger alert-dismissible" id="failAuth"
					role="alert">
					<button type="button" class="close" data-dismiss="alert"
						aria-label="Close">
						<span aria-hidden="true">&times;</span>
					</button>
					<strong><fmt:message key="libelle.acc_errorLogin" /></strong>
					<fmt:message key="libelle.acc_errorLogin_c" />
				</div>
				<div class="alert alert-success alert-dismissible" id="mkAcc"
					role="alert">
					<button type="button" class="close" data-dismiss="alert"
						aria-label="Close">
						<span aria-hidden="true">&times;</span>
					</button>
					<strong><fmt:message key="libelle.acc_mk_success" /></strong> <br />
					<fmt:message key="libelle.acc_mk_success_c" />
				</div>
				<form class="form-horizontal" role="form"
					action="./Connexion?action=auth" id="subscribeForm" method="POST">
					<div class="form-group">
						<div class="signup-block">
							<div class="row">
								<div class="col-md-6 col-sm-6 col-sm-offset-1 col-md-offset-0">
									<input class="form-control input-lg" name="login" type="text"
										id="login"
										placeholder="<fmt:message key="libelle.acc_buttonLogin"/>"
										required>
								</div>
								<div class="col-md-6 col-sm-6 col-sm-offset-1 col-md-offset-0">
									<input class="form-control input-lg" name="mdp" type="password"
										id="mdp"
										placeholder="<fmt:message key="libelle.acc_buttonMDP" />"
										required>
								</div>
							</div>
						</div>
						<div class="row-fluid">
							<div class="col-md-12 col-sm-4">
								<button type="submit" class="btn btn-success btn-lg">
									<fmt:message key="libelle.acc_buttonConnect" />
								</button>
							</div>
						</div>
					</div>
				</form>
				<span id="result" class="alertMsg"></span>
			</div>
		</div>
		<a href="#explore" class="scrollto">
			<p class="text-shadow">
				<fmt:message key="libelle.acc_scroll_down" />
			</p>
			<p class="scrollto--arrow">
				<img src="img/scroll_down.png" alt="scroll down arrow">
			</p>
		</a>
	</div>
	</main>
	<div class="container full" id="explore">
		<div class="section-title">
			<h2>
				<fmt:message key="libelle.acc_title_mk_acc" />
			</h2>
			<h4>
				<fmt:message key="libelle.acc_title_mk_acc_sub" />
			</h4>
		</div>
		<div class="section-title">
			<h4>
				<fmt:message key="libelle.acc_title_fill_field" />
			</h4>
		</div>
		<div class="row center">
			<div
				class="alert alert-danger alert-dismissible col-md-5 col-md-offset-4"
				id="failAcc" role="alert">
				<button type="button" class="close" data-dismiss="alert"
					aria-label="Close">
					<span aria-hidden="true">&times;</span>
				</button>
				<strong><fmt:message key="libelle.acc_errorAcc" /></strong>
				<fmt:message key="libelle.acc_errorAcc_c" />
			</div>
		</div>
		<form class="form-horizontal" method="post"
			action="./Connexion?action=newAcc">
			<div class="form-group">
				<label for="inputLogin" class="col-sm-5 control-label"><fmt:message
						key="libelle.acc_form_login" /></label>
				<div class="col-sm-4">
					<input type="text" class="form-control" id="inputLogin"
						name="inputLogin"
						placeholder="<fmt:message key="libelle.acc_form_login_ph" />">
				</div>
			</div>
			<div class="form-group">
				<label for="inputPassword" class="col-sm-5 control-label"><fmt:message
						key="libelle.acc_form_mdp" /></label>
				<div class="col-sm-4">
					<input type="password" class="form-control" id="inputPassword"
						name="inputPassword"
						placeholder="<fmt:message key="libelle.acc_form_mdp_ph" />">
				</div>
			</div>
			<div class="form-group">
				<label for="inputPasswordVerif" class="col-sm-5 control-label"><fmt:message
						key="libelle.acc_form_verif_mdp" /></label>
				<div class="col-sm-4">
					<input type="password" class="form-control" id="inputPassword3"
						placeholder="<fmt:message key="libelle.acc_form_verif_mdp_ph" />">
				</div>
			</div>
			<div class="row">
				<p class="col-sm-offset-4">
					<small><fmt:message key="libelle.acc_form_lib_requiere" /></small>
				</p>
			</div>
			<div class="form-group">
				<div class="col-md-offset-6 col-sm-7">
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