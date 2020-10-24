
<%@ taglib prefix="sform" uri="http://www.springframework.org/tags/form" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <link href="webjars/bootstrap/3.3.6/css/bootstrap.min.css" rel="stylesheet"/>
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
    <div class="jumbotron">
        <center><h2>List of Batchstudent </h2></center>
    </div>
    <div class="row">
        <div class ="jumbotron"> <center><h1>Batch Registration Form</h1></center></div>
        <!- we used the modelAttribute pass value view to controler->
        <sform:form method="post" id="batchform" modelAttribute="batch">

            <div class="row">
                <div class="form-group col-md-12">
                    <label class="col-md-3 control-lable" for="name">Batch Name</label>
                    <div class="col-md-9">
                        <sform:input type="text" path="name" id="name"
                                     class="form-control input-sm"></sform:input>
                        <div class="has-error">
                            <sform:errors path="name" class="help-inline"/>
                        </div>
                    </div>
                </div>
            </div>


            <div class="row">
                <div class="form-group col-md-12">
                    <label class="col-md-3 control-lable" for="start_date">Start Date</label>
                    <div class="col-md-9">
                        <sform:input type="date" path="start_date" id="start_date"
                                     class="form-control input-sm"></sform:input>
                        <div class="has-error">
                            <sform:errors path="start_date" class="help-inline"/>
                        </div>
                    </div>
                </div>
            </div>

            <div class="row">
                <div class="form-group col-md-12">
                    <label class="col-md-3 control-lable" for="end_date">End Date</label>
                    <div class="col-md-9">
                        <sform:input type="date" path="end_date" id="EndDateSeleter"
                                     class="form-control input-sm"></sform:input>
                        <div class="has-error">
                            <sform:errors path="end_date" class="help-inline"/>
                        </div>
                    </div>
                </div>
            </div>

            <div class="row">
                <div class="form-group col-md-12">

                    <label class="col-md-3 control-lable" for="courseid">Course</label>
                    <div class="col-md-9">

                        <sform:select path="courseid"  multiple="false"  id="coursedSelecter"

                                      itemLabel="name" class="form-control input-sm" />

                        <div class="has-error">
                            <sform:errors path="courseid" class="help-inline"/>
                        </div>

                    </div>
                </div>
            </div>

            <div class="row">
                <div class="form-group col-md-12">

                    <div class="col-md-9">
                        <c:choose>
                            <c:when test="${edit}">
                                <input type="submit" value="Update" id="updatesubmit" class="btn btn-primary btn-lg"/>
                                <!--<a href="<c:url value='/' />">Cancel</a> -->
                                <input type="submit" value="cancel" class="btn btn-primary btn-lg"/>

                            </c:when>
                            <c:otherwise>
                                <input type="submit" value="Save" id="submitbutton" class="btn btn-primary btn-lg"/>
                                <input type="submit" value="cancel" class="btn btn-primary btn-lg"/>

                                <!-- <a href="<c:url value='/' />">Cancel</a> -->
                            </c:otherwise>
                        </c:choose>

                    </div>
                </div>
            </div>

        </sform:form>
    </div>
    <div class="row">
    <table class="table table-dark table-striped table-hover">
        <thead class>
        <tr>

            <th>Date Joint</th>
            <th>Batch Name</th>
            <th>Student Name</th>


        </tr>
        </thead>

        <tbody>

        <c:forEach items="${studentBatchList}" var="batstu">
            <tr>
                <td>${batstu.datejoint}</td>
                <td>${batstu.batchid}</td>
                <td>${batstu.studentid}</td>

                <td><a href="<c:url value='/edit-studentbatch-${batstu.id}'/>" class="btn btn-warning">Edit</a>
                <td><a href="<c:url value='/delete-batch-${batstu.id}'/>" class="btn btn-warning">Delete</a>
                </td>

                <td></td>
            </tr>
        </c:forEach>

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
