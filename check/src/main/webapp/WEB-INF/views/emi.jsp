<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
<head>
    <meta charset="UTF-8">
    <title>EMI Schedule</title>
    <!-- Include Bootstrap CSS -->
    <link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/4.5.2/css/bootstrap.min.css">
</head>
<body>
    <div class="container">
        <h1>EMI Schedule</h1>

        <table class="table table-striped">
            <thead>
                <tr>
                    <th>Customer ID</th>
                    <th>EMI Amount</th>
                    <th>EMI Start Date</th>
                    <th>EMI End Date</th>
                </tr>
            </thead>
            <tbody>
                <c:forEach items="${loanList}" var="loan">
                    <c:if test="${loan.customerId == customerId}">
                        <!-- Calculate EMI schedules here -->
                        <c:set var="emiAmount" value="${loan.amount / loan.noOfMonths}" />
                        <c:set var="emiStartDate" value="${loan.applicationDate}" />
                        <c:set var="emiEndDate" value="${emiStartDate}" />
                        <c:forTokens items="1,2" var="emiIndex" delims=",">
                            <!-- Calculate EMI End Date -->
                            <c:set var="emiEndDate" value="${emiEndDate + 1}" />
                            <tr>
                                <td>${loan.customerId}</td>
                                <td>${emiAmount}</td>
                                <td>${emiStartDate}</td>
                                <td>${emiEndDate}</td>
                            </tr>
                        </c:forTokens>
                    </c:if>
                </c:forEach>
            </tbody>
        </table>
    </div>

    <!-- Include Bootstrap JavaScript and jQuery -->
    <script src="https://ajax.googleapis.com/ajax/libs/jquery/3.5.1/jquery.min.js"></script>
    <script src="https://cdnjs.cloudflare.com/ajax/libs/popper.js/1.16.0/umd/popper.min.js"></script>
    <script src="https://maxcdn.bootstrapcdn.com/bootstrap/4.5.2/js/bootstrap.min.js"></script>
</body>
</html>
