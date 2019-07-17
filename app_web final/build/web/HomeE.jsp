<%-- 
    Document   : home
    Created on : 14-jul-2019, 12:17:26
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
    
    <body>           
         <header>
            <nav class="navbar navbar-expand-lg navbar-light bg-light">
                <div class="container">
                    <a class="navbar-brand" href="#">Cursos</a>            
                    <div class="collapse navbar-collapse" id="navbarNavAltMarkup">
                        <div class="navbar-nav">
                            <a  class="btn btn-outline-info" href="Controlador?accion=perfilE&estudiante=${estudiante.getNombre()}" target="myFrame">${estudiante.getNombre()}</a>
                        </div>
                        <div class="navbar-nav pl-3">
                            <a  class="btn btn-outline-info" href="Controlador?accion=Vernotas" target="myFrame">Notas</a>
                        </div>
                        <div class="navbar-nav pl-3">
                            <a  class="btn btn-outline-info" href="Controlador?accion=RegistrarC&estudiante=${estudiante.getNombre()}" target="myFrame">Reguistrar Curso</a>
                        </div>
                    </div>
                    <a name="accion" class="btn btn-outline-info" value="salir" href="Controlador?accion=salir" >Salir</a>
                </div>

            </nav>
        </header>
                        <div style="height: 550px" class="container">
            <iframe name="myFrame" style="width: 100%; height: 100%;">
        </div>
        
    </body>
    <script src="https://code.jquery.com/jquery-3.3.1.slim.min.js" integrity="sha384-q8i/X+965DzO0rT7abK41JStQIAqVgRVzpbzo5smXKp4YfRvH+8abtTE1Pi6jizo" crossorigin="anonymous"></script>
    <script src="https://cdnjs.cloudflare.com/ajax/libs/popper.js/1.14.3/umd/popper.min.js" integrity="sha384-ZMP7rVo3mIykV+2+9J3UJ46jBk0WLaUAdn689aCwoqbBJiSnjAK/l8WvCWPIPm49" crossorigin="anonymous"></script>
    <script src="https://stackpath.bootstrapcdn.com/bootstrap/4.1.3/js/bootstrap.min.js" integrity="sha384-ChfqqxuZUCnJSK3+MXmPNIyE6ZbWh2IMqE241rYiqJxyMiZ6OW/JmZQ5stwEULTy" crossorigin="anonymous"></script>

</html>
