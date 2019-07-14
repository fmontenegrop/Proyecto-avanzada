<%-- 
    Document   : Principal1
    Created on : 13-jul-2019, 16:39:26
    Author     : GAMER
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>JSP Page</title>
        <link rel="stylesheet" href="https://stackpath.bootstrapcdn.com/bootstrap/4.1.3/css/bootstrap.min.css" integrity="sha384-MCw98/SFnGE8fJT3GXwEOngsV7Zt27NXFoaoApmYm81iuXoPkFOJwJ8ERdknLPMO" crossorigin="anonymous">
    </head>
     <header>
        <nav class="navbar navbar-expand-lg navbar-light bg-light">
            <div class="container">
                <a class="navbar-brand" href="#">Cursos</a>            
                <div class="collapse navbar-collapse" id="navbarNavAltMarkup">
                    <div class="navbar-nav">
                        <a class="btn btn-outline-info" href="Controlador?accion=Persona" target="frameEst">Personas</a>
                    </div>
                </div>
                <div class="btn-group pr-5">
                    <button type="button" class="btn btn-info dropdown-toggle" data-toggle="dropdown" aria-haspopup="true" aria-expanded="false">
                        ${user.getNombre()}
                    </button>
                    <div class="dropdown-menu">
                        <a class="dropdown-item" href="#">
                            <img src="img\user.png" alt="60" width="60">                            
                        </a>
                        <a class="dropdown-item" href="#">${user.getNombre()} ${user.getApellido()}</a>
                        <a class="dropdown-item" href="#">${user.getCorreo()}</a>                    
                        <div class="dropdown-divider"></div>
                        <form action="Validar" method="POST">
                            <button name="accion" value="salir" class="dropdown-item">Salir</button>
                        </form>
                    </div>
                </div> 
            </div>

        </nav>
    </header>
    <body>
        <div style="height: 550px">
            <iframe name="myFrame" style="width: 100%; height: 100%;">
        </div>
    </body>
     <link rel="stylesheet" href="https://stackpath.bootstrapcdn.com/bootstrap/4.1.3/css/bootstrap.min.css" integrity="sha384-MCw98/SFnGE8fJT3GXwEOngsV7Zt27NXFoaoApmYm81iuXoPkFOJwJ8ERdknLPMO" crossorigin="anonymous">
</html>
