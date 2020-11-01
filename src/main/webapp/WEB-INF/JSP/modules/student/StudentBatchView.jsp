
<%@ taglib prefix="sform" uri="http://www.springframework.org/tags/form" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <link href="webjars/bootstrap/3.3.6/css/bootstrap.min.css" rel="stylesheet"/>
    <link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/4.5.0/css/bootstrap.min.css">
    <link rel="stylesheet" href="http://cdn.datatables.net/1.10.22/css/jquery.dataTables.min.css">
    <script src="https://ajax.googleapis.com/ajax/libs/jquery/3.5.1/jquery.min.js"></script>
    <script src="https://cdnjs.cloudflare.com/ajax/libs/popper.js/1.16.0/umd/popper.min.js"></script>
    <script src="https://maxcdn.bootstrapcdn.com/bootstrap/4.5.0/js/bootstrap.min.js"></script>
    <script src="http://cdn.datatables.net/1.10.22/js/jquery.dataTables.min.js"></script>

    <title>List of course</title>

</head>
<body>

</body>
<div class="container">
    <!--<div class="panel-heading"><span class="Lead">List of Employees</span></div> -->
    <div class="jumbotron">
        <center><h2>List of Batchstudent </h2></center>
    </div>

    <div class="row">
    <table id="myTable" class="table table-dark table-striped table-hover">
        <thead class>
        <tr>

            <th>Date Joint</th>
            <th>Batch Name</th>
            <th>Student Name</th>


        </tr>
        </thead>

        <tbody>
            <tr>
<%--                <td>${batstu.datejoint}</td>--%>
<%--                <td>${batstu.batchid}</td>--%>
<%--                <td>${batstu.studentid}</td>--%>

<%--                <td><a href="<c:url value='/edit-studentbatch-${batstu.id}'/>" class="btn btn-warning">Edit</a>--%>
<%--                <td><a href="<c:url value='/delete-batch-${batstu.id}'/>" class="btn btn-warning">Delete</a>--%>
<%--                </td>--%>
<%--                <td></td>--%>
            </tr>

        </tbody>
    </table>
    </div>
    <div>

        <div class="panel">
            <a href="<c:url value='/newbatchstudent'/>" class="btn btn-primary btn-lg">Add New Batch Student</a>

        </div>
    </div>


</div>
</html>
<script>
    $(document).ready( function () {
        $('#myTable').DataTable();
    } );
</script>