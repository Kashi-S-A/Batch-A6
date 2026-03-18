<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Course List</title>

<style>
    body {
        margin: 0;
        font-family: Arial, sans-serif;
        background-color: #f4f6f9;
    }

    .header {
        background-color: #2c4a7a;
        color: white;
        padding: 15px 25px;
        display: flex;
        justify-content: space-between;
        align-items: center;
    }

    .header h2 {
        margin: 0;
    }

    .header .icons {
        display: flex;
        gap: 20px;
        font-size: 18px;
    }

    .breadcrumb {
        padding: 15px 25px;
        font-size: 14px;
    }

    .breadcrumb a {
        text-decoration: none;
        color: #2c4a7a;
        font-weight: bold;
    }

   
    .container {
        margin: 20px;
        background: white;
        padding: 20px;
        border-radius: 6px;
        box-shadow: 0 2px 6px rgba(0,0,0,0.1);
    }

  
    table {
        width: 100%;
        border-collapse: collapse;
    }

    th {
        background-color: #e9edf2;
        padding: 12px;
        text-align: left;
        font-size: 14px;
    }

    td {
        padding: 12px;
        border-top: 1px solid #ddd;
        font-size: 14px;
    }

    tr:hover {
        background-color: #f9fbfd;
    }

   
    .btn-edit {
        background-color: #2c6ed5;
        color: white;
        padding: 6px 12px;
        border: none;
        border-radius: 4px;
        cursor: pointer;
        font-size: 13px;
    }

    .btn-edit:hover {
        background-color: #1f57a8;
    }
</style>

</head>
<body>

    
    <div class="header">
        <h2>Course List</h2>
        <div class="icons">
            🌐 ✉️ 👤
        </div>
    </div>

    
    <div class="breadcrumb">
        <a href="#">Home</a> / Courses
    </div>

    <div class="container">
        <table>
            <thead>
                <tr>
                    <th>ID</th>
                    <th>Course Name</th>
                    <th>Duration</th>
                    <th>Students Enrolled</th>
                    <th>Action</th>
                </tr>
            </thead>
            <tbody>
                <tr>
                    <td>1</td>
                    <td>Java</td>
                    <td>3 Months</td>
                    <td>Kashi, Sneha</td>
                    <td><button class="btn-edit">Edit</button></td>
                </tr>
                <tr>
                    <td>2</td>
                    <td>Spring Boot</td>
                    <td>2 Months</td>
                    <td>Amit</td>
                    <td><button class="btn-edit">Edit</button></td>
                </tr>
                <tr>
                    <td>3</td>
                    <td>React</td>
                    <td>2 Months</td>
                    <td>Rahul</td>
                    <td><button class="btn-edit">Edit</button></td>
                </tr>
            </tbody>
        </table>
    </div>

</body>
</html>
