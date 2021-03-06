<%-- Created by IntelliJ IDEA. --%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<!DOCTYPE html>
<html lang="en">
<head>
  <meta charset="UTF-8">
  <title>Chat App</title>
  <link rel="stylesheet" href="https://stackpath.bootstrapcdn.com/bootstrap/4.4.1/css/bootstrap.min.css"
        integrity="sha384-Vkoo8x4CGsO3+Hhxv8T/Q5PaXtkKtu6ug5TOeNV6gBiFeWPGFN9MuhOf23Q9Ifjh" crossorigin="anonymous">
</head>
<body>
<nav class="navbar navbar-dark bg-dark">
  <a class="navbar-brand" href="home.html">Chat App</a>
  <ul class="navbar-nav mr-auto d-flex flex-row justfiy-content-start">
    <li class="nav-item active mr-3">
      <a class="nav-link" href="Controller?command=Home">Home <span class="sr-only">(current)</span></a>
    </li>
    <li class="nav-item">
      <a class="nav-link" href="Controller?command=GoToChat">Chat</a>
    </li>
  </ul>
  <form class="form-inline my-2 my-lg-0">
    <input class="form-control mr-sm-2" type="search" placeholder="Search" aria-label="Search">
    <button class="btn btn-outline-info my-2 my-sm-0" type="submit">Search</button>
  </form>
</nav>

<div class="login-form d-flex justify-content-center w-25 m-auto">
  <form action="Controller?command=Login" method="post" class="flex-fill">
    <h2 class="text-center">Log in</h2>
    <div class="form-group">
      <input id="username" type="text" name="username" class="form-control" placeholder="Username">
    </div>
    <div class="form-group">
      <input id="password" type="password" name="password" class="form-control" placeholder="Password">
    </div>
    <div class="form-group d-flex">
      <input type="submit" class="btn btn-outline-info flex-fill" value="log in">
    </div>
    <p class="text-center"><a href="#">Create an Account</a></p>
  </form>
</div>

<div id="topics" class="container-fluid d-flex justify-content-center">
  <div class="topic" id="projectweek">
    <h5>Was het een interessante projectweek? </h5>
    <div>
      <input type="text" name="commentInput">
      <input type="number" name="rating">
      <button class="comment">send</button>
    </div>
  </div>
  <div class="topic" id="vandaag">
    <h5>Wat ben je van plan om te doen vandaag? </h5>
    <div>
      <input type="text" name="commentInput">
      <input type="number" name="rating">
      <button class="comment">send</button>
    </div>
  </div>
  <div class="topic" id="muziek">
    <h5 >Naar welke muziek ben je momenteel aan het luisteren ? </h5>
    <div>
      <input type="text" name="commentInput">
      <input type="number" name="rating">
      <button class="comment">send</button>
    </div>
  </div>
  <div class="topic" id="examenvraag">
    <h5>Wat zijn de examenvragen voor het vak web4 </h5>
    <div>
      <input type="text" name="commentInput">
      <input type="number" name="rating">
      <button class="comment">send</button>
    </div>
  </div>
  <div class="topic" id="corona">
    <h5>Wat vinden jullie van Corona ?</h5>
    <div>
      <input type="text" name="commentInput">
      <input type="number" name="rating">
      <button class="comment">send</button>
    </div>
  </div>
</div>

<script src="comments.js"></script>

<script src="https://code.jquery.com/jquery-3.4.1.js"
        integrity="sha256-WpOohJOqMqqyKL9FccASB9O0KwACQJpFTUBLTYOVvVU="
        crossorigin="anonymous"></script>
<script src="https://cdn.jsdelivr.net/npm/popper.js@1.16.0/dist/umd/popper.min.js"
        integrity="sha384-Q6E9RHvbIyZFJoft+2mJbHaEWldlvI9IOYy5n3zV9zzTtmI3UksdQRVvoxMfooAo"
        crossorigin="anonymous"></script>
<script src="https://stackpath.bootstrapcdn.com/bootstrap/4.4.1/js/bootstrap.min.js"
        integrity="sha384-wfSDF2E50Y2D1uUdj0O3uMBJnjuUD4Ih7YwaYd1iqfktj0Uod8GCExl3Og8ifwB6"
        crossorigin="anonymous"></script>
</body>
</html>