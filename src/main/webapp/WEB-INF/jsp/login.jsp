<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ page isELIgnored="false" %>

<html>
    <head>
        <link href="https://cdn.jsdelivr.net/npm/bootstrap@5.1.3/dist/css/bootstrap.min.css" rel="stylesheet" integrity="sha384-1BmE4kWBq78iYhFldvKuhfTAU6auU8tT94WrHftjDbrCEXSU1oBoqyl2QvZ6jIW3" crossorigin="anonymous">
        <title>Title</title>
    </head>
    <body>
        <div class="container">
            <h1>Login para entrar no sistema</h1>

            <form action="login" method="post">
                <div class="form-group">
                    <label for="email">Email</label>
                    <input type="text" class="form-control" id="email" name="email" placeholder="Enter email">
                </div>
                <div class="form-group">
                    <label for="senha">Senha</label>
                    <input type="password" class="form-control" id="senha" name="senha" placeholder="Password">
                </div>
                <br>
                <button type="submit" class="btn btn-primary" value="login" name="login">Login</button>
            </form>
            <br>
            <h4><a href="cad" class="btn btn-primary">Criar Conta</a></h4>

            <c:if test="${not empty erro}">
                <h2>
                    <b>${erro}</b>
                </h2>
            </c:if>
        </div>
    </body>
</html>
