package ru.itpark.servlets;

import ru.itpark.models.User;
import ru.itpark.repository.UsersRepository;
import ru.itpark.repository.UsersRepositoryEntityManagerImpl;

import javax.persistence.EntityManager;
import javax.persistence.Persistence;
import javax.servlet.ServletConfig;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.List;

public class CarsServlet extends HttpServlet {

    private UsersRepository usersRepository;

    @Override
    public void init(ServletConfig config) throws ServletException {
        usersRepository = (UsersRepository)config.getServletContext().getAttribute("usersRepository");
    }

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {

        long userId = Long.parseLong(req.getParameter("id"));
        User user = usersRepository.find(userId);

        req.setAttribute("cars", user.getCars());

        req.getRequestDispatcher("/jsp/cars.jsp").forward(req, resp);
    }
}
