<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ page isELIgnored="false" %>

<html>
    <head>
        <link href="https://cdn.jsdelivr.net/npm/bootstrap@5.1.3/dist/css/bootstrap.min.css" rel="stylesheet" integrity="sha384-1BmE4kWBq78iYhFldvKuhfTAU6auU8tT94WrHftjDbrCEXSU1oBoqyl2QvZ6jIW3" crossorigin="anonymous">
        <link rel="stylesheet" href="<c:url value="/css/style.css"/>" type="text/css">
        <title>Controle de Farmacias</title>
    </head>
    <body>

        <div class="container">
            <div class="d-inline-flex p-6 col">
                <form:form methos="post" action="/app_farm/index/criar" modelAttribute="farm">
                    <h1>Cadastrar Farmacia</h1>

                    <div class="form-group">
                        <form:label path="sigla_estado">Estado:</form:label>
                        <form:input path="sigla_estado" type="text" class="form-control" />
                    </div>

                    <div class="form-group">
                        <form:label path="nome_cidade">Nome da cidade:</form:label>
                        <form:input path="nome_cidade" type="text" class="form-control" />
                    </div>

                    <div class="form-group">
                        <form:label path="rua">Rua:</form:label>
                        <form:input path="rua" type="text" class="form-control" />
                    </div>

                    <div class="form-group">
                        <form:label path="cep">CEP:</form:label>
                        <form:input path="cep" type="text" class="form-control" />
                    </div>

                    <div class="form-group">
                        <form:label path="telefone">Telefone:</form:label>
                        <form:input path="telefone" type="text" class="form-control" />
                    </div>
                    <br>
                    <input type="submit"  class="btn btn-primary" value="CADASTRAR">
                </form:form>
            </div>
            <div class="d-inline-flex p-6 col">
                <table class="table table-success table-striped">
                        <tr class="table-success col">
                            <th>Alias Farmacia</th>
                            <th>Funcionario</th>
                            <th>Estoque</th>
                        </tr>

                        <tr class="table-success col">
                            <td>
                                <h1>ALIAS DA FARMACIA</h1>
                            </td>
                            <td>
                                <form action="" method="get">
                                    <input type="hidden" name="id_func" value="">
                                    <input type="hidden" name="opcao" value="editar" />
                                    <input type="submit" value="EDITAR" />
                                </form>
                            </td>
                            <td>
                                <form action="cadastro-controller" method="get">
                                    <input type="hidden" name="id_func" value="$">
                                    <input type="hidden" name="opcao" value="excluir" />
                                    <input type="submit" value="EXCLUIR" />
                                </form>
                            </td>
                        </tr>
                </table>
            </div>
        </div>
    </body>
</html>
