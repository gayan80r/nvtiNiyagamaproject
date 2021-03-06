<%--
  Created by IntelliJ IDEA.
  User: Administrator
  Date: 7/24/2020
  Time: 10:13 AM
  To change this template use File | Settings | File Templates.
--%>

<%@ taglib prefix="sform" uri="http://www.springframework.org/tags/form" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html xmlns="http://www.w3.org/1999/xhtml"
      xmlns:th="http://www.thymeleaf.org">
<head>
    <link href="webjars/bootstrap/3.3.6/css/bootstrap.min.css" rel ="stylesheet"/>
    <link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/4.5.0/css/bootstrap.min.css">
    <script src="https://ajax.googleapis.com/ajax/libs/jquery/3.5.1/jquery.min.js"></script>
    <script src="https://cdnjs.cloudflare.com/ajax/libs/popper.js/1.16.0/umd/popper.min.js"></script>
    <script src="https://maxcdn.bootstrapcdn.com/bootstrap/4.5.0/js/bootstrap.min.js"></script>


    <script src="https://ajax.googleapis.com/ajax/libs/jquery/3.1.1/jquery.min.js"></script>
    <script src="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.7/js/bootstrap.min.js"></script>
    <link rel="stylesheet" href="https://cdn.datatables.net/1.10.12/css/jquery.dataTables.min.css">
    <script src="https://cdn.datatables.net/1.10.12/js/jquery.dataTables.min.js"></script>
    <script src="/js/datatable.js"></script>
    <title>List of Employees</title>

</head>
<body>

</body>
<div class="container">
    <!--<div class="panel-heading"><span class="Lead">List of Employees</span></div> -->
    <div class ="jumbotron"> <center><h2>List of OJT Place</h2></center></div>
    <table class="table table-dark table-striped table-hover" id="OJTPlaceTable">
        <thead class>
        <tr>

            <th>ojt Place Name</th>
            <th>Contact Person Name</th>
            <th>Email</th>
            <th>Land Line Phone</th>
            <th>Mobile</th>
            <th>City</th>
            <th width="100"></th>
            <th width="100"></th>

        </tr>
        </thead>

        <tbody>

        <c:forEach items="${ojtplaceList}" var="ojtp">
            <tr>
                <td>${ojtp.name}</td>
                <td>${ojtp.contactperson}</td>
                <td>${ojtp.email}</td>
                <td>${ojtp.landline}</td>
                <td>${ojtp.mobile}</td>
                <td>${ojtp.city}</td>

                <td><a href="<c:url value='/edit-ojtPlace-${ojtp.id}'/>" class="btn btn-warning">Edit</a>
                <td><a href="<c:url value='/delete-ojtPlace-${ojtp.id}'/>" class="btn btn-warning">Delete</a>
                </td>

                <td></td>
            </tr>
        </c:forEach>

        </tbody>
    </table>
    <div>

        <div class="panel">
            <a href ="<c:url value='/newojtplace'/>" class="btn btn-primary btn-lg">Add New OJT Place</a>

        </div>
    </div>


</div>
</html>

