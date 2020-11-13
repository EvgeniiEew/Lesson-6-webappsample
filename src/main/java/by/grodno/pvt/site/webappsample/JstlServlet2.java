package by.grodno.pvt.site.webappsample;

import java.io.IOException;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import by.grodno.pvt.site.webappsample.service.Department;
import by.grodno.pvt.site.webappsample.service.DepartmentService;
import by.grodno.pvt.site.webappsample.service.User;
import by.grodno.pvt.site.webappsample.service.UserService;

import static by.grodno.pvt.site.webappsample.service.UserService.LOGGER;

public class JstlServlet2 extends HttpServlet {

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        try {
            Department department = DepartmentService.getDepService().checkingDepartmentPresence(req.getParameter("nameDept"));
            User user = new User(null,
                    req.getParameter("firstName"),
                    req.getParameter("lastName"),
                    new SimpleDateFormat("yyy-MM-dd")
                            .parse(req.getParameter("birthdate")),
                    Boolean.valueOf(req.getParameter("male")),
                    Double.valueOf(req.getParameter("salary")),
                    department.getDepNumber(),
                    department.getNameDept());
                   // Integer.valueOf(req.getParameter("depNumber")),
                  //  req.getParameter("nameDept"));

            UserService.getService().addUser(user);

        } catch (ParseException e) {
            LOGGER.error("Something went wrong...", e);
        }
        resp.sendRedirect("/webappsample/jstl1");
    }

}