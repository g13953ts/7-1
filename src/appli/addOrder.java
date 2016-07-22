package appli;

import java.io.IOException;
import java.net.URL;
import java.util.*;
 
import javax.jdo.*;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.*;
import model.Order;
 
public class addOrder extends HttpServlet {
    private static final long serialVersionUID = 1L;
 
    @Override
    protected void doGet(HttpServletRequest req,
            HttpServletResponse resp)
            throws ServletException, IOException {
        resp.setContentType("text/plain");
        resp.getWriter().println("no url...");
    }
 
    @Override
    protected void doPost(HttpServletRequest req,
            HttpServletResponse resp)
            throws ServletException, IOException {
        req.setCharacterEncoding("UTF-8");
        String clothes = req.getParameter("clothes");
        Order data = new Order(clothes);
        PersistenceManagerFactory factory = PMF.get();
        PersistenceManager manager = factory.getPersistenceManager();
        try {
            manager.makePersistent(data);
        } finally {
            manager.close();
        }
        RequestDispatcher dispatcher = req.getRequestDispatcher("/WEB-INF/jsp/main2.jsp");
        dispatcher.forward(req, resp);
        //resp.sendRedirect("/WEB-INF/jsp/main2.jsp");
    }
}