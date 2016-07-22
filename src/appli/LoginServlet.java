package appli;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.google.appengine.api.users.*;

public class LoginServlet extends HttpServlet{
	  //private static final long serialVersionUID = 1L;

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp)
            throws ServletException, IOException {
    	UserService userService = UserServiceFactory.getUserService();
    	HttpSession session = req.getSession();
    	resp.setCharacterEncoding("UTF-8");
        resp.setContentType("text/html");
        req.setCharacterEncoding("utf-8");
        User user = userService.getCurrentUser();
        
    	if(userService.isUserLoggedIn()){
            // ユーザ情報とログアウト用リンクの取得
            session.setAttribute("user", userService.getCurrentUser());
        	//resp.sendRedirect("");
            resp.getWriter().println("認証ドメイン:" + userService.getCurrentUser());
            resp.getWriter().println("ニックネーム:" + user.getNickname());
            resp.getWriter().println("ユーザID    :" + user.getUserId());
            resp.getWriter().println("Eメール     :" + user.getEmail());
            RequestDispatcher dispatcher = req.getRequestDispatcher("/WEB-INF/jsp/loginOK.jsp");
            dispatcher.forward(req, resp);
    	}else{
    		session.removeAttribute("user");
        	String url = req.getRequestURI();
        	String loginURL = userService.createLoginURL( url );
        	resp.sendRedirect(loginURL);
    	}
    }
    
    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        request.setCharacterEncoding("UTF-8");
        //リクエストパラメタの取得
        request.setCharacterEncoding("UTF-8");

        //フォワード
        RequestDispatcher dispatcher = request.getRequestDispatcher("/WEB-INF/jsp/loginOK.jsp");
        dispatcher.forward(request, response);
        //processRequest(request, response);
    }

    @Override
    public String getServletInfo() {
        return "Short description";
    }
}
