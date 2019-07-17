/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package cto;

import dao.Estudiante_DAO;
import dao.Profesor_DAO;
import dto.Estudiante_DTO;
import java.io.IOException;
import java.io.PrintWriter;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import dto.Profesor_DTO;

/**
 *
 * @author GAMER
 */
public class Controlador extends HttpServlet {

    /**
     * Processes requests for both HTTP <code>GET</code> and <code>POST</code>
     * methods.
     *
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     */
    protected void processRequest(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        response.setContentType("text/html;charset=UTF-8");
        Profesor_DTO p = new Profesor_DTO();
        Profesor_DAO p_dao = new Profesor_DAO();
        Estudiante_DTO e=new Estudiante_DTO();
        Estudiante_DAO e_dao=new Estudiante_DAO();
        String accion = request.getParameter("accion");
        switch (accion) {
            case "HomeP":
                request.getRequestDispatcher("HomeP.jsp").forward(request, response);
                break;
            case "HomeE":
                request.getRequestDispatcher("HomeE.jsp").forward(request, response);
                break;
            case "salir":
                System.out.println("Salir");
                request.getRequestDispatcher("index.jsp").forward(request, response);
                break;
            case "perfil":
                String dato = request.getParameter("docente");
                p = p_dao.obtenerP(dato);
                request.setAttribute("usuario", p);
                request.getRequestDispatcher("Perfil.jsp").forward(request, response);
            break;
            case "perfilE":
                String datoE = request.getParameter("estudiante");
                e = e_dao.obtenerE(datoE);
                request.setAttribute("usuario", e);
                request.getRequestDispatcher("PerfilE.jsp").forward(request, response);
            break;
                
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
        processRequest(request, response);
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
