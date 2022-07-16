<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ page isELIgnored="false" %>

<html>
    <head>
        <link href="https://cdn.jsdelivr.net/npm/bootstrap@5.1.3/dist/css/bootstrap.min.css"
              rel="stylesheet" integrity="sha384-1BmE4kWBq78iYhFldvKuhfTAU6auU8tT94WrHftjDbrCEXSU1oBoqyl2QvZ6jIW3"
              crossorigin="anonymous">
        <title>Cadastrar Funcionário</title>
    </head>
    <body>
        <div class="container">

            <form action="cadFarm" method="post">

                <h1>Cadastro Farmacia</h1>
                <div class="form-group">
                    <label for="nome">Localização : </label>
                    <input type="text" class="form-control" id="nome" name="nome" placeholder="insira seu nome aqui">
                </div>

                <div class="form-group">
                    <label for="nomefarm">Cadastrar Localização : </label>
                    <input type="text" class="form-control" id="nomefarm" name="nome" placeholder="insira seu nome aqui">
                </div>
                <br>
                <button type="submit" class="btn btn-primary" value="cadFarm" name="cadFarm">Cadastrar</button>
            </form>
            <h4><a href="login">Voltar!</a></h4>

            <c:if test="${not empty erro}">
                <h2>
                    <b>${erro}</b>
                </h2>
            </c:if>

        </div>
    </body>
</html>
