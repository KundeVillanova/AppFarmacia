<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ page isELIgnored="false" %>

<html>
    <head>
        <link href="https://cdn.jsdelivr.net/npm/bootstrap@5.1.3/dist/css/bootstrap.min.css" rel="stylesheet" integrity="sha384-1BmE4kWBq78iYhFldvKuhfTAU6auU8tT94WrHftjDbrCEXSU1oBoqyl2QvZ6jIW3" crossorigin="anonymous">

        <title>Controle de Estoque</title>
    </head>
    <body>
        <div class="container">
             <h1>Bem vindo ${usuario_logado.nome}</h1>
            <h1>Estoque da farmacia ${farmacia.alias_farm}</h1>
            <h2><a class="btn btn-primary" href="/app_farm/farm/franquias">Voltar</a></h2>
            <hr>

            <form:form method="post" action="/app_farm/esto/${acao}" modelAttribute="prod">
                <form:input path="farmacia.id_farm" value="${farmacia.id_farm}" type="hidden" />
                <form:input path="id_produto" type="hidden" />
                <div class="form-group">
                    <form:label path="nome_produto">Nome:</form:label>
                    <form:input path="nome_produto" type="text" class="form-control"  placeholder="Nome do produto" />
                </div>
                <div class="form-group">
                    <form:label path="categoria">Categoria:</form:label>
                    <form:input path="categoria" type="text" class="form-control" placeholder="Ex: Higiene, Remeédio, etc..." />
                </div>
                <div class="form-group">
                    <form:label path="marca">Marca:</form:label>
                    <form:input path="marca" type="text" class="form-control"  placeholder="Insira marca do produto" />
                </div>
                <div class="form-group">
                    <form:label path="quantidade">Quantidade:</form:label>
                    <form:input path="quantidade" type="text" class="form-control"  placeholder="Insira a quantidade de caixas"/>
                </div>
                <br>
                <input type="submit"  class="btn btn-primary" value="${acao}">
            </form:form>
            <br>
            <hr>
            <br>
            <table class="table table-bordered table-dark">
                <tr>
                    <th>Nome</th>
                    <th>Categoria</th>
                    <th>Marca</th>
                    <th>Quantidade</th>
                    <th>Opções</th>
                </tr>
                <c:forEach var="p" items="${prods}">
                    <tr>
                        <th>${p.nome_produto}</th>
                        <th>${p.categoria}</th>
                        <th>${p.marca}</th>
                        <th>${p.quantidade}</th>
                        <td>
                            <a href="/app_farm/esto/editar?id=${p.id_produto}">Editar! </a>
                            <a href="/app_farm/esto/excluir?id=${p.id_produto}">Excluir!</a>
                        </td>
                    </tr>
                </c:forEach>
            </table>
        </div>
    </body>
</html>

