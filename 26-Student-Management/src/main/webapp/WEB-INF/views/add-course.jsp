<%@ page contentType="text/html;charset=UTF-8" %>
<!DOCTYPE html>
<html>
<head>
    <title>Add Course</title>
    <style>
        body {
            font-family: Arial;
            background: #eef2f7;
        }

        .modal {
            width: 400px;
            margin: 100px auto;
            background: white;
            border-radius: 6px;
            box-shadow: 0px 4px 12px rgba(0,0,0,0.2);
        }

        .modal-header {
            background: #2c4a7a;
            color: white;
            padding: 15px;
            font-size: 18px;
            display: flex;
            justify-content: space-between;
        }

        .modal-body {
            padding: 20px;
        }

        label {
            font-weight: bold;
        }

        input {
            width: 100%;
            padding: 10px;
            margin: 10px 0 20px 0;
            border: 1px solid #ccc;
            border-radius: 4px;
        }

        .btn {
            width: 100%;
            padding: 12px;
            background: #28a745;
            color: white;
            border: none;
            border-radius: 4px;
            font-size: 16px;
        }
    </style>
</head>

<body>

<div class="modal">
    <div class="modal-header">
        Add New Course
        <span>✖</span>
    </div>

    <div class="modal-body">
        <form action="add-course" method="post">

            <label>Course Name:</label>
            <input type="text" name="name" placeholder="Enter course name">

            <label>Duration:</label>
            <input type="text" name="duration" placeholder="e.g., 3 Months">

            <button class="btn">Save Course</button>

        </form>
    </div>
</div>

</body>
</html>