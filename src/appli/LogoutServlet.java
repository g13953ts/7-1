package appli;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.google.appengine.api.users.*;
import com.google.appengine.api.users.UserServiceFactory;

public class LogoutServlet extends HttpServlet {
	   //private static final long serialVersionUID = 1L;

	    @Override
	    protected void doGet(HttpServletRequest req, HttpServletResponse resp)
	            throws ServletException, IOException {
	    	UserService userService = UserServiceFactory.getUserService();
	    	resp.setCharacterEncoding("UTF-8");
	        resp.setContentType("text/html");
	        req.setCharacterEncoding("utf-8");

	        if(userService.isUserLoggedIn()){
	        	String url = req.getRequestURI();
	        	String logoutURL = userService.createLogoutURL( url );
	        	//RequestDispatcher dispatcher = req.getRequestDispatcher(logoutURL);
	        	resp.sendRedirect(logoutURL);
	        }
	        RequestDispatcher dispatcher = req.getRequestDispatcher("/WEB-INF/jsp/logoutOK.jsp");
	        dispatcher.forward(req, resp);

	    }
	    @Override
	    protected void doPost(HttpServletRequest request, HttpServletResponse response)
	            throws ServletException, IOException {
	        request.setCharacterEncoding("UTF-8");
	        RequestDispatcher dispatcher = request.getRequestDispatcher("/WEB-INF/jsp/logoutOK.jsp");
	        dispatcher.forward(request, response);
	    }

	    @Override
	    public String getServletInfo() {
	        return "Short description";
	    }
	}
