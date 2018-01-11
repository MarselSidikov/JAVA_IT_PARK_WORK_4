package ru.itpark.servlets.simple;

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
import java.io.PrintWriter;
import java.util.List;

public class UsersServlet extends HttpServlet {

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

        resp.setContentType("text/html");
        resp.setCharacterEncoding("UTF-8");
        PrintWriter writer = resp.getWriter();

        writer.write("<table>");
        writer.write("<tr>");
        writer.write("<th>id</th>");
        writer.write("<th>name</th>");
        writer.write("<th>citizen</th>");
        writer.write("</tr>");

        List<User> users = usersRepository.findAll();
        for (User user : users) {
            writer.write("<tr>");
            writer.write("<td>" + user.getId() + "</td>");
            writer.write("<td>" + user.getName() + "</td>");
            writer.write("<td>" + user.getCitizen() + "</td>");
            writer.write("</tr>");
        }
        writer.write("</table>");

    }
}
