<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ page isELIgnored="false" %>
<html>
    <head>
        <link href="https://cdn.jsdelivr.net/npm/bootstrap@5.1.3/dist/css/bootstrap.min.css" rel="stylesheet" integrity="sha384-1BmE4kWBq78iYhFldvKuhfTAU6auU8tT94WrHftjDbrCEXSU1oBoqyl2QvZ6jIW3" crossorigin="anonymous">
        <title>Pagina inicial</title>
    </head>
    <body>
        <div class="container">
            <h1>Olá ${usuario_logado.nome}</h1>

            <h2>ID da sessão: ${pageContext.session.id}</h2>
            <h3>Criação da sessão: ${pageContext.session.creationTime}</h3>
            <h3>Ultimo acesso: ${pageContext.session.lastAccessedTime}</h3>

            <ul>
                <h4><a href="controlador?opcao=funcionario" class="btn btn-success"> Cadastrar Funcionário</a></h4>

                <h4><a href="controlador?opcao=produto" class="btn btn-success"> Cadastrar Produto</a></h4>

                <h4><a href="controlador?opcao=farmacia" class="btn btn-success"> Cadastrar Farmacia</a></h4>
            </ul>
        </div>
    </body>
</html>
