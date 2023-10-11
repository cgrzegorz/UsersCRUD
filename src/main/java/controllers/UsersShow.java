package controllers;

import Dao.UserDao;
import utils.DbUtil;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.sql.Connection;
import java.sql.SQLException;

@WebServlet(name = "UsersShow", urlPatterns = {"/users/show"})
public class UsersShow extends HttpServlet {
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        UserDao userDao = new UserDao();
        int id = Integer.parseInt(request.getParameter("id"));
        request.setAttribute("user", userDao.read(id));
        getServletContext().getRequestDispatcher("/users/show.jsp")
                .forward(request, response);
    }
}
