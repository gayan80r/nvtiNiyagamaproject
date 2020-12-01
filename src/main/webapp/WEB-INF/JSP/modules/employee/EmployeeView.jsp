<%@ taglib prefix="sform" uri="http://www.springframework.org/tags/form" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ page contentType="text/html; charset=ISO-8859-1" language="java" %>
<head>
    <title>List of Employees</title>
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
    <link rel="stylesheet" href="https://cdn.datatables.net/1.10.22/css/dataTables.semanticui.min.css">

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

            <div class="bg-white topbar mb-4 static-top shadow text-uppercase d-flex align-items-center p-l-15">
                <h4>List of Employees</h4>
            </div>

            <!-- Component Panel -->
            <div class="container-fluid" style="overflow-y: hidden">

                <div class="ui form segment">

                    <div class="ui horizontal divider text-secondary">Educational and Vocational details.</div>

                    <div class="field">
                        <div class="two fields">

                            <div class="field">
                                <label>Highest Educational Qualification</label>
                                <select class="ui dropdown" id="highestEducationalQualification">
                                    <option value="0">Select</option>
                                    <c:forEach items="${highesteducationalqualificationList}" var="heql">
                                        <option value="${heql.id}">${heql.name}</option>
                                    </c:forEach>
                                </select>
                            </div>

                            <div class="field">
                                <label>Highest Vocational Qualification</label>
                                <select class="ui dropdown" id="highestVocationalQualification">
                                    <option value="0">Select</option>
                                    <c:forEach items="${highestvocationalqualificationList}" var="hvql">
                                        <option value="${hvql.id}">${hvql.name}</option>
                                    </c:forEach>
                                </select>
                            </div>

                        </div>
                    </div>

                    <div class="ui horizontal divider text-secondary">Employment details.</div>

                    <div class="field">
                        <div class="two fields">

                            <div class="field">
                                <label>Employee Type</label>
                                <select class="ui dropdown" id="employeeType">
                                    <option value="0">Select</option>
                                    <c:forEach items="${employeeTypeList}" var="etl">
                                        <option value="${etl.id}">${etl.name}</option>
                                    </c:forEach>
                                </select>
                            </div>

                            <div class="field">
                                <label>Department</label>
                                <select class="ui dropdown" id="department">
                                    <option value="0">Select</option>
                                    <c:forEach items="${departmentList}" var="dl">
                                        <option value="${dl.id}">${dl.name}</option>
                                    </c:forEach>
                                </select>
                            </div>

                        </div>
                    </div>

                    <div class="field">
                        <div class="two fields">

                            <div class="field">
                                <label>Designation</label>
                                <select class="ui dropdown" id="designation">
                                    <option value="0">Select</option>
                                    <c:forEach items="${designationList}" var="del">
                                        <option value="${del.id}">${del.name}</option>
                                    </c:forEach>
                                </select>
                            </div>

                            <div class="field">
                                <label>Civil Status</label>
                                <select class="ui dropdown" id="civilStatus">
                                    <option value="0">Select</option>
                                    <c:forEach items="${civilStatusList}" var="csl">
                                        <option value="${csl.id}">${csl.name}</option>
                                    </c:forEach>
                                </select>
                            </div>

                        </div>
                    </div>

                    <div class="field">
                        <div class="two fields">

                            <div class="field">
                                <label>Gender</label>
                                <select class="ui dropdown" id="gender">
                                    <option value="0">Select</option>
                                    <c:forEach items="${genderList}" var="gl">
                                        <option value="${gl.id}">${gl.name}</option>
                                    </c:forEach>
                                </select>
                            </div>

                            <div class="field">
                                <label>Status</label>
                                <select class="ui dropdown" id="status">
                                    <option value="1">Active</option>
                                    <option value="0">Deactive</option>
                                </select>
                            </div>

                        </div>
                    </div>

                    <button class="fluid ui button btn-inverse-primary" id="filter">Search</button>

                </div>

                <div class="ui stacked segment">

                    <div>Search</div>
                    <div class="field ui fluid icon input">
                        <input type="text" placeholder="Search a very wide input..." id="mainSearch">
                        <i class="search icon"></i>
                    </div>

                    <div style="padding-left: 10px;">
                        <table class="ui celled striped table w-100" id="employeeTable">
                                <thead class="full-width">
                                    <tr>
                                        <th>Full Name</th>
                                        <th>Name with Initial</th>
                                        <th>NIC</th>
                                        <th>Mobile</th>
                                        <th>City</th>
                                        <th></th>
                                    </tr>
                                </thead>
                                <tbody>
                                </tbody>
                                <tfoot class="full-width">
                                    <tr>
                                        <th colspan="6">
                                            <div class="ui right floated small primary labeled icon button">
                                                <i class="user icon"></i> <a href="<c:url value='/newemployee'/>" class="text-white">Add New Employee</a>
                                            </div>
                                        </th>
                                    </tr>
                                </tfoot>
                            </table>
                    </div>
                </div>
            </div>
            <!-- End Component Panel -->

        </div>
        <!-- End Main Content -->

    </div>
    <!-- End Content Wrapper -->

</div>
<!-- End Page Wrapper -->

<div class="ui mini modal h-auto" id="removeEmployeeModal">
    <div class="content">
        <p>Are you sure removing Employee?.</p>
    </div>
    <div class="actions">
        <div class="ui buttons">
            <button class="ui animated btn-inverse-warning deny button" data-dismiss="modal">
                <div class="visible content">Cancel</div>
                <div class="hidden content">
                    <i class="thumbs down outline icon"></i>
                </div>
             </button>
            <div class="or"></div>
            <a class="ui animated btn-inverse-danger button" id="removeEmployeeData">
                <div class="visible content">Remove</div>
                <div class="hidden content">
                    <i class="trash alternate outline icon"></i>
                </div>
            </a>
        </div>
    </div>
