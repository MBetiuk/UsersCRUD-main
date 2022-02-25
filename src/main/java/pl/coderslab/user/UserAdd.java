package pl.coderslab.user;

import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.annotation.*;
import java.io.IOException;

@WebServlet("/user/add")
public class UserAdd extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
      request.setCharacterEncoding("UTF-8");
      response.setCharacterEncoding("UTF-8");
       getServletContext().getRequestDispatcher("/users/add.jsp").forward(request,response);
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
    String userName = request.getParameter("username");
    String email = request.getParameter("email");
    String password = request.getParameter("password");
    User user = new User();
    user.setUserName(userName);
    user.setEmail(email);
    user.setPassword(password);
    UserDao userDao = new UserDao();
    request.setAttribute("userDao",userDao.create(user));
    response.sendRedirect("/user/list");

    }
}

// TODO: 25/02/2022 - Po zatwierdzeniu ma nastąpić przekierowanie do adresu /user/list.