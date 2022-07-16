<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@page isELIgnored="false" %>

<html>
    <head>
        <link href="https://cdn.jsdelivr.net/npm/bootstrap@5.1.3/dist/css/bootstrap.min.css" rel="stylesheet" integrity="sha384-1BmE4kWBq78iYhFldvKuhfTAU6auU8tT94WrHftjDbrCEXSU1oBoqyl2QvZ6jIW3" crossorigin="anonymous">
        <title>Funcionario</title>
    </head>
    <body>

    <div class="container">

        <form action="editar-controller" method="post">
            <h1>Editar Usuario</h1>
            <input type="hidden" name="id_func" value="${func.id_func}"/>

            <div class="form-group">
                Nome: <input type="text" name="nome_func" value="${func.nome_func}" /> <br/>
            </div>

            <div class="form-group">
            TELEFONE: <input type="text" name="telefone" value="${func.telefone}" /> <br/>
            </div>

            <div class="form-group">
            DATA NASCIMENTO: <input type="text" name="data_nasc" value="${func.data_nasc}" /> <br/>
            </div>
            <input type="submit" value="editar">
        </form>
        <div>
            <a href="controlador?opcao=funcionario"
            ><input type="button" value="voltar"/></a>
        </div>
    </div>
    </body>
</html>

