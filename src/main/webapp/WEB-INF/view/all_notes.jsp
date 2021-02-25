<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1" isELIgnored="false"%>
	<%@include file="navbar.jsp"%>
	<%@include file="all_js_css.jsp"%>
	<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html>
<html>
<head>
<style>
img
{
height: 90px;
width: 100px;
margin-bottom: 1%;

}
</style>
<meta charset="ISO-8859-1">
<title>Insert title here</title>

<style>
h1
{
font-family: cursive;
}
</style>

</head>
<body>
	
	<div class="container-fluid p-0 m-0 text-center">
	<br>
	
	
	<h1 class="text-uppercase">All notes:</h1>
     <a href="new" class="btn btn-primary"> Add New Note</a>
     <br>
	<div class="text-uppercase">
		<div class="col-12">


            <c:forEach items="${listofrecords}" var="n" varStatus="status">
            		<div class="card ">
					
				<div class="card-body">
					   
					<img src="https://res.cloudinary.com/practicaldev/image/fetch/s--qf__txuB--/c_imagga_scale,f_auto,fl_progressive,h_900,q_auto,w_1600/https://dev-to-uploads.s3.amazonaws.com/i/fogwo79x50l7gk7x76ga.jpg">
	
						<h5 class="card-title">${n.id}</h5>
						<h5 class="card-title">${n.title}</h5>
						<p class="card-text">${n.content}</p>
						</div>
					
                    
					<div class="container text-center">
						<a href="delete?id= ${n.id} " class="btn btn-danger">Delete</a>

						<a href="update?id=${n.id}" class="btn btn-primary">Update</a>
					</div>
				</div>
			
        </c:forEach>
		</div>
	</div>

 </div>
</body>
</html>