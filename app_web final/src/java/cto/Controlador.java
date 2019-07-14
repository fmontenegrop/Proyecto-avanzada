package cto;

import dao.Persona_DAO;
import dto.PersonaDTO;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.List;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 *
 * @author GAMER
 */
public class Controlador extends HttpServlet {
    Persona_DAO person=new Persona_DAO();
    List  <PersonaDTO> listap;
    PersonaDTO persondto=new PersonaDTO();    
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
        String accion = request.getParameter("accion");                
        switch (accion) {
            case "Persona":
                request.getRequestDispatcher("Principal.jsp").forward(request, response);
                break;
                case "HomeD":
                request.getRequestDispatcher("Home_doc.jsp").forward(request, response);
                break; 
            case "HomeE":
                request.getRequestDispatcher("Home_est.jsp").forward(request, response);
                break;           
            case "Agregar": 
                String user = request.getParameter("txtUser");
                String pass=request.getParameter("txtPass");
                //persondto=person.validar(user, pass);                  
                String nombre = request.getParameter("txtNadd");
                String apellido=request.getParameter("txtAadd");
                String correo=request.getParameter("txtCadd");
                this.person.insertP(nombre, apellido, correo);
                System.out.println("Succesfull");
                this.listap=person.getPersonas();                
                request.setAttribute("listap",this.listap);
                request.setAttribute("user",persondto);
                request.getRequestDispatcher("Principal.jsp").forward(request, response);
                break;
            case "Eliminar":               
                String id=request.getParameter("id");
                this.person.deleteP(id);
                this.listap=person.getPersonas();                
                request.setAttribute("listap",this.listap);
                request.getRequestDispatcher("Principal.jsp").forward(request, response);
                System.out.println("Delete succesfull");
                break;
        }
        response.setContentType("text/html;charset=UTF-8");
        try (PrintWriter out = response.getWriter()) {
            /* TODO output your page here. You may use following sample code. */
            out.println("<!DOCTYPE html>");
            out.println("<html>");
            out.println("<head>");
            out.println("<title>Servlet Controlador</title>");
            out.println("</head>");
            out.println("<body>");
            out.println("<h1>Servlet Controlador at " + request.getContextPath() + "</h1>");
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
