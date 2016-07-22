package appli;
import java.io.*;
import java.util.*;
 
import javax.jdo.*;
import javax.servlet.http.*;

import model.Order;

@SuppressWarnings("serial")
public class MygaeServlet extends HttpServlet {
    public void doGet(HttpServletRequest req,
            HttpServletResponse resp)
            throws IOException {
        PersistenceManagerFactory factory = PMF.get();
        PersistenceManager manager = factory.getPersistenceManager();
        resp.setCharacterEncoding("UTF-8");
        resp.setContentType("text/html");
        req.setCharacterEncoding("utf-8");
        String param1 = req.getParameter("id");
        PrintWriter out = resp.getWriter();
        List<Order> list = null;
        if (param1 == null || param1 ==""){
            String query = "select from " + Order.class.getName();
            try {
                list = (List<Order>)manager.newQuery(query).execute();
            } catch(JDOObjectNotFoundException e){}
        } else {
            try {
                Order data = (Order)manager.getObjectById(Order.class,Long.parseLong(param1));
                list = new ArrayList();
                list.add(data);
            } catch(JDOObjectNotFoundException e){}
        }
        String res = "[";
        if (list != null){
            for(Order data:list){
                res += "{id:" + data.getId() + "',clothes:'" +
                    data.getClothes() + "'},";
            }
        }
        res += "]";
        out.println(res);
        manager.close();
    }
}
