<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8" isELIgnored="false"%>
   <%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
<%@include file="Components/allcss.jsp" %>
</head>
<body style="background-color:pink;">
<%@include file ="Components/admin_navbar.jsp" %>
<h1 class="text-center text-success fs-2">Welcome to Admin Home Page</h1>
<a href="add_student" class="btn btn-sm btn-secondary btn-white">Add Student</a>
 <table border="2px">
    <tr>
      <th>Name</th>
      <th>Age</th>
      <th>Mobile</th>
      <th>Email</th>
      <th>Action</th>
    </tr>
    <c:forEach var="s" items="${students}">
    <tr>
      <td>${s.getName()}</td>
      <td>${s.getAge()}</td>
      <td>${s.getMobile()}</td>
      <td>${s.getEmail()}</td>
      <td><a href="update_student?stdId=${s.getId()}">Update</a></td>
      <td><a href="delete_student?stdId=${s.getId()}">Delete</a></td>
    </tr>
    </c:forEach>
   </table>
  
</body>
</html>