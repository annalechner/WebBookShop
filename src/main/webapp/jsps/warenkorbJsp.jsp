<%-- 
    Document   : bookJsp
    Created on : 19.11.2019, 13:51:40
    Author     : annalechner
--%>

<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <meta name="viewport" content="width=device-width, initial-scale=1">
        <link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/3.4.0/css/bootstrap.min.css">
        <script src="https://ajax.googleapis.com/ajax/libs/jquery/3.4.1/jquery.min.js"></script>
        <script src="https://maxcdn.bootstrapcdn.com/bootstrap/3.4.0/js/bootstrap.min.js"></script>
        <link href="style/styleBook.css" rel="stylesheet" type="text/css"/>
        <script src="scripts/script.js" type="text/javascript"></script>
        <title>Warenkorb</title>
    </head>
    <body>

        <div class="container">
            <center><h1>Bookshop Luna Krochner</h1>
                <h3>Warenkorb</h3>
                <form method="POST" action="BookController">
                    <input type="submit" class="btn btn-primary" name="back" value="Zurück"/>
                </form>
                <table id="myTable" class="table table-hover">
                    <thead>
                        <tr>
                            <th scope="col">Titel</th>
                            <th scope="col">ISBN</th>
                            <th scope="col">Preis</th>
                            <th scope="col">Menge</th>
                        </tr>
                    </thead>
                    <tbody>
                        <c:forEach var="item" items="${books}">
                            <c:if test="${item.amount>0}">
                                <tr>
                                    <td>${item.title}</td>
                                    <td>${item.isbn}</td>
                                    <td>${String.format("%.2f €",item.price)}</td>
                                    <td>${item.amount}</td>
                                </tr></c:if></c:forEach>
                    </tbody>
                </table>

                <form id="formBack" method="POST" action="BookController">
                    <input type="submit" class="btn btn-primary" name="reset" value="Bestellen"/>
                </form>
            </center>

        </div>
    </body>
</html>
