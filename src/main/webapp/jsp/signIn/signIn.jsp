<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html lang="en">
  <head>
    <meta charset="utf-8">
    <meta http-equiv="X-UA-Compatible" content="IE=edge">
    <meta name="viewport" content="width=device-width, initial-scale=1">
    <meta name="description" content="">
    <meta name="author" content="">
    <link rel="icon" href="/images/icos/favicon.ico">

    <title>XX系统</title>

    <!-- Bootstrap core CSS -->
    <link href="/frames/bootstrap-3.3.7/dist/css/bootstrap.min.css" rel="stylesheet">

    <link href="../../css/signIn/signin.css" rel="stylesheet">
      <script type="text/javascript" src="/js/jquery1.11.3.min.js"></script>

  </head>

  <body>

    <div class="container">

      <form class="form-signin" method="post" >
        <h2 class="form-signin-heading">请登录</h2>
        <label for="inputEmail" class="sr-only">User name</label>
        <input type="text" id="inputEmail" class="form-control" placeholder="User name" required autofocus>
        <label for="inputPassword" class="sr-only">Password</label>
        <input type="password" id="inputPassword" class="form-control" placeholder="Password" required>
        <div class="checkbox">
          <label>
            <input type="checkbox" value="remember-me"> 记 住
          </label>
        </div>
        <button class="btn btn-lg btn-primary btn-block" onclick="signIn()" type="button">登 录</button>
      </form>

    </div>

  </body>

  <script language="javascript" type="text/javascript">
        function signIn() {
            var inputEmail = jQuery("#inputEmail").val();
            alert(inputEmail);
            window.location.href='<%=request.getContextPath()%>/sign/signIn.do?inputEmail='+inputEmail;
        }
    </script>
</html>
