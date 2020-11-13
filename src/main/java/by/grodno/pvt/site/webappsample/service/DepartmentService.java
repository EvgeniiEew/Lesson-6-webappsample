package by.grodno.pvt.site.webappsample.service;

import java.sql.*;
import java.util.*;
import java.util.Date;

import static by.grodno.pvt.site.webappsample.service.UserService.LOGGER;

public class DepartmentService {
    private static DepartmentService departmentService;

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

    public List<UserDep> getDepUser(String parameter) {
        List<UserDep> departmentsUserArrayList = new ArrayList<UserDep>();
        try (Connection conn = DBUtils.getConnetion(); PreparedStatement stmt = conn.prepareStatement(SQL.SELECT_ALL_DEPTNUM)) {
            int number = Integer.parseInt(parameter);
            stmt.setInt(1, number);
            ResultSet queryResaltSet = stmt.executeQuery();
            while (queryResaltSet.next()) {
                UserDep userDep = retrieveDepUser(queryResaltSet);
                departmentsUserArrayList.add(userDep);
            }
            queryResaltSet.close();
        } catch (Exception e) {
            LOGGER.error("Something went wrong...", e);
        }
        return departmentsUserArrayList;
    }

    private UserDep retrieveDepUser(ResultSet queryResaltSet) throws SQLException {
        Integer idUser = queryResaltSet.getInt(1);
        String fName = queryResaltSet.getString(2);
        String lName = queryResaltSet.getString(3);
        Double salary = queryResaltSet.getDouble(4);
        Date date = queryResaltSet.getTimestamp(5);
        Boolean male = queryResaltSet.getBoolean(6);
        Integer depNumber = queryResaltSet.getInt(7);
        Integer idDept = queryResaltSet.getInt(8);
        String nameDept = queryResaltSet.getString(9);
        UserDep userDep = new UserDep(idUser, fName, lName, salary, date, male, depNumber, idDept, nameDept);
        return userDep;
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

    public Department checkingDepartmentPresence(String nameDep) {

        List<Department> listDepartment = getDepartments();
        for (Department department : listDepartment) {
            if (department.getNameDept().equals(nameDep)) {
                return department;
            }
        }
        try (Connection conn = DBUtils.getConnetion();
             PreparedStatement stmt = conn.prepareStatement(SQL.INSERT_DEPT, Statement.RETURN_GENERATED_KEYS)) {
            ResultSet generatedKeys = stmt.getGeneratedKeys();
            stmt.setString(2, nameDep);
            stmt.executeUpdate();
            generatedKeys.next();
            LOGGER.info("Dept created with id: " + generatedKeys.getLong(1));
        } catch (Exception e) {
            LOGGER.error("Something went wrong...", e);
        }
        return this.getDepByName(nameDep);
    }
    // todo fix
    public Department getDepByName(String nameDep) {

        try (Connection conn = DBUtils.getConnetion(); PreparedStatement
                stmt = conn.prepareStatement(SQL.SELECT_DEPARTMENT_BY_NAME)) {
            stmt.setString(1, nameDep);
            ResultSet queryResaltSet = stmt.executeQuery();
          //  Integer idDep = queryResaltSet.getInt(1);
           // String depName = queryResaltSet.getString(2);
            Department department  = new Department(queryResaltSet.getInt(1),queryResaltSet.getString(2));
            return department;
        } catch (Exception e) {
            LOGGER.error("Something went wrong...", e);
        }
        return  new Department();
    }
}
