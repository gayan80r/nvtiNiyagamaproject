
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
    <div class ="jumbotron"> <center><h1>Accessor Registration Form</h1></center></div>
    <!- we used the modelAttribute pass value view to controler->
    <sform:form method="post" id="accessorform" modelAttribute="accessor">

        <div class="row">
            <div class="form-group col-md-12">
                <label class="col-md-3 control-lable" for="first_name">First Name</label>
                <div class="col-md-9">
                    <sform:input type="text" path="first_name" id="first_name"
                                 class="form-control input-sm"></sform:input>
                    <div class="has-error">
                        <sform:errors path="first_name" class="help-inline"/>
                    </div>
                </div>
            </div>
        </div>


        <div class="row">
            <div class="form-group col-md-12">
                <label class="col-md-3 control-lable" for="last_name">Last Name</label>
                <div class="col-md-9">
                    <sform:input type="text" path="last_name" id="last_name"
                                 class="form-control input-sm"></sform:input>
                    <div class="has-error">
                        <sform:errors path="last_name" class="help-inline"/>
                    </div>
                </div>
            </div>
        </div>

        <div class="row">
            <div class="form-group col-md-12">
                <label class="col-md-3 control-lable" for="namewithinitial">Name with initial</label>
                <div class="col-md-9">
                    <sform:input type="text" path="namewithinitial" id="namewithinitial"
                                 class="form-control input-sm"></sform:input>
                    <div class="has-error">
                        <sform:errors path="namewithinitial" class="help-inline"/>
                    </div>
                </div>
            </div>
        </div>

        <div class="row">
            <div class="form-group col-md-12">
                <label class="col-md-3 control-lable" for="nic">NIC</label>
                <div class="col-md-9">
                    <sform:input type="text" path="nic" id="nic"
                                 class="form-control input-sm"></sform:input>
                    <div class="has-error">
                        <sform:errors path="nic" class="help-inline"/>
                    </div>
                </div>
            </div>
        </div>



        <div class="row">
            <div class="form-group col-md-12">

                <label class="col-md-3 control-lable" for="genderid">Gender</label>
                <div class="col-md-9">

                    <sform:select path="genderid" items="${genderList}" multiple="false" itemValue="id"

                                  itemLabel="name" class="form-control input-sm" />

                    <div class="has-error">
                        <sform:errors path="genderid" class="help-inline"/>
                    </div>

                </div>
            </div>
        </div>




        <div class="row">
            <div class="form-group col-md-12">

                <label class="col-md-3 control-lable" for="designationid">Designation</label>
                <div class="col-md-9">
                    <sform:select path="designationid" items="${designationList}" multiple="false" itemValue="id"

                                  itemLabel="name" class="form-control input-sm" />
                    <div class="has-error">
                        <sform:errors path="designationid" class="help-inline"/>
                    </div>

                </div>
            </div>
        </div>






        <div class="row">
            <div class="form-group col-md-12">
                <label class="col-md-3 control-lable" for="mobile">Mobile Number</label>
                <div class="col-md-9">
                    <sform:input type="text" path="mobile" id="mobile"
                                 class="form-control input-sm"></sform:input>
                    <div class="has-error">
                        <sform:errors path="mobile" class="help-inline"/>
                    </div>
                </div>
            </div>
        </div>
        <div class="row">
            <div class="form-group col-md-12">
                <label class="col-md-3 control-lable" for="workingphone">Home Number</label>
                <div class="col-md-9">
                    <sform:input type="text" path="workingphone" id="workingphone"
                                 class="form-control input-sm"></sform:input>
                    <div class="has-error">
                        <sform:errors path="workingphone" class="help-inline"/>
                    </div>
                </div>
            </div>
        </div>

        <div class="row">
            <div class="form-group col-md-12">
                <label class="col-md-3 control-lable" for="email">Email Address</label>
                <div class="col-md-9">
                    <sform:input type="text" path="email" id="email"
                                 class="form-control input-sm"></sform:input>
                    <div class="has-error">
                        <sform:errors path="email" class="help-inline"/>
                    </div>
                </div>
            </div>
        </div>





        <div class="row">
            <div class="form-group col-md-12">
                <label class="col-md-3 control-lable" for="address_line1">Address Line 1</label>
                <div class="col-md-9">
                    <sform:input type="text" path="address_line1" id="addressLine1"
                                 class="form-control input-sm"></sform:input>
                    <div class="has-error">
                        <sform:errors path="address_line1" class="help-inline"/>
                    </div>
                </div>
            </div>
        </div>

        <div class="row">
            <div class="form-group col-md-12">
                <label class="col-md-3 control-lable" for="address_line2">Address Line 2</label>
                <div class="col-md-9">
                    <sform:input type="text" path="address_line2" id="addressLine2"
                                 class="form-control input-sm"></sform:input>
                    <div class="has-error">
                        <sform:errors path="address_line2" class="help-inline"/>
                    </div>
                </div>
            </div>
        </div>

        <div class="row">
            <div class="form-group col-md-12">
                <label class="col-md-3 control-lable" for="city">City</label>
                <div class="col-md-9">
                    <sform:input type="text" path="city" id="city"
                                 class="form-control input-sm"></sform:input>
                    <div class="has-error">
                        <sform:errors path="city" class="help-inline"/>
                    </div>
                </div>
            </div>
        </div>


        <div class="row">
            <div class="form-group col-md-12">
                <label class="col-md-3 control-lable" for="bankaccountno">Bank Account No</label>
                <div class="col-md-9">
                    <sform:input type="text" path="bankaccountno" id="bankaccountno"
                                 class="form-control input-sm"></sform:input>
                    <div class="has-error">
                        <sform:errors path="bankaccountno" class="help-inline"/>
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
            var status = validateAccessor();

            if(status){

                $("#accessorform").unbind('submit').submit();
            }
        });

        function validateAccessor(){

            var firstName   = $('#first_name').val();
            var lastName    = $('#last_name').val();
            var namewithinitial=$('#namewithinitial').val();

            var nic         = $('#nic').val();
            var mobile      = $('#mobile').val();
            var workingphone = $('#workingphone').val();
            var email       = $('#email').val();

            var dob         = $('#dob').val();

            var addressLine1 = $('#addressLine1').val();
            var city        = $('#city').val();

            var status = true;


            if(firstName.length < 3){

                $('#first_name').after("<Span>Please enter a valid name from jquery</Span>");
                status = false;
            }


            if(lastName.length < 3){

                $('#last_name').after("<Span>Please enter a valid name from jquery</Span>");
                status = false;
            }

            if(nic.length > 0){

                var nicRegex = /^([0-9]{9}[V|v|x|X])|([0-9]{12})^/;
                var valNic = nicRegex.test(nic);
                if(!valNic) {
                    $('#nic').after("<Span>Please enter a valid nic from jquery</Span>");
                    status = false;
                }
            }


            if(mobile.length > 0) {

                var mobileRegex = /^((07)(0|1|2|5|6|7|8|9)[0-9]{7})$/;
                var valMobile = mobileRegex.test(mobile);

                if (!valMobile) {
                    $('#mobile').after("<Span>Please enter a valid mobile number from jquery</Span>");
                    status = false;
                }
            }

            if(workingphone.length > 0) {

                //var homeRegex = /^([0-9]{10})^/;
                var homeRegex = /^\d{10}$/;
                var valhome = homeRegex.test(workingphone);

                if (!valhome) {
                    $('#workingphone').after("<Span>Please enter a valid home number from jquery</Span>");
                    status = false;
                }
            }

            /* if(email.length > 0) {

                 var emailregex = /^[a-zA-Z0-9_!#$%&'*+/=?`{|}~^-]+(?:\.[a-zA-Z0-9_!#$%&'*+/=?`{|}~^-]+)*@[a-zA-Z0-9-]+(?:\.[a-zA-Z0-9-]+)*$/;
                 var valemail = emailregex .test(email);

                 if (!valemail) {
                     $('#email').after("<Span>Please enter a valid Email Name from jquery</Span>");
                     status = false;
                 }
             }*/

            if(addressLine1.length <= 0){

                $('#addressLine1').after("<Span>Please enter the address</Span>");
                status = false;
            }


            if(city.length <= 0){

                $('#city').after("<Span>Please enter the city</Span>");
                status = false;
            }


            return status;
        }});

</script>


</html>

