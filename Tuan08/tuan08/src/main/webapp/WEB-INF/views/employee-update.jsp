<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<!DOCTYPE html>
<html>
<head>
    <meta charset="UTF-8">
    <title>Update Employee</title>
    <style>
        body {
            font-family: Arial, sans-serif;
            margin: 20px;
            background-color: #f5f5f5;
        }
        .container {
            max-width: 600px;
            margin: 0 auto;
            background-color: white;
            padding: 30px;
            border-radius: 8px;
            box-shadow: 0 2px 4px rgba(0,0,0,0.1);
        }
        h1 {
            text-align: center;
            color: #333;
            margin-bottom: 30px;
        }
        .form-group {
            margin-bottom: 20px;
        }
        label {
            display: block;
            margin-bottom: 5px;
            font-weight: bold;
            color: #333;
        }
        input[type="text"],
        input[type="email"],
        input[type="date"],
        textarea {
            width: 100%;
            padding: 10px;
            border: 1px solid #ddd;
            border-radius: 4px;
            box-sizing: border-box;
            font-size: 14px;
        }
        .radio-group {
            display: flex;
            gap: 20px;
        }
        .radio-group input[type="radio"] {
            margin-right: 5px;
        }
        .btn {
            padding: 10px 20px;
            border: none;
            border-radius: 4px;
            cursor: pointer;
            font-size: 14px;
            margin-right: 10px;
        }
        .btn-primary {
            background-color: #007bff;
            color: white;
        }
        .btn-secondary {
            background-color: #6c757d;
            color: white;
        }
        .btn:hover {
            opacity: 0.8;
        }
        .error {
            color: #dc3545;
            font-size: 12px;
            margin-top: 5px;
        }
        .form-buttons {
            text-align: center;
            margin-top: 30px;
        }
    </style>
</head>
<body>
<div class="container">
    <h1>UPDATE EMPLOYEE</h1>

    <form:form method="post" modelAttribute="employee" action="${pageContext.request.contextPath}/employees/edit/${employee.id}">

        <div class="form-group">
            <label for="firstName">First Name</label>
            <form:input path="firstName" id="firstName"/>
            <form:errors path="firstName" cssClass="error"/>
        </div>

        <div class="form-group">
            <label for="lastName">Last Name</label>
            <form:input path="lastName" id="lastName"/>
            <form:errors path="lastName" cssClass="error"/>
        </div>

        <div class="form-group">
            <label for="email">Email</label>
            <form:input path="email" type="email" id="email"/>
            <form:errors path="email" cssClass="error"/>
        </div>

        <div class="form-group">
            <label for="dateOfBirth">Date of Birth</label>
            <form:input path="dateOfBirth" type="date" id="dateOfBirth"/>
            <form:errors path="dateOfBirth" cssClass="error"/>
        </div>

        <div class="form-group">
            <label for="phone">Phone number</label>
            <form:input path="phone" id="phone"/>
            <form:errors path="phone" cssClass="error"/>
        </div>

        <div class="form-group">
            <label>Gender</label>
            <div class="radio-group">
                <label>
                    <form:radiobutton path="gender" value="Male"/> Male
                </label>
                <label>
                    <form:radiobutton path="gender" value="Female"/> Female
                </label>
            </div>
            <form:errors path="gender" cssClass="error"/>
        </div>

        <div class="form-group">
            <label for="address">Address</label>
            <form:textarea path="address" id="address" rows="3"/>
            <form:errors path="address" cssClass="error"/>
        </div>

        <div class="form-buttons">
            <a href="${pageContext.request.contextPath}/employees" class="btn btn-secondary">Back</a>
            <button type="submit" class="btn btn-primary">Register</button>
        </div>

    </form:form>
</div>
</body>
</html>