<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ page isELIgnored="false" %>

<html>
    <head>
        <link href="https://cdn.jsdelivr.net/npm/bootstrap@5.1.3/dist/css/bootstrap.min.css" rel="stylesheet" integrity="sha384-1BmE4kWBq78iYhFldvKuhfTAU6auU8tT94WrHftjDbrCEXSU1oBoqyl2QvZ6jIW3" crossorigin="anonymous">
        <link rel="stylesheet" href="<c:url value="/css/style.css"/>" type="text/css">
        <title>Farmaapp - Criar conta</title>
    </head>
    <body>
        <div class="container">
            
           <%--@elvariable id="user" type="br.csi.model.usuario.Usuario"--%>
           <form:form methos="post" action="/app_farm/index/criar" modelAttribute="user">
                <h1>Criar conta</h1>

                <div class="form-group">
                    <form:label path="nome">Nome:</form:label>
                    <form:input path="nome" type="text" class="form-control" />
                </div>

                <div class="form-group">
                    <form:label path="email">Email:</form:label>
                    <form:input path="email" type="text" class="form-control" />
                </div>

                <div class="form-group">
                    <form:label path="senha">Senha:</form:label>
                    <form:input path="senha" type="text" class="form-control" />
                </div>
                <br>
                <button type="submit" class="btn btn-primary" value="cadastrar">Cadastrar</button>
           </form:form>

            <br>

        </div>
    </body>
</html>
