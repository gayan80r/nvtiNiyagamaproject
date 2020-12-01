<%@ taglib prefix="sform" uri="http://www.springframework.org/tags/form" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ page contentType="text/html; charset=ISO-8859-1" language="java" %>
<html>
<head>
    <meta charset="utf-8">
    <meta http-equiv="X-UA-Compatible" content="IE=edge">
    <meta name="viewport" content="width=device-width, initial-scale=1, shrink-to-fit=no">
    <meta name="description" content="">
    <meta name="author" content="">

    <title>Employee Registration</title>

    <link href="https://cdn.rawgit.com/mdehoog/Semantic-UI/6e6d051d47b598ebab05857545f242caf2b4b48c/dist/semantic.min.css"
          rel="stylesheet" type="text/css"/>


    <!-- Custom fonts for this template-->
    <link href="vendor/fontawesome-free/css/all.min.css" rel="stylesheet" type="text/css">
    <link href="https://fonts.googleapis.com/css?family=Nunito:200,200i,300,300i,400,400i,600,600i,700,700i,800,800i,900,900i"
          rel="stylesheet">
    <!-- Custom styles for this template-->
    <link href="/css/sb-admin-2.min.css" rel="stylesheet">
    <link href="/Semantic/semantic.min.css" rel="stylesheet">
</head>

<body id="page-top">

