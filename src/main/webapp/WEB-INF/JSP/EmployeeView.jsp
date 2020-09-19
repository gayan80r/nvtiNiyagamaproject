<%--
  Created by IntelliJ IDEA.
  User: Administrator
  Date: 3/14/2020
  Time: 11:36 AM
  To change this template use File | Settings | File Templates.
--%>

<%@ taglib prefix="sform" uri="http://www.springframework.org/tags/form" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html xmlns="http://www.w3.org/1999/xhtml"
      xmlns:th="http://www.thymeleaf.org">
<head>
    <link href="webjars/bootstrap/3.3.6/css/bootstrap.min.css" rel ="stylesheet"/>
    <link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/4.5.0/css/bootstrap.min.css">
    <script src="https://ajax.googleapis.com/ajax/libs/jquery/3.5.1/jquery.min.js"></script>
    <script src="https://cdnjs.cloudflare.com/ajax/libs/popper.js/1.16.0/umd/popper.min.js"></script>
    <script src="https://maxcdn.bootstrapcdn.com/bootstrap/4.5.0/js/bootstrap.min.js"></script>


    <script src="https://ajax.googleapis.com/ajax/libs/jquery/3.1.1/jquery.min.js"></script>
    <script src="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.7/js/bootstrap.min.js"></script>

    <link rel="stylesheet" href="https://cdn.datatables.net/1.10.12/css/jquery.dataTables.min.css">
    <script src="https://cdn.datatables.net/1.10.12/js/jquery.dataTables.min.js"></script>
    <script src="/js/datatable.js"></script>
    <title>List of Employees</title>

</head>
<body>

</body>
<div class="container">
    <!--<div class="panel-heading"><span class="Lead">List of Employees</span></div> -->
    <div class ="jumbotron"> <center><h2>List of Employees</h2></center></div>
    <table class="table table-dark table-striped table-hover" id="employeesTable">
       <thead class>
        <tr>

            <th>First Name</th>
            <th>Last Name</th>
            <th>NIC</th>
            <th>Mobile</th>
            <th>City</th>
            <th width="100"></th>
            <th width="100"></th>

        </tr>
       </thead>

        <tbody>

        <c:forEach items="${employeeList}" var="emp">
        <tr>
            <td>${emp.first_name}</td>
            <td>${emp.last_name}</td>
            <td>${emp.nic}</td>
            <td>${emp.mobile}</td>
            <td>${emp.city}</td>
            <td><a href="<c:url value='/edit-employee-${emp.id}'/>" class="btn btn-warning">Edit</a>
            <td><a href="<c:url value='/delete-employee-${emp.id}'/>" class="btn btn-warning">Delete</a>
            </td>

            <td></td>
        </tr>
        </c:forEach>

        </tbody>
    </table>
<div>


<div class="panel" id="pages">


</div>

    <div class="panel">
        <a href ="<c:url value='/newemployee'/>" class="btn btn-primary btn-lg">Add New Employee</a>

    </div>
</div>


</div>
</html>


<script>
    $(document).ready(function () {
        pagination();
    });

    function pagination() {
      var no_of_rows=3;
     var $rows =$("tbody tr");
     var total_data_rows=$rows.length;
     var no_of_pages=0;
     if(total_data_rows%no_of_rows==0){

         no_of_pages=total_data_rows/no_of_rows;

     }
     if(total_data_rows%no_of_rows>=1){
         no_of_pages=total_data_rows/no_of_rows;
         no_of_pages++;
     }
        $("#pages").append("<a href='#' class='btn btn-default'>Next</a>");
     for(var i=1;i<=no_of_pages;i++){
         // $("#pages").append("<a href='#' class='btn btn-default'>next</a>");
         $("#pages").append("<a href='#' class='btn btn-default'>"+i+"</a>");
         // $("#pages").append("<a href='#' class='btn btn-default'>Previous</a>")
     }
        $("#pages").append("<a href='#' class='btn btn-default'>Previous</a>");
     $rows.each(function (j) {
       $(this).hide();
       if(j+1<=no_of_rows){
           $rows.eq(j).show();
       }
     });
        var temp=0;
     $("#pages  a").click(function (e) {
         e.preventDefault();
         $rows.hide();
         var page=$(this).text();

         if(page=="Next"){
             if(temp <no_of_pages){
                 temp++;
             }

         }
         else if(page=="Previous") {

             if (temp >0) {
                 temp--;
             }
         }else{
               temp=page-1;
             }


      var start=   temp*no_of_rows;
      for(var a=0;a<no_of_rows;a++){
          $rows.eq(start+a).show();
      }

     });
    }

</script>

<%--
<script>
    $(document).ready( function () {
        var table = $('#employeesTable').DataTable({
            "sAjaxSource": "/employee",
            "sAjaxDataProp": "",
            "order": [[ 0, "asc" ]],
            "aoColumns": [

                { "mData": "first_name" },
                { "mData": "last_name" },
                { "mData": "nic" },
                { "mData": "mobile" },
                { "mData": "city" }
            ]
        })
    });


</script>--%>
