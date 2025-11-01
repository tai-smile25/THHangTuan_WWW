<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
<!DOCTYPE html>
<html>
<head>
    <meta charset="UTF-8">
    <title>Employee List</title>
    <style>
        body {
            font-family: Arial, sans-serif;
            margin: 20px;
            background-color: #f5f5f5;
        }
        .container {
            background-color: white;
            padding: 20px;
            border-radius: 8px;
            box-shadow: 0 2px 4px rgba(0,0,0,0.1);
        }
        h1 {
            text-align: center;
            color: #333;
            margin-bottom: 30px;
        }
        .header-buttons {
            text-align: right;
            margin-bottom: 20px;
        }
        .btn {
            padding: 8px 16px;
            border: none;
            border-radius: 4px;
            cursor: pointer;
            text-decoration: none;
            display: inline-block;
            margin-left: 5px;
        }
        .btn-primary {
            background-color: #007bff;
            color: white;
        }
        .btn-secondary {
            background-color: #6c757d;
            color: white;
        }
        .btn-success {
            background-color: #28a745;
            color: white;
        }
        .btn-danger {
            background-color: #dc3545;
            color: white;
        }
        .btn:hover {
            opacity: 0.8;
        }
        table {
            width: 100%;
            border-collapse: collapse;
            margin-top: 20px;
        }
        th, td {
            padding: 12px;
            text-align: left;
            border-bottom: 1px solid #ddd;
        }
        th {
            background-color: #f8f9fa;
            font-weight: bold;
        }
        tr:hover {
            background-color: #f5f5f5;
        }
        .alert {
            padding: 10px;
            margin-bottom: 20px;
            border-radius: 4px;
            background-color: #d4edda;
            color: #155724;
            border: 1px solid #c3e6cb;
        }
    </style>
</head>
<body>
<div class="container">
    <h1>EMPLOYEE LIST</h1>

    <!-- Success Message -->
    <c:if test="${not empty message}">
        <div class="alert">${message}</div>
    </c:if>

    <!-- Header Buttons -->
    <div class="header-buttons">
        <a href="${pageContext.request.contextPath}/employees" class="btn btn-secondary">Search</a>
        <a href="${pageContext.request.contextPath}/employees/add" class="btn btn-primary">Add Employee</a>
    </div>

    <!-- Employee Table -->
    <table>
        <thead>
        <tr>
            <th>First Name</th>
            <th>Last Name</th>
            <th>Gender</th>
            <th>Date of Birth</th>
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
                <td>
                    <fmt:formatDate value="${employee.dateOfBirth}" pattern="yyyy-MM-dd HH:mm:ss.S"/>
                </td>
                <td>${employee.email}</td>
                <td>${employee.phone}</td>
                <td>
                    <a href="${pageContext.request.contextPath}/employees/edit/${employee.id}" class="btn btn-success">Update</a>
                    <a href="${pageContext.request.contextPath}/employees/delete/${employee.id}"
                       class="btn btn-danger"
                       onclick="return confirm('Are you sure you want to delete this employee?')">Delete</a>
                </td>
            </tr>
        </c:forEach>
        <c:if test="${empty employees}">
            <tr>
                <td colspan="7" style="text-align: center;">No employees found</td>
            </tr>
        </c:if>
        </tbody>
    </table>
</div>
</body>
</html>