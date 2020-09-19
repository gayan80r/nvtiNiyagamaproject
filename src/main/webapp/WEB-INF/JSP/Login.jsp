<%--
  Created by IntelliJ IDEA.
  User: Administrator
  Date: 6/20/2020
  Time: 9:23 AM
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="sform" uri="http://www.springframework.org/tags/form" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<html>
<head>

    <link href="webjars/bootstrap/3.3.6/css/bootstrap.min.css"
          rel="stylesheet"/>
    <link href="<c:url value='/css/app.css' />" rel="stylesheet"></link>
    <script src="webjars/jquery/1.9.1/jquery.min.js"></script>
    <!-- Latest compiled and minified CSS -->
    <link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/3.4.1/css/bootstrap.min.css">

    <!-- jQuery library -->
    <script src="https://ajax.googleapis.com/ajax/libs/jquery/3.5.1/jquery.min.js"></script>

    <!-- Latest compiled JavaScript -->
    <script src="https://maxcdn.bootstrapcdn.com/bootstrap/3.4.1/js/bootstrap.min.js"></script>

    <title>Login Form</title>

    <link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/3.4.1/css/bootstrap.min.css">
    <link rel="stylesheet" href="https://cdnjs.cloudflare.com/ajax/libs/font-awesome/4.7.0/css/font-awesome.min.css">
    <script src="https://ajax.googleapis.com/ajax/libs/jquery/3.5.1/jquery.min.js"></script>
    <script src="https://maxcdn.bootstrapcdn.com/bootstrap/3.4.1/js/bootstrap.min.js">

    </script>
    <link href="webjars/bootstrap/3.3.6/css/bootstrap.min.css"
          rel="stylesheet"/>
    <link href="<c:url value='/css/app.css' />" rel="stylesheet"></link>
    <script src="webjars/jquery/1.9.1/jquery.min.js"></script>
    <!-- Latest compiled and minified CSS -->
    <link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/3.4.1/css/bootstrap.min.css">

    <!-- jQuery library -->
    <script src="https://ajax.googleapis.com/ajax/libs/jquery/3.5.1/jquery.min.js"></script>

    <!-- Latest compiled JavaScript -->
    <script src="https://maxcdn.bootstrapcdn.com/bootstrap/3.4.1/js/bootstrap.min.js"></script>
    <style>
        /* Set height of the grid so .sidenav can be 100% (adjust if needed) */
        .row.content {height: 900px}

        /* Set gray background color and 100% height */
        .sidenav {
            background-color: #f1f1f1;
            height: 100%;
        }

        .con {

            height: 100%;
        }

        /* Set black background color, white text and some padding */


        /* On small screens, set height to 'auto' for sidenav and grid */
        @media screen and (max-width: 767px) {
            .sidenav {
                height: auto;
                padding: 15px;
            }
            .row.content {height: auto;}
        }

        body {font-family: Arial, Helvetica, sans-serif;}
        * {box-sizing: border-box;}

        .input-container {
            display: -ms-flexbox; /* IE10 */
            display: flex;
            width: 100%;
            margin-bottom: 15px;
        }

        .icon {
            padding: 10px;
            background: dodgerblue;
            color: white;
            min-width: 50px;
            text-align: center;
        }

        .input-field {
            width: 100%;
            padding: 10px;
            outline: none;
        }

        .input-field:focus {
            border: 2px solid dodgerblue;
        }

        /* Set a style for the submit button */
        .btn {
            background-color: dodgerblue;
            color: white;
            padding: 15px 20px;
            border: none;
            cursor: pointer;
            width: 100%;
            opacity: 0.9;
        }

        .btn:hover {
            opacity: 1;
        }
    </style>
</head>

<body>
<div class="container-fluid">
<div class="row content">
<div class="col-sm-6 sidenav">
    <img src="student.jpg" class="rounded" alt="Cinque Terre" width="600" height="600">
</div>


<div class="col-sm-6 con">

<div class="jumbotron">
    <h1>Login Form</h1>

</div>

<sform:form  method="post" id="loginform" modelAttribute="user">

    <div class="input-container">
    <i class="fa fa-user icon"></i>&nbsp;
    <sform:input type="text" path="username" id="username" placeholder="Please Enter User Name"
                 class="form-control input-sm"></sform:input>
    </div>
    <div class="has-error col-md-5">
    <sform:errors path="username" class="help-inline"/>
    </div>


        <div class="input-container">
        <i class="fa fa-key icon"></i>&nbsp;
    <sform:input type="password" path="password" id="password" placeholder="Please Enter Password"
                 class="form-control input-sm"></sform:input>
    </div>
    <div class="has-error col-md-5">
    <sform:errors path="password" class="help-inline"/>
    </div>

    <input type="submit" value="Login" class="btn btn-primary btn-sm btn-block"/>
            <button type="button" class="btn btn-secondary btn-lg btn-warning btn-block">Cancel</button>

            <label>
            <input type="checkbox" checked="checked" name="remember"> Remember me
            </label>


            </div>

            </div>
    </sform:form>

</body>
</html>
