<%-- 
    Document   : index
    Created on : 06-jul-2019, 20:17:54
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
        <div class="container mt-4 col-lg-4">
            <div class="card-body col-sm-10 pt-5">
                <form class="form-sing" action="Validar" method="POST">
                    <div class="form-group">
                        <h3>Login</h3>
                    </div>
                    <div class="form-group">
                        <label>Usuario</label>
                        <input type="text" name="txtUser" class="form-control">
                    </div>
                    <div class="form-group">
                        <label>Contraseña</label>
                        <input type="text" name="txtPass" class="form-control">                               
                    </div>                    
                    <div class="form-check pb-4">
                        <input class="form-check-input" type="checkbox" value="true" name="rol" id="defaultCheck1">
                        <label class="form-check-label" for="defaultCheck1">
                            Profesor
                        </label>
                    </div>
                    <input type="submit" name="accion" value="ingresar" class="btn btn-primary btn-block">
                </form>
            </div>
        </div>

    </body>
    <script src="https://code.jquery.com/jquery-3.3.1.slim.min.js" integrity="sha384-q8i/X+965DzO0rT7abK41JStQIAqVgRVzpbzo5smXKp4YfRvH+8abtTE1Pi6jizo" crossorigin="anonymous"></script>
    <script src="https://cdnjs.cloudflare.com/ajax/libs/popper.js/1.14.3/umd/popper.min.js" integrity="sha384-ZMP7rVo3mIykV+2+9J3UJ46jBk0WLaUAdn689aCwoqbBJiSnjAK/l8WvCWPIPm49" crossorigin="anonymous"></script>
    <script src="https://stackpath.bootstrapcdn.com/bootstrap/4.1.3/js/bootstrap.min.js" integrity="sha384-ChfqqxuZUCnJSK3+MXmPNIyE6ZbWh2IMqE241rYiqJxyMiZ6OW/JmZQ5stwEULTy" crossorigin="anonymous"></script>
</html>