<!-- Page Wrapper -->
<div id="wrapper">
    <!-- ============================================================== -->
    <!-- 						Navigation Start 						-->
    <!-- ============================================================== -->
    <%@include file="/WEB-INF/JSP/modules/leftnavbar.jsp" %>
    <!-- ============================================================== -->
    <!-- 						Navigation End	 						-->
    <!-- ============================================================== -->

    <!-- Content Wrapper -->
    <div id="content-wrapper" class="d-flex flex-column">

        <!-- Main Content -->
        <div id="content">
            <div class="bg-white topbar mb-4 static-top shadow text-uppercase d-flex align-items-center p-l-15"><h4>
                Employee Registration Form</h4></div>

            <!-- Component Panel -->
            <div class="container-fluid">

                <!-- Step Component -->
                <div class="ui three top attached mini steps">
                    <div class="active step" id="step1">
                        <i class="user icon"></i>
                        <div class="content">
                            <div class="title">Personal</div>
                            <div class="description">Enter Employee personal details.</div>
                        </div>
                    </div>
                    <div class="step" id="step2">
                        <i class="map marker alternate icon"></i>
                        <div class="content">
                            <div class="title">Contact</div>
                            <div class="description">Enter Contact details.</div>
                        </div>
                    </div>
                    <div class="step" id="step3">
                        <i class="info icon"></i>
                        <div class="content">
                            <div class="title">Extra</div>
                            <div class="description">Enter Employment and Educational details.</div>
                        </div>
                    </div>
                </div>
                <div class="ui attached segment">
                    <sform:form method="post" id="employeeform" modelAttribute="employee" cssClass="ui form">
                        <div id="personal-details">

                            <div class="field">

                                <div class="two fields">

                                    <div class="field required">
                                        <label>Full Name</label>
                                        <sform:input type="text" path="full_name" id="full_name"
                                                     class="only-letters first-capital"
                                                     placeholder="Jhone Swizer"></sform:input>
                                        <div class="ui warning mini message">
                                            <div>Please enter Full Name.</div>
                                        </div>
                                        <sform:errors path="full_name" class="ui warning mini message transition visible"/>
                                    </div>

                                    <div class="field required">
                                        <label>Name with initial</label>
                                        <sform:input type="text" path="name_with_initial" id="name_with_initial"
                                                     class="only-letters first-capital"
                                                     placeholder="J. Swizer"></sform:input>
                                        <div class="ui warning mini message">
                                            <div>Please enter Name with initial.</div>
                                        </div>
                                        <sform:errors path="name_with_initial" class="ui warning mini message transition visible"/>
                                    </div>

                                </div>

                                <div class="two fields">

                                    <div class="field">
                                        <label>Civil Status</label>
                                        <sform:select path="civilStatusId" items="${civilStatusList}" multiple="false"
                                                      itemValue="id" itemLabel="name" class="ui dropdown"/>
                                    </div>

                                    <div class="field required">
                                        <label>National Identity Number</label>
                                        <sform:input type="text" path="nic" id="nic" class="text-uppercase"
                                                     placeholder="000000000000"></sform:input>
                                        <div class="ui warning mini message">
                                            <div>Please enter National Identity Number.</div>
                                        </div>
                                        <sform:errors path="nic" class="ui warning mini message transition visible"/>
                                    </div>

                                </div>

                                <div class="two fields">

                                    <div class="field">
                                        <label>Gender</label>
                                        <sform:select path="genderId" items="${genderList}" multiple="false"
                                                      itemValue="id" itemLabel="name" class="ui dropdown" id="gender"/>
                                    </div>

                                    <div class="field required ui calendar">
                                        <label>Date of Birth</label>
                                        <sform:input type="text" path="dob" id="dob" autocomplete="off"
                                                     placeholder="January 1, 2020"></sform:input>
                                        <div class="ui warning mini message">
                                            <div>Please select Date of Birth.</div>
                                        </div>
                                        <sform:errors path="dob" class="ui warning mini message transition visible"/>
                                    </div>

                                </div>

                            </div>


                        </div>

                        <div class="transition hidden" id="contact-details">

                            <div class="field">
                                <div class="two fields">

                                    <div class="field required">
                                        <label>Mobile Number</label>
                                        <sform:input type="text" path="mobile" id="mobile" class="contact"
                                                     placeholder="000 000 0000"></sform:input>
                                        <div class="ui warning mini message">
                                            <div>Please enter Mobile Number.</div>
                                        </div>
                                        <sform:errors path="mobile" class="ui warning mini message transition visible"/>
                                    </div>

                                    <div class="field">
                                        <label>Home Number</label>
                                        <sform:input type="text" path="home" id="home" class="contact"
                                                     placeholder="000 000 0000"></sform:input>
                                    </div>

                                </div>
                            </div>

                            <div class="field">
                                <div class="two fields">

                                    <div class="field required">
                                        <label>Address Line 1</label>
                                        <sform:input type="text" path="address_line1" id="addressLine1"
                                                     cssClass="first-capital" placeholder="01 Hill Lane"></sform:input>
                                        <div class="ui warning mini message">
                                            <div>Please enter Address.</div>
                                        </div>
                                        <sform:errors path="address_line1" class="ui warning mini message transition visible"/>
                                    </div>

                                    <div class="field">
                                        <label>Address Line 2</label>
                                        <sform:input type="text" path="address_line2" id="addressLine2"
                                                     cssClass="first-capital" placeholder="Hill Stree"></sform:input>
                                    </div>

                                </div>
                            </div>

                            <div class="field">
                                <div class="two fields">
                                    <div class="field">
                                        <label>City</label>
                                        <sform:select path="cityId" items="${cityList}" multiple="false"
                                                      itemValue="id" itemLabel="name" class="ui search dropdown" id="city"/>
                                    </div>

                                    <div class="field required">
                                        <label>Email Address</label>
                                        <sform:input type="text" path="email" id="email" placeholder="example@example.com"></sform:input>
                                        <div class="ui warning mini message">
                                            <div>Please enter Email.</div>
                                        </div>
                                        <sform:errors path="email" class="ui warning mini message transition visible"/>
                                    </div>

                                </div>
                            </div>

                        </div>

                        <div class="transition hidden" id="extra-details">

                            <div class="ui horizontal divider text-secondary">Educational and Vocational details.</div>

                            <div class="field">
                                <div class="two fields">

                                    <div class="field">
                                        <label>Highest Educational Qualification</label>
                                        <sform:select path="highset_educational_qualification_id"
                                                      items="${highesteducationalqualificationList}" multiple="false"
                                                      itemValue="id" itemLabel="name" class="ui dropdown"/>
                                    </div>

                                    <div class="field">
                                        <label>Highest Vocational Qualification</label>
                                        <sform:select path="highset_vocational_qualification_id"
                                                      items="${highestvocationalqualificationList}" multiple="false"
                                                      itemValue="id" itemLabel="name"
                                                      class="form-control input-sm ui dropdown"/>
                                    </div>

                                </div>
                            </div>

                            <div class="ui horizontal divider text-secondary">Employment details.</div>

                            <div class="field">
                                <div class="two fields">

                                    <div class="field">
                                        <label>Employee Type</label>
                                        <sform:select path="employeeTypeId" items="${employeeTypeList}" multiple="false"
                                                      itemValue="id" itemLabel="name" class="ui dropdown"/>
                                    </div>

                                    <div class="field">
                                        <label>EPF NO</label>
                                        <sform:input type="text" path="epf_no" id="epf_no"
                                                     placeholder="000000"></sform:input>
                                        <div class="ui warning mini message">
                                            <div>Please enter EPF NO.</div>
                                        </div>
                                        <sform:errors path="epf_no" class="ui warning mini message transition visible"/>
                                    </div>

                                </div>
                            </div>

                            <div class="field">
                                <div class="two fields">

                                    <div class="field">
                                        <label>Department</label>
                                        <sform:select path="departmentId" items="${departmentList}" multiple="false"
                                                      itemValue="id" itemLabel="name" class="ui dropdown"/>
                                    </div>

                                    <div class="field">
                                        <label>Designation</label>
                                        <sform:select path="designationId" items="${designationList}" multiple="false"
                                                      itemValue="id" itemLabel="name" class="ui dropdown"/>
                                    </div>

                                </div>
                            </div>

                        </div>

                        <div class="ui divider"></div>
                        <div class="w-100 d-flex justify-content-end">
                            <div class="ui buttons">
                                <button type="button" class="ui disabled button previous"><i
                                        class="left arrow icon"></i></button>
                                <div class="or"></div>
                                <button type="button" class="ui button next"><i class="right arrow icon"></i></button>
                            </div>
                        </div>
                    </sform:form>
                </div>
                <!-- End Step Component -->

            </div>
            <!-- End Component Panel -->

        </div>
        <!-- End Main Content -->

    </div>
    <!-- End Content Wrapper -->

