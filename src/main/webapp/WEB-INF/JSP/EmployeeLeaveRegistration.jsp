

<%@ taglib prefix="sform" uri="http://www.springframework.org/tags/form" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>

<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Title</title>



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
    <div class ="jumbotron"> <center><h1>Employee Registration Form</h1></center></div>
    <!- we used the modelAttribute pass value view to controler->
    <sform:form method="post" id="employeeLeaveform" modelAttribute="employeeLeave">

        <div class="row">
            <div class="form-group col-md-12">
                <label class="col-md-3 control-lable" for="epf_no">EPF No</label>
                <div class="col-md-9">
                    <sform:input type="text" path="epf_no" id="first_name"
                                 class="form-control input-sm"></sform:input>
                    <div class="has-error">
                        <sform:errors path="epf_no" class="help-inline"/>
                    </div>
                </div>
            </div>
        </div>


        <div class="row">
            <div class="form-group col-md-12">

                <label class="col-md-3 control-lable" for="employeeid"> Name with initial</label>
                <div class="col-md-9">
                    <sform:select path="employeeid" items="${employeeList}" multiple="false" itemValue="id"

                                  itemLabel="name" class="form-control input-sm" />
                    <div class="has-error">
                        <sform:errors path="employeeid" class="help-inline"/>
                    </div>

                </div>
            </div>
        </div>

        <div class="row">
            <div class="form-group col-md-12">

                <label class="col-md-3 control-lable" for="empleavetypeid">Leave Type</label>
                <div class="col-md-9">

                    <sform:select path="empleavetypeid" items="${leaveTyperList}" multiple="false" itemValue="id"

                                  itemLabel="name" class="form-control input-sm" />

                    <div class="has-error">
                        <sform:errors path="empleavetypeid" class="help-inline"/>
                    </div>

                </div>
            </div>
        </div>


        <div class="row">
            <div class="form-group col-md-12">
                <label class="col-md-3 control-lable" for="startdate">Leave Start Date</label>
                <div class="col-md-9">
                    <sform:input type="date" path="startdate" id="startdate"
                                 class="form-control input-sm"></sform:input>
                    <div class="has-error">
                        <sform:errors path="startdate" class="help-inline"/>
                    </div>
                </div>
            </div>
        </div>

        <div class="row">
            <div class="form-group col-md-12">
                <label class="col-md-3 control-lable" for="enddate">Leave End Date</label>
                <div class="col-md-9">
                    <sform:input type="date" path="enddate" id="enddate"
                                 class="form-control input-sm"></sform:input>
                    <div class="has-error">
                        <sform:errors path="enddate" class="help-inline"/>
                    </div>
                </div>
            </div>
        </div>

        <div class="row">
            <div class="form-group col-md-12">
                <label class="col-md-3 control-lable" for="applydate">Leave Apply Date</label>
                <div class="col-md-9">
                    <sform:input type="date" path="applydate" id="applydate"
                                 class="form-control input-sm"></sform:input>
                    <div class="has-error">
                        <sform:errors path="applydate" class="help-inline"/>
                    </div>
                </div>
            </div>
        </div>

        <div class="row">
            <div class="form-group col-md-12">

                <label class="col-md-3 control-lable" for="coveringEmployeeId"> Covering Employee</label>
                <div class="col-md-9">
                    <sform:select path="coveringEmployeeId" items="${employeeList}" multiple="false" itemValue="id"

                                  itemLabel="name" class="form-control input-sm" />
                    <div class="has-error">
                        <sform:errors path="coveringEmployeeId" class="help-inline"/>
                    </div>

                </div>
            </div>
        </div>

        <div class="row">
            <div class="form-group col-md-12">

                <label class="col-md-3 control-lable" for="approvedEmployeeId"> Approved Employee</label>
                <div class="col-md-9">
                    <sform:select path="approvedEmployeeId" items="${employeeList}" multiple="false" itemValue="id"

                                  itemLabel="name" class="form-control input-sm" />
                    <div class="has-error">
                        <sform:errors path="approvedEmployeeId" class="help-inline"/>
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
            var status = validateEmployee();

            if(status){

                $("#employeeLeaveform").unbind('submit').submit();
            }
        });

       /* $("#nic").focusout(function (event) {

            var nic         = $('#nic').val();
            if(nic.length > 0){

                var nicRegex = /^([0-9]{9}[V|v|x|X])|([0-9]{12})^/;
                var valNic = nicRegex.test(nic);
                if(!valNic) {
                    $('#nic').after("<Span>Please enter a valid nic from jquery</Span>");
                    status = false;
                }
            }

        });*/

        function validateEmployee(){


            var epf_no    =$('#epf_no').val();


            var status = true;




            if(epf_no.length < 4){

                $('#epf_no').after("<Span>Please enter a valid epf  for jquery</Span>");
                status = false;
            }



            return status;
        }});

</script>


</html>
