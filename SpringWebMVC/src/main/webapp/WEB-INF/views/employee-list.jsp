<%@ taglib uri="http://www.springframework.org/tags" prefix="spring" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>

<html>
<head>
    <title>Employee List</title>
    <style>
        body {
            font-family: Arial, sans-serif;
            background-color: #fff;
            margin: 0;
            padding: 0;
        }

        .container {
            width: 80%;
            margin: 40px auto;
        }

        h1 {
            text-align: center;
            font-weight: bold;
            margin-bottom: 20px;
        }

        hr {
            border: 0;
            height: 1px;
            background: #ccc;
            margin-bottom: 20px;
        }

        .toolbar {
            display: flex;
            justify-content: flex-end;
            align-items: center;
            margin-bottom: 15px;
        }

        .toolbar form {
            margin-right: 10px;
        }

        input[type="text"] {
            padding: 6px;
            border: 1px solid #ccc;
            border-radius: 4px;
        }

        button, a.btn {
            background-color: #007bff;
            color: white;
            padding: 6px 12px;
            border: none;
            border-radius: 4px;
            cursor: pointer;
            text-decoration: none;
        }

        button:hover, a.btn:hover {
            background-color: #0056b3;
        }

        table {
            width: 100%;
            border-collapse: collapse;
        }

        th, td {
            border: 1px solid #ddd;
            padding: 10px;
            text-align: left;
        }

        th {
            background-color: #f4f4f4;
        }

        td a {
            text-decoration: none;
            color: #007bff;
            margin-right: 10px;
        }

        td a:hover {
            text-decoration: underline;
        }
    </style>
</head>
<body>

<div class="container">
    <h1>EMPLOYEE LIST</h1>
    <hr>

    <div class="toolbar">
        <form action="${pageContext.request.contextPath}/employees/search" method="get">
            <input type="text" name="keyword" placeholder="Search..." />
            <button type="submit">Search</button>
        </form>
        <a href="${pageContext.request.contextPath}/register" class="btn">Add Employee</a>
    </div>

    <table>
        <thead>
        <tr>
            <th>First Name</th>
            <th>Last Name</th>
            <th>Gender</th>
            <th>Date of birth</th>
            <th>Email</th>
            <th>Phone</th>
            <th>Action</th>
        </tr>
        </thead>
        <tbody>
        <c:forEach var="employee" items="${employees}">
            <tr>
                <td>${employee.firstName}</td>
                <td>${employee.lastName}</td>
                <td>${employee.gender}</td>
                <td>${employee.birthDate}</td>
                <td>${employee.email}</td>
                <td>${employee.phone}</td>
                <td>
                    <a href="${pageContext.request.contextPath}/employees/update/${employee.id}">Update</a>
                    <a href="${pageContext.request.contextPath}/employees/delete/${employee.id}">Delete</a>
                </td>
            </tr>
        </c:forEach>
        </tbody>
    </table>

    <c:if test="${empty employees}">
        <p style="text-align:center; color:gray;">No employees found.</p>
    </c:if>
</div>

</body>
</html>
