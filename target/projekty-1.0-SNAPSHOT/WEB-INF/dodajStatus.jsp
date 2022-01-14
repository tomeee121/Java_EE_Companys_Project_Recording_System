<%@ page contentType="text/html;charset=UTF-8" pageEncoding="UTF-8" language="java" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<!DOCTYPE html>
<html lang="pl">
<head>
    <title>Dodaj status projektu do bazy</title>
    <link rel="stylesheet" href="${pageContext.request.contextPath}/styles.css">
    <meta http-equiv="Content-Type" content="text/html; charset=UTF-8" />
</head>
<body style="background-color: lightcyan";>
<div><a href="${pageContext.request.contextPath}/"><img src="images/1.jpg" width="100" height="100" alt="logotyp" style="width:300px;height:160px;"></a></div><br>
<nav>
    <ul class="menu">
        <li><a href="${pageContext.request.contextPath}" class="nav-element">Strona główna</a></li>
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
    </ul>
</nav>

<main>
    <form action="" method="POST" style="margin: 30px auto; text-align: center; background-color: beige">
        <label style="margin-bottom: 40px" for="title">Wpisz status projektu:</label>
        <input name="title" id="title" style="line-height: 28px; margin: 5px 0"><br>
        <c:if test="${not empty requestScope.check}"><p style="color: crimson">Podaj nazwę</p></c:if>
        <input type="submit" style="line-height: 28px; margin: 5px 0; background-color: coral">
    </form>
</main>

</body>
</html>