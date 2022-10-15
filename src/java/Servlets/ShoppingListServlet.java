/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Servlets;

import java.io.IOException;
import java.util.ArrayList;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

/**
 *
 * @author valentinmorales
 */
public class ShoppingListServlet extends HttpServlet {

    
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
        
        //getServletContext().getRequestDispatcher("/WEB-INF/register.jsp").forward(request, response);
        HttpSession session = request.getSession();
        if(session.getAttribute("username")!= null ){  
             
            getServletContext().getRequestDispatcher("/WEB-INF/shoppingList.jsp").forward(request, response);
        }
        else if(request.getParameter("action")=="logout")
        {
            session.invalidate();
            getServletContext().getRequestDispatcher("/WEB-INF/register.jsp").forward(request, response);
        }
        else 
        {
            getServletContext().getRequestDispatcher("/WEB-INF/register.jsp").forward(request, response);
        }

        
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
        
        String name = request.getParameter("name");
        
        if (name==null || name.equals(""))
        {
            getServletContext().getRequestDispatcher("/WEB-INF/register.jsp").forward(request, response);
            return;
        }
        
        
        
        HttpSession session = request.getSession();
            
        
        String action = request.getParameter("action");
        
        ArrayList<String> items = new ArrayList<String>();
        
        switch(action)
        {
            case "register":
                session.setAttribute("username",name);
                getServletContext().getRequestDispatcher("/WEB-INF/shoppingList.jsp").forward(request, response);
                break;
            case "add":
                String item = request.getParameter("item");
                items.add(item);
                session.setAttribute("items", items);
                getServletContext().getRequestDispatcher("/WEB-INF/shoppingList.jsp").forward(request, response);
                break;
            case "delete":
                break;
            case "logout":
                session.invalidate();
                getServletContext().getRequestDispatcher("/WEB-INF/register.jsp").forward(request, response);
                break;
            default:
                getServletContext().getRequestDispatcher("/WEB-INF/register.jsp").forward(request, response);
        }
        

        //getServletContext().getRequestDispatcher("/WEB-INF/shoppingList.jsp").forward(request, response);
        
    }


}
