/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Servlets;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
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
        if(request.getParameter("logout")!=null)
        {
            session.invalidate();
            getServletContext().getRequestDispatcher("/WEB-INF/register.jsp").forward(request, response);
            
        }
        
            getServletContext().getRequestDispatcher("/WEB-INF/register.jsp").forward(request, response);
        
        
        

        
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
        
        HttpSession session = request.getSession();
            
        
        String action = (String)request.getParameter("action");

        
        if(action.equals("register"))
        {
            String username = request.getParameter("username");
        
            if (username==null || username.equals(""))
            {
                getServletContext().getRequestDispatcher("/WEB-INF/register.jsp").forward(request, response);
                return;
            }
            else
            {
                session.setAttribute("username",username);
                ArrayList<String> items = new ArrayList<String>();
                session.setAttribute("items", items);
                //getServletContext().getRequestDispatcher("/WEB-INF/shoppingList.jsp").forward(request, response);
            }
        }
        if(action.equals("add"))
        {
            String item = request.getParameter("item");
            if(item!="" && item!=null)
            {
                ArrayList<String> itemsList = (ArrayList<String>) session.getAttribute("items");
                itemsList.add(item);
                session.setAttribute("items", itemsList);
            }
            
            //getServletContext().getRequestDispatcher("/WEB-INF/shoppingList.jsp").forward(request, response);
        }
        if(action.equals("delete"))
        {
            String delItem = request.getParameter("item");
            ArrayList<String> itemsList = (ArrayList<String>) session.getAttribute("items");
            itemsList.remove(delItem);
            session.setAttribute("items", itemsList);
            //getServletContext().getRequestDispatcher("/WEB-INF/shoppingList.jsp").forward(request, response);
        }

        getServletContext().getRequestDispatcher("/WEB-INF/shoppingList.jsp").forward(request, response);
        
    }


}
