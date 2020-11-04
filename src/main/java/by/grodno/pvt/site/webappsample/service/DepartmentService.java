package by.grodno.pvt.site.webappsample.service;

import java.sql.*;
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

    public List<Department> getDepartments() {
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

    public List<User> getUserfDep() {
        return this.userArrayList;
    }

    public void delList() {
        this.userArrayList.clear();
    }

    public List<Department> getDepUser(String parameter) {
        List<Department> departmentsArrayList = new ArrayList<Department>();
        delList();
        try (Connection conn = DBUtils.getConnetion(); PreparedStatement stmt = conn.prepareStatement(SQL.SELECT_ALL_DEPTNUM)) {
            int number = Integer.parseInt(parameter);
            stmt.setInt(1, number);
            ResultSet queryResaltSet = stmt.executeQuery();
            while (queryResaltSet.next()) {
                User user = ToUser(queryResaltSet);
                this.userArrayList.add(user);
                Department department = ToDepartment(queryResaltSet);
                departmentsArrayList.add(department);
            }
            queryResaltSet.close();
        } catch (Exception e) {
            LOGGER.error("Something went wrong...", e);
        }
        return departmentsArrayList;
    }

    private Department ToDepartment(ResultSet queryResaltSet) throws SQLException {
        Integer id = queryResaltSet.getInt(8);
        String nameDept = queryResaltSet.getString(9);
        Department department = new Department(id, nameDept);
        return department;
    }

    private User ToUser(ResultSet queryResaltSet) throws SQLException {
        Integer id = queryResaltSet.getInt(1);
        String fName = queryResaltSet.getString(2);
        String lName = queryResaltSet.getString(3);
        Double sal = queryResaltSet.getDouble(4);
        Date date = queryResaltSet.getTimestamp(5);
        Boolean male = queryResaltSet.getBoolean(6);
        Integer depNumber = queryResaltSet.getInt(7);
        String nameDept = queryResaltSet.getString(9);
        User user = new User(id, fName, lName, date, male, sal, depNumber, nameDept);
        return user;
    }

    public void addDepartment(Department newDepartment) {
        try (Connection conn = DBUtils.getConnetion();
             PreparedStatement stmt = conn.prepareStatement(SQL.INSERT_DEPT)) {
            stmt.setInt(1, newDepartment.getDepNumber());
            stmt.setString(2, newDepartment.getNameDept());
            stmt.executeUpdate();
        } catch (Exception e) {
            LOGGER.error("Something went wrong...", e);
        }
    }
}
