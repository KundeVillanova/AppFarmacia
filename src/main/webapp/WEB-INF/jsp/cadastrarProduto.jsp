<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ page isELIgnored="false" %>

<html>
    <head>
        <link href="https://cdn.jsdelivr.net/npm/bootstrap@5.1.3/dist/css/bootstrap.min.css"
              rel="stylesheet" integrity="sha384-1BmE4kWBq78iYhFldvKuhfTAU6auU8tT94WrHftjDbrCEXSU1oBoqyl2QvZ6jIW3"
              crossorigin="anonymous">
        <title>Cadastrar Produto</title>
    </head>
    <body>
        <div class="container">

            <form action="cadProd" method="post">
                <h1>Cadastro Produto</h1>

                <div class="form-group">
                    <label for="nome">Nome produto : </label>
                    <input type="text" class="form-control" id="nome" name="nome" placeholder="Nome do porduto">
                </div>

                <div class="form-group">
                    <label for="quantidade">Quantidade : </label>
                    <input type="text" class="form-control" id="quantidade" name="quantidade" placeholder="insira quantidade">
                </div>

                <div class="form-group">
                    <label for="tipo">Tipo : </label>
                    <input type="text" class="form-control" id="tipo" name="tipoProd" placeholder="insira o tipo do producto">
                </div>

                <br>
                <button type="submit" class="btn btn-primary" value="cadProd" name="cadProd">Cadastrar Produto</button>
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
