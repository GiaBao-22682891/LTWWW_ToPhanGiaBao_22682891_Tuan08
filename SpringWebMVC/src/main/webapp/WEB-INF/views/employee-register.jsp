<%@ taglib uri="http://www.springframework.org/tags/form" prefix="form" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>

<html>
<head>
    <title>Registration Employee</title>
    <style>
        body {
            font-family: Arial, sans-serif;
            background-color: #fff;
            display: flex;
            justify-content: center;
            align-items: center;
            height: 100vh;
        }
        .container {
            width: 400px;
            border: 1px solid #ddd;
            border-radius: 10px;
            padding: 30px;
            box-shadow: 0 0 10px rgba(0,0,0,0.1);
        }
        h1 {
            text-align: center;
        }
        .form-group {
            margin-bottom: 15px;
        }
        label {
            display: block;
            font-weight: bold;
        }
        input[type="text"], input[type="email"], input[type="date"] {
            width: 100%;
            padding: 8px;
            margin-top: 5px;
        }
        .gender input {
            margin-right: 5px;
        }
        .buttons {
            text-align: center;
            margin-top: 20px;
        }
        button {
            margin: 5px;
            padding: 8px 20px;
            border: none;
            border-radius: 5px;
            cursor: pointer;
        }
        .back { background-color: gray; color: white; }
        .register { background-color: #007BFF; color: white; }
        .message { text-align: center; color: green; }
    </style>
</head>
<body>
<div class="container">
    <h1>REGISTRATION EMPLOYEE</h1>

    <form:form action="${pageContext.request.contextPath}/register" method="post" modelAttribute="employee">
        <div class="form-group">
            <label>First Name</label>
            <form:input path="firstName" placeholder="First Name" />
        </div>

        <div class="form-group">
            <label>Last Name</label>
            <form:input path="lastName" placeholder="Last Name" />
        </div>

        <div class="form-group">
            <label>Email</label>
            <form:input path="email" placeholder="Email" />
        </div>

        <div class="form-group">
            <label>Date of Birth</label>
            <form:input path="birthDate" type="date" />
        </div>

        <div class="form-group">
            <label>Phone number</label>
            <form:input path="phone" placeholder="Phone number" />
        </div>

        <div class="form-group gender">
            <label>Gender</label>
            <form:radiobutton path="gender" value="Male"/> Male
            <form:radiobutton path="gender" value="Female" /> Female
        </div>

        <div class="form-group">
            <label>Address</label>
            <form:input path="address" placeholder="Address" />
        </div>

        <div class="buttons">
            <button type="button" class="back">Back</button>
            <button type="submit" class="register">Register</button>
            <a href="${pageContext.request.contextPath}/employees" class="viewList">View list</a>
        </div>

        <div class="message">
            <c:if test="${not empty message}">
                <p>${message}</p>
            </c:if>
        </div>
    </form:form>
</div>
</body>
</html>
