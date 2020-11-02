package by.grodno.pvt.site.webappsample;

import by.grodno.pvt.site.webappsample.service.Department;
import by.grodno.pvt.site.webappsample.service.DepartmentService;
import by.grodno.pvt.site.webappsample.service.User;
import by.grodno.pvt.site.webappsample.service.UserService;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.List;

public class JstlServlet5Dept  extends HttpServlet {

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        String parameter = req.getParameter("number");
        int index = Integer.parseInt(parameter);

        List<User> users = DepartmentService.getDepService().getUserfDep();
        List<Department> departments = DepartmentService.getDepService().getDepUser(parameter);
        req.setAttribute("users", users);
        req.setAttribute("departments", departments);
        getServletContext().getRequestDispatcher("/jstl3.jsp").forward(req, resp);
    }
}
