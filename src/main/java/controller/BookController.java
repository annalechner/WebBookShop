/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package controller;

import database.DB_Access;
import beans.Book;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.Comparator;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import java.util.stream.Collectors;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletConfig;
import javax.servlet.ServletContext;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 *
 * @author annalechner
 */
@WebServlet(name = "BookController", urlPatterns = {"/BookController"})
public class BookController extends HttpServlet {

    private DB_Access access;

    @Override
    public void init(ServletConfig config) throws ServletException {
        super.init(config); //To change body of generated methods, choose Tools | Templates.
        access = DB_Access.getInstance();
    }

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
        request.getRequestDispatcher("jsps/bookJsp.jsp").forward(request, response);
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
        ServletContext context = this.getServletContext();
        if (context.getAttribute("allBooks") == null) {
            try {
                context.setAttribute("allBooks", access.getAllBooks());
            } catch (Exception ex) {
                Logger.getLogger(BookController.class.getName()).log(Level.SEVERE, null, ex);
            }
        }
        if (request.getSession().getAttribute("books") == null) {
            request.getSession().setAttribute("books", (List<Book>) context.getAttribute("allBooks"));
        }
        System.out.println("GET");
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
        ServletContext context = this.getServletContext();
        Comparator<Book> comp = Comparator.naturalOrder();
        System.out.println(request.getParameterMap().keySet());
        if (request.getParameterMap().keySet().contains("selTitle")) {
            comp = comp.thenComparing(Book::getTitle);
            request.getSession().setAttribute("title", "checked");
        } else {
            request.getSession().removeAttribute("title");
        }
        if (request.getParameterMap().keySet().contains("selAuthor")) {
            comp = comp.thenComparing(Book::getFirstAuthor);
            request.getSession().setAttribute("author", "checked");
        } else {
            request.getSession().removeAttribute("author");
        }
        if (request.getParameterMap().keySet().contains("selPrice")) {
            comp = comp.thenComparing(Book::getPrice);
            request.getSession().setAttribute("price", "checked");
        } else {
            request.getSession().removeAttribute("price");
        }
        request.getSession().setAttribute("books", ((List<Book>) context.getAttribute("allBooks")).stream().sorted(comp).collect(Collectors.toList()));
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
