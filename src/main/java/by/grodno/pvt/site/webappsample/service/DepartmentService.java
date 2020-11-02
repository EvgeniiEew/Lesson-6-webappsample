package by.grodno.pvt.site.webappsample.service;

import javax.naming.event.ObjectChangeListener;
import java.sql.*;
import java.text.SimpleDateFormat;
import java.util.*;
import java.util.Date;

import static by.grodno.pvt.site.webappsample.service.UserService.LOGGER;

public class DepartmentService {
    private static DepartmentService departmentService;
    List<User> userArrayList = new ArrayList<User>();
    private DepartmentService() {
    }

    public static DepartmentService getDepService() {
        if (departmentService == null) {
            departmentService = new DepartmentService();
        }
        return departmentService;
    }

    public List<Department> getDepartment() {
        List<Department> result = new ArrayList<Department>();
        try (Connection conn = DBUtils.getConnetion(); Statement stmt = conn.createStatement()) {
            ResultSet rs = stmt.executeQuery(SQL.SELECT_ALL_Dep);

            while (rs.next()) {

                Department department = mapRawToDepartment(rs);

                result.add(department);
            }

            rs.close();
        } catch (Exception e) {
            LOGGER.error("Something went wrong...", e);
        }

        return result;
    }

    private Department mapRawToDepartment(ResultSet rs) throws SQLException {
        Integer id = rs.getInt(1);
        String nameDept = rs.getString(2);
        Department department = new Department(id, nameDept);
        return department;
    }
    public List<User>  getUserfDep(){
        return this.userArrayList;
    }
    public void delList(){
        this.userArrayList.clear();
    }
    public List<Department>  getDepUser(String parameter) {
        List<Department> departmentsArrayList = new ArrayList<Department>();
        delList();
        try (Connection conn = DBUtils.getConnetion(); Statement stmt = conn.createStatement()) {
            ResultSet SelAll = stmt.executeQuery("select *  from testtable a right join  dept b on a.dept_num = b.id  where b.id = ".concat(parameter));
            while (SelAll.next()) {
                User user = ToUser(SelAll);
                this.userArrayList.add(user);
                Department department = ToDepartment(SelAll);
                departmentsArrayList.add(department);
            }
            SelAll.close();
        } catch (Exception e) {
            LOGGER.error("Something went wrong...", e);
        }
        return departmentsArrayList;
    }
    private Department ToDepartment(ResultSet SelAll) throws SQLException {
        Integer id = SelAll.getInt(8);
        String nameDept = SelAll.getString(9);
        Department department = new Department(id, nameDept);
        return department;
    }
    private User ToUser(ResultSet SelAll) throws SQLException {
        Integer id = SelAll.getInt(1);
        String fName = SelAll.getString(2);
        String lName = SelAll.getString(3);
        Double sal = SelAll.getDouble(4);
        Date date = SelAll.getTimestamp(5);
        Boolean male = SelAll.getBoolean(6);
        Integer depNumber = SelAll.getInt(7);
        String nameDept = SelAll.getString(9);
        User user = new User(id, fName, lName, date, male, sal, depNumber, nameDept);
        return user;
    }
}
