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
        <link href="style/style.css" rel="stylesheet" type="text/css"/>
        <script src="scripts/script.js" type="text/javascript"></script>
        <title>Order Now!</title>
    </head>
    <body><center>
        <div class="container">
            <center><h1>Bookshop Luna Krochner</h1></center>
            <div class="btn-group btn-group-toggle" data-toggle="buttons">
                <label class="btn btn-secondary active">
                    <input type="radio" name="options" id="option1" autocomplete="off" checked> Titel
                </label>
                <label class="btn btn-secondary">
                    <input type="radio" name="options" id="option2" autocomplete="off"> Autor
                </label>
            </div>
            <input class="form-control" id="myInput" type="text" placeholder="Filter...">
            <table class="table table-hover table-scroll">
                <thead>
                    <tr>
                        <th scope="col">Titel</th>
                        <th scope="col">Autor(en)</th>
                        <th scope="col">Preis</th>
                        <th scope="col">Handle</th>
                    </tr>
                </thead>
                <tbody>
                    <c:forEach var="item" items="${books}">
                    <tr>
                        <td>${item.title}</td>
                        <td><c:forEach var="author" items ="${item.authors}">${author.firstname} ${author.lastname}</br><a href="#">${author.url}</a></br></c:forEach></td>
                        <td>${item.publisher.name}</td>
                        <td>${item.publisher.url}</td>
                        <td>@mdo</td>
                    </tr></c:forEach>
                        private String title;
    private String url;
    private double price;
    private Publisher publisher;
    private String isbn;
    private List<Author> authors = new ArrayList<>();

                </tbody>
            </table>
</div>
            <label>Sortieren nach:</label>
            <div class="form-check">
                <input type="checkbox" class="form-check-input" id="sortCheck1">
                <label class="form-check-label" for="sortCheck1">Titel</label>
                <input type="checkbox" class="form-check-input" id="sortCheck2">
                <label class="form-check-label" for="sortCheck2">Autor(en)</label>
                <input type="checkbox" class="form-check-input" id="sortCheck3">
                <label class="form-check-label" for="sortCheck3">Preis</label>
            </div>
        </div>
    </center>
    </body>
</html>
