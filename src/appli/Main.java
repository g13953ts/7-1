 /*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package appli;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.google.appengine.api.users.UserServiceFactory;

import appli.PMF;
import javax.servlet.http.*;
import model.Order;
import java.io.*;
import java.util.*;
import javax.jdo.*;
/**
 *
 * @author g13953ts
 */

public class Main extends HttpServlet {

    private static final long serialVersionUID = 1L;

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp)
            throws ServletException, IOException {
    	
    	 PersistenceManagerFactory factory = PMF.get();
         PersistenceManager manager = factory.getPersistenceManager();
         resp.setCharacterEncoding("UTF-8");
         resp.setContentType("text/html");
         req.setCharacterEncoding("utf-8");
         String param1 = req.getParameter("clothes[]");
         PrintWriter out = resp.getWriter();
         List<Order> list = null;
         
        
        	 out.println("<p>" + req.getUserPrincipal().getName() + "さん</p>");    
        
            RequestDispatcher dispatcher = req.getRequestDispatcher("/WEB-INF/jsp/main.jsp");
            dispatcher.forward(req, resp);

    }


    @SuppressWarnings("unchecked")
    protected void doPost(HttpServletRequest req, HttpServletResponse resp)
            throws ServletException, IOException {
      	 PersistenceManagerFactory factory = PMF.get();
         PersistenceManager manager = factory.getPersistenceManager();
        String param1 = req.getParameter("clothes[]");
        resp.setCharacterEncoding("UTF-8");
        resp.setContentType("text/html");
        req.setCharacterEncoding("utf-8");
        PrintWriter out = resp.getWriter();

        RequestDispatcher dispatcher = req.getRequestDispatcher("/WEB-INF/jsp/main2.jsp");
        dispatcher.forward(req, resp);
    }
}
