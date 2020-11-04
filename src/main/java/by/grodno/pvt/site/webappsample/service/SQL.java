package by.grodno.pvt.site.webappsample.service;

public class SQL {

    public static final String SELECT_ALL = "select *  from testtable a left join  dept b on a.dept_num = b.id order by a.id";
    public static final String DELETE_BY_ID = "delete from public.testtable where id = ?";
    public static final String INSERT = "INSERT INTO public.testTable "
            + "(empl_name, empl_last_name, salary, birthdate,  male, dept_num) VALUES (?,?,?,?,?,?)";
    public static final String UPDATE_BY_ID = "UPDATE public.testTable SET " +
            "empl_name = ? , empl_last_name = ? , salary = ? ," +
            " birthdate = ? , male = ? , dept_num = ? " + " WHERE id = ?";

    public static final String SELECT_ALL_Dep = "select *  from dept  order by id";
    public static final String SELECT_ALL_DEPTNUM = "select *  from testtable a right join  dept b on a.dept_num = b.id  where b.id = ?";
    public static final String INSERT_DEPT ="INSERT INTO public.dept (id, dept_name) VALUES (?,?) ";
}
