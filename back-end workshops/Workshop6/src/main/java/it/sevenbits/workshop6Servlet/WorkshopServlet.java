package it.sevenbits.workshop6Servlet;

import it.sevenbits.workshop6Servlet.Repository.TaskRepository;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.Set;

public class WorkshopServlet extends HttpServlet { // /tasks

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        TaskRepository repository = TaskRepository.getInstance();
        StringBuilder sb = new StringBuilder();
        sb.append("[\n");
        Set<Integer> keys = repository.getIdList();
        for(Integer key : keys) {
            sb.append(String.format("  {\n    \"id\": %d,\n    \"name\": \"%s\"\n  }, \n",
                    key,repository.get(key)));
        }
        sb.deleteCharAt(sb.lastIndexOf(","));
        sb.append("]");
        response.setContentType("application/json");
        response.setCharacterEncoding("UTF-8");
        response.setStatus(200);

        response.getWriter().write(sb.toString());
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        TaskRepository repository = TaskRepository.getInstance();
        int id = repository.add(request.getParameter("name"));
        response.setContentType("application/json");
        response.setCharacterEncoding("UTF-8");
        response.setStatus(201);
        response.addHeader("Location",String.format("/item?id=%d",id));

        response.getWriter().write(String.format("{\n    \"id\": %d,\n    \"name\": %s\n}",
                id,repository.get(id)));

    }
}
