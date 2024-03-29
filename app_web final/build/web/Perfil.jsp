<%-- 
    Document   : Perfil
    Created on : 16-jul-2019, 16:48:40
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
        <div class="row pt-3">
            <div class="col-md-4">
                <img src="img/user.png">
            </div>
            <div class="col-md-6">
                <div class="row pt-4" style="color: #17a2b8; font-size: 20px">
                    <dic class="col-md-3">
                        Nombre:
                    </dic>      
                    <div class="col-md-5" style="color: #0062cc; text-transform: capitalize">
                        ${usuario.getNombre()}                        
                    </div>
                    <div class="col">
                        <button type="button" class="btn btn-primary" data-toggle="modal" data-target="#exampleModal">
                            Editar
                        </button>
                    </div>
                </div>
                <div class="row pt-3" style="color: #17a2b8; font-size: 20px">
                    <dic class="col-md-3">
                        CC:
                    </dic>      
                    <div class="col-md-6" style="color: #0062cc; text-transform: capitalize">
                        ${usuario.getCc()}
                    </div>                    
                </div>               
            </div>
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
                                <label>Nombre Actual</label>
                                <input type="text" name="txtActual" class="form-control">
                            </div>                    
                            <div class="form-group">
                                <label>Dato</label>
                                <input type="text" name="txtDato" class="form-control">
                            </div>
                            <input type="submit" name="accion" value="editarN" class="btn btn-primary btn-block">
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
