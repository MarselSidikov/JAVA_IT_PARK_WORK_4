package ru.itpark.servlets;

import ru.itpark.models.User;
import ru.itpark.repository.UsersRepository;
import ru.itpark.repository.UsersRepositoryEntityManagerImpl;

import javax.persistence.EntityManager;
import javax.persistence.Persistence;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.List;

public class UsersJspServlet extends HttpServlet {

    private UsersRepository usersRepository;

    @Override
    public void init() throws ServletException {
        EntityManager entityManager =
                Persistence.createEntityManagerFactory("ru.itpark.persistence")
                        .createEntityManager();

        usersRepository = new UsersRepositoryEntityManagerImpl(entityManager);
    }

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        List<User> users = usersRepository.findAll();

        req.setAttribute("users", users);

        req.getRequestDispatcher("/jsp/users.jsp").forward(req, resp);
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        req.setCharacterEncoding("UTF-8");
        String name = req.getParameter("name");
        String citizen = req.getParameter("citizen");
        int age = Integer.parseInt(req.getParameter("age"));

        User user = User.builder()
                .name(name)
                .age(age)
                .citizen(citizen)
                .build();

        usersRepository.save(user);

        resp.sendRedirect("/users_as_jsp");
    }
}
