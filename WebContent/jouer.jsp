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
		<div class=row>
			<div class="col-md-6 col-md-offset-4">
				<h1><fmt:message key="play.nameP"/> ${laPartie.name}</h1>
				<h2><fmt:message key="play.idP"/> ${unePartie.id}</h2>
			</div>
		</div>
		<!--------PARTIE DICE & INFO PARTIE/SCORE-------->
		<div class="row">
			<div class="col-md-6">
				<h3><fmt:message key="play.JoueurTour"/> X <fmt:message key="play.JoueurTourBis"/></h3>
				<table class="table  text-center">
					<tr>
						<td><div class="sixth-face">
								<div class="column">
									<span class="pip"></span> <span class="pip"></span> <span
										class="pip"></span>
								</div>
								<div class="column">
									<span class="pip"></span> <span class="pip"></span> <span
										class="pip"></span>
								</div>
							</div></td>
						<td>
							<div class="col-md-offset-2"></div>
							<div class="second-face">
								<span class="pip"></span> <span class="pip"></span>
							</div>
						</td>
					</tr>
				</table>
				<h3><fmt:message key="play.JoueurScoreRound"/> X <fmt:message key="play.JoueurScoreRoundBis"/></h3>
				<p><fmt:message key="play.JoueurScoreTotal"/> XX</p>
				<p><fmt:message key="play.JoueurAliveOption"/></p>
			</div>
			<!--------PARTIE JOUER & SCORE-------->
			<div class="col-sm-6 col-md-6">
				<div class="thumbnail">
					<img src="./img/flat-feature-icon-2.png" alt="analytics-icon">
					<div class="caption">
						<h3>Joueur 1</h3>
						<p>score : XX</p>
					</div>
				</div>
				<div class="thumbnail">
					<img src="./img/flat-feature-icon-2.png">
					<div class="caption">
						<h3>Joueur 2</h3>
						<p>score : XY</p>
					</div>
				</div>
				<div class="thumbnail">
					<img src="./img/flat-feature-icon-2.png">
					<div class="caption">
						<h3>Joueur 1</h3>
						<p>score : XX</p>
					</div>
				</div>
				<div class="thumbnail">
					<img src="./img/flat-feature-icon-2.png">
					<div class="caption">
						<h3>Joueur 2</h3>
						<p>score : XY</p>
					</div>
				</div>
				<div class="thumbnail">
					<img src="./img/flat-feature-icon-2.png">
					<div class="caption">
						<h3>Joueur 1</h3>
						<p>score : XX</p>
						play.Score
					</div>
				</div>
				<div class="thumbnail">
					<img src="./img/flat-feature-icon-2.png">
					<div class="caption">
						<h3>Joueur 2</h3>
						<p>score : XY</p>
					</div>
				</div>
			</div>

		</div>
		<!--------PARTIE BOUTTON-------->
		<div class="row">
			<div class="col-md-12">
				<table class="table  text-center">
					<tr>
						<td><a class="form-control btn-primary btn-sm"
							href="./Jouer?action=lancerDes"><fmt:message key="play.lib_input_play"/></a></td>
						<td><a class="form-control btn-primary btn-sm"
							href="./Jouer?action=stopJouer"><fmt:message key="play.lib_input_stop"/></a></td>
					</tr>
				</table>
			</div>
		</div>
			<!-- Footer -->
	<%@ include file="footer.jsp"%>
	</div>
</body>
</html>