</div>

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
<script src="http://cdn.datatables.net/1.10.22/js/jquery.dataTables.min.js"></script>
<script src="https://cdn.datatables.net/1.10.22/js/dataTables.semanticui.min.js"></script>
<script src="<c:url value="/Semantic/semantic.min.js"/>"></script>

<script src="https://cdn.rawgit.com/mdehoog/Semantic-UI/6e6d051d47b598ebab05857545f242caf2b4b48c/dist/semantic.min.js"></script>


<script>
    function removeEmployee(id){
        $('#removeEmployeeData').attr('href', '/delete-employee-'+id);
        $('#removeEmployeeModal').modal({centered: true}).modal('show');
    }
    $(document).ready(function () {
        $('.ui.dropdown').dropdown({selectOnKeydown: true});
        var employeeTable = $('#employeeTable').DataTable({
            columnDefs: [{
                targets: [5],
                createdCell: function (td, cellData, rowData, row, col) {
                    $(td).css('padding', '0');
                    $(td).css('width', '1%');
                }
            },
                {
                    targets: [0,1],
                    createdCell: function (td, cellData, rowData, row, col) {
                        $(td).css('width', '30%');
                    }
                }],
            initComplete: function (settings, json) {
                $('#employeeTable_info').hide();
                $('#employeeTable_filter').hide();
                $('#employeeTable_length').hide();
                $('#employeeTable').parent().css('padding-right', '2px');
            }
        });

        $('#mainSearch').keyup(function (e) {
            employeeTable.search($(this).val()).draw();
        });

        $('#filter').click(function (e) {

            var param=$('#highestEducationalQualification').val();
            param+="/"+$('#highestVocationalQualification').val();
            param+="/"+$('#employeeType').val();
            param+="/"+$('#department').val();
            param+="/"+$('#designation').val();
            param+="/"+$('#civilStatus').val();
            param+="/"+$('#gender').val();
            param+="/"+$('#status').val();
            $.ajax({
                type: 'GET',
                url: '/apiEmployee/getFilterEmployee/'+param,
                data: '',
                dataType: "json",
                success: function (data) {
                    console.log(data);
                    employeeTable.clear().draw();
                    $.each(data, function (key, value) {

                        var button='<a class="ui animated btn-inverse-danger border-radius-0 button h-100" style="height: 100% !important;" tabindex="0" onclick="removeEmployee('+ value.id +');">\n' +
                            '                                                        <div class="visible text-danger content">Remove</div>\n' +
                            '                                                        <div class="hidden content">\n' +
                            '                                                            <i class="trash alternate outline icon"></i>\n' +
                            '                                                        </div>\n' +
                            '                                                    </a>\n' +
                            '                                                </div>';
                        if(!value.status){
                            button='<a class="ui animated btn-inverse-success-td border-radius-0 button h-100" style="height: 100% !important;" tabindex="0" href="/active-employee-'+value.id+'">\n' +
                                '                                                        <div class="visible content">Active</div>\n' +
                                '                                                        <div class="hidden content">\n' +
                                '                                                            <i class="check icon"></i>\n' +
                                '                                                        </div>\n' +
                                '                                                    </a>\n' +
                                '                                                </div>';
                        }

                        employeeTable.row.add([value.full_name,value.name_with_initial, value.nic, value.mobile, value.city_id.name,
                            '<div class="ui buttons h-100">\n' +
                            '                                                    <a class="ui animated btn-inverse-warning border-radius-0 button h-100" tabindex="0" href="/edit-employee-'+value.id+'">\n' +
                            '                                                        <div class="visible text-warning content">Edit</div>\n' +
                            '                                                        <div class="hidden content">\n' +
                            '                                                            <i class="edit outline icon"></i>\n' +
                            '                                                        </div>\n' +
                            '                                                    </a>\n' +
                            '                                                    <div class="or"></div>\n' +button]).draw();
                    });
                }
            });
        });


        $.ajax({
            type: 'GET',
            url: '/apiEmployee/getAllEmployee',
            data: '',
            dataType: "json",
            success: function (data) {
                $.each(data, function (key, value) {
                    employeeTable.row.add([value.full_name,value.name_with_initial, value.nic, value.mobile, value.cityId.name,
                    '<div class="ui buttons h-100">\n' +
                    '                                                    <a class="ui animated btn-inverse-warning border-radius-0 button h-100" tabindex="0" href="/edit-employee-'+value.id+'">\n' +
                    '                                                        <div class="visible text-warning content">Edit</div>\n' +
                    '                                                        <div class="hidden content">\n' +
                    '                                                            <i class="edit outline icon"></i>\n' +
                    '                                                        </div>\n' +
                    '                                                    </a>\n' +
                    '                                                    <div class="or"></div>\n' +
                    '                                                    <a class="ui animated btn-inverse-danger border-radius-0 button h-100" style="height: 100% !important;" tabindex="0" onclick="removeEmployee('+ value.id +');">\n' +
                    '                                                        <div class="visible text-danger content">Remove</div>\n' +
                    '                                                        <div class="hidden content">\n' +
                    '                                                            <i class="trash alternate outline icon"></i>\n' +
                    '                                                        </div>\n' +
                    '                                                    </a>\n' +
                    '                                                </div>']).draw();
                });
            }
        });

    });

</script>

</body>
</html>


