package by.grodno.pvt.site.webappsample;

import by.grodno.pvt.site.webappsample.service.DepartmentService;
import by.grodno.pvt.site.webappsample.service.User;
import by.grodno.pvt.site.webappsample.service.UserService;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;

import static by.grodno.pvt.site.webappsample.service.UserService.LOGGER;

public class JstlServlet4Edit extends HttpServlet {
    private int currentUserIndex;
    private int userIdSub;

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {

        String parameter = req.getParameter("number");
        int index = Integer.parseInt(parameter);
        this.currentUserIndex = index;
        User userForEdit = UserService.getService().getUsers().get(index);
        String numberUserFoSUBD = req.getParameter("k");
        int userId = Integer.parseInt(numberUserFoSUBD);
        this.userIdSub = userId;
        req.setAttribute("user", userForEdit);
        req.setAttribute("number", index);
        getServletContext().getRequestDispatcher("/jstl2.jsp").forward(req, resp);
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        try {
            ArrayList<String> depNumDepName = DepartmentService.getDepService().checkingDepartmentPresence(req.getParameter("nameDept"));
            User newUser = new User(this.userIdSub,
                    req.getParameter("firstName"),
                    req.getParameter("lastName"),
                    new SimpleDateFormat("yyy-MM-dd").parse(req.getParameter("birthdate")),
                    Boolean.valueOf(req.getParameter("male")),
                    Double.valueOf(req.getParameter("salary")),
//                    Integer.valueOf(req.getParameter("depNumber")),
//                    req.getParameter("nameDept"));
                    Integer.valueOf(depNumDepName.get(0)),
                    depNumDepName.get(1));
            UserService.getService().updateUser(newUser);
        } catch (ParseException e) {
            LOGGER.error("Something went wrong...", e);
        }
        resp.sendRedirect("/webappsample/jstl1");
    }
}


