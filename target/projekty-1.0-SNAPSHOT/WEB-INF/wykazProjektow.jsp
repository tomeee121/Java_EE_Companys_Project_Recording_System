<%@ page contentType="text/html;charset=UTF-8" pageEncoding="UTF-8" language="java" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<!DOCTYPE html>
<html lang="pl">
<head>
  <title>Projekty, znajdujące się w bazie:</title>
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
  <c:if test="${not empty requestScope.projekty}">
    <section>
      <h2 style="margin: 10px 60px">Projekty w bazie danych, które są realizowane/ukończone/zaniechane/odłożone:</h2>
      <table style="margin: 10px 50px; border-collapse: collapse;border: 1px solid black; background-color: ghostwhite">
        <thead style="background-color: darkgoldenrod">
        <tr>
          <th style="border: 1px solid black;">Rodzaj projektu</th>
          <th style="border: 1px solid black;">Status projektu</th>
          <th style="border: 1px solid black;">Numer projektu</th>
          <th style="border: 1px solid black;">Temat projektu</th>
          <th style="border: 1px solid black;">Data rozpoczęcia</th>
          <th style="border: 1px solid black;">Data ukończenia</th>
          <th style="border: 1px solid black;">Kwota, na którą opiewa kontrakt</th>
          <th style="border: 1px solid black;">Opis</th>
        </tr>
        </thead>
        <tbody>
        <c:forEach var="projekt" items="${requestScope.projekty}">
          <tr>
            <td style="border: 1px solid black;">${projekt.getnazwa_rodzaj()}</td>
            <td style="border: 1px solid black;">${projekt.getnazwa_status()}</td>
            <td style="border: 1px solid black;">${projekt.nr_projekt}</td>
            <td style="border: 1px solid black;">${projekt.temat_projekt}</td>
            <td style="border: 1px solid black;">${projekt.data_rozpoczecia}</td>
            <td style="border: 1px solid black;">${projekt.data_zakonczenia}</td>
            <td style="border: 1px solid black;">${projekt.kwota}</td>
            <td style="border: 1px solid black;">${projekt.uwagi}</td>
          </tr>
        </c:forEach>
        </tbody>
      </table>
    </section>
  </c:if>

</main>

</body>
</html>