%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Insert title here</title>
</head>
<body>
	<label for="welcome"><fmt:message key="libelle.hello" /></label>
	<img src="img/fr_FR.png" onclick="changeLocale('fr_FR');" />
	<img src="img/en_Us.png" onclick="changeLocale('en_Us');" />
</body>
</html>