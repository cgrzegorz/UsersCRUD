package controllers;

import Dao.UserDao;
import models.User;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@WebServlet(name = "UsersAdd", urlPatterns = {"/users/add"})
public class UsersAdd extends HttpServlet {
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        getServletContext().getRequestDispatcher("/users/add.jsp")
                .forward(request, response);
    }

    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        String userName = req.getParameter("userName");
        String email = req.getParameter("email");
        String password = req.getParameter("password");

        User user = new User();
        user.setUserName(userName);
        user.setEmail(email);
        user.setPassword(password);
        UserDao userDao = new UserDao();
        userDao.create(user);
        resp.sendRedirect(req.getContextPath() + "/users/list");
    }
}
