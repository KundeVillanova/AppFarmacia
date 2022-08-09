<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ page isELIgnored="false" %>

<html>
    <head>
        <link href="https://cdn.jsdelivr.net/npm/bootstrap@5.1.3/dist/css/bootstrap.min.css" rel="stylesheet" integrity="sha384-1BmE4kWBq78iYhFldvKuhfTAU6auU8tT94WrHftjDbrCEXSU1oBoqyl2QvZ6jIW3" crossorigin="anonymous">
        <link rel="stylesheet" href="<c:url value="/css/style.css"/>" type="text/css">
        <title>Controle de Funcionarios</title>
    </head>
    <body>

        <div class="container  mt-5">
            <div class="d-flex flex-column flex-lg-row gap-5">
                <div class="w-50">
                    <form:form methos="post" action="/app_farm/app/cadastrarFunc" modelAttribute="func">
                        <div class="form-group">
                            <form:label path="nome_func">Nome:</form:label>
                            <form:input path="nome_func" type="text" class="form-control" />
                        </div>

                        <div class="form-group">
                            <form:label path="telefone">Telefone:</form:label>
                            <form:input path="telefone" type="text" class="form-control" />
                        </div>

                        <div class="form-group">
                            <form:label path="data_nasc">Data de nascimento:</form:label>
                            <form:input path="data_nasc" type="text" class="form-control" />
                        </div>

                        <div class="form-group">
                            <form:label path="funcao">Função:</form:label>
                            <form:input path="funcao" type="text" class="form-control" />
                        </div>

                        <br>
                        <input type="submit"  class="btn btn-primary" value="CADASTRAR">
                    </form:form>
                    <a class="btn btn-primary" href="/app_farm/index/farmaciaIndex">Voltar</a>
                </div>

                <div class="w-50">
                    <table class="table table-success table-striped">
                        <tr>
                            <th>Nome funcionario</th>
                            <th>Telefone</th>
                            <th>Data de nascimento</th>
                            <th>Opções</th>
                        </tr>
                        <c:forEach var="f" items="${funcionarios}">
                            <tr>
                                <th>${f.nome_func}</th>
                                <th>${f.telefone}</th>
                                <th>${f.data_nasc}</th>
                                <td>
                                    <form action="cadastro-controller" method="get">
                                        <input type="hidden" name="id_func" value="${f.id_func}">
                                        <input type="hidden" name="opcao" value="editar" />
                                        <input type="submit" value="EDITAR" />
                                    </form>

                                    <form action="cadastro-controller" method="get">
                                        <input type="hidden" name="id_func" value="${f.id_func}">
                                        <input type="hidden" name="opcao" value="excluir" />
                                        <input type="submit" value="EXCLUIR" />
                                    </form>

                                </td>
                            </tr>
                        </c:forEach>
                    </table>
                </div>
            </div>
        </div>
    </body>
</html>
