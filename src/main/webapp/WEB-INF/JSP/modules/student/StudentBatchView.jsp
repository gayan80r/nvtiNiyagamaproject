
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
    <style>
        body{
            margin: 0;
            font-size: medium;
            font-weight: 400;
            line-height: 1.6;
            color: #212529;
            text-align: left;
            background-color: #f5f8fa;
        }

        input[type=text], [type=date] {
            width: 100%;
            padding: 15px;
            margin: 5px 0 22px 0;
            display: inline-block;
            border: none;
            font-size: medium;
            background:lightblue ;
        }


    </style>
</head>
<body>

</body>
<div class="container">



        <div class ="jumbotron"> <center><h1>Student Batch List Form</h1></center></div>
        <!- we used the modelAttribute pass value view to controler->
        <sform:form method="post" id="studentbatchListform" modelAttribute="studentBatch">
            <div class="row">
                <div class="form-group col-md-12">

                    <label class="col-md-3 control-lable" for="id" >Year</label>
                    <div class="col-md-9">
                        <sform:select path="id" items="${yearList}" multiple="false" itemValue="id" id="yearIdSeleter"

                                      itemLabel="name" class="form-control input-sm" >
                            <sform:option value="" label="--Please Select"/>
                        </sform:select>
                        <div class="has-error">
                            <sform:errors path="id" class="help-inline"/>
                        </div>

                    </div>
                </div>
            </div>

            <div class="row">
                <div class="form-group col-md-12">

                    <label class="col-md-3 control-lable" for="batchid">Batch Name</label>
                    <div class="col-md-9">
                        <sform:select path="batchid"  multiple="false"  id="batchIdSelecter"

                                      itemLabel="name" class="form-control input-sm" />
                        <div class="has-error">
                            <sform:errors path="batchid" class="help-inline"/>
                        </div>

                    </div>
                </div>
            </div>



            <div class="row">
                <div class="form-group col-md-12">

                    <label class="col-md-3 control-lable" for="studentid">Student Name</label>
                    <div class="col-md-9">
                        <sform:select path="studentid"  multiple="false" id="studentIdSelecter"

                                      itemLabel="name" class="js-example-basic-single form-control input-sm" />
                        <div class="has-error">
                            <sform:errors path="studentid" class="help-inline"/>
                        </div>

                    </div>
                </div>
            </div>





            <div class="row">
                <div class="form-group col-md-12">

                    <div class="col-md-9">

                        <input type="submit" value="Search" id="submitbutton" class="btn btn-primary btn-lg"/>
                    </div>
                </div>
            </div>

        </sform:form>

    <!--<div class="panel-heading"><span class="Lead">List of Employees</span></div> -->
    <div class="jumbotron">
        <center><h2>List of Batch student </h2></center>
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


    </div>


</div>
</html>

<script>

    $(document).ready(function () {
        $('#myTable').DataTable();
        $('.js-example-basic-single').select2();


        //$("#batchIdSelecter").change(function () {
        //var value = $("#yearIdSeleter").val();

        $.ajax({
            type: 'GET',
            //url: '/api/retrivestudent/'+value,
            url: '/api/retrivestudent',
            data: '',
            dataType: "json",
            success: function (data) {

                $("#studentIdSelecter").html('');
                var itrms='<option value="0"></option>';
                $.each(data, function (key, value)  {
                    itrms=itrms+'<option value="'+value.id+'">'+value.name+'</option>';
                });
                $("#studentIdSelecter").html(itrms);
            }
        });



        //});


        $("#yearIdSeleter").change(function () {
            var value = $("#yearIdSeleter").val();

            $.ajax({
                type: 'GET',
                url: '/api/retrivebatch/'+value,
                data: '',
                dataType: "json",
                success: function (data) {

                    $("#batchIdSelecter").html('');
                    var itrms='<option value="0"></option>';
                    $.each(data, function (key, value)  {
                        itrms=itrms+'<option value="'+value.id+'">'+value.name+'</option>';
                    });
                    $("#batchIdSelecter").html(itrms);
                }
            });



        });

    });
</script>