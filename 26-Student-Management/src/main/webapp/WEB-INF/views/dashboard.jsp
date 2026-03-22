<%@ page contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>

<!DOCTYPE html>
<html>
<head>
    <meta charset="UTF-8">
    <title>Dashboard</title>

    <link href="https://cdn.jsdelivr.net/npm/bootstrap@5.3.0/dist/css/bootstrap.min.css" rel="stylesheet">
    <link href="https://cdnjs.cloudflare.com/ajax/libs/font-awesome/6.5.0/css/all.min.css" rel="stylesheet">

    <style>
        body {
            background: #f5f7fb;
        }

        .card {
            border-radius: 10px;
            padding: 20px;
            box-shadow: 0 2px 6px rgba(0,0,0,0.1);
        }

        .icon {
            width: 50px;
            height: 50px;
            border-radius: 50%;
            background: #e9f2ff;
            display: flex;
            align-items: center;
            justify-content: center;
            margin: auto;
        }

        .count {
            font-size: 26px;
            font-weight: bold;
        }

        .item {
            padding: 6px 0;
            border-bottom: 1px solid #eee;
        }
    </style>
</head>

<body>

<!-- NAVBAR -->
<nav class="navbar navbar-dark bg-primary px-4 d-flex justify-content-between">
    <span class="navbar-brand">Student Management System</span>

    <div class="d-flex gap-4 text-white">
        <i class="fa-solid fa-globe"></i>
        <i class="fa-solid fa-envelope"></i>

        <div class="dropdown">
            <i class="fa-solid fa-user" data-bs-toggle="dropdown" style="cursor:pointer;"></i>
            <ul class="dropdown-menu dropdown-menu-end">
                <li><a class="dropdown-item" href="#">Profile</a></li>
                <li><a class="dropdown-item" href="#">Logout</a></li>
            </ul>
        </div>
    </div>
</nav>

<div class="container mt-4 text-center">

    <h3>Student Management System</h3>
    <p class="text-muted">Manage Students and Courses</p>

    <!-- CARDS -->
    <div class="row justify-content-center mt-4">

        <!-- STUDENTS -->
        <div class="col-md-4">
            <div class="card">
                <div class="icon">
                    <i class="fa-solid fa-user text-primary"></i>
                </div>
                <h6 class="mt-2">Total Students</h6>

                <div class="count">
                    ${totalStudents != null ? totalStudents : 5}
                </div>

                <a href="view-students.jsp" class="btn btn-primary mt-2">View Students</a>
            </div>
        </div>

        <!-- COURSES -->
        <div class="col-md-4">
            <div class="card">
                <div class="icon">
                    <i class="fa-solid fa-book text-success"></i>
                </div>
                <h6 class="mt-2">Total Courses</h6>

                <div class="count">
                    ${totalCourses != null ? totalCourses : 3}
                </div>

                <a href="view-course.jsp" class="btn btn-success mt-2">View Courses</a>
            </div>
        </div>

    </div>

    <!-- BUTTONS -->
    <div class="mt-4">
        <a href="add-student.jsp" class="btn btn-primary me-3">
            <i class="fa-solid fa-plus"></i> Add Student
        </a>

        <a href="add-course.jsp" class="btn btn-success">
            <i class="fa-solid fa-plus"></i> Add Course
        </a>
    </div>

    <!-- RECENT DATA -->
    <div class="row mt-5 text-start">

        <!-- STUDENTS -->
        <div class="col-md-6">
            <div class="card">
                <h6>Recent Students</h6>

                <c:choose>
                    <c:when test="${not empty students}">
                        <c:forEach var="s" items="${students}">
                            <div class="item">
                                <i class="fa-solid fa-user me-2"></i>${s.name}
                            </div>
                        </c:forEach>
                    </c:when>

                    <c:otherwise>
                        <div class="item"><i class="fa-solid fa-user me-2"></i>Kashi</div>
                        <div class="item"><i class="fa-solid fa-user me-2"></i>Amit</div>
                        <div class="item"><i class="fa-solid fa-user me-2"></i>Sneha</div>
                        <div class="item"><i class="fa-solid fa-user me-2"></i>Rahul</div>
                    </c:otherwise>
                </c:choose>

            </div>
        </div>

        <!-- COURSES -->
        <div class="col-md-6">
            <div class="card">
                <h6>Recent Courses</h6>

                <c:choose>
                    <c:when test="${not empty courses}">
                        <c:forEach var="c" items="${courses}">
                            <div class="item">
                                <i class="fa-solid fa-book me-2"></i>${c.name}
                            </div>
                        </c:forEach>
                    </c:when>

                    <c:otherwise>
                        <div class="item"><i class="fa-solid fa-book me-2"></i>Java</div>
                        <div class="item"><i class="fa-solid fa-book me-2"></i>Spring Boot</div>
                        <div class="item"><i class="fa-solid fa-book me-2"></i>React</div>
                        <div class="item"><i class="fa-solid fa-book me-2"></i>Angular</div>
                    </c:otherwise>
                </c:choose>

            </div>
        </div>

    </div>

</div>

<script src="https://cdn.jsdelivr.net/npm/bootstrap@5.3.0/dist/js/bootstrap.bundle.min.js"></script>

</body>
</html>