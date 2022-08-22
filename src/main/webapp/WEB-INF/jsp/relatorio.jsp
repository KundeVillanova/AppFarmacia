<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ page isELIgnored="false" %>

<html>
<head>
    <link href="https://cdn.jsdelivr.net/npm/bootstrap@5.1.3/dist/css/bootstrap.min.css" rel="stylesheet" integrity="sha384-1BmE4kWBq78iYhFldvKuhfTAU6auU8tT94WrHftjDbrCEXSU1oBoqyl2QvZ6jIW3" crossorigin="anonymous">

    <title>Relatorio</title>
</head>
<body>
<div class="container">
    <h1>Bem vindo ${usuario_logado.nome}</h1>
    <h2>Relatorio da ${farmacia.alias_farm}</h2>
    <h2><a class="btn btn-primary" href="/app_farm/farm/franquias">Voltar</a></h2>

    <table class="table table-success table-striped">
        <tr>
            <th>Nome: ${farmacia.alias_farm}</th>
            <th>Telefone: ${farmacia.telefone}</th>
            <th>Estado: ${farmacia.estado}</th>
            <th>Cidade: ${farmacia.cidade}</th>
            <th>Rua: ${farmacia.rua}</th>
            <th>CEP: ${farmacia.cep}</th>
        </tr>
    </table>
    <div class="row">
        <div class="col-sm">
            <h1>Funcionarios</h1>
            <table class="table table-success table-striped">
                <tr>
                    <th>Nome</th>
                    <th>Telefone</th>
                    <th>Data de nascimento</th>
                    <th>Cargo</th>
                </tr>
                <c:forEach var="f" items="${funcionarios}">
                    <tr>
                        <th>${f.nome_func}</th>
                        <th>${f.telefone}</th>
                        <th>${f.data_nasc}</th>
                        <th>${f.funcao}</th>
                    </tr>
                </c:forEach>
            </table>
        </div>
        <div class="col-sm">
            <h1>Produtos</h1>
            <table class="table table-success table-striped">
                <tr>
                    <th>Nome</th>
                    <th>Categoria</th>
                    <th>Marca</th>
                    <th>Quantidade</th>
                </tr>
                <c:forEach var="p" items="${prods}">
                    <tr>
                        <th>${p.nome_produto}</th>
                        <th>${p.categoria}</th>
                        <th>${p.marca}</th>
                        <th>${p.quantidade}</th>
                    </tr>
                </c:forEach>
            </table>
        </div>
    </div>
</div>
</body>
</html>