</div>
<!-- End Page Wrapper -->

<!-- Scroll to Top Button-->
<a class="scroll-to-top rounded" href="#page-top">
    <i class="fas fa-angle-up"></i>
</a>

<!-- Logout Modal-->
<div class="modal fade" id="logoutModal" tabindex="-1" role="dialog" aria-labelledby="exampleModalLabel"
     aria-hidden="true">
    <div class="modal-dialog" role="document">
        <div class="modal-content">
            <div class="modal-header">
                <h5 class="modal-title" id="exampleModalLabel">Ready to Leave?</h5>
                <button class="close" type="button" data-dismiss="modal" aria-label="Close">
                    <span aria-hidden="true">×</span>
                </button>
            </div>
            <div class="modal-body">Select "Logout" below if you are ready to end your current session.</div>
            <div class="modal-footer">
                <button class="btn btn-secondary" type="button" data-dismiss="modal">Cancel</button>
                <a class="btn btn-primary" href="login.html">Logout</a>
            </div>
        </div>
    </div>
</div>

<!-- Bootstrap core JavaScript-->
<script src="<c:url value="/vendor/jquery/jquery.min.js"/>"></script>
<script src="<c:url value="/vendor/bootstrap/js/bootstrap.bundle.min.js"/>"></script>

<!-- Core plugin JavaScript-->
<script src="<c:url value="/vendor/jquery-easing/jquery.easing.min.js"/>"></script>

<!-- Custom scripts for all pages-->
<script src="<c:url value="/js/sb-admin-2.min.js"/>"></script>
<script src="<c:url value="/Semantic/semantic.min.js"/>"></script>
<script src="<c:url value="/js/validation.js"/>"></script>
<script src="<c:url value="/js/mobile-number.js"/>"></script>
<script src="<c:url value="/js/nic-retrive.js"/>"></script>

<script src="https://cdn.rawgit.com/mdehoog/Semantic-UI/6e6d051d47b598ebab05857545f242caf2b4b48c/dist/semantic.min.js"></script>

<script src="<c:url value="/js/modules/employee/Employee.js"/>"></script>

</body>

</html>