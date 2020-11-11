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
      //  List<Department> departments = DepartmentService.getDepService().getDepUser(parameter);
        List<UserDep> userDeps = DepartmentService.getDepService().getDepUser(parameter);
        req.setAttribute("userDeps", userDeps);
      //  req.setAttribute("departments", departments);
        getServletContext().getRequestDispatcher("/jstl3.jsp").forward(req, resp);
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
