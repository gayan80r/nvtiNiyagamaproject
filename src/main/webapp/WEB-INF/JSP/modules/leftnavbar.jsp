<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
 <!-- Sidebar -->
<style type="text/css">
  #Pages1 {
  }
</style>

<body id="page-top">

<!-- Page Wrapper -->
<div id="wrapper">



<ul class="navbar-nav bg-gradient-primary sidebar sidebar-dark accordion" id="accordionSidebar">

      <!-- Sidebar - Brand -->
      <a class="sidebar-brand d-flex align-items-center justify-content-center" href="dashboard">
        <div class="sidebar-brand-icon rotate-n-15">
          <i class="fas fa-laugh-wink"></i>
        </div>
        <div class="sidebar-brand-text mx-3">SB Admin <sup>2</sup></div>
      </a>

      <!-- Divider -->
      <hr class="sidebar-divider my-0">

      <!-- Nav Item - Dashboard -->
      <li class="nav-item active">
        <a class="nav-link" href="dashboard">
          <i class="fas fa-fw fa-tachometer-alt"></i>
          <span>Dashboard</span></a>
      </li>

      <!-- Divider -->
      <hr class="sidebar-divider">

      <!-- Heading -->
      <div class="sidebar-heading">
        Employee
      </div>

      <!-- Nav Item - Pages Collapse Menu -->
      <li class="nav-item">
        <a class="nav-link collapsed" href="#" data-toggle="collapse" data-target="#collapseTwo" aria-expanded="true" aria-controls="collapseTwo">
          <i class="fas fa-fw fa-cog"></i>
          <span>Employee Section</span>
        </a>
        <div id="collapseTwo" class="collapse" aria-labelledby="headingTwo" data-parent="#accordionSidebar">
          <div class="bg-white py-2 collapse-inner rounded">
            <h6 class="collapse-header">Employee Management:</h6>
              <a class="collapse-item" href="newemployee">Add New Employee </a>
            <a class="collapse-item" href="employee">Employee Details</a>
            <a class="collapse-item" href="employeetraining">Employee Training</a>
            <a class="collapse-item" href="cards.html">Employee Leave</a>
          </div>
        </div>
      </li>

      <!-- Nav Item - Utilities Collapse Menu -->
      <li class="nav-item">
        <a class="nav-link collapsed" href="#" data-toggle="collapse" data-target="#collapseUtilities" aria-expanded="true" aria-controls="collapseUtilities">
          <i class="fas fa-fw fa-wrench"></i>
          <span>Assessors</span>
        </a>
        <div id="collapseUtilities" class="collapse" aria-labelledby="headingUtilities" data-parent="#accordionSidebar">
          <div class="bg-white py-2 collapse-inner rounded">
            <h6 class="collapse-header">Assessors Management:</h6>
              <a class="collapse-item" href="newaccessor">Add New Assessors </a>
            <a class="collapse-item" href="accessor">AssessorsDetails </a>
          </div>
        </div>
      </li>

  <!-- Divider -->
  <hr class="sidebar-divider">
  <!-- Heading -->
  <div class="sidebar-heading">
    Course & Batch
  </div>

  <!-- Nav Item - Pages Collapse Menu -->
  <li class="nav-item">
    <a class="nav-link collapsed" href="#" data-toggle="collapse" data-target="#collapsecourse" aria-expanded="true" aria-controls="collapsePages">
      <i class="fas fa-fw fa-folder"></i>
      <span>Course & Batch Management</span>
    </a>
    <div id="collapsecourse" class="collapse" aria-labelledby="headingPages" data-parent="#accordionSidebar">
      <div class="bg-white py-2 collapse-inner rounded">
        <h6 class="collapse-header">Course:</h6>
          <a class="collapse-item" href="newcourse">Add New Course </a>
          <a class="collapse-item" href="#">Course Details</a>

          <div class="collapse-divider"></div>
          <h6 class="collapse-header"> Module:</h6>
          <a class="collapse-item" href="newmodule">Add New Module </a>
          <a class="collapse-item" href="module">Module Details</a>

        <div class="collapse-divider"></div>
        <h6 class="collapse-header"> Batch:</h6>
          <a class="collapse-item" href="batch">Add New Batch </a>
        <a class="collapse-item" href="#">Batch Details</a>

          <div class="collapse-divider"></div>
          <h6 class="collapse-header"> Instructor:</h6>
          <a class="collapse-item" href="newbatchinstructor">Add New Instructor For Batch </a>
          <a class="collapse-item" href="batchinstructor">Batch Instructor Details</a>
      </div>
    </div>
  </li>
      <!-- Divider -->
      <hr class="sidebar-divider">

      <!-- Heading -->
      <div class="sidebar-heading">
        Students
      </div>

      <!-- Nav Item - Pages Collapse Menu -->
      <li class="nav-item">
        <a class="nav-link collapsed" href="#" data-toggle="collapse" data-target="#collapsePages" aria-expanded="true" aria-controls="collapsePages">
          <i class="fas fa-fw fa-folder"></i>
          <span>Student Management</span>
        </a>
        <div id="collapsePages" class="collapse" aria-labelledby="headingPages" data-parent="#accordionSidebar">
          <div class="bg-white py-2 collapse-inner rounded">
            <h6 class="collapse-header">Students:</h6>

            <a class="collapse-item" href="student">Students Details</a>
            <a class="collapse-item" href="newstudent">Register New Students</a> 
            <div class="collapse-divider"></div>
            <h6 class="collapse-header">Student Batch:</h6>
            <a class="collapse-item" href="newbatchstudent">Student Batch Registration</a>
            <a class="collapse-item" href="batchstudent">Student Batch List</a>
              <div class="collapse-divider"></div>
              <h6 class="collapse-header">Student Parrent:</h6>
              <a class="collapse-item" href="newstudentparrent">Student Parent </a>
              <a class="collapse-item" href="studentparrent">Student Parent List </a>
          </div>
        </div>
      </li>
  <!-- Divider -->
      <hr class="sidebar-divider">

      <!-- Heading -->
      <div class="sidebar-heading">
        Exam
      </div>

      <li class="nav-item">
        <a class="nav-link collapsed" href="#" data-toggle="collapse" data-target="#collapsePages1" aria-expanded="true" aria-controls="collapsePages">
          <i class="fas fa-fw fa-folder"></i>
          <span>Exam Management</span>
        </a>
        <div id="collapsePages1" class="collapse" aria-labelledby="headingPages" data-parent="#accordionSidebar">
          <div class="bg-white py-2 collapse-inner rounded">
            <h6 class="collapse-header">Exam:</h6>
            <a class="collapse-item" href="#">Task Assignment</a>
            <a class="collapse-item" href="#">Semister Exam</a>
            <a class="collapse-item" href="#">Viver Exam</a>
            <div class="collapse-divider"></div>
            <h6 class="collapse-header">Asign Assersor  for Exam:</h6>
            <a class="collapse-item" href="#">Asigning Assersor</a>

          </div>
        </div>
      </li>

  <!-- Divider -->
  <hr class="sidebar-divider">
  <div class="sidebar-heading">
    On the job Training
  </div>

  <!-- Nav Item - Pages Collapse Menu -->
  <li class="nav-item">
    <a class="nav-link collapsed" href="#" data-toggle="collapse" data-target="#collapseojt" aria-expanded="true" aria-controls="collapseTwo">
      <i class="fas fa-fw fa-folder"></i>
      <span>OJT Management</span>
    </a>
    <div id="collapseojt" class="collapse" aria-labelledby="headingTwo" data-parent="#accordionSidebar">
      <div class="bg-white py-2 collapse-inner rounded">
        <h6 class="collapse-header">OJT :</h6>
          <a class="collapse-item" href="newojtplace">Add New OJT Place</a>
          <a class="collapse-item" href="ojtplace"> OJT Place Details</a>

          <div class="bg-white py-2 collapse-inner rounded">
              <div class="collapse-divider"></div>
              <h6 class="collapse-header">Student OJT Place :</h6>
              <a class="collapse-item" href="newojtstudent">Assign The student OJT Place</a>
              <a class="collapse-item" href="ojtstudent"> Student OJT Place Details</a>
          </div>
      </div>
    </div>
  </li>


  <div class="sidebar-heading">
    Job Placement
  </div>

  <!-- Nav Item - Pages Collapse Menu -->
  <li class="nav-item">
    <a class="nav-link collapsed" href="#" data-toggle="collapse" data-target="#collapsejob" aria-expanded="true" aria-controls="collapseTwo">
      <i class="fas fa-fw fa-folder"></i>
      <span>Job Placement Management</span>
    </a>
      <div id="collapsejob" class="collapse" aria-labelledby="headingTwo" data-parent="#accordionSidebar">
          <div class="bg-white py-2 collapse-inner rounded">
              <h6 class="collapse-header">OJT :</h6>
              <a class="collapse-item" href="newjobplacement">Add New Job Placement </a>
              <a class="collapse-item" href="jobplacement"> Job placement Details</a>
              <div class="collapse-divider"></div>
              <h6 class="collapse-header">Student Job Placement :</h6>
              <a class="collapse-item" href="#">Assign The student Job Placement</a>
              <a class="collapse-item" href="#"> Student Job Placement Details</a>
          </div>
      </div>
  </li>

  <!-- Divider -->
  <hr class="sidebar-divider">
      <!-- Nav Item - Charts -->
      <li class="nav-item">
        <a class="nav-link" href="charts.html">
          <i class="fas fa-fw fa-chart-area"></i>
          <span>Charts</span></a>
      </li>

      <!-- Nav Item - Tables -->
      <li class="nav-item">
        <a class="nav-link" href="tables.html">
          <i class="fas fa-fw fa-table"></i>
          <span>Tables</span></a>
      </li>

      <!-- Divider -->
      <hr class="sidebar-divider d-none d-md-block">

      <!-- Sidebar Toggler (Sidebar) -->
      <div class="text-center d-none d-md-inline">
        <button class="rounded-circle border-0" id="sidebarToggle"></button>
      </div>

    </ul>
    <!-- End of Sidebar -->
</div>
</body>