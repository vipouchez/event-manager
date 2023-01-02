<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>

<link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/4.0.0/css/bootstrap.min.css" integrity="sha384-Gn5384xqQ1aoWXA+058RXPxPg6fy4IWvTNh0E263XmFcJlSAwiGgFAW/dAiS6JXm" crossorigin="anonymous">
<body>
<%@include file="navbar.html" %>
<br>
<div class=container>
<div class="card m-5 p-2">
 <div class="card-header"><h2>Add sponsor</h2></div>
<div class="card-body">
<form action="savesponsor" method=post  >

 <div class="mb-3 mt-3">
 <label for="name" class="form-label">Nom:</label>
 <input type=text class="form-control" id="name" name="name" value="${sponsor.name}">
 </div>

 <div class="mb-3 mt-3">
   <label for="name" class="form-label">Donation:</label>
    <input type=text class="form-control" id="donation" name="donation" value="${sponsor.donation}">
  </div>

<div class="mb-3">
  <label for="Event" class="form-label">Event :</label>
 <select name="event">
 <c:forEach items="${listEvent}" var="event">
 <option value="${event.id}">${event.name}</option>
 </c:forEach>
 </select>

  </div>

  </div>


 <button type="submit" class="btn btn-primary" >Save</button>
</form></div> </div></div></body>
