<%-- 
    Document   : bookJsp
    Created on : 19.11.2019, 13:51:40
    Author     : annalechner
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <meta name="viewport" content="width=device-width, initial-scale=1">
        <link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/3.4.0/css/bootstrap.min.css">
        <script src="https://ajax.googleapis.com/ajax/libs/jquery/3.4.1/jquery.min.js"></script>
        <script src="https://maxcdn.bootstrapcdn.com/bootstrap/3.4.0/js/bootstrap.min.js"></script>
        <title>Order Now!</title>
        <script>
            $(document).ready(function () {
                $("#myInput").on("keyup", function () {
                    var value = $(this).val().toLowerCase();
                    $("#myTable tr").filter(function () {
                        $(this).toggle($(this).text().toLowerCase().indexOf(value) > -1)
                    });
                });
            });
        </script>
        <style>
            .container{
                width: 900px;
            }
            body {
                /*position: relative;*/
                z-index: 1;
            }

            body:before {
                content: "";
                position: absolute;
                z-index: -1;
                top: 0;
                bottom: 0;
                left: 0;
                right: 0;
                background: url("images/library.jpg") center center;
                opacity: .2;
            }
            #myInput{
                width: 500px;
            }
            .btn-group-toggle{
                color: black;
            }
        </style>
    </head>
    <body>
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
            <table class="table table-hover">
                <thead>
                    <tr>
                        <th scope="col">Titel</th>
                        <th scope="col">Autor(en)</th>
                        <th scope="col">Preis</th>
                        <th scope="col">Handle</th>
                    </tr>
                </thead>
                <tbody>
                    <tr>
                        <th scope="row">1</th>
                        <td>Mark</td>
                        <td>Otto</td>
                        <td>@mdo</td>
                    </tr>
                </tbody>
            </table>
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
    </body>
</html>
