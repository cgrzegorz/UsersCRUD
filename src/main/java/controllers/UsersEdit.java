package controllers;

import Dao.UserDao;
import models.User;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@WebServlet(name = "UsersEdit", urlPatterns = {"/users/edit"})
public class UsersEdit extends HttpServlet {
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {

        int id = Integer.parseInt(request.getParameter("id"));
        User user = new UserDao().read(id);
        request.setAttribute("user", user);

        getServletContext().getRequestDispatcher("/users/edit.jsp")
                .forward(request, response);
    }

    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        String userName = req.getParameter("userName");
        String email = req.getParameter("email");
        String password = req.getParameter("password");
        int id = Integer.parseInt(req.getParameter("id"));


        User user = new User();
        user.setUserName(userName);
        user.setEmail(email);
        user.setPassword(password);
        user.setId(id);
        UserDao userDao = new UserDao();
        System.out.println(user);
        userDao.update(user);
        resp.sendRedirect(req.getContextPath() + "/users/list");
    }
}