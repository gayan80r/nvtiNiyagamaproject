
<%@ taglib prefix="sform" uri="http://www.springframework.org/tags/form" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>

<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Title</title>
    <script src="webjars/jquery/1.9.1/jquery.min.js"></script>

    <link href="webjars/bootstrap/3.3.6/css/bootstrap.min.css" rel ="stylesheet"/>
    <link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/4.5.0/css/bootstrap.min.css">

    <script src="https://cdnjs.cloudflare.com/ajax/libs/popper.js/1.16.0/umd/popper.min.js"></script>
    <script src="https://maxcdn.bootstrapcdn.com/bootstrap/4.5.0/js/bootstrap.min.js"></script>

    <link href="https://cdn.jsdelivr.net/npm/select2@4.1.0-beta.1/dist/css/select2.min.css" rel="stylesheet" />
    <script src="https://cdn.jsdelivr.net/npm/select2@4.1.0-beta.1/dist/js/select2.min.js"></script>
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

<div class="container">
    <div class ="jumbotron"> <center><h1>Student Batch Registration Form</h1></center></div>
    <!- we used the modelAttribute pass value view to controler->
    <sform:form method="post" id="studentbatchform" modelAttribute="studentBatch">
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
                <label class="col-md-3 control-lable" for="datejoint">Date of Joint</label>
                <div class="col-md-9">
                    <sform:input type="date" path="datejoint" id="doj"
                                 class="form-control input-sm"></sform:input>
                    <div class="has-error">
                        <sform:errors path="datejoint" class="help-inline"/>
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
</body>

<script>

    $( document ).ready(function() {

        $("#submitbutton,#updatesubmit").click(function(event){

            event.preventDefault();
            //var status = validatestudentBatch();

            if(status){

                $("#studentbatchform").unbind('submit').submit();
            }

        })

</script>

<script>

    $(document).ready(function () {
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



</html>
