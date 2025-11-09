<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ page isErrorPage="true" %>
<!DOCTYPE html>
<html>
<head>
 <meta charset="UTF-8">
 <title>Error</title>
 <link rel="stylesheet" href="${pageContext.request.contextPath}/styles/bootstrap.min.css">
</head>
<body>
<div class="container mt-5">
 <div class="card border-danger">
  <div class="card-header bg-danger text-white">
   <h2>Error Occurred</h2>
  </div>
  <div class="card-body">
   <div class="alert alert-danger">
    <h4>Sorry, an error occurred!</h4>
    <p><strong>Error:</strong> ${pageContext.exception.message}</p>
    <c:if test="${not empty pageContext.errorData.statusCode}">
     <p><strong>Status Code:</strong> ${pageContext.errorData.statusCode}</p>
    </c:if>
   </div>
   <a href="${pageContext.request.contextPath}/employees" class="btn btn-primary">
    Back to Employee List
   </a>
  </div>
 </div>
</div>
</body>
</html>
