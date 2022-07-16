<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ page isELIgnored="false" %>

<html>
    <head>
        <link href="https://cdn.jsdelivr.net/npm/bootstrap@5.1.3/dist/css/bootstrap.min.css"
              rel="stylesheet" integrity="sha384-1BmE4kWBq78iYhFldvKuhfTAU6auU8tT94WrHftjDbrCEXSU1oBoqyl2QvZ6jIW3"
              crossorigin="anonymous">
        <title>Criar conta</title>
    </head>
    <body>
    <div class="container">

        <form action="cad" method="post">
            <h1>Criar conta</h1>

            <div class="form-group">
                <label for="nome">Your name</label>
                <input type="text" class="form-control" id="nome" name="nome" placeholder="Your name">
            </div>

            <div class="form-group">
                <label for="email">Email address</label>
                <input type="text" class="form-control" id="email" name="email" placeholder="Enter email">
            </div>

            <div class="form-group">
                <label for="senha">Password</label>
                <input type="password" class="form-control" id="senha" name="senha" placeholder="Password">
            </div>
            <br>
            <button type="submit" class="btn btn-primary" value="cad" name="cad">Cadastrar</button>
        </form>
        <br>
        <h4><a href="telalogin">Voltar!</a></h4>

        <c:if test="${not empty erro}">
            <h2>
                <b>${erro}</b>
            </h2>
        </c:if>

    </div>
    </body>
</html>
