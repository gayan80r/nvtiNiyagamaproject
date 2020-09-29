<%@ taglib prefix="sform" uri="http://www.springframework.org/tags/form" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html xmlns="http://www.w3.org/1999/xhtml"
      xmlns:th="http://www.thymeleaf.org">
<head>
    <link href="webjars/bootstrap/3.3.6/css/bootstrap.min.css" rel="stylesheet"/>
    <link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/4.5.0/css/bootstrap.min.css">
    <script src="https://ajax.googleapis.com/ajax/libs/jquery/3.5.1/jquery.min.js"></script>
    <script src="https://cdnjs.cloudflare.com/ajax/libs/popper.js/1.16.0/umd/popper.min.js"></script>
    <script src="https://maxcdn.bootstrapcdn.com/bootstrap/4.5.0/js/bootstrap.min.js"></script>
    <script src="/js/datatable.js"></script>
    <title>List of Employees</title>

</head>
<body>

</body>
<div class="container">
    <!--<div class="panel-heading"><span class="Lead">List of Employees</span></div> -->
    <div class ="jumbotron"> <center><h2>List of Employees</h2></center></div>
    <table class="table table-dark table-striped table-hover" id="accessorTable">
        <thead class>
        <tr>

            <th> Name With Initial</th>

             <th>NIC</th>
            <th>Mobile</th>
            <th>City</th>
            <th>Email</th>
            <th>Bank Account No</th>
            <th width="100"></th>
            <th width="100"></th>

        </tr>
        </thead>

        <tbody>

        <c:forEach items="${accessorList}" var="acc">
            <tr>
                <td>${acc.namewithinitial}</td>
                <td>${acc.nic}</td>
                <td>${acc.mobile}</td>
                <td>${acc.city}</td>
                <td>${acc.email}</td>
                <td>${acc.bankaccountno}</td>
                <td><a href="<c:url value='/edit-accessor-${acc.id}'/>" class="btn btn-warning">Edit</a>
                <td><a href="<c:url value='/delete-accessor-${acc.id}'/>" class="btn btn-warning">Delete</a>
                </td>

                <td></td>
            </tr>
        </c:forEach>

        </tbody>
    </table>
    <div>

        <div class="panel">
            <a href ="<c:url value='/newaccessor'/>" class="btn btn-primary btn-lg">Add New Employee</a>

        </div>
    </div>


</div>
</html>

