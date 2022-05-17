<%@ page contentType="text/html;charset=UTF-8" pageEncoding="UTF-8" language="java" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<!DOCTYPE html>
<html lang="pl">
<head>
    <title>Projekty - strona główna</title>
    <link rel="stylesheet" href="${pageContext.request.contextPath}/styles.css">
    <meta http-equiv="Content-Type" content="text/html; charset=UTF-8" />
</head>
<body style="background-color: lightcyan";>
<div><a href="${pageContext.request.contextPath}/"><img src="images/1.jpg" width="100" height="100" alt="logotyp" style="width:300px;height:160px;"></a></div><br>
    <nav>
    <ul class="menu">
        <li><a href="index.html" class="nav-element">Strona główna</a></li>
        <li id="knowledge" class="expandable">
            <div class="nav-element">
                <p class="p">Wykaz projektów</p>
                <div class="expandable-element">
                    <ul>
                        <li><a href="${pageContext.request.contextPath}/dodaj">Dodaj rodzaj projektu</a></li>
                        <li><a href="${pageContext.request.contextPath}/dodajStatus">Dodaj status projektu</a></li>
                        <li><a href="${pageContext.request.contextPath}/dodajProjekt">Dodaj projekt</a></li>
                        <li><a href="${pageContext.request.contextPath}/pokazRodzaj">Projekty wg. rodzaju</a></li>
                        <li><a href="${pageContext.request.contextPath}/pokazStatus">Projekty wg. statusu</a></li>
                        <li><a href="${pageContext.request.contextPath}/wykazProjektow">Wykaz projektów</a></li>
                    </ul>
                </div>
            </div>
        </li>
        <li><a href="${pageContext.request.contextPath}/upload" class="nav-element">Prześlij z Excel'a</a></li>
    </ul>
    </nav>
<br><br><br><br><br><br><br><br><br><br><br><br>
<h1 style="text-align: center">Strona wspomagająca zarządzanie przedsiębiorstwem.</h1>
<p style="text-align: center">Wszelkie prawa zastrzeżone (Tomasz Borowski).</p>
</body>
</html>