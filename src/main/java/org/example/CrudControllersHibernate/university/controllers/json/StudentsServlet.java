package org.example.CrudControllersHibernate.university.controllers.json;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.databind.PropertyNamingStrategies;
import org.example.CrudControllersHibernate.university.dao.entity.Student;
import org.example.CrudControllersHibernate.university.service.StudentsService;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;

@WebServlet(name = "StudentsServlet", value = "/json/students")
public class StudentsServlet extends HttpServlet {
    private StudentsService service;
    private ObjectMapper mapper;

    public StudentsServlet() {
        service = StudentsService.getInstance();
        mapper = new ObjectMapper().setPropertyNamingStrategy(PropertyNamingStrategies.SNAKE_CASE);
                                  // .setSerializationInclusion(JsonInclude.Include.NON_NULL);
    }

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        request.setCharacterEncoding("UTF-8");
        response.setContentType("application/json; charset=utf-8");
        PrintWriter writer = response.getWriter();
        writer.println(mapper.writeValueAsString(service.readAll()));

    }

    @Override
    //STUDENT WITHOUT ID
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        request.setCharacterEncoding("UTF-8");
        response.setContentType("application/json; charset=utf-8");

        service.create(mapper.readValue(request.getInputStream(), Student.class));
    }

    @Override
    //STUDENT WITH ID
    protected void doPut(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        req.setCharacterEncoding("UTF-8");
        resp.setContentType("application/json; charset=utf-8");

        service.update(mapper.readValue(req.getInputStream(), Student.class));
    }


    @Override
    //STUDENT WITH ID
    protected void doDelete(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        req.setCharacterEncoding("UTF-8");
        resp.setContentType("application/json; charset=utf-8");

        service.delete(mapper.readValue(req.getInputStream(), Student.class));
    }
}
