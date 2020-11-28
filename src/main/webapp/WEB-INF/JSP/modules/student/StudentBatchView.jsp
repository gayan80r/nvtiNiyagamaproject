<%@ taglib prefix="sform" uri="http://www.springframework.org/tags/form" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<c:set var="path" value="${pageContext.request.contextPath}"/>
<%@ taglib prefix="fn" uri="http://java.sun.com/jsp/jstl/functions" %>
<html>
    <head>
        <meta charset="utf-8">
        <meta http-equiv="X-UA-Compatible" content="IE=edge">
        <meta name="viewport" content="width=device-width, initial-scale=1, shrink-to-fit=no">
        <meta name="description" content="">
        <meta name="author" content="">

        <title>List of course</title>

        <!-- Custom fonts for this template-->
        <link href="vendor/fontawesome-free/css/all.min.css" rel="stylesheet" type="text/css">
        <link href="https://fonts.googleapis.com/css?family=Nunito:200,200i,300,300i,400,400i,600,600i,700,700i,800,800i,900,900i" rel="stylesheet">
        <!-- Custom styles for this template-->
        <link href="/css/sb-admin-2.min.css" rel="stylesheet">

    <%--    <link href="webjars/bootstrap/3.3.6/css/bootstrap.min.css" rel="stylesheet"/>--%>
    <%--    <link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/4.5.0/css/bootstrap.min.css">--%>
        <link rel="stylesheet" href="http://cdn.datatables.net/1.10.22/css/jquery.dataTables.min.css">
        <script src="https://ajax.googleapis.com/ajax/libs/jquery/3.5.1/jquery.min.js"></script>
        <script src="https://cdnjs.cloudflare.com/ajax/libs/popper.js/1.16.0/umd/popper.min.js"></script>
        <script src="https://maxcdn.bootstrapcdn.com/bootstrap/4.5.0/js/bootstrap.min.js"></script>
        <script src="http://cdn.datatables.net/1.10.22/js/jquery.dataTables.min.js"></script>

    </head>

    <body id="page-top">
        <!-- Page Wrapper -->
        <div id="wrapper">

            <!-- ============================================================== -->
            <!-- 						Navigation Start 						-->
            <!-- ============================================================== -->
            <jsp:include page="${request.contextPath}/leftmenu"></jsp:include>
            <!-- ============================================================== -->
            <!-- 						Navigation End	 						-->
            <!-- ============================================================== -->

            <!-- Content Wrapper -->
            <div id="content-wrapper" class="d-flex flex-column">

                <!-- Main Content -->
                <div id="content">

                    <div class="jumbotron text-center"><h1 class="h3 mb-0 text-black">Student Batch List Form</h1></div>

                    <div class="container">
                        <!- we used the modelAttribute pass value view to controler->
                        <sform:form method="post" id="studentbatchListform" class="text-dark" modelAttribute="studentBatch">
                            <div class="row">
                                <div class="form-group col-md-12">

                                    <label class="col-md-3 control-lable" for="id">Select The Year</label>
                                    <div class="col-md-12">
                                        <sform:select path="id" items="${yearList}" multiple="false" itemValue="id" id="yearIdSeleter"

                                                      itemLabel="name" class="form-control input-sm">
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

                                    <label class="col-md-3 control-lable" for="batchid">Select The Course</label>
                                    <div class="col-md-12">
                                        <select id="courseIdSelecter" class="form-control input-sm">
                                        </select>
                                        <div class="has-error">
                                            <sform:errors path="id" class="help-inline"/>
                                        </div>

                                    </div>
                                </div>
                            </div>

                            <div class="row">
                                <div class="form-group col-md-12">

                                    <label class="col-md-3 control-lable" for="batchid">Batch Name</label>
                                    <div class="col-md-12">
                                        <sform:select path="batchid" multiple="false" id="batchIdSelecter"

                                                      itemLabel="name" class="form-control input-sm"/>
                                        <div class="has-error">
                                            <sform:errors path="batchid" class="help-inline"/>
                                        </div>

                                    </div>
                                </div>
                            </div>

                            <div class="row">
                                <div class="form-group col-md-12">

                                    <div class="col-md-9">

                                        <input type="button" value="Search" id="submitbutton" class="btn btn-primary"/>
                                    </div>
                                </div>
                            </div>

                        </sform:form>
                    </div>
                        <!--<div class="panel-heading"><span class="Lead">List of Employees</span></div> -->
                    <div class="bg-gray p-1 text-center"><h2 class="h3 mb-0 text-black">List of Batch student </h2></div>

                    <div class="container p-t-10">
                        <div class="row table-responsive">
                            <table id="myTable" class="w-100 table table-striped table-bordered display text-black">
                                <thead class>
                                <tr>
                                    <th>Student Name</th>
                                    <th>Date Joint</th>
                                    <th>Status</th>
                                    <th width="100"></th>
                                    <th width="100"></th>
                                </tr>
                                </thead>
                                <tbody>
                                </tbody>
                            </table>
                        </div>
                        <div>


                        </div>


                    </div>

                </div>
                <!-- End Main Content -->

            </div>
            <!-- End Content Wrapper -->



        </div>
        <!-- End of Page Wrapper -->

        <!-- Delete Modal -->

        <div class="modal fade" tabindex="-1" role="dialog" id="removeStudentBatch">
            <div class="modal-dialog modal-dialog-centered" role="document">
                <div class="modal-content">
                    <div class="modal-body text-center text-black">
                        <p>Are you sure removing student of the batch?.</p>
                    </div>
                    <div class="modal-footer">
                        <button type="button" class="btn btn-link"><a id="removeBatchLink">Remove</a></button>
                        <button type="button" class="btn btn-link" data-dismiss="modal">Close</button>
                    </div>
                </div>
            </div>
        </div>

        <!-- End Delete Modal -->

        <!-- Scroll to Top Button-->
        <a class="scroll-to-top rounded" href="#page-top">
            <i class="fas fa-angle-up"></i>
        </a>

        <!-- Logout Modal-->
        <div class="modal fade" id="logoutModal" tabindex="-1" role="dialog" aria-labelledby="exampleModalLabel" aria-hidden="true">
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

        <!-- Custom scripts for all pages-->
        <script src="<c:url value="/js/sb-admin-2.min.js"/>"></script>

        <script>
            function removeBatchStudent(id){
                $('#removeBatchLink').attr('href', '/detele-studentbatch-'+id);
                $('#removeStudentBatch').modal('show');
            }

            $(document).ready(function () {
                // $.fn.dataTable.ext.classes.sPageButton = 'btn btn-primary';
                var studentsTable = $('#myTable').DataTable({
                    columnDefs: [{
                        targets: '_all',
                        createdCell: function (td, cellData, rowData, row, col) {
                            $(td).css('color', '#000000');
                        }
                    },{ "width": "1%", "targets": [3,4] }]
                });



                $('.js-example-basic-single').select();

                $('#submitbutton').click(function () {
                    $.ajax({
                        type: 'GET',
                        url: '/api/retrivebcstudent/' + $("#batchIdSelecter").val() + '/' + $("#courseIdSelecter").val(),
                        data: '',
                        dataType: "json",
                        success: function (data) {
                            studentsTable.clear().draw();
                            $.each(data, function (key, value) {
                                studentsTable.row.add([value.firstName + " " + value.lastName, dateFormate(value.date), value.status, "<a href='/edit-studentbatch-" + value.id + "' class='btn btn-warning btn-circle'><i class='fas fa-user-edit'></i></a>", '<button onclick="removeBatchStudent('+ value.id +');" class="btn btn-danger btn-circle"><i class="fas fa-trash"></i></button>']).draw(false);
                            });
                        }
                    });
                });

                $.ajax({
                    type: 'GET',
                    //url: '/api/retrivestudent/'+value,
                    url: '/api/retrivestudent',
                    data: '',
                    dataType: "json",
                    success: function (data) {

                        $("#studentIdSelecter").html('');
                        var itrms = '<option value="0"></option>';
                        $.each(data, function (key, value) {
                            itrms = itrms + '<option value="' + value.id + '">' + value.name + '</option>';
                        });
                        $("#studentIdSelecter").html(itrms);
                    }
                });


                //});


                $("#courseIdSelecter").change(getYearAndCourseBatch);
                $("#yearIdSeleter").change(getYearAndCourseBatch);

                function getYearAndCourseBatch() {
                    var year = $("#yearIdSeleter").val();
                    var course = $("#courseIdSelecter").val();

                    $.ajax({
                        type: 'GET',
                        url: '/api/retriveyearandcoursebatch/' + year + "/" + course,
                        data: '',
                        dataType: "json",
                        success: function (data) {

                            $("#batchIdSelecter").html('');
                            var itrms = '<option value="0"></option>';
                            $.each(data, function (key, value) {
                                itrms = itrms + '<option value="' + value.id + '">' + value.name + '</option>';
                            });
                            $("#batchIdSelecter").html(itrms);
                        }
                    });
                }

                $.ajax({
                    type: 'GET',
                    url: '/api/retrivecourse',
                    data: '',
                    dataType: "json",
                    success: function (data) {

                        $("#courseIdSelecter").html('');
                        var itrms = '<option value="0"></option>';
                        $.each(data, function (key, value) {
                            itrms = itrms + '<option value="' + value.id + '">' + value.name + '</option>';
                        });
                        $("#courseIdSelecter").html(itrms);
                    }
                });

                var months = ["January", "February", "March", "April", "May", "June", "July", "August", "November", "September", "November", "December"];

                function dateFormate(date) {
                    date = new Date(date);
                    return months[date.getMonth()] + ' ' + String(date.getDate()).padStart(2, '0') + ', ' + date.getFullYear();
                }

            });
        </script>

    </body>

</html>