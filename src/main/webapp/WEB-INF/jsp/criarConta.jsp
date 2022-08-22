<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ page isELIgnored="false" %>

<html>
    <head>
        <link href="https://cdn.jsdelivr.net/npm/bootstrap@5.1.3/dist/css/bootstrap.min.css" rel="stylesheet" integrity="sha384-1BmE4kWBq78iYhFldvKuhfTAU6auU8tT94WrHftjDbrCEXSU1oBoqyl2QvZ6jIW3" crossorigin="anonymous">
        <title>Farmaapp - Criar conta</title>
    </head>
    <body>
        <div class="container">
            
           <%--@elvariable id="user" type=""--%>
           <form:form methos="post" action="/app_farm/index/criar" modelAttribute="user">
                <h1>Criar conta</h1>
                <hr>
                <div class="form-group">
                    <form:label path="nome">Nome:</form:label>
                    <form:input path="nome" type="text" class="form-control" placeholder="Digite seu nome de usuario" />
                </div>

                <div class="form-group">
                    <form:label path="email">Email:</form:label>
                    <form:input path="email" type="text" class="form-control" placeholder="Digite seu email"/>
                </div>

                <div class="form-group">
                    <form:label path="senha">Senha:</form:label>
                    <form:input path="senha" type="password" class="form-control" />
                </div>
                <br>
                <input type="submit"  class="btn btn-primary" value="CADASTRAR">
           </form:form>
            <br>
            <a class="btn btn-primary" href="/app_farm/index/login">Login</a>
        </div>
    </body>
</html>
