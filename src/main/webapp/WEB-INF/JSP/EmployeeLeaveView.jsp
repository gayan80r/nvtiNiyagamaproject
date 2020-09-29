<%@ taglib prefix="sform" uri="http://www.springframework.org/tags/form" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>

    <link href="webjars/bootstrap/3.3.6/css/bootstrap.min.css" rel="stylesheet"/>
    <%--    <link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/4.5.0/css/bootstrap.min.css">--%>
    <script src="https://ajax.googleapis.com/ajax/libs/jquery/3.5.1/jquery.min.js"></script>
    <script src="https://cdnjs.cloudflare.com/ajax/libs/popper.js/1.16.0/umd/popper.min.js"></script>
    <%--    <script src="https://maxcdn.bootstrapcdn.com/bootstrap/4.5.0/js/bootstrap.min.js"></script>--%>

</head>
<body>

</body>
<div class="container">
    <!--<div class="panel-heading"><span class="Lead">List of Employees</span></div> -->
    <div class ="jumbotron"> <center><h2>List of Employee</h2></center></div>
    <table class="table table-dark table-striped table-hover" id="leavetable">
        <thead class>
        <tr>

            <th>EPF No</th>
            <th>Start Date</th>
            <th>End Date</th>
            <th>Employee Leave Type</th>
            <th>Covering Employee</th>
            <th>Approved Employee</th>
            <th>Apply Date</th>



        </tr>
        </thead>

        <tbody>

        <c:forEach items="${employeeLeaveList}" var="empLeave">
            <tr>
                <td>${empLeave.epf_no}</td>
                <td>${empLeave.startdate}</td>
                <td>${empLeave.enddate}</td>
                <td>${empLeave.empleavetypeid}</td>
                <td>${empLeave.coveringEmployee}</td>
                <td>${empLeave.approvedEmployee}</td>
                <td>${empLeave.applydate}</td>

                <td><a href="<c:url value='/edit--${empLeave.id}'/>" class="btn btn-warning">Edit</a>
                <td><a href="<c:url value='/delete--${empLeave.id}'/>" class="btn btn-warning">Delete</a>
                </td>

                <td></td>
            </tr>
        </c:forEach>

        </tbody>
    </table>
    <div>

        <div class="panel">
            <a href ="<c:url value='/newemployeeleave'/>" class="btn btn-primary btn-lg">Add New Leave</a>

        </div>
    </div>


</div>
</html>
<%--<script>$(document).ready(function() {
    $('#coursetable').DataTable();
} );
</script>--%>

