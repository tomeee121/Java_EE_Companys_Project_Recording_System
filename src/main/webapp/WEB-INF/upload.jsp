<%@ page contentType="text/html;charset=UTF-8" pageEncoding="UTF-8" language="java" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<!DOCTYPE html>
<html lang="pl">
<head>
    <title>Dodaj rodzaj projektu do bazy</title>
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
        <li><a href="${pageContext.request.contextPath}/upload" class="nav-element">Prześlij z Excel'a</a></li>
    </ul>
</nav>
        <main>
            <p style="text-align: center; width:70vw">W przypadku potrzeby zarchiwizowania znacznej liczby danych, możliwe jest ich przesłanie poprzez upload z pliku .xlsx (Excel),
                należy jednak przesłać je odpowiednio uporzadkowane:</p>
            <section>
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
                </table>
            </section>

            <section style="margin-left: 90px">
            <h1>Prześlij plik:</h1>
            <form action="upload" enctype="multipart/form-data" method="post">
                <input type="file" name="file" style="background-color: #808080;border: none;color: black;padding: 15px 32px;text-align: center;text-decoration: none;display: inline-block;font-size: 16px;margin: 4px 2px;cursor: pointer;margin-bottom: 10px"/><br>
                <input type="submit" value="upload" style="background-color: #4CAF50;border: none;color: white;padding: 15px 32px;text-align: center;text-decoration: none;display: inline-block;font-size: 16px;margin: 4px 2px;cursor: pointer;"/>
            </form>
            </section>
        </main>

</body>
</html>