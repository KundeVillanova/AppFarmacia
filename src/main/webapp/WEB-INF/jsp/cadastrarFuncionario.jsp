<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ page isELIgnored="false" %>

<html>
    <head>
        <link href="https://cdn.jsdelivr.net/npm/bootstrap@5.1.3/dist/css/bootstrap.min.css" rel="stylesheet" integrity="sha384-1BmE4kWBq78iYhFldvKuhfTAU6auU8tT94WrHftjDbrCEXSU1oBoqyl2QvZ6jIW3" crossorigin="anonymous">
        <script defer src="https://cdn.jsdelivr.net/npm/@popperjs/core@2.11.5/dist/umd/popper.min.js" integrity="sha384-Xe+8cL9oJa6tN/veChSP7q+mnSPaj5Bcu9mPX5F5xIGE0DVittaqT5lorf0EI7Vk" crossorigin="anonymous"></script>
        <script defer src="https://cdn.jsdelivr.net/npm/bootstrap@5.2.0-beta1/dist/js/bootstrap.min.js" integrity="sha384-kjU+l4N0Yf4ZOJErLsIcvOU2qSb74wXpOhqTvwVx3OElZRweTnQ6d31fXEoRD1Jy" crossorigin="anonymous"></script>
        <title>Cadastrar Funcionário</title>
    </head>
    <body>
        <div class="container">
            <form action="cadFunc" method="post">
                <h1>Cadastro Funcionario</h1>

                    <div class="form-group">
                        <label for="nome">Nome Funcionário: </label>
                        <input type="text" class="form-control" id="nome" name="nome" placeholder="insira o nome aqui">
                    </div>

                    <div class="form-group">
                        <label for="telefone">Telefone</label>
                        <input type="text" class="form-control" id="telefone" name="telefone" placeholder="(99)99999-9999">
                    </div>

                    <div class="form-group">
                        <label for="nascimento">Data de nascimento</label>
                        <input type="text" class="form-control" id="nascimento" name="data" placeholder="00 / 00 / 0000">
                    </div>

                <div class="dropdown">
                    <a class="btn btn-secondary dropdown-toggle" href="#" role="button" id="dropdownMenuLink" data-bs-toggle="dropdown" aria-expanded="false">
                        Função
                    </a>
                    <ul class="dropdown-menu" aria-labelledby="dropdownMenuLink">
                        <li>farmaceutico</li>
                        <li>atendente</li>
                        <li>estoquista</li>
                    </ul>
                </div>
                <br>
                <button type="submit" class="btn btn-primary" value="cadFunc" name="cadFunc">Cadastrar</button>
            </form>

                <br>
                <br>
                <table class="table table-success table-striped">
                    <tr>
                        <th>ID</th>
                        <th>Nome funcionario</th>
                        <th>Telefone</th>
                        <th>Data de nascimento</th>
                        <th>Opções</th>
                    </tr>
                    <c:forEach var="f" items="${funcionarios}">
                        <tr>
                            <th>${f.id_func}</th>
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

            <h4><a href="controlador?opcao=dashboard" class="btn btn-primary">Voltar</a></h4>
        </div>
    </body>
</html>
