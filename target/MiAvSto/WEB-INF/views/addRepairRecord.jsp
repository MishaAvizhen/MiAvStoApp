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

    <title>Create a repair record</title>

    <link href="${contextPath}/resources/css/bootstrap.min.css" rel="stylesheet">
    <link href="${contextPath}/resources/css/common.css" rel="stylesheet">


    <script src="https://oss.maxcdn.com/html5shiv/3.7.2/html5shiv.min.js"></script>
    <script src="https://oss.maxcdn.com/respond/1.4.2/respond.min.js"></script>

</head>

<body>

<div class="container">

    <form:form method="POST" modelAttribute="repairRecordForm" class="form-createRepairRecord">
        <h2 class="form-createRepairRecord-heading">Create your repair record</h2>
        <span>${message}</span>


        <spring:bind path="repairRecordDescription">
            <div class="form-group ${status.error ? 'has-error' : ''}">
                <form:input type="text" path="repairRecordDescription" class="form-control" id="repairRecordDescription"
                            placeholder="repair record description" autofocus="true"></form:input>
                <form:errors path="repairRecordDescription"></form:errors>
            </div>
        </spring:bind>

        <spring:bind path="detailPrice">
            <div class="form-group ${status.error ? 'has-error' : ''}">
                <form:input type="text" path="detailPrice" class="form-control" id="detailPrice"
                            placeholder="detail price" autofocus="true"></form:input>
                <form:errors path="detailPrice"></form:errors>
            </div>
        </spring:bind>

        <spring:bind path="workPrice">
            <div class="form-group ${status.error ? 'has-error' : ''}">
                <form:input type="text" path="workPrice" class="form-control" id="workPrice"
                            placeholder="work price" autofocus="true"></form:input>
                <form:errors path="workPrice"></form:errors>
            </div>
        </spring:bind>

        <spring:bind path="otherNotes">
            <div class="form-group ${status.error ? 'has-error' : ''}">
                <form:input type="text" path="otherNotes" class="form-control" id="otherNotes"
                            placeholder="other notes" autofocus="true"></form:input>
                <form:errors path="otherNotes"></form:errors>
            </div>
        </spring:bind>

        <button class="btn btn-lg btn-primary btn-block" type="submit">Add record</button>
    </form:form>

</div>
<!-- /container -->
<script src="https://ajax.googleapis.com/ajax/libs/jquery/1.11.2/jquery.min.js"></script>
<script src="${contextPath}/resources/js/bootstrap.min.js"></script>
</body>
</html>