package pl.coderslab.user;

import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.annotation.*;
import java.io.IOException;

@WebServlet("/user/delete")
public class UserDelete extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        response.setCharacterEncoding("UTF-8");
        request.setCharacterEncoding("UTF-8");
        String id = request.getParameter("id");
        UserDao userDao = new UserDao();
        userDao.delete(Integer.parseInt(id));
        response.sendRedirect("/user/list");
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

    }
}

// TODO: 25/02/2022  - Strona ma być dostępna pod adresem /user/delete. Po zatwierdzeniu ma nastąpić przekierowanie do adresu /user/list 