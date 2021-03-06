package by.grodno.pvt.site.webappsample;

import java.io.IOException;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import by.grodno.pvt.site.webappsample.service.Department;
import by.grodno.pvt.site.webappsample.service.DepartmentService;
import by.grodno.pvt.site.webappsample.service.User;
import by.grodno.pvt.site.webappsample.service.UserService;

public class JstlServlet1 extends HttpServlet {

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {

        List<User> users = UserService.getService().getUsers();
        List<Department> departments = DepartmentService.getDepService().getDepartments();
        req.setAttribute("users", users);
        req.setAttribute("departments", departments);
        getServletContext().getRequestDispatcher("/jstl1.jsp").forward(req, resp);
    }

}
