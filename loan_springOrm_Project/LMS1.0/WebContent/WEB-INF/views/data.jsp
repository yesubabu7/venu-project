<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ page import="base.models.*" %>
<%@ page import="java.util.List" %>

<!DOCTYPE html>
<html>
<head>
    <meta charset="UTF-8">
    <title>Customer Details</title>
    <!-- Include Bootstrap CSS -->
    <link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/4.5.2/css/bootstrap.min.css">
</head>
<body>
    <div class="container">
        <h2 class="mt-5">Customer Details</h2>
        
        <c:set var="loanApplicationForm" value="${requestScope.loanApplicationForm}" />
        <c:set var="loanList" value="${requestScope.loanList}" />
        
         <div class="mt-3">
        <label for="emiRangeFilter">Filter by EMI Range:</label>
        <input type="text" id="emiRangeFilter" class="form-control" placeholder="Enter EMI Range" onkeyup="filterTable()">
    </div>
        
        <div class="card mt-3">
            <div class="card-body">
                <h5 class="card-title">Customer Information</h5>
                <p class="card-text"><strong>First Name:</strong> ${loanApplicationForm.firstname}</p>
                <p class="card-text"><strong>Last Name:</strong> ${loanApplicationForm.lastname}</p>
                <p class="card-text"><strong>PAN Number:</strong> ${loanApplicationForm.pan}</p>
                <p class="card-text"><strong>Nominee Relation:</strong> ${loanApplicationForm.nomineerelation}</p>
                <p class="card-text"><strong>CIBIL Score:</strong> ${requestScope.cibilScore}</p>
                <p class="card-text"><strong>Status:</strong> ${requestScope.status}</p>
            </div>
        </div>

        <h5 class="mt-5">Loan Applicants</h5>
        <table class="table table-bordered mt-3">
            <thead class="thead-dark">
                <tr>
                    <th>Applicant ID</th>
                    <th>Amount</th>
                    <th>EMI Range</th>
                    <th>Nominee Requested</th>
                    <th>Action</th>
                </tr>
            </thead>
            <tbody>
                <c:forEach items="${loanList}" var="loanApplicant">
                    <tr>
                        <td>${loanApplicant.id}</td>
                        <td>${loanApplicant.amount}</td>
                        <td>${loanApplicant.emiRangeFrom} - ${loanApplicant.emiRangeTo}</td>
                        <td>${loanApplicant.nominatedAmount}</td>
                        <td>
                            <button type="button" class="btn btn-info" data-toggle="collapse" data-target="#details-${loanApplicant.id}">
                                View Details
                            </button>
                        </td>
                    </tr>
                    <tr>
                        <td colspan="5" class="collapse" id="details-${loanApplicant.id}">
                            <!-- Details content here -->
                            <p><strong>Applicant ID:</strong> ${loanApplicant.id}</p>
                            <p><strong>Amount:</strong> ${loanApplicant.amount}</p>
                            <p><strong>No Of Months:</strong> ${loanApplicant.noOfMonths}</p>
                            
                            <p><strong>Emi-Range:</strong> ${loanApplicant.emiRangeFrom} - ${loanApplicant.emiRangeTo}</p>
                            <p><strong>No. of Amount:</strong> ${loanApplicant.nominatedAmount}</p>
                            <p><strong>Processed ID:</strong> ${loanApplicant.processedUserId}</p>
                            
                            <form action="acceptOrReject" method="post">
                                <input type="hidden" name="applicantId" value="${loanApplicant.id}">
                                <button type="submit" name="action" value="Accept" class="btn btn-success">Accept</button>
                                <button type="submit" name="action" value="Reject" class="btn btn-danger">Reject</button>
                            </form>
                        </td>
                    </tr>
                </c:forEach>
            </tbody>
        </table>
    </div>

    <!-- Include Bootstrap JavaScript and jQuery -->
    <script src="https://ajax.googleapis.com/ajax/libs/jquery/3.5.1/jquery.min.js"></script>
    <script src="https://cdnjs.cloudflare.com/ajax/libs/popper.js/1.16.0/umd/popper.min.js"></script>
    
    <script src="https://maxcdn.bootstrapcdn.com/bootstrap/4.5.2/js/bootstrap.min.js"></script>
    <script>
    // Filter the table based on EMI range input
    function filterTable() {
        var input, filter, table, tr, td, i, txtValue;
        input = document.getElementById("emiRangeFilter");
        filter = input.value.toUpperCase();
        table = document.querySelector(".table");
        tr = table.getElementsByTagName("tr");
        
        // Loop through all table rows
        for (i = 1; i < tr.length; i += 2) { // Skip details rows
            td = tr[i].getElementsByTagName("td")[2]; // Assuming EMI range is in the third column
            
            if (td) {
                txtValue = td.textContent || td.innerText;
                
                // If the EMI range includes the filter text, display the row; otherwise, hide it
                if (txtValue.toUpperCase().indexOf(filter) > -1) {
                    tr[i - 1].style.display = ""; // Show corresponding details row
                    tr[i].style.display = ""; // Show data row
                } else {
                    tr[i - 1].style.display = "none"; // Hide corresponding details row
                    tr[i].style.display = "none"; // Hide data row
                }
            }
        }
    }
</script>
</body>
</html>
