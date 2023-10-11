package controllers;

import Dao.UserDao;


import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;


@WebServlet(name = "UsersDelete", urlPatterns = {"/users/delete"})
public class UsersDelete extends HttpServlet {
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        int id = Integer.parseInt(request.getParameter("id"));

        UserDao userDao = new UserDao();

        userDao.delete(id);
        response.sendRedirect(request.getContextPath() + "/users/list");

    }
}
