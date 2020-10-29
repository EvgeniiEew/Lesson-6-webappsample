package by.grodno.pvt.site.webappsample;

import by.grodno.pvt.site.webappsample.service.User;
import by.grodno.pvt.site.webappsample.service.UserService;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.text.ParseException;
import java.text.SimpleDateFormat;

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
            User newUser = new User(null,
                    req.getParameter("firstName"),
                    req.getParameter("lastName"),
                    new SimpleDateFormat("yyy-MM-dd").parse(req.getParameter("birthdate")),
                    Boolean.valueOf(req.getParameter("male")),
                    Double.valueOf(req.getParameter("salary"))
            );
            UserService.getService().updateUser(newUser, this.userIdSub);
        } catch (ParseException e) {
            e.printStackTrace();
        }
        resp.sendRedirect("/webappsample/jstl1");
    }
}


