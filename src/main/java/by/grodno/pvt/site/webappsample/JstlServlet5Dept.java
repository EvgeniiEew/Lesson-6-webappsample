package by.grodno.pvt.site.webappsample;

import by.grodno.pvt.site.webappsample.service.*;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.List;

public class JstlServlet5Dept extends HttpServlet {

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        String parameter = req.getParameter("number");
        //List<User> users = DepartmentService.getDepService().getUserfDep();
        List<User> users = UserService.getService().getUsers();
        List<Department> departments = DepartmentService.getDepService().getDepartments();
        req.setAttribute("users", users);
        req.setAttribute("departments", departments);
      //  List<Department> departments = DepartmentService.getDepService().getDepUser(parameter);
        List<UserDep> userDeps = DepartmentService.getDepService().getDepUser(parameter);
        req.setAttribute("userDeps", userDeps);
      //  req.setAttribute("departments", departments);
        getServletContext().getRequestDispatcher("/jstl1.jsp").include(req, resp);
//        jstl 3
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        Department newDepartment = new Department(
                Integer.valueOf(req.getParameter("depNumber")),
                req.getParameter("nameDept"));
        DepartmentService.getDepService().addDepartment(newDepartment);
        resp.sendRedirect("/webappsample/jstl1");
    }
}
