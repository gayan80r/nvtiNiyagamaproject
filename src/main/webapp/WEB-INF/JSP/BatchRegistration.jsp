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
</body>

<script>

    $( document ).ready(function() {

        $("#submitbutton,#updatesubmit").click(function(event){

            event.preventDefault();
            var status = validateCourse();

            if(status){

                $("#batchform").unbind('submit').submit();
            }
        });

       /* $.ajax({
            type: 'GET',
            //url: '/api/retrivestudent/'+value,
            url: '/api/retrivecourse',
            data: '',
            dataType: "json",
            success: function (data) {

                $("#coursedSelecter").html('');
                var itrms='<option value="0"></option>';
                $.each(data, function (key, value)  {
                    itrms=itrms+'<option value="'+value.id+'">'+value.name+'</option>';
                });
                $("#coursedSelecter").html(itrms);
            }
        });*/
        $("#EndDateSeleter").change(function () {
            //var value = $("#EndDateSeleter").val();

            $.ajax({
                type: 'GET',
                //url: '/api/retrivestudent/'+value,
                url: '/api/retrivecourse',
                data: '',
                dataType: "json",
                success: function (data) {

                    $("#coursedSelecter").html('');
                    var itrms='<option value="0"></option>';
                    $.each(data, function (key, value)  {
                        itrms=itrms+'<option value="'+value.id+'">'+value.name+'</option>';
                    });
                    $("#coursedSelecter").html(itrms);
                }
            });



        });
        function validateCourse(){

            var Name   =    $('#name').val();
            var start_date = $('#start_date').val();
            var end_date = $('#end_date').val();

            var status = true;

            if(Name.length < 3){

                $('#name').after("<Span>Please enter a valid name from jquery</Span>");
                status = false;
            }
            return status;
        }});

</script>


</html>

