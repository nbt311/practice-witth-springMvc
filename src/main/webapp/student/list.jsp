<%--
  Created by IntelliJ IDEA.
  User: nbtru
  Date: 12/9/2023
  Time: 3:38 PM
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<html>
<head>
    <title>Title</title>
    <meta name="viewport" content="width=device-width, initial-scale=1">
    <link href="https://netdna.bootstrapcdn.com/bootstrap/3.3.6/css/bootstrap.min.css" rel="stylesheet">
    <link href="https://cdn.jsdelivr.net/npm/bootstrap@5.0.2/dist/css/bootstrap.min.css" rel="stylesheet">
    <link rel="stylesheet" href="https://cdn.jsdelivr.net/npm/bootstrap-icons@1.5.0/font/bootstrap-icons.css">
    <link rel="stylesheet" href="css/list.css">
</head>
<body>
<div class="container">
    <div class="m-4">
        <nav class="navbar navbar-expand-lg navbar-dark bg-primary">
            <div class="container-fluid">
                <a href="/student?action=add" class="navbar-brand">Add Student</a>
                <button type="button" class="navbar-toggler" data-bs-toggle="collapse"
                        data-bs-target="#navbarCollapse2">
                    <span class="navbar-toggler-icon"></span>
                </button>
                <div class="collapse navbar-collapse" id="navbarCollapse2">
                    <form class="d-flex ms-auto" method="get">
                        <input type="text" class="form-control me-sm-2" name="key" value="${key}">
                        <button type="submit" class="btn btn-outline-light">Search</button>
                    </form>
                </div>
            </div>
        </nav>
    </div>
    <div class="row">
        <div class="col-lg-12">
            <div class="main-box clearfix">
                <div class="table-responsive">
                    <table class="table user-list">
                        <thead>
                        <tr>
                            <th><span>#</span></th>
                            <th><span>Name</span></th>
                            <th><span>Date Of Birth</span></th>
                            <th><span>Email</span></th>
                            <th><span>Address</span></th>
                            <th><span>Phone</span></th>
                            <th><span>ClassRoom</span></th>
                            <th><span>Action</span></th>
                        </tr>
                        </thead>

                        <tbody>
                        <c:forEach items="${list}" var="student">
                        <tr>
                            <td>
                                    ${student.getId()}
                            </td>
                            <td>
                                    ${student.getName()}
                            </td>
                            <td class="text-center">
                                <span class="label label-default">${student.getDateOfBirth()}</span>
                            </td>
                            <td>
                                <span class="__cf_email__"
                                      data-cfemail="e78a8e8b86a78c92898e94c984888a">${student.getEmail()}</span>
                            </td>
                            <td class="address">
                                    ${student.getAddress()}
                            </td>
                            <td>
                                    ${student.getPhone()}
                            </td>
                            <td>
                                    ${student.getClassRoom()}
                            </td>
                            <td>
                                <button><a href="/student/${student.getId()}" class="table-link">
    <span class="fa-stack">
    <i class="fa fa-square fa-stack-2x"></i>
    <i class="fa fa-pencil fa-stack-1x fa-inverse"></i>
    </span>
                                    View</a></button>
                                <button><a href="/student?action=edit&id=${student.getId()}" class="table-link">
    <span class="fa-stack">
    <i class="fa fa-square fa-stack-2x"></i>
    <i class="fa fa-pencil fa-stack-1x fa-inverse"></i>
    </span>
                                    Edit</a></button>
                                <button><a onclick="return confirm('Are you sure?')"
                                           href="/student?action=delete&id=${student.getId()}"
                                           class="table-link danger">
    <span class="fa-stack">
    <i class="fa fa-square fa-stack-2x"></i>
    <i class="fa fa-trash-o fa-stack-1x fa-inverse"></i>
    </span>
                                    Delete</a></button>
                            </td>
                        </tr>
                        <tr>
                            </c:forEach>
                </div>
            </div>
        </div>
    </div>
</div>
</body>
</html>
