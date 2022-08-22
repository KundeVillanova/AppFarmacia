<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ page isELIgnored="false" %>

<html>
    <head>
        <link href="https://cdn.jsdelivr.net/npm/bootstrap@5.1.3/dist/css/bootstrap.min.css" rel="stylesheet" integrity="sha384-1BmE4kWBq78iYhFldvKuhfTAU6auU8tT94WrHftjDbrCEXSU1oBoqyl2QvZ6jIW3" crossorigin="anonymous">

        <title>Login</title>
    </head>
    <body>
            <div class="container">
                <div class="">
                    <h1>Faça Login</h1>
                    <hr>
                    <form action="/app_farm/index/logar" method="post">
                        <div class="form-group">
                            <label for="email">Email</label>
                            <input type="text" class="form-control" id="email" name="email">
                        </div>
                        <div class="form-group">
                            <label for="senha">Senha</label>
                            <input type="password" class="form-control" id="senha" name="senha">
                        </div>
                        <br>
                        <button type="submit" class="btn btn-primary" value="logar" name="logar">Logar</button>
                    </form>
                    <br>
                    <a class="btn btn-primary" href="/app_farm/index/criar">Criar conta</a>

                    <c:if test="${not empty erro}">
                        <h2>
                            <b>${erro}</b>
                        </h2>
                    </c:if>
                </div>
            </row>
        </div>
    </body>
</html>
