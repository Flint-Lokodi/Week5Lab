package servlets;

import java.io.IOException;
import java.util.ArrayList;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import models.AccountService;
import models.User;

/**
 *
 * @author 608787
 */
public class LoginServlet extends HttpServlet {

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException{
        String logoutSucess = "You have sucessfully logged out.";
        
        HttpSession session = request.getSession();
        
        String logParam = request.getParameter("logout");
        if (logParam != null) {
              request.setAttribute("message", logoutSucess);
              session.invalidate(); 
              session = request.getSession();
        }
        String username = (String) session.getAttribute("username");
        if (username != null){                            
            response.sendRedirect("home");
        }
        else{
        getServletContext().getRequestDispatcher("/WEB-INF/login.jsp")
                .forward(request, response);
        }
    }
    
    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException{
        String username = request.getParameter("username");
        String password = request.getParameter("password");
        String authFailed = "Failed Authentication.";
        String empty = "Username or Password is empty.";
        
        if (username == null || username.equals("") || password == null || password.equals("")) {
            request.setAttribute("username", username);
            request.setAttribute("password", password);
            request.setAttribute("message", empty);
            
            getServletContext().getRequestDispatcher("/WEB-INF/login.jsp")
                    .forward(request, response);           
        }
        
        AccountService accServ = new AccountService();
        User user = accServ.login(username, password);
        
        if (user == null) {
            request.setAttribute("username", username);
            request.setAttribute("password", password);
            request.setAttribute("message", authFailed);
            
            getServletContext().getRequestDispatcher("/WEB-INF/login.jsp").forward(request, response);
        } else {
            HttpSession session = request.getSession();
            session.setAttribute("username", user.getUsername());
            response.sendRedirect("home");
        }
        
        
        
    }
}
