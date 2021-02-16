
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

    <title>Welcome</title>

    <link href="${contextPath}/resources/css/bootstrap.min.css" rel="stylesheet">
</head>
<body>

<div class="container">
    <div class="row centered-form">
        <div class="col-xs-12 col-sm-8 col-md-4 col-sm-offset-2 col-md-offset-4" id="allRepairRequestContainer">
            <c:forEach items="${repairRequestsListOfUser}" var="repairRequest">
                <div class="panel panel-default">
                    <div class="panel-heading">
                        <h3 class="panel-title">All repair requests </h3>
                    </div>
                    <div class="panel-body">
                        <div class="row">
                            <div class="form-group">
                                <div class="list-group">
                                    <a href="#" class="list-group-item active">Repair
                                        description:${repairRequest.repairRequestDescription}</a>
                                    <a href="#" class="list-group-item ">Date:${repairRequest.dateOfRequest}</a>
                                    <a href="#" class="list-group-item active">Car:${repairRequest.carRemark}</a>
                                    <a href="#" class="list-group-item ">Status:${repairRequest.status}</a>

                                </div>
                                <hr>
                            </div>
                        </div>
                    </div>
                </div>
            </c:forEach>
        </div>
    </div>
</div>
<script src="https://ajax.googleapis.com/ajax/libs/jquery/1.11.2/jquery.min.js"></script>
<script src="${contextPath}/resources/js/bootstrap.min.js"></script>
</body>
</html>