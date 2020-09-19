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
    <div class ="jumbotron"> <center><h1>Employee Traing Registration Form</h1></center></div>
<%--     we used the modelAttribute pass value view to controler--%>
    <sform:form method="post" id="employeetrainningform" modelAttribute="employeeTrainingDetails">


        <div class="row">
            <div class="form-group col-md-12">

                <label class="col-md-3 control-lable" for="empid"> Name with Initial</label>
                <div class="col-md-9">
<%--                  this {empList} from the   model.addAttribute("empList", empList) --%>
                    <sform:select path="empid" items="${empList}" multiple="false" itemValue="id"

                                  itemLabel="name_with_initial" class="form-control input-sm" />
                    <div class="has-error">
                        <sform:errors path="empid" class="help-inline"/>
                    </div>

                </div>
            </div>
        </div>

        <div class="row">
            <div class="form-group col-md-12">

                <label class="col-md-3 control-lable" for="emptraid"> Name Of The Trainning</label>
                <div class="col-md-9">
                    <sform:select path="emptraid" items="${trainingList}" multiple="false" itemValue="id"

                                  itemLabel="name" class="form-control input-sm" />
                    <div class="has-error">
                        <sform:errors path="emptraid" class="help-inline"/>
                    </div>

                </div>
            </div>
        </div>


        <div class="row">
            <div class="form-group col-md-12">
                <label class="col-md-3 control-lable" for="datecomplete">Date of completed</label>
                <div class="col-md-9">
                    <sform:input type="date" path="datecomplete" id="doc"
                                 class="form-control input-sm"></sform:input>
                    <div class="has-error">
                        <sform:errors path="datecomplete" class="help-inline"/>
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

                $("#employeetrainningform").unbind('submit').submit();
            }

        })
    /* function validatestudentBatch(){



         var studentid  = $('#studentId').val();
         var status = true;

         if(studentid.length< 3){

             $('#studentId').after("<Span>Please enter a student id from jquery</Span>");
             status = false;
         }








         return status;
     }});
*/
</script>


</html>

