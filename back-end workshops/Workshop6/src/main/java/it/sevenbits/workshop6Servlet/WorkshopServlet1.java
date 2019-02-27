package it.sevenbits.workshop6Servlet;

import it.sevenbits.workshop6Servlet.Repository.TaskRepository;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.Set;

public class WorkshopServlet1 extends HttpServlet { // /tasks

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        TaskRepository repository = TaskRepository.getInstance();

        response.setContentType("application/json");
        response.setCharacterEncoding("UTF-8");

        int id = Integer.decode(request.getParameter("taskId"));
        if (repository.contains(id)) {
            response.setStatus(200);
            response.getWriter().write(String.format("{\n    \"id\": %d,\n    \"name\": %s\n}",
                    id, repository.get(id)));
        } else {
            response.setStatus(404); // спросить про description
        }
    }

    @Override
    protected void doDelete(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        TaskRepository repository = TaskRepository.getInstance();

        response.setContentType("application/json");
        response.setCharacterEncoding("UTF-8");

        int id = Integer.decode(request.getParameter("taskId"));
        if (repository.contains(id)) {
            String result = String.format("{\n    \"id\": %d,\n    \"name\": %s\n}",
                    id, repository.get(id));
            repository.delete(id);
            response.setStatus(200);
            response.getWriter().write(result);
        } else {
            response.setStatus(404); // спросить про description, путь и еррор
        }
    }
}
