package pl.coderslab.user;

import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.annotation.*;
import java.io.IOException;

@WebServlet("/user/edit")
public class UserEdit extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        response.setCharacterEncoding("UTF-8");
        request.setCharacterEncoding("UTF-8");
        String id = request.getParameter("id");
        Cookie cookie = new Cookie("id", id);
        response.addCookie(cookie);
        UserDao userDao = new UserDao();
        User read = userDao.read(Integer.parseInt(id));
        request.setAttribute("user", read);
        getServletContext().getRequestDispatcher("/users/edit.jsp")
                .forward(request, response);
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        response.setCharacterEncoding("UTF-8");
        request.setCharacterEncoding("UTF-8");
        User user = new User();
        user.setId(Integer.parseInt(request.getParameter("id")));
        user.setUserName(request.getParameter("name"));
        user.setEmail(request.getParameter("email"));
        user.setPassword(request.getParameter("password"));
        UserDao userDao = new UserDao();
        userDao.update(user);
        response.sendRedirect("/user/list");
    }
}

// TODO: 25/02/2022 - Strona ma być dostępna pod adresem /user/edit. Po zatwierdzeniu ma nastąpić przekierowanie do adresu /user/list.