<%--
  Created by IntelliJ IDEA.
  User: dima
  Date: 21.02.2022
  Time: 19:47
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>


<!DOCTYPE html>
<html lang="pl">

<head>

    <meta charset="UTF-8">
    <meta http-equiv="X-UA-Compatible" content="IE=edge">
    <meta name="viewport" content="width=device-width, initial-scale=1, shrink-to-fit=no">
    <meta name="description" content="">
    <meta name="author" content="">

    <title>UsersCRUD</title>

    <!-- Custom fonts for this template-->
    <link href="<c:url value="/theme/vendor/fontawesome-free/css/all.min.css"/>" rel="stylesheet" type="text/css">
    <link href="https://fonts.googleapis.com/css?family=Nunito:200,200i,300,300i,400,400i,600,600i,700,700i,800,800i,900,900i"
          rel="stylesheet">

    <!-- Custom styles for this template-->
    <link href="<c:url value="/theme/css/sb-admin-2.min.css"/>" rel="stylesheet">

</head>

<body id="page-top">

<%@ include file="/header.jsp" %>
<!-- Begin Page Content -->
<div class="container-fluid">

    <!-- Page Heading -->
    <div class="d-sm-flex align-items-center justify-content-between mb-4">
        <h1 class="h3 mb-0 text-gray-800">UsersCRUD</h1>
        <a href="<c:url value="/user/add"/>" class="d-none d-sm-inline-block btn btn-sm btn-primary shadow-sm">Dodaj
            użytkownika</a>
    </div>



    <div class="card-body">
        <div class="table-responsive">
            <table class="table">

<%--                <thead>--%>
                <tr>
                    <th >ID</th>
                    <th >Nazwa użytkownika</th>
                    <th >Email</th>
                    <th>Akcja</th>
                </tr>
<%--                </thead>--%>

<%--                    <tbody>--%>
                    <c:forEach items="${users}" var="user">
                    <tr>
                        <td>${user.id}</td>
                        <td>${user.userName}</td>
                        <td>${user.email}</td>
                        <td>
                            <a href="= <c:url value="/user/delete?id=${user.id}"/>"> Usuń </a>
                            <a href="=<c:url value="/user/edit?id=${user.id}"/>"> Edytuj </a>
                            <a href="<c:url value="/users/show.jsp?id=${user.id}"/>"> Pokaż </a>
                        </td>
                    </tr> </c:forEach>
<%--                    </tbody>--%>



            </table>


        </div>
    </div>


</div>
<!-- /.container-fluid -->
<%@ include file="/footer.jsp" %>
</body>

</html>

