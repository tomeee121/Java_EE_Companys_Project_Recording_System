<%@ page contentType="text/html;charset=UTF-8" pageEncoding="UTF-8" language="java" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<!DOCTYPE html>
<html lang="pl">
<head>
    <title>Dodaj projekt do bazy na podstawie dodanych statusów i rodzajów</title>
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
    <form action="" method="post">
    <c:if test="${not empty requestScope.kinds}">
        <p style="text-align: center; line-height: 28px; margin: 5px 0">Wybierz rodzaj projektu</p>
        <div style="text-align: center">
        <select name="kind" required>
        <optgroup label="Rodzaje:" id="optgroup1" style="line-height: 28px;">
            <c:forEach var="kind" items="${requestScope.kinds}">
                    <option value="${kind.nazwa_rodzaj}" style="line-height: 28px;">${kind.nazwa_rodzaj}</option>
            </c:forEach>
        </optgroup>
        </select>
        </div>
    </c:if>

    <c:if test="${not empty requestScope.statuses}">
        <br>
        <p style="text-align: center; line-height: 28px; margin: 5px 0">Wybierz status projektu</p>
        <div style="text-align: center">
        <select name="status" required>
            <optgroup label ="Statusy:" id="optgroup2" style="line-height: 28px;">
                <c:forEach var="status" items="${requestScope.statuses}">
                    <option value="${status.nazwa_status}" style="line-height: 28px;">${status.nazwa_status}</option>
                </c:forEach>
            </optgroup>
        </select>
        </div>
    </c:if>
    <div style="text-align: center">
    <label style="margin-bottom: 40px" for="input1">Wpisz nr projektu:</label>
    <input name="nr_projekt" id="input1" style="line-height: 28px; margin: 5px 0" required><br>
    <label style="margin-bottom: 40px" for="input2">Wpisz temat projektu:</label>
    <input name="temat_projekt" id="input2" style="line-height: 28px; margin: 5px 0" required><br>
    <label style="margin-bottom: 40px" for="input3">Wpisz datę rozpoczęcia:</label>
    <input name="data_rozpoczecia" placeholder="Format YYYY-MM-DD" id="input3" style="line-height: 28px; margin: 5px 0" required><br>
    <label style="margin-bottom: 40px" for="input4">Wpisz datę zakończenia:</label>
    <input name="data_zakonczenia" placeholder="Format YYYY-MM-DD" id="input4" style="line-height: 28px; margin: 5px 0" required><br>
    <label style="margin-bottom: 40px" for="input5">Wpisz kwotę, na którą opiewa projekt w zł:</label>
    <input name="kwota" id="input5" style="line-height: 28px; margin: 5px 0" required><br>
    <label style="margin-bottom: 40px" for="input6">Opis/dodatkowe:</label>
    <input name="uwagi" id="input6" style="line-height: 28px; margin: 5px 0" required><br>

    <input type="submit" style="line-height: 28px; margin: 5px 0; background-color: coral">
    </div>
    </form>

</main>

</body>
</html>