/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package cto;

import dao.*;
import dto.*;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.List;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 *
 * @author GAMER
 */
@WebServlet(name = "Validar", urlPatterns = {"/Validar"})
public class Validar extends HttpServlet {

    Profesor_DTO p = new Profesor_DTO();
    Estudiante_DTO e = new Estudiante_DTO();
    Estudiante_DAO e_dao = new Estudiante_DAO();
    Profesor_DAO p_dao = new Profesor_DAO();
    Curso_DTO c=new Curso_DTO();
    Curso_DAO c_dao=new Curso_DAO();
    Registro_DAO r_dao=new Registro_DAO();
    public void setE(Estudiante_DTO e) {
        this.e = e;
    }

    public void setP(Profesor_DTO p) {
        this.p = p;
    }

    protected void processRequest(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
         String accion = request.getParameter("accion");
        switch (accion) {        
            
        }
        
    }

    // <editor-fold defaultstate="collapsed" desc="HttpServlet methods. Click on the + sign on the left to edit the code.">
    /**
     * Handles the HTTP <code>GET</code> method.
     *
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     */
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        processRequest(request, response);
    }

    /**
     * Handles the HTTP <code>POST</code> method.
     *
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     */
    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        String action = request.getParameter("accion");             
        if (action.equals("ingresar")) {
            String user = request.getParameter("txtUser");
            String pass = request.getParameter("txtPass");
            String rol = request.getParameter("rol");
            boolean bDat = Boolean.parseBoolean(rol);
            if (bDat == true) {
                this.p = this.p_dao.loginP(user, pass);
                if (this.p.getNombre() != null) {
                    this.setP(p);                    
                    request.setAttribute("docente", this.p);
                    request.getRequestDispatcher("Controlador?accion=HomeP").forward(request, response);                    
                } else {
                    request.getRequestDispatcher("index.jsp").forward(request, response);
                }
            } else {
                this.e = this.e_dao.loginP(user, pass);
                if (this.e.getNombre() != null) {
                    this.setE(e);
                    request.setAttribute("estudiante", this.e);
                    request.getRequestDispatcher("Controlador?accion=HomeE").forward(request, response);
                } else {
                    request.getRequestDispatcher("index.jsp").forward(request, response);
                }
            }

        } 
        if(action.equals("editarN")){
            String actual=request.getParameter("txtActual");
            String dato=request.getParameter("txtDato");
            this.p=this.p_dao.obtenerP(actual);
            this.p_dao.Editar(Integer.toString(p.getCodigo()), dato, "nombre");
            this.p=this.p_dao.obtenerP(dato);
            request.setAttribute("usuario", p);
           request.getRequestDispatcher("Perfil.jsp").forward(request, response);
        }
         if(action.equals("editarE")){
            
            String actual=request.getParameter("txtActual");
            String dato=request.getParameter("txtDato");
            this.e=this.e_dao.obtenerE(actual);
            this.e_dao.Editar(Integer.toString(e.getCodigo()), dato, "nombre");
            this.e=this.e_dao.obtenerE(dato);
            request.setAttribute("usuario", e);
           request.getRequestDispatcher("PerfilE.jsp").forward(request, response);
        }
         if(action.equals("AddC")){            
            String curso=request.getParameter("AddCurso");
            String fecha=request.getParameter("AddFecha");
            String estudiante=request.getParameter("AddE");
             System.out.println("Estudiante "+estudiante);
            this.e=this.e_dao.obtenerE(estudiante);
            this.c=this.c_dao.obtenerC(curso);
            this.r_dao.registrarCurso(fecha, Integer.toString(e.getCodigo()), Integer.toString(c.getId()));
            request.setAttribute("estudiante", e.getNombre());
            request.getRequestDispatcher("Controlador?accion=RegistrarC").forward(request, response);
        }
    }

    /**
     * Returns a short description of the servlet.
     *
     * @return a String containing servlet description
     */
    @Override
    public String getServletInfo() {
        return "Short description";
    }// </editor-fold>

}
