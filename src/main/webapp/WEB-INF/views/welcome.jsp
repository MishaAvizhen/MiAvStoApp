<%@ taglib prefix="spring" uri="http://www.springframework.org/tags" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>

<c:set var="contextPath" value="${pageContext.request.contextPath}"/>

<!DOCTYPE html>
<html lang="en">
<head>
    <meta charset="utf-8">
    <meta http-equiv="X-UA-Compatible" content="IE=edge">
    <meta name="viewport" content="width=device-width, initial-scale=1">
    <meta name="description" content="">
    <meta name="author" content="">

    <script src="https://cdn.jsdelivr.net/npm/@popperjs/core@2.6.0/dist/umd/popper.min.js"
            integrity="sha384-KsvD1yqQ1/1+IA7gi3P0tyJcT3vR+NdBTt13hSJ2lnve8agRGXTTyNaBYmCR/Nwi"
            crossorigin="anonymous"></script>
    <script src="https://cdn.jsdelivr.net/npm/bootstrap@5.0.0-beta2/dist/js/bootstrap.min.js"
            integrity="sha384-nsg8ua9HAw1y0W1btsyWgBklPnCUAFLuTMS2G72MMONqmOymq585AcH49TLBQObG"
            crossorigin="anonymous"></script>
    <link href="//netdna.bootstrapcdn.com/bootstrap/3.0.0/css/bootstrap-glyphicons.css" rel="stylesheet">

    <title>Service Station</title>

    <link href="${contextPath}/resources/css/bootstrap.min.css" rel="stylesheet">
</head>
<body>

<div class="navbar navbar-inverse navbar-fixed-top">
    <div class="container-fluid">
        <div class="navbar-header">
            <a class="navbar-brand" href="#">MiAvSto</a>
        </div>
        <ul class="nav navbar-nav">
            <li class="active"><a href="#">Home</a></li>
            <li class="dropdown"><a class="dropdown-toggle" data-toggle="dropdown" href="#">Page 1 <span
                    class="caret"></span></a>
                <ul class="dropdown-menu">
                    <li><a href="#">Page 1-1</a></li>
                    <li><a href="#">Page 1-2</a></li>
                    <li><a href="#">Page 1-3</a></li>
                </ul>
            </li>
            <li><a href="#">Page 2</a></li>
        </ul>
        <ul class="nav navbar-nav navbar-right">
            <c:if test="${pageContext.request.userPrincipal.name != null}">
                <li><a href="/" class="glyphicon glyphicon-user" style="color:rgb(7, 246, 184 );">
                    Welcome ${pageContext.request.userPrincipal.name}</a></li>
                <li><a href="/login" class="glyphicon glyphicon-log-out" style="color:rgb(32, 234, 69 );"> logout</a>
                </li>
            </c:if>
        </ul>
    </div>
</div>
<div class="jumbotron">
    <div class="container">
        <div class="col-md-8 col-lg-9">
            <br>
            <p>AvizhenSTO bla bla bla main</p>
            <p><a href="#" class="btn btn-primary"> Learn more &raquo;</a></p>
        </div>
        <div class="col-md-4 col-lg-3">
            <br>
            <p>Backend info: ${message}</p>
        </div>
    </div>
</div>

<div class="container">
    <div class="row">
        <div class="col-md-6">
            <h3>Title 1</h3>
            <p>AvizhenSTO bla bla bla</p>

            <p><a href="#" class="btn btn-info"> Learn more &raquo;</a></p>
        </div>
        <div class="col-md-6">
            <h3>Title 2</h3>
            <p>AvizhenSTO bla bla bla</p>
            <p><a href="#" class="btn btn-warning"> Learn more &raquo;</a></p>
        </div>
    </div>
</div>

<hr>
<footer>
    <p>&copy; All rights reserved 2020</p>
</footer>

<script src="https://ajax.googleapis.com/ajax/libs/jquery/1.11.2/jquery.min.js"></script>
<script src="${contextPath}/resources/js/bootstrap.min.js"></script>
</body>
</html>

