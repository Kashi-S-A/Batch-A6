<%@ page contentType="text/html;charset=UTF-8" %>
<!DOCTYPE html>
<html>
<head>
    <title>View Students</title>

    <link href="https://cdn.jsdelivr.net/npm/bootstrap@5.3.0/dist/css/bootstrap.min.css" rel="stylesheet">
</head>

<body>

<div class="container mt-4">
    <h3>Students List</h3>

    <table class="table table-bordered mt-3">
        <thead class="table-dark">
            <tr>
                <th>ID</th>
                <th>Name</th>
                <th>Email</th>
            </tr>
        </thead>

        <tbody>
            <tr>
                <td>1</td>
                <td>Kashi</td>
                <td>kashi@gmail.com</td>
            </tr>
            <tr>
                <td>2</td>
                <td>Amit</td>
                <td>amit@gmail.com</td>
            </tr>
            <tr>
                <td>3</td>
                <td>Sneha</td>
                <td>sneha@gmail.com</td>
            </tr>
        </tbody>
    </table>

    <a href="dashboard.jsp" class="btn btn-primary">Back to Dashboard</a>

</div>

</body>
</html>