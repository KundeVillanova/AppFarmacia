<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ page isELIgnored="false" %>

<html>
    <head>
        <link href="https://cdn.jsdelivr.net/npm/bootstrap@5.1.3/dist/css/bootstrap.min.css" rel="stylesheet" integrity="sha384-1BmE4kWBq78iYhFldvKuhfTAU6auU8tT94WrHftjDbrCEXSU1oBoqyl2QvZ6jIW3" crossorigin="anonymous">

        <title>Controle de Farmacias</title>
    </head>
    <body>

        <div class="container">
            <h1>Bem vindo ${usuario_logado.nome}</h1>
            <br>
            <form:form method="post" action="/app_farm/index/logout"><input type="submit" value="logout"></form:form>
            <hr>

            <form:form method="post" action="/app_farm/farm/${acao}" modelAttribute="farm">
                <form:input path="id_farm" type="hidden" />
            <div class="form-group">
                <form:label class="form-label" path="alias_farm">Nome da farmacia: </form:label>
                <form:input class="form-control" path="alias_farm" type="text"  placeholder="Digite um alias para Farmacia" />
            </div>
            <div class="form-group">
                <form:label class="form-label" path="telefone">Telefone: </form:label>
                <form:input class="form-control" path="telefone" type="text"  placeholder="(00)00000000" />
            </div>
            <div class="form-group">
                <form:label class="form-label" path="estado">Estado: </form:label>
                <form:input class="form-control" path="estado" type="text"  placeholder="Digite o nome do estado" />
            </div>
            <div class="form-group">
                <form:label class="form-label" path="cidade">Cidade: </form:label>
                <form:input class="form-control" path="cidade" type="text"  placeholder="Digite o nome da cidade" />
            </div>
            <div class="form-group">
                <form:label class="form-label" path="rua">Rua: </form:label>
                <form:input class="form-control" path="rua" type="text" placeholder="Digite o nome da rua" />
            </div>
            <div class="form-group">
                <form:label class="form-label" path="cep">CEP: </form:label>
                <form:input class="form-control" path="cep" type="text"  placeholder="Digiteo o Cep" />
            </div>
                <br>
                <input type="submit" value="${acao}">
            </form:form>
            <br>
            <hr>
            <br>
            <table class="table table-bordered table-dark">
                <tr>
                    <th>Alias</th>
                    <th>Telefone</th>
                    <th>Estado</th>
                    <th>Cidade</th>
                    <th>Rua</th>
                    <th>Cep</th>
                </tr>
                <c:forEach var="f" items="${farmacias}">
                    <tr>
                        <th>${f.alias_farm}</th>
                        <th>${f.telefone}</th>
                        <th>${f.estado}</th>
                        <th>${f.cidade}</th>
                        <th>${f.rua}</th>
                        <th>${f.cep}</th>
                    </tr>
                    <tr class="table-success">
                        <th>Opções :</th>
                        <th>
                            <a href="/app_farm/farm/editar?id_farm=${f.id_farm}">Editar</a>
                        </th>
                        <th>
                            <a href="/app_farm/farm/excluir?id_farm=${f.id_farm}">Excluir</a>
                        </th>
                        <th>
                            <a href="/app_farm/func/irFuncionario?id_farm=${f.id_farm}">Funcionarios</a>
                        </th>
                        <th>
                            <a href="/app_farm/esto/irEstoque?id_farm=${f.id_farm}">Estoque</a>
                        </th>
                        <th>
                            <a href="/app_farm/farm/irRelatorio?id_farm=${f.id_farm}">Relatorio</a>
                        </th>
                    </tr>
                </c:forEach>
            </table>
        </div>
    </body>
</html>
