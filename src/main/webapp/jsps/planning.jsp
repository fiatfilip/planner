<%--
  Created by IntelliJ IDEA.
  User: FiatF
  Date: 4/12/2018
  Time: 7:52 PM
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix = "c" uri = "http://java.sun.com/jsp/jstl/core" %>
<!doctype html>
<html lang="en">
<head>
    <!-- Required meta tags -->
    <meta charset="utf-8">
    <meta name="viewport" content="width=device-width, initial-scale=1, shrink-to-fit=no">

    <!-- Bootstrap CSS -->

    <!-- Latest compiled and minified CSS -->
    <link rel="stylesheet" href="//maxcdn.bootstrapcdn.com/bootstrap/4.1.0/css/bootstrap.min.css">
    <link rel="stylesheet" href="//maxcdn.bootstrapcdn.com/font-awesome/4.3.0/css/font-awesome.min.css">
    <!-- Latest compiled JavaScript -->
    <script src="https://maxcdn.bootstrapcdn.com/bootstrap/4.1.0/js/bootstrap.min.js"></script>

    <title>Planning</title>
</head>
<body>
    <div class="container">
        <nav class="navbar navbar-expand-lg navbar-light bg-light">
            <a class="navbar-brand" href="#">SIIT planner</a>
            <button class="navbar-toggler" type="button" data-toggle="collapse" data-target="#navbarSupportedContent" aria-controls="navbarSupportedContent" aria-expanded="false" aria-label="Toggle navigation">
                <span class="navbar-toggler-icon"></span>
            </button>

            <div class="collapse navbar-collapse" id="navbarSupportedContent">
                <ul class="navbar-nav mr-auto">
                    <li class="nav-item active">
                        <a class="nav-link" href="#">Plannings <span class="sr-only">(current)</span></a>
                    </li>
                    <li class="nav-item">
                        <a class="nav-link" href="#">Add planning</a>
                    </li>
                    <li class="nav-item dropdown">
                        <a class="nav-link dropdown-toggle " href="#" id="navbarDropdown" role="button" data-toggle="dropdown" aria-haspopup="true" aria-expanded="false">
                            Admin
                        </a>
                        <div class="dropdown-menu" aria-labelledby="navbarDropdown">
                            <a class="dropdown-item" href="#">Employees</a>
                            <a class="dropdown-item" href="#">Rooms</a>
                            <div class="dropdown-divider"></div>
                            <a class="dropdown-item" href="#">Something else here</a>
                        </div>
                    </li>
                    <li class="nav-item">
                        <a class="nav-link disabled" href="#">Disabled</a>
                    </li>
                </ul>
                <form class="form-inline my-2 my-lg-0">
                    <input class="form-control mr-sm-2" type="search" placeholder="Search" aria-label="Search">
                    <button class="btn btn-outline-success my-2 my-sm-0" type="submit">Search</button>
                </form>
            </div>
        </nav>
        <div class="row">
            <div class="col-md-12">
                <h3>Planning</h3>
            </div>
        </div>

        <form method="post">
            <div class="form-group row">
                <label for="room" class="col-sm-2 col-form-label">Room</label>
                <div class="col-sm-10">
                    <select class="form-control" id="room" name="room">
                        <c:forEach var="room" items="${requestScope.rooms}">
                            <option value="<c:out value="${room.roomId}"/>"><c:out value="${room.roomName}"/></option>
                        </c:forEach>
                    </select>
                </div>
            </div>
            <div class="form-group row" >
                <label for="employee" class="col-sm-2 col-form-label">Employee</label>
                <div class="col-sm-10">
                    <select class="form-control" id="employee" name="employee">
                        <c:forEach var="employee" items="${requestScope.employees}">
                            <option value="<c:out value="${employee.employeeId}"/>"><c:out value="${employee.employeeName}"/></option>
                        </c:forEach>
                    </select>
                </div>
            </div>
            <div class="form-group row" >
                <label for="startdate" class="col-sm-2 col-form-label">Start Date</label>
                <div class="col-sm-4">
                    <div class="input-group date">
                        <input name="startdate" id="startdate" type="date" class="form-control" />
                        <div class="input-group-prepend">
                            <span class="input-group-text"><i class="fa fa-calendar"></i></span>
                        </div>
                    </div>
                </div>
                <label for="enddate" class="col-sm-2 col-form-label">End Date</label>
                <div class="col-sm-4">
                    <div class="input-group date">
                        <input name="enddate" id="enddate" type="date" class="form-control" />
                        <div class="input-group-prepend">
                            <span class="input-group-text"><i class="fa fa-calendar"></i></span>
                        </div>
                    </div>
                </div>
            </div>

            <div class="form-group row" >
                <div class="col-sm-10 offset-sm-2">
                    <button type="submit" class="btn btn-primary">Add</button>
                </div>
            </div>
        </form>
    </div>

</body>
</html>
