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
    <title>List of Student</title>

</head>
<body>

</body>
<div class="container">
    <!--<div class="panel-heading"><span class="Lead">List of Employees</span></div> -->
    <div class ="jumbotron"> <center><h2>Ojt List  </h2></center></div>
    <table class="table table-dark table-striped table-hover">
        <thead class>
        <tr>

            <th>Name With initial</th>
            <th>Ojt Place</th>
            <th>Start Date</th>
            <th>Completion Date</th>

            <th width="100"></th>
            <th width="100"></th>

        </tr>
        </thead>

        <tbody>

        <c:forEach items="${ojtPlaceList}" var="stu">
            <tr>
                <td>${stu.studentid}</td>
                <td>${stu.ojtid}</td>
                <td>${stu.datejoint}</td>
                <td>${stu.completionDate}</td>

                <td><a href="<c:url value='/edit-ojtstudent-${stu.id}'/>" class="btn btn-warning">Edit</a>
                <td><a href="<c:url value='/delete-ojtstudent-${stu.id}'/>" class="btn btn-warning">Delete</a>
                </td>

                <td></td>
            </tr>
        </c:forEach>

        </tbody>
    </table>
    <div>

        <div class="panel">
            <a href ="<c:url value='/newstudent'/>" class="btn btn-primary btn-lg">Add New Student</a>

        </div>
    </div>


</div>
</html>
