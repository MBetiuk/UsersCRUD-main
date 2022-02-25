package pl.coderslab.user;

import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.annotation.*;
import java.io.IOException;

@WebServlet("/user/show")
public class UserShow extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        response.setCharacterEncoding("UTF-8");
        request.setCharacterEncoding("UTF-8");


        String idString = request.getParameter("id");
        int id= Integer.parseInt(idString);
        UserDao userDao = new UserDao();
        User readUser = userDao.read(id);

        request.setAttribute("readUser",readUser );

getServletContext().getRequestDispatcher("/users/show.jsp").forward(request,response);

    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
    }
}

// TODO: 25/02/2022 - Strona ma być dostępna pod adresem /user/show. Po zatwierdzeniu ma nastąpić przekierowanie do adresu /user/list.