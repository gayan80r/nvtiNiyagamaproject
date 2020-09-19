<%@ taglib prefix="sform" uri="http://www.springframework.org/tags/form" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <link href="webjars/bootstrap/3.3.6/css/bootstrap.min.css" rel ="stylesheet"/>
    <link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/4.5.0/css/bootstrap.min.css">
    <script src="https://ajax.googleapis.com/ajax/libs/jquery/3.5.1/jquery.min.js"></script>
    <script src="https://cdnjs.cloudflare.com/ajax/libs/popper.js/1.16.0/umd/popper.min.js"></script>
    <script src="https://maxcdn.bootstrapcdn.com/bootstrap/4.5.0/js/bootstrap.min.js"></script>
    <title>List of course</title>

</head>
<body>

</body>
<div class="container">
    <!--<div class="panel-heading"><span class="Lead">List of Employees</span></div> -->
    <div class ="jumbotron"> <center><h2>List of course</h2></center></div>
    <table class="table table-dark table-striped table-hover">
        <thead class>
        <tr>

            <th>Module Name</th>
            <th>Duration</th>
            <th>Course </th>
            <th>Semister </th>



        </tr>
        </thead>

        <tbody>

        <c:forEach items="${moduleList}" var="modu">
            <tr>
                <td>${modu.name}</td>

                <td>${modu.timeduration}</td>

                <td>${modu.courseId}</td>
                <td>${modu.semesterId}</td>u

                <td><a href="<c:url value='/edit-module-${modu.id}'/>" class="btn btn-warning">Edit</a>
                <td><a href="<c:url value='/delete-module-${modu.id}'/>" class="btn btn-warning">Delete</a>
                </td>

                <td></td>
            </tr>
        </c:forEach>

        </tbody>
    </table>
    <div>

        <div class="panel">
            <a href ="<c:url value='/newmodule'/>" class="btn btn-primary btn-lg">Add New Module</a>

        </div>
    </div>


</div>
</html>
