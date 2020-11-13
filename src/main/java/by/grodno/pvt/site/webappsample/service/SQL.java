package by.grodno.pvt.site.webappsample.service;

public class SQL {

    public static final String SELECT_ALL = "select *  from users u left join  dept d on u.dept_num = d.id order by u.id";
    public static final String DELETE_BY_ID = "delete from public.users where id = ?";
    public static final String INSERT = "INSERT INTO public.users "
            + "(empl_name, empl_last_name, salary, birthdate,  male, dept_num) VALUES (?,?,?,?,?,?)";
    public static final String UPDATE_BY_ID = "UPDATE public.users SET " +
            "empl_name = ? , empl_last_name = ? , salary = ? ," +
            " birthdate = ? , male = ? , dept_num = ? " + " WHERE id = ?";

    public static final String SELECT_ALL_Dep = "select *  from dept  order by id";
    public static final String SELECT_ALL_DEPTNUM = "select *  from users u right join  dept b on u.dept_num = b.id  where b.id = ?";
    public static final String INSERT_DEPT ="INSERT INTO public.dept (id, dept_name) VALUES (?,?) ";
    public static final String  SELECT_DEPARTMENT_BY_NAME ="Select * from dept where dept_name = ?";
}
