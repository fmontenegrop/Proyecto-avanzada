<%-- 
    Document   : Principal
    Created on : 06-jul-2019, 20:18:13
    Author     : GAMER
--%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@page import="cto.Validar"%>
<%@page import="java.util.List"%>
<%@page import="dto.PersonaDTO"%>
<%
%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>JSP Page</title>
        <link rel="stylesheet" href="https://stackpath.bootstrapcdn.com/bootstrap/4.1.3/css/bootstrap.min.css" integrity="sha384-MCw98/SFnGE8fJT3GXwEOngsV7Zt27NXFoaoApmYm81iuXoPkFOJwJ8ERdknLPMO" crossorigin="anonymous">
    </head>

    <body>
        <div class="container pt-5">
            <div class="row">
                <div class="col-md-2 pt-5">                    
                    <div class="row pt-3">
                        <!-- Button trigger modal -->
                        <button type="button" class="btn-outline-primary" data-toggle="modal" data-target="#agregar">
                            Agregar
                        </button>                        
                    </div>                    
                </div>
                <div class="col">
                    <table class="table table-hover">
                        <thead>
                            <tr>                        
                                <th scope="col">Id</th>
                                <th scope="col">Nombre</th>
                                <th scope="col">Apellido</th>
                                <th scope="col">Correo</th>
                                <th scope="col">Accion</th>
                            </tr>
                        </thead>
                        <tbody>                      
                            <c:forEach var="persona" items="${listap}">                                
                                <tr>                                                        
                                    <td name="id">${persona.getId()}</td>                                
                                    <td name="nombre">${persona.getNombre()}</td>
                                    <td name="apellido">${persona.getApellido()}</td>
                                    <td name="correo">${persona.getCorreo()}</td>                                
                                    <td>
                                        <div class="row">
                                            <div class="col-md-4">
                                                <button type="button" class="btn-outline-primary" data-toggle="modal" data-target="#editar">
                                                    Editar
                                                </button> 
                                            </div>
                                            <div class="col-md-6">
                                                <a href="Controlador?accion=Eliminar&id=${persona.getId()}" class="btn btn-danger btn-block">Eliminar</a>
                                            </div>                                    
                                        </div>                                    
                                    </td>                                                                                        
                                </tr>     
                            </c:forEach>
                        </tbody>
                    </table>                   
                </div>
            </div>
        </div>        
        <!-- Modal Agregar -->
        <div class="modal fade" id="agregar" tabindex="-1" role="dialog" aria-labelledby="exampleModalLabel" aria-hidden="true">
            <div class="modal-dialog" role="document">
                <div class="modal-content">
                    <div class="modal-header">
                        <h5 class="modal-title" id="exampleModalLabel">Agregue Nueva Persona</h5>
                        <button type="button" class="close" data-dismiss="modal" aria-label="Close">
                            <span aria-hidden="true">&times;</span>
                        </button>
                    </div>
                    <div class="modal-body">
                        <div class="card-body col-sm-10 pt-5">
                            <form class="form-sing" action="Controlador" method="POST">
                                <div class="form-group">
                                    <label>Nombre</label>
                                    <input type="text" name="txtNadd" class="form-control">
                                </div>
                                <div class="form-group">
                                    <label>Apellido</label>
                                    <input type="text" name="txtAadd" class="form-control">
                                </div>                                
                                <div class="form-group">
                                    <label>Correo</label>
                                    <input type="text" name="txtCadd" class="form-control">
                                </div>
                                <div class="row">
                                    <div class="col-md-4">
                                        <input type="submit" name="accion" value="Agregar" class="btn btn-primary btn-block">
                                    </div>
                                    <div class="offset-md-4 col-md-4">
                                        <button type="button" class="btn btn-secondary" data-dismiss="modal">Cancelar</button>
                                    </div>
                                </div>

                            </form>
                        </div>
                    </div>                    
                </div>
            </div>
        </div>
        <!-- Modal Editar -->
        <div class="modal fade" id="editar" tabindex="-1" role="dialog" aria-labelledby="exampleModalLabel" aria-hidden="true">
            <div class="modal-dialog" role="document">
                <div class="modal-content">
                    <div class="modal-header">
                        <h5 class="modal-title" id="exampleModalLabel">Editar Persona</h5>
                        <button type="button" class="close" data-dismiss="modal" aria-label="Close">
                            <span aria-hidden="true">&times;</span>
                        </button>
                    </div>
                    <div class="modal-body">
                        <div class="card-body col-sm-10 pt-5">
                            <form class="form-sing" action="Controlador" method="POST">
                                <div class="form-group">
                                    <label>Nombre</label>
                                    <input type="text" name="txtNedit" class="form-control">
                                </div>
                                <div class="form-group">
                                    <label>Apellido</label>
                                    <input type="text" name="txtAedit" class="form-control">
                                </div>                                
                                <div class="form-group">
                                    <label>Correo</label>
                                    <input type="text" name="txtCedit" class="form-control">
                                </div>
                                <div class="row">
                                    <div class="col-md-4">
                                        <input type="submit" name="accion" value="Agregar" class="btn btn-primary btn-block">
                                    </div>
                                    <div class="offset-md-4 col-md-4">
                                        <button type="button" class="btn btn-secondary" data-dismiss="modal">Cancelar</button>
                                    </div>
                                </div>

                            </form>
                        </div>
                    </div>                    
                </div>
            </div>
        </div>
    </body>
    <script src="https://code.jquery.com/jquery-3.3.1.slim.min.js" integrity="sha384-q8i/X+965DzO0rT7abK41JStQIAqVgRVzpbzo5smXKp4YfRvH+8abtTE1Pi6jizo" crossorigin="anonymous"></script>
    <script src="https://cdnjs.cloudflare.com/ajax/libs/popper.js/1.14.3/umd/popper.min.js" integrity="sha384-ZMP7rVo3mIykV+2+9J3UJ46jBk0WLaUAdn689aCwoqbBJiSnjAK/l8WvCWPIPm49" crossorigin="anonymous"></script>
    <script src="https://stackpath.bootstrapcdn.com/bootstrap/4.1.3/js/bootstrap.min.js" integrity="sha384-ChfqqxuZUCnJSK3+MXmPNIyE6ZbWh2IMqE241rYiqJxyMiZ6OW/JmZQ5stwEULTy" crossorigin="anonymous"></script>
</html>
