<%-- 
    Document   : RegistroC
    Created on : 16-jul-2019, 22:22:43
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
        <div class="row">
            <h1>Adicion y Cancelacion de Materias</h1>
        </div>
        <div class="row">
            <h2>${estado}</h2>
        </div>
        <div class="row">
            <button type="button" class="btn btn-primary" data-toggle="modal" data-target="#exampleModal">
                Agregar Curso
            </button>
        </div>
        <!-- Modal -->
        <div class="modal fade" id="exampleModal" tabindex="-1" role="dialog" aria-labelledby="exampleModalLabel" aria-hidden="true">
            <div class="modal-dialog" role="document">
                <div class="modal-content">
                    <div class="modal-header">
                        <h5 class="modal-title" id="exampleModalLabel">Editar Nombre</h5>
                        <button type="button" class="close" data-dismiss="modal" aria-label="Close">
                            <span aria-hidden="true">&times;</span>
                        </button>
                    </div>
                    <div class="modal-body">
                        <form class="form-sing" action="Validar" method="POST">                    
                            <div class="form-group">
                                <label>Nombre Estudiante</label>
                                <input  type="text" name="AddE" value="${usuario.getNombre()}" class="form-control">
                            </div>                    
                            <div class="form-group">
                                <label>Nombre del Curso</label>
                                <input type="text" name="AddCurso" class="form-control">
                            </div>                    
                            <div class="form-group">
                                <label>Fecha</label>
                                <input type="text" name="AddFecha" class="form-control">
                            </div>
                            <input type="submit" name="accion" value="AddC" class="btn btn-primary btn-block">
                        </form>
                    </div>                    
                </div>
            </div>
        </div>                             
    </body>
    <script src="https://code.jquery.com/jquery-3.3.1.slim.min.js" integrity="sha384-q8i/X+965DzO0rT7abK41JStQIAqVgRVzpbzo5smXKp4YfRvH+8abtTE1Pi6jizo" crossorigin="anonymous"></script>
    <script src="https://cdnjs.cloudflare.com/ajax/libs/popper.js/1.14.3/umd/popper.min.js" integrity="sha384-ZMP7rVo3mIykV+2+9J3UJ46jBk0WLaUAdn689aCwoqbBJiSnjAK/l8WvCWPIPm49" crossorigin="anonymous"></script>
    <script src="https://stackpath.bootstrapcdn.com/bootstrap/4.1.3/js/bootstrap.min.js" integrity="sha384-ChfqqxuZUCnJSK3+MXmPNIyE6ZbWh2IMqE241rYiqJxyMiZ6OW/JmZQ5stwEULTy" crossorigin="anonymous"></script>
    <link rel="stylesheet" href="https://stackpath.bootstrapcdn.com/bootstrap/4.1.3/css/bootstrap.min.css" integrity="sha384-MCw98/SFnGE8fJT3GXwEOngsV7Zt27NXFoaoApmYm81iuXoPkFOJwJ8ERdknLPMO" crossorigin="anonymous">
</html>
