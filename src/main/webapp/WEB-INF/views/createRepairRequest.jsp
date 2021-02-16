<%@ taglib prefix="spring" uri="http://www.springframework.org/tags" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>

<c:set var="contextPath" value="${pageContext.request.contextPath}"/>

<!DOCTYPE html>
<html lang="en">
<head>
    <meta charset="utf-8">
    <meta http-equiv="X-UA-Compatible" content="IE=edge">
    <meta name="viewport" content="width=device-width, initial-scale=1">
    <meta name="description" content="">
    <meta name="author" content="">

    <title>Create a repair request</title>

    <link href="${contextPath}/resources/css/bootstrap.min.css" rel="stylesheet">
    <link href="${contextPath}/resources/css/common.css" rel="stylesheet">


    <script src="https://oss.maxcdn.com/html5shiv/3.7.2/html5shiv.min.js"></script>
    <script src="https://oss.maxcdn.com/respond/1.4.2/respond.min.js"></script>

</head>

<body>

<div class="container">

    <form:form method="POST" modelAttribute="repairRequestForm" class="form-createRepairRequest">
        <h2 class="form-createRepairRequest-heading">Create your repair request</h2>
        <span>${message}</span>
        <spring:bind path="dateOfRequest">
            <div class="form-group ${status.error ? 'has-error' : ''}">
                <form:input type="date" path="dateOfRequest" class="form-control" placeholder="Date"
                            autofocus="true"></form:input>
                <form:errors path="dateOfRequest"></form:errors>
            </div>
        </spring:bind>

        <spring:bind path="carRemark">
            <div class="form-group ${status.error ? 'has-error' : ''}">
                <form:input type="text" path="carRemark" class="form-control"
                            placeholder=" write car remark"></form:input>
                <form:errors path="carRemark"></form:errors>
            </div>
        </spring:bind>

        <spring:bind path="repairRequestDescription">
            <div class="form-group ${status.error ? 'has-error' : ''}">
                <form:input type="text" path="repairRequestDescription" class="form-control" placeholder="request description"
                            autofocus="true"></form:input>
                <form:errors path="repairRequestDescription"></form:errors>
            </div>
        </spring:bind>


        <button class="btn btn-lg btn-primary btn-block" type="submit">Send request</button>
    </form:form>

</div>
<!-- /container -->
<script src="https://ajax.googleapis.com/ajax/libs/jquery/1.11.2/jquery.min.js"></script>
<script src="${contextPath}/resources/js/bootstrap.min.js"></script>
</body>
</html>