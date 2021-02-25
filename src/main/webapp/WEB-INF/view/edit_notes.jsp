<%@page import="org.hibernate.Session"%>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head> 

  <%@include file="all_js_css.jsp" %>
<meta charset="ISO-8859-1">
<title>Insert title here</title>
 <div class="container-fluid p-0 m-0">
       <%@include file="navbar.jsp" %>
       </div>

</head>
<body>  


   <form action="save" method="post">
  <div class="form-group">
    <label for="title">Note Title</label>
    <input required type="text" name="title" class="form-control" id="title" placeholder="enter text here" value="">
   </div>
  <div class="form-group">
    <label for="content">Note Content</label>
    <textarea required id="content" name="content" placeholder="Enter the content" class="form-control"   style="height: 200px;"> </textarea>
   </div>
 <div class="continer text-center">
  <button type="submit" class="btn btn-primary">Save your note</button>
  </div>
</form>

</body>
</html>