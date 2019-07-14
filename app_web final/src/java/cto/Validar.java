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

    List<PersonaDTO> listap;

    public List<PersonaDTO> getListap() {
        return listap;
    }
    DocenteDAO docDao = new DocenteDAO();
    Docente_DTO docDto = new Docente_DTO();
    Persona_DAO person = new Persona_DAO();
    PersonaDTO persondto = new PersonaDTO();

    protected void processRequest(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        response.setContentType("text/html;charset=UTF-8");
        try (PrintWriter out = response.getWriter()) {
            /* TODO output your page here. You may use following sample code. */
            out.println("<!DOCTYPE html>");
            out.println("<html>");
            out.println("<head>");
            out.println("<title>Servlet Validar</title>");
            out.println("</head>");
            out.println("<body>");
            out.println("<h1>Servlet Validar at " + request.getContextPath() + "</h1>");
            out.println("</body>");
            out.println("</html>");
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
                docDto = docDao.validar(Integer.parseInt(user), Integer.parseInt(pass));
                if (docDto.getNombre() != null) {
                    request.getRequestDispatcher("Controlador?accion=HomeD").forward(request, response);
                } else {
                    request.getRequestDispatcher("index.jsp").forward(request, response);
                    System.out.println("NULL");
                }
            } else {
                persondto = person.validar(Integer.parseInt(user), Integer.parseInt(pass));
                if (persondto.getNombre() != null) {

                    this.listap = person.getPersonas();
                    request.setAttribute("listap", this.listap);
                    request.setAttribute("user", persondto);
                    request.getRequestDispatcher("Controlador?accion=HomeE").forward(request, response);
                } else {
                    request.getRequestDispatcher("index.jsp").forward(request, response);
                    System.out.println("NULL");
                }
            }

        } else {
            request.getRequestDispatcher("index.jsp").forward(request, response);
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
