<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ page isELIgnored="false" %>

<html>
    <head>
        <link href="https://cdn.jsdelivr.net/npm/bootstrap@5.1.3/dist/css/bootstrap.min.css" rel="stylesheet" integrity="sha384-1BmE4kWBq78iYhFldvKuhfTAU6auU8tT94WrHftjDbrCEXSU1oBoqyl2QvZ6jIW3" crossorigin="anonymous">

        <title>Controle de Funcionarios</title>
    </head>
    <body>
        <div class="container">

            <h1>Bem vindo ${usuario_logado.nome}</h1>
            <h1>Funcionarios da ${farmacia.alias_farm}</h1>
            <h2><a class="btn btn-primary" href="/app_farm/farm/franquias">Voltar</a></h2>
            <hr>
            <div class="container">
                    <div>
                        <form:form methos="post" action="/app_farm/func/${acao}" modelAttribute="func">
                            <form:input path="farmacia.id_farm" value="${farmacia.id_farm}" type="hidden" />
                            <form:input path="id_func" type="hidden" />
                            <div class="form-group">
                                <form:label path="nome_func">Nome:</form:label>
                                <form:input path="nome_func" type="text" class="form-control" placeholder="Insira o nome do funcionario" />
                            </div>
                            <div class="form-group">
                                <form:label path="telefone">Telefone:</form:label>
                                <form:input path="telefone" type="text" class="form-control" placeholder="(99)9999999" />
                            </div>
                            <div class="form-group">
                                <form:label path="data_nasc">Data de nascimento:</form:label>
                                <form:input path="data_nasc" type="text" class="form-control"  placeholder="00/00/0000" />
                            </div>
                            <div class="form-group">
                                <form:label path="funcao">Função:</form:label>
                                <form:input path="funcao" type="text" class="form-control"  placeholder="Ex: Farmaceutico, Atendente, Estoquista, etc..." />
                            </div>
                            <br>
                            <input type="submit"  class="btn btn-primary" value="${acao}">
                        </form:form>
                    </div>
            </div>
            <br>
            <hr>
            <br>
            <table class="table table-bordered table-dark">
                <tr>
                    <th>Nome</th>
                    <th>Telefone</th>
                    <th>Data de nascimento</th>
                    <th>Cargo</th>
                    <th>Opções</th>
                </tr>
                <c:forEach var="f" items="${funcionarios}">
                    <tr>
                        <th>${f.nome_func}</th>
                        <th>${f.telefone}</th>
                        <th>${f.data_nasc}</th>
                        <th>${f.funcao}</th>
                        <th>
                            <a href="/app_farm/func/editar?id=${f.id_func}">Editar!</a>
                            <a href="/app_farm/func/excluir?id=${f.id_func}">Excluir!</a>
                        </th>
                    </tr>
                </c:forEach>
            </table>
        </div>
    </body>
</html>