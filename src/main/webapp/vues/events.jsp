<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/4.0.0/css/bootstrap.min.css" integrity="sha384-Gn5384xqQ1aoWXA+058RXPxPg6fy4IWvTNh0E263XmFcJlSAwiGgFAW/dAiS6JXm" crossorigin="anonymous">
<body>
<%@include file="navbar.html"%>
<br><br>
<form method=get action=eventmc>
<div class=container>
<div class="row mt-4 pl-2">
<div class="col-md-1">
<label for="mc" class="form-label">Mot Cle:</label>
</div>
<div class="col-md-3">
<input type="text" id="mc" class="form-control" name=mc>
</div>
<div class="col-md-3">
<button type="submit" class="btn btn-primary">Search</button>
<a href="/eventapi/addevent" class="btn btn-primary" > Add Event </a>
</div> </div> </div> </form>
<br><hr>
<table class="table table-hover">
<tr>
 <th>Id</th><th>Name</th><th>Price</th><th>Animator</th><th>Theme</th><th>Picture</th><th>Action</th>
 <th>sponsors</th><th>address</th>
</tr>
<c:forEach items="${events}" var="e">
<tr>
<td>${e.id}</td>
<td>${e.name}</td>
<td>${e.price }</td>
<td>${e.animator}</td>
<td>${e.theme.name}</td>

<td> <img src="/eventapi/images/${e.picture}"  width="50" height="50" /> </td>


<td> <form action="deleteevent/${e.id}" method="post">
         <button type="submit" class="btn btn-primary">Delete</button></form>
         <a href="/eventapi/event/${e.id}" class="btn btn-primary" > update </a>
</td>

<td>${e.sponsors}</td>
<td>${e.address.city} , ${e.address.district}</td>

</tr>
</c:forEach>
</table>
</body>
