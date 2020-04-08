<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%--
  Created by IntelliJ IDEA.
  User: rafae
  Date: 31/03/2020
  Time: 13:09
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<!DOCTYPE html>
<html lang="en">
<head>
    <meta charset="UTF-8">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <title>Document</title>
    <link rel="stylesheet" href="https://stackpath.bootstrapcdn.com/bootstrap/4.4.1/css/bootstrap.min.css"
          integrity="sha384-Vkoo8x4CGsO3+Hhxv8T/Q5PaXtkKtu6ug5TOeNV6gBiFeWPGFN9MuhOf23Q9Ifjh" crossorigin="anonymous">
    <link rel="stylesheet" href="style.css">
</head>
<body>
<nav class="navbar navbar-dark bg-dark">
    <a class="navbar-brand" href="home.html">Chat App</a>
    <ul class="navbar-nav mr-auto d-flex flex-row justfiy-content-start">
        <li class="nav-item active mr-3">
            <a class="nav-link" href="Controller?Command=Home">Home <span class="sr-only">(current)</span></a>
        </li>
        <li class="nav-item">
            <a class="nav-link" href="Controller?command=GoToChat">Friends</a>
        </li>
    </ul>
    <div class="form-inline my-2 my-lg-0">
        <input id="name" name="name" class="form-control mr-sm-2" type="search" placeholder="Name" aria-label="Search">
        <button id="addfriend" class="btn btn-outline-info my-2 my-sm-0" type="submit">Search</button>
    </div>
    <form method="post" action="Controller?command=Logout" class="form-inline my-2 my-lg-0">
        <button id="logout" class="btn btn-info ml-3" type="submit">logout</button>
    </form>
</nav>
<h1 id="h1" class="d-flex justify-content-center">${friend.name}</h1>
<div class="d-flex flex-row">
<div id="main" class="d-flex flex-row">
    <div class="d-flex flex-column">
        <button class="w-15" id="hidebutton">hide friends</button>
        <div id="friends">
            <div class="d-flex flex-column border rounded w-15">
                <p class="${sessionScope.user.friendlist == null or empty sessionScope.user.friendlist ? "" : "d-none"}">je hebt nog geen vrienden</p>
                <c:forEach var="friend" items="${sessionScope.user.friendlist}">
                    <div id="friendlist" class="friend border-dark">
                        <img class="img" src="prof.png" alt="profile picture">
                        <a class="" href="Controller?command=GoToChat&friend=${friend.name}">${friend.name}</a>
                    </div>
                </c:forEach>
            </div>
        </div>
    </div>
</div>
    <main class="messaging d-flex flex-column m-1 w-100" >
        <c:if test="${friend != null}">
            <section id="chat-box" class="clearfix w-100">
                <ul class="messages clearfix" id="messages">

                </ul>
                <div class="d-flex">
                    <input id="input" class="flex-grow-1 input" type="text" name="message">
                    <button id="send" class="flex-grow-5">send</button>
                </div>
            </section>
        </c:if>

    </main>
</div>
<script src="https://code.jquery.com/jquery-3.4.1.js"
        integrity="sha256-WpOohJOqMqqyKL9FccASB9O0KwACQJpFTUBLTYOVvVU="
        crossorigin="anonymous"></script>
<script src="https://cdn.jsdelivr.net/npm/popper.js@1.16.0/dist/umd/popper.min.js"
        integrity="sha384-Q6E9RHvbIyZFJoft+2mJbHaEWldlvI9IOYy5n3zV9zzTtmI3UksdQRVvoxMfooAo"
        crossorigin="anonymous"></script>
<script src="https://stackpath.bootstrapcdn.com/bootstrap/4.4.1/js/bootstrap.min.js"
        integrity="sha384-wfSDF2E50Y2D1uUdj0O3uMBJnjuUD4Ih7YwaYd1iqfktj0Uod8GCExl3Og8ifwB6"
        crossorigin="anonymous"></script>
<script src="https://code.jquery.com/ui/1.12.1/jquery-ui.js"></script>
<script src="chat.js"></script>
</body>
</html>
