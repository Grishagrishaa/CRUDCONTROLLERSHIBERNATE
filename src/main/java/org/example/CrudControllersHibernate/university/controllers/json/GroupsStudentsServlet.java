package org.example.CrudControllersHibernate.university.controllers.json;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.databind.PropertyNamingStrategies;
import org.example.CrudControllersHibernate.university.dao.entity.Group;
import org.example.CrudControllersHibernate.university.service.GroupsStudentsService;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;

@WebServlet(name = "GroupsStudentsServlet", urlPatterns = "/json/groups/manage")
public class GroupsStudentsServlet extends HttpServlet {
    private GroupsStudentsService service;
    private ObjectMapper mapper;
    public GroupsStudentsServlet(){
        service = GroupsStudentsService.getInstance();
        mapper = new ObjectMapper().setPropertyNamingStrategy(PropertyNamingStrategies.SNAKE_CASE);
        // .setSerializationInclusion(JsonInclude.Include.NON_NULL);
    }
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        req.setCharacterEncoding("UTF-8");
        resp.setContentType("application/json; charset=utf-8");
        PrintWriter writer = resp.getWriter();


        writer.println(mapper.writeValueAsString(service.readAll()));
    }

    @Override
    protected void doPut(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        req.setCharacterEncoding("UTF-8");
        resp.setContentType("application/json; charset=utf-8");
        service.update(mapper.readValue(req.getInputStream(), Group.class));
    }

    @Override
    protected void doDelete(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        req.setCharacterEncoding("UTF-8");
        resp.setContentType("application/json; charset=utf-8");
        service.delete(mapper.readValue(req.getInputStream(), Group.class));
    }
}
