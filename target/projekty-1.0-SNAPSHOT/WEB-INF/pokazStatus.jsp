<%@ page contentType="text/html;charset=UTF-8" pageEncoding="UTF-8" language="java" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<!DOCTYPE html>
<html lang="pl">
<head>
  <title>Projekty według statusu</title>
  <link rel="stylesheet" href="${pageContext.request.contextPath}/styles.css">
  <script type="text/javascript" src="${pageContext.request.contextPath}/script.js"></script>
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
  <c:if test="${not empty requestScope.statuses}">
    <section>
      <h2 style="margin: 10px 60px">Projekty według statusu:</h2>
      <table style="margin: 10px 50px; border-collapse: collapse; background-color: ghostwhite">
        <thead style="background-color: darkgoldenrod">
        <tr>
          <th style="border: 1px solid black;">Akcja</th>
          <th style="border: 1px solid black;">id_status</th>
          <th style="border: 1px solid black;">nazwa_status</th>
        </tr>
        </thead>
        <tbody>
        <c:forEach var="status" items="${requestScope.statuses}">
          <tr id="${status.getid_status()}">
            <td id="2_${status.getid_status()}" style="border: 1px solid black;"><a href="${pageContext.request.contextPath.concat('/usuńStatus?id_status=').concat(status.getid_status())}"><c:out value=" Usuń "/></a>
                <c:out value="  / "/>
              <button value="${status.getid_status()}" onclick="createForm(this.value)">Edytuj</button></td>
            <td id="3_${status.getid_status()}" style="border: 1px solid black;">${status.getid_status()}</td>
            <td id="4_${status.getid_status()}" style="border: 1px solid black;">${status.nazwa_status}</td>
          </tr>
        </c:forEach>
        </tbody>
      </table>
    </section>
  </c:if>

</main>

</body>
</html